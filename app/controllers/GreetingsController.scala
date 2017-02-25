package controllers

import play.api.mvc.Controller
import play.api.mvc.Action
import play.api.libs.json.Json


class GreetingsController extends Controller {
  
  def sayHello() = Action {
    Ok(Json.obj("say" -> "Hello"))
  }
  
}