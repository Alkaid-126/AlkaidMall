package com.Alkaid.AlkaidMall;

import com.Alkaid.AlkaidMall.bean.*;

import java.util.List;

public interface ManageService {
    /**
     * 得到一级列表
     * @return
     */
    public List<BaseCatalog1> getCatalog1();

    /**
     * 根据一级列表得到二级列表
     * @param catalog1Id
     * @return
     */
    public List<BaseCatalog2> getCatalog2(String catalog1Id);

    /**
     * 根据二级列表得到三级列表
     * @param catalog2Id
     * @return
     */
    public List<BaseCatalog3> getCatalog3(String catalog2Id);

    /**
     * 得到基本属性，通过3级列表
     * @param catalog3Id
     * @return
     */
    public List<BaseAttrInfo> getAttrList(String catalog3Id);

    /**
     * 新增属性
     * @param baseAttrInfo
     */
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    List<BaseAttrValue> getAttrValueList(String attrId);
}
