resolvers += "less is" at "http://repo.lessis.me"

libraryDependencies <+= sbtVersion(v =>
  "me.lessis" %% "coffeescripted-sbt" % "0.1.5-%s".format(v)
)

libraryDependencies <+= (sbtVersion) { sv => "com.eed3si9n" %% "sbt-assembly" % ("sbt" + sv + "_0.6") }
