package com.dreamTimes.util;

import org.springframework.web.multipart.MultipartFile;
import java.io.*;

public class ImgUtil {
    public static String imgControl(MultipartFile part, String servletPath) throws IOException {
        if(part == null){
            return null;
        }
        String oldFileName = part.getOriginalFilename();
        if(!isImg(oldFileName)){
            return null;
        }
        String newFileName = System.currentTimeMillis()+oldFileName.substring(oldFileName.lastIndexOf("."));
        File path = new File(servletPath);
        if(!path.exists()){
            path.mkdir();
        }
        part.transferTo(new File(servletPath,newFileName));
        return newFileName;
    }
    public static boolean isImg(String fileName){
        if(fileName.indexOf(".")>-1){
            String lastName = fileName.substring(fileName.lastIndexOf("."));
            if(".jpg|.png|.bmp|.webp|.gif".indexOf(lastName) > -1){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
