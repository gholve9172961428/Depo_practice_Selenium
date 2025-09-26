import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.addpayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class parsingjson {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(addpayload.addplace()).when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String placeID = js.getString("place_id");
		System.out.println("The place Id Is:"+placeID);

	}


}
