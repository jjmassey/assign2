package nz.ac.massey.cs.sdc.assign2.s15390549;

import java.io.StringWriter;

import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

public class VelocityLayout extends Layout{
	
	String pattern;
	
	public VelocityLayout() {
		this.pattern = "${p} [${t}] ${c} Timestamp: ${d} ${m}${n}";
	}
	
	public VelocityLayout(String pattern) {
		if (pattern.equals(" ")) {
			this.pattern = "${p} [${t}] ${c} Timestamp: ${d} ${m}${n}";
		}
		else {
			this.pattern = pattern;
		}
	}
	

	public void activateOptions() {
		// TODO Auto-generated method stub
	}

	@Override
	public String format(LoggingEvent event) {
		
		VelocityEngine ve = new VelocityEngine();
		ve.init();
		VelocityContext context = new VelocityContext();
		StringWriter sw = new StringWriter();
		
		String c = event.getLoggerName();	// e.g File (Appender) "--> testLogger -->"
		long d = event.getTimeStamp();		// e.g "1539824883398"
		Object m = event.getMessage();		// e.g Test0 - testLogger.info("Test0")
		Level p = event.getLevel();			// e.g INFO, DEBUG, WARN
		String t = event.getThreadName();	// e.g [main]
		String n = "\n" ;
		context.put("c", c);
		context.put("d", d);
		context.put("m", m);
		context.put("p", p);
		context.put("t", t);
		context.put("n", n);
		ve.evaluate(context, sw, "", pattern);
		
		return sw.toString();	// return formatted or return event or context or pattern?
	}

	@Override
	public boolean ignoresThrowable() {
		// TODO Auto-generated method stub
		return false;
	}

}