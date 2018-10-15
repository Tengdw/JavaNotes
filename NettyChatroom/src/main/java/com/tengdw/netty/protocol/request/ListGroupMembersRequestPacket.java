package com.tengdw.netty.protocol.request;

import com.tengdw.netty.protocol.Packet;
import lombok.Data;

import static com.tengdw.netty.protocol.command.Command.LIST_GROUP_MEMBERS_REQUEST;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/9 15:28
 */
@Data
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_REQUEST;
    }
}
