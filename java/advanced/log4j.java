package advanced;

import java.util.Properties;
import org.apache.log4j.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ReporterConfig.Property;
import org.apache.log4j.Logger;
/**
 * Trace
 * Debug
 * Info
 * Warn
 * Error
 * Fatal
 * @author 30196083
 *
 */

public class log4j {
	static Logger log = Logger.getLogger(log4j.class);

	public static void main(String[] args) {
		
		 //BasicConfigurator.configure();
		 
		
		/*Properties log4jprop = new Properties();
		log4jprop.setProperty("log4j.rootLogger", "DEBUG, CA");
		log4jprop.setProperty("log4j.appender.CA", "org.apache.log4j.ConsoleAppender");
		log4jprop.setProperty("log4j.appender.CA.layout", "org.apache.log4j.PatternLayout");
		log4jprop.setProperty("log4j.appender.CA.layout.ConversionPattern" , "%d{yyyy-MM-dd} -- %10p %c[0] - %m%n");
		*/
		//Using file
		
		PropertyConfigurator.configure("log4j.properties");
		
		
		
		
		log.setLevel(Level.ALL);
		
		log.debug("This is a debug");

		log.info("This msg is a info");
		runMethod();
		log.debug("This is a debug");
		

	}
	public static void runMethod(){
		log.error("This info message is from runMethod");
	}

}
