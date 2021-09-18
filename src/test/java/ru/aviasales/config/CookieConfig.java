package ru.aviasales.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/cookie.properties"
})
public interface CookieConfig extends Config {
    @Key("auid")
    String auid();
}