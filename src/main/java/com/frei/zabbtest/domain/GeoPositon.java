package com.frei.zabbtest.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Class for object longtitude and latitude
 *
 *
 *
 *
 * by Andreichenko
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoPositon {

    private double latitude;
    private double longtitude;
}
