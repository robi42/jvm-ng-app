var Application, Greeter, app, fs;
Application = require('stick').Application;
fs = require('fs');
Greeter = com.robert42.Greeter;
app = exports.app = Application();
app.configure('notfound', 'error', 'static', 'params', 'route', 'render');
app.static(module.resolve(fs.join('..', 'public')));
app.render.base = module.resolve(fs.join('..', 'templates'));
app.render.master = 'page.html';
app.get('/', function(req) {
  console.log(Greeter.greet());
  return app.render('index.html', {
    title: 'It\'s working!'
  });
});
if (require.main === module) {
  require('ringo/httpserver').main(module.id);
}