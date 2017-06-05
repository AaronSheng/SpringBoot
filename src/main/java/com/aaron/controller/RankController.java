package com.aaron.controller;

import com.aaron.service.RankService;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rank")
public class RankController {
    private static final Logger logger = LogManager.getLogger(RankController.class);

    @Autowired
    private RankService rankService;

    @RequestMapping(value = "/addScore", method = RequestMethod.GET)
    public JSONObject addScore(@RequestParam("id")Long id, @RequestParam("score")Long score) {
        rankService.addScore(id, score);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        return jsonObject;
    }

    @RequestMapping(value = "/getRank", method = RequestMethod.GET)
    public JSONObject getRank(@RequestParam("score")Long score) {
        Long rank = rankService.getRank(score);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        jsonObject.put("rank", rank);
        return jsonObject;
    }

    @RequestMapping(value = "/deleteRank", method = RequestMethod.GET)
    public JSONObject deleteRank(@RequestParam("id")Long id) {
        rankService.deleteRank(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        return jsonObject;
    }
}
