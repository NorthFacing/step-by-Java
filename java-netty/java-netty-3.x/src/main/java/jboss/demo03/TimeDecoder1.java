package jboss.demo03;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

/**
 * Created by Bob on 2016/4/12.
 */
public class TimeDecoder1 extends FrameDecoder {
  @Override
  protected Object decode(ChannelHandlerContext ctx,
                          Channel channel,
                          ChannelBuffer buffer) {
    if (buffer.readableBytes() < 4) {
      return null;
    }
    return buffer.readBytes(4);
  }
}