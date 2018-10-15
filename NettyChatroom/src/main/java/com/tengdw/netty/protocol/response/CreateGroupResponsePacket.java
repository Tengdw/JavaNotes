package com.tengdw.netty.protocol.response;

import com.tengdw.netty.protocol.Packet;
import lombok.Data;

import java.util.List;

import static com.tengdw.netty.protocol.command.Command.CREATE_GROUP_RESPONSE;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/9 10:48
 */
@Data
public class CreateGroupResponsePacket extends Packet {
    private boolean success;

    private String groupId;

    private List<String> userNameList;
    @Override
    public Byte getCommand() {
        return CREATE_GROUP_RESPONSE;
    }
}
