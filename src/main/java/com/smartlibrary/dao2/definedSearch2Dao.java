package com.smartlibrary.dao2;

import com.smartlibrary.domain.DefinedPersonAssetSearch;
import com.smartlibrary.domain.DefinedResult;

import java.util.List;

public interface definedSearch2Dao {
    List<DefinedResult> getDefinedPersonAsset(DefinedPersonAssetSearch definedPersonAssetSearch);

}
