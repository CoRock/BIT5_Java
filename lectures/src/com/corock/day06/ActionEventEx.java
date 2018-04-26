package com.corock.day06;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventEx extends Frame implements ActionListener {
	
	Panel p;
	Button input, exit;
	TextArea ta;

	public ActionEventEx() {
		super("ActionEvent Test");

		p = new Panel();
		input = new Button("Input");
		exit = new Button("Exit");
		ta = new TextArea();

		// Connect event source with event listener!
		input.addActionListener(this);
		exit.addActionListener(this);

		p.add(input);
		p.add(exit);

		add(p, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);

		setBounds(300, 300, 300, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String name;
		name = ae.getActionCommand();

		if (name.equals("Input"))
			ta.append("button was entered. \n");
		else {
			ta.append("exit program, bye :) \n");

			try { Thread.sleep(1000); }
			catch (Exception e) { }

			System.exit(0);
		}
	}

	public static void main(String[] args) {
		ActionEventEx ae1 = new ActionEventEx();
	}
	
}