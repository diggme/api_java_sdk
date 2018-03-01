package cn.diggme.models;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdFrameModel {

    /**
     * 广告位ID
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * 广告位名称
     */
    @JsonProperty("name")
    private String name;

    /**
     * 广告位别名
     */
    @JsonProperty("alias")
    private String alias;

    /**
     * 广告位备注
     */
    @JsonProperty("remark")
    private String remark;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("alias")
    public String getAlias() {
        return alias;
    }

    @JsonProperty("alias")
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @JsonProperty("remark")
    public String getRemark() {
        return remark;
    }

    @JsonProperty("remark")
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AdFrameModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

}