import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
  @Test
  public void f() {
	  
	  RestAssured.baseURI = "https://demoqa.com/Account/v1/Authorized";
	  RequestSpecification request = RestAssured.given();
	  
	  JSONObject obj = new JSONObject();
	  obj.put("userName", "nnanthini");
	  obj.put("password", "Nnanthini@123");
	  System.out.println("JSON string for put request "+obj.toJSONString());
	  request.body(obj.toJSONString());
	  Response response = request.post();
	  //ResponseBody body = response.body();
	  System.out.println(response.jsonPath().prettyPrint());
	  System.out.println(response.getStatusCode());
	  System.out.println(response.getStatusLine());
	  Assert.assertEquals(response.getStatusCode(), 200);
	  //System.out.println(response.jsonPath());
	  
	  
	  
  }
}
