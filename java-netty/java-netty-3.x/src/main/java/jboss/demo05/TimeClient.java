package jboss.demo05;

/**
 * Created by Bob on 2016/4/12.
 */

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class TimeClient {

  public static void main(String[] args) throws Exception {
    String host = "localhost";
    int port = 8080;

    ChannelFactory factory =
        new NioClientSocketChannelFactory(
            Executors.newCachedThreadPool(),
            Executors.newCachedThreadPool());

    ClientBootstrap bootstrap = new ClientBootstrap(factory);

    bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
      public ChannelPipeline getPipeline() {
        return Channels.pipeline(
            new TimeDecoderPojo(),
            new TimeClientHandler()
        );
      }
    });

    bootstrap.setOption("tcpNoDelay", true);
    bootstrap.setOption("keepAlive", true);

    ChannelFuture future = bootstrap.connect(new InetSocketAddress(host, port));

    // 关闭资源
    future.awaitUninterruptibly();
    if (!future.isSuccess()) {
      future.getCause().printStackTrace();
    }
    future.getChannel().getCloseFuture().awaitUninterruptibly();
    factory.releaseExternalResources();

  }
}