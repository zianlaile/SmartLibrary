package com.smartlibrary.dao;

import com.smartlibrary.domain.gctrl;

import java.util.List;

/**
 * Created by tt on 2017/7/18.
 */
public interface gctrlDao {
    public abstract List<gctrl> getGctrlCountByMonth(gctrl b);
    public abstract List<gctrl> getGctrlCountByYear(gctrl b);
    public abstract List<gctrl> getGctrlCountByDay(gctrl b);
    public abstract List<gctrl> getGctrlCountByDay2(gctrl b);

}
