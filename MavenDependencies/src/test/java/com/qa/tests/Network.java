package com.qa.tests;

import java.util.List;

public class Network {

	public int id;
	public String name;
	public String ipv4Start;
	public String ipv4End;
	public String parentId;
	public int networkSize;
	public int totalIPs;
	public String assignedIPs;
	public String state;
	public boolean reserved;
	public NetworkType type;
	public List<Network> children;
	public List<Network> items;
	public List<SubNetwork> subnets;

}
