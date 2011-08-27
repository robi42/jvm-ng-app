var response  = require('ringo/jsgi/response');
var mustache  = require('ringo/mustache');
var {Greeter} = com.robert42;

exports.index = function (req) {
    var template = getResource("./templates/index.html").content;

    // Hello from Scala.
    console.log(Greeter.greet());

    return response.html(
        mustache.to_html(template, {
            title: "It's working!"
        })
    );
};
