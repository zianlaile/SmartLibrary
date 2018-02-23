package com.smartlibrary.dao2;

import com.smartlibrary.domain.DefinedSearchContent;

import java.util.List;

public interface definedSearchContent2Dao {
    List<DefinedSearchContent> getDefinedProfessionContent();
    List<DefinedSearchContent> getDefinedAssetTypeContent();

}
