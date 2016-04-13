package jboss.demo05;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import static org.jboss.netty.buffer.ChannelBuffers.buffer;

/**
 * Created by Bob on 2016/4/12.
 */

public class TimeEncoderPojo extends SimpleChannelHandler {

  public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) {
    UnixTime time = (UnixTime) e.getMessage();

    ChannelBuffer buf = buffer(4);
    buf.writeInt(time.getValue());

    Channels.write(ctx, e.getFuture(), buf);
  }
}