package com.tengdw.netty.protocol.response;

import com.tengdw.netty.protocol.Packet;
import lombok.Data;

import static com.tengdw.netty.protocol.command.Command.LOGIN_RESPONSE;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/9/29 17:29
 */
@Data
public class LoginResponsePacket extends Packet {
    private String userId;

    private String userName;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
