package com.ssafy.ws10.step3.weather;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class WeatherMain {
	JFrame f = new JFrame("Weather Info");
	JButton b = new JButton("call Weather");
	JList li = new JList();
	WeatherDAO dao;

	public WeatherMain(){
		dao = WeatherDAO.getWeatherDAO();	// singleton
		createGUI(); //GUI 작업
		addEvent();
	}

	private void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { // 창닫기 버튼 클릭시
				System.exit(0); // 프로그램 종료
			}
		});
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
	}

	protected void showList() {
		String url = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153080000";
		java.util.List<Weather> datas = dao.getWeatherList(url);
		li.removeAll();
		li.setListData(datas.toArray());
	}

	private void createGUI() {
		f.add(b, "North");
		f.add("Center", li);
		f.setSize(400, 500);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new WeatherMain();
	}

}
