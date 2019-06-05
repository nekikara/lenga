package core

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object Main {
  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem("test-project")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher
    val dir = "./test_project"
    val routes = ResourceCollector.generateMailApiRoutes(dir)
    routes.foreach(println)
  }
}
