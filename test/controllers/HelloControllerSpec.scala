import scala.concurrent.Future

import org.scalatestplus.play._

import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._


class HelloControllerSpec extends PlaySpec with Results {
  
  "HelloController#sayHello" should {
    "should say hello" in {
      val helloController = new HelloController()
      val result: Future[Result] = helloController.sayHello().apply(FakeRequest()) 
      val bodyText: String = contentAsString(result)
      bodyText mustBe "hello"
    }
  }  
    
}