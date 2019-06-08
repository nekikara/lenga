package core

import scala.io.Source

object FileOpener {
  def readAll(path: String): List[String] = {
    val bufferedSource = Source.fromFile(path)
    try bufferedSource.getLines().toList
    finally bufferedSource.close()
  }
}
