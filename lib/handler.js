var MainDocs, createOrUpdate;
MainDocs = com.robert42.jvmng.MainDocs;
module.exports = {
  respondWith: {
    json: function(data) {
      return {
        status: 200,
        headers: {
          'Content-Type': 'application/json; charset=utf-8'
        },
        body: [data]
      };
    }
  },
  handleCreateOrUpdate: function(req) {
    if (req.method === 'POST') {
      return createOrUpdate(req, function(json) {
        return MainDocs.create(json);
      });
    } else if (req.method === 'PUT') {
      return createOrUpdate(req, function(json) {
        return MainDocs.update(json);
      });
    }
  }
};
createOrUpdate = function(req, callback) {
  var json;
  json = JSON.stringify(req.postParams);
  return module.exports.respondWith.json(callback(json));
};