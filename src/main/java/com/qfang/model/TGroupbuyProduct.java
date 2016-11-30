package com.qfang.model;

import java.util.Date;

/**
*
* @Title TGroupbuyProduct
* @Description 
* @author ch
* @Date 2016年11月15日 17:51:45
 */
public class TGroupbuyProduct {
    private Integer FId;

    private Integer FEntityId;

    private String FEntityType;

    private String FEntityName;

    private String FTitle;

    private String FSubtitle;

    /** 优化标题 */
    private String FFavorableTitle;

    private Date FStartTime;

    private Date FEndTime;

    private String FOriginalPrice;

    private String FFavorablePrice;

    private String FPhone;

    private String FCoverPic;

    private String FAppCoverPic;

    private String FStatus;

    private Integer FCustomerCount;

    private Integer FClickCount;

    private Long FLevel;

    private String FTitle1;

    private String FTitle2;

    private String FTitle3;

    private String FPic1;

    private String FPic2;

    private String FPic3;

    private Date FUpdateTime;

    private Date FCreateTime;

    private String FDetailPic;

    private String FOtherPic;

    /** 是否为首页推荐，1是0否 */
    private Boolean FRecommend;

    private String FCity;

    public Integer getFId() {
        return FId;
    }

    public TGroupbuyProduct setFId(Integer FId) {
        this.FId = FId;
        return this;
    }

    public Integer getFEntityId() {
        return FEntityId;
    }

    public TGroupbuyProduct setFEntityId(Integer FEntityId) {
        this.FEntityId = FEntityId;
        return this;
    }

    public String getFEntityType() {
        return FEntityType;
    }

    public TGroupbuyProduct setFEntityType(String FEntityType) {
        this.FEntityType = FEntityType == null ? null : FEntityType.trim();
        return this;
    }

    public String getFEntityName() {
        return FEntityName;
    }

    public TGroupbuyProduct setFEntityName(String FEntityName) {
        this.FEntityName = FEntityName == null ? null : FEntityName.trim();
        return this;
    }

    public String getFTitle() {
        return FTitle;
    }

    public TGroupbuyProduct setFTitle(String FTitle) {
        this.FTitle = FTitle == null ? null : FTitle.trim();
        return this;
    }

    public String getFSubtitle() {
        return FSubtitle;
    }

    public TGroupbuyProduct setFSubtitle(String FSubtitle) {
        this.FSubtitle = FSubtitle == null ? null : FSubtitle.trim();
        return this;
    }

    /** 优化标题 */
    public String getFFavorableTitle() {
        return FFavorableTitle;
    }

    public TGroupbuyProduct setFFavorableTitle(String FFavorableTitle) {
        this.FFavorableTitle = FFavorableTitle == null ? null : FFavorableTitle.trim();
        return this;
    }

    public Date getFStartTime() {
        return FStartTime;
    }

    public TGroupbuyProduct setFStartTime(Date FStartTime) {
        this.FStartTime = FStartTime;
        return this;
    }

    public Date getFEndTime() {
        return FEndTime;
    }

    public TGroupbuyProduct setFEndTime(Date FEndTime) {
        this.FEndTime = FEndTime;
        return this;
    }

    public String getFOriginalPrice() {
        return FOriginalPrice;
    }

    public TGroupbuyProduct setFOriginalPrice(String FOriginalPrice) {
        this.FOriginalPrice = FOriginalPrice == null ? null : FOriginalPrice.trim();
        return this;
    }

    public String getFFavorablePrice() {
        return FFavorablePrice;
    }

    public TGroupbuyProduct setFFavorablePrice(String FFavorablePrice) {
        this.FFavorablePrice = FFavorablePrice == null ? null : FFavorablePrice.trim();
        return this;
    }

    public String getFPhone() {
        return FPhone;
    }

    public TGroupbuyProduct setFPhone(String FPhone) {
        this.FPhone = FPhone == null ? null : FPhone.trim();
        return this;
    }

    public String getFCoverPic() {
        return FCoverPic;
    }

