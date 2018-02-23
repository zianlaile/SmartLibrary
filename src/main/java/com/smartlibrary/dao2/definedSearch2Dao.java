package com.smartlibrary.dao2;

import com.smartlibrary.domain.DefinedResult;
import com.smartlibrary.domain2.DefinedPersonAssetSearch;

import java.util.List;

public interface definedSearch2Dao {
    List<DefinedResult> getDefinedPersonAsset(DefinedPersonAssetSearch definedPersonAssetSearch);

}
