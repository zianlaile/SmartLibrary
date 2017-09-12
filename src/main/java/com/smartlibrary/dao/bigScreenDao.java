package com.smartlibrary.dao;

import com.smartlibrary.domain.BigScreen;

import java.util.List;

/**
 * Created by 胡云飞 on 2017/9/11.
 */
public interface bigScreenDao {
    public abstract List<BigScreen> getnumber();
    public abstract List<BigScreen> getlend();
    public abstract List<BigScreen> getresource();
}
