
import org.testng.Assert;
import util.Util;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class OpenWeatherAPI {
 
 @Test
 public void queryParameter() {
 
 RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/"; 
 RequestSpecification request = RestAssured.given();
 
 Response response = request.queryParam("q", "London") 
                    .queryParam("appid", Util.KEY) 
                    .get("/weather");
 
 System.out.println("Response body "+response.getBody().asPrettyString());
 System.out.println("Response status "+response.statusLine());
 System.out.println("Response code "+response.statusCode());
 
 JsonPath jsonPath = response.jsonPath();
 Integer id = jsonPath.get("id");
 
 System.out.println(id);
 
 }
}