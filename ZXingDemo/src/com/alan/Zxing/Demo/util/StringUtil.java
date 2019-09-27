package com.alan.Zxing.Demo.util;

import java.io.UnsupportedEncodingException;

/**
 * �ַ��������� 
 * @author Test
 *
 */
public class StringUtil {


	/**
	 * ��GBKת��UTF-8
	 * Change GBK to utf-8
	 * 
	 * @param gbk
	 * @return
	 */
    public static String convertString(String gbk){
    	String utf8 = "";
        try {
			utf8 = new String(gbk2utf8(gbk),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return utf8;
    }

    public static  byte[] gbk2utf8(String chenese) {
        char c[] = chenese.toCharArray();
        byte[] fullByte = new byte[3 * c.length];
        for (int i = 0; i < c.length; i++) {
            int m = (int) c[i];
            String word = Integer.toBinaryString(m);

            StringBuffer sb = new StringBuffer();
            int len = 16 - word.length();
            for (int j = 0; j < len; j++) {
                sb.append("0");
            }
            sb.append(word);
            sb.insert(0, "1110");
            sb.insert(8, "10");
            sb.insert(16, "10");

            String s1 = sb.substring(0, 8);
            String s2 = sb.substring(8, 16);
            String s3 = sb.substring(16);

            byte b0 = Integer.valueOf(s1, 2).byteValue();
            byte b1 = Integer.valueOf(s2, 2).byteValue();
            byte b2 = Integer.valueOf(s3, 2).byteValue();
            byte[] bf = new byte[3];
            bf[0] = b0;
            fullByte[i * 3] = bf[0];
            bf[1] = b1;
            fullByte[i * 3 + 1] = bf[1];
            bf[2] = b2;
            fullByte[i * 3 + 2] = bf[2];

        }
        return fullByte;
    }

}
