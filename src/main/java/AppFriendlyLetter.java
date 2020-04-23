import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class AppFriendlyLetter {
    public static void main (String[] args){
        Console myConsole = System.console();

        staticFileLocation("/public");

        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "hello.hbs");
                }, new HandlebarsTemplateEngine());

        get("/photos", (request, response) ->
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<title>Hello Friend!</title>" +
                        "<link rel='stylesheet'  href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
                        "</head>" +
                        "<body>" +
                        "<h1>Favorite Traveling Photos</h1>" +
                        "<ul>" +
                        "<li><img src='/images/image1.jpg' alt='A photo of a developer.' style = 'margin : '100px;' width = '250px' height = '250px'/></li>" +
                        "<li><img src='/images/image2.png' alt='A photo of another developer.' style = 'margin : 50px;' width = '250px' height = '250px' /></li>" + "</ul>" + "</body>" + "</html>" );

    }
}
