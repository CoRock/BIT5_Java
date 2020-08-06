package com.corock.day06;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventEx extends Frame implements WindowListener {
	public WindowEventEx() {
		super("WindowEvent Test");

		Label exit = new Label("push exit button to the right corner.");
		
		add(exit);

		setBounds(300, 300, 500, 500);
		setVisible(true);
		
		addWindowListener(this);
	}

	public static void main(String[] args) {
		new WindowEventEx();
	}

	@Override
	public void windowOpened(WindowEvent e) { }

	@Override
	public void windowClosing(WindowEvent e) { System.exit(0); }

	@Override
	public void windowClosed(WindowEvent e) { }

	@Override
	public void windowIconified(WindowEvent e) { }

	@Override
	public void windowDeiconified(WindowEvent e) { }

	@Override
	public void windowActivated(WindowEvent e) { }

	@Override
	public void windowDeactivated(WindowEvent e) { }
}