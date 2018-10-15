package nz.ac.massey.cs.sdc.assign2.s15390549;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class MemAppender extends AppenderSkeleton {
	
	private List<LoggingEvent> events;
	private int maxSize = 2;
	private int discardedLogCount = 0;
	// Singleton Pattern
	
	private static final MemAppender instance = new MemAppender();
	
    public MemAppender(){
    	if (instance == null) {
    		this.events = new ArrayList<>();
        }
    	this.events = new ArrayList<>();
    }
    
    private MemAppender(List<LoggingEvent> eventsList){
    	if (instance == null) {
            this.events = eventsList;
        }
    	this.events = eventsList;
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
