package com.edizzy.coronavirusapi.scraper.parser;

import com.edizzy.coronavirusapi.model.common.Country;
import com.edizzy.coronavirusapi.model.common.TimelineData;
import com.edizzy.coronavirusapi.model.enums.FixedCountryNameEnum;
import com.edizzy.coronavirusapi.service.utils.CountryUtility;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CountriesTimeSeriesDataParser {

    private static final String COMMA = ",";
    private static final String NEW_LINE = "\n";

    public Map<Country, LinkedList<TimelineData>>  parse(String csvData) {
        final Map<Country, LinkedList<TimelineData>> countryTimelineDataMap = Maps.newHashMap();

        final String[] headersWithData = csvData.split(NEW_LINE);
        final String[] headers = headersWithData[0].split(COMMA);

        for (int countryIndex = 1; countryIndex < headersWithData.length; countryIndex++) {
            final LinkedList<TimelineData> timeline = Lists.newLinkedList();
            final DateTimeFormatter formatter = DateTimeFormat.forPattern("M/d/yy");

            final List<String> data = Lists.newArrayList(headersWithData[countryIndex].split(COMMA));
            final Country country = CountryUtility.getCountry(data.get(1), data.get(0));
            if ("KR".equals(country.getCode())) {
                data.remove(4);
            }
            for (int dateIndex = 4 ; dateIndex < data.size(); dateIndex++) {
                timeline.add(TimelineData.builder()
                        .date(formatter.parseDateTime(headers[dateIndex]))
                        .value(Integer.valueOf(data.get(dateIndex)))
                        .build());
            }
            countryTimelineDataMap.put(country, timeline);
        }
        return countryTimelineDataMap;
    }
}
