package com.aaron.web;

import com.aaron.service.OnlineUserService;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/online")
public class OnlineController {
    private static final Logger logger = LogManager.getLogger(OnlineController.class);

    @Autowired
    private OnlineUserService onlineUserService;

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public JSONObject getName(@RequestParam("id")long id) {
        String name = onlineUserService.getName(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        jsonObject.put("name", name);
        return jsonObject;
    }

    @RequestMapping(value = "/setName", method = RequestMethod.GET)
    public JSONObject setName(@RequestParam("id")long id, @RequestParam("name")String name) {
        onlineUserService.setName(id, name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        return jsonObject;
    }
}
