package com.ge.converter.driver;

import java.util.List;

import com.ge.converter.client.Parser;
import com.ge.converter.client.Writer;
import com.ge.converter.core.ParserFactory;
import com.ge.converter.core.WriterFactory;
import com.ge.converter.misc.CommonFunction;

public class Invoker {

	public static void main(String[] args) {
		
		CommonFunction common = new CommonFunction();
		
		Parser parser = ParserFactory.getParserInstance(common.prop.getProperty("parser"));
		List<Object> cities = parser.parse();
		
		Writer writer = WriterFactory.getWriterInstance(common.prop.getProperty("writer"));
		
		writer.write(cities);
		
	}
}
