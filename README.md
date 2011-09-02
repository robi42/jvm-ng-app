# JVM NG App

This is a minimal [RingoJS]/[Scala] hybrid app targeting deployment to [Heroku]. <br>
Its web layer is based on [Stick] and its persistence layer on [Rogue].

## Dev

The app's persistence layer depends on [MongoDB], so start it:

    $ mongod

To run the app locally launch `ringo` <br>
with the main script via `foreman`:

    $ gem install foreman
    $ foreman start

Then point your browser to this URL:

  http://localhost:5000/

To compile + package Scala & [CoffeeScript] on-the-fly <br>
via `sbt` [0.10]:

    $ sbt
    > ~package

BTW, for compiling/packaging once just leave off the `~`.

To make an assembly of all `sbt` project lib dependencies:

    $ sbt
    > assembly:package-dependency

## Deploy

    $ gem install heroku
    $ heroku create --stack cedar
    $ heroku addons:add mongolab
    $ heroku config

Now, adjust `src/main/resources/props/production.default.props` accordingly. <br>
Plus, rebuild `scala-app.jar` (via `> package`) to include this config update.

    $ heroku config:add LIFT_PROD=-Drun.mode=production
    $ heroku config:add RINGO_PROD=--production
    $ git commit -am 'Make it ready for production.'
    $ git push heroku master
    $ heroku open


  [RingoJS]:      http://ringojs.org/
  [Scala]:        http://www.scala-lang.org/
  [Heroku]:       http://www.heroku.com/
  [Stick]:        https://github.com/hns/stick#readme
  [Rogue]:        http://engineering.foursquare.com/2011/01/21/rogue-a-type-safe-scala-dsl-for-querying-mongodb/
  [MongoDB]:      http://www.mongodb.org/
  [CoffeeScript]: http://coffeescript.org/
  [0.10]:         https://github.com/harrah/xsbt/wiki/Setup
