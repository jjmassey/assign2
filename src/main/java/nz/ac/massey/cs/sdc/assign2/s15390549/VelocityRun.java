package nz.ac.massey.cs.sdc.assign2.s15390549;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import nz.ac.massey.cs.sdc.assign2.s15390549.VelocityLayout;
import nz.ac.massey.cs.sdc.assign2.s15390549.MemAppender;

public class VelocityRun {

	public static Logger testLogger = Logger.getLogger(" testLogger ");
	
	public static void main(String[] args) throws IOException {
		
		BasicConfigurator.configure();
		
		// Parameter for testing VelocityLayout(pattern)
		String pattern = "Timestamp: ${d} ${p} [${t}] ${c} ${m}${n}";
		
//		MemAppender object = MemAppender.getInstance();
		testLogger.addAppender(new FileAppender(new VelocityLayout(pattern), "logs.txt"));
		testLogger.info("Test0");
		testLogger.info("Test1");
		
		
		
		
		
		
		testLogger.setLevel(Level.ALL);

	}

}
