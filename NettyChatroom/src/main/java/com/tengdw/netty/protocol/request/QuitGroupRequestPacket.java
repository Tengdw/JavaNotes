package com.tengdw.netty.protocol.request;

import com.tengdw.netty.protocol.Packet;
import lombok.Data;

import static com.tengdw.netty.protocol.command.Command.QUIT_GROUP_REQUEST;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/9 14:11
 */
@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return QUIT_GROUP_REQUEST;
    }
}
