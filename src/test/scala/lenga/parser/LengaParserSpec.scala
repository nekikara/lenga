package lenga.parser

import org.scalatest._

class LengaParserSpec extends WordSpec with Matchers {
  "The LengaParser" when {
    "it contains only a text" should {
      "return the text" in {
        LengaParser.parse("hello") shouldEqual Seq("hello")
      }
    }

    "it contains a identifier" should {
      "return the identifier" in {
        val src = "{{ hello }}"
        LengaParser.parse(src) should be(Seq("hello"))
      }
    }
  }
}
