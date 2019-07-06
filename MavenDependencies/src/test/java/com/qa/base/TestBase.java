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
import com.qa.util.TestUtil;

publicTestBase(Class<GetResponseType>t1, Class<PostResponseType>t2) {
	this.getResponseClass = t1;
	this.postResponseClass = t2;

publicstaticintRESPONSE_STATUS_CODE_200 = 200; 
publicstaticintRESPONSE_STATUS_CODE_500 = 500;
publicstaticintRESPONSE_STATUS_CODE_400 = 400;
publicstaticintRESPONSE_STATUS_CODE_401 = 401;
publicstaticintRESPONSE_STATUS_CODE_201 = 201;
publicstaticintRESPONSE_STATUS_CODE_403 = 403;
publicstaticintRESPONSE_STATUS_CODE_404 = 404;
publicstaticintRESPONSE_STATUS_CODE_202 = 202;
publicstaticintRESPONSE_STATUS_CODE_405 = 405;

static {
	try {
		prop = newProperties();
		FileInputStreamip = newFileInputStream(
				System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");
		prop.load(ip);
	} catch (FileNotFoundExceptione) {
		e.printStackTrace();
	} catch (IOExceptione) {
		e.printStackTrace();
	}
protectedstatic String getAccessToken() throwsJsonGenerationException, JsonMappingException, IOException {
	returngetAccessToken(false);
}

protectedstatic String getAccessToken(booleanisNegative) throwsJsonGenerationException, JsonMappingException, IOException {
	if (isNegative) {
		if (badAccessToken == null) {
			returngetAccessToken(prop.getProperty("negative_client_id"), prop.getProperty("negative_client_secret"), prop.getProperty("negative_audience"), true);
		}
		returnbadAccessToken;
	}
	if (accessToken == null) {
		returngetAccessToken(prop.getProperty("auth_client_id"), prop.getProperty("auth_client_secret"), prop.getProperty("auth_audience"), false);
	}
	returnaccessToken;
}

protectedstatic String getAccessToken(String clientId, String clientSecret, String audience, booleanisNegative)
		throwsJsonGenerationException, JsonMappingException, IOException {
	HashMap<String, String>headerMap = new HashMap<String, String>();
-			headerMap.put("Content-Type", "application/json");
-	I do also some other neccessery code to change object to Jason to string , check the status code , jasonstring then json to java object 
-	// jackson API:
-	
-			AuthenticationRequestrequest = newAuthenticationRequest(clientId, clientSecret, audience, prop.getProperty("auth_grant_type"));
-			
-			
-			// object to json to String:
-			String requestString = MAPPER.writeValueAsString(request);
-			String url = prop.getProperty("URL") + prop.getProperty("serviceURL");
-			CloseableHttpResponsecloseableHttpResponse = restClient.post(url, requestString, headerMap);// call the api
-	
-			// validate response from API:
-	
-			// status code
-			System.out.println(accessToken);
-			intstatusCode = closeableHttpResponse.getStatusLine().getStatusCode();
-			Assert.assertEquals(statusCode, TestBase.RESPONSE_STATUS_CODE_200);
-	
-			// JosonString
-			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
-			
-			JSONObjectresponseJson = newJSONObject(responseString);
-	
-			// json to java object
-			Token usersResObj = MAPPER.readValue(responseString, Token.class); // actual users object
-			// System.out.println(usersResObj);
-			if (isNegative) {
-				badAccessToken = usersResObj.getAccess_token();
-				returnbadAccessToken;
-			} else {
-				accessToken = usersResObj.getAccess_token();
-				returnaccessToken;	

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
		
		JSONObject responseJson = new JSONObject(responseString);

		
		// json to java object
		Token usersResObj = MAPPER.readValue(responseString, Token.class); // actual users object
		// System.out.println(usersResObj);
		TestBase.accessToken = usersResObj.getAccess_token();
		return TestBase.accessToken;

	}

publicGetResponseTypeget(String url) throwsClientProtocolException, IOException {
	returnget(url, TestBase.RESPONSE_STATUS_CODE_200, false);
}

publicGetResponseTypeget(String url, intexpectedStatusCode) {
	returnget(url, expectedStatusCode, false);
}

/**
 * Makes a get request to the given {@paramurl}, asserts the request is
 * successful and returns the JSON response.
 * 
 * @return JSON response object.
 * @throwsIOException
 * @throwsClientProtocolException
 */
publicGetResponseTypeget(String url, intexpectedStatusCode, booleanisNegative) {
	try {
		HashMap<String, String>headerMap = new HashMap<String, String>();
		headerMap.put("Authorization", "bearer " + TestBase.getAccessToken(isNegative));

		System.out.printf("Sending request to %s\n", url);
		// Call the API
		CloseableHttpResponsecloseableHttpResponse = restClient.get(url, headerMap);

		// Assert that the request was successful
		intstatusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, expectedStatusCode);
		
		
		// If the request fails, don't check the object structure
		if (expectedStatusCode / 100 != 2) {
			returnnull;
		}

		Header[] headersArray = closeableHttpResponse.getAllHeaders();

		// Print headers and response for debugging
		HashMap<String, String>allHeaders = new HashMap<String, String>();
		for (Header header :headersArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Header Array-->" + allHeaders);

		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		System.out.println("The response from get API: " + responseString);
		
		if (this.getResponseClass == String.class) {
			return(GetResponseType)responseString;
		}
		
		GetResponseTypereturnvalue = MAPPER.readValue(responseString, this.getResponseClass);

		returnreturnvalue;
	} catch (Exception e) {
		thrownewRuntimeException(e);
	}


	}

publicPostResponseTypepost(String url, String postBody) throwsClientProtocolException, IOException {
	returnpost(url, postBody, false);
}

publicPostResponseTypepost(String url, String postBody, booleanisNegative) throwsClientProtocolException, IOException {
	HashMap<String, String>headerMap = new HashMap<String, String>();
	headerMap.put("Content-Type", "application/json");
	headerMap.put("Authorization", "bearer " + TestBase.getAccessToken(isNegative));

	System.out.printf("Sending request to %s\n", url);
	// Call the API
	CloseableHttpResponsecloseableHttpResponse = restClient.post(url, postBody, headerMap);

	//Assert that the request was successful
	intstatusCode = closeableHttpResponse.getStatusLine().getStatusCode();
	Assert.assertEquals(statusCode, TestBase.RESPONSE_STATUS_CODE_202);

	Header[] headersArray = closeableHttpResponse.getAllHeaders();

	// Print headers and response for debugging
	HashMap<String, String>allHeaders = new HashMap<String, String>();
	for (Header header :headersArray) {
		allHeaders.put(header.getName(), header.getValue());
	}
	System.out.println("Header Array-->" + allHeaders);

	String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
	System.out.println("The response from post API: " + responseString);

	PostResponseTypereturnvalue = MAPPER.readValue(responseString, this.postResponseClass);
	
	
	
	returnreturnvalue;

	}
}