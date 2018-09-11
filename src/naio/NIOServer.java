package naio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NIOServer {
	static int count = 0 ;
	public static void main(String[] args) throws IOException {
		Selector select = Selector.open();
		ServerSocketChannel server = ServerSocketChannel.open();
		InetSocketAddress ias = new InetSocketAddress("127.0.0.1", 30000);
		server.bind(ias);
		server.configureBlocking(false);
		server.register(select, SelectionKey.OP_ACCEPT);
		server.accept();
		//System.out.println("sad");
		while(select.select() > 0){
			select.selectedKeys().clear();
			System.out.println("A client was accepted by server :"+(++count));
		}
	}
}
