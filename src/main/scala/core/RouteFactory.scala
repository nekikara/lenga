package core

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._

object RouteFactory {
  def mailRoutes(routesData: Array[String]): Route = {
    val routes = routesData.map(routeName => {
      val pathChunks = routeName.split("\\/").filter(!_.isEmpty)
      path(separateOnSlashes(pathChunks.mkString("/"))) {
        complete(routeName)
      }
    })
    routes.reduce((x, y) => x ~ y)
  }
}
