package Loggers;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

public class Log {
    public static void fmtGlobLog(String fmt, Object... args) {
        Logger.getGlobal().log(Level.INFO, String.format(fmt, args));
    }
    public static void fmtGlobLog(Level lvl, String fmt, Object... args) {
        Logger.getGlobal().log(lvl, String.format(fmt, args));
    }
    public static void readProperty(InputStream properties) {
        try {
            manager.readConfiguration(properties);
            logger = Logger.getGlobal();
        }
        catch (IOException exc){
            fmtGlobLog(exc.toString());
        }
    }
    private static final LogManager manager = LogManager.getLogManager();
    private static Logger logger = Logger.getGlobal();
}
