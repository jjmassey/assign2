package nz.ac.massey.cs.sdc.assign2.s15390549;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class MemAppender extends AppenderSkeleton {
	
	private List<LoggingEvent> events;
	
	// Maxsize variable for testing
	// CHANGED THIS DESPENDING ON WHAT I WAS USING
	// MaxSize for stressTest.java - Linked List and Array List maxSize = 12600000
	// MaxSize for stressTest.java - File and Console Appenders with Layouts maxSize = 
	// MaxSize for Test.java - maxSize = 2
	private int maxSize = 2;
	
	private int discardedLogCount = 0;
	
	// Singleton Pattern
	private static MemAppender instance = new MemAppender();
	
	// I have made this public so I can use them in my tests
    // The singleton method appears to still work even though they are public. If someone tries to initialise another instance it will throw an error
    public MemAppender(){
    	if (instance != null) {
            throw new IllegalStateException("Already instantiated");
        }
    	this.events = new ArrayList<>();
    }
    
    // I have made this public so I can use them in my tests
    // The singleton method appears to still work even though they are public. If someone tries to initialise another instance it will throw an error
	public MemAppender(ArrayList<LoggingEvent> eventsList){
		if (instance != null) {
            throw new IllegalStateException("Already instantiated");
        }
    	this.events = eventsList;
    }
	
	// I have made this public so I can use them in my tests
    // The singleton method appears to still work even though they are public. If someone tries to initialise another instance it will throw an error
	public MemAppender(LinkedList<LoggingEvent> eventsList){
		if (instance != null) {
            throw new IllegalStateException("Already instantiated");
        }
    	this.events = eventsList;
    }
	
	// Called to reset singleton to a null value
	public static void resetSingleton() {
		   instance = null;
		}
    
    //Get the only object available
    public static MemAppender getInstance(){
    	return instance;
   }
	
	public long getDiscardedLogCount() {
		return discardedLogCount;
	}
	
	protected void append(LoggingEvent event) {
		if (events.size() == maxSize) {
			events.remove(events.get(0));
			discardedLogCount += 1;
		}
		events.add(event);
		return;
	}
	
	// Get current logs returns Unmodifiable list
	public List<LoggingEvent> getCurrentLogs() {
		List<LoggingEvent> immutablelist = Collections.unmodifiableList(events);
		return immutablelist;
	}
	
	public void close() {}
	
	public boolean requiresLayout() {
		return false;
	}
}
