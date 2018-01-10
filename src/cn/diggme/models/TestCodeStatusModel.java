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

    @JsonProperty("require_role")
    private int requireRole;

    @JsonProperty("require_info")
    private int requireInfo;

    @JsonProperty("is_role_finish")
    private int isRoleFinish;

    @JsonProperty("is_info_finish")
    private int isInfoFinish;

    @JsonProperty("is_test_finish")
    private int isTestFinish;

    @JsonProperty("is_test_package")
    private int isTestPackage;

    @JsonProperty("is_order_pay")
    private int isOrderPay;

    @JsonProperty("order_id")
    private int orderId;

    @JsonProperty("test_id")
    private int testId;

    @JsonProperty("test_limit_time")
    private int testLimitTime;

    @JsonProperty("test_limit_time_gap")
    private int testLimitTimeGap;

    @JsonProperty("test_qa_template")
    private String testQaTemplate;

    @JsonProperty("test_calculate_id")
    private int testCalculateId;

    @JsonProperty("test_hide_prev_btn")
    private int testHidePrevBtn;

    @JsonProperty("test_package_title")
    private String testPackageTitle;

    @JsonProperty("test_package_brief")
    private String testPackageBrief;

    @JsonProperty("user_role_id")
    private int userRoleId;

    @JsonProperty("user_result_id")
    private int userResultId;

    @JsonProperty("user_limit_time_remain")
    private int userLimitTimeRemain;

    @JsonProperty("require_part")
    private int requirePart;

    @JsonProperty("user_part_id")
    private int userPartId;

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

    public void setTestHidePrevBtn(int testHidePrevBtn) {
        this.testHidePrevBtn = testHidePrevBtn;
    }

    public int getTestHidePrevBtn() {
        return testHidePrevBtn;
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
                ", testHidePrevBtn=" + testHidePrevBtn +
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