package io.sqooba.sample_remote_logging;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleLoggerApp {
	private static Logger logger = LoggerFactory.getLogger(SampleLoggerApp.class);
	
	private static String[] logType = { "INFO", "DEBUG", "WARN", "ERROR" };
	
	private static String[] infoLogs = {
			"New user xxxxxxx added",
			"User Jayant details were updated",
			"User Jayant password changed"
	};

	private static String[] debugLogs = {
			"User cache is empty fetching users from DB to fill cache.",
			"File path not set using default file path.",
			"current list size 3."
	};
	
	private static String[] warnLogs = {
			"User attempted to delete admin user.",
			"5 login attempts failed for user Jayant with invalid password.",
			"Buffer is full, adding messages to kafka cache to process later."
	};
	
	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();
		while (true) {
			randomLog(random);
			Thread.sleep(random.nextInt(120000));
		}
	}

	private static void randomLog(final Random random) {
		
		switch (logType[random.nextInt(logType.length)]) {
		case "INFO":
			logger.info(infoLogs[random.nextInt(infoLogs.length)]);
			break;
		case "DEBUG":
			logger.debug(debugLogs[random.nextInt(debugLogs.length)]);
			break;
		case "WARN":
			logger.debug(warnLogs[random.nextInt(warnLogs.length)]);
			break;
		case "ERROR":
			randomErrorLog(random);
			break;
		default:
			break;
		}
	}

	private static void randomErrorLog(final Random random) {
		switch (random.nextInt(3)) {
		case 1:
			SampleLoggerApp sampleLoggerApp = null;
			try {
				sampleLoggerApp.addUser();
			} catch (Exception e) {
				logger.error("Error while adding user.", e);
			}			
			break;
		case 2:
			try{
				int i = 2/0;
			}catch (Exception e) {
				logger.error("Error while calculating.", e);
			}

		default:
			break;
		}

		
	}

	private void addUser() {
		// TODO Auto-generated method stub
		
	}
}
