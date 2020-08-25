package com.edizzy.coronavirusapi.service.utils;

import com.edizzy.coronavirusapi.model.common.Country;
import com.edizzy.coronavirusapi.model.enums.FixedCountryNameEnum;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CountryUtility {

    private static final List<String> AFRICAN_COUNTRIES = Lists.newArrayList("nigeria", "ethiopia", "egypt", "democratic republic of the congo", "tanzania", "south africa", "kenya", "uganda", "algeria", "sudan", "morocco", "angola", "mozambique", "ghana", "madagascar", "cameroon", "côte d'ivoire", "niger", "burkina faso", "mali", "malawi", "zambia", "senegal", "chad", "somalia", "zimbabwe", "guinea", "rwanda", "benin", "burundi", "tunisia", "south sudan", "togo", "sierra leone", "libya", "congo", "liberia", "central african republic", "mauritania", "eritrea", "namibia", "gambia", "botswana", "gabon", "lesotho", "guinea-bissau", "equatorial guinea", "mauritius", "eswatini", "djibouti", "réunion", "comoros", "western sahara", "cabo verde", "mayotte", "sao tome and principe", "seychelles", "saint helena");
    private static final List<String> ASIAN_COUNTRIES = Lists.newArrayList("china","india","indonesia","pakistan","bangladesh","japan","philippines","vietnam","iran","thailand","myanmar","south korea","iraq","afghanistan","saudi arabia","uzbekistan","malaysia","yemen","nepal","north korea","taiwan","sri lanka","kazakhstan","syria","cambodia","jordan","azerbaijan","united arab emirates","tajikistan","israel","hong kong","laos","lebanon","kyrgyzstan","turkmenistan","singapore","oman","state of palestine","kuwait","georgia","mongolia","armenia","qatar","bahrain","timor-leste","cyprus","bhutan","macao","maldives","brunei darussalam");
    private static final List<String> EUROPEAN_COUNTRIES = Lists.newArrayList("russia","germany","united kingdom","france","italy","spain","ukraine","poland","romania","netherlands","belgium","czechia","greece","portugal","sweden","hungary","belarus","austria","serbia","switzerland","bulgaria","denmark","finland","slovakia","norway","ireland","croatia","moldova","bosnia and herzegovina","albania","lithuania","north macedonia","slovenia","latvia","estonia","montenegro","luxembourg","malta","iceland","channel islands","isle of man","andorra","faeroe islands","monaco","liechtenstein","san marino","gibraltar","vatican", "turkey");
    private static final List<String> NORTH_AMERICAN_COUNTRIES = Lists.newArrayList("usa","mexico","canada","guatemala","haiti","cuba","dominican republic","honduras","nicaragua","el salvador","costa rica","panama","jamaica","puerto rico","trinidad and tobago","guadeloupe","belize","bahamas","martinique","barbados","saint lucia","curaçao","grenada","saint vincent and the grenadines","aruba","united states virgin islands","antigua and barbuda","dominica","cayman islands","bermuda","greenland","saint kitts and nevis","sint maarten","turks and caicos islands","saint martin","british virgin islands","caribbean netherlands","anguilla","saint barthélemy","saint pierre and miquelon","montserrat");
    private static final List<String> SOUTH_AMERICAN_COUNTRIES = Lists.newArrayList("brazil","colombia","argentina","peru","venezuela","chile","ecuador","bolivia","paraguay","uruguay","guyana","suriname","french guiana","falkland islands");
    private static final List<String> OCEANIA_COUNTRIES = Lists.newArrayList("australia","papua new guinea","new zealand","fiji","solomon islands","vanuatu","new caledonia","french polynesia","samoa","guam","kiribati","micronesia","tonga","marshall islands","northern mariana islands","american samoa","palau","cook islands","tuvalu","wallis and futuna islands","nauru","niue","tokelau");
    private static final List<String> NON_CONTINENTS = Lists.newArrayList("diamond princess", "ms zaandam");

    private static final Map<String, String> countryContinentMap = Maps.newHashMap();
    private static final Map<String, Locale> countryLocaleMap = Maps.newHashMap();

    private CountryUtility() {

    }

    static {
        mapContinents();
        mapLocales();
    }

    public static Country getCountry(String countryName, String province) {
        final FixedCountryNameEnum countryEnum = FixedCountryNameEnum.getByBrokenName(countryName);
        if (countryEnum != null) {
            countryName = countryEnum.getCountry();
            province = countryEnum.getProvince();
        }
        return buildCountry(countryName, province);
    }

    private static Country buildCountry(String countryName, String province) {
        final String continent = countryContinentMap.get(countryName.toLowerCase());

        if ("Other".equals(continent)) {
            return Country.builder()
                    .name(countryName)
                    .continent(continent)
                    .build();
        } else if ("kosovo".equals(countryName.toLowerCase())){
            return Country.builder()
                    .name(countryName)
                    .province(Strings.EMPTY)
                    .continent("Europe")
                    .code("XK")
                    .iso("RKS")
                    .build();
        }
        return Country.builder()
                .name(countryName)
                .province(province)
                .continent(continent)
                .code(countryLocaleMap.get(countryName.toLowerCase()).getCountry())
                .iso(countryLocaleMap.get(countryName.toLowerCase()).getISO3Country())
                .build();
    }

    private static void mapLocales() {
        Arrays.asList(Locale.getISOCountries()).forEach(iso ->
                {
                    Locale locale = new Locale(Locale.ENGLISH.getISO3Language(), iso);
                    countryLocaleMap.put(locale.getDisplayCountry().toLowerCase(), locale);
                }
        );
    }

    private static void mapContinents() {
        AFRICAN_COUNTRIES.forEach(country -> countryContinentMap.put(country, "Africa"));
        ASIAN_COUNTRIES.forEach(country -> countryContinentMap.put(country, "Asia"));
        EUROPEAN_COUNTRIES.forEach(country -> countryContinentMap.put(country, "Europe"));
        NORTH_AMERICAN_COUNTRIES.forEach(country -> countryContinentMap.put(country, "North America"));
        SOUTH_AMERICAN_COUNTRIES.forEach(country -> countryContinentMap.put(country, "South America"));
        OCEANIA_COUNTRIES.forEach(country -> countryContinentMap.put(country, "Oceania"));
        NON_CONTINENTS.forEach(country -> countryContinentMap.put(country, "Other"));
    }
}
