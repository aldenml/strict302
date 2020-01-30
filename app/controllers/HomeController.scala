package controllers

import javax.inject._
import play.api.mvc._
import services.StrictWSClientProvider

@Singleton
object HomeController extends Controller {

  def test = Action {
    //val ws = wsProvider.wsClient

//    ws.url("https://www.test.com")
//      .get()
    Thread.sleep(2000)

    Ok("test")
  }

}
