package com.aaron.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/file")
public class FileController {
    private static Logger logger = LogManager.getLogger(UserController.class);

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public JSONObject uploadFile(@RequestParam("file")MultipartFile multipartFile) {
        System.out.println(multipartFile.getOriginalFilename() + " size:" + multipartFile.getSize());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        jsonObject.put("result", "success");
        return jsonObject;
    }

    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    public JSONObject uploadFiles(@RequestParam("file")MultipartFile[] multipartFiles) {
        for (MultipartFile multipartFile : multipartFiles) {
            System.out.println(multipartFile.getOriginalFilename() + " size:" + multipartFile.getSize());
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        jsonObject.put("result", "success");
        return jsonObject;
    }
}
