package com.tengdw.netty.protocol.response;

import com.tengdw.netty.protocol.Packet;

import static com.tengdw.netty.protocol.command.Command.HEARTBEAT_RESPONSE;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/10 10:37
 */
public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}
