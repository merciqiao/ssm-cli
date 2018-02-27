package com.yingu.project.rest.controller;

import cn.cecr.econtract.web.app.ws.CreditDTO;
import com.github.pagehelper.PageInfo;
import com.yingu.project.api.CourcePagerParam;
import com.yingu.project.api.ResponsePagerResult;
import com.yingu.project.api.ResponseResult;
import com.yingu.project.api.Status;
import com.yingu.project.persistence.mysql.entity.CourseEntity;
import com.yingu.project.persistence.mysql.entity.StudentEntity;
import com.yingu.project.service.service.CourseService;
import com.yingu.project.service.service.StudentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * Created by MMM on 2018/01/29.
 * 反欺诈rest接口
 */
@RestController
@RequestMapping(value="/ssm-cli-api")
@Slf4j
public class AntifraudController {
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;


//    @ApiOperation(value="黑名单首次查询接口",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
//    @RequestMapping(value = "/getBlankListInfo",method = RequestMethod.POST)
//    public ResponseResult<CreditDTO> getBlankListInfo(@RequestBody BlackListParam blackListParam) throws Exception{
//        ResponseResult<CreditDTO> result = new ResponseResult<>();
//        try {
//            if(blackListParam.getIntoinfono()==null||blackListParam.getIntoinfono()==""){
//                result.setStatus(Status.FAILED);
//                result.setMessage("参数进件编号不能为空");
//                return result;
//            }
//            long t1 = System.currentTimeMillis();
//            List<CreditDTO> creditDTOList = noneBankAntifraudHelper.getBlankListInfo(blackListParam);
//            result.setStatus(Status.SUCCESS);
//            result.setData(creditDTOList);
//            result.setMessage("查询成功");
//            long t2 = System.currentTimeMillis();
//            log.info("ssm-cli-api.getBlankListInfo is success,excute time is:"+(t2-t1)+"millis"
//                    +",param is:"+ JSON.toJSONString(blackListParam));
//            return result;
//        }
//        catch (Exception ex){
//            log.error(ex.getMessage(),ex);
//            result.setStatus(Status.FAILED);
//            result.setMessage("数据获取异常,请重试");
//            return result;
//        }
//    }
//    @ApiOperation(value="根据进件编号查询黑名单接口",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
//    @RequestMapping(value = "/getBlankListInfoByIntoInfoNo",method = RequestMethod.POST)
//    public ResponseResult<CreditDTO> getBlankListInfoByIntoInfoNo(@RequestBody BlackListParam blackListParam) throws Exception {
//        ResponseResult<CreditDTO> result = new ResponseResult<>();
//        try {
//            if(blackListParam.getIntoinfono()==null||blackListParam.getIntoinfono()==""){
//                result.setStatus(Status.FAILED);
//                result.setMessage("参数进件编号不能为空");
//                return result;
//            }
//            long t1 = System.currentTimeMillis();
//            List<CreditDTO> creditDTOList = noneBankAntifraudService.getBlankListInfoByIntoInfoNo(blackListParam.getIntoinfono());
//            result.setStatus(Status.SUCCESS);
//            result.setData(creditDTOList);
//            result.setMessage("查询成功");
//            long t2 = System.currentTimeMillis();
//            log.info("ssm-cli-api.getBlankListInfoByIntoInfoNo is success,excute time is:"+(t2-t1)+"millis"
//                    +",param is:"+ JSON.toJSONString(blackListParam));
//            return result;
//        }
//        catch (Exception ex){
//            log.error(ex.getMessage(),ex);
//            result.setStatus(Status.FAILED);
//            result.setMessage("数据获取异常,请重试");
//            return result;
//        }
//
//    }
    @ApiOperation(value="jpa插入学生表",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public ResponseResult<CreditDTO> addStudent(@RequestBody StudentEntity studentEntity) throws Exception {
        ResponseResult<CreditDTO> result = new ResponseResult<>();
        try {
            studentEntity.setName(studentEntity.getName()+"jpa");
            studentService.add(studentEntity);
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");
            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }
    @ApiOperation(value="mybatis插入学生表",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/insertStudent",method = RequestMethod.POST)
    public ResponseResult<CreditDTO> insertStudent(@RequestBody StudentEntity studentEntity) throws Exception {
        ResponseResult<CreditDTO> result = new ResponseResult<>();
        try {

            studentEntity.setName(studentEntity.getName()+"mybatis");
            //mybatis
            studentService.insert(studentEntity);

            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");
            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }
    @ApiOperation(value="mybatis分页查询课程表",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/selectCourcePager",method = RequestMethod.POST)
    public ResponsePagerResult<CourseEntity> selectCourcePager(@RequestBody CourcePagerParam courcePagerParam) throws Exception {
        ResponsePagerResult<CourseEntity> result = new ResponsePagerResult<>();
        try {

            PageInfo<Map> pageInfo= courseService.selectPager(courcePagerParam.getPageIndex(),courcePagerParam.getPageSize());
            result.setRowCount(pageInfo.getTotal());
            result.setData(pageInfo.getList());
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功");
            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }
}
