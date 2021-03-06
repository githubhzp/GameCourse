package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.FirstUIControllerImpl;
/**
 * @Description: 
 * @author: hzp
 * @date: 
 */
public class FirstUI extends JPanel{
	
	private final int panelWidth = 320;
	private final int panelHeight = 480;
	private final int buttonWidth = 150;
	private final int buttonHeight = 60;
	
//	private Image mainSet;
	private ImageIcon nameSet;
	private ImageIcon patternSet1_1;
	private ImageIcon patternSet1_2;
	private ImageIcon patternSet2_1;
	private ImageIcon patternSet2_2;
	
	private JLabel nameL;
	
	private Button classicPatternB;
	private Button horriblePatternB;
	
	private FirstUIControllerServer controller = new FirstUIControllerImpl();
	
	public FirstUI(){
		Images();
		initui();
	}
	
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);  
//		g.drawImage(mainSet, 0, 0, this.getWidth(), this.getHeight(), this); 
//	}
	
	/** 
	 * 初始化第一个界面中所要使用的图片
	 * setting:背景图片
	 */
	private void Images(){
//		mainSet = Toolkit.getDefaultToolkit().getImage("image//FirstUI_01.jpg");
		nameSet = new ImageIcon("image//FirstUI_name_02.jpg");
		patternSet1_1 = new ImageIcon("image//FUIB_01_1.jpg");
		patternSet1_2 = new ImageIcon("image//FUIB_01_2.jpg");
		patternSet2_1 = new ImageIcon("image//FUIB_02_1.jpg");
		patternSet2_2 = new ImageIcon("image//FUIB_02_2.jpg");
	}
	
	private void initui(){
		Labels();
		Buttons();
		
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(panelWidth, panelHeight);
		this.setVisible(true);
		
		this.add(nameL);
		nameL.setLocation((panelWidth-nameL.getWidth())/2, 50);
		
		this.add(classicPatternB);
		this.add(horriblePatternB);
		classicPatternB.setLocation((panelWidth-buttonWidth)/2, 150);
		horriblePatternB.setLocation((panelWidth-buttonWidth)/2, 230);
	}
	
	private void Labels(){
		nameL = new JLabel();
		nameL.setIcon(nameSet);
		nameL.setSize(150, 70);
	}
	
	private void Buttons(){
		classicPatternB = new Button();
		classicPatternB.setSize(buttonWidth, buttonHeight);
		classicPatternB.setIcon(patternSet1_1);
		classicPatternB.setBorder(null);
		classicPatternB.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				classicPatternB.setIcon(patternSet1_2);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(!classicPatternB.getStatus())
					classicPatternB.setIcon(patternSet1_1);
			}
		});
		classicPatternB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.intoClassicPattern();
			}
		});
		
		horriblePatternB = new Button();
		horriblePatternB.setSize(buttonWidth, buttonHeight);
		horriblePatternB.setIcon(patternSet2_1);
		horriblePatternB.setBorder(null);
		horriblePatternB.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				horriblePatternB.setIcon(patternSet2_2);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(!horriblePatternB.getStatus())
					horriblePatternB.setIcon(patternSet2_1);
			}
		});
		horriblePatternB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.intoHorriblePatternB();
			}
			
		});
	}
	
}
