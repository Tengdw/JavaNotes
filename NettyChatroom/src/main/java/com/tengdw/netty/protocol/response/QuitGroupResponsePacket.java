package com.tengdw.netty.protocol.response;

import com.tengdw.netty.protocol.Packet;
import lombok.Data;

import static com.tengdw.netty.protocol.command.Command.QUIT_GROUP_RESPONSE;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/9 14:12
 */
@Data
public class QuitGroupResponsePacket extends Packet {

    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return QUIT_GROUP_RESPONSE;
    }
}
