package nz.ac.massey.cs.sdc.assign2.s15390549;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import nz.ac.massey.cs.sdc.assign2.s15390549.VelocityLayout;

public class VelocityRun {

	public static Logger testLogger = Logger.getLogger("--> File");
	
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		MemAppender object = MemAppender.getInstance();
		testLogger.addAppender(object);
		
		testLogger.setLevel(Level.ALL);

	}

}
