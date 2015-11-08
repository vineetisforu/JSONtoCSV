package com.ge.converter.client;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public interface Parser {

	public void setup(Properties config);
	public List<Object> parse();
	
}
