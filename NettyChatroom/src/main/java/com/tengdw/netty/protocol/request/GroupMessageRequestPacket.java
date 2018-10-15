package com.tengdw.netty.protocol.request;

import com.tengdw.netty.protocol.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.tengdw.netty.protocol.command.Command.GROUP_MESSAGE_REQUEST;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/9 15:55
 */
@Data
@NoArgsConstructor
public class GroupMessageRequestPacket extends Packet {

    private String toGroupId;

    private String message;

    public GroupMessageRequestPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
