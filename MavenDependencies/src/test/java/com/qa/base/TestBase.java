package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.client.RestClient;
import com.qa.data.AuthenticationRequest;
import com.qa.data.Token;

public class TestBase {

	public static int RESPONSE_STATUS_CODE_200 = 200;
	public static int RESPONSE_STATUS_CODE_500 = 500;
	public static int RESPONSE_STATUS_CODE_400 = 400;
	public static int RESPONSE_STATUS_CODE_401 = 401;
	public static int RESPONSE_STATUS_CODE_201 = 201;
	public static int RESPONSE_STATUS_CODE_404 = 404;
	public static Properties prop;

	private static RestClient restClient = new RestClient();

	private static String accessToken;

	static {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TestBase() {
	}

	protected static String getAccessToken() throws JsonGenerationException, JsonMappingException, IOException {
		if (TestBase.accessToken == null) {
			HashMap<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("Content-Type", "application/json");

			// jackson API:

			ObjectMapper mapper = new ObjectMapper();
			AuthenticationRequest request = new AuthenticationRequest("BtJ6mnD3VnhBEgrJRgEVYqSx3BBvvBhC",
					"6vpdd-JwK8DpwvSs2MJMMFQdLSWDhCa87art2FV3qf9NceVoNZan8jeRrJw8Cy4F",
					"https://cxt-fabric-manager.azurewebsites.net", "client_credentials"); // expected users

			// object to json file:

			// object to json to String:
			String requestString = mapper.writeValueAsString(request);
			String url = prop.getProperty("URL") + prop.getProperty("serviceURL");
			CloseableHttpResponse closeableHttpResponse = restClient.post(url, requestString, headerMap);// call the api

			// validate response from API:

			// status code

			int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
			Assert.assertEquals(statusCode, TestBase.RESPONSE_STATUS_CODE_200);

			// JosonString
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			JSONObject responseJson = new JSONObject(responseString);

			System.out.println("The response from API is" + responseJson);

			// json to java object
			Token usersResObj = mapper.readValue(responseString, Token.class); // actual users object
			System.out.println(usersResObj);
			TestBase.accessToken = usersResObj.getAccess_token();
		}
		return TestBase.accessToken;
	}
	
	/**
	 * Makes a get request to the given {@param url}, asserts the request is successful
	 * and returns the JSON response.
	 * 
	 * @return JSON response object.
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	protected JSONObject get(String url) throws ClientProtocolException, IOException {
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Authorization", "bearer " + TestBase.getAccessToken());

		// Call the API
		CloseableHttpResponse closeableHttpResponse = restClient.get(url, headerMap);
		
		// Assert that the request was successful
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, TestBase.RESPONSE_STATUS_CODE_200);
		
		Header[] headersArray = closeableHttpResponse.getAllHeaders();

		// Print headers and response for debugging
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Header Array-->" + allHeaders);

		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		System.out.println("The response from get API" + responseString);
		JSONObject responseJson = new JSONObject(responseString);
		return responseJson;
	}

}
