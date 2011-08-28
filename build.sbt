name := "JVM NG"

seq(coffeescript.CoffeeScript.coffeeSettings: _*)

bare in Coffee := true

targetDirectory in Coffee := file("lib")

seq(sbtassembly.Plugin.assemblySettings: _*)

outputPath in Assembly := file("jars") / "scala-assembly.jar"
