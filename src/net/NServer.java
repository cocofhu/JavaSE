package net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NServer {
	// 用于检测所有Channel状态的Selector
	private Selector selector = null ;
	// 端口号
	static final int PORT = 30000 ; 
	// 定义实现编码解码的字符集对象
	private Charset charset = Charset.forName("UTF-8");
	public void init()throws IOException{
		// 
		selector = Selector.open() ;
		// 通过Open方法打开一个未绑定的ServerSocketChannel实例
		ServerSocketChannel server = ServerSocketChannel.open() ;
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1",PORT) ; 
		// 将该ServerSocketChannel绑定指定IP地址
		server.bind(isa) ; 
		// 设置ServerSocket以非阻塞方式工作/
		//server.configureBlocking(false) ;
		// 将server注册到指定的Selector对象
		//server.register(selector, SelectionKey.OP_ACCEPT) ; 
		//System.out.println("---------------");
		System.out.println(selector.select());
		while(selector.select() >0 ){
			for (SelectionKey sk : selector.selectedKeys()) {
				selector.selectedKeys().remove(sk) ; 
				if(sk.isAcceptable()){
					SocketChannel sc = server.accept() ;
					//System.out.println("Accepted");
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
					sk.interestOps(SelectionKey.OP_ACCEPT) ; 
				}
				if(sk.isReadable()){
					SocketChannel sc = (SocketChannel)sk.channel() ; 
					ByteBuffer buff = ByteBuffer.allocate(1024) ; 
					String content = "" ; 
					try{
						while(sc.read(buff)>0){
							buff.flip();
							content += charset.decode(buff);
							//buff.clear() ;
						}
					}catch(IOException e){
						sk.cancel();
						if(sk.channel() != null){
							sk.channel().close();
						}
					}
					if(content.length() >0){
						for (SelectionKey key : selector.keys()) {
							Channel targetChannel = key.channel() ;
							if(targetChannel instanceof SocketChannel){
								SocketChannel dest = (SocketChannel) targetChannel ;
								dest.write(charset.encode(content));
								System.out.println(content);
							}
						}
					}
				}
			
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		new NServer().init();
	}
}
