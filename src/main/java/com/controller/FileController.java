package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.ConfigEntity;
import com.entity.EIException;
import com.service.ConfigService;
import com.utils.R;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Date;
import java.util.Objects;

/**
 * 上传文件映射表
 */
@RestController
@RequestMapping("file")
@SuppressWarnings({"unchecked", "rawtypes"})
@CrossOrigin(origins = "*")
public class FileController {
    @Autowired
    private ConfigService configService;

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    @IgnoreAuth
    public R upload(@RequestParam("file") MultipartFile file, String type) throws Exception {
        if (file.isEmpty()) {
            throw new EIException("上传文件不能为空");
        }
        String modulePath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI())
                .getParentFile().getParentFile().getAbsolutePath();
        String resourcesPath = modulePath + "/src/main/resources/static/upload/";
        String staticAbsolutePath = URLDecoder.decode(resourcesPath, StandardCharsets.UTF_8.name());
        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        File path = new File(staticAbsolutePath);
        if (!path.exists()) {
            path.mkdirs();
        }

        String staticAbsolutePath2 = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath() + "static/upload/";
        ;
        staticAbsolutePath2 = URLDecoder.decode(staticAbsolutePath2, StandardCharsets.UTF_8.name());
        File path2 = new File(staticAbsolutePath2);
        if (!path2.exists()) {
            path2.mkdirs();
        }

        String fileName = new Date().getTime() + "." + fileExt;

        File dest = new File(path.getAbsolutePath() + "/" + fileName);
        File dest2 = new File(path2.getAbsolutePath() + "/" + fileName);
        file.transferTo(dest);
        FileUtils.copyInputStreamToFile(Files.newInputStream(new File(dest.getAbsolutePath()).toPath()), dest2);
        if (StringUtils.isNotBlank(type) && type.equals("1")) {
            ConfigEntity configEntity = configService.selectOne(new EntityWrapper<ConfigEntity>().eq("name", "faceFile"));
            if (configEntity == null) {
                configEntity = new ConfigEntity();
                configEntity.setName("faceFile");
                configEntity.setValue(fileName);
            } else {
                configEntity.setValue(fileName);
            }
            configService.insertOrUpdate(configEntity);
        }
        // return R.ok().put("file", "upload/" + fileName);
        return R.ok().put("file", fileName);
    }

    /**
     * 下载文件
     */
    @IgnoreAuth
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam String fileName) {
        try {
            File path = new File(ResourceUtils.getURL("classpath:static").getPath());
            if (!path.exists()) {
                path = new File("");
            }
            File upload = new File(path.getAbsolutePath(), "/upload/");
            if (!upload.exists()) {
                upload.mkdirs();
            }
            File file = new File(upload.getAbsolutePath() + "/" + fileName);
            if (file.exists()) {
               /*if(!fileService.canRead(file, SessionManager.getSessionUser())){
                   getResponse().sendError(403);
               }*/
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.setContentDispositionFormData("attachment", fileName);
                return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}