package com.ilp.entity;

public class Services {
    private String  serviceCode;
    private String  serviceName;
    private double  rate;
	public String getServiceCode() {
		return serviceCode;
	}
	public Services(String serviceCode, String serviceName, double rate) {
		super();
		this.serviceCode = serviceCode;
		this.serviceName = serviceName;
		this.rate = rate;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
} 