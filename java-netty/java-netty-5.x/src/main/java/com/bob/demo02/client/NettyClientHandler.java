package com.bob.demo02.client;

import com.bob.demo02.Utils.DateUtil;
import com.bob.demo02.domain.msg.BaseMsg;
import com.bob.demo02.domain.msg.LoginMsg;
import com.bob.demo02.domain.msg.MsgType;
import com.bob.demo02.domain.msg.PingMsg;
import com.bob.demo02.domain.reply.ReplyClientBody;
import com.bob.demo02.domain.reply.ReplyMsg;
import com.bob.demo02.domain.reply.ReplyServerBody;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;

import java.util.Date;

/**
 * Created by Bob on 2016/4/13.
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<BaseMsg> {
  //利用写空闲发送心跳检测消息
  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    if (evt instanceof IdleStateEvent) {
      IdleStateEvent e = (IdleStateEvent) evt;
      switch (e.state()) {
        case WRITER_IDLE:
          PingMsg pingMsg = new PingMsg();
          ctx.writeAndFlush(pingMsg);
          System.out.println(DateUtil.getStrDate() + " send ping to server");
          break;
        default:
          break;
      }
    }
  }

  @Override
  protected void messageReceived(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {
    MsgType msgType = baseMsg.getType();
    switch (msgType) {
      case LOGIN: {
        //向服务器发起登录
        LoginMsg loginMsg = new LoginMsg();
        loginMsg.setPassword("yao");
        loginMsg.setUserName("robin");
        channelHandlerContext.writeAndFlush(loginMsg);
        System.out.println("receive login from server");
      }
      break;
      case PING: {
        System.out.println("receive ping from server");
      }
      break;
      case ASK: {
        ReplyClientBody replyClientBody = new ReplyClientBody("client replyMsg !!!");
        ReplyMsg replyMsg = new ReplyMsg();
        replyMsg.setBody(replyClientBody);
        channelHandlerContext.writeAndFlush(replyMsg);
        System.out.println("receive ask from server");
      }
      break;
      case REPLY: {
        ReplyMsg replyMsg = (ReplyMsg) baseMsg;
        ReplyServerBody replyServerBody = (ReplyServerBody) replyMsg.getBody();
        System.out.println("receive server msg: " + replyServerBody.getServerInfo());
      }
      default:
        break;
    }
    ReferenceCountUtil.release(msgType);
  }
}
