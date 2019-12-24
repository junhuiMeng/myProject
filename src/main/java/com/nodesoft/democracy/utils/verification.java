package com.nodesoft.democracy.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nodesoft.common.utils.DateUtils;
import com.nodesoft.common.utils.StringUtils;
import com.nodesoft.common.web.BaseController;
import com.nodesoft.democracy.democracyuser.entity.DemUser;
import com.nodesoft.democracy.democracyuser.service.DemUserService;
import com.nodesoft.democracy.score.dao.DemScoreDao;
import com.nodesoft.democracy.score.entity.DemScore;
import com.nodesoft.democracy.score.entity.Unit;
import com.nodesoft.democracy.score.service.DemScoreService;
import com.nodesoft.democracy.theme.entity.DemTheme;
import com.nodesoft.democracy.theme.service.DemThemeService;
import com.nodesoft.modules.sys.dao.AreaDao;
import com.nodesoft.modules.sys.entity.Area;
import com.nodesoft.modules.sys.entity.Dict;
import com.nodesoft.modules.sys.entity.Office;
import com.nodesoft.modules.sys.service.AreaService;
import com.nodesoft.modules.sys.service.OfficeService;
import com.nodesoft.modules.sys.utils.DictUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: yademocracygrade
 * @PackageName: com.nodesoft.democracy.utils
 * @ClassName: verification
 * @Description: 短信验证码工具类
 * @author: lenovo
 * @date: 2019/10/8 11:13
 * @Copyright: 西安捷点科技开发有限责任公司 Copyright (c) 2019
 */

@Controller
@RequestMapping(value = "/api")
public class verification extends BaseController {

    @Autowired
    private DemUserService demUserService;
    @Autowired
    private DemScoreService demScoreService;
    @Autowired
    private DemScoreDao demScoreDao;

    @Autowired
    private OfficeService officeService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private AreaDao areaDao;

    @Autowired
    private DemThemeService demThemeService;


    /**
     * @return
     * @Description 登录判断是否在有效期
     */
    @RequestMapping(value = "/timeJudgment")
    @ResponseBody

    public String timeJudgment(HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        DemTheme demTheme = new DemTheme();
        demTheme.setHold1("fbnf");
        List<DemTheme> demThemelist =demThemeService.findList(demTheme);
        if(demThemelist.size()>0){
            demTheme=demThemelist.get(0);
            Long a=DateUtils.pastDays(demThemelist.get(0).getStartDate());
            Long b=DateUtils.pastDays(demThemelist.get(0).getEndDate());
            if(!(a<0) && !(b>0)){
                j.getBody().put("bool", "true");
            }else{
                j.getBody().put("bool", "false");
            }
        }
        return renderString(response, j);
    }

    /**
     * @param mobile 手机号（正式）
     * @return 是否发送成功
     * @Description 发送验证码
     */
//    @RequestMapping(value = "/getVerificationCode")
//    @ResponseBody
//    public String getVerificationCode(String mobile, HttpServletResponse response) throws Exception {
//        AjaxJson j = new AjaxJson();
//
//        DemUser user=new DemUser();
//        user.setTel(mobile);
//        DemTheme demTheme = new DemTheme();
//        demTheme.setHold1("fbnf");
//        List<DemTheme> demThemelist =demThemeService.findList(demTheme);
//        if(demThemelist.size()>0){
//            user.setYear(demThemelist.get(0).getYear());
//        }
//
//        List<DemUser> userList=demUserService.findList(user);
//        if(userList!=null&&userList.size()>0){
//            String status=userList.get(0).getStatus();
//            if("1".equals(status)){
//                j.getBody().put("status", "1");
//                return renderString(response, j);
//            }
//        }
//
//
//        int random = (int) ((Math.random() * 9 + 1) * 100000);
//        String randomNum = String.valueOf(random);
//        Cache.put(mobile, randomNum, 300000);
//        boolean flage = new SendSms().SingleSender(mobile, randomNum);
//        if (!flage) {
//            j.setSuccess(false);
//            j.setMsg("发送失败");
//        }
//
//        return renderString(response, j);
//    }

