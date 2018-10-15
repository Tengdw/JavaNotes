package com.tengdw.netty.protocol.response;

import com.tengdw.netty.protocol.Packet;
import com.tengdw.netty.session.Session;
import lombok.Data;

import static com.tengdw.netty.protocol.command.Command.GROUP_MESSAGE_RESPONSE;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/9 15:58
 */
@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private Session fromUser;

    private String message;

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_RESPONSE;
    }
}
