# JVM NG App

This is a minimal [RingoJS]/[Scala] hybrid app targeting deployment to [Heroku].

## Deploy

    $ gem install heroku
    $ heroku create --stack cedar
    $ git push heroku master
    $ heroku open

## Dev

To run it locally launch `ringo`
with the main script via `foreman`:

    $ gem install foreman
    $ foreman start

Then point your browser to this URL:

  http://localhost:5000/

To package `scala-assembly.jar` via `sbt` [0.10]:

    $ cd sbt; sbt
    > assembly


  [RingoJS]: http://ringojs.org/
  [Scala]:   http://www.scala-lang.org/
  [Heroku]:  http://www.heroku.com/
  [0.10]:    https://github.com/harrah/xsbt/wiki/Setup