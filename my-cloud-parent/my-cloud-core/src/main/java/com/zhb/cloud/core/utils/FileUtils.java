package com.zhb.cloud.core.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
	/** ~~~ 上传或下载的文件（附件）在服务器上的保存路径的固定部分 */
	private static final String DEFAULT_PRE_FILE_FORMAT_AUTO = "upload/";
	/** ~~~ 系统默认建立和使用的以时间字符串作为文件名称的时间格式 */
	private static final String DEFAULT_SUB_FOLDER_FORMAT_AUTO = "yyyy/MM/dd";
	/** ~~~ 默认的js文件在服务器的地址 */
	private static final String DEFAULT_FILE_PATH = "http://www.baidi.com";

	/**
	 * 生成上传到服务器的js文件的文件名
	 * 
	 * @return
	 */
	public static String getFilename(String suffix) {
		return RandomUtils.randomWorkId(8) + "." + suffix;
	}

	/**
	 * @Title: getFtpFilePath
	 * @Description:生成保存在服务器端的js的地址
	 * @return
	 * @return: String
	 * @author: zhb
	 * @throws 2016年6月20日上午11:10:24
	 */
	public static String getFilePath() {
		DateFormat df = new SimpleDateFormat(DEFAULT_SUB_FOLDER_FORMAT_AUTO);
		String filePath = df.format(new Date());
		return DEFAULT_PRE_FILE_FORMAT_AUTO + filePath + "/";
	}

	public static void uploadFile(String filePath, String suffix) {
		String infile = filePath;
		FileInputStream fin;
		FileOutputStream fout;
		try {
			fin = new FileInputStream(infile);
			FileChannel fcin = fin.getChannel();
			String outfile = getFilePath();
			fout = new FileOutputStream(outfile);
			FileChannel fcout = fout.getChannel();
			// 使用allocateDirect，而不是allocate
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
			while (true) {
				buffer.clear();
				int r = fcin.read(buffer);
				if (r == -1) {
					break;
				}
				buffer.flip();
				fcout.write(buffer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Title: generateFilePath
	 * @Description:自动生成js文件的地址
	 * @param workId
	 * @return
	 * @return: String
	 * @author: zhb
	 * @throws 2016年6月20日上午11:44:39
	 */
	public static String generateFilePath(String workId) {
		StringBuffer buffer = new StringBuffer(DEFAULT_FILE_PATH);
		buffer.append("?workid=" + workId);
		return buffer.toString();
	}
}
