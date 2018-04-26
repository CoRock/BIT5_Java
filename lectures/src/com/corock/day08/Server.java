package com.corock.day08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket server;
	private DataInputStream in;
	private DataOutputStream out;
	private Socket client;
	
	public void setting() {
		try {
			server = new ServerSocket(7777);
			System.out.println("서버 대기중...");
			client = server.accept();
			
			// server로 데이터를 보낼 스트림을 만든다 => 서버로 보내질 통로가 생김
			out = new DataOutputStream(client.getOutputStream());
			in = new DataInputStream(client.getInputStream());
			
			// 받아들인 걸 찍기 위한 작업
			String msg = in.readUTF();
			System.out.println("클라이언트로부터의 메세지: " + msg);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.setting();
	}
}
