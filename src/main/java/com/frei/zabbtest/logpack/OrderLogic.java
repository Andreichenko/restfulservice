package com.frei.zabbtest.logpack;

import org.apache.log4j.Logger;

public class OrderLogic {

    private static final Logger log = Logger.getLogger(OrderLogic.class);

    private void doOrder(){
        log.info("Information Message");
        addToCart();
    }

    private void addToCart(){
        log.error("Error message");
    }
}
