package com.tengdw.netty.protocol.request;

import com.tengdw.netty.protocol.Packet;
import lombok.Data;

import static com.tengdw.netty.protocol.command.Command.LOGOUT_REQUEST;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/8 11:43
 */
@Data
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return LOGOUT_REQUEST;
    }
}
