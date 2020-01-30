package services

//import akka.stream.Materializer
import javax.inject.Inject
import javax.inject.Singleton
//import org.asynchttpclient.DefaultAsyncHttpClientConfig
import play.api.inject.ApplicationLifecycle
//import play.api.libs.ws.ahc.AhcConfigBuilder
//import play.api.libs.ws.ahc.AhcWSClient
//import play.api.libs.ws.ahc.AhcWSClientConfig

import scala.concurrent.Future

@Singleton
class StrictWSClientProvider @Inject()(
//  clientConfig: AhcWSClientConfig,
  lifecycle: ApplicationLifecycle
) {

  lazy val wsClient = {

//    val playConfig =
//      new AhcConfigBuilder(clientConfig).build()
//
//    val config = new DefaultAsyncHttpClientConfig.Builder(playConfig)
//      .setStrict302Handling(true)
//      .build()
//
//    val client = AhcWSClient(config)
//
//    lifecycle.addStopHook { () =>
//      Future.successful(client.close())
//    }
//
//    client
    null
  }
}
