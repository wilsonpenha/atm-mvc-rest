package com.backbase.spring.service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.backbase.spring.model.Address;
import com.backbase.spring.model.Atm;
import com.backbase.spring.model.GeoLocation;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ResponseServiceImpl define the main methods to retrive the ING ATM's JSON object and also to filter by a specific city
 * 
 * @author wpjunior
 *
 */
@Component
public class ResponseServiceImpl {

	
	private static final Logger log = Logger.getLogger(ResponseServiceImpl.class);
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONArray retrieveAtmsFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);

            //here we have to clean the JSON - the JSON from this web service is not formatted correctly
            jsonText = fixJsonText(jsonText);
            JSONArray json = new JSONArray(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public String fixJsonText (String JSON) {
        // Removing a garbage chars from ING JSON in the begin of it "})],"
        String fixedJson = JSON.substring(JSON.indexOf("["));
        return fixedJson;
    }

    public ArrayList<Atm> retrieveATMs(HashMap<String,String> filter){

        JSONArray json;
        ArrayList<Atm> atms = new ArrayList<Atm>();

        try {
			json = retrieveAtmsFromUrl("https://www.ing.nl/api/locator/atms/");
	
	        for (int i = 0; i < json.length(); i++) {
	            JSONObject atmJson = json.getJSONObject(i);
	            Atm atm = new Atm();
	            Address address = new Address();
	            JSONObject addressJson = atmJson.getJSONObject("address");
	            atm.setType(atmJson.getString("type"));
	
	            address.setCity(addressJson.getString("city"));
	            address.setStreet(addressJson.getString("street"));
	            address.setHouseNumber(addressJson.getString("housenumber"));
	            address.setPostalCode(addressJson.getString("postalcode"));
	
	            GeoLocation geoLocation = new GeoLocation();
	            JSONObject geo = addressJson.getJSONObject("geoLocation");
	            try{
		            geoLocation.setLat(geo.getString("lat"));
		            geoLocation.setLng(geo.getString("lng"));
	    		} catch (JSONException e) {
	    			// do nothing if some address has no geo location metadata.
	    		}	            
	            address.setGeoLocation(geoLocation);
	            atm.setAddress(address);
	            
	            if (filter.get("searchBy").equalsIgnoreCase("all")) {
	            	// only load valid atm with city data
	            	if (atm.getAddress().getCity()!=null && !atm.getAddress().getCity().isEmpty())
	            		atms.add(0,atm);
	            } else if (filter.get("searchBy").equalsIgnoreCase("city")) {
	                if (address.getCity().equalsIgnoreCase(filter.get("value"))) {
	                    atms.add(0,atm);
	                }
	            }
	
	        }
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


        return atms;
    }

    public ArrayList<Atm> getATMsByCity(String city){
        HashMap<String, String> filter = new HashMap<String, String>();
        filter.put("searchBy","city");
        filter.put("value",city);
        return retrieveATMs(filter);
    }

    public ArrayList<Atm> getATMs(){
        HashMap<String, String> filter = new HashMap<String, String>();
        filter.put("searchBy","all");
        filter.put("value","");
        return retrieveATMs(filter);
    }

}
