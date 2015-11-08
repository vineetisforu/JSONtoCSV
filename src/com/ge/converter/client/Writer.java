package com.ge.converter.client;

import java.util.List;
import java.util.Properties;

public interface Writer {

	public void setup(Properties config);
	public List<Object> write(Object obj);
	
}
