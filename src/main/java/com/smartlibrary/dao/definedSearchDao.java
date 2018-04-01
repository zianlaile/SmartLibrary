package com.smartlibrary.dao;

import com.smartlibrary.domain.*;

import java.util.List;

public interface definedSearchDao {
    List<DefinedResult> getDefinedBook(DefinedBookSearch definedBookSearch);

    List<DefinedResult> getDefinedGctrl(DefinedGctrlSearch definedGctrlSearch);

    List<DefinedResult> getDefinedIc(DefinedIcSearch definedIcSearch);

    List<DefinedResult> getDefinedPrint(DefinedPrintSearch definedPrintSearch);

    List<DefinedResult> getDefinedPersonAsset(DefinedPersonAssetSearch definedPersonAssetSearch);

    List<DefinedRankResult> getDefinedRank(DefinedRankSearch definedRankSearch);
}
