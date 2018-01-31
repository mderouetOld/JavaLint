package utility;

public class OSUtils {

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
	}

	public static boolean isSolaris() {
		return (OS.indexOf("sunos") >= 0);
	}

	public static String getOS() {
		if (isWindows()) {
			return "win";
		} else if (isMac()) {
			return "osx";
		} else if (isUnix()) {
			return "uni";
		} else if (isSolaris()) {
			return "sol";
		} else {
			return "err";
		}
	}

	public static String extractFileNameFromPath(String path) {
		Integer lastIndexSlash = null;
		if (isMac()) {
			lastIndexSlash = path.lastIndexOf("/");
		}
		if (isWindows()) {
			lastIndexSlash = path.lastIndexOf("\\");
		}
		return (path.substring(lastIndexSlash + 1, path.length()));
	}
	
	public static String windowsToLinuxPath(String windowsPath) {
		return windowsPath.replace("\\", "/");
	}
	public static String linuxToWindowsPath(String linuxPath) {
		return linuxPath.replace("/", "\\");
	}
}