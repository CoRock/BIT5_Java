package com.corock.day08;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) {
		try {
			// �� ��ǻ���� IP�ּ� ���� ȣ��Ʈ�� �޾ƺ���
			// �ϴ� ��ü�� �����.
			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println("�� ��ǻ�� IP �ּ�: " + localHost.getHostAddress());
			
			// ���̹� ���� DNS�� ���ؼ� IP ������ ���
			InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : naverIps) {
				System.out.println("www.naver.com IP �ּ�: " + remote.getHostAddress());
			}
		} catch (UnknownHostException ue) {
			ue.printStackTrace();
		}
	}
}
