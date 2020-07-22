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
			System.out.println("���� �����...");
			client = server.accept();
			
			// server�� �����͸� ���� ��Ʈ���� ����� => ������ ������ ��ΰ� ����
			out = new DataOutputStream(client.getOutputStream());
			in = new DataInputStream(client.getInputStream());
			
			// �޾Ƶ��� �� ��� ���� �۾�
			String msg = in.readUTF();
			System.out.println("Ŭ���̾�Ʈ�κ����� �޼���: " + msg);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.setting();
	}
}
