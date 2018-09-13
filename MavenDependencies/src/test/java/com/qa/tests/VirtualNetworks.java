package com.qa.tests;

import java.util.List;

public class VirtualNetworks {
	public Integer id;
	public String name;
	public Integer vlan;
	public Integer vni;
	public Object type;
	public List<VirtualNetwork> items;
    public List<VirtualNetwork> networks;
    public Integer customerId;
	public Integer fabricId;
	public VirtualNetworkState state;
	public Integer managementVirtualNetworkId;
	public List<VirtualNetwork> computeNodeGroups;
	public VirtualNetworksCustomer customer;
	public VirtualNetworkFabric fabric;
	
	public static class Id {

	}

}
