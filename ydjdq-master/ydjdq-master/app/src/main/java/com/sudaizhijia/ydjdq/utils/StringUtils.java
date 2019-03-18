package com.sudaizhijia.ydjdq.utils;

import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtils {

	/**
	 * 金钱格式化的模式
	 */
	public static final String moneyPattern = "###########0.00";
	public static String getUrlEncodePath(String path){
		try {
			String substring1 = path.substring(0, path.lastIndexOf("/") + 1);
			String substring = path.substring(path.lastIndexOf("/") + 1);
			path = substring1 + URLEncoder.encode(substring, "utf-8");
			return path;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String getFileType(String path){
		try {
			String substring = path.substring(path.lastIndexOf("."));
			return substring;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String getDislodgeSuffix(String name){
		try {
			if(name.lastIndexOf(".")!=-1){
				String substring = name.substring(0,name.lastIndexOf("."));
				return substring;
			}else{
				return name;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static boolean isNullOrEmpty(String text) {
		if (text == null || "".equals(text.trim()) || text.trim().length() == 0 || "null".equals(text.trim())) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 获取更新的时间
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getDateString(Date date) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (calendar.get(Calendar.YEAR) - (date.getYear() + 1900) > 0) {
			return sdf.format(date);
		} else if (calendar.get(Calendar.MONTH) - date.getMonth() > 0) {
			return sdf.format(date);
		} else if (calendar.get(Calendar.DAY_OF_MONTH) - date.getDate() > 6) {
			return sdf.format(date);
		} else if ((calendar.get(Calendar.DAY_OF_MONTH) - date.getDate() > 0) && (calendar.get(Calendar.DAY_OF_MONTH) - date.getDate() < 6)) {
			int i = calendar.get(Calendar.HOUR_OF_DAY) - date.getHours();
			return i + "天前";
		} else if (calendar.get(Calendar.HOUR_OF_DAY) - date.getHours() > 0) {
			int i = calendar.get(Calendar.HOUR_OF_DAY) - date.getHours();
			return i + "小时前";
		} else if (calendar.get(Calendar.MINUTE) - date.getMinutes() > 0) {
			int i = calendar.get(Calendar.MINUTE) - date.getMinutes();
			return i + "分钟前";
		} else if (calendar.get(Calendar.SECOND) - date.getSeconds() > 0) {
			int i = calendar.get(Calendar.SECOND) - date.getSeconds();
			return i + "秒前";
		} else if (calendar.get(Calendar.SECOND) - date.getSeconds() == 0) {
			return "刚刚";
		} else {
			return sdf.format(date);
		}
	}
	/**把钱转换成带千或万的格式*/
	public static String changeMoneyFormat(int money){
		if (money>=1000 && money<10000) {
			return money/1000+"千";
		}else if (money>=10000) {
			return money/10000+"万";
		}
		return money+"";
	}
	
	public static boolean isPhoneNubmer(String phone){
		Pattern p = Pattern.compile("^1\\d{10}$");
		Matcher m = p.matcher(phone);
		return m.matches();  
	}
	public static boolean isBankNubmer(String BankNubmer){
		Pattern p = Pattern.compile("^\\d{16,19}$");
		Matcher m = p.matcher(BankNubmer);
		return m.matches();  
	}
	

	/**
	 * 是否不为空
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNotEmpty(String s) {
		return s != null && !"".equals(s.trim());
	}

	/**
	 * 是否为空
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		return s == null || "".equals(s.trim());
	}

	/**
	 * 通过{n},格式化.
	 * 
	 * @param src
	 * @param objects
	 * @return
	 */
	public static String format(String src, Object... objects) {
		int k = 0;
		for (Object obj : objects) {
			src = src.replace("{" + k + "}", obj.toString());
			k++;
		}
		return src;
	}
	public static String formatRate(double data) {
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#,##0.0#%");
		String result = df.format(data);
		return result.substring(0,result.length()-1);
	}

	/**
	 * 返回的数据带有百分号
	 * @param data
	 * @return
	 */
	public static String formatRateB(double data) {
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#,##0.0#%");
		String result = df.format(data);
		return result;
	}



	/**
	 * 根据 patteren格式化数据
	 *
	 * @param data
	 * @param pattern
	 * @return
	 */
	public static String formatData(String data, String pattern) {
		String replace = data.replaceAll(",", "");
		Double d = new Double(replace);
		DecimalFormat df = new DecimalFormat();
		df.applyPattern(pattern);
		String result = df.format(d);
		return result;
	}
	/**
	 * 根据 patteren格式化数据
	 *
	 * @param data
	 * @param pattern
	 * @return
	 */
	public static String formatData(Double data, String pattern) {
		DecimalFormat df = new DecimalFormat();
		df.applyPattern(pattern);
		String result = df.format(data);
		return result;
	}
	public static String formatData(Float data, String pattern) {
		DecimalFormat df = new DecimalFormat();
		df.applyPattern(pattern);
		String result = df.format(data);
		return result;
	}
	public static String formatMoney(Double data) {
		DecimalFormat df = new DecimalFormat();
		df.applyPattern(moneyPattern);
		String result = df.format(data);
		return result;
	}
//
//	public static String formatPerson(int data) {
//		DecimalFormat df = new DecimalFormat();
//		df.applyPattern(ConstantsApp.personPattern);
//		String result = df.format(data);
//		return result;
//	}
	/**
	 * 用正则表达式验证身份证格式
	 * @return
	 */
	public static boolean checkSfz(String name) {
		Pattern p = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");
		Matcher m = p.matcher(name);
		return m.matches();
	}

    /**手机号留前三后四*/
    public static String formatPhoneNumber(String phoneNumber){
        if (isPhoneNubmer(phoneNumber)){
            return phoneNumber.substring(0,4)+"****"+phoneNumber.substring(7);
        }else{
            return "";
        }
    }
}
