package nz.ac.massey.cs.sdc.assign2.s15390549;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import nz.ac.massey.cs.sdc.assign2.s15390549.MemAppender;
import nz.ac.massey.cs.sdc.assign2.s15390549.VelocityLayout;

public class Test {
	
	// Create two instances of MemAppender
	MemAppender object = MemAppender.getInstance();
	MemAppender object1 = MemAppender.getInstance();
	
	
	// Singleton Pattern Test - ensure only one instance can be created 
	@org.junit.Test
	public void singletonTest() {
		assertTrue(object == object1);
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