package com.smartlibrary.dao2;

import com.smartlibrary.domain2.Counts;

import java.util.List;

/**
 * Created by zian on 2017/9/28.
 */
public interface PersonAssetDao {
    List<Counts> getCountsBySex();

    List<Counts> getCountsByYear();

    List<Counts> getAssetByYear();

    List<Counts> getAssetByFloor();
}
