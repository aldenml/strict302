package filters

import play.api.Logger
import play.api.mvc._
import play.api.mvc.Results.TooManyRequest

import scala.concurrent.Future
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.function.IntUnaryOperator

import play.api.Play.current

import scala.concurrent.Promise
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.Cookie

object MaxConnectionRedirectFilter extends Filter {

  private val MaxConnections = 20
  private val CookieName = "is_cool_LIV"

  def isSticky(request: RequestHeader): Boolean = {
    request.cookies.get(CookieName).isDefined
  }

  private val active = new AtomicInteger(0)

  def apply(nextFilter: RequestHeader => Future[Result])(requestHeader: RequestHeader): Future[Result] = {
    var redirect = false

    active.getAndUpdate(new IntUnaryOperator {
      override def applyAsInt(activeConnections: Int): Int =
        if (activeConnections < MaxConnections || isSticky(requestHeader)) {
          activeConnections + 1
        } else {
          redirect = true
          activeConnections
        }
    })

    if (redirect) {
      //Future.successful(Results.Redirect("https://www.google.com"))
      Future.successful(Results.InternalServerError)
    } else {
      nextFilter(requestHeader).map { result =>
        active.decrementAndGet()
        result
          .withCookies(Cookie(CookieName, "1", Some(60 * 60)))
      }
    }

  }
}
