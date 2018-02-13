package uk.gov.dvsa.logging;

import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class LoggingExecutor {

    private final Logger logger;

    public LoggingExecutor(Logger logger)
    {
        this.logger = logger;
    }

    public <T> T timed(Supplier<T> operation, EventType event) {
        long start = System.nanoTime();
        try {
            T result = operation.get();
            logEvent(event, "Done in {} nanoseconds", start);
            return result;
        } catch (Exception e) {
            logEvent(event, "Failed after {} nanoseconds", start);
            throw e;
        }
    }

    private void logEvent(EventType event, String message, long start) {
        long duration = System.nanoTime() - start;
        LogContextWrapper.setEvent(event);
        LogContextWrapper.setDuration(duration);
        logger.info(message, duration);
        LogContextWrapper.cleanupDuration();
    }
}
