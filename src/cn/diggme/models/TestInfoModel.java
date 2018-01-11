package cn.diggme.models;

import java.util.ArrayList;

public class TestInfoModel {

    private int id;
    private String name;
    private String code;
    private String type;
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
                '}';
    }

}