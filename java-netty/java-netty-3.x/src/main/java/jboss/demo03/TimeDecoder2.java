package jboss.demo03;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;
import org.jboss.netty.handler.codec.replay.VoidEnum;

/**
 * Created by Bob on 2016/4/12.
 */
public class TimeDecoder2 extends ReplayingDecoder<VoidEnum> {

  @Override
  protected Object decode(
      ChannelHandlerContext ctx, Channel channel,
      ChannelBuffer buffer, VoidEnum state) {

    return buffer.readBytes(4);
  }
}