package com.tengdw.netty.protocol.request;

import com.tengdw.netty.protocol.Packet;
import lombok.Data;
import static com.tengdw.netty.protocol.command.Command.LOGIN_REQUEST;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/9/29 12:08
 */
@Data
public class LoginRequestPacket extends Packet {

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
