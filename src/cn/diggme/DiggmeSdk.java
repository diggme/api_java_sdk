package cn.diggme;

import cn.diggme.exceptions.InvalidParamsException;
import cn.diggme.exceptions.RemoteServerException;
import cn.diggme.models.*;
import cn.diggme.utils.EncryptHelper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DiggmeSdk {

    private String appKey = "";
    private String appSecret = "";
    private String serverUrl = "https://api.diggme.cn/api/";
    private String version = "v1";
    private String env = "production";
    private String accessToken = "";

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        switch (env) {
            case "local":
                this.serverUrl = "http://api.diggme.local/api/" + this.version + '/';
                break;
            case "develop":
                this.serverUrl = "http://apidev.diggme.cn/api/" + this.version + '/';
                break;
            case "production":
            default:
                this.serverUrl = "https://api.diggme.cn/api/" + this.version + '/';
        }
    }

    public DiggmeSdk(String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.setEnv("");
    }

    public DiggmeSdk(String appKey, String appSecret, String env) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.setEnv(env);
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * 发起HTTP请求
     *
     * @param path
     * @param method
     * @param params
     * @return
     * @throws InvalidParamsException
     * @throws RemoteServerException
     */
    protected JSONObject makeRequest(String path, String method, Map<String, String> params) throws InvalidParamsException, RemoteServerException {
        try {
            HttpResponse<JsonNode> jsonResponse = null;
            Iterator<? extends Map.Entry<?, ?>> entries = params.entrySet().iterator();

            if (method.toLowerCase().equals("post")) {
                HttpRequestWithBody request = Unirest.post(this.serverUrl.concat(path)).header("Authorization", this.accessToken);
                while (entries.hasNext()) {
                    Map.Entry<?, ?> entry = entries.next();
                    request.field((String) entry.getKey(),entry.getValue());
                }
                jsonResponse = request.asJson();
                System.out.print("POST:URL >>>>>> ");
                System.out.println(request.getUrl());
            } else {
                GetRequest request = Unirest.get(this.serverUrl.concat(path)).header("Authorization", this.accessToken);
                while (entries.hasNext()) {
                    Map.Entry<?, ?> entry = entries.next();
                    request.queryString((String) entry.getKey(), entry.getValue());
                }
                jsonResponse = request.asJson();
                System.out.print("GET:URL >>>>>> ");
                System.out.println(request.getUrl());
            }

            JSONObject result = jsonResponse.getBody().getObject();

            checkResultStatus(result);

            return result;
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 请求结果判定
     *
     * @param result
     * @throws InvalidParamsException
     * @throws RemoteServerException
     */
    protected void checkResultStatus(JSONObject result) throws InvalidParamsException, RemoteServerException {
        if (result == null) {
            throw new InvalidParamsException("返回数据为空");
        } else if (!result.has("http_status")) {
            throw new InvalidParamsException("返回http_status状态码为空");
        } else if (result.getInt("http_status") != 200 && result.getInt("http_status") != 500) {
            throw new InvalidParamsException(result.getString("msg"));
        } else if (result.getInt("http_status") == 500) {
            throw new RemoteServerException(result.getString("msg"));
        }
        if (!result.has("data")) {
            throw new InvalidParamsException("返回data数据为空");
        }
    }

    /**
     * 获取访问令牌
     *
     * @param grantType
     * @return AccessTokenModel | null
     * @throws InvalidParamsException
     * @throws RemoteServerException
     */
    public AccessTokenModel getOpenAccessToken(String grantType) throws InvalidParamsException, RemoteServerException {
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", grantType);
        params.put("app_key", this.appKey);
        params.put("app_secret", this.appSecret);

        JSONObject result = makeRequest("open/token", "get", params);
        if (result.isNull("data")) {
            return null;
        }
        try {
            JSONObject jsonObject = result.getJSONObject("data");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonObject.toString(), AccessTokenModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取单个广告位
     *
     * @param frameId
     * @return AdBannerModel | null
     * @throws InvalidParamsException
     * @throws RemoteServerException
     */
    public AdBannerModel getAdBanner(int frameId) throws InvalidParamsException, RemoteServerException {
        Map<String, String> params = new HashMap<>();
        params.put("frame_id", String.valueOf(frameId));

        JSONObject result = makeRequest("channel/ad/banner", "get", params);
        if (result.isNull("data")) {
            return null;
        }
        try {
            JSONObject jsonObject = result.getJSONObject("data");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonObject.toString(), AdBannerModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取多个广告位
     *
     * @param frameId
     * @return ArrayList<AdBannerModel> | null
     * @throws InvalidParamsException
     * @throws RemoteServerException
     */
    public ArrayList<AdBannerModel> getAdBanners(int frameId) throws InvalidParamsException, RemoteServerException {
        Map<String, String> params = new HashMap<>();
        params.put("frame_id", String.valueOf(frameId));

        JSONObject result = makeRequest("channel/ad/banners", "get", params);
        if (result.isNull("data")) {
            return null;
        }
        try {
            JSONArray data = result.getJSONArray("data");
            ArrayList<AdBannerModel> list = new ArrayList<>();
            Iterator it = data.iterator();
            while (it.hasNext()) {
                JSONObject jsonObject = (JSONObject) it.next();
                ObjectMapper mapper = new ObjectMapper();
                list.add(mapper.readValue(jsonObject.toString(), AdBannerModel.class));
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 测试列表
     *
     * @param categoryId
     * @param size
     * @param page
     * @return ArrayList<TestModel> | null
     * @throws InvalidParamsException
     * @throws RemoteServerException
     */
    public ArrayList<TestModel> getTestList(int categoryId, int size, int page) throws InvalidParamsException, RemoteServerException {
        Map<String, String> params = new HashMap<>();
        params.put("frame_id", String.valueOf(categoryId));
        params.put("size", String.valueOf(size));
        params.put("page", String.valueOf(page));

        JSONObject result = makeRequest("channel/test/list", "get", params);
        if (result.isNull("data")) {
            return null;
        }
        try {
            JSONArray data = result.getJSONArray("data");
            ArrayList<TestModel> list = new ArrayList<>();
            Iterator it = data.iterator();
            while (it.hasNext()) {
                JSONObject jsonObject = (JSONObject) it.next();
                ObjectMapper mapper = new ObjectMapper();
                list.add(mapper.readValue(jsonObject.toString(), TestModel.class));
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 测试分类
     *
     * @return ArrayList<TestCategoryModel> | null
     * @throws InvalidParamsException
     * @throws RemoteServerException
     */
    public ArrayList<TestCategoryModel> getTestCategoryList() throws InvalidParamsException, RemoteServerException {

        Map<String, String> params = new HashMap<>();

        JSONObject result = makeRequest("channel/test/category/list", "get", params);
        if (result.isNull("data")) {
            return null;
        }
        try {
            JSONArray data = result.getJSONArray("data");
            ArrayList<TestCategoryModel> list = new ArrayList<>();
            Iterator it = data.iterator();
            while (it.hasNext()) {
                JSONObject jsonObject = (JSONObject) it.next();
                ObjectMapper mapper = new ObjectMapper();
                list.add(mapper.readValue(jsonObject.toString(), TestCategoryModel.class));
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取测试兑换码状态(支付状态\是否包含人口学角色信息\是否生成报告\是否支持重测)
     *
     * @param inCode
     * @param testId
     * @return TestCodeStatusModel | null
     */
    public TestCodeStatusModel getTestCodeStatus(String inCode, int testId) throws InvalidParamsException, RemoteServerException {
        Map<String, String> params = new HashMap<>();
        params.put("in_code", inCode);
        params.put("test_id", String.valueOf(testId));

        JSONObject result = makeRequest("channel/ad/banner", "get", params);
        if (result.isNull("data")) {
            return null;
        }
        try {
            JSONObject jsonObject = result.getJSONObject("data");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonObject.toString(), TestCodeStatusModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取测试订单兑换码
     *
     * @param testId
     * @param outTradeNo
     * @return String | null
     */
    public String getTestCode(int testId, String outTradeNo) throws InvalidParamsException, RemoteServerException {
        Map<String, String> params = new HashMap<>();
        params.put("test_id", String.valueOf(testId));
        params.put("no", outTradeNo);

        JSONObject result = makeRequest("channel/test/code", "get", params);
        if (result.isNull("data")) {
            return null;
        }
        return result.getJSONObject("data").getString("code");
    }

    /**
     * 订单状态回调 (支付成功)
     *
     * @param encryptData
     * @return boolean
     * @throws InvalidParamsException
     * @throws RemoteServerException
     */
    public boolean postNotifyPayCb(String encryptData) throws InvalidParamsException, RemoteServerException {

        encryptData = EncryptHelper.encrypt(this.appSecret, encryptData);

        Map<String, String> params = new HashMap<>();
        params.put("encrypt_data", encryptData);

        JSONObject result = makeRequest("channel/notify/payCb", "post", params);
        if (result.isNull("data")) {
            return false;
        }
        return result.getInt("http_status") == 200;
    }

}
