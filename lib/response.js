var MainDocs;
MainDocs = com.robert42.jvmng.MainDocs;
exports.respondWith = {
  json: function(data) {
    return {
      status: 200,
      headers: {
        'Content-Type': 'application/json; charset=utf-8'
      },
      body: [data]
    };
  }
};