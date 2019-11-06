package com.sap.hcp.cf.sample;

import static com.sap.hcp.cf.logging.common.customfields.CustomField.customField;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.hcp.cf.logging.common.customfields.CustomField;

public class PickGreeting {
	private static Random random = new Random();
	private static boolean DO_SLEEP = Boolean.getBoolean("RANDOM_SLEEP");

	private static final String[] GREETINGS = new String[] { "Hello Stranger", "Bonjour!", "Nice to see you...",
			"At your service", "What a beautiful day!", "\u0c90 \u0ca0" };

	private static final Logger LOGGER = LoggerFactory.getLogger(PickGreeting.class);

	public static String pick() {
		if (DO_SLEEP) {
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (Exception ex) {
				LOGGER.error("Thread.sleep() failed", ex);
			}
		}
		String greeting = GREETINGS[random.nextInt(GREETINGS.length)];
		LOGGER.info("Picked greeting : {}", greeting);

		String teststring = "TESTSTRING";


		LOGGER.info("Logging with custom field {}", customField("customString", "myCustomString"));
		LOGGER.info("Logging with custom field {}", customField("customDouble", 12.34));
		LOGGER.info("Logging with custom field {}", customField("customInteger", 15));	
		
		
		LOGGER.debug("This is a debug message with attached string {}", teststring);
		LOGGER.info("This is an info message with attached string {}", teststring);
		LOGGER.warn("This is a warning message with attached string {}", teststring);
		LOGGER.error("This is an error message with attached string {}", teststring);

		return greeting;
	}
}
