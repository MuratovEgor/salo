package ru.aviasales.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/cookie.properties"
})
public interface CookieConfig extends Config {
    @DefaultValue("rBQjfmE6V4cenwAfC2emAg==")
    @Key("auid")
    String auid();
}