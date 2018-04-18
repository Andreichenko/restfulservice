package com.frei.zabbtest;


import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *  Main Class Spring Application
 *
 *
 * by Andreichenko
 */

@SpringBootApplication
public class Application implements CommandLineRunner{

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).bannerMode(Banner.Mode.OFF).run(args);
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