    /**
     *
     * @param mobile（测试）
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getVerificationCode")
    @ResponseBody
    public String getVerificationCode(String mobile, HttpServletResponse response) throws Exception {
        AjaxJson j = new AjaxJson();
        int random = (int) ((Math.random() * 9 + 1) * 100000);
        String randomNum = String.valueOf(random);
        Cache.put(mobile, randomNum, 300000);
        boolean flage = new SendSms().SingleSender(mobile, randomNum);
        if (!flage) {
            j.setSuccess(false);
            j.setMsg("发送失败");
        }

        return renderString(response, j);
    }

    /**
     * @param params 手机号,验证码
     * @return
     * @Description 验证验证码
     */
//    @RequestMapping(value = "verifyCode")
//    @ResponseBody
//    public String verifyCode(@RequestBody String params, HttpServletResponse response) {
//        logger.info("params"+params);
//        AjaxJson j = new AjaxJson();
//        try {
//            params = URLDecoder.decode(params, "utf-8");
//            params = params.replace("=", "");
//        } catch (UnsupportedEncodingException e) {
//            return "解码失败!";
//        }
//        JSONObject json = JSONObject.parseObject(params);
//        String mobile = json.getString("mobile");
//        String code = json.getString("code");
//        String year=DateUtils.getYear();
//        logger.info("year+++++++"+year);
//        DemTheme demTheme = new DemTheme();
//
//        demTheme.setHold1("fbnf");
//        List<DemTheme> demThemelist = demThemeService.findList(demTheme);
//        String niandu="";
//        if(demThemelist.size()>0&&demThemelist!=null){
//            niandu=demThemelist.get(0).getYear();
//
//        }else{
//            j.getBody().put("info", "系统未维护关于年度数据！");
//            return renderString(response, j);
//        }
//        String randomNum = (String) Cache.get(mobile);
//        if (randomNum != null && randomNum.equals(code)) {
//            /**
//             * 1.查询数据库，如果用户已存在，则直接登录，如果不存在则注册新用户
//             */
//            DemUser demUser = new DemUser();
//            demUser.setTel(mobile);
//            demUser.setYear(niandu);
//            List<DemUser> vuser = demUserService.findList(demUser);
////            if (vuser.size() > 0 && vuser != null) {
//            if (vuser.size()>0&&vuser!=null) {
////                if(vuser.get(0).getStatus().equals("1")){
//                if("1".equals(vuser.get(0).getStatus())){
//                    j.getBody().put("biaoshi", "1");
//                    return renderString(response, j);
//                }
//                j.getBody().put("VouserList", vuser);
//
//            } else {
//
//                demUserService.save(demUser);
//                List<DemUser> voser = demUserService.findList(demUser);
//                j.getBody().put("VouserList", voser);
//            }
//
//
//        } else {
//            j.setSuccess(false);
//            j.setMsg("验证码错误");
//        }
//
//        return renderString(response, j);
//    }




    @RequestMapping(value = "verifyCode")
    @ResponseBody
    public String verifyCode(@RequestBody String params, HttpServletResponse response) {
        logger.info("params"+params);
        AjaxJson j = new AjaxJson();
        try {
            params = URLDecoder.decode(params, "utf-8");
            params = params.replace("=", "");
        } catch (UnsupportedEncodingException e) {
            return "解码失败!";
        }
        JSONObject json = JSONObject.parseObject(params);
        String mobile = json.getString("mobile");
        String code = json.getString("code");
        String year=DateUtils.getYear();
        logger.info("year+++++++"+year);
        DemTheme demTheme = new DemTheme();

        demTheme.setHold1("fbnf");
        List<DemTheme> demThemelist = demThemeService.findList(demTheme);
        String niandu="";
        if(demThemelist.size()>0&&demThemelist!=null){
            niandu=demThemelist.get(0).getYear();

        }else{
            j.getBody().put("info", "系统未维护关于年度数据！");
            return renderString(response, j);
        }
        String randomNum = (String) Cache.get(mobile);
        if (randomNum != null && randomNum.equals(code)) {

            DemUser demUser = new DemUser();
            demUser.setTel(mobile);
//            demUser.setYear(niandu);
            List<DemUser> vuser = demUserService.findList(demUser);
            if (vuser.size()>0&&vuser!=null) {
                    j.getBody().put("VouserList",vuser );
            } else {

                demUserService.save(demUser);
                List<DemUser> voser = demUserService.findList(demUser);
                j.getBody().put("VouserList", voser);
            }

        } else {
            j.setSuccess(false);
            j.setMsg("验证码错误");
        }
        return renderString(response, j);
    }

    /**
     * @return
     * @Description 获取人员类型
     */

    @RequestMapping(value = "/getpersontype")
    @ResponseBody

    public String getpersontype(HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        List<Dict> dictList = DictUtils.getDictList("user_type");
        DemTheme demTheme = new DemTheme();

        demTheme.setHold1("fbnf");
        List<DemTheme> demThemelist = demThemeService.findList(demTheme);

        if (dictList.size() > 0 && dictList != null) {
            j.getBody().put("dictList", dictList);
        } else {

            j.getBody().put("dictList", "0");
        }

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        if (demThemelist.size() > 0 && demThemelist != null) {
            demThemelist.get(0).setHold1(ft.format(demThemelist.get(0).getStartDate()));
            demThemelist.get(0).setHold2(ft.format(demThemelist.get(0).getEndDate()));


            j.getBody().put("demThemelist", demThemelist);
        } else {

            j.getBody().put("demThemelist", "0");
        }


        return renderString(response, j);
    }


