package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstUI extends JPanel{

	private JLabel nameL;
	private Image setting;
	private Image settingL;
	
	private final int panelWidth = 320;
	private final int panelHeight = 480;
	
	public FirstUI(){
		Images();
		initui();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);  
		g.drawImage(setting, 0, 0, this.getWidth(), this.getHeight(), this); 
	}
	
	private void initui(){
		Labels();
		
		this.setLayout(null);
		this.setSize(panelWidth, panelHeight);
		this.setVisible(true);
		
		this.add(nameL);
		nameL.setLocation((this.getWidth()-nameL.getWidth())/2, 50);
		
	}
	
	private void Labels(){
		nameL = new JLabel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);  
				g.drawImage(settingL, 0, 0, this.getWidth(), this.getHeight(), this); 
			}
		};
		nameL.setSize(150, 70);
	}
	
	
	/** 
	 * ��ʼ����һ����������Ҫʹ�õ�ͼƬ
	 * setting:����ͼƬ
	 */
	private void Images(){
		setting = Toolkit.getDefaultToolkit().getImage("image//FirstUI_01.jpg");
		settingL = Toolkit.getDefaultToolkit().getImage("image//FirstUI_name_01");
	}
}