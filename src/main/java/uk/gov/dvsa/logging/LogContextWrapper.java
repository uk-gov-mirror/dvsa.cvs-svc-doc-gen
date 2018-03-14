package uk.gov.dvsa.logging;

import org.apache.logging.log4j.ThreadContext;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LogContextWrapper {

    public static final String CONTEXT_EVENT_KEY = "event";
    public static final String CONTEXT_DURATION_KEY = "duration";
    public static final String PAGE_NUMBER_KEY = "pageNumber";

    private static final NumberFormat formatter = new DecimalFormat("#0.000000");

    public static void setEvent(EventType event) {
        ThreadContext.put(CONTEXT_EVENT_KEY, event.getName());
    }

    public static void cleanupEvent() {
        ThreadContext.remove(CONTEXT_EVENT_KEY);
    }

    public static void setDuration(Long durationNanos) {
        ThreadContext.put(CONTEXT_DURATION_KEY, formatter.format(durationNanos / 10e9) + " seconds");
    }

    public static void cleanupDuration() {
        ThreadContext.remove(CONTEXT_DURATION_KEY);
    }

    public static void setPageNumber(String pageNumber) {
        ThreadContext.put(PAGE_NUMBER_KEY, pageNumber);
    }

    public static void cleanupPageNumber() {
        ThreadContext.remove(PAGE_NUMBER_KEY);
    }
}
