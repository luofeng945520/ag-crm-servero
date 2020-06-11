package com.cn.ag.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.cn.ff.utils.BeanConversion.Json.GsonManager;
import com.cn.ff.utils.comm.support.RequestParam;
import com.cn.ff.utils.comm.support.ResultData;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttp {

	private static Logger logger = LoggerFactory.getLogger(OkHttp.class);

	public static String postDataWithParame(Map<String, Object> map) {
		OkHttpClient client = new OkHttpClient();
		RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"),
				"json");
		RequestBody headers=new FormBody.Builder().add("code", map.get("code").toString()).add("sc", map.get("sc").toString())
				.add("custname", map.get("custname").toString())
				.add("address", map.get("address").toString())
				.build();
		Request request = new Request.Builder().url(map.get("url").toString()).post(body).post(headers).build();
		String str = "";
		try {
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				str = response.body().string();
			}
			System.err.println("str:"+str);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return str;
	}

	public static String post(String url,Map<String,Object> map){
		OkHttpClient client = new OkHttpClient().newBuilder()
				.connectTimeout(2000,TimeUnit.SECONDS)
				.readTimeout(2000, TimeUnit.SECONDS)
				.build();
		RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"),
				"json");
		FormBody.Builder builder = new FormBody.Builder();
		for (String key : map.keySet()) {
			builder.add(key,map.get(key).toString());
		}
		RequestBody headers= builder.build();

		Request request = new Request.Builder().url(url).post(body).post(headers).build();
		String str = "";
		try {
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				str = response.body().string();
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return null;
		}

		return str;
	}

	public static <T> ResultData doPost(String requestAddr, T param, String paramName) throws Exception {

		String post = OkHttp.post(requestAddr, getOkHttpParam(paramName,param));

		return  GsonManager.getIns().jsonToAnyObject(post, ResultData.class);
	}

	public static <T,E> E doPost(String requestAddr, T param, String paramName, TypeReference<E> typeReference) throws Exception {
		String post = OkHttp.post(requestAddr, getOkHttpParam(paramName,param));
		ResultData resultData = null;
		try {
			resultData = GsonManager.getIns().jsonToAnyObject(post, ResultData.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (resultData==null){
			throw new NullPointerException("ResultData为空！");
		}
		if (resultData.getCode()==0){
			throw new IllegalArgumentException(resultData.getMsg());
		}
		return JSON.parseObject(JSON.toJSONString(resultData.getValue()),typeReference);
	}

	/**
	 * @Description: 封装请求参数 M5格式
	 * @Param
	 * @Return
	 * @throws
	 * 2020/5/8 14:28
	 */
	private static <T> Map<String,Object> getOkHttpParam(String attributeName,T t) throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put(attributeName,t);
		String s = GsonManager.getIns().objectToJsonStr(map);
		JsonObject jsonObject = GsonManager.getIns().jsonToAnyObject(s, JsonObject.class);
		RequestParam requestParam = new RequestParam();
		requestParam.setValue(jsonObject);
		Map<String,Object> args = new HashMap<>();
		args.put("param", GsonManager.getIns().objectToJsonStr(requestParam));
		return args;
	}

	/**
	 * @Description: 转发网络请求文件
	 * @Param
	 * @Return
	 * @throws
	 * 2019/12/17 8:49
	 * @Author milk
	 */
	public static String post(String url, Map<String,String> map, MultipartFile multipartFile, String temporaryDirectory){

		MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

		if (map != null){
			for (String key : map.keySet()) {
				builder.addFormDataPart(key,map.get(key));
			}
		}

		//临时存储
		File file = new File(temporaryDirectory + File.separator + System.currentTimeMillis()+ File.separator + multipartFile.getOriginalFilename());
		File parentFile = file.getParentFile();
		if (!parentFile.exists()){
			boolean mkdirs = parentFile.mkdirs();
			if (!mkdirs){
				return null;
			}

			try {
				multipartFile.transferTo(file);
			} catch (IOException e) {
				return null;
			}
		}


		builder.addFormDataPart("file",multipartFile.getOriginalFilename(),RequestBody.create(MediaType.parse("text/xml"),file));

		MultipartBody build = builder.build();

		Request request = new Request.Builder().url(url)
				.post(build)
				.build();

		try {
			OkHttpClient client = new OkHttpClient().newBuilder()
					.connectTimeout(200, TimeUnit.SECONDS)
					.readTimeout(200, TimeUnit.SECONDS)
					.build();

			Response execute = client.newCall(request).execute();
			if (execute.isSuccessful()) {
				return execute.body().string();
			}
			return null;
		} catch (IOException e) {
			return null;
		}finally {
			boolean delete = file.delete();
			if (delete){
				boolean deleteF = parentFile.delete();
				if (deleteF){
					logger.info("临时文件删除成功");
				}
			}
		}
	}

}
