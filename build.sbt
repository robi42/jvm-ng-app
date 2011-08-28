name := "JVM NG"

unmanagedBase <<= baseDirectory { base => base / "sbt_jars" }

resolvers ++= Seq(
  "scala-tools" at "http://nexus.scala-tools.org/content/repositories/public",
  "codahale" at "http://repo.codahale.com"
)

libraryDependencies += "com.codahale" %% "simplespec" % "0.3.4" % "test->default"

seq(coffeescript.CoffeeScript.coffeeSettings: _*)

bare in Coffee := true

targetDirectory in Coffee := file("lib")

seq(sbtassembly.Plugin.assemblySettings: _*)

outputPath in Assembly := file("jars") / "scala-assembly.jar"
