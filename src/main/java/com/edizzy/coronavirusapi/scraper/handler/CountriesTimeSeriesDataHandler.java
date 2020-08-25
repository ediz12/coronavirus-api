package com.edizzy.coronavirusapi.scraper.handler;

import com.edizzy.coronavirusapi.model.common.Country;
import com.edizzy.coronavirusapi.model.common.TimelineData;
import com.edizzy.coronavirusapi.model.enums.ApiLinksEnum;
import com.edizzy.coronavirusapi.scraper.parser.CountriesTimeSeriesDataParser;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CountriesTimeSeriesDataHandler implements DataHandler {

    private final RestTemplate restTemplate;
    private final CountriesTimeSeriesDataParser countriesTimeSeriesDataParser;

    @Override
    public void getData() {
        final Map<Country, LinkedList<TimelineData>> casesTimeSeries = countriesTimeSeriesDataParser.parse(getCSVData(ApiLinksEnum.JHU_CASES_TIME_SERIES));

        /*final Map<Country, LinkedList<TimelineData>> deathTimeSeries = countriesTimeSeriesDataParser.parse(getCSVData(ApiLinksEnum.JHU_DEATHS_TIME_SERIES));
        final Map<Country, LinkedList<TimelineData>> recoveredTimeSeries = countriesTimeSeriesDataParser.parse(getCSVData(ApiLinksEnum.JHU_RECOVERED_TIME_SERIES));
        getActiveTimeSeries(casesTimeSeries, deathTimeSeries, recoveredTimeSeries);*/
    }

    private Map<Country, LinkedList<TimelineData>> getActiveTimeSeries(Map<Country, LinkedList<TimelineData>> casesTimeSeries, Map<Country, LinkedList<TimelineData>> deathTimeSeries, Map<Country, LinkedList<TimelineData>> recoveredTimeSeries) {
        final List<String> collect = casesTimeSeries.keySet().stream()
                .map(Country::getName).sorted()
                .collect(Collectors.toList());
        final HashSet<String> strings = Sets.newLinkedHashSet(collect);
        strings.forEach(System.out::println);
        System.out.println(strings.size());
        /*for (Country country : casesTimeSeries.keySet()) {
            try {
                System.out.println(country.getName());
                /*System.out.println(casesTimeSeries.get(country));
                System.out.println(deathTimeSeries.get(country));
                System.out.println(recoveredTimeSeries.get(country));
            } catch (Exception e) {

            }
        }*/
        return null;
    }

    private String getCSVData(ApiLinksEnum apiLinksEnum) {
        final ResponseEntity<String> entity = restTemplate.getForEntity(apiLinksEnum.getBaseUrl(), String.class);
        return entity.getBody();
    }
}
