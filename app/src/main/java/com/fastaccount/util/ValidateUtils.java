package com.fastaccount.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yanghaitao on 16/5/10.
 */
public class ValidateUtils {
    private final static String REGEX_MOBILEPHONE = "^0?1[0-9]\\d{9}$";

    public static boolean checkPhone(String number) {
        Pattern PATTERN_MOBILEPHONE = Pattern.compile(REGEX_MOBILEPHONE);
        Matcher match = PATTERN_MOBILEPHONE.matcher(number);
        return match.matches();
    }
    public static boolean checkZhongzhuID(String number) {
        Pattern ZhongzhuID = Pattern.compile("^\\w{6,20}$");
        Matcher match = ZhongzhuID.matcher(number);
        return match.matches();
    }
    /**
            * 该方法主要使用正则表达式来判断字符串中是否包含字母
     * @author fenggaopan 2015年7月21日 上午9:49:40
            * @param cardNum 待检验的原始卡号
     * @return 返回是否包含
     */
    public static boolean judgeContainsStr(String cardNum) {
        String regex=".*[a-zA-Z]+.*";
        Matcher m= Pattern.compile(regex).matcher(cardNum);
        return m.matches();
    }


    public static boolean isHZ(String hz) {
        String regex="^[\\u4e00-\\u9fa5]+$";
        Matcher m= Pattern.compile(regex).matcher(hz);
        return m.matches();
    }
    private final static String REGEX_EMMAIL = "^[a-z0-9]+([._\\\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";

    public static boolean checkEMAIL(String email) {
        Pattern emails = Pattern.compile(REGEX_EMMAIL);
        Matcher match = emails.matcher(email);
        return match.matches();
    }

    public static boolean checkPwd(String pwd) {
        if (6 <= pwd.length() && pwd.length() <= 16) {
            return true;
        }
        return false;
    }

    public static boolean checkRealName(String name) {
        if (name.length() > 0 && name.length() < 16) {
            return true;
        }
        return false;
    }
    public static boolean checkWord(String name) {
        String names=CharReplaceProcessUtil.INSTANCE.replace(name);
        String regex="^[a-zA-Z\u4E00-\u9FA5]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match=pattern.matcher(names);
       return match.matches();

    }
    public static boolean checkIDNumber(String IDNumber) {
        Pattern PATTERN_MOBILEPHONE = Pattern.compile("^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$");
        Matcher match = PATTERN_MOBILEPHONE.matcher(IDNumber);
        return match.matches();
    }

    public static boolean checkAreaName(String areaName) {
        if (areaName.length() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 时间截取
     *
     * @param datetime
     * @param splite
     * @return
     */
    public static int[] getYMDArray(String datetime, String splite) {
        int date[] = {0, 0, 0, 0, 0};


        if (datetime != null && datetime.length() > 0) {
            String[] dates = datetime.split(splite);

            int position = 0;
            for (String temp : dates) {
                date[position] = Integer.valueOf(temp);
                position++;
            }
        }
        return date;
    }
}
