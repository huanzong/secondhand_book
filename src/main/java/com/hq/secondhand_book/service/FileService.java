package com.hq.secondhand_book.service;

import com.hq.secondhand_book.util.resp.ResultResp;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    ResultResp singleFile(MultipartFile file, String userName);
}
