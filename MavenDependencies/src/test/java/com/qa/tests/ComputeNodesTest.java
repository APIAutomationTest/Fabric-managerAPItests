package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class ComputeNodesTest extends TestBase<ComputeNodes, Object> {
	private static String computeNodes = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_computeNodes");
	private static String computeNodesSpecifications = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_computeNodesSpecifications");
	private static String ComputeHypervisor = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_ComputeHypervisor");
	private static String computeSpecificationsId = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_computeSpecificationsId");
	


	public ComputeNodesTest() {
		super(ComputeNodes.class, Object.class);
	}

	@Test
	public void getComputeNodes() throws ClientProtocolException, IOException {
		ComputeNodes response = super.get(computeNodes);

		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).name);
		Assert.assertTrue(response.items.get(0).name.length() > 0);		

		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}

	@Test
	public void getComputeNodesSpecifications() throws ClientProtocolException, IOException {
		ComputeNodes response = super.get(computeNodesSpecifications);

		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).name);
		Assert.assertTrue(response.items.get(0).name.length() > 0);		

		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}

	@Test
	public void getComputeHypervisor() throws ClientProtocolException, IOException {
		ComputeNodes response = super.get(ComputeHypervisor);

		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).name);
		Assert.assertTrue(response.items.get(0).name.length() > 0);		

		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}
	@Test
	public void getComputespecificationId() throws ClientProtocolException, IOException {
		ComputeNodes response = super.get(computeSpecificationsId);
		
		Assert.assertNotNull(response);

		
		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}
}
