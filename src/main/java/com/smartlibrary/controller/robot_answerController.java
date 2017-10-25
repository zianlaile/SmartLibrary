package com.smartlibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.smartlibrary.service.rebot_answerService;
import com.smartlibrary.service.bigScreenService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 胡云飞 on 2017/10/18.
 */
@Controller
@RequestMapping("/rebot")
public class robot_answerController {
    @Autowired
    private rebot_answerService rebot_answerService;
    @Autowired
    private bigScreenService bigScreenService;
    @RequestMapping(method = RequestMethod.GET,value = "/booknumber", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getBookNumber(){
        return "图书馆共有图书"+rebot_answerService.getNumber("all_book")+"本";
    }
    @RequestMapping(method = RequestMethod.GET,value = "/crooms", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getCrooms(){
        Map result = bigScreenService.getSysfxx();
        return "图书馆共有研修间"+result.get("uRoomTotal")+"间，剩余"+result.get("uRoomIdle")+"间";
    }
    @RequestMapping(method = RequestMethod.GET,value = "/ereads", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getEreads(){
        Map result = bigScreenService.getSysfxx();
        return "图书馆共有电子阅览室"+result.get("uPCTotal")+"个，剩余"+result.get("uPCIdel")+"个";
    }
    @RequestMapping(method = RequestMethod.GET,value = "/gctrl", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getGctrl(){
        return "图书馆累计进馆"+rebot_answerService.getNumber("all_gctrl")+"人次，今日进馆"+rebot_answerService.getNumber("now_gctrl")+"人次";
    }
    @RequestMapping(method = RequestMethod.GET,value = "/seats", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getSeats(){
        Map result = bigScreenService.getSysfxx();
        return "图书馆共有座位"+result.get("uSeatTotal")+"个，剩余"+result.get("uSeatIdel")+"个";
    }
}
