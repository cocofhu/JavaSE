package net;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class NClient {
	private Selector selector = null ; 
	static final int PORT = 30000 ;
	private Charset charset = Charset.forName("utf-8");
	private SocketChannel sc = null ; 
	public void init()throws Exception{
		selector = Selector.open() ;
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1",PORT);
		sc = SocketChannel.open(isa);
		sc.configureBlocking(false) ; 
		sc.register(selector, SelectionKey.OP_READ);
		new Thread(()->{
			try {
				while( selector.select() > 0){
					for (SelectionKey sk : selector.selectedKeys()) {
						selector.selectedKeys().remove(sk) ;
						if(sk.isReadable()){
							SocketChannel sc = (SocketChannel) sk.channel() ;
							ByteBuffer buff = ByteBuffer.allocate(1024) ; 
							String content = "" ;
							//System.out.println("read...");
							while(sc.read(buff)>0){
								sc.read(buff);
								buff.flip();
								content += charset.decode(buff);
								//buff.clear() ;
							}
							System.out.println(content);
							sk.interestOps(SelectionKey.OP_READ);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String line = scan.nextLine() ;
			sc.write(charset.encode(line));
		}
	}
	public static void main(String[] args) throws Exception {
		new NClient().init();
	}
}
