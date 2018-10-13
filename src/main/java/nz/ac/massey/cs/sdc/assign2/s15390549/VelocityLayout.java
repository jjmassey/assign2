package nz.ac.massey.cs.sdc.assign2.s15390549;

import java.io.StringWriter;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class VelocityLayout extends org.apache.log4j.Layout{
	
	VelocityEngine ve = new VelocityEngine();
	VelocityContext context = new VelocityContext();
	StringWriter sw = new StringWriter();
	
	// constructor for pattern and if it doesn't have a pattern give it the pattern.
//	String pattern = "$p [$t] $c $d $m$n";
	
//	String velocityPattern = 
	
	public VelocityLayout(String pattern) {
		if (pattern == null) {
			pattern = "$p [$t] $c $d $m$n";
		}
		pattern = "$p [$t] $c $d $m$n";
	}

	public void activateOptions() {
		// TODO Auto-generated method stub
	}

	@Override
	public String format(LoggingEvent event) {
		String c = event.getLoggerName();
		String d = event.toString();
		Object m = event.getMessage();
		Level p = event.getLevel();
		String t = event.getThreadName();
		String n = "\n" ;
		String formatted = (p + "[" + t + "]" + c + d + m + n);
		return formatted;
	}

	@Override
	public boolean ignoresThrowable() {
		// TODO Auto-generated method stub
		return false;
	}

}