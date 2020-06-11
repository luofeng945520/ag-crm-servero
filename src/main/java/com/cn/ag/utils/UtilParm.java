package com.cn.ag.utils;


import com.cn.ff.utils.comm.support.ResultData;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class UtilParm {
	
	private static Logger logger = LoggerFactory.getLogger(UtilParm.class);

		public static ModelAndView errorData(HttpServletRequest request, int code, String errorString) {
			ModelAndView modelAndView = new ModelAndView("weberror");
			modelAndView.addObject("code", code);
			modelAndView.addObject("msg", errorString);
			if (request.getParameter("callback")!=null) {
				modelAndView.addObject("call", request.getParameter("callback"));
				modelAndView.setViewName("weberror-call");
			}
			else{
				modelAndView.setViewName("weberror");
			}
			return modelAndView;
		}


		public static String resultDataString(int code,String msg){
		Gson gs = new Gson();

		ResultData data = new ResultData();
		data.setCode(code);
		data.setMsg(msg);
		return gs.toJson(data);
		
	}

		public static ResultData resultData(int code,String msg){
			ResultData data = new ResultData();
			data.setCode(code);
			data.setMsg(msg);
			return data;
		}
		/**
		 * @Description: TODO(这里用一句话描述这个方法的作用)
		 * @Param 
		 * @Return 
		 * @throws 
		 * 2019/7/22 11:49
		 * @Author amber
		 */ 
		public static <T> ResultData resultData(int code,String msg,T e){
			ResultData data = new ResultData();
			data.setCode(code);
			data.setMsg(msg);
			data.setValue(e);
			//输出MSG到控制台
		UtilParm.logger.debug("执行输出对象----"+data);
		return data;
	}

	/**
	 * @Description: 下载文件
	 * @Param
	 * @Return
	 * @throws
	 * 2020/4/25 17:24
	 * @Author milk
	 */
	public static void browserDownload(HttpServletResponse response, File file) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/octet-stream; charset=UTF-8");
		response.setContentType("application/x-download");
		response.setHeader("content-disposition", "attachment;filename=" + new String((file.getName()).getBytes(), StandardCharsets.ISO_8859_1));

		ServletOutputStream outputStream = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		int temp;
		byte[] buffer = new byte[1024];
		while ((temp = fis.read(buffer))!=-1){
			outputStream.write(buffer,0,temp);
		}


		fis.close();
		outputStream.flush();
		outputStream.close();
		response.flushBuffer();
		logger.info("下载文件："+file.getName());
	}
	
	
	
}
