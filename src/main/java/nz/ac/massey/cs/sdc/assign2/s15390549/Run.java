package nz.ac.massey.cs.sdc.assign2.s15390549;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

import nz.ac.massey.cs.sdc.assign2.s15390549.MemAppender;

public class Run {
	
	private static final LoggingEvent LoggingEvent = null;
	
	public static Logger fileLogger = Logger.getLogger("--> File");
	
	public static void main(String[] args) {
		
		List<LoggingEvent> events = new ArrayList<LoggingEvent>();
		List<LoggingEvent> immutablelist = Collections.unmodifiableList(events);
		
		
		// Test to see if logs are saved to FileLoggers
		MemAppender object = MemAppender.getInstance();
		fileLogger.addAppender(object);
		
		fileLogger.info("transactions imported");
		fileLogger.info("test");
		fileLogger.info("test2");
		fileLogger.info("test3");
		
		System.out.print(object.getCurrentLogs());
		
		// Test to see if discardedLogs works
		System.out.print(object.getDiscardedLogCount());
		
		// Test to try to add to immutable list
//		immutablelist.add(LoggingEvent);
		
		// Test to add to mutable list
		events.add(LoggingEvent); 
		
	}

}