    /**
     * @return
     * @Description 获取区域
     */
    @RequestMapping(value = "/getregion")
    @ResponseBody

    public String getregion(HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        Area area = new Area();
        List<Area> areaList = demScoreDao.findAreaList(area);
        if (areaList.size() > 0 && areaList != null) {
            j.getBody().put("dictList", areaList);
        } else {
            j.getBody().put("dictList", "0");
        }

        return renderString(response, j);
    }


    /**
     * @return
     * @Description 获取评议
     */

    @RequestMapping(value = "/gettopic")
    @ResponseBody

    public String gettopic(String id, HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        List<String> unitList = demScoreDao.getquestiontype(id);
        Area area = new Area();
        area.setId(id);
        Office office = new Office();
        office.setArea(area);
        List<Object> listData = new ArrayList<Object>();

        for (int i = 0; i < unitList.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            List<Office> list = new ArrayList<Office>();
            Office office1 = new Office();
            office1.setType(unitList.get(i));
            list = demScoreDao.findUnitList(office1);
            DictUtils.getDictLabel(unitList.get(i), "dem_type", "");
            map.put(DictUtils.getDictLabel(unitList.get(i), "dem_type", ""), list);
            listData.add(map);
        }
        j.getBody().put("listData", listData);
        DemTheme demTheme = new DemTheme();

        demTheme.setHold1("fbnf");

        List<DemTheme> demThemelist = demThemeService.findList(demTheme);

        if(demThemelist.size()>0&&demThemelist!=null){

            List<Dict> dictList = DictUtils.getDictList(demThemelist.get(0).getYear());
            if (dictList.size() > 0 && dictList != null) {
                j.getBody().put("dictList", dictList);
            } else {

                j.getBody().put("dictList", "0");
            }
        }

        return renderString(response, j);
    }


    /**
     * @returna
     * @Description 存取评议结果
     */

    @RequestMapping(value = "/accessresults")
    @ResponseBody
    public String accessresults(@RequestBody String params, HttpServletResponse response) {
        logger.info(params);
        AjaxJson j = new AjaxJson();
        try {
            params = URLDecoder.decode(params, "utf-8");
            params = params.replace("=", "");
        } catch (UnsupportedEncodingException e) {
            return "解码失败!";
        }
        logger.info(params);
        JSONObject json = JSON.parseObject(params);
        String userId = "";
        String quxianId = "";
//        DemUser demUser=null;


        logger.info(params);
        userId = json.getString("userID").trim();//用户id
        if(userId==null||"".equals(userId)){
            j.getBody().put("info", "系统异常，请重新登录！");
            return renderString(response, j);
        }



        logger.info("++++++++++++++++++++"+userId);
        quxianId = json.getString("areaID").trim();//行政id



        String userType = json.getString("sfID").trim();//人员类型
        String opinion = json.getString("advice").trim();//人员建议

        String ninadu = json.getString("year").trim();
        List<DemScore> list = new ArrayList<DemScore>();
        DemUser demUser = demUserService.get(userId);

        //获取单位（题），分数，存入分数表
        // list = (List<DemScore>) json.get("danweiList");
        String danweiList = json.getString("res");
        JSONArray jsonArray = JSON.parseArray(danweiList);


        for (int i = 0; i < jsonArray.size(); i++) {
            Object obj = jsonArray.get(i);
            System.out.println(obj.toString());
            JSONObject jsonObject = JSON.parseObject(obj.toString());

            DemScore demScore = new DemScore();
            demScore.setPersonid(userId.trim());//用户id
            demScore.setHold2(userType.trim());//人员类型id
            demScore.setHold1(quxianId.trim());//行政部门id
            demScore.setYear(demUser.getYear());//年度
            demScore.setOfficeid(jsonObject.getString("name").trim());//单位（题）id
            demScore.setResult(jsonObject.getString("value").trim());//分数

            Office office = null;
            try {
                office = officeService.get(jsonObject.getString("name").trim());
            } catch (Exception e) {
                e.printStackTrace();
                j.getBody().put("info", "系统异常，请重新登录！");
                return renderString(response, j);
            }
            demScore.setOfficename(office.getName());//单位（题）名称
            demScore.setReviewType(DictUtils.getDictLabel(office.getType(), "dem_type", ""));//单位类型名称
            demScoreService.save(demScore);
            demScore = null;
        }


        demUser.setStatus("1");

        String areaName=areaDao.getAreaNameByid(quxianId.trim());
        logger.info(quxianId+"***********************"+areaName);

        demUser.setHold1(areaName);//区域名称
        demUser.setHold2(userType);//人员类型id
        demUser.setOfficeid(quxianId.trim());//区域id
        demUser.setOpinion(opinion);//评议建议
        demUserService.save(demUser);

        j.getBody().put("info", "评议保存成功");
        return renderString(response, j);
    }






}