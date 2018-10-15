package com.tengdw.netty.client.console;

import com.tengdw.netty.protocol.request.LoginRequestPacket;
import com.tengdw.netty.util.SessionUtil;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/8 14:24
 */
public class LoginConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        System.out.print("输入用户名登录: ");
        String username = scanner.nextLine();
        loginRequestPacket.setUsername(username);

        // 密码使用默认的
        loginRequestPacket.setPassword("pwd");

        // 发送登录数据包
        channel.writeAndFlush(loginRequestPacket);
        waitForLoginResponse();

    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
