package cn.diggme.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * TestQuestionModel
 *
 * @author Develop
 * @modified 2017-11-08
 * @copyright develop@diggme.cn
 * @lisence MIT
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestQuestionModel implements Serializable {

    /**
     * 题目ID
     */
    @JsonProperty("id")
    private int id;

    /**
     * 题目标题
     */
    @JsonProperty("title")
    private String title;

    /**
     * 题目图片
     */
    @JsonProperty("image")
    private String image;

    /**
     * 题目类型
     * radio_text：文字单选
     * checkbox_text：文字多选
     * radio_image：图片单选
     * checkbox_image：图片多选
     * sort_text：文字排序
     * sort_image：图片排序
     * cursor_text：文字游标
     * cursor_image：图片游标
     * fill_text：填空
     * intro：指导语
     */
    @JsonProperty("type")
    private String type;

    /**
     * 题目显示时间
     */
    @JsonProperty("during")
    private int during;

    /**
     * 是否为图片题目
     */
    @JsonProperty("is_image")
    private int isImage;

    /**
     * 题目选项
     */
    @JsonProperty("options")
    private ArrayList<?> options;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuring() {
        return during;
    }

    public void setDuring(int during) {
        this.during = during;
    }

    public int getIsImage() {
        return isImage;
    }

    public void setIsImage(int isImage) {
        this.isImage = isImage;
    }

    public ArrayList<?> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<?> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "TestQuestionModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                ", during=" + during +
                ", isImage=" + isImage +
                ", options=" + options +
                '}';
    }
}
