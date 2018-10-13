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
<<<<<<< HEAD

	private static final LoggingEvent LoggingEvent = null;

	public static Logger fileLogger = Logger.getLogger("--> File");

	public static void main(String[] args) {

=======
	
	private static final LoggingEvent LoggingEvent = null ;
	private static final LoggingEvent LoggingEvent1 = null ;
	
	public static Logger testLogger = Logger.getLogger("--> File");
	
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
>>>>>>> master
		List<LoggingEvent> events = new ArrayList<LoggingEvent>();
		List<LoggingEvent> immutablelist = Collections.unmodifiableList(events);


		// Test to see if logs are saved to FileLoggers
		MemAppender object = MemAppender.getInstance();
<<<<<<< HEAD
		fileLogger.addAppender(object);

		fileLogger.info("transactions imported");
		fileLogger.info("test");
		fileLogger.info("test2");
		fileLogger.info("test3");

=======
		
		testLogger.addAppender(object);
		
		testLogger.info("test0");
		testLogger.info("test1");
		testLogger.info("test2");
		testLogger.info("test3\n");
		
>>>>>>> master
		System.out.print("Current Logs: " + object.getCurrentLogs());

		// Test to see if discardedLogs works
<<<<<<< HEAD
		System.out.print("\n\nNumber of Discarded Logs: " + object.getDiscardedLogCount());

		// Test to try to add to immutable list
//		immutablelist.add(LoggingEvent);

		// Test to add to mutable list
		events.add(LoggingEvent);

=======
		System.out.print("\n\nNumber of Discarded Logs: " + object.getDiscardedLogCount() + "\n");
		
		if (immutablelist.add(LoggingEvent)) {
			
		}
		
		// Test to try to add to immutable list
		immutablelist.add(LoggingEvent);
		
		// Test to add to mutable list
		events.add(LoggingEvent);
		events.add(LoggingEvent1);
		
		System.out.println("Mutable list \"events\": " + events);
		
>>>>>>> master
	}

}
