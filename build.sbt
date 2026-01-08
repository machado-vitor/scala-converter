val scala3Version = "3.7.4"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala-converter",
    version := "0.1.0",
    scalaVersion := scala3Version
  )
