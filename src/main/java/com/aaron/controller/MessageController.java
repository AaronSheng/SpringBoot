package com.aaron.controller;

import com.aaron.service.MessageService;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
    private static Logger logger = LogManager.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/addMessage", method = RequestMethod.GET)
    public JSONObject addMessage(@RequestParam("message")String message) {
        messageService.addMessage(message);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        return jsonObject;
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public JSONObject getMessage() {
        String message = messageService.getMessage();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        jsonObject.put("message", message);
        System.out.println(jsonObject.toJSONString());
        return jsonObject;
    }
}
