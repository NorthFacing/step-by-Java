package netty_in_action.c01_GETTING_STARTED;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;


/**
 * 运行本代码会报错：Exception in thread "main" java.lang.IllegalStateException: channel not registered to an event loop
 * <p>
 * 只需要了解通过监听器模式实现了回调即可。可以把 ChannelFutureListener 看做是回调的一个更加精细的版本。
 * 事实上，回调和Future是相互补充的机制；他们相互结合，构成了Netty本身的关键构件块之一。
 *
 * @author adolphor
 */
public class D01_04 {
  public static void main(String[] args) throws Exception {
    Channel channel = new NioSocketChannel();
    ChannelFuture future = channel.connect(new InetSocketAddress("192.168.0.1", 1080));
    future.addListener((ChannelFutureListener) channelFuture -> {
      if (channelFuture.isSuccess()) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("Hello", Charset.defaultCharset());
        future.channel().writeAndFlush(byteBuf);
      } else {
        Throwable cause = future.cause();
        cause.printStackTrace();
      }
    });
  }
}
