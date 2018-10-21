package nz.ac.massey.cs.sdc.assign2.s15390549;

import java.io.IOException;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class StressTest {

	MemAppender object = MemAppender.getInstance();
	public static Logger testLogger = Logger.getLogger(" testLogger ");
	
	@org.junit.Test
	public void stressTest() {
		try {
			testLogger.addAppender(new FileAppender(new VelocityLayout(), "stressLogs.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i=0; i<10; i++) {
			testLogger.info("Test: " + i);
		}
	}
	
	@org.junit.Test
	public void linkedListTest() {
		
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
}
