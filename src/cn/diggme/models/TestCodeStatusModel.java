package cn.diggme.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * TestCodeStatusModel
 *
 * @author Develop
 * @modified 2017-11-08
 * @copyright develop@diggme.cn
 * @lisence MIT
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestCodeStatusModel implements Serializable {

    /**
     * 是否需要角色信息
     */
    @JsonProperty("require_role")
    private int requireRole;

    /**
     * 是否需要人口信息
     */
    @JsonProperty("require_info")
    private int requireInfo;

    /**
     * 是否完成角色设置
     */
    @JsonProperty("is_role_finish")
    private int isRoleFinish;

    /**
     * 是否完成人口学设置
     */
    @JsonProperty("is_info_finish")
    private int isInfoFinish;

    /**
     * 是否完成测试
     */
    @JsonProperty("is_test_finish")
    private int isTestFinish;


    /**
     * 支付状态
     */
    @JsonProperty("is_order_pay")
    private int isOrderPay;

    /**
     * 订单ID
     */
    @JsonProperty("order_id")
    private int orderId;

    /**
     * 测试ID
     */
    @JsonProperty("test_id")
    private int testId;

    /**
     * 测试次数限制
     */
    @JsonProperty("test_limit_time")
    private int testLimitTime;

    /**
     * 测试间隔限制（未生效）
     */
    @JsonProperty("test_limit_time_gap")
    private int testLimitTimeGap;

    /**
     * 测试答题类型（可选）
     * qa：对话形式
     * normal：普通形式
     * 此字段用于当前测试中建议使用的答题场景
     */
    @JsonProperty("test_qa_template")
    private String testQaTemplate;

    /**
     * 测试类型
     * 0：普通测试
     * 4：跳转测试
     */
    @JsonProperty("test_calculate_id")
    private int testCalculateId;

    /**
     * 测试结果匹配标题文案
     * 当 is_test_package 字段为 1 时生效
     */
    @JsonProperty("test_package_title")
    private String testPackageTitle;

    /**
     * 测试结果匹配标题简述
     * 当 is_test_package 字段为 1 时生效
     */
    @JsonProperty("test_package_brief")
    private String testPackageBrief;

    /**
     * 是否匹配测试
     */
    @JsonProperty("is_test_package")
    private int isTestPackage;

    /**
     * 用户选择的角色ID
     */
    @JsonProperty("user_role_id")
    private int userRoleId;

    /**
     * 用户结果ID
     */
    @JsonProperty("user_result_id")
    private int userResultId;

    /**
     * 用户剩余测试次数
     */
    @JsonProperty("user_limit_time_remain")
    private int userLimitTimeRemain;

    /**
     * 是否分段测试
     */
    @JsonProperty("require_part")
    private int requirePart;

    /**
     * 用户当前阶段的分段ID
     */
    @JsonProperty("user_part_id")
    private int userPartId;

    /**
     * 用户下个阶段的分段ID
     */
    @JsonProperty("next_part_id")
    private int nextPartId;

    public void setRequireRole(int requireRole) {
        this.requireRole = requireRole;
    }

    public int getRequireRole() {
        return requireRole;
    }

    public void setRequireInfo(int requireInfo) {
        this.requireInfo = requireInfo;
    }

    public int getRequireInfo() {
        return requireInfo;
    }

    public void setIsRoleFinish(int isRoleFinish) {
        this.isRoleFinish = isRoleFinish;
    }

    public int getIsRoleFinish() {
        return isRoleFinish;
    }

    public void setIsInfoFinish(int isInfoFinish) {
        this.isInfoFinish = isInfoFinish;
    }

    public int getIsInfoFinish() {
        return isInfoFinish;
    }

    public void setIsTestFinish(int isTestFinish) {
        this.isTestFinish = isTestFinish;
    }

    public int getIsTestFinish() {
        return isTestFinish;
    }

    public void setIsTestPackage(int isTestPackage) {
        this.isTestPackage = isTestPackage;
    }

    public int getIsTestPackage() {
        return isTestPackage;
    }

    public void setIsOrderPay(int isOrderPay) {
        this.isOrderPay = isOrderPay;
    }

    public int getIsOrderPay() {
        return isOrderPay;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestLimitTime(int testLimitTime) {
        this.testLimitTime = testLimitTime;
    }

    public int getTestLimitTime() {
        return testLimitTime;
    }

    public void setTestLimitTimeGap(int testLimitTimeGap) {
        this.testLimitTimeGap = testLimitTimeGap;
    }

    public int getTestLimitTimeGap() {
        return testLimitTimeGap;
    }

    public void setTestQaTemplate(String testQaTemplate) {
        this.testQaTemplate = testQaTemplate;
    }

    public String getTestQaTemplate() {
        return testQaTemplate;
    }

    public void setTestCalculateId(int testCalculateId) {
        this.testCalculateId = testCalculateId;
    }

    public int getTestCalculateId() {
        return testCalculateId;
    }

    public void setTestPackageTitle(String testPackageTitle) {
        this.testPackageTitle = testPackageTitle;
    }

    public String getTestPackageTitle() {
        return testPackageTitle;
    }

    public void setTestPackageBrief(String testPackageBrief) {
        this.testPackageBrief = testPackageBrief;
    }

    public String getTestPackageBrief() {
        return testPackageBrief;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserResultId(int userResultId) {
        this.userResultId = userResultId;
    }

    public int getUserResultId() {
        return userResultId;
    }

    public void setUserLimitTimeRemain(int userLimitTimeRemain) {
        this.userLimitTimeRemain = userLimitTimeRemain;
    }

    public int getUserLimitTimeRemain() {
        return userLimitTimeRemain;
    }

    public void setRequirePart(int requirePart) {
        this.requirePart = requirePart;
    }

    public int getRequirePart() {
        return requirePart;
    }

    public void setUserPartId(int userPartId) {
        this.userPartId = userPartId;
    }

    public int getUserPartId() {
        return userPartId;
    }

    public void setNextPartId(int nextPartId) {
        this.nextPartId = nextPartId;
    }

    public int getNextPartId() {
        return nextPartId;
    }

    @Override
    public String toString() {
        return "TestCodeStatusModel{" +
                "requireRole=" + requireRole +
                ", requireInfo=" + requireInfo +
                ", isRoleFinish=" + isRoleFinish +
                ", isInfoFinish=" + isInfoFinish +
                ", isTestFinish=" + isTestFinish +
                ", isTestPackage=" + isTestPackage +
                ", isOrderPay=" + isOrderPay +
                ", orderId=" + orderId +
                ", testId=" + testId +
                ", testLimitTime=" + testLimitTime +
                ", testLimitTimeGap=" + testLimitTimeGap +
                ", testQaTemplate='" + testQaTemplate + '\'' +
                ", testCalculateId=" + testCalculateId +
                ", testPackageTitle='" + testPackageTitle + '\'' +
                ", testPackageBrief='" + testPackageBrief + '\'' +
                ", userRoleId=" + userRoleId +
                ", userResultId=" + userResultId +
                ", userLimitTimeRemain=" + userLimitTimeRemain +
                ", requirePart=" + requirePart +
                ", userPartId=" + userPartId +
                ", nextPartId=" + nextPartId +
                '}';
    }
}