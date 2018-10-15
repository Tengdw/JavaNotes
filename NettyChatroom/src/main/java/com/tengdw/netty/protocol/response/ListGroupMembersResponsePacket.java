package com.tengdw.netty.protocol.response;

import com.tengdw.netty.protocol.Packet;
import com.tengdw.netty.session.Session;
import lombok.Data;

import java.util.List;

import static com.tengdw.netty.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/9 15:29
 */
@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
