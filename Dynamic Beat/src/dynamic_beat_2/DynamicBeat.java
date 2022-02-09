package dynamic_beat_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
	
	// 더블 버퍼링을 사용하여 배경 이미지 불러오기 
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground; // 배경 이미지를 담을 수 있는 객체

	public DynamicBeat() {
		
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); 
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true); 
		
		// 불러온 이미지를 introBackground 변수에 넣어서 초기화
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg")).getImage();
	}
	
	// 메소드
	// 가장 먼저 그림을 그리는 메소드
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics(); // screenGraphic를 사용하여 그래픽 객체를 가져옴
		screenDraw(screenGraphic); //screenDraw에 정의된 방식 대로 이미지를 그림
		g.drawImage(screenImage, 0, 0, null); // 이 위치에서 백그라운드가 그려짐 
	
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); // 이 위치에서 그림을 그림
		this.repaint(); // 다시 paint 함수를 불러옴, 프로그램 종료할 때 까지 반복 
	}
	
}
