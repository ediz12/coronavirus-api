package com.edizzy.coronavirusapi.scraper.handler;

import com.edizzy.coronavirusapi.model.common.Country;
import com.edizzy.coronavirusapi.model.common.TotalCountryData;
import com.edizzy.coronavirusapi.model.enums.ApiLinksEnum;
import com.edizzy.coronavirusapi.model.exceptions.ScrapingRequestFailedException;
import com.edizzy.coronavirusapi.scraper.parser.CountriesTotalDataParser;
import com.edizzy.coronavirusapi.service.utils.CountryUtility;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CountriesTotalDataHandler implements DataHandler {

    private final CountriesTotalDataParser countriesTotalDataParser;

    @Override
    public void getData() {
        final Document document = getDocument();
        List<TotalCountryData> totalCountryData = countriesTotalDataParser.parse(document);

        final List<String> collect = totalCountryData.stream()
                .map(TotalCountryData::getCountry)
                .map(c -> CountryUtility.getCountry(c, ""))
                .map(Country::getName).sorted()
                .collect(Collectors.toList());
        final HashSet<String> strings = Sets.newLinkedHashSet(collect);
        strings.forEach(System.out::println);
        System.out.println(collect.size());
        /*for (TotalCountryData totalCountryDatum : totalCountryData) {
            try {
                CountryUtility.getCountry(totalCountryDatum.getCountry(), Strings.EMPTY);
            } catch (Exception e) {
                System.out.println(totalCountryDatum.getCountry());
            }
        }*/
    }

    private Document getDocument() {
        try {
            final Connection connection = Jsoup.connect(ApiLinksEnum.WORLDOMETER_MAIN_PAGE.getBaseUrl());
            return connection.get();
        } catch (IOException e) {
            throw new ScrapingRequestFailedException("CountriesTotalCovidDataHandler#getDocument(): Could not get connection from Worldometer: ", e);
        }
    }
}
