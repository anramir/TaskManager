
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/scala/activator-1.3.6-minimal/TODO-List/conf/routes
// @DATE:Mon Nov 30 10:19:00 CET 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:15
  class ReverseWebJarAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WebJarAssets.at",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "webjars/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "web/assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def addTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.addTask",
      """
        function(task,status) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addTask" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("task", task), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("status", status)])})
        }
      """
    )
  
    // @LINE:8
    def tasks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.tasks",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks"})
        }
      """
    )
  
    // @LINE:11
    def updateTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.updateTask",
      """
        function(identifier,status) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateTask" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("identifier", identifier), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("status", status)])})
        }
      """
    )
  
    // @LINE:10
    def removeTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.removeTask",
      """
        function(identifier) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "removeTask" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("identifier", identifier)])})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}