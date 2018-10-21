package nz.ac.massey.cs.sdc.assign2.s15390549;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import nz.ac.massey.cs.sdc.assign2.s15390549.MemAppender;
//import nz.ac.massey.cs.sdc.assign2.s15390549.VelocityLayout;

public class Test {
	
	// Do we need this?	
//	BasicConfigurator.configure();
	
	// Create two instances of MemAppender
	MemAppender object = MemAppender.getInstance();
	MemAppender object1 = MemAppender.getInstance();
	
	// Use getCurrentLogs() to return an immutable list
	List<LoggingEvent> immutableList = object.getCurrentLogs();
	
	// Create a mutable list
	ArrayList<LoggingEvent> events = new ArrayList<LoggingEvent>();
	
	// Create an instance of a logging event
	private static final LoggingEvent LoggingEvent = null;
	private static final LoggingEvent LoggingEvent1 = null;
	private static final LoggingEvent LoggingEvent2 = null;
	
	// Create a logger - testLogger
	public static Logger testLogger = Logger.getLogger("--> File");
	
	
	
	// Singleton Pattern Test - ensure only one instance can be created 
	@org.junit.Test
	public void singletonTest() {
		// Create two instances of MemAppender
		MemAppender object = MemAppender.getInstance();
		MemAppender object1 = MemAppender.getInstance();
		System.out.println("singletonTest");
		assertTrue(object == object1);
	}
	
	// Immutable List Test (METHOD 1) - ensure immutableList cannot be altered
	@org.junit.Test
	public void immutableTest1() {
		MemAppender object = MemAppender.getInstance();
		List<LoggingEvent> immutableList = object.getCurrentLogs();
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
		MemAppender object = new MemAppender(events);
		testLogger.addAppender(object);
		assumeTrue(object.getDiscardedLogCount() == 0);
		testLogger.info("test0");
		testLogger.info("test1");
		testLogger.info("test2");
		assertTrue(object.getDiscardedLogCount() == 1);
	}
				
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BasicConfigurator.configure();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// == same identity, or .equals
}