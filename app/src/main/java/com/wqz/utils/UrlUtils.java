package com.wqz.utils;

/**
 * Created by Administrator on 2016/12/23.
 */

public class UrlUtils
{
    public static String ROOT_URL = "http://121.201.110.207/DigitalizeStore";

    public static String USER_URL = ROOT_URL + "/user";
    public static String USER_LOGIN = USER_URL + "/login?username=#{username}&password=#{password}&callback=";
}
