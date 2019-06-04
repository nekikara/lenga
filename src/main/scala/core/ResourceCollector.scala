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
        val fileName = f.getName.stripPrefix(mailDirName)
        val parentPath = s"${f.getParent.stripPrefix(mailDirName)}"
        if (fileName.startsWith("_index")) {
          parentPath
        } else {
          if (parentPath.isEmpty) {
            s"/${f.getName.split("\\.").head}"
          } else {
            s"$parentPath${f.getName.split("\\.").head}"
          }
        }
      })
      .distinct
  }
}
