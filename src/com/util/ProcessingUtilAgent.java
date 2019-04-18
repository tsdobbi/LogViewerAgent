package com.util;

public class ProcessingUtilAgent {
	private static ProcessingUtilAgent plObj;

	private ProcessingUtilAgent() {

	}

	public static ProcessingUtilAgent getInstance() {
		if (plObj == null)
			plObj = new ProcessingUtilAgent();
		return plObj;
	}

	public String decodeDir(String dir) {

		dir = dir.replace("%2F", "//");

		return dir;

	}

}
