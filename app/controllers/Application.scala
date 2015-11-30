package controllers

import java.util.UUID

import javax.inject.Inject

import scala.concurrent.Future

import play.api.Logger
import play.api.mvc.{ Action, Controller }
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.functional.syntax._
import play.api.libs.json._

import scala.util.Success

// Reactive Mongo imports
import reactivemongo.api.Cursor

import play.modules.reactivemongo.{ // ReactiveMongo Play2 plugin
MongoController,
ReactiveMongoApi,
ReactiveMongoComponents
}

// BSON-JSON conversions/collection
import play.modules.reactivemongo.json._
import play.modules.reactivemongo.json.collection._

class Application @Inject() (val reactiveMongoApi:ReactiveMongoApi) extends Controller with MongoController with ReactiveMongoComponents {

  def collection: JSONCollection = db.collection[JSONCollection]("tasks")

  // serves the web page
  def index = Action {
    Ok(views.html.kanban())
  }

  // The json keys. The 'id' field was added as without it we would get a warning like this:
  // Warning: Each child in an array or iterator should have a unique "key" prop. Check the render method of CommentList. See https://fb.me/react-warning-keys for more information.
  val JSON_KEY_TASK = "task"
  val JSON_KEY_STATUS = "status"
  val JSON_KEY_ID = "_id"
  
  import controllers.Tarea._

  // Returns the tasks list
  def tasks = Action.async {
    val cursor:Cursor[Tarea] = collection.find(Json.obj()).cursor[Tarea]
    val futureTaskList:Future[List[Tarea]]=cursor.collect[List]()
    futureTaskList.map(tasks=>Ok(Json.toJson(tasks)))
  }

  // Adds a new task to the list and returns it
  def addTask(task: String,status:String) = Action.async{
    val newTask = Json.obj(
      JSON_KEY_ID -> UUID.randomUUID().toString,
      JSON_KEY_TASK -> task,
	  JSON_KEY_STATUS ->status)
    collection.insert(newTask).map(lastError=>Ok("MongoLastError: %s" .format(lastError)))
  }


  def removeTask(identifier:String) =Action.async{
    val selector=Json.obj(JSON_KEY_ID->identifier)
    collection.remove(selector).map(lastError=>Ok("MongoLastError %s" .format(lastError)))
  }

  def updateTask(identifier:String,status:String) =Action.async{
    val selector=Json.obj(JSON_KEY_ID->identifier)
    val modifier=Json.obj("$set" -> Json.obj(JSON_KEY_STATUS->status))
    collection.update(selector,modifier).map(lastError=>Ok("MongoLastError %s" .format(lastError)))
  }
}

case class Tarea(
                _id:String,
                task:String,
                status:String
                )

object Tarea {

  import play.api.libs.json.Json
  import play.api.data._
  import play.api.data.Forms._

  implicit val tareaFormat:Format[Tarea] = Json.format[Tarea]
}