var {Application} = require("stick");
var {Greeter}     = com.robert42;

export("app");

var app = Application();
app.configure("params", "route", "render");
app.render.base = module.resolve("templates");
app.render.master = "page.html";


app.get("/", function(request) {
    var context = {title: "It's working!"};
    console.log(Greeter.greet()); // Hello from Scala.
    return app.render("index.html", context);
});
