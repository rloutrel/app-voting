import play.api.mvc.Controller
import play.api.mvc.Action


class HelloController extends Controller {
  
  def sayHello() = Action {
    Ok("hello")
  }
  
}