package xyz.lfans.utils;

import java.io.UnsupportedEncodingException;

/**
 * @author Atlantis
 * @create 2019-06-24-16:10
 */
public class StringCode {
    public static String toUTF8(String s) throws UnsupportedEncodingException {
        byte b[] = s.getBytes("UTF-8");
        s=new String(b);
        return s;
    }
}
