package com.qfang.dao;

import com.qfang.model.TGroupbuyProduct;
import com.qfang.model.TGroupbuyProductWithBLOBs;

public interface TGroupbuyProductMapper {
    int insert(TGroupbuyProductWithBLOBs tGroupbuyProductWithBLOBs);

    int insertSelective(TGroupbuyProductWithBLOBs tGroupbuyProductWithBLOBs);

    TGroupbuyProductWithBLOBs selectByPrimaryKey(Integer FId);

    int updateByPrimaryKeySelective(TGroupbuyProductWithBLOBs tGroupbuyProductWithBLOBs);

    int updateByPrimaryKeyWithBLOBs(TGroupbuyProductWithBLOBs tGroupbuyProductWithBLOBs);

    int updateByPrimaryKey(TGroupbuyProduct tGroupbuyProduct);

    int deleteByPrimaryKey(Integer FId);
}