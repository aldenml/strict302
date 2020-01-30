
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/aldenml/Development/strict302/conf/routes
// @DATE:Thu Jan 30 18:16:49 EST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
