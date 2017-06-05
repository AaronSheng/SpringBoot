package com.aaron.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/alipay")
public class AlipayController {
    private static Logger logger = LogManager.getLogger(AlipayController.class);

    @RequestMapping(value = "/charge_notify", method = RequestMethod.POST)
    public String getName(@RequestParam("out_trade_no")String outTradeNo) {
        return "success";
    }
}
