{MainDocs} = com.robert42.jvmng

# Response helpers.
exports.respondWith =
  json: (data) ->
    status: 200
    headers:
      'Content-Type':
        'application/json; charset=utf-8'
    body: [data]
