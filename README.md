# SBT Assignment

### Created SBT Project with JDBC and joda date/time dependencies and scalastyle plugin.Also added Cached Resolution feature:

```

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "SBT-Assignment",
    idePackagePrefix := Some("com.knoldus.sbtassignment"),

    //JDBC and joda date/time dependencies
    libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.32",
    libraryDependencies += "joda-time" % "joda-time" % "2.12.2",

    //adding cached Resolution  feature
    updateOptions := updateOptions.value.withCachedResolution(true)
  ).aggregate(core, utils)
```
### Two sub-modules(core and utils) created
**Added scala test dependency in core module with test scope:-**

**Added classpath of core utils module into core module:-**

```
lazy val core = project
  .settings(commonSettings,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "Test")
  .dependsOn(utils)

lazy val utils = project
  .settings(commonSettings)
```

### Added scala style plugin which give warning of all modules:
![Screenshot from 2023-03-14 00-08-38](https://user-images.githubusercontent.com/125345690/224806576-895e812c-c385-44db-9246-c35a3e5ed8ba.png)
