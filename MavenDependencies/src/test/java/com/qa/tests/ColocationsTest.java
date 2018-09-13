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
import com.qa.util.TestUtil;

public class ColocationsTest extends TestBase<Colocations, Object> {
	private static String colocationPortTypes = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_colocationPortTypes");
	private static String colocationCapacity = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL-colocationCapacity");
	private static String colocationSwitch = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_colocationSwitch");
	
	private static String colocationports = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_colocationports");
	private static String colocationportspeed = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_colocationportspeed");
	
	public ColocationsTest() {
		super(Colocations.class, Object.class);
	}

	@Test
	public void getColocations() throws ClientProtocolException, IOException {
		Colocations response = super.get(colocationPortTypes);
	
		// 1. Has return value
		Assert.assertNotNull(response);
		// 2. Has non-empty name
		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).name);
		Assert.assertTrue(response.items.get(0).name.length() > 0);		
				
		// 4. get the value from Json Array 

		int id = (response.items.get(0).id);
		String name = (response.items.get(0).name); 
		int id1 = (response.items.get(1).id);
		String name1 = (response.items.get(1).name);
         System.out.println(id); 
         System.out.println(name); 
         System.out.println(id1); 
         System.out.println(name1); 
		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}

	@Test
	public void getColocationsCapacity() throws ClientProtocolException, IOException {
		Colocations response = super.get(colocationCapacity);
		
		// 1. Has return value
		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).name);
		Assert.assertTrue(response.items.get(0).name.length() > 0);	
		
		// 4. get the value from Json Array 
		int id = (response.items.get(0).id);
		String name = (response.items.get(0).name); 
		int switchId = (response.items.get(0).switches.get(0).switchId); 
		String switchName = (response.items.get(0).switches.get(0).switchName); 
		String IP = (response.items.get(0).switches.get(0).IP); 
		String macAddress = (response.items.get(0).switches.get(0).macAddress); 
		int speedId = (response.items.get(0).speeds.get(0).speedId); 
		String speedName = (response.items.get(0).speeds.get(0).speedName); 
		int totalPorts = (response.items.get(0).speeds.get(0).totalPorts); 
		int availablePorts = (response.items.get(0).speeds.get(0).availablePorts); 
		int usedPorts = (response.items.get(0).speeds.get(0).usedPorts);
		
        System.out.println(id); 
        System.out.println(name); 
        System.out.println(switchId);  
        System.out.println(switchName); 
        System.out.println(IP);
        System.out.println(macAddress); 
        System.out.println(speedId); 
        System.out.println(speedName);
        System.out.println(totalPorts);
        System.out.println(availablePorts);
        System.out.println(usedPorts);
		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}

	@Test
	public void getColocationsSwitch() throws ClientProtocolException, IOException {
		Colocations response = super.get(colocationSwitch);
		
		// 1. Has return value
		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).name);
		Assert.assertTrue(response.items.get(0).name.length() > 0);		

		// 4. get the value from Json Array 

		int id = (response.items.get(0).id);
		String name = (response.items.get(0).name); 
        System.out.println(id); 
        System.out.println(name); 

		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}
	@Test
	public void getColocationsports() throws ClientProtocolException, IOException {
		Colocations response = super.get(colocationports);
		
		// 1. Has return value
		Assert.assertNotNull(response);


		

		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}
	@Test
	public void getColocationsportspeed() throws ClientProtocolException, IOException {
		
		Colocations response = super.get(colocationportspeed);
		
		// 1. Has return value
		Assert.assertNotNull(response);

		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).type);
		Assert.assertTrue(response.items.get(0).type.length() > 0);		
		
		// 4. get the value from Json Array 

		int id = (response.items.get(0).id);
		String portType = (response.items.get(0).portType); 
		int speedId = (response.items.get(0).speedId);
		String speed = (response.items.get(0).speed);
		String type = (response.items.get(0).type);
		int id1 = (response.items.get(1).id);
		String portType1 = (response.items.get(1).portType); 
		int speedId1 = (response.items.get(1).speedId);
		String speed1 = (response.items.get(1).speed);
		String type1 = (response.items.get(1).type);
		System.out.println(id); 
		System.out.println(portType); 
		System.out.println(speedId); 
		System.out.println(speed); 
		System.out.println(type); 
		System.out.println(id1); 
		System.out.println(portType1); 
		System.out.println(speedId1); 
		System.out.println(speed1); 
		System.out.println(type1); 
		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}
}



