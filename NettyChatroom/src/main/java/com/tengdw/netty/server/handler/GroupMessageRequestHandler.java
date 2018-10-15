package com.tengdw.netty.server.handler;

import com.tengdw.netty.protocol.request.GroupMessageRequestPacket;
import com.tengdw.netty.protocol.response.GroupMessageResponsePacket;
import com.tengdw.netty.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * 群消息
 *
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/9 16:02
 */
@ChannelHandler.Sharable
public class GroupMessageRequestHandler extends SimpleChannelInboundHandler<GroupMessageRequestPacket> {
    public static final GroupMessageRequestHandler INSTANCE = new GroupMessageRequestHandler();

    private GroupMessageRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRequestPacket msg) throws Exception {
        // 1.拿到 groupId 构造群聊消息的响应
        String toGroupId = msg.getToGroupId();
        String message = msg.getMessage();

        GroupMessageResponsePacket responsePacket = new GroupMessageResponsePacket();
        responsePacket.setFromUser(SessionUtil.getSession(ctx.channel()));
        responsePacket.setMessage(message);
        responsePacket.setFromGroupId(toGroupId);

        // 2. 拿到群聊对应的 channelGroup，写到每个客户端
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(toGroupId);
        channelGroup.writeAndFlush(responsePacket);
    }
}
