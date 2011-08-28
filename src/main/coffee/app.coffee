{Application} = require 'stick'
fs            = require 'fs'
{Greeter}     = com.robert42

# Set up application.
app = exports.app = Application()
app.configure 'notfound', 'error', 'static', 'params', 'route', 'render'
app.static module.resolve(fs.join('..', 'public'))
app.render.base   = module.resolve(fs.join('..', 'templates'))
app.render.master = 'page.html'


app.get '/', (req) ->
  console.log Greeter.greet() # Hello from Scala.
  app.render 'index.html', title: 'It\'s working!'


# Script to run app from command line.
if require.main is module
  require('ringo/httpserver').main module.id
