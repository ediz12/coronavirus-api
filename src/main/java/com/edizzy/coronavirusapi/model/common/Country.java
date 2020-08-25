package com.edizzy.coronavirusapi.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor
public class Country {

    private String name;
    private String province;
    private String continent;
    private String code;
    private String iso;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return name.equals(country.name) &&
                Objects.equals(province, country.province) &&
                Objects.equals(continent, country.continent) &&
                Objects.equals(code, country.code) &&
                Objects.equals(iso, country.iso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, province, continent, code, iso);
    }
}
