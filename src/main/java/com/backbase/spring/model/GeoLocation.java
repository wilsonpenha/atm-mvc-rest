package com.backbase.spring.model;

/**
 * Pojo class for GeoLocation
 * 
 * @author wpjunior
 *
 */
public class GeoLocation {
    String lat;
    String lng;

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() { return lat; }

    public String getLng() { return lng;}
} 
