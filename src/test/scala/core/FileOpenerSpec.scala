package core

import org.scalatest._

class FileOpenerSpec extends WordSpec with Matchers {
  "The FileOpenerSpec" should {
    "return lines from a file path" in {
      FileOpener.readAll("./test_project/mails/test.html.lenga") shouldEqual List(
        "<h1>Lenga</h1>"
      )
    }
  }
}
