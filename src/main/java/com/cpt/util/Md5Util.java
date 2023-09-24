package com.cpt.util;

import java.security.MessageDigest;

public class Md5Util {
    public static String md5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] dataBytes = data.getBytes();
        byte[] mdBytes = md.digest(dataBytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : mdBytes) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
}
