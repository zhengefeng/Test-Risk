package com.risk.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 上传excel文件
 * Created by zhenge.feng.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/uploadfile",method= RequestMethod.POST)
    public ModelAndView uploadfileUpload(HttpServletRequest req, HttpServletResponse resp, MultipartFile file) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("filename",file.getOriginalFilename());
        modelAndView.addObject ("size", file.getSize()/(1024.0*1024) + "M");
        return modelAndView;
    }

    @RequestMapping(value = "/uploadfile2",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> uploadfileUpload2(HttpServletRequest req, HttpServletResponse resp, MultipartFile file) throws Exception {

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("filename", file.getOriginalFilename());
        map.put("size", file.getSize()/(1024.0*1024) + "M");

        return map;
    }

    /*@RequestMapping(value = "/uploadExcel",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult uploadUsers(HttpServletRequest request,
                                  @RequestParam MultipartFile file) throws CommonException{
        //手工导入
        try {
            MultipartRequest multipartRequest=(MultipartRequest) request;
            MultipartFile excelFile=multipartRequest.getFile("file");
            if(excelFile!=null){
                List<UserModel> models=userService.insertUserByExcel(excelFile);
                if(models!=null && models.size()>0){
                    return ResultRender.renderResult("名单导入成功", models);
                }else{
                    return ResultRender.renderResult("名单导入失败", models);
                }
            }else{
                return ResultRender.renderResult("上传失败");
            }
        } catch (Exception e) {
            throw new Exception("上传文件出错");
        }
    }*/


}
