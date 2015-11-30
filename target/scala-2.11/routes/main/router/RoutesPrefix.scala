
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/scala/activator-1.3.6-minimal/TODO-List/conf/routes
// @DATE:Mon Nov 30 10:19:00 CET 2015


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
