package jboss.demo04;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

/**
 * Created by Bob on 2016/4/12.
 */
public class TimeDecoderPojo extends FrameDecoder {
  @Override
  protected Object decode(ChannelHandlerContext ctx,
                          Channel channel,
                          ChannelBuffer buffer) {
    if (buffer.readableBytes() < 4) {
      return null;
    }
    return new UnixTime(buffer.readInt());
  }
}