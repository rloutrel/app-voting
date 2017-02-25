package controllers

import scala.concurrent.Future
import org.scalatestplus.play._
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._


class GreetingsControllerSpec extends PlaySpec with Results {
  
  "HelloController#sayHello" should {
    
    "say hello" in {
      val helloController = new GreetingsController()
      
      val result: Future[Result] = helloController.sayHello().apply(FakeRequest()) 
      
      contentType(result) mustEqual Some("application/json")      
      (contentAsJson(result) \ "say").as[String] mustEqual "Hello"
    }
    
  }  
    
}