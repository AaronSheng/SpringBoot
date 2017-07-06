package com.aaron.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/wx")
public class WxController {
    private static Logger logger = LogManager.getLogger(WxController.class);

    @RequestMapping(value = "/charge_notify", method = RequestMethod.POST)
    public String getName(@RequestBody String body) {
        return body;
    }
}
