package com.edizzy.coronavirusapi.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum  FixedCountryNameEnum {

    CAPE_VERDE("Cabo Verde", "Cape Verde", Strings.EMPTY),
    CONGO_BRAZZAVILLE("Congo (Brazzaville)", "Congo", "Brazzaville"),
    CONGO_KINSHASA("Congo (Kinshasa)", "Congo", "Kinshasa"),
    COTE_DIVORIE("Cote d'Ivoire", "Côte d'Ivoire", Strings.EMPTY),
    WEST_BANK("West Bank and Gaza", "Palestine", "West Bank, Gaza"),
    CZECHIA("Czechia", "Czech Republic", Strings.EMPTY),
    ESWATINI("Eswatini", "Swaziland", Strings.EMPTY),
    VATICAN("Holy See", "Vatican", "Holy See"),
    SOUTH_KOREA("\"Korea", "South Korea", Strings.EMPTY),
    SOUTH_KOREA2("S. Korea", "South Korea", Strings.EMPTY),
    NORTH_MACEDONIA("North Macedonia", "Macedonia", Strings.EMPTY),
    TAIWAN("Taiwan*", "Taiwan", Strings.EMPTY),
    USA("US", "United States", Strings.EMPTY),
    USA2("USA", "United States", Strings.EMPTY),
    UK("UK", "United Kingdom", Strings.EMPTY),
    MYANMAR("Burma", "Myanmar", Strings.EMPTY),
    UAE("UAE", "United Arab Emirates", Strings.EMPTY),
    REUNION("Réunion", "France", "Reunion"),
    FAROE_ISLANDS("Faeroe Islands", "Faroe Islands", Strings.EMPTY),
    CHANNEL_ISLANDS("Channel Islands", "United Kingdom", "Channel Islands"),
    VATICAN2("Vatican City", "Vatican", "Holy See"),
    ST_VINCENT("St. Vincent Grenadines", "Saint Vincent and the Grenadines", Strings.EMPTY),
    TURKS_AND_CAICOS("Turks and Caicos", "United Kingdom", "Turks and Caicos Islands"),
    CENTRAL_AFRICAN_REPUBLIC("CAR", "Central African Republic", Strings.EMPTY),
    SINT_MAARTEN("Sint Maarten", "Netherlands", "Sint Maarten"),
    DRC("DRC", "Congo", "Kinshasa"),
    ST_BARTH("St. Barth", "France", "Saint Barth"),
    IVORY_COAST("Ivory Coast", "Côte d'Ivoire", Strings.EMPTY);

    private static  Map<String, FixedCountryNameEnum> fixedCountryNameEnumMap;

    static {
      fixedCountryNameEnumMap = Arrays.stream(FixedCountryNameEnum.values())
                .collect(Collectors.toMap(FixedCountryNameEnum::getBroken, Function.identity()));
    }

    private final String broken;
    private final String country;
    private final String province;

    public static FixedCountryNameEnum getByBrokenName(String broken) {
        return fixedCountryNameEnumMap.get(broken);
    }
}
