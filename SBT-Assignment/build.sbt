import org.scalastyle.sbt.ScalastylePlugin

val jdbc = "mysql" % "mysql-connector-java" % "8.0.32"
val date_time = "joda-time" % "joda-time" % "2.12.2"

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "SBT-Assignment",
    idePackagePrefix := Some("com.knoldus.sbtassignment"),

    //JDBC and joda date/time dependencies
    libraryDependencies += jdbc,
    libraryDependencies += date_time,

    //adding cached Resolution  feature
    updateOptions := updateOptions.value.withCachedResolution(true)
  ).aggregate(core, utils)

lazy val commonSettings = ScalastylePlugin.globalSettings

lazy val core = project
  .settings(commonSettings,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "Test")
  .dependsOn(utils)

lazy val utils = project
  .settings(commonSettings)