package com.ge.converter.core;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.ge.converter.client.Writer;

public class CSVWriter implements Writer{

	Properties config;
	
	@Override
	public void setup(Properties config) {
		
		this.config = config;
		
	}

	@Override
	public List<Object> write(Object obj) {
		
		List<Object> cities = (List<Object>)obj;
		StringBuffer buffer = new StringBuffer();
		String str = "";
		Set<String> keyset = new LinkedHashSet<String>();
		
		for(String key: ((Map<String, String>)cities.get(0)).keySet()) {
			
//			buffer.append(key + config.getProperty("delim"));
			str += key + config.getProperty("delim");
			keyset.add(key);
		}
		
		str = str.substring(0, str.length()-config.getProperty("delim").length());
		buffer.append(str + "\n");
		str = "";
		
		for(int i =0; i<cities.size(); i++) {
			
			Map<String, String> city = (Map<String, String>)cities.get(i);
			
			for(String key: keyset) {

				str += city.get(key) + config.getProperty("delim");
				
			}
			
			str = str.substring(0, str.length()-config.getProperty("delim").length());
			buffer.append(str + "\n");
			str = "";
		}
		
		System.out.println(buffer.toString());
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(config.getProperty("output"), "UTF-8");
			writer.println(buffer);
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
