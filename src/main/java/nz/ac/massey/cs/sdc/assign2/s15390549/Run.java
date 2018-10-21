package nz.ac.massey.cs.sdc.assign2.s15390549;

// branch velocity test

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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

		ArrayList<LoggingEvent> events = new ArrayList<LoggingEvent>();
		LinkedList<LoggingEvent> events1 = new LinkedList<LoggingEvent>();

		// Test to see if logs are saved to FileLoggers
		MemAppender obj0 = new MemAppender();			// WORKS
		MemAppender obj1 = new MemAppender(events1);	// WORKS
	
		System.out.print("(BEFORE) Current Logs: " + obj1.getCurrentLogs() + "\n\n");
		
		List<LoggingEvent> immuteTest = obj0.getCurrentLogs();
		
		// Test for Immutable List returned from "getCurrentLogs"
//		immuteTest.add(LoggingEvent);
		
		testLogger.info("test0");
		testLogger.info("test1");
		testLogger.info("test2");
		testLogger.info("test3");
		testLogger.info("test3\n");

		System.out.print("(AFTER) Current Logs: " + obj1.getCurrentLogs());

		// Test to see if discardedLogs works
		System.out.print("\n\nNumber of Discarded Logs: " + obj1.getDiscardedLogCount() + "\n\n");

		// Test to try to add to immutable list
//		immuteTest.add(LoggingEvent);
		
		System.out.println("(BEFORE) Mutable list from MemAppender(events) \"events\": " + events1);
		
		// Test to add to mutable list
		events1.add(LoggingEvent);
		events1.add(LoggingEvent1);

		System.out.println("(AFTER) Mutable list MemAppender(events) \"events\": " + events1);

	}

}
