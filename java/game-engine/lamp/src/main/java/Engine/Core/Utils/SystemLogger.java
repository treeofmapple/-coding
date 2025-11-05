package Engine.Core.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SystemLogger {

    private static String getCallerClassName() {
        return StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .walk(frames -> frames
                        .skip(2)
                        .findFirst()
                        .map(frame -> frame.getDeclaringClass().getSimpleName())
                        .orElse("UnknownClass"));
    }
	
    private static String prefix() {
        return "[" + getCallerClassName() + "] -> ";
    }

    public static void info(String message) {
        log.info(prefix() + message);
    }

    public static void info(String message, Object... args) {
        log.info(prefix() + message, args);
    }

    public static void warn(String message) {
        log.warn(prefix() + message);
    }

    public static void warn(String message, Object... args) {
        log.warn(prefix() + message, args);
    }

    public static void error(String message) {
        log.error(prefix() + message);
    }

    public static void error(String message, Object... args) {
        log.error(prefix() + message, args);
    }

    public static void debug(String message) {
        log.debug(prefix() + message);
    }

    public static void debug(String message, Object... args) {
        log.debug(prefix() + message, args);
    }
    
}
