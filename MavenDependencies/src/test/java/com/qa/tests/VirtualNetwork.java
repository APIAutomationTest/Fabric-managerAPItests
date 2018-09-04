package com.qa.tests;

import java.util.List;

public class VirtualNetwork {

	public int id;
	public String name;
	public VirtualNetworkstype type;

	public int vlan;
	public int vni;
	public VirtualNetworkFabric fabric;
	public List<VirtualNetworkGroup> groups;
	public VirtualNetworksCustomer customer;
	public VirtualNetworkState state;
	public List<VirtualNetwork> items;

}