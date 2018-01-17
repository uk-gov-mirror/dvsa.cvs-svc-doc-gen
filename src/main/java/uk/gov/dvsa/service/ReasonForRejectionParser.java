package uk.gov.dvsa.service;

import uk.gov.dvsa.model.reason_for_rejection.ReasonForRejection;

import java.util.ArrayList;
import java.util.List;

public class ReasonForRejectionParser {

    public static List<ReasonForRejection> parseAll(List<String> rawReasonsForRejection) {
        List<ReasonForRejection> parsedReasonsForRejection = new ArrayList<>();

        rawReasonsForRejection.forEach(
            rawRfr -> parsedReasonsForRejection.add(parse(rawRfr))
        );

        return parsedReasonsForRejection;

    }

    private static ReasonForRejection parse(String rfrText) {
        ReasonForRejection reasonForRejection = new ReasonForRejection();
        reasonForRejection.setFailureText(rfrText);
        return reasonForRejection;
    }
}
