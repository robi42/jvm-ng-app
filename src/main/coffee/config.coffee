{Application} = require 'stick'
fs            = require 'fs'

publicPath    = module.resolve(fs.join('..', 'public'))
templatesPath = module.resolve(fs.join('..', 'templates'))

# Set up application.
app = exports.app = Application()
app.configure 'notfound', 'error', 'gzip', 'etag',
  'static', 'params', 'route', 'render'
app.static publicPath
app.render.base   = templatesPath
app.render.master = 'page.html'
