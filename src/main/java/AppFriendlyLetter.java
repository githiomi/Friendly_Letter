

import static spark.Spark.*;

import java.io.Console;

public class AppFriendlyLetter {
    public static void main (String[] args){
        Console myConsole = System.console();
        get("/", (request, response) -> "Hello world!");
    }
}
