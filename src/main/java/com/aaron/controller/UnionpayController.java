package com.aaron.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/unionpay")
public class UnionpayController {
    private static Logger logger = LogManager.getLogger(UnionpayController.class);

    @RequestMapping(value = "/charge_notify", method = RequestMethod.POST)
    public String getName(@RequestParam("orderId")String orderId) {
        return "success";
    }
}
