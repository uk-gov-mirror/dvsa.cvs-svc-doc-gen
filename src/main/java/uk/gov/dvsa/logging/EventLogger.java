package uk.gov.dvsa.logging;

import org.apache.logging.log4j.Logger;
import uk.gov.dvsa.model.mot.CurrentTracingInformation;

public class EventLogger {

    private final Logger logger;

    public EventLogger(Logger logger) {
        this.logger = logger;
    }

    public void logEvent(EventType event) {
        LogContextWrapper.setEvent(event);
        logger.info(event.getDescription());
    }

    public void logEvent(EventType event, long durationNanos) {
        LogContextWrapper.setEvent(event);
        LogContextWrapper.setDuration(durationNanos);
        logger.info(event.getDescription());
        LogContextWrapper.cleanupDuration();
    }

    public void logError(EventType event, long durationNanos, Exception e) {
        LogContextWrapper.setEvent(event);
        LogContextWrapper.setDuration(durationNanos);
        logger.error(e.getMessage(), e);
        LogContextWrapper.cleanupDuration();
    }

    public void logEventWithTraceInfo(EventType eventType, CurrentTracingInformation currentTracingInformation) {
        LogContextWrapper.setTraceInformation(
                currentTracingInformation.getTraceId(),
                currentTracingInformation.getSpanId(),
                currentTracingInformation.getParentSpanId()
        );
        logEvent(eventType);
    }
}
