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
		MemAppender object = MemAppender.getInstance();

		testLogger.addAppender(object);

		testLogger.info("test0");
		testLogger.info("test1");
		testLogger.info("test2");
		testLogger.info("test3\n");

		System.out.print("Current Logs: " + object.getCurrentLogs());

		// Test to see if discardedLogs works
		System.out.print("\n\nNumber of Discarded Logs: " + object.getDiscardedLogCount() + "\n");

		// Test to try to add to immutable list
<<<<<<< HEAD
		// immutablelist.add(LoggingEvent);
=======
//		immutablelist.add(LoggingEvent);
>>>>>>> velocity

		// Test to add to mutable list
		events.add(LoggingEvent);
		events.add(LoggingEvent1);

		System.out.println("Mutable list \"events\": " + events);

	}

}
