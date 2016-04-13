package jboss.demo05;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * Created by Bob on 2016/4/12.
 */
public class TimeServerHandler extends SimpleChannelHandler {

  // 有新连接，就加入到ChannelGroup，进行统一管理
  @Override
  public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) {
    TimeServer.allChannels.add(e.getChannel());
  }

  @Override
  public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent cse) {

    UnixTime time = new UnixTime((int) (System.currentTimeMillis() / 1000));

    ChannelFuture f = cse.getChannel().write(time);

    f.addListener(new ChannelFutureListener() {
      @Override
      public void operationComplete(ChannelFuture future) {
        Channel ch = future.getChannel();
        ch.close();
      }
    });

  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
    e.getCause().printStackTrace();
    e.getChannel().close();
  }

}