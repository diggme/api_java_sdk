package cn.diggme.example;

import cn.diggme.DiggmeSdk;
import cn.diggme.exceptions.InvalidParamsException;
import cn.diggme.exceptions.RemoteServerException;
import cn.diggme.models.*;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

class PlanC {

    public static void main(String... args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        // 填写必要信息
        int ChannelId = 0;
        String appKey = "";
        String appSecret = "";

        try {
            // 初始化SDK
            DiggmeSdk sdk = new DiggmeSdk(appKey, appSecret);

            // 设置sdk接口环境 develop / production
            sdk.setEnv("develop");

            // 获取访问令牌 (合作商可使用缓存方案,避免频繁获取的网络延时)
            AccessTokenModel accessTokenModel = sdk.getOpenAccessToken("client_credential");
            // 设置SDK访问令牌
            sdk.setAccessToken(accessTokenModel.getAccessToken());
            System.out.println("getAccessToken >>>>>>");
            System.out.println(accessTokenModel.getAccessToken());

            // 获取测试分类列表
            ArrayList<TestCategoryModel> categoryList = sdk.getTestCategoryList();
            System.out.println("getTestCategoryList >>>>>>");
            System.out.println(categoryList);

            //【合作商可以同步测试列表到本地商品模块做外键test_id绑定】

            // 获取测试列表
            int categoryId = 0;
            int page = 1;
            int size = 20;
            ArrayList<TestModel> testList = sdk.getTestList(categoryId, page, size);
            System.out.println("getTestList >>>>>>");
            System.out.println(testList);

            // 获取测试详情
            TestModel testModel = sdk.getTestDetail(testList.get(0).getId());
            System.out.println("getTestDetail >>>>>>");
            System.out.println(testModel);

            //【合作商可以同步测试列表到本地商品模块做外键test_id绑定】

            // 获取测试兑换码
            // 合作商订单ID、或订单流水
            String outTradeNo = "your_order_id_" + Math.random();
            String inCode = sdk.getTestCode(testList.get(0).getId(), outTradeNo);
            System.out.println("getTestCode >>>>>>");
            System.out.println(inCode);

            // 合作商支付成功后, 回调通知DiggMe该in_code已支付
            String encryptData = (new JSONObject())
                    .put("status", "success")
                    .put("in_code", inCode)
                    .toString();

            Boolean isSuccess = sdk.postNotifyPayCb(encryptData);
            System.out.println("postNotifyPayCb >>>>>>");
            System.out.println(isSuccess);

            // 获取InCode状态, 如是否需要人口信息、是否需要角色填写、是否已生成报告
            TestCodeStatusModel statusModel = sdk.getTestCodeStatus(inCode, testList.get(0).getId());
            System.out.println("getTestCodeStatus >>>>>>");
            System.out.println(statusModel);

            // ------------ 人口学信息与角色页面 ------------

            // 获取人口学信息列表
            ArrayList<TestInfoModel> infoList = sdk.getTestInfoList(testList.get(0).getId());
            System.out.println("getTestInfoList >>>>>>");
            System.out.println(infoList);

            // 提交用户填写的测试人口学信息 和 角色ID

            // ------------ 答题页面 ------------

            // 用户选择的角色id, 可读取getTestCodeStatus获取
            int userRoleId = 0;

            // 获取答题列表
            ArrayList<TestQuestionModel> questionList = sdk.getTestQuestionList(inCode, testList.get(0).getId(), userRoleId);
            System.out.println("getTestQuestionList >>>>>>");
            System.out.println(questionList);

            // 提交答案
//            sdk.postTestResult()

            // ------------ 报告页面 ------------

//            sdk.getTestReport()

        } catch (InvalidParamsException e) {
            e.printStackTrace();
        } catch (RemoteServerException e) {
            e.printStackTrace();
        }

    }

}