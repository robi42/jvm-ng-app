resolvers += "less is" at "http://repo.lessis.me"

libraryDependencies <+= sbtVersion(sv =>
  "me.lessis"    %% "coffeescripted-sbt" % "0.1.5-%s".format(sv)
)

libraryDependencies <+= sbtVersion(sv =>
  "com.eed3si9n" %% "sbt-assembly"       % "sbt%s_0.6".format(sv)
)
