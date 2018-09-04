package com.qa.base;

import java.util.Random;

public class TestHelper {
	/**
	 * Generates a random string with the given {@param length}.
	 */
	public static String randomString(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int randomChar = 98 + random.nextInt(26);
			sb.append((char) randomChar);
		}
		return sb.toString();
	}
	
	public static int randomInt(int upperLimit) {
		return (new Random()).nextInt(upperLimit);
	}
}
