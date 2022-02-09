package dynamic_beat_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
	
	// ���� ���۸��� ����Ͽ� ��� �̹��� �ҷ����� 
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground; // ��� �̹����� ���� �� �ִ� ��ü

	public DynamicBeat() {
		
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); 
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true); 
		
		// �ҷ��� �̹����� introBackground ������ �־ �ʱ�ȭ
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg")).getImage();
	}
	
	// �޼ҵ�
	// ���� ���� �׸��� �׸��� �޼ҵ�
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics(); // screenGraphic�� ����Ͽ� �׷��� ��ü�� ������
		screenDraw(screenGraphic); //screenDraw�� ���ǵ� ��� ��� �̹����� �׸�
		g.drawImage(screenImage, 0, 0, null); // �� ��ġ���� ��׶��尡 �׷��� 
	
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); // �� ��ġ���� �׸��� �׸�
		this.repaint(); // �ٽ� paint �Լ��� �ҷ���, ���α׷� ������ �� ���� �ݺ� 
	}
	
}
