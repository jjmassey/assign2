package nz.ac.massey.cs.sdc.assign2.s15390549;

import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.apache.log4j.PatternLayout;

public class StressTest {
	
	ArrayList<LoggingEvent> events1;
	LinkedList<LoggingEvent> events2;
	String velPattern;
	String patPattern;
	Date start;
	Date end;
	
	// Appenders
	private MemAppender object1;	
	private MemAppender object2;	
	private FileAppender fVelAppender;		// File Appender with Velocity Pattern Layout
	private FileAppender fPatAppender;		// File Appender with Pattern Layout
	private ConsoleAppender cVelAppender; 	// Console Appender with Velocity Pattern Layout
	private ConsoleAppender cPatAppender; 	// Console Appender with Pattern Layout
	
	// Loggers
	private Logger linkedListLogger;	// Logger for linked list
	private Logger arrayListLogger;		// Logger for array list
	private Logger cVelLogger;			// Logger - Console + Velocity Pattern
	private Logger cPatLogger;			// Logger - Console + Pattern
	private Logger fVelLogger;			// Logger - File + Velocity Pattern
	private Logger fPatLogger;			// Logger - File + Pattern
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BasicConfigurator.configure();
		
		// IMPORTANT! RESET singleton to null
		MemAppender.resetSingleton();
	}
	
	@Before
	public void setUp() throws Exception {
		
		velPattern = "Timestamp: ${d} ${p} [${t}] ${c} ${m}${n}";
		patPattern = "Timestamp: %d %p [%t] %c %m%n";
		events1 = new ArrayList<LoggingEvent>();
		events2 = new LinkedList<LoggingEvent>();
		start = new Date();
		
		// Appenders
		object1 = new MemAppender(events1);			// Array list
		object2 = new MemAppender(events2);			// Linked list
		fVelAppender = new FileAppender(new VelocityLayout(velPattern), "stressFileVelLogs.txt");
		fPatAppender = new FileAppender(new PatternLayout(patPattern), "stressFilePatLogs.txt");
		cVelAppender = new ConsoleAppender(new VelocityLayout(velPattern));
		cPatAppender = new ConsoleAppender(new PatternLayout(patPattern));
		
		// Loggers
		arrayListLogger = Logger.getLogger("---> Array list logger");
		linkedListLogger = Logger.getLogger("---> Linked list logger");
		fVelLogger = Logger.getLogger("---> File Velocity layout logger");
		fPatLogger = Logger.getLogger("---> File Pattern layout logger");
		cVelLogger = Logger.getLogger("---> Console Velocity layout logger");
		cPatLogger = Logger.getLogger("---> Console Pattern layout logger");

	}
	
	// MemAppender with Array List
	@org.junit.Test
	public void arrayList() throws IOException {
		arrayListLogger.addAppender(object1);
		System.out.println(start.toString());
		for (int i=0; i<1260000; i++) {
			arrayListLogger.info("Array Test: " + i);
		}
		end = new Date();
		System.out.println(end.toString());
	}
	
	// MemAppender with Linked List
	@org.junit.Test
	public void linkedList() throws IOException {
		linkedListLogger.addAppender(object1);
		System.out.println(start.toString());
		for (int i=0; i<1260000; i++) {
			linkedListLogger.info("Linked Test: " + i);
		}
		end = new Date();
		System.out.println(end.toString());
	}
	
	// Console Appender with Velocity Layout
	@org.junit.Test
	public void consoleVelocityPatternLayout() throws IOException {
		cVelLogger.addAppender(cVelAppender);
		System.out.println(start.toString());
		for (int i=0; i<2000; i++) {
			cVelLogger.info("Console + Velocity Test: " + i);
		}
		end = new Date();
		System.out.println(end.toString());
	}
	
	// Console Appender with Pattern Layout
	@org.junit.Test
	public void consolePatternLayout() throws IOException {
		cPatLogger.addAppender(cPatAppender);
		System.out.println(start.toString());
		for (int i=0; i<1000000; i++) {
			cPatLogger.info("Console + Pattern Test: " + i);
		}
		end = new Date();
		System.out.println(end.toString());
	}
	
	// Console Appender with Velocity Layout
	@org.junit.Test
	public void fileVelocityPatternLayout() throws IOException {
		fVelLogger.addAppender(fVelAppender);
		System.out.println(start.toString());
		for (int i=0; i<2000; i++) {
			fVelLogger.info("File + Velocity Test: " + i);
		}
		end = new Date();
		System.out.println(end.toString());
	}
	
	// Console Appender with Pattern Layout
	@org.junit.Test
	public void filePatternLayout() throws IOException {
		fPatLogger.addAppender(fPatAppender);
		System.out.println(start.toString());
		for (int i=0; i<1000000; i++) {
			fPatLogger.info("File + Pattern Test: " + i);
		}
		end = new Date();
		System.out.println(end.toString());
	}
	
	@After
	public void tearDown() throws Exception {
		object1 = null;
		object2 = null;
		events1 = null;
		events2 = null;
		arrayListLogger = null;
		linkedListLogger = null;
		fVelAppender = null;
		fPatAppender = null;
		cVelAppender = null;
		cPatAppender = null;
		fVelLogger = null;
		fPatLogger = null;
		cVelLogger = null;
		cPatLogger = null;
		start = null;
		end = null;
		assertNull(object1);
		assertNull(object2);
		assertNull(events1);
		assertNull(events2);
		assertNull(linkedListLogger);
		assertNull(arrayListLogger);
		assertNull(fVelAppender);
		assertNull(fPatAppender);
		assertNull(cVelAppender);
		assertNull(cPatAppender);
		assertNull(fVelLogger);
		assertNull(fPatLogger);
		assertNull(cVelLogger);
		assertNull(cPatLogger);
		assertNull(start);
		assertNull(end);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
}