    public TGroupbuyProduct setFCoverPic(String FCoverPic) {
        this.FCoverPic = FCoverPic == null ? null : FCoverPic.trim();
        return this;
    }

    public String getFAppCoverPic() {
        return FAppCoverPic;
    }

    public TGroupbuyProduct setFAppCoverPic(String FAppCoverPic) {
        this.FAppCoverPic = FAppCoverPic == null ? null : FAppCoverPic.trim();
        return this;
    }

    public String getFStatus() {
        return FStatus;
    }

    public TGroupbuyProduct setFStatus(String FStatus) {
        this.FStatus = FStatus == null ? null : FStatus.trim();
        return this;
    }

    public Integer getFCustomerCount() {
        return FCustomerCount;
    }

    public TGroupbuyProduct setFCustomerCount(Integer FCustomerCount) {
        this.FCustomerCount = FCustomerCount;
        return this;
    }

    public Integer getFClickCount() {
        return FClickCount;
    }

    public TGroupbuyProduct setFClickCount(Integer FClickCount) {
        this.FClickCount = FClickCount;
        return this;
    }

    public Long getFLevel() {
        return FLevel;
    }

    public TGroupbuyProduct setFLevel(Long FLevel) {
        this.FLevel = FLevel;
        return this;
    }

    public String getFTitle1() {
        return FTitle1;
    }

    public TGroupbuyProduct setFTitle1(String FTitle1) {
        this.FTitle1 = FTitle1 == null ? null : FTitle1.trim();
        return this;
    }

    public String getFTitle2() {
        return FTitle2;
    }

    public TGroupbuyProduct setFTitle2(String FTitle2) {
        this.FTitle2 = FTitle2 == null ? null : FTitle2.trim();
        return this;
    }

    public String getFTitle3() {
        return FTitle3;
    }

    public TGroupbuyProduct setFTitle3(String FTitle3) {
        this.FTitle3 = FTitle3 == null ? null : FTitle3.trim();
        return this;
    }

    public String getFPic1() {
        return FPic1;
    }

    public TGroupbuyProduct setFPic1(String FPic1) {
        this.FPic1 = FPic1 == null ? null : FPic1.trim();
        return this;
    }

    public String getFPic2() {
        return FPic2;
    }

    public TGroupbuyProduct setFPic2(String FPic2) {
        this.FPic2 = FPic2 == null ? null : FPic2.trim();
        return this;
    }

    public String getFPic3() {
        return FPic3;
    }

    public TGroupbuyProduct setFPic3(String FPic3) {
        this.FPic3 = FPic3 == null ? null : FPic3.trim();
        return this;
    }

    public Date getFUpdateTime() {
        return FUpdateTime;
    }

    public TGroupbuyProduct setFUpdateTime(Date FUpdateTime) {
        this.FUpdateTime = FUpdateTime;
        return this;
    }

    public Date getFCreateTime() {
        return FCreateTime;
    }

    public TGroupbuyProduct setFCreateTime(Date FCreateTime) {
        this.FCreateTime = FCreateTime;
        return this;
    }

    public String getFDetailPic() {
        return FDetailPic;
    }

    public TGroupbuyProduct setFDetailPic(String FDetailPic) {
        this.FDetailPic = FDetailPic == null ? null : FDetailPic.trim();
        return this;
    }

    public String getFOtherPic() {
        return FOtherPic;
    }

    public TGroupbuyProduct setFOtherPic(String FOtherPic) {
        this.FOtherPic = FOtherPic == null ? null : FOtherPic.trim();
        return this;
    }

    /** 是否为首页推荐，1是0否 */
    public Boolean getFRecommend() {
        return FRecommend;
    }

    public TGroupbuyProduct setFRecommend(Boolean FRecommend) {
        this.FRecommend = FRecommend;
        return this;
    }

    public String getFCity() {
        return FCity;
    }

    public TGroupbuyProduct setFCity(String FCity) {
        this.FCity = FCity == null ? null : FCity.trim();
        return this;
    }
}