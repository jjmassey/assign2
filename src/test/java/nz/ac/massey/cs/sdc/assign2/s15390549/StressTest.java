package nz.ac.massey.cs.sdc.assign2.s15390549;

import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class StressTest {
	
	ArrayList<LoggingEvent> events1;
	LinkedList<LoggingEvent> events2;
	private MemAppender object;
	private MemAppender object1;
	private MemAppender object2;
	private Logger testLogger;
	private Logger linkedListLogger;
	private Logger arrayListLogger;
	Date start;
	Date end;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BasicConfigurator.configure();
	}
	
	@Before
	public void setUp() throws Exception {
		object = MemAppender.getInstance();
		events1 = new ArrayList<LoggingEvent>();
		events2 = new LinkedList<LoggingEvent>();
		object1 = new MemAppender(events1);			// Array list
		object2 = new MemAppender(events2);			// Linked list
		arrayListLogger = Logger.getLogger("---> Array list logger");
		linkedListLogger = Logger.getLogger("---> Linked list logger");
		start = new Date();
		end = new Date();
	}
	
	@org.junit.Test
	public void arrayList() throws IOException {
		arrayListLogger.addAppender(object1);
		System.out.println(start.toString());
		for (int i=0; i<100; i++) {
			arrayListLogger.info("Array Test: " + i);
		}
		System.out.println(end.toString());
	}
	
	@org.junit.Test
	public void linkedList() throws IOException {
		linkedListLogger.addAppender(object1);
		System.out.println(start.toString());
		for (int i=0; i<100; i++) {
			linkedListLogger.info("Linked Test: " + i);
		}
		System.out.println(end.toString());
	}
	
	@After
	public void tearDown() throws Exception {
		object = null;
		object1 = null;
		object2 = null;
		events1 = null;
		events2 = null;
		testLogger = null;
		arrayListLogger = null;
		linkedListLogger = null;
		start = null;
		end = null;
		assertNull(object);
		assertNull(object1);
		assertNull(object2);
		assertNull(events1);
		assertNull(events2);
		assertNull(testLogger);
		assertNull(linkedListLogger);
		assertNull(arrayListLogger);
		assertNull(start);
		assertNull(end);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
}
