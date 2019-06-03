package core

import java.io.File

object ResourceCollector {
  def generateMailApiRoutes(dir: String): Array[String] = {

    def getRecursiveListOfFiles(dir: File): Array[File] = {
      val files = dir.listFiles
      files ++ files.filter(_.isDirectory).flatMap(getRecursiveListOfFiles)
    }
    val rootDir = new File(dir)
    val files = getRecursiveListOfFiles(rootDir)

    val mailDirName = s"$dir/mails"
    files
      .filter(_.isFile)
      .map(f => {
        f.getName.stripPrefix(mailDirName)
      })
  }
}
