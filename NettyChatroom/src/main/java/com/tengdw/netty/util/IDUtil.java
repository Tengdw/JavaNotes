package com.tengdw.netty.util;

import java.util.UUID;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/8 18:00
 */
public class IDUtil {

    public static String randomUserId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}
