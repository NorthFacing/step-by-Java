package jboss.demo01;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Created by Bob on 2016/4/12.
 */

public class DiscardServer {

  public static void main(String[] args) throws Exception {
    // ChannelFactory is a factory which creates and manages Channels
    // and its related resources
    ChannelFactory factory =
            new NioServerSocketChannelFactory(
                    Executors.newCachedThreadPool(),
                    Executors.newCachedThreadPool());

    // ServerBootstrap is a helper class that sets up a server.
    ServerBootstrap bootstrap = new ServerBootstrap(factory);

    // Whenever a new connection is accepted by the server, a new
    // ChannelPipeline will be created by the specified ChannelPipelineFactory.
    bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
      @Override
      public ChannelPipeline getPipeline() {
        return Channels.pipeline(new DiscardServerHandler());
      }
    });

    bootstrap.setOption("child.tcpNoDelay", true);
    bootstrap.setOption("child.keepAlive", true);

    bootstrap.bind(new InetSocketAddress(8080));
  }
}