package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.*;	


public class PostAPITest extends TestBase{
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;
	String url1;
	String url2;
	String url3;
	String url4;
	String url5;
	String url6;
	String url7;
	String serviceUrl1;
	String serviceUrl2;
	String serviceUrl3;
	String serviceUrl4;
	String serviceUrl5;
	String serviceUrl6;
	String serviceUrl7;
	String apiUrl1;
	String apiUrl2;
	String apiUrl3;
	String apiUrl4;
	String apiUrl5;
	String apiUrl6;
	String apiUrl7;
	String usersResObj;

	

@BeforeMethod
	
	public void setUp () throws ClientProtocolException, IOException {
		testBase = new TestBase();
		 serviceUrl = prop.getProperty("URL");
		 apiUrl = prop.getProperty("serviceURL");
		
		 url = serviceUrl + apiUrl;
		 
		 serviceUrl1 = prop.getProperty("URL1");
		 apiUrl1 = prop.getProperty("serviceURL1");
		
		 url1 = serviceUrl1 + apiUrl1;
		 
		 serviceUrl2 = prop.getProperty("URL1");
		 apiUrl2 = prop.getProperty("serviceURL2");
		
		 url2 = serviceUrl2 + apiUrl2;
		 
		 serviceUrl3 = prop.getProperty("URL1");
		 apiUrl3 = prop.getProperty("serviceURL3");
		
		 url3 = serviceUrl3 + apiUrl3;
		 
		 serviceUrl4 = prop.getProperty("URL1");
		 apiUrl4 = prop.getProperty("serviceURL4");
		
		 url4 = serviceUrl4 + apiUrl4;
		 
		 serviceUrl5 = prop.getProperty("URL1");
		 apiUrl5 = prop.getProperty("serviceURL5");
		
		 url5 = serviceUrl5 + apiUrl5;
		 
		 serviceUrl6 = prop.getProperty("URL1");
		 apiUrl6 = prop.getProperty("serviceURL6");
		
		 url6 = serviceUrl6 + apiUrl6;
		 
		 serviceUrl7 = prop.getProperty("URL1");
		 apiUrl7 = prop.getProperty("serviceURL7");
		
		 url7 = serviceUrl7 + apiUrl7;
}

@Test(priority =1)
public void postAPITest() throws JsonGenerationException, JsonMappingException, IOException {
restClient = new RestClient();
HashMap<String, String> headerMap = new HashMap<String, String>();
headerMap.put("Content-Type", "application/json");

//jackson API:

ObjectMapper mapper = new ObjectMapper();
AuthenticationRequest request = new AuthenticationRequest("BtJ6mnD3VnhBEgrJRgEVYqSx3BBvvBhC","6vpdd-JwK8DpwvSs2MJMMFQdLSWDhCa87art2FV3qf9NceVoNZan8jeRrJw8Cy4F","https://cxt-fabric-manager.azurewebsites.net","client_credentials"); // expected users

//object to json file:



// object to json to String:
String requestString = mapper.writeValueAsString(request);

closeableHttpResponse = restClient.post(url, requestString, headerMap);// call the api

// validate response from API:


//status code

int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
AssertJUnit.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_200);

//JosonString
String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");

JSONObject responseJson = new JSONObject(responseString);

System.out.println("The response from API is"+responseJson);

System.out.println("-----------------------------------------------------------------------------------------------------------");

// json to java object
	Token usersResObj = mapper.readValue(responseString, Token.class); // actual users object
	System.out.println(usersResObj);
	this.usersResObj = usersResObj.getAccess_token();	
	
	


}
// get method computeNodes
@Test(priority =2)
public void GetAPITest() throws JsonGenerationException, JsonMappingException, IOException {
restClient = new RestClient();
HashMap<String, String> headerMap = new HashMap<String, String>();
headerMap.put("Authorization", "bearer "+usersResObj);

closeableHttpResponse = restClient.get(url1, headerMap);// call the api


Header[] headersArray = closeableHttpResponse.getAllHeaders();

HashMap<String, String> allHeaders = new HashMap<String, String>();


for(Header header : headersArray) {
	allHeaders.put(header.getName(), header.getValue());
	
}

System.out.println("Header Array-->"+allHeaders);

String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");


System.out.println("The response from get API computeNodes"+responseString);
System.out.println("-----------------------------------------------------------------------------------------------------------");


}
// get method customers
@Test(priority =3)
public void GetAPITest1() throws JsonGenerationException, JsonMappingException, IOException {
restClient = new RestClient();
HashMap<String, String> headerMap = new HashMap<String, String>();
headerMap.put("Authorization", "bearer "+usersResObj);

closeableHttpResponse = restClient.get(url2, headerMap);// call the api

Header[] headersArray = closeableHttpResponse.getAllHeaders();

HashMap<String, String> allHeaders = new HashMap<String, String>();


for(Header header : headersArray) {
	allHeaders.put(header.getName(), header.getValue());
	
}

System.out.println("Header Array customers-->"+allHeaders);

String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");


System.out.println("The response from get API customers "+responseString);
System.out.println("-----------------------------------------------------------------------------------------------------------");


}
//get method customers
@Test(priority =4)
public void GetAPITest2() throws JsonGenerationException, JsonMappingException, IOException {
restClient = new RestClient();
HashMap<String, String> headerMap = new HashMap<String, String>();
headerMap.put("Authorization", "bearer "+usersResObj);

closeableHttpResponse = restClient.get(url3, headerMap);// call the api

Header[] headersArray = closeableHttpResponse.getAllHeaders();

HashMap<String, String> allHeaders = new HashMap<String, String>();


for(Header header : headersArray) {
	allHeaders.put(header.getName(), header.getValue());
	
}

System.out.println("Header Array computeNodeGroups-->"+allHeaders);

String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");


System.out.println("The response from get API computeNodeGroups "+responseString);
System.out.println("-----------------------------------------------------------------------------------------------------------");


}
@Test(priority =5)
public void GetAPITest3() throws JsonGenerationException, JsonMappingException, IOException {
restClient = new RestClient();
HashMap<String, String> headerMap = new HashMap<String, String>();
headerMap.put("Authorization", "bearer "+usersResObj);

closeableHttpResponse = restClient.get(url4, headerMap);// call the api

Header[] headersArray = closeableHttpResponse.getAllHeaders();

HashMap<String, String> allHeaders = new HashMap<String, String>();


for(Header header : headersArray) {
	allHeaders.put(header.getName(), header.getValue());
	
}

System.out.println("Header Array networks-->"+allHeaders);

String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");


System.out.println("The response from get API networks "+responseString);
System.out.println("-----------------------------------------------------------------------------------------------------------");

}
@Test(priority =6)
public void GetAPITest4() throws JsonGenerationException, JsonMappingException, IOException {
restClient = new RestClient();
HashMap<String, String> headerMap = new HashMap<String, String>();
headerMap.put("Authorization", "bearer "+usersResObj);

closeableHttpResponse = restClient.get(url5, headerMap);// call the api

Header[] headersArray = closeableHttpResponse.getAllHeaders();

HashMap<String, String> allHeaders = new HashMap<String, String>();


for(Header header : headersArray) {
	allHeaders.put(header.getName(), header.getValue());
	
}

System.out.println("Header Array routingInstances-->"+allHeaders);

String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");


System.out.println("The response from get API routingInstances "+responseString);
System.out.println("-----------------------------------------------------------------------------------------------------------");

}
@Test(priority =7)
public void GetAPITest5() throws JsonGenerationException, JsonMappingException, IOException {
restClient = new RestClient();
HashMap<String, String> headerMap = new HashMap<String, String>();
headerMap.put("Authorization", "bearer "+usersResObj);

closeableHttpResponse = restClient.get(url6, headerMap);// call the api

Header[] headersArray = closeableHttpResponse.getAllHeaders();

HashMap<String, String> allHeaders = new HashMap<String, String>();


for(Header header : headersArray) {
	allHeaders.put(header.getName(), header.getValue());
	
}

System.out.println("Header Array networkPlanes-->"+allHeaders);

String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");


System.out.println("The response from get API networkPlanes "+responseString);
System.out.println("-----------------------------------------------------------------------------------------------------------");

}
@Test(priority =8)
public void GetAPITest6() throws JsonGenerationException, JsonMappingException, IOException {
restClient = new RestClient();
HashMap<String, String> headerMap = new HashMap<String, String>();
headerMap.put("Authorization", "bearer "+usersResObj);

closeableHttpResponse = restClient.get(url7, headerMap);// call the api

Header[] headersArray = closeableHttpResponse.getAllHeaders();

HashMap<String, String> allHeaders = new HashMap<String, String>();


for(Header header : headersArray) {
	allHeaders.put(header.getName(), header.getValue());
	
}

System.out.println("Header Array switches-->"+allHeaders);

String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");


System.out.println("The response from get API switches "+responseString);

}
}