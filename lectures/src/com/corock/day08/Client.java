package com.corock.day08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	// ���� ����
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	
	public void connect() {
		try {
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("���� ���� �Ϸ�!");
			
			// server�� �����͸� ���� ��Ʈ���� ����� => ������ ������ ��ΰ� ����
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			out.writeUTF("���� Ŭ���̾�Ʈ��");
			System.out.println("Ŭ���̾�Ʈ �޼��� ���ۿϷ�");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("���� ���� ����1");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("���� ���� ����2");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.connect();
	}
}
