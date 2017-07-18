package com.smartlibrary.service;

import com.smartlibrary.domain.gctrl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by tt on 2017/7/18.
 */
@Service
public class gctrlService {
    private static final Logger logger = Logger.getLogger(gctrlService.class);
   /* @Autowired
    private gctrlDao gctrldao;*/
    public Map<String,List> getGctrlCountByYear(gctrl b) {
        return null;
    }

    public Map<String,List> getGctrlCountByMonth(gctrl b) {
        return null;
    }

    public Map<String,List> getGctrlCountByDay(gctrl b) {
        return null;
    }
}
