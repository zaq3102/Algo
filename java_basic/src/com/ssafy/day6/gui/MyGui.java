package com.ssafy.day6.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyGui extends JFrame{
	public static void main(String[] args) {
		MyGui gui = new MyGui();
		gui.launch();
		
		
	}
	
	private void launch() {
		this.setTitle("싸피 화이팅!");
		this.setSize(500, 300);
		
		JButton button1 = new JButton("북쪽");
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("북쪽 클릭");
				
			}
		});
		
		
		this.add(BorderLayout.NORTH,button1);
		this.add(BorderLayout.SOUTH,new JButton("남쪽"));
		this.add(BorderLayout.EAST,new JButton("동쪽"));
		this.add(BorderLayout.WEST,new JButton("서쪽"));
		this.add(BorderLayout.CENTER,new JButton("중앙"));
		
		
		this.setVisible(true);
		
	}
	
}
