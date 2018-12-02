package net.block;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class BlockClient implements Runnable{
	private static BufferedReader reader ; 
	private static BufferedWriter writer ;
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 8889);
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		Scanner scan = new Scanner(System.in); 
		new Thread(new BlockClient()).start();
		while(true){
			writer.write(scan.nextLine()+"\r\n");
			writer.flush(); 
		}
		
	}
	@Override
	public void run() {
		try {
			while(true){
				System.out.println(reader.readLine() ); 
			}
		} catch (Exception e) {
		}
	}
}
