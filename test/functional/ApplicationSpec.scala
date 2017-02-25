package functional;
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.OneAppPerTest
import play.api.test.Helpers._
import play.api.test.FakeRequest
import akka.stream.Materializer
import org.scalatestplus.play.OneAppPerSuite


class ApplicationSpec extends PlaySpec with OneAppPerSuite {
  
  "Application" should {

    "send 404 on a bad request" in  {
      route(app, FakeRequest(GET, "/boum")).map(status(_)) mustBe Some(NOT_FOUND)
    }

    "GreetingsController" should { 
      
      "provide a GET greetings resource" in {        
        status(route(app, FakeRequest(GET, "/greetings")).get) mustBe OK  
      }
      
    }  
    
  }
}