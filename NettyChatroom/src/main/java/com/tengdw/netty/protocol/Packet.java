package com.tengdw.netty.protocol;

import lombok.Data;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/9/29 12:06
 */
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 指令
     */
    public abstract Byte getCommand();
}
