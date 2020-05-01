
package com.vispractice.zipkin.service4;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vispractice.zipkin.TracelinkCutdown;
import com.vispractice.zipkin.UtilId;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("service的API接口")
@RestController
@RequestMapping("/service4")
public class ZipkinBraveController {

	//单次服务调用的唯一TraceID
    private String linkTraceID=UtilId.randomHexString(16);

    @ApiOperation("trace第四步")
    @RequestMapping("/test")
    public String service1(HttpServletRequest req,HttpServletResponse res) throws Exception {

    	//提供服务改TraceID和SpanID
        TracelinkCutdown.CutdownKongtoService(req, res, linkTraceID);

        return "service4";
    }

}
