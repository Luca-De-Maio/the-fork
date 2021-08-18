package api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import userinformation.testSuccessfulPersonalInformation;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PokemonNormalType {
    private Logger logger = Logger.getLogger(PokemonNormalType.class);

    @Test
    public void requestPokemon() {
        List<String> normals = new ArrayList<>();

        ResponseBody response = RestAssured.given().get("https://pokeapi.co/api/v2/pokemon?limit=30").getBody();

        JsonPath jsonPath = new JsonPath(response.asString()).setRootPath("results");

        List<String> urls =  jsonPath.get("url");
        logger.info("Pokemon Normal type: ");

        for (String url : urls) {
            ResponseBody pokemon = given().get(url).getBody();
            JsonPath types = new JsonPath(pokemon.asString()).setRootPath("types");
            int i = 0;
            while(i < types.getList("").size()) {
                if (types.getList("type.name").get(i).equals("normal")) {
                    normals.add(url);
                    logger.info(url);
                }
                i++;
            }
        }
    }
}
