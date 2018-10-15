package com.tengdw.netty.protocol.request;

import com.tengdw.netty.protocol.Packet;

import static com.tengdw.netty.protocol.command.Command.HEARTBEAT_REQUEST;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/10 10:36
 */
public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
