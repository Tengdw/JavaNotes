package com.tengdw.netty.protocol.request;

import com.tengdw.netty.protocol.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.tengdw.netty.protocol.command.Command.MESSAGE_REQUEST;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/9/30 10:16
 */
@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {

    private String toUserId;
    private String message;

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
