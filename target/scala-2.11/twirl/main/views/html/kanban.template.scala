
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object kanban_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class kanban extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>
<head>
    <script type='text/javascript' src='"""),_display_(/*4.42*/routes/*4.48*/.WebJarAssets.at(WebJarAssets.fullPath("react", "react.js"))),format.raw/*4.108*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*5.42*/routes/*5.48*/.WebJarAssets.at(WebJarAssets.locate("marked.js"))),format.raw/*5.98*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*6.42*/routes/*6.48*/.WebJarAssets.at(WebJarAssets.locate("jquery.js"))),format.raw/*6.98*/("""'></script>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*7.50*/routes/*7.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*7.97*/("""">
</head>
<body>
    <div id="content"></div>
    <script type='text/javascript' src='"""),_display_(/*11.42*/routes/*11.48*/.Assets.versioned("javascript/kanban.js")),format.raw/*11.89*/("""'></script>
</body>
</html>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object kanban extends kanban_Scope0.kanban
              /*
                  -- GENERATED --
                  DATE: Mon Nov 30 10:19:00 CET 2015
                  SOURCE: D:/scala/activator-1.3.6-minimal/TODO-List/app/views/kanban.scala.html
                  HASH: c9db79b982ef4a0f39d9f0cf6dda4d548d0ed7b1
                  MATRIX: 611->0|711->74|725->80|806->140|886->194|900->200|970->250|1050->304|1064->310|1134->360|1222->422|1236->428|1297->469|1416->561|1431->567|1493->608
                  LINES: 25->1|28->4|28->4|28->4|29->5|29->5|29->5|30->6|30->6|30->6|31->7|31->7|31->7|35->11|35->11|35->11
                  -- GENERATED --
              */
          