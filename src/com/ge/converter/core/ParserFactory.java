package com.ge.converter.core;

import com.ge.converter.client.Parser;
import com.ge.converter.misc.CommonFunction;

public class ParserFactory {

	public static Parser getParserInstance(String type) {
		
		Parser parser = null;
		
		if(type.equalsIgnoreCase("json")) {
			parser = new JsonParser();
			parser.setup(CommonFunction.prop);
		}
		
		return parser;
	}
	
}
