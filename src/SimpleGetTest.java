import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest {


@Test
public void VerifyCityInJsonResponse()
{
 RestAssured.baseURI = "https://demoqa.com/Account/v1/User";
 RequestSpecification httpRequest = RestAssured.given();
 Response response = httpRequest.get("/nnanthini");
 System.out.println("Status code "+response.getStatusCode());
 System.out.println("Status line "+response.getStatusLine());
 System.out.println("Status body "+response.getBody());
 //System.out.println("Status code "+response);
 
 JsonPath jsonPath = response.jsonPath();
 System.out.println("Json Path "+jsonPath.toString());
 String code = jsonPath.get("code");
 String message = jsonPath.get("message");
 
 Assert.assertEquals(code, "1200");
 Assert.assertEquals(message, "User not authorized!");
 
 /*
 
ResponseBody body = response.getBody();
 
 // To check for sub string presence get the Response body as a String.
 // Do a String.contains
 String bodyAsString = body.asString();
 
 
 
 
 // First get the JsonPath object instance from the Response interface
 JsonPath jsonPathEvaluator = response.jsonPath();
 
 // Then simply query the JsonPath object to get a String value of the node
 // specified by JsonPath: City (Note: You should not put $. in the Java code)
 String city = jsonPathEvaluator.get("City");
 
 // Let us print the city variable to see what we got
 System.out.println("City received from Response " + city);
 
 // Validate the response
 Assert.assertEquals(city, "Hyderabad", "Correct city name received in the Response");
 */
}

}