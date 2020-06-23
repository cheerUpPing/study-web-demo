package com.elon.studydemo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;

@RequestMapping(value = "/image")
@Controller
public class ImageController {

    @RequestMapping(value = "/getImage/{imageName}/r", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(@PathVariable String imageName) throws Exception {
        File file = new File("D:/ocr_file/" + imageName);
        if (!file.exists()) {
            return new byte[]{};
        }
        FileInputStream in = new FileInputStream(file);
        byte[] bytes = new byte[in.available()];
        in.read(bytes, 0, in.available());
        return bytes;
    }

}
