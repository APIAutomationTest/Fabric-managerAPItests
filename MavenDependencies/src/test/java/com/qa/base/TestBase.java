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

public abstract class TestBase<GetResponseType, PostResponseType> {

	public static int RESPONSE_STATUS_CODE_200 = 200;
	public static int RESPONSE_STATUS_CODE_500 = 500;
	public static int RESPONSE_STATUS_CODE_400 = 400;
	public static int RESPONSE_STATUS_CODE_401 = 401;
	public static int RESPONSE_STATUS_CODE_201 = 201;
	public static int RESPONSE_STATUS_CODE_403 = 403;
	public static int RESPONSE_STATUS_CODE_404 = 404;
	public static int RESPONSE_STATUS_CODE_202 = 202;
	public static Properties prop;

	private final Class<GetResponseType> getResponseClass;
	private final Class<PostResponseType> postResponseClass;

	private static RestClient restClient = new RestClient();

	protected static String accessToken;

	private static final ObjectMapper MAPPER = new ObjectMapper();

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

	public TestBase(Class<GetResponseType> t1, Class<PostResponseType> t2) {
		this.getResponseClass = t1;
		this.postResponseClass = t2;
	}

	protected static String getAccessToken() throws JsonGenerationException, JsonMappingException, IOException {
		if (TestBase.accessToken == null) {
			return getAccessToken(prop.getProperty("auth_client_id"), prop.getProperty("auth_client_secret"));
		}
		return TestBase.accessToken;
	}

	protected static String getAccessToken(String clientId, String clientSecret)
			throws JsonGenerationException, JsonMappingException, IOException {

		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");

		// jackson API:

		AuthenticationRequest request = new AuthenticationRequest(clientId, clientSecret,
				prop.getProperty("auth_audience"), prop.getProperty("auth_grant_type"));

		

		// object to json to String:
		String requestString = MAPPER.writeValueAsString(request);
		String url = prop.getProperty("URL") + prop.getProperty("serviceURL");
		CloseableHttpResponse closeableHttpResponse = restClient.post(url, requestString, headerMap);// call the api

		// validate response from API:

		// status code

		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, TestBase.RESPONSE_STATUS_CODE_200);

		// JosonString
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		

		// json to java object
		Token usersResObj = MAPPER.readValue(responseString, Token.class); // actual users object
		// System.out.println(usersResObj);
		TestBase.accessToken = usersResObj.getAccess_token();
		return TestBase.accessToken;

	}

	protected GetResponseType get(String url) throws ClientProtocolException, IOException {
		return get(url, TestBase.RESPONSE_STATUS_CODE_200);
	}

	/**
	 * Makes a get request to the given {@param url}, asserts the request is
	 * successful and returns the JSON response.
	 * 
	 * @return JSON response object.
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	protected GetResponseType get(String url, int expectedStatusCode) throws ClientProtocolException, IOException {
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Authorization", "bearer " + TestBase.getAccessToken());

		System.out.printf("Sending request to %s\n", url);
		// Call the API
		CloseableHttpResponse closeableHttpResponse = restClient.get(url, headerMap);

		// Assert that the request was successful
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, expectedStatusCode);
		
		// If the request fails, don't check the object structure
		if (expectedStatusCode / 100 != 2) {
			return null;
		}

		Header[] headersArray = closeableHttpResponse.getAllHeaders();

		// Print headers and response for debugging
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Header Array-->" + allHeaders);

		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		System.out.println("The response from get API: " + responseString);

		GetResponseType returnvalue = MAPPER.readValue(responseString, this.getResponseClass);

		return returnvalue;
	}

	protected PostResponseType post(String url, String postBody) throws ClientProtocolException, IOException {
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Authorization", "bearer " + TestBase.getAccessToken());

		System.out.printf("Sending request to %s\n", url);
		// Call the API
		CloseableHttpResponse closeableHttpResponse = restClient.post(url, postBody, headerMap);

		// Assert that the request was successful
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, TestBase.RESPONSE_STATUS_CODE_202);
		
		Header[] headersArray = closeableHttpResponse.getAllHeaders();

		// Print headers and response for debugging
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Header Array-->" + allHeaders);

		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		System.out.println("The response from post API: " + responseString);

		PostResponseType returnvalue = MAPPER.readValue(responseString, this.postResponseClass);

		return returnvalue;
	}
}
