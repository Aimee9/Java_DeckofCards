import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {

        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          Deck deck = new Deck();
          Card randomCard = deck.makeRandomCard();
          model.put("randomCard", randomCard);
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/output", (request, response) -> {
          //set up the hashmap and set the output
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/output.vtl");
          return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

      }
    }
