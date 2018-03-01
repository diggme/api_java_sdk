package cn.diggme.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * AdBannerModel
 *
 * @author Develop
 * @modified 2017-11-08
 * @copyright develop@diggme.cn
 * @lisence MIT
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdBannerModel implements Serializable {

    /**
     * 广告ID
     */
    @JsonProperty("id")
    private int id;

    /**
     * 绑定实体ID（可选）
     * 如：object_id=1 object_name=test 则表示绑定了对应ID=1的测试
     */
    @JsonProperty("object_id")
    private int objectId;

    /**
     * 绑定实体类型（可选）
     * 如：object_id=1 object_name=test 则表示绑定了对应ID=1的测试
     */
    @JsonProperty("object_name")
    private String objectName;

    /**
     * 广告标题
     */
    @JsonProperty("title")
    private String title;

    /**
     * 广告外链
     */
    @JsonProperty("url")
    private String url;

    /**
     * 广告封面图
     */
    @JsonProperty("image")
    private String image;

    /**
     * 广告开始时间（可选）
     */
    @JsonProperty("start")
    private String start;

    /**
     * 广告结束时间（可选）
     */
    @JsonProperty("end")
    private String end;

    /**
     * 广告排序
     */
    @JsonProperty("sort")
    private String sort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "AdBannerModel{" +
                "id='" + id + '\'' +
                ", objectId='" + objectId + '\'' +
                ", objectName='" + objectName + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }

}
