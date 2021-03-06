import java.util.*;
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

          int i = 0;
          ArrayList randomCards = new ArrayList<Card>();
          while (i < 5 ){
            Card randomCard = deck.makeRandomCard();
            randomCards.add(randomCard);
            i++;
          }

          Collections.sort(randomCards);
          model.put("randomCards", randomCards);

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
