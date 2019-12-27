package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HelloController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result hello() {
        return ok("Hello There!");
    }

    public Result helloWithName(String name) {
        return ok("Hello There, " + name + "!");
    }

    public Result hellosWithCount(String name, Integer count) {
        if (count == null) {
            count = 0;
        }
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < count; i++) {
            message.append("Hello, ").append(name).append("!\n");
        }
        return ok(message.toString());
    }

    public Result greetings() {
        JsonNode requestJson = request().body().asJson();
        if (!requestJson.has("first_name")) {
            return badRequest("Must provide first_name");
        }
        if (!requestJson.has("last_name")) {
            return badRequest("Must provide last_name");
        }
        String firstName = requestJson.get("first_name").asText();
        String lastName = requestJson.get("last_name").asText();
        String message = "Welcome, " + firstName + " " + lastName + "!";
        return ok(message);
    }
}
