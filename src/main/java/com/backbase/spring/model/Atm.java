package com.backbase.spring.model;

/**
 * Pojo class for Atm
 * 
 * @author wpjunior
 *
 */
public class Atm {
    String type;
    Address address;

    public Atm(){}
    public Atm(String type, Address address){
    	this.type=type;
    	this.address=address;
    	
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }
}
