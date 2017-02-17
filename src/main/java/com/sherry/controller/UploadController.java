package com.sherry.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherry.common.Constants;
import com.sherry.common.JacksonMapper;
import com.sherry.common.util.MyFileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zxin on 17/2/17.
 */

@Controller
public class UploadController {
    ObjectMapper objectMapper = JacksonMapper.getInstance();

    @RequestMapping(value = "uploadPic", method= RequestMethod.POST)
    public @ResponseBody String uploadPic(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "myfile", required = true) CommonsMultipartFile myfile,
            HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String picType = myfile.getOriginalFilename().substring(myfile.getOriginalFilename().indexOf("."));// 取文件格式后缀名
        long now = System.currentTimeMillis();
        String filename = "indexPic_" + Constants.longDateToString(now) + now + picType;// 取当前时间戳作为文件名
        MyFileUtils.fileUpload(myfile, filename);
        map.put("filename",filename);
        map.put("result","success");
        return objectMapper.writeValueAsString(map);
    }

}
