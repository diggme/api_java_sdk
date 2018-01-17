package cn.diggme.example;

import cn.diggme.*;
import cn.diggme.exceptions.*;
import cn.diggme.models.*;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

class PlanB {

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
            String outTradeNo = "your_order_id_2";
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

            // 加载提供网址
            // 人口学、答题、报告逻辑已封装好的H5
            // is_iframe 是否iframe模式
            String h5Url = "https://wx.diggme.cn/channel/entry.html?channel_id=%s&test_id=%s&in_code=%s&is_iframe=1";
            h5Url = String.format(h5Url,
                    String.valueOf(ChannelId),
                    String.valueOf(testList.get(0).getId()),
                    String.valueOf(inCode));
            System.out.println("reportUrl >>>>>>");
            System.out.println(h5Url);

        } catch (InvalidParamsException e) {
            e.printStackTrace();
        } catch (RemoteServerException e) {
            e.printStackTrace();
        }

    }

}