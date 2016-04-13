package jboss.demo01;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * Created by Bob on 2016/4/12.
 */

public class DiscardServerHandler extends SimpleChannelHandler {

  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent me) {
    ChannelBuffer buf = (ChannelBuffer) me.getMessage();
    while (buf.readable()) {
      System.out.println((char) buf.readByte());
      System.out.flush();
    }

    Channel ch = me.getChannel();
    ch.write(me.getMessage());

  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
    e.getCause().printStackTrace();

    Channel ch = e.getChannel();
    ch.close();
  }
}