package com.cmcc.know.controller;

import com.cmcc.common.bean.BaseUser;
import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.config.interceptor.CurrentUser;
import com.cmcc.know.entity.KnowType;
import com.cmcc.know.service.KnowTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "资料类型接口")
@RestController
@RequestMapping("/knowType")
public class KnowTypeController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KnowTypeService knowTypeService;

    @ApiOperation(value = "获取资料类型", notes = "获取所有资料类型")
    @GetMapping
    public Result getAll() {
        try {
            List<KnowType> list = knowTypeService.getAll();
            return Result.success(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }

    @ApiOperation(value = "添加资料类型", notes = "根据实体添加资料类型")
    @PutMapping
    public Result addKnowType(KnowType knowType, @CurrentUser BaseUser baseUser) {
        return knowTypeService.add(knowType, baseUser);
    }


    @ApiOperation(value = "更新资料类型", notes = "根据实体ID更新资料类型")
    @PostMapping("/{typeId}")
    public Result updateKnowType(
            @ApiParam(name = "typeId", value = "资料类型ID", required = true)
            @PathVariable String typeId,
            KnowType knowType, @CurrentUser BaseUser baseUser) {
        knowType.setTypeId(typeId);
        return knowTypeService.update(knowType, baseUser);
    }


    @ApiOperation(value = "删除资料类型", notes = "根据ID逻辑删除资料类型")
    @DeleteMapping("/{typeId}")
    public Result delKnowType(
            @ApiParam(name = "typeId", value = "资料类型ID", required = true)
            @PathVariable String typeId) {
        try {
            Integer it = knowTypeService.delete(typeId);
            if (it == 1) {
                return Result.success();
            } else {
                return Result.failure(ResultCode.RESULE_DATA_NONE);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }

}
