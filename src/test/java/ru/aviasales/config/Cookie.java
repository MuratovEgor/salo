package ru.aviasales.config;

import org.aeonbits.owner.ConfigFactory;

public class Cookie {
    public static CookieConfig config = ConfigFactory.create(CookieConfig.class, System.getProperties());
}
