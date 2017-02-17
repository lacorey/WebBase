package com.sherry.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherry.common.Constants;
import com.sherry.common.JacksonMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFileUtils {

	public static String getValueFromProperties(String fileName, String key) throws Exception {

		Constants.logger.info("fileName---" + fileName);
		Properties p = new Properties();
		InputStream in = Constants.class.getClassLoader().getResourceAsStream(fileName);
		p.load(in);
		in.close();
		return p.getProperty(key).trim();
	}
	
	public static String getValueFromProperties(String key) throws Exception {
		String fileName = "application.properties";
		Constants.logger.info("fileName---" + fileName);
		Properties p = new Properties();
		InputStream in = Constants.class.getClassLoader().getResourceAsStream(fileName);
		p.load(in);
		in.close();
		return p.getProperty(key).trim();
	}

	/**
	 * @param file
	 *            //文件对象
	 * @param fileName
	 *            //文件名
	 * @return 文件名
	 */
	public static void fileUpload(MultipartFile file, String fileName) throws Exception {
		String filePath = "";
		filePath = getValueFromProperties("savePicUrl");
		copyFile(file.getInputStream(), filePath, fileName);
	}
	
	public static void fileUpload(MultipartFile file, String filePath, String fileName) throws Exception {
		copyFile(file.getInputStream(), filePath, fileName);
	}


	 /** 
     * 根据地址获得数据的字节流 
     * @param strUrl 网络连接地址 
     * @return 
     */  
    public static byte[] getImageBytesFromNetByUrl(String strUrl){  
        try {  
            URL url = new URL(strUrl);  
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("GET");  
            conn.setConnectTimeout(5 * 1000);  
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据  
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据  
            return btImg;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    
    /** 
     * 根据地址获得数据的in 
     * @param strUrl 网络连接地址 
     * @return 
     */  
    public static InputStream getImageFromNetByUrl(String strUrl){  
        try {  
            URL url = new URL(strUrl);  
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("GET");  
            conn.setConnectTimeout(5 * 1000);  
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据  
            return inStream;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    
    /** 
     * 从输入流中获取数据 
     * @param inStream 输入流 
     * @return 
     * @throws Exception 
     */  
    public static byte[] readInputStream(InputStream inStream) throws Exception{  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        while( (len=inStream.read(buffer)) != -1 ){  
            outStream.write(buffer, 0, len);  
        }  
        inStream.close();  
        return outStream.toByteArray();  
    }  
    
	/**
	 * 写文件到当前目录的upload目录中
	 * 
	 * @param in
	 * @throws IOException
	 */
	public static String copyFile(InputStream in, String dir, String realname) throws Exception {
		File file = new File(dir, realname);
		if (!file.exists()) {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
		}
		FileUtils.copyInputStreamToFile(in, file);
		return realname;
	}
	
	/**
	 * 写二进制文件到当前目录的upload目录中
	 * 
	 * @throws IOException
	 */
	private static String copyByteFile(byte[] bs, String dir, String realname) throws Exception {
		File file = new File(dir, realname);
		if (!file.exists()) {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
		}
		ByteArrayInputStream bis = new ByteArrayInputStream(bs);
		FileUtils.copyInputStreamToFile(bis, file);
		return realname;
	}
	
	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 *            String
	 * @return boolean
	 */
	public static void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myDelFile = new File(filePath);
			myDelFile.delete();

		} catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();

		}

	}
	/**
	 * 列出文件
	 *
	 */
	public static List<String> listFileNames(String filePath,String searchName) {
		File[] files = null;
		try {
			File myDelFile = new File(filePath);
			files = myDelFile.listFiles();

		} catch (Exception e) {
			System.out.println("list file error");
			e.printStackTrace();

		}
		List<String> fileNames = new ArrayList();
		if(searchName==null){
			searchName = "";
		}
		searchName = searchName.replaceAll("\\.", "\\\\.");
		searchName = "^.*" + searchName + ".*$";

	     System.out.println(searchName);
		Pattern p = Pattern.compile(searchName);
		
		for(File f:files){
			Matcher fMatcher = p.matcher(f.getName());
			if(fMatcher.matches()){
				fileNames.add(f.getName());
			}
			
		}
		return fileNames;

	}
	
	public static void main(String[] args) throws Exception{
		
		ObjectMapper o = JacksonMapper.getInstance();
		String filepath = getValueFromProperties("saveVideoUrl");
		List<String> files = listFileNames(filepath,"bc.t");
		System.out.println("files---"+o.writeValueAsString(files));
		Constants.logger.info("hahahha");
	}
	
	

	

}
