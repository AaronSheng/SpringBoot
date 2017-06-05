package com.aaron.controller;

import com.aaron.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public JSONObject getName(@RequestParam("id")long id) {
        String name = userService.getName(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        jsonObject.put("name", name);
        return jsonObject;
    }

    @RequestMapping(value = "/setName", method = RequestMethod.GET)
    public JSONObject setName(@RequestParam("id")long id, @RequestParam("name")String name) {
        userService.setName(id, name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        jsonObject.put("result", "success");
        return jsonObject;
    }
}
