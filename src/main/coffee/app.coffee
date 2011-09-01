{respondWith, handleCreateOrUpdate} = require './handler'
{MongoConfig, MainDocs}             = com.robert42.jvmng
app = exports.app                   = require('./config').app

DOCS_URL = '/docs'
DOC_URL  = "#{DOCS_URL}/:id"

# Request/response handling.
app.get '/', (req) ->
  app.render 'index.html', title: 'It\'s working!'

app.get DOCS_URL, ->
  respondWith.json MainDocs.all()

app.post DOCS_URL, handleCreateOrUpdate

app.get DOC_URL, (req, id) ->
  respondWith.json MainDocs.get(id)

app.put DOCS_URL, handleCreateOrUpdate

app.del DOC_URL, (req, id) ->
  MainDocs.remove id
  respondWith.json ''


# Script to run app from command line.
if require.main is module
  MongoConfig.init()
  require('ringo/httpserver').main module.id
