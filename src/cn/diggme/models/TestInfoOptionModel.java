package cn.diggme.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * TestInfoOptionModel
 *
 * @author Develop
 * @modified 2017-11-08
 * @copyright develop@diggme.cn
 * @lisence MIT
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestInfoOptionModel implements Serializable {

    /**
     * 人口信息选项ID
     */
    @JsonProperty("id")
    private int id;

    /**
     * 人口信息选项名称
     */
    @JsonProperty("name")
    private String name;

    /**
     * 人口信息选项名称
     */
    @JsonProperty("label")
    private String label;

    /**
     * 人口信息选项值
     */
    @JsonProperty("value")
    private String value;

    /**
     * 人口信息选项绑定角色ID
     */
    @JsonProperty("role_id")
    private int roleId;

    /**
     * 人口信息选项是否可用
     */
    @JsonProperty("disabled")
    private boolean disabled;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "TestInfoOptionModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", value='" + value + '\'' +
                ", roleId=" + roleId +
                ", disabled=" + disabled +
                '}' + '\n';
    }
}
