package com.tengdw.netty.protocol.request;

import com.tengdw.netty.protocol.Packet;
import lombok.Data;

import java.util.List;

import static com.tengdw.netty.protocol.command.Command.CREATE_GROUP_REQUEST;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/9 10:46
 */
@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_REQUEST;
    }
}
