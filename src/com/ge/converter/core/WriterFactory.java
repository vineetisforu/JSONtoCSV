package com.ge.converter.core;

import com.ge.converter.client.Writer;
import com.ge.converter.misc.CommonFunction;

public class WriterFactory {

	public static Writer getWriterInstance(String type) {
		
		Writer writer = null;
		
		if(type.equalsIgnoreCase("csv")) {
			
			writer = new CSVWriter();
			writer.setup(CommonFunction.prop);
			
		}
		
		return writer;
		
	}
}
