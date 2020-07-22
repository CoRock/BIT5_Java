package com.corock.day08;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) {
		try {
			// 내 컴퓨터의 IP주소 로컬 호스트를 받아보자
			// 일단 객체를 만든다.
			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP 주소: " + localHost.getHostAddress());
			
			// 네이버 서버 DNS를 통해서 IP 정보를 출력
			InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : naverIps) {
				System.out.println("www.naver.com IP 주소: " + remote.getHostAddress());
			}
		} catch (UnknownHostException ue) {
			ue.printStackTrace();
		}
	}
}
