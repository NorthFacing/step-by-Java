package com.bob.demo03;

import io.netty.channel.ChannelHandler;

/**
 * Created by Bob on 2016/11/1.
 */
public interface ChannelHandlerHolder {
  ChannelHandler[] handlers();
}
