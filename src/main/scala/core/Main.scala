package core

import akka.actor.ActorSystem

object Main {
  def main(args: Array[String]): Unit = {
    val dir = "./test_project"
    val routes = ResourceCollector.generateMailApiRoutes(dir)
    routes.foreach(println)
  }
}
