package com.backbase.spring.model;

/**
 * Pojo class for Atm Address
 * 
 * @author wpjunior
 *
 */
public class Address {
    String street;
    String housenumber;
    String postalcode;
    String city;
    GeoLocation geoLocation;
    
    public Address(){}
    
    public Address(String street, String housenumber, String postalcode, String city){
    	this.street=street;
    	this.housenumber=housenumber;
    	this.postalcode=postalcode;
    	this.city=city;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public void setPostalCode(String postalcode) {
        this.postalcode = postalcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	public String getStreet() {
        return street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public String getCity() {
        return city;
    }
    
    public GeoLocation getGeoLocation() { 
    	return geoLocation; 
    }

}
