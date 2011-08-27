var {Application} = require('stick');
var fs            = require('fs');
var {Greeter}     = com.robert42;

// Set up application.
var app = exports.app = Application();
app.configure('notfound', 'error', 'static', 'params', 'route', 'render');
app.static(module.resolve(fs.join('..', 'public')));
app.render.base   = module.resolve(fs.join('..', 'templates'));
app.render.master = 'page.html';


app.get('/', function (req) {
    var context = {title: 'It\'s working!'};
    console.log(Greeter.greet()); // Hello from Scala.
    return app.render('index.html', context);
});


// Script to run app from command line.
if (require.main == module) {
    require('ringo/httpserver').main(module.id);
}
