package awesomespider.significantAdvancements.Utils;

import awesomespider.significantAdvancements.SignificantAdvancements;

public class ExceptionUtil {

	public static String[] errorCodes = new String[]{
		"SAException-EMDIDx001",
		"SAException-EMDMDx002"
	};
	
	public static final String EXCEPTIONTEXT = "Please go to the minecraft forum thread, and post the following stacktrace and error code there.";
	
	/**
	 * Gets the recommended error message to send for an EMDID error (External Mod Dismantler Item Duplicate).
	 * @param modid - The mod causing the problem.
	 * @return The recommended error message.
	 * @since Version 0.0.1 - Granite
	 */
	public static String getErrorMessageEMDID(String modid){
		return "An external mod (" + modid + ") added a duplicate dismantler item. " + EXCEPTIONTEXT + "Error code: " + errorCodes[0];
	}
}
