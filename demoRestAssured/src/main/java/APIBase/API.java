package APIBase;
 import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import utils.Constants;
import utils.DateFormatter;

public class API {


	private static Response response;
	private static String responseStr;

	//Set base URL
	public static void setBaseURL() {
		RestAssured.baseURI = Constants.URL;
	}

	//Get response on API request
	public static void ResponseonGET() {

		response = RestAssured.given().request(Method.GET,"");
		responseStr = response.asPrettyString();
	}

	//Response is saved in .txt file
	public static void saveResponseInFile() {

		try {		
			FileWriter writer = new FileWriter(new File(Constants.filepath+"/sfgov_"+DateFormatter.requiredFormat()+".json"));
			writer.write(response.toString());
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void addIsRoofAttribute() {
		try {
			//Adding attribute is_roof to response
			JsonElement jsonElement = new Gson().fromJson(responseStr, JsonElement.class);
			JsonArray gsonarray = jsonElement.getAsJsonArray(); 
			for(JsonElement element : gsonarray) {
				if(element.isJsonObject()) {
					JsonObject jsonObj = element.getAsJsonObject();
					String description = jsonObj.get("description").getAsString();
					if(description != null && description.contains("roof")) {
						jsonObj.addProperty("is_roof", "true");
					}
					else {
						jsonObj.addProperty("is_roof", "false");
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Response is saves in csv file
	public static void saveResponseInCSV() {
		try {

			JSONArray array = new JSONArray(responseStr);
			File file = new File(Constants.filepath+"/sfgov_"+DateFormatter.requiredFormat()+".csv");
			//System.out.println("file created");
			String csvString = CDL.toString(array);
			FileUtils.writeStringToFile(file, csvString);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
