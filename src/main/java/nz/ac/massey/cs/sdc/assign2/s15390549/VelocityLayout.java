package nz.ac.massey.cs.sdc.assign2.s15390549;

import java.io.StringWriter;

import org.apache.log4j.spi.LoggingEvent;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class VelocityLayout extends org.apache.log4j.Layout{
	
	VelocityEngine ve = new VelocityEngine();
	VelocityContext context = new VelocityContext();
	StringWriter sw = new StringWriter();
	
	// constructor for pattern and if it doesn't have a pattern give it the pattern.
	
	public VelocityLayout() {
		// TODO Auto-generated constructor stub
	}

	public void activateOptions() {
		// TODO Auto-generated method stub
	}

	@Override
	public String format(LoggingEvent arg0) {
		
		return null;
	}

	@Override
	public boolean ignoresThrowable() {
		// TODO Auto-generated method stub
		return false;
	}

}