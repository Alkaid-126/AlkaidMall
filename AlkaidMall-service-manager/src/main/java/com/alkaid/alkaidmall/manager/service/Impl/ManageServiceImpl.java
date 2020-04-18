package com.alkaid.alkaidmall.manager.service.Impl;

import com.Alkaid.AlkaidMall.ManageService;
import com.Alkaid.AlkaidMall.bean.*;
import com.alibaba.dubbo.config.annotation.Service;
import com.alkaid.alkaidmall.manager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;
    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;
    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;
    @Autowired
    private BaseCatalog3Mapper baseCatalog3Mapper;
    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;

    @Override
    public List<BaseCatalog1> getCatalog1() {
        return baseCatalog1Mapper.selectAll();
    }

    @Override
    public List<BaseCatalog2> getCatalog2(String catalog1Id) {
        BaseCatalog2 baseCatalog2=new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);
        List<BaseCatalog2> baseCatalog2List = baseCatalog2Mapper.select(baseCatalog2);
        return baseCatalog2List;
    }

    @Override
    public List<BaseCatalog3> getCatalog3(String catalog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);
        return baseCatalog3Mapper.select(baseCatalog3);
    }

    @Override
    public List<BaseAttrInfo> getAttrList(String catalog3Id) {
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(catalog3Id);

        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoMapper.select(baseAttrInfo);
        return baseAttrInfoList;
    }

    @Transactional
    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        //修改
        if(baseAttrInfo.getId() != null || baseAttrInfo.getId().length() > 0){
            baseAttrInfoMapper.updateByPrimaryKey(baseAttrInfo);
        }else {
            //保存数据
            baseAttrInfoMapper.insertSelective(baseAttrInfo);
        }
        //不管是新增和修改都需要进行对Value表的操作
        //baseAttrValue? 先删除数据 再进行插入操作
        BaseAttrValue baseAttrValueDel = new BaseAttrValue();
        baseAttrValueDel.setAttrId(baseAttrInfo.getId());
        baseAttrValueMapper.delete(baseAttrValueDel);
        //重新插入属性值 baseAttrValue表格
        if(baseAttrInfo.getAttrValueList() != null && baseAttrInfo.getAttrValueList().size() > 0){
                for(BaseAttrValue baseAttrValue1 : baseAttrInfo.getAttrValueList() ){
                    baseAttrValue1.setId(null);
                    //baseAttrInfo.getId() = baseAttrValue1.attrId
                    baseAttrValue1.setAttrId(baseAttrInfo.getId());
                    baseAttrValueMapper.insertSelective(baseAttrValue1);
                }
            }

    }

    @Override
    public List<BaseAttrValue> getAttrValueList(String attrId) {
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(attrId);
        return baseAttrValueMapper.select(baseAttrValue);
    }
}
