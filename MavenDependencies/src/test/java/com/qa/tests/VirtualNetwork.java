package com.qa.tests;

import java.util.List;

public class VirtualNetwork {

	public int id;
	public String name;
	public Object type;
	//public String type;
	public int vlan;
	public int vni;
	public VirtualNetworkFabric fabric;
	public List<VirtualNetworkGroup> groups;
	public VirtualNetworksCustomer customer;
	public VirtualNetworkState state;
	public List<VirtualNetwork> items;
	public int virtualNetworkGroupId;
	public List<VirtualNetwork> networks;
	public int customerId;
	public int fabricId;
	public int managementVirtualNetworkId;
	public List<VirtualNetwork> computeNodeGroups;
	public VirtualNetworkHypervisor hypervisorType;
	
	

}
