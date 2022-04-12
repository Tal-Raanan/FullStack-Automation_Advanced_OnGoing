package utilities;

// Class Name: Logger
// Class Description: This class initializes the logger
public class Logger extends CommonOps {

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class.getName());

    // Method Name: fatal
    // Method Description: This method documented fatal logs
    // Method Parameters: String
    // Method Return: String
    public static void fatal (String msg) {
        logger.fatal(msg);
    }

    // Method Name: error
    // Method Description: This method documented error logs
    // Method Parameters: String
    // Method Return: String
    public static void error (String msg) {
        logger.error(msg);
    }

    // Method Name: warn
    // Method Description: This method documented warn logs
    // Method Parameters: String
    // Method Return: String
    public static void warn (String msg) {
        logger.warn(msg);
    }

    // Method Name: info
    // Method Description: This method documented info logs
    // Method Parameters: String
    // Method Return: String
    public static void info (String msg) {
        logger.info(msg);
    }

    // Method Name: debug
    // Method Description: This method documented debug logs
    // Method Parameters: String
    // Method Return: String
    public static void debug (String msg) {
        logger.debug(msg);
    }

    // Method Name: trace
    // Method Description: This method documented trace logs
    // Method Parameters: String
    // Method Return: String
    public static void trace (String msg) {
        logger.trace(msg);
    }
}
