package cn.diggme.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * TestCategoryModel
 *
 * @author Develop
 * @modified 2017-11-08
 * @copyright develop@diggme.cn
 * @lisence MIT
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestCategoryModel implements Serializable {

    /**
     * 测试分类ID
     */
    @JsonProperty("id")
    private int id;

    /**
     * 测试分类名称
     */
    @JsonProperty("name")
    private String name;

    /**
     * 测试分类图表
     */
    @JsonProperty("icon")
    private String icon;

    /**
     * 测试分类简介
     */
    @JsonProperty("brief")
    private String brief;

    /**
     * 测试小图
     */
    @JsonProperty("img")
    private String img;

    /**
     * 测试图表
     */
    @JsonProperty("pic")
    private String pic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
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

    @Override
    public String toString() {
        return "TestCategoryModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", brief='" + brief + '\'' +
                ", img='" + img + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }

}
