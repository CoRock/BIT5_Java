package com.corock.day06;

import java.awt.Frame;

public class FrameEx2 extends Frame {

	public FrameEx2() {
		super("Frame Test2");

		setSize(300, 300);	// Size of frame
		setVisible(true);	// Visibility of frame
	}

	public static void main(String[] args) {
		FrameEx2 fe = new FrameEx2();
	}
	
}