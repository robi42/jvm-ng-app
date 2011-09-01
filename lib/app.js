var DOCS_URL, DOC_URL, MainDocs, MongoConfig, app, handleCreateOrUpdate, respondWith, _ref, _ref2;
_ref = require('./handler'), respondWith = _ref.respondWith, handleCreateOrUpdate = _ref.handleCreateOrUpdate;
_ref2 = com.robert42.jvmng, MongoConfig = _ref2.MongoConfig, MainDocs = _ref2.MainDocs;
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
app.post(DOCS_URL, handleCreateOrUpdate);
app.get(DOC_URL, function(req, id) {
  return respondWith.json(MainDocs.get(id));
});
app.put(DOCS_URL, handleCreateOrUpdate);
app.del(DOC_URL, function(req, id) {
  MainDocs.remove(id);
  return respondWith.json('');
});
if (require.main === module) {
  MongoConfig.init();
  require('ringo/httpserver').main(module.id);
}