name := "JVM NG"

seq(sbtassembly.Plugin.assemblySettings: _*)

outputPath in Assembly := file("jars") / "scala-assembly.jar"
