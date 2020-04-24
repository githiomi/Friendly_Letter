import com.sun.tools.javac.file.PathFileObject;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import velocity.VelocityTemplateEngine;

import static spark.Spark.*;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class AppFriendlyLetter {
    public static void main (String[] args){
        Console myConsole = System.console();
        String layout = "templates/layout.vtl";

        staticFileLocation("/public");

//        get("/", (request, response) -> {
//            Map<String, Object> helloModel = new HashMap<String, Object>();
//            return new ModelAndView(helloModel, "hello.hbs");
//                }, new HandlebarsTemplateEngine());
//
//        get("/photos", (request, response) -> {
//            Map<String, Object> photosModel = new HashMap<String, Object>();
//            return new ModelAndView(photosModel, "dev_photos.hbs");
//                }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/card", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("recipient", request.queryParams("recipient"));
            model.put("sender", request.queryParams("sender"));
            model.put("template", "templates/greetingcard.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}
