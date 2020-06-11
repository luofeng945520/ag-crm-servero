package com.cn.ag.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cn.ag.exception.TransferException;
import com.cn.ag.exception.WrongStateException;
import com.cn.ff.utils.BeanConversion.Json.GsonManager;
import com.cn.ff.utils.ReflexUtil;
import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.RequestParam;
import com.cn.ff.utils.comm.support.ResultData;
import com.cn.ff.utils.comm.support.WhereParam;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class UtilTools {

	public static FrontRequestParam analysisPagesParam(FrontRequestParam frontRequestParam){
		//定义分页数据
    	//当前页
		int page = frontRequestParam.getPage() <=0 ? 1 : frontRequestParam.getPage();
		//每页数据量 最少10条
		int pageDataNumber = frontRequestParam.getPageDataNumber()<=0 ? 1 : frontRequestParam.getPageDataNumber();
		//计算MYSQL limit
		int startIndex,endIndex;

		endIndex = pageDataNumber;
		//endIndex = page * pageDataNumber;
		endIndex = Math.max(endIndex, 0);

		startIndex = (page-1)*pageDataNumber;
		//startIndex = endIndex - pageDataNumber;
		startIndex = Math.max(startIndex, 0);

		frontRequestParam.setPage(page);
    	frontRequestParam.setPageDataNumber(pageDataNumber);
    	frontRequestParam.setStartIndex(startIndex);
    	frontRequestParam.setEndIndex(endIndex);
		return frontRequestParam;
	}
	
	public static String md5Encode(String inStr){
		MessageDigest md5 = null;
		try{
			md5 = MessageDigest.getInstance("MD5");
		}catch(Exception e){
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		byte[] byteArray = null;
		try {
			byteArray = inStr.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for(int i=0;i<md5Bytes.length;i++){
			int val = md5Bytes[i] & 0xff;
			if(val<16){
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}


	public static final Map<String,String> op = new HashMap();
	static {
		op.put("WOP01", ">");
		op.put("WOP02", "<");
		op.put("WOP03", "<>");
		op.put("WOP04", "=");
		op.put("WOP05", "<=");
		op.put("WOP06", ">=");
		op.put("WOP07", "LIKE");
		op.put("WOP08", "NOT LIKE");
		op.put("WOP09", "IN");
		op.put("WOP10", "desc");
		op.put("WOP11", "asc");
		op.put("WOP12", "is");
		op.put("WOP13", "LIKE");//'%*'以*结尾
		op.put("WOP14", "LIKE");//'*%'以*开始
		op.put("WOP15", "NOT LIKE");//'%*'不以*结尾
		op.put("WOP16", "NOT LIKE");//'*%'不以*开始
		op.put("WOP17","IS NOT");
	}

	
	public static String praseWhereParam(List<WhereParam> wpLists){
		
		String w="";
		
		if(wpLists==null || wpLists.size()<=0) return null;
	
		@SuppressWarnings("unused")
		int i = 0;
		for (WhereParam wp : wpLists) {
			w = w + " " + wp.getSetup();
			w = w + " " + wp.getKey();
			w = w + " " + (String) op.get(wp.getOp());
			if (wp.getValueType().equals("string")) {
				if (op.get(wp.getOp()).equals("LIKE") && wp.getOp().equals("WOP07")) {
					w = w + " '%" + wp.getValue() + "%'";
				} else if (op.get(wp.getOp()).equals("is")) {
					w = w + " " + wp.getValue();
				} else if (op.get(wp.getOp()).equals("NOT LIKE") && wp.getOp().equals("WOP08")) {
					w = w+ " '%"+ wp.getValue() + "%'";
				}else if(op.get(wp.getOp()).equals("LIKE") && wp.getOp().equals("WOP13")){
					w = w+ " '%"+ wp.getValue() + "'";
				}else if(op.get(wp.getOp()).equals("LIKE") && wp.getOp().equals("WOP14")){
					w = w+ " '"+ wp.getValue() + "%'";
				}else if(op.get(wp.getOp()).equals("NOT LIKE") && wp.getOp().equals("WOP15")){
					w = w+ " '%"+ wp.getValue() + "'";
				}else if(op.get(wp.getOp()).equals("NOT LIKE") && wp.getOp().equals("WOP16")){
					w = w+ " '"+ wp.getValue() + "%'";
				}else if (wp.getOp().equals("WOP09")) {
					w = w + "(" + wp.getValue() + ")";
				}else if ((wp.getOp().equals("WOP12") || wp.getOp().equals("WOP17")) && (wp.getValue().equals("null") || wp.getValue().equals("NULL"))){
					w = w + " " + wp.getValue();
				}else{
					w = w + " '" + wp.getValue() + "'";
				}
			} else if (wp.getValueType().equals("int")) {
				if (wp.getOp().equals("WOP09")) {
					w = w + "(" + wp.getValue() + ")";
				} else {
					w = w + " " + wp.getValue();
				}
			}
		}
		return w;
	}

	/**
	 * @Description:
	 * @Param
	 * @Return
	 * @throws
	 * 2020/5/5 8:36
	 */
	public static <T> T getObject(String param, Class<T> clazz) throws Exception{
		T t;
		GsonManager gm = GsonManager.getIns();
		RequestParam requestParam=null;
		try {
			requestParam=gm.jsonToAnyObject(param, RequestParam.class);
			if(FrontRequestParam.class.equals(clazz)) {
				t = requestParam.getFrontRequestParamOfClz(clazz);
			}else {
				t = requestParam.getValueOfClz(clazz);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("parameter error");
		}
		if(objcetIsNull(t)) {
			throw new NullPointerException("parameter is empty");
		}
		
		return t;
		
	}
	
	/**
	 * 
	 * @Title: objcetIsNull  
	 * @Description: 判断 对象 属性为空    全为空返回true 不为空返回false
	 * @param @param t
	 * @param @return    参数  
	 * @return boolean    返回类型  
	 * @throws
	 */
	public static <T> boolean objcetIsNull(T t) {
		if(t==null) {
			return true;
		}
		Class clazz = t.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);//设置访问权限
			try {
				Object object = field.get(t);

				if(object != null && object instanceof String) {
					if(object.toString().trim().length()!=0) {
						return false;
					}
					
				}
				if(object != null && !(object instanceof String)) {
					return false;
				}
				
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	/**
	 * ==>将对象A 有值的属性 的值 赋予  对象B 的属性
	 */
	public <T> void putValueToOtherObj(T a,T b) {
		if(a == null || b == null) {
			throw new NullPointerException("参数为空");
		}
		if(!a.getClass().equals(b.getClass())) {
			throw new IllegalArgumentException("参数类型不一致");
		}
		Class clazz = a.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);//设置访问权限
			try {
				Object value = field.get(a);
				if(value != null && !field.getType().equals(List.class)) {
					field.set(b, value);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @Title: getParam
	 * @Description: 获取前台参数指定key-value
	 *  @param param  前台参数
	 *  @param attribute  想要获取的属性
	 *  @param clazz	属性值的类型
	 *  @return    设定文件
	 *  Object    返回类型
	 *  2019年3月8日 上午9:37:56
	 * @throws
	 */
	public static <T> T getValueByKey(String param, String attribute,Class<T> clazz) throws IllegalArgumentException,NullPointerException {
		Object obj=null;
		GsonManager gm = GsonManager.getIns();
		RequestParam requestParam;
		try {
			requestParam=gm.jsonToAnyObject(param, RequestParam.class);
			JsonObject value = requestParam.getValue();
			JsonElement jsonElement = value.get(attribute);
			if(!jsonElement.isJsonNull()) {
				if(clazz.equals(String.class)) {
					obj = jsonElement.getAsString();
				}else if(clazz.equals(Double.class)) {
					obj = jsonElement.getAsDouble();
				}else if(clazz.equals(Integer.class)) {
					obj = jsonElement.getAsInt();
				}else if(clazz.equals(List.class)){
					obj = jsonElement.getAsJsonArray();
					obj = gm.jsonToAnyObject(obj.toString(),List.class);
				} else if (clazz.equals(Long.class)){
					obj = jsonElement.getAsLong();
				} else{
					obj = jsonElement.getAsString();
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("parameter error");
		}
		if(obj == null) {
			throw new NullPointerException("parameter is empty");
		}
		return (T) obj;
	}  
	
	/**
	 *
	 * @Description: 返回分页数据
	 * @Title: returnData
	 * @param dataCount 条数
	 * @param frontRequestParam
	 * @param list 对象集合
	 * @return 设定文件
	 * @return ResultData 返回类型
	 * @date 2019年2月25日 下午5:07:12
	 * @throws
	 */
	public static <T> ResultData returnData(int dataCount, FrontRequestParam frontRequestParam, List<T> list) {
		// 定义输出MAP
		Map<String, Object> ret = new HashMap<>();
		ret.put("object", list);
		if (frontRequestParam == null){
			return UtilParm.resultData(1, "ok", ret);
		}
		int pagesCount = (int) Math.ceil(dataCount / 1.0 / frontRequestParam.getPageDataNumber());
		pagesCount = pagesCount <= 0 ? 1 : pagesCount;
		if (list == null || list.size() <= 0) {
			return UtilParm.resultData(0, "暂无数据", null);
		}

		ret.put("dataCount", dataCount);
		ret.put("page", frontRequestParam.getPage());
		ret.put("pagesCount", pagesCount);
		ret.put("pageDataNumber", frontRequestParam.getPageDataNumber());
		return UtilParm.resultData(1, "ok", ret);
	}

	public static <T> ResultData returnData(int dataCount, FrontRequestParam frontRequestParam, Set<T> list) {
		// 定义输出MAP
		Map<String, Object> ret = new HashMap<>();
		ret.put("object", list);
		if (frontRequestParam == null){
			return UtilParm.resultData(1, "ok", ret);
		}
		int pagesCount = (int) Math.ceil(dataCount / 1.0 / frontRequestParam.getPageDataNumber());
		pagesCount = pagesCount <= 0 ? 1 : pagesCount;
		if (list == null || list.size() <= 0) {
			return UtilParm.resultData(0, "暂无数据", null);
		}

		ret.put("dataCount", dataCount);
		ret.put("page", frontRequestParam.getPage());
		ret.put("pagesCount", pagesCount);
		ret.put("pageDataNumber", frontRequestParam.getPageDataNumber());
		return UtilParm.resultData(1, "ok", ret);
	}

	/**
	 * @Description: 转换参数  只能用 returnData(int dataCount, FrontRequestParam frontRequestParam, List<T> list) 的结果
	 * @Param
	 * @Return
	 * @throws
	 * 2019/11/19 10:38
	 * @Author milk
	 */
	public static void resultData(ResultData resultData,String toName){
		Map<String, Object> value = (Map<String, Object>) resultData.getValue();
		value.put(toName,value.get("object"));
		value.remove("object");
	}


	public static  <T> List<T> reList(List list, Class<T> clazz) throws Exception {
		GsonManager gm = GsonManager.getIns();

		List<T> lsit = new ArrayList<T>();
		for (Object t : list) {
			Object jsonToAnyObject = gm.jsonToAnyObject(JSON.toJSONString(t), clazz);
			lsit.add(clazz.cast(jsonToAnyObject));
		}
//	    System.out.println(lsit.toString());
		return lsit;
	}

	public static <T> List<T> reList(JsonArray jsonArray, Class<T> clazz) throws Exception{
		GsonManager gm = GsonManager.getIns();
		List<T> list = new ArrayList<>();
		for (JsonElement jsonElement : jsonArray){
			T t = gm.jsonToAnyObject(gm.objectToJsonStr(jsonElement), clazz);
			list.add(t);
		}
		return list;
	}

	/**@Description: (将查询分页条件转为map)
	 * @return
	 * @param
	 * @throws
	 */
	public Map<String,Object> paramToMap(String param) throws Exception{
		FrontRequestParam frontRequestParam = getObject(param,FrontRequestParam.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whereParam", praseWhereParam(frontRequestParam.getWheres()));
		if(frontRequestParam.getPage()!=0) {
			analysisPagesParam(frontRequestParam);
			map.put("startIndex", frontRequestParam.getStartIndex());
			map.put("endIndex", frontRequestParam.getEndIndex());
		}
	return map;
	}


	/**
	 * @Description: 比较resource的不为null的属性 与 tagat的属性   有不同则返回false
	 * @Param resource 来源对象  taget 目标对象
	 * @Return  boolean
	 * @throws
	 * 2019/8/2 15:31
	 * @Author milk
	 */
	public <T>  boolean equalsObjectAttr(T resource,T taget){
		Class<?> rClass = resource.getClass();
		Class<?> tClass = taget.getClass();

		if (rClass.getName().startsWith("java.lang")){
			return resource.equals(taget);
		}
		
//		if (!rClass.equals(tClass)){
//			return false;
//		}

//		Field[] fields = rClass.getDeclaredFields();
		List<Field> allField = new ArrayList<>();
		getAllField(rClass,allField);

		for (Field f:allField) {
			//设置访问权限
			f.setAccessible(true);
			try {
				Object o = f.get(resource);

				if (o != null && f.getType().getName().startsWith("java.lang")){
					Field tClassDeclaredField = null;
					try {
						tClassDeclaredField = tClass.getDeclaredField(f.getName());
					} catch (NoSuchFieldException | SecurityException e) {
						continue;
					}
					//设置访问权限
					tClassDeclaredField.setAccessible(true);
					Object o1 = tClassDeclaredField.get(taget);
					if (!o.equals(o1)){
						return false;
					}
				}

			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	private <T> void getAllField(Class<T> t,List<Field> list){
		Field[] declaredFields = t.getDeclaredFields();
		List<Field> fields = Arrays.asList(declaredFields);
		list.addAll(fields);
		if (!t.getSuperclass().equals(Object.class)){
			getAllField(t.getSuperclass(),list);
		}
	}

	public static Map<String,Object> objectToMap(Object object){
		Map<String,Object> map = new HashMap<>();
		Class<?> clazz = object.getClass();
		for (Field field : clazz.getDeclaredFields()){
			field.setAccessible(true);
			String fieldName = field.getName();
			try {
				Object value = field.get(object);
				map.put(fieldName,value);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}

	public static String getUUIDUpperCase(){
		return UUID.randomUUID().toString().replace("-","").toUpperCase();
	}

	/**
	* @MethodName:pagingHelper
	* @Description: TODO 处理
	* @Param:[frontRequestParam]
	* @Return:java.util.Map<java.lang.String,java.lang.Object>
	* @Author:Amber
	* @Data:2019/11/11
	* @Remarks:
	*/
	public static Map<String,Object> pagingHelper(FrontRequestParam frontRequestParam){
		Map<String,Object> args = new HashMap<>();
		UtilTools.analysisPagesParam(frontRequestParam);
		args.put("startIndex",frontRequestParam.getStartIndex());
		args.put("endIndex",frontRequestParam.getEndIndex());
		String whereParam = UtilTools.praseWhereParam(frontRequestParam.getWheres());
		args.put("whereParam",whereParam);
		return args;
	}

	/**
	* @MethodName:returnMapGenerator
	* @Description: TODO 分页返回数据生成器（在调用pagingHelper之后才能使用）
	* @Param:[dataCount, frontRequestParam]
	* @Return:java.util.Map<java.lang.String,java.lang.Object>
	* @Author:Amber
	* @Data:2019/11/11
	* @Remarks:
	*/
	public static <T> Map<String,Object> pagingReturnMapGenerator(Integer dataCount, FrontRequestParam frontRequestParam,Object object){
		int pagesCount = dataCount / frontRequestParam.getPageDataNumber();
		pagesCount = pagesCount<=0 ? 1 : pagesCount;
		Map<String,Object> returnMap = new HashMap<>();
		returnMap.put("entityList", object);
		returnMap.put("dataCount", dataCount);
		returnMap.put("page", frontRequestParam.getPage());
		returnMap.put("pagesCount", pagesCount);
		returnMap.put("pageDataNumber", frontRequestParam.getPageDataNumber());
		return returnMap;
	}

	/**
	* @MethodName:getClassName
	* @Description: TODO 获取类名
	* @Param:[t]
	* @Return:java.lang.String
	* @Author:Amber
	* @Data:2019/11/11
	* @Remarks:
	*/
	private static <T> String getClassName(T t){
		return t.getClass().getSimpleName();
	}



	public static Map<String,Object> jsonToMap(String jsonString){
		return JSON.parseObject(jsonString,new TypeReference<Map<String,Object>>(){} );
	}

	public static <T> T parseValueAttribute(String param,String attributeName,TypeReference<T> typeReference) throws WrongStateException {
		T t = null;
		JSONObject value = JSON.parseObject(param).getJSONObject("value");
		if (value==null){
			throw new NullPointerException("Empty value");
		}
		String attribute = value.getString(attributeName);
		if (typeReference.getType().getTypeName().equals("java.lang.String")){
			throw new WrongStateException("String can not be parsed");
		}
		if (StringUtils.isBlank(attribute)){
			throw new NullPointerException("No such attribute["+attributeName+"]");
		}
		t = JSON.parseObject(attribute, typeReference);
		if (t==null){
			throw new NullPointerException("Empty object");
		}
		return t;
	}

	public static String parseValueAttributeString(String param,String attributeName){
		JSONObject value = JSON.parseObject(param).getJSONObject("value");
		if (value==null){
			throw new NullPointerException("empty value");
		}
		return value.getString(attributeName);
	}


	public static <T> boolean emptyList(List<T> list){
		return list == null || list.isEmpty();
	}


	public static void compressFile(File file, OutputStream outputStream) throws IOException {

		byte[] buf = new byte[1024];

		ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream,StandardCharsets.UTF_8);

		zipOutputStream.putNextEntry(new ZipEntry(file.getName()));

		int len;
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		while ((len=bufferedInputStream.read(buf))!=-1){
			zipOutputStream.write(buf,0,len);
		}

		zipOutputStream.closeEntry();
		zipOutputStream.close();
		bufferedInputStream.close();
		outputStream.close();


	}

	public static void compressFile(List<File> files,OutputStream outputStream) throws IOException {
		byte[] buf = new byte[1024];
		ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream,StandardCharsets.UTF_8);
		FileInputStream fileInputStream;
		BufferedInputStream bufferedInputStream = null;

		for (File file : files) {
			zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
			int len;
			fileInputStream = new FileInputStream(file);
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			while ((len=bufferedInputStream.read(buf))!=-1){
				zipOutputStream.write(buf,0,len);
			}

		}

		if (bufferedInputStream != null) {
			bufferedInputStream.close();
		}
		zipOutputStream.closeEntry();
		zipOutputStream.close();
		outputStream.close();

	}



	public static boolean isChineseChar(char c){
		return String.valueOf(c).matches("[\u4e00-\u9fa5]");
	}



	public static boolean paramCheck(String[] fieldNames,Object object) throws IllegalAccessException {
		//验证参数是否为空
		return emptyFieldCheck(ReflectUtils.retainFields(Arrays.asList(fieldNames), ReflectUtils.fieldsOf(object)),object);
	}

	private static boolean emptyFieldCheck(Field[] retainFields, Object object) throws IllegalAccessException {
		for (Field retainField : retainFields) {
			retainField.setAccessible(true);
			Object fieldValue = retainField.get(object);
			if (fieldValue ==null || "".equals(fieldValue.toString())){
				throw new NullPointerException("空参数异常,字段[" + retainField.getName() + "]");
			}
		}
		return true;
	}

	public static  <T> List<T> reList(List<LinkedTreeMap<String, Object>> object, Class<T> clazz, String keyName) {
		GsonManager gm = GsonManager.getIns();

		if (object == null || object.isEmpty()) {
			return null;
		}

		List<T> lsit = new ArrayList<>();
		try {
			for (LinkedTreeMap<String, Object> ts : object) {
				T t = gm.jsonToAnyObject(gm.objectToJsonStr(ts), clazz);
				copyAttr(t, ts);
				lsit.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lsit;
	}

	private static <T> void copyAttr(T t,Map<String,Object> source) throws IllegalAccessException {

		Class<?> tClass = t.getClass();
		//获取所有属性
		List<Field> allField = ReflexUtil.getAllField(tClass);

		Set<String> set = source.keySet();

		for (Field declaredField : allField) {
			for (String key : set) {
				//不区分大小写比较  若是一样属性名 并且 值为空
				if (declaredField.getName().equals(key)){
					//设置可访问
					declaredField.setAccessible(true);
					if (declaredField.get(t) != null){
						break;
					}
					//设置属性值
					Object value = source.get(key);
					if (value != null && declaredField.getType().getName().contains("BigDecimal")){
						declaredField.set(t,new BigDecimal(String.valueOf(value)));
					}else if (value != null && declaredField.getType().getName().startsWith("java.lang")){
						declaredField.set(t,value);
					}else if(value == null && declaredField.getType().getName().startsWith("java")) {
						declaredField.set(t,null);
					}else{
						throw new TransferException("数据转换失败 "+ declaredField.getType().getName());
					}
					break;
				}
			}
		}
	}
}
