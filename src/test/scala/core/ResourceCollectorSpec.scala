package core

import org.scalatest._

class ResourceCollectorSpec extends FlatSpec with Matchers {
  "The ResourceCollector" should "have configure" in {
    val dir = "./test_project"
    val routes = Array("/test", "/signup", "/password/reset")
    ResourceCollector.generateMailApiRoutes(dir) should contain theSameElementsAs routes
  }
}
