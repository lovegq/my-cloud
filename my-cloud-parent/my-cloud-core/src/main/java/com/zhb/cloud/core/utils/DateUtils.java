package com.zhb.cloud.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Title: DateUtils.java
 * @Package com.tztd.sts.core.util
 * @Description: 日期工具类
 * @author zhb
 * @date 2016年6月23日 下午4:58:51
 * @version V1.0
 */
public class DateUtils {
	/**
	 * 开始小时
	 */
	public static final String START_HOUR = "startHour";
	/**
	 * 结束小时
	 */
	public static final String END_HOUR = "endHour";
	/**
	 * 开始日期
	 */
	public static final String START_DAY = "startDay";
	/**
	 * 结束日期
	 */
	public static final String END_DAY = "endDay";

	public static final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static Map<String, String> getLastHour() {
		Map<String, String> map = new HashMap<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		Date endHour = calendar.getTime();
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
		Date startHour = calendar.getTime();
		map.put(DateUtils.START_HOUR, timeFormat.format(startHour));
		map.put(DateUtils.END_HOUR, timeFormat.format(endHour));
		return map;
	}

	public static Map<String, String> getLastDay() {
		Map<String, String> map = new HashMap<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 00);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		Date endDay = calendar.getTime();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);
		Date startDay = calendar.getTime();
		map.put(DateUtils.START_DAY, timeFormat.format(startDay));
		map.put(DateUtils.END_DAY, timeFormat.format(endDay));
		return map;
	}

	/**
	 * @Title: toDate
	 * @Description: 将字符串转换为日期
	 * @param stsTime
	 * @return
	 * @throws Exception
	 * @return: Date
	 * @author: zhb
	 * @throws 2016年9月22日上午10:45:28
	 */
	public static Date toDate(String stsTime) throws Exception {
		return dateFormat.parse(stsTime);
	}

	/**
	 * @Title: getDayBefore
	 * @Description: 获得指定日期的前一天
	 * @param specifiedDay
	 * @return
	 * @return: String
	 * @author: zhb
	 * @throws Exception
	 * @throws 2016年9月22日上午10:33:45
	 */
	public static Date getDayBefore(String stsTime) throws Exception {
		Date date = dateFormat.parse(stsTime);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getDayAfter
	 * @Description:获得指定日期的后一天
	 * @param specifiedDay
	 * @return
	 * @return: String
	 * @author: zhb
	 * @throws Exception
	 * @throws 2016年9月22日上午10:33:33
	 */
	public static Date getDayAfter(String stsTime) throws Exception {
		Date date = dateFormat.parse(stsTime);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);
		return c.getTime();
	}
}
