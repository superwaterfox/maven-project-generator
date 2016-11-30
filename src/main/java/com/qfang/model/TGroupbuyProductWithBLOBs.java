package com.qfang.model;

/**
*
* @Title TGroupbuyProductWithBLOBs
* @Description 
* @author ch
* @Date 2016年11月15日 17:51:45
 */
public class TGroupbuyProductWithBLOBs extends TGroupbuyProduct {
    private String FDesc1;

    private String FDesc2;

    private String FDesc3;

    public String getFDesc1() {
        return FDesc1;
    }

    public TGroupbuyProductWithBLOBs setFDesc1(String FDesc1) {
        this.FDesc1 = FDesc1 == null ? null : FDesc1.trim();
        return this;
    }

    public String getFDesc2() {
        return FDesc2;
    }

    public TGroupbuyProductWithBLOBs setFDesc2(String FDesc2) {
        this.FDesc2 = FDesc2 == null ? null : FDesc2.trim();
        return this;
    }

    public String getFDesc3() {
        return FDesc3;
    }

    public TGroupbuyProductWithBLOBs setFDesc3(String FDesc3) {
        this.FDesc3 = FDesc3 == null ? null : FDesc3.trim();
        return this;
    }
}