import Dependencies._

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "lenga",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.1.8",
    libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.19", // or whatever the latest version is
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-stream-testkit" % "2.5.19",
      "com.typesafe.akka" %% "akka-http-testkit" % "10.1.8"
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
