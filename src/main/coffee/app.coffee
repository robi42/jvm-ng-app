{respondWith}           = require './response'
{MongoConfig, MainDocs} = com.robert42.jvmng
app = exports.app       = require('./config').app

DOCS_URL = '/docs'
DOC_URL  = "#{DOCS_URL}/:id"

# Request/response handling.
app.get '/', (req) ->
  app.render 'index.html', title: 'It\'s working!'

app.get DOCS_URL, ->
  respondWith.json MainDocs.all()

app.post DOCS_URL, (req) ->
  json = JSON.stringify(req.postParams)
  respondWith.json MainDocs.create(json)

app.get DOC_URL, (req, id) ->
  respondWith.json MainDocs.get(id)

app.put DOC_URL, (req, id) ->
  req.postParams._id = id
  json = JSON.stringify(req.postParams)
  respondWith.json MainDocs.update(json)

app.del DOC_URL, (req, id) ->
  MainDocs.remove id
  respondWith.json ''


# Script to run app from command line.
if require.main is module
  MongoConfig.init()
  require('ringo/httpserver').main module.id
