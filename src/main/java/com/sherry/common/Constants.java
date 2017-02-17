package com.sherry.common;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherry.common.util.MyFileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class Constants {

	public static Logger logger = Logger.getLogger("syx");

	public static String dateTimeToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ret = sdf.format(date);
		return ret;
	}

	public static Date stringToDateTime(String sdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(sdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date weixinDateStringToDateTime(String wdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = null;
		try {
			date = sdf.parse(wdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	

	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ret = sdf.format(date);
		return ret;
	}

	public static String longDateToString(long time) {
		Timestamp date = new Timestamp(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ret = sdf.format(date);
		return ret;
	}

	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
		return pattern.matcher(str).matches();
	}

	public static String getSmallByOrigin(String name) {
		String name1 = name.substring(0, name.lastIndexOf("."));
		String suffix = name.substring(name.lastIndexOf("."));
		return name1 + "-s" + suffix;
	}

	private static final String STR_FORMAT = "00000";

	public static final String getPatientCode(int reint) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String code = sdf.format(new Date());
		int codeID = reint % 100000;
		DecimalFormat df = new DecimalFormat(STR_FORMAT);
		String codeL = df.format(codeID);
		code = code + codeL;
		return code;

	}

	public static final String testMakJson() {

		ObjectMapper objectMapper = JacksonMapper.getInstance();

		List sellMedicalList = new ArrayList();
		Map sellMedical = new HashMap();
		sellMedical.put("fkUserMedicalId", 2);
		sellMedical.put("changeNum", 1);
		sellMedical.put("changePrice", 1);
		sellMedicalList.add(sellMedical);
		Map sellMedical2 = new HashMap();
		sellMedical2.put("fkUserMedicalId", 4);
		sellMedical2.put("changeNum", 1);
		sellMedical2.put("changePrice", 1);
		sellMedicalList.add(sellMedical2);

		String retStr = "";
		try {
			retStr = objectMapper.writeValueAsString(sellMedicalList);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retStr;

	}

	public static final void testParseJson(String jsonstr) {

		ObjectMapper objectMapper = JacksonMapper.getInstance();

		try {
			List<HashMap<String, Object>> list = objectMapper.readValue(jsonstr, List.class);
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = list.get(i);
				Set<String> set = map.keySet();
				for (Iterator<String> it = set.iterator(); it.hasNext();) {
					String key = it.next();
					System.out.println(key + ":" + map.get(key));
				}
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static final String saveTwoDimensionCode(String url) {

		String imgPath = null;
		try {
			imgPath = MyFileUtils.getValueFromProperties("savePicUrl")+File.separator+"twoDimension"+File.separator;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String imgName = UUID.randomUUID().toString().trim().replaceAll("-", "")+".png";
		if (!new File(imgPath).exists()) {
			new File(imgPath).mkdirs();
		}
		 
//		TwoDimensionCode handler = new TwoDimensionCode();
//		handler.encoderQRCode(url, imgPath+imgName, "png");

		String ret = null;
		try {
			ret = MyFileUtils.getValueFromProperties("PROJECT_URL")+"/upload/pic/twoDimension/"+imgName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public static void main(String[] args) {
		
		String text = "34#4%6*8";
		String questionId = text.substring(0, text.indexOf("#"));
		String optionContent = text.substring(text.indexOf("#") + 1, text.length());

		System.out.println("questionId--" + questionId);
		System.out.println("optionContent--" + optionContent);
		System.out.println("test--" + text.split("\\*")[0]);
		System.out.println("test--" + getPatientCode(12));
		System.out.println("testJson--" + testMakJson());

		String jsonstr = "[{\"fkUserMedicalId\":2,\"changePrice\":1,\"changeNum\":1},{\"fkUserMedicalId\":4,\"changePrice\":1,\"changeNum\":1}]";
		testParseJson(jsonstr);
		System.out.println("timeToHex()--" + timeToHex());

		System.out.println("stringToDateTime()--" + weixinDateStringToDateTime("20141030133525"));
		

		System.out.println("stringToDateTime()--" + stringToDateTime("2016-06-26 23:00:16").getTime());
		
		
		System.out.println("saveTwoDimensionCode--" +saveTwoDimensionCode("http://www.baidu.com"));

		Double x = 0.1;
		Double y = 0.1;
		System.out.println("x==y--" + (x==y));
		System.out.println("x.equals(y)--" + (x.equals(y)));
		System.out.println("double--" + String.valueOf((int)(1*100)));

	}

	/**
	 * 获取8位不重复随机码（取当前时间戳转化为十六进制）
	 * 
	 * @author ShelWee
	 * @return
	 */
	public static String timeToHex() {
		return Integer.toHexString((int) (new Date().getTime()));
	}


}
