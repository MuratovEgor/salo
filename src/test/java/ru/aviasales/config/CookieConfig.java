package ru.aviasales.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/cookie.properties"
})
public interface CookieConfig extends Config {

    @DefaultValue("CtYgeWEg4UiRB+0CJaiUAg==")
    @Key("auid")
    String auid();

    @DefaultValue("CtYgeWEiE3GRB+0CQ/66Ag==")
    @Key("auidControl")
    String auidControl();

}
