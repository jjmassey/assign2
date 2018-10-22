package nz.ac.massey.cs.sdc.assign2.s15390549;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import nz.ac.massey.cs.sdc.assign2.s15390549.*;


public class Test {
	

	private MemAppender object;
	private MemAppender object1;
	private MemAppender object2;
	private MemAppender object3;
	private MemAppender object4;
	private FileAppender fAppender;
	private ConsoleAppender cAppender;
	List<LoggingEvent> immutableList;
	ArrayList<LoggingEvent> events1;
	LinkedList<LoggingEvent> events2;
	String pattern;
	private Logger testLogger;
	private Logger testLogger1;
	private Logger testLogger2;
	private final LoggingEvent LoggingEvent = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BasicConfigurator.configure();
		
		// IMPORTANT! RESET singleton to null
		MemAppender.resetSingleton();
	}
	
	@Before
	public void setUp() throws Exception {
		BasicConfigurator.configure();
		System.out.println("Setting it up!");
		object = new MemAppender();
		events1 = new ArrayList<LoggingEvent>();
		events2 = new LinkedList<LoggingEvent>();
		object1 = new MemAppender(events1);
		object2 = new MemAppender(events2);
		object3 = MemAppender.getInstance();
		object4 = MemAppender.getInstance();
		pattern = "Timestamp: ${d} ${p} [${t}] ${c} ${m}${n}";
		fAppender = new FileAppender(new VelocityLayout(pattern),"fileLogs.txt");
		cAppender = new ConsoleAppender(new VelocityLayout(pattern));
		immutableList = object.getCurrentLogs();
		testLogger = Logger.getLogger("---> Test logger");
		testLogger1 = Logger.getLogger("---> File logger");
		testLogger2 = Logger.getLogger("---> Console logger");
		
		
	}
	
	// LinkedList as parameter for MemAppender Test
	@org.junit.Test
	public void LinkedList() throws IOException {
		testLogger.addAppender(object1);
		assumeTrue(events1.size() == 0);
		testLogger.info("Linked list test");
		assertTrue(events1.size()==1);
		
	}
	
	// ArrayList as parameter for MemAppender Test
	@org.junit.Test
	public void ArrayList() throws IOException {
		testLogger.addAppender(object2);
		assumeTrue(events2.size() == 0);
		testLogger.info("Array list test");
		assertTrue(events2.size()==1);
		
	}
	
	// FileAppender with VelocityLayout Combination 
	@org.junit.Test
	public void fileAppender() throws IOException {
		testLogger1.addAppender(fAppender);
		testLogger1.info("File Appender Test");
		// WORKS - Can be found in the generated file fileLogs.txt
		// Don't know how to do a j unit test for this though??
	}
	
	// ConsoleAppender with VelocityLayout Combination 
	@org.junit.Test
	public void consoleAppender() throws IOException {
		testLogger2.addAppender(cAppender);
		testLogger2.info("Console Appender Test");
		System.out.println("######## Console Appender Test ########");
		// WORKS - Can be found within all the statements in the console!!
		// Don't know how to do a j unit test for this though??
	}
	
	// MemAppender wih INFO level Combination / getCurrentLogs Test
	@org.junit.Test
	public void infoLevel() throws IOException {
		testLogger.addAppender(object);
		assumeTrue(immutableList.size() == 0);
		testLogger.info("Info test");
		assertTrue(immutableList.size()==1);	
	}
	
	// MemAppender with WARN level Combination
	@org.junit.Test
	public void warnLevel() throws IOException {
		testLogger.addAppender(object);
		assumeTrue(immutableList.size() == 0);
		testLogger.warn("Warn test");
		assertTrue(immutableList.size()==1);	
	}
	
	// MemAppender with ERROR level Combination 
	@org.junit.Test
	public void errorLevel() throws IOException {
		testLogger.addAppender(object);
		assumeTrue(immutableList.size() == 0);
		testLogger.error("Error test");
		assertTrue(immutableList.size() == 1);	
	}
	
	// MemAppender with DEBUG level Combination 
	@org.junit.Test
	public void debugLevel() throws IOException {
		testLogger.addAppender(object);
		assumeTrue(immutableList.size() == 0);
		testLogger.debug("Debug test");
		assertTrue(immutableList.size() == 1);	
	}
	
	// Singleton Pattern Test - ensure only one instance can be created 
	@org.junit.Test
	public void singletonTest() {
		System.out.println("singletonTest");
		assertTrue(object3 == object4);
	}
	
	// Immutable List Test (METHOD 1) - ensure immutableList cannot be altered
	@org.junit.Test
	public void immutableTest1() {
		try{
				immutableList.add(LoggingEvent);
				System.out.println("ImmutableTest1 - Try");
			}catch(Exception e){
				System.out.println("ImmutableTest1 - Catch - [Exception: " + e + "]");
			 	assertTrue(true);
			}
	}
	
	// Immutable List Test (METHOD 2) - ensure immutableList cannot be altered
	@org.junit.Test(expected = UnsupportedOperationException.class)
	public void immutableTest2() throws Exception{
		System.out.println("immutableTest2");
		immutableList.add(LoggingEvent);
	}
	
	// maxSize test - (ASSUMING maxSize = 2;
	@org.junit.Test
	public void maxSize() {
		testLogger.addAppender(object);
		assumeTrue(object.getDiscardedLogCount() == 0);
		testLogger.debug("Log count test");
		testLogger.debug("Log count test");
		testLogger.debug("Log count Test");
		assertTrue(object.getDiscardedLogCount() == 1);
	}
	


	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		object = null;
		object1 = null;
		object2 = null;
		object3 = null;
		object4 = null;
		events1 = null;
		events2 = null;
		fAppender = null;
		cAppender = null;
		testLogger = null;
		testLogger1 = null;
		testLogger2 = null;
		immutableList = null;
		assertNull(object);
		assertNull(object1);
		assertNull(object2);
		assertNull(object3);
		assertNull(object4);
		assertNull(events1);
		assertNull(events2);
		assertNull(fAppender);
		assertNull(cAppender);
		assertNull(testLogger);
		assertNull(testLogger1);
		assertNull(testLogger2);
		assertNull(immutableList);
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
}
