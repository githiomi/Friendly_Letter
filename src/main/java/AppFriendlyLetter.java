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

        get("/photos", (request, response) -> {
            return new ModelAndView(new HashMap(), "dev_photos.hbs");
                }, new HandlebarsTemplateEngine());

    }
}
