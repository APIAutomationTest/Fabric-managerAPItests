package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

public class GetAPITest extends TestBase{
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
	
	
	@BeforeMethod
	
	public void setUp () throws ClientProtocolException, IOException {
		testBase = new TestBase();
		 serviceUrl = prop.getProperty("URL");
		 apiUrl = prop.getProperty("serviceURL");
		
		 url = serviceUrl + apiUrl;
		
		
	}
	
	@Test
	public void getAPITest() throws ClientProtocolException, IOException {
	    restClient = new RestClient();
	    closeableHttpResponse = restClient.get(url);
		
		// status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Statuc Code-->"+statusCode);
		
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");
		
		// Json string
		String responseString =  EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		
		
		
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response JSON from API ---->"+responseJson);
		 
		
		//per.page:
		String perPageValue = TestUtil.getValueByJPath(responseJson,"/per_page");
		System.out.println("value of per page is -->"+ perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 3);
		
		
		
		// all headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		
		for(Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());
			
		}
		
		System.out.println("Header Array-->"+allHeaders);


	
	

}
}