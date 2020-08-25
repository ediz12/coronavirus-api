package com.edizzy.coronavirusapi.scraper.handler;

import com.edizzy.coronavirusapi.model.common.TotalWorldData;
import com.edizzy.coronavirusapi.model.enums.ApiLinksEnum;
import com.edizzy.coronavirusapi.model.exceptions.ScrapingRequestFailedException;
import com.edizzy.coronavirusapi.scraper.parser.WorldTotalDataParser;
import lombok.RequiredArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

@RequiredArgsConstructor
public class WorldTotalDataHandler implements DataHandler {

    private final WorldTotalDataParser worldTotalDataParser;

    @Override
    public void getData() {
        final Document document = getDocument();
        TotalWorldData totalWorldData = worldTotalDataParser.parse(document);
        //TODO: update WORLD_DATA db every 15 mins
        System.out.println();
    }

    private Document getDocument() {
        try {
            final Connection connection = Jsoup.connect(ApiLinksEnum.WORLDOMETER_MAIN_PAGE.getBaseUrl());
            return connection.get();
        } catch (IOException e) {
            throw new ScrapingRequestFailedException("WorldTotalCovidDataParser#getDocument(): Could not get connection from Worldometer: ", e);
        }
    }
}
