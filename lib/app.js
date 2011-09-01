var DOCS_URL, DOC_URL, MainDocs, MongoConfig, app, respondWith, _ref;
respondWith = require('./response').respondWith;
_ref = com.robert42.jvmng, MongoConfig = _ref.MongoConfig, MainDocs = _ref.MainDocs;
app = exports.app = require('./config').app;
DOCS_URL = '/docs';
DOC_URL = "" + DOCS_URL + "/:id";
app.get('/', function(req) {
  return app.render('index.html', {
    title: 'It\'s working!'
  });
});
app.get(DOCS_URL, function() {
  return respondWith.json(MainDocs.all());
});
app.post(DOCS_URL, function(req) {
  var json;
  json = JSON.stringify(req.postParams);
  return respondWith.json(MainDocs.create(json));
});
app.get(DOC_URL, function(req, id) {
  return respondWith.json(MainDocs.get(id));
});
app.put(DOC_URL, function(req, id) {
  var json;
  req.postParams._id = id;
  json = JSON.stringify(req.postParams);
  return respondWith.json(MainDocs.update(json));
});
app.del(DOC_URL, function(req, id) {
  MainDocs.remove(id);
  return respondWith.json('');
});
if (require.main === module) {
  MongoConfig.init();
  require('ringo/httpserver').main(module.id);
}