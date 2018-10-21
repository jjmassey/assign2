package nz.ac.massey.cs.sdc.assign2.s15390549;

// branch velocity test

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

//import nz.ac.massey.cs.sdc.assign2.s15390549.MemAppender;

public class Run {

	private static final LoggingEvent LoggingEvent = null ;
	private static final LoggingEvent LoggingEvent1 = null ;

	public static Logger testLogger = Logger.getLogger("--> File");

	public static void main(String[] args) {

		BasicConfigurator.configure();

		List<LoggingEvent> events = new ArrayList<LoggingEvent>();
		List<LoggingEvent> immutablelist = Collections.unmodifiableList(events);


		// Test to see if logs are saved to FileLoggers
		MemAppender object = new MemAppender();			// WORKS
		MemAppender object1 = new MemAppender(events);	// WORKS
		
		MemAppender obj = object.getInstance();
		
		List<org.apache.log4j.spi.LoggingEvent> immuteTest = obj.getCurrentLogs();
	
		
//		MemAppender object = MemAppender.getInstance();

		testLogger.addAppender(obj);

		System.out.print("(BEFORE) Current Logs: " + obj.getCurrentLogs() + "\n\n");
		
		testLogger.info("test0");
		testLogger.info("test1");
		testLogger.info("test2");
		testLogger.info("test3");
		testLogger.info("test3\n");

		System.out.print("(AFTER) Current Logs: " + obj.getCurrentLogs());

		// Test to see if discardedLogs works
		System.out.print("\n\nNumber of Discarded Logs: " + obj.getDiscardedLogCount() + "\n");

		// Test to try to add to immutable list
//		immutablelist.add(LoggingEvent);
		
		System.out.println("Mutable list from MemAppender(events) \"events\": " + events);
		
		// Test to add to mutable list
		events.add(LoggingEvent);
		events.add(LoggingEvent1);

		System.out.println("Mutable list MemAppender(events) \"events\": " + events);

	}

}
