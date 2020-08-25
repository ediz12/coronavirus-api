package com.edizzy.coronavirusapi.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class TotalWorldData {

    private int total;
    private int active;
    private int closed;
    private int dead;
    private int recovered;
}
