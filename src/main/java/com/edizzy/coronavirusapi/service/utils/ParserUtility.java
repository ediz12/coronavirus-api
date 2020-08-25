package com.edizzy.coronavirusapi.service.utils;

import com.edizzy.coronavirusapi.model.exceptions.ScrapingParserFailedException;
import org.apache.logging.log4j.util.Strings;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ParserUtility {

    private ParserUtility() {

    }

    private static final NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
    private static final String PLUS = "+";
    private static final String MINUS = "-";

    public static Integer parseInt(String number) {
        try {
            number = number.replace(PLUS, Strings.EMPTY).replace(MINUS, Strings.EMPTY);
            if (number.isEmpty()) {
                return 0;
            }
            return format.parse(number).intValue();
        } catch (ParseException e) {
            throw new ScrapingParserFailedException("TotalCovidDataParser#parseInt(): Could not parse: ", e);
        }
    }

    public static Double parseDouble(String number) {
        try {
            if (number.isEmpty()) {
                return 0D;
            }
            return format.parse(number).doubleValue();
        } catch (ParseException e) {
            throw new ScrapingParserFailedException("TotalCovidDataParser#parseDouble(): Could not parse: ", e);
        }
    }
}
