package core

import org.scalatest._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.server.Directives._

class RouteFactorySpec extends WordSpec with Matchers with ScalatestRouteTest {
  "The RouteFactorySpec" should {
    val routes = Array("/test", "/signup", "/password/reset")
    val testRoute = RouteFactory.mailRoutes(routes) { routeName =>
      get {
        complete(routeName)
      }
    }
    "return test for GET requests to the test path" in {
      Get("/test") ~> testRoute ~> check {
        responseAs[String] shouldEqual "/test"
      }
    }
    "return signup for GET requests to the signup path" in {
      Get("/signup") ~> testRoute ~> check {
        responseAs[String] shouldEqual "/signup"
      }
    }
    "return password/reset for GET requests to the password/reset path" in {
      Get("/password/reset") ~> testRoute ~> check {
        responseAs[String] shouldEqual "/password/reset"
      }
    }
  }
}
