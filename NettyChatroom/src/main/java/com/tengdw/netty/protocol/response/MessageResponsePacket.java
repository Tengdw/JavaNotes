package com.tengdw.netty.protocol.response;

import com.tengdw.netty.protocol.Packet;
import lombok.Data;

import static com.tengdw.netty.protocol.command.Command.MESSAGE_RESPONSE;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/9/30 10:19
 */
@Data
public class MessageResponsePacket extends Packet {

    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
