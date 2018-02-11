package cn.diggme.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * TestInfoModel
 *
 * @author Develop
 * @modified 2017-11-08
 * @copyright develop@diggme.cn
 * @lisence MIT
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestInfoModel {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("code")
    private String code;

    @JsonProperty("type")
    private String type;

    @JsonProperty("options")
    private ArrayList<TestInfoOptionModel> options;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<TestInfoOptionModel> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<TestInfoOptionModel> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "TestInfoModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", options=" + options +
                '}' + '\n';
    }

}