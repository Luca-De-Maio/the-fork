package api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class NormalType {


    @Test
    public void requestPokemon() {
        List<String> normals = new ArrayList<>();

        ResponseBody response = RestAssured.given().get("https://pokeapi.co/api/v2/pokemon?limit=30").getBody();

        JsonPath jsonPath = new JsonPath(response.asString()).setRootPath("results");

        List<String> urls =  jsonPath.get("url");

        for (String url : urls) {
            ResponseBody pokemon = given().get(url).getBody();
            JsonPath types = new JsonPath(pokemon.asString()).setRootPath("types");
            int i = 0;
            while(i < types.getList("").size()) {
                if (types.getList("type.name").get(i).equals("normal")) {
                    normals.add(url);
                    System.out.println(url);
                }
                i++;
            }
        }
    }
}
