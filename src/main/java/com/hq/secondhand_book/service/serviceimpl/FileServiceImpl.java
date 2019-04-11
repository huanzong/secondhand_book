package com.hq.secondhand_book.service.serviceimpl;

import com.hq.secondhand_book.entity.User;
import com.hq.secondhand_book.repository.UserRepositiry;
import com.hq.secondhand_book.service.FileService;
import com.hq.secondhand_book.util.resp.Response;
import com.hq.secondhand_book.util.resp.ResultResp;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Resource
    UserRepositiry userRepositiry;

    /**
     * 单文件上传
     * @param file
     * @param userName
     * @return
     */
    @Override
    public ResultResp singleFile(MultipartFile file,String userName) {
        try {
            String name = file.getOriginalFilename();//上传文件的真实名称
            String suffixName = name.substring(name.lastIndexOf(".")+1);//获取后缀名
            String fileName = UUID.randomUUID()+"."+suffixName;
            //图片的存储位置
            String filePath = "E://Workspaces//secondhand_book//src//main//resources//static//picture//user//";
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Optional<User> userOptional = userRepositiry.getByUserNameAndUsable(userName,1);
            if(userOptional.isPresent()){
                User user = userOptional.get();
                user.setUserPic(fileName);
                userRepositiry.saveAndFlush(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.dataErr();
        }
        return Response.ok();
    }
}
