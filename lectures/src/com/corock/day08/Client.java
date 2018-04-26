package com.corock.day08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	// 소켓 생성
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	
	public void connect() {
		try {
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("서버 접속 완료!");
			
			// server로 데이터를 보낼 스트림을 만든다 => 서버로 보내질 통로가 생김
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			out.writeUTF("나는 클라이언트다");
			System.out.println("클라이언트 메세지 전송완료");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("서버 접속 에러1");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("서버 접속 에러2");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.connect();
	}
}
