package cn.diggme.example;

import cn.diggme.DiggmeSdk;
import cn.diggme.exceptions.InvalidParamsException;
import cn.diggme.exceptions.RemoteServerException;
import cn.diggme.models.*;
import org.json.JSONObject;
import org.json.JSONString;

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
            TestModel testModel = sdk.getTestDetail(51);
            System.out.println("getTestDetail >>>>>>");
            System.out.println(testModel);

            //【合作商可以同步测试列表到本地商品模块做外键test_id绑定】

            // 获取测试兑换码
            // 合作商订单ID、或订单流水
            String outTradeNo = "your_order_id_" + Math.random();
            String inCode = sdk.getTestCode(testModel.getId(), outTradeNo);
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
            TestCodeStatusModel statusModel = sdk.getTestCodeStatus(inCode, testModel.getId());
            System.out.println("getTestCodeStatus >>>>>>");
            System.out.println(statusModel);

            // ------------ 人口学信息与角色页面 ------------

            // 获取人口学信息列表
            ArrayList<TestInfoModel> infoList = sdk.getTestInfoList(testModel.getId());
            System.out.println("getTestInfoList >>>>>>");
            System.out.println(infoList);


            // 处理用户填写的测试人口学信息
            // key 值对应为【TestInfoModel】的code
            // value 值对应为【TestInfoOptionModel】的value，如【TestInfoModel】为text类型，则是用户的输入
            //      如：your_name_key => '小明'
            JSONObject setting = new JSONObject();
            setting.put("role", "男");
            System.out.println("postTestInfo Pre-processing setting>>>>>>");
            System.out.println(setting.toString());

            // 处理用户选择的角色ID
            // 角色ID统一绑定在【TestInfoModel】为radio类型的子选项【TestInfoOptionModel】下的roleId
            //      如：TestInfoOptionModel{id=354, name='父亲（或者扮演父亲角色的人）', label='父亲（或者扮演父亲角色的人）', value='父亲（或者扮演父亲角色的人）, roleId=1, disabled=false}
            //         TestInfoOptionModel{id=355, name='母亲（或者扮演母亲角色的人）', label='母亲（或者扮演母亲角色的人）', value='母亲（或者扮演母亲角色的人）', roleId=2, disabled=false}
            //         TestInfoOptionModel{id=394, name='孩子', label='孩子', value='孩子', roleId=3, disabled=false}
            // 用户选项为父亲、则当前用户则角色id = 1
            // 如果当前测试不需要设定角色，roleId = 0 即可
            int userRoleId = 1;
            System.out.println("postTestInfo Pre-processing roleId>>>>>>");
            System.out.println(userRoleId);

            Boolean isPostTestInfoSuccess = sdk.postTestInfo(testModel.getId(), inCode, setting.toString(), userRoleId);
            System.out.println("postTestInfo >>>>>>");
            System.out.println(isPostTestInfoSuccess);

            // ------------ 答题页面 ------------

            // 用户选择的角色id, 可读取getTestCodeStatus获取
            userRoleId = 1;

            // 获取答题列表
            ArrayList<TestQuestionModel> questionList = sdk.getTestQuestionList(inCode, testModel.getId(), userRoleId);
            System.out.println("getTestQuestionList >>>>>>");
            System.out.println(questionList);

            // 提交答案
//            sdk.postTestResult();

            // ------------ 报告页面 ------------

//            sdk.getTestReport();

        } catch (InvalidParamsException e) {
            e.printStackTrace();
        } catch (RemoteServerException e) {
            e.printStackTrace();
        }

    }

}