name    := "JVM NG"

version := "0.1"

scalaVersion := "2.8.1"

unmanagedBase <<= baseDirectory { base => base / "sbt_jars" }

resolvers ++= Seq(
  "scala-tools" at "http://nexus.scala-tools.org/content/repositories/public",
  "codahale"    at "http://repo.codahale.com"
)

libraryDependencies ++= Seq(
  "ch.qos.logback" %  "logback-classic"     % "0.9.28",
  "com.foursquare" %% "rogue"               % "1.0.21" intransitive(),
  "net.liftweb"    %% "lift-mongodb-record" % "2.4-M2",
  "com.codahale"   %% "simplespec"          % "0.3.4" % "test->default"
)

seq(coffeescript.CoffeeScript.coffeeSettings: _*)

bare in Coffee := true

targetDirectory in Coffee := file("lib")

seq(sbtassembly.Plugin.assemblySettings: _*)

outputPath in Assembly := file("jars") / "scala-assembly.jar"

// test in Assembly := {}
