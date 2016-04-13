package jboss.demo03;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import java.util.Date;

/**
 * Created by Bob on 2016/4/12.
 */
public class TimeClientHandler extends SimpleChannelHandler {

  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
    ChannelBuffer buf = (ChannelBuffer) e.getMessage();
    long currentTimeMillis = buf.readInt() * 1000L;
    System.out.println(currentTimeMillis);
    System.out.println(new Date(currentTimeMillis));
    e.getChannel().close();
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
    e.getCause().printStackTrace();
    e.getChannel().close();
  }
}