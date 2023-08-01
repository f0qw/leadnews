package com.heima.wemedia.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.WmMaterialDto;
import com.heima.wemedia.service.WmMaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/material")
@Api(value = "自媒体的素材管理", tags = "wm_material", description = "图片视频素材管理的相关API")
public class WmMaterialController {

    @Autowired
    private WmMaterialService wmMaterialService;


    @ApiOperation("图片素材的上传")
    @PostMapping("/upload_picture")
    public ResponseResult uploadPicture(MultipartFile multipartFile){
        System.out.println("/upload_picture执行");
        return wmMaterialService.uploadPicture(multipartFile);
    }

    @ApiOperation("点击素材管理后显示分页查询的图片")
    @PostMapping("/list")
    public ResponseResult findList(@RequestBody WmMaterialDto dto){
        System.out.println("/list执行");
        return wmMaterialService.findList(dto);
    }
}
