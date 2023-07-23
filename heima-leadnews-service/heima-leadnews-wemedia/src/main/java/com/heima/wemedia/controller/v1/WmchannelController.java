package com.heima.wemedia.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.wemedia.service.WmChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/channel")
@Api(value = "自媒体的频道管理", tags = "wm_channel", description = "频道管理的相关API")
public class WmchannelController {
    @Autowired
    private WmChannelService wmChannelService;

    @GetMapping("/channels")
    @ApiOperation("频道的下拉列表需查询出所有频道")
    public ResponseResult findAll(){
        return wmChannelService.findAll();
    }
}
