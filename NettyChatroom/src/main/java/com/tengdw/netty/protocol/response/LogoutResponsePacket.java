package com.tengdw.netty.protocol.response;

import com.tengdw.netty.protocol.Packet;
import lombok.Data;

import static com.tengdw.netty.protocol.command.Command.LOGOUT_RESPONSE;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/8 11:44
 */
@Data
public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return LOGOUT_RESPONSE;
    }
}
