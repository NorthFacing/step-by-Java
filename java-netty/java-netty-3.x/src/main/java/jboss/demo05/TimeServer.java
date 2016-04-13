package jboss.demo05;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.ChannelGroupFuture;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Created by Bob on 2016/4/12.
 */

public class TimeServer {

  // 增加ChannelGroup，管理channel
  static final ChannelGroup allChannels = new DefaultChannelGroup("time-server");

  public static void main(String[] args) throws Exception {
    ChannelFactory factory =
            new NioServerSocketChannelFactory(
                    Executors.newCachedThreadPool(),
                    Executors.newCachedThreadPool());

    ServerBootstrap bootstrap = new ServerBootstrap(factory);

    bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
      @Override
      public ChannelPipeline getPipeline() {
        return Channels.pipeline(
                new TimeEncoderPojo(),
                new TimeServerHandler()
        );
      }
    });

    bootstrap.setOption("child.tcpNoDelay", true);
    bootstrap.setOption("child.keepAlive", true);

    Channel channel = bootstrap.bind(new InetSocketAddress(8080));

    // 关闭资源
    allChannels.add(channel);
//    waitForShutdownCommand();
    ChannelGroupFuture future = allChannels.close();
    future.awaitUninterruptibly();
    factory.releaseExternalResources();
  }
}