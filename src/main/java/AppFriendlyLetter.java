import com.sun.tools.javac.file.PathFileObject;
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
            Map<String, Object> helloModel = new HashMap<String, Object>();
            return new ModelAndView(helloModel, "hello.hbs");
                }, new HandlebarsTemplateEngine());

        get("/photos", (request, response) -> {
            Map<String, Object> photosModel = new HashMap<String, Object>();
            return new ModelAndView(photosModel, "dev_photos.hbs");
                }, new HandlebarsTemplateEngine());

    }
}
