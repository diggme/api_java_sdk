package cn.diggme.example;

import cn.diggme.*;
import cn.diggme.exceptions.*;
import cn.diggme.models.*;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

class Demo {

    public static void main(String... args) throws UnsupportedEncodingException, NoSuchAlgorithmException {


        String appKey = "interneltest#h5";
        String appSecret = "lgKJ7XJt4A6F9X71DWrOkn4eZhDtZnJA";

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

            // 获取单广告 [可选功能]
            int frameId = 1;
            AdBannerModel bannerModel = sdk.getAdBanner(frameId);
            System.out.println("getAdBanner >>>>>>");
            System.out.println(bannerModel);

            // 获取多个广告 [可选功能]
            ArrayList<AdBannerModel> banners = sdk.getAdBanners(frameId);
            System.out.println("getAdBanners >>>>>>");
            System.out.println(banners);

            // 获取广告位 [可选功能]
            ArrayList<AdFrameModel> adFrameList = sdk.getAdFrameList();
            System.out.println("getAdFrameList >>>>>>");
            System.out.print(adFrameList);

            // 获取测试兑换码
            // 合作商订单ID、或订单流水
            String outTradeNo = "your_order_id_2";
            String inCode = sdk.getTestCode(testList.get(0).getId(), outTradeNo);
            System.out.println("getTestCode >>>>>>");
            System.out.println(inCode);

            // 合作商支付成功后, 回调通知DiggMe该in_code已支付
            String encryptData = (new JSONObject())
                    .put("status", "success")
                    .put("in_code", "c6237665a5599575f07b-yca3KkNj")
                    .toString();

            Boolean isSuccess = sdk.postNotifyPayCb(encryptData);
            System.out.println("postNotifyPayCb >>>>>>");
            System.out.println(isSuccess);


        } catch (InvalidParamsException e) {
            e.printStackTrace();
        } catch (RemoteServerException e) {
            e.printStackTrace();
        }

    }

}