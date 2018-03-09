package com.smartlibrary.controller;

import com.smartlibrary.service.CrossAnalysisService;
import com.smartlibrary.service.gctrlService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/cross_analysis" })
public class CrossAnalysisController {
    private static final Logger logger = Logger.getLogger(gctrlService.class);
    @Autowired
    private CrossAnalysisService crossAnalysisService;

}
