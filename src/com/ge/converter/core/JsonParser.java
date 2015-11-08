package com.ge.converter.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ge.converter.client.Parser;
import com.ge.converter.misc.CommonFunction;

public class JsonParser implements Parser {

	Properties config;
	
	@Override
	public void setup(Properties config) {

		this.config = config;
		
	}

	@Override
	public List<Object> parse() {

		List<Object> cities = new ArrayList<Object>();
		Map<String, String> city = new HashMap<String, String>();
		
		 try {
				JSONArray arr = new JSONArray(CommonFunction.sendGet(config.get("api").toString()));
				
				for(int i =0;i<arr.length();i++) {

					JSONObject jobj = (JSONObject)arr.get(i);

					Iterator iter =jobj.keys();
					
					while(iter.hasNext()) {
						
						Object key = iter.next();
						
						if(jobj.get(key.toString()) instanceof JSONObject) {
							
							JSONObject jobj2 = (JSONObject)jobj.get(key.toString());

							Iterator iter2 =jobj2.keys();
							
							while(iter2.hasNext()) {
								
								Object key2 = iter2.next();
								city.put(key2.toString(), jobj2.get(key2.toString()).toString());
//								System.out.println( key2 + ":" + jobj2.get(key2.toString()));
							}
						}
						else
							city.put(key.toString(), jobj.get(key.toString()).toString());
//								System.out.println(key + ":" + jobj.get(key.toString()));
					}
					
					cities.add(city);
					city = new HashMap<String, String>();
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return cities;
		
		
	}

}
