package com.axel.custools.utils;

import com.axel.common.constant.password.PasswordParam;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordUtil {
    private PasswordUtil() {
        /* This utility class should not be instantiated */
    }

    // 字符池
    private static final String NUMBER = "0123456789";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SYMBOL = "!@#$%^&*()_+-=[]{}|;:,.?";

    private static final Random RANDOM = new Random();

    /**
     * 生成随机密码
     */
    public static String generatePassword(PasswordParam param) {
        StringBuilder pool = new StringBuilder();
        if (Boolean.TRUE.equals(param.getHasNumber())) {
            pool.append(NUMBER);
        }
        if (Boolean.TRUE.equals(param.getHasLower())) {
            pool.append(LOWER);
        }
        if (Boolean.TRUE.equals(param.getHasUpper())) {
            pool.append(UPPER);
        }
        if (Boolean.TRUE.equals(param.getHasSymbol())) {
            pool.append(SYMBOL);
        }
        String charPool = pool.toString();
        if (!StringUtils.hasText(charPool)) {
            return "";
        }
        int len = param.getLength();
        List<Character> pwdList = new ArrayList<>(len);

        // 强制每种选中类型至少出现一次，避免纯单一字符
        int index = 0;
        if (Boolean.TRUE.equals(param.getHasNumber())) {
            pwdList.add(NUMBER.charAt(RANDOM.nextInt(NUMBER.length())));
            index++;
        }
        if (Boolean.TRUE.equals(param.getHasLower())) {
            pwdList.add(LOWER.charAt(RANDOM.nextInt(LOWER.length())));
            index++;
        }
        if (Boolean.TRUE.equals(param.getHasUpper())) {
            pwdList.add(UPPER.charAt(RANDOM.nextInt(UPPER.length())));
            index++;
        }
        if (Boolean.TRUE.equals(param.getHasSymbol())) {
            pwdList.add(SYMBOL.charAt(RANDOM.nextInt(SYMBOL.length())));
            index++;
        }

        // 补齐剩余长度
        for (; index < len; index++) {
            int randomIdx = RANDOM.nextInt(charPool.length());
            pwdList.add(charPool.charAt(randomIdx));
        }
        // 打乱顺序
        Collections.shuffle(pwdList);

        StringBuilder result = new StringBuilder();
        for (Character c : pwdList) {
            result.append(c);
        }
        return result.toString();
    }

    /**
     * 计算密码强度
     */
    public static String getPasswordLevel(PasswordParam param) {
        int score = 0;
        if (param.getLength() >= 8) score++;
        if (param.getLength() >= 12) score++;
        if (Boolean.TRUE.equals(param.getHasNumber())) score++;
        if (Boolean.TRUE.equals(param.getHasUpper())) score++;
        if (Boolean.TRUE.equals(param.getHasSymbol())) score++;

        if (score <= 2) return "弱";
        else if (score <= 4) return "中";
        else return "强";
    }
}
