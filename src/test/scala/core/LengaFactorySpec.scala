package core

import org.scalatest._

class LengaFactorySpec extends FlatSpec with Matchers {
  "The LengaFactorySpec" should "have configure" in {
    LengaFactory.configure() should be("configure")
  }
}
