package cn.diggme.models.enums;


public enum TestInfoEnum {

    RADIO("radio", "复选框"),
    CHECKBOX("text", "复选框"),
    TEXT("text", "文本框"),
    DATE("date", "日期框");

    private String name;
    private String key;

    TestInfoEnum(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
