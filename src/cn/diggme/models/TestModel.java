package cn.diggme.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TestModel
 *
 * @author Develop
 * @modified 2017-11-08
 * @copyright develop@diggme.cn
 * @lisence MIT
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestModel implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("img")
    private String img;

    @JsonProperty("pic")
    private String pic;

    @JsonProperty("title")
    private String title;

    @JsonProperty("brief")
    private String brief;

    @JsonProperty("content")
    private String content;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("discount_price")
    private BigDecimal discountPrice;

    @JsonProperty("base_price")
    private BigDecimal basePrice;

    @JsonProperty("category_id")
    private int categoryId;

    @JsonProperty("category_name")
    private String categoryName;

    @JsonProperty("category_pic")
    private String categoryPic;

    @JsonProperty("category_img")
    private String categoryImg;

    @JsonProperty("category_brief")
    private String categoryBrief;

    @JsonProperty("tested_num")
    private int testedNum;

    @JsonProperty("like_num")
    private int likeNum;

    @JsonProperty("limit_time")
    private String limitTime;

    @JsonProperty("base_category_id")
    private int baseCategoryId;

    @JsonProperty("base_category_name")
    private String baseCategoryName;

    @JsonProperty("base_category_brief")
    private String baseCategoryBrief;

    @JsonProperty("base_category_img")
    private String baseCategoryImg;

    @JsonProperty("base_category_pic")
    private String baseCategoryPic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryBrief() {
        return categoryBrief;
    }

    public void setCategoryBrief(String categoryBrief) {
        this.categoryBrief = categoryBrief;
    }

    public int getTestedNum() {
        return testedNum;
    }

    public void setTestedNum(int testedNum) {
        this.testedNum = testedNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public int getBaseCategoryId() {
        return baseCategoryId;
    }

    public void setBaseCategoryId(int baseCategoryId) {
        this.baseCategoryId = baseCategoryId;
    }

    public String getBaseCategoryName() {
        return baseCategoryName;
    }

    public void setBaseCategoryName(String baseCategoryName) {
        this.baseCategoryName = baseCategoryName;
    }

    public String getBaseCategoryBrief() {
        return baseCategoryBrief;
    }

    public void setBaseCategoryBrief(String baseCategoryBrief) {
        this.baseCategoryBrief = baseCategoryBrief;
    }

    public String getBaseCategoryImg() {
        return baseCategoryImg;
    }

    public void setBaseCategoryImg(String baseCategoryImg) {
        this.baseCategoryImg = baseCategoryImg;
    }

    public String getBaseCategoryPic() {
        return baseCategoryPic;
    }

    public void setBaseCategoryPic(String baseCategoryPic) {
        this.baseCategoryPic = baseCategoryPic;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", pic='" + pic + '\'' +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", discountPrice=" + discountPrice +
                ", basePrice=" + basePrice +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryBrief='" + categoryBrief + '\'' +
                ", testedNum=" + testedNum +
                ", likeNum=" + likeNum +
                ", limitTime='" + limitTime + '\'' +
                ", baseCategoryId=" + baseCategoryId +
                ", baseCategoryName='" + baseCategoryName + '\'' +
                ", baseCategoryBrief='" + baseCategoryBrief + '\'' +
                ", baseCategoryImg='" + baseCategoryImg + '\'' +
                ", baseCategoryPic='" + baseCategoryPic + '\'' +
                '}' + '\n';
    }
}
