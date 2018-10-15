package com.tengdw.netty.client.hanlder;

import com.tengdw.netty.protocol.request.HeartBeatRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * 心跳定时器
 *
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/10 10:34
 */
public class HeartBeatTimerHandler extends ChannelInboundHandlerAdapter {

    private static final int HEARTBEAT_INTERVAL = 5;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.executor().scheduleAtFixedRate(() ->
                        ctx.writeAndFlush(new HeartBeatRequestPacket()),
                HEARTBEAT_INTERVAL, HEARTBEAT_INTERVAL, TimeUnit.SECONDS);
        super.channelActive(ctx);
    }
}
