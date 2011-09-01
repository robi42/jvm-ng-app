{MainDocs} = com.robert42.jvmng

# Some helpers.
module.exports =
  respondWith:
    json: (data) ->
      status: 200
      headers:
        'Content-Type':
          'application/json; charset=utf-8'
      body: [data]

  handleCreateOrUpdate: (req) ->
    if req.method is 'POST'
      createOrUpdate req, (json) ->
        MainDocs.create json
    else if req.method is 'PUT'
      createOrUpdate req, (json) ->
        MainDocs.update json

createOrUpdate = (req, callback) ->
  json = JSON.stringify(req.postParams)
  module.exports.respondWith.json callback(json)
