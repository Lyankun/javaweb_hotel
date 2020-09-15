package cn.com.Lyankun.ssm.controller;

import cn.com.Lyankun.ssm.entity.Rooms;
import cn.com.Lyankun.ssm.utils.QiniuUploadUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *   客房控制器层
 */
@Controller
@RequestMapping("/rooms")
public class RoomsController extends BaseController<Rooms> {

    //客房封面图上传
    @RequestMapping("/uploadRoomPic")
    public @ResponseBody Map<String,Object> uploadRoomPic(String path, MultipartFile myFile) {

        try {
            return QiniuUploadUtils.upload(myFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
