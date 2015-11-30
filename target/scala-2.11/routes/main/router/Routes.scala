
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/scala/activator-1.3.6-minimal/TODO-List/conf/routes
// @DATE:Mon Nov 30 10:19:00 CET 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_2: controllers.Application,
  // @LINE:14
  Assets_1: controllers.Assets,
  // @LINE:15
  WebJarAssets_0: controllers.WebJarAssets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_2: controllers.Application,
    // @LINE:14
    Assets_1: controllers.Assets,
    // @LINE:15
    WebJarAssets_0: controllers.WebJarAssets
  ) = this(errorHandler, Application_2, Assets_1, WebJarAssets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_2, Assets_1, WebJarAssets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks""", """controllers.Application.tasks"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addTask""", """controllers.Application.addTask(task:String, status:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """removeTask""", """controllers.Application.removeTask(identifier:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateTask""", """controllers.Application.updateTask(identifier:String, status:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """web/assets/$file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """webjars/$file<.+>""", """controllers.WebJarAssets.at(file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_2.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Application_tasks1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks")))
  )
  private[this] lazy val controllers_Application_tasks1_invoker = createInvoker(
    Application_2.tasks,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "tasks",
      Nil,
      "GET",
      """""",
      this.prefix + """tasks"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_addTask2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addTask")))
  )
  private[this] lazy val controllers_Application_addTask2_invoker = createInvoker(
    Application_2.addTask(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "addTask",
      Seq(classOf[String], classOf[String]),
      "POST",
      """""",
      this.prefix + """addTask"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_removeTask3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("removeTask")))
  )
  private[this] lazy val controllers_Application_removeTask3_invoker = createInvoker(
    Application_2.removeTask(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "removeTask",
      Seq(classOf[String]),
      "POST",
      """""",
      this.prefix + """removeTask"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_updateTask4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateTask")))
  )
  private[this] lazy val controllers_Application_updateTask4_invoker = createInvoker(
    Application_2.updateTask(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "updateTask",
      Seq(classOf[String], classOf[String]),
      "POST",
      """""",
      this.prefix + """updateTask"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("web/assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """web/assets/$file<.+>"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_WebJarAssets_at6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("webjars/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_WebJarAssets_at6_invoker = createInvoker(
    WebJarAssets_0.at(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebJarAssets",
      "at",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """webjars/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_2.index)
      }
  
    // @LINE:8
    case controllers_Application_tasks1_route(params) =>
      call { 
        controllers_Application_tasks1_invoker.call(Application_2.tasks)
      }
  
    // @LINE:9
    case controllers_Application_addTask2_route(params) =>
      call(params.fromQuery[String]("task", None), params.fromQuery[String]("status", None)) { (task, status) =>
        controllers_Application_addTask2_invoker.call(Application_2.addTask(task, status))
      }
  
    // @LINE:10
    case controllers_Application_removeTask3_route(params) =>
      call(params.fromQuery[String]("identifier", None)) { (identifier) =>
        controllers_Application_removeTask3_invoker.call(Application_2.removeTask(identifier))
      }
  
    // @LINE:11
    case controllers_Application_updateTask4_route(params) =>
      call(params.fromQuery[String]("identifier", None), params.fromQuery[String]("status", None)) { (identifier, status) =>
        controllers_Application_updateTask4_invoker.call(Application_2.updateTask(identifier, status))
      }
  
    // @LINE:14
    case controllers_Assets_versioned5_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned5_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:15
    case controllers_WebJarAssets_at6_route(params) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_WebJarAssets_at6_invoker.call(WebJarAssets_0.at(file))
      }
  }
}