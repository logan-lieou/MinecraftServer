// This code would be added somewhere in the plugin

import java.io.IOException;

class basic_execute {
	private static String OS = null;

	public static void main(String[] args) throws IOException {

		// Conditional statement based on OS
		if (isWindows() == true) {
			Process g = new ProcessBuilder("cmd.exe", "dir").start();
		}

		else {
			Process p = new ProcessBuilder("touch", "file.exe").start();	
		}

	}

	private static String getOsName() {
		if(OS == null) { OS = System.getProperty("os.name"); }
		return OS;
	}

	// Method to determine the host OS
	private static boolean isWindows() {
		if (getOsName().startsWith("Windows")) {
			return true;
		}
		else {
			return false;
		}
	}
}

