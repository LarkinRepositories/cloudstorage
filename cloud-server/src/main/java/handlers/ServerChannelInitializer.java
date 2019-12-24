package handlers;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.nio.charset.Charset;

public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final StringEncoder STRING_ENCODER = new StringEncoder();
    private final StringDecoder STRING_DECODER = new StringDecoder();
    //здесь сериализаторы или протокол
    private final CommandDecoder COMMAND_DECODER = new CommandDecoder();
    private final ChunkedWriteHandler CHUNKED_WRITE_HANDLER = new ChunkedWriteHandler();
    private final ServerHandler SERVER_HANDLER = new ServerHandler();


    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(8189, Delimiters.lineDelimiter()));
        socketChannel.pipeline().addLast(STRING_DECODER);
        socketChannel.pipeline().addLast(STRING_DECODER);
//        socketChannel.pipeline().addLast(COMMAND_DECODER);
        socketChannel.pipeline().addLast(CHUNKED_WRITE_HANDLER);
//        socketChannel.pipeline().addLast(SERVER_HANDLER);

    }
}
