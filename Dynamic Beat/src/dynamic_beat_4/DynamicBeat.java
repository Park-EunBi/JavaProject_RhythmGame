package dynamic_beat_4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));

	// ImageIcon�� ��ġ�� ���� �̵�
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg"))
			.getImage();
	// menuBar ����
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	// exitButton �߰�
	//private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png")));
	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	
	private int mouseX, mouseY;
	
	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); // �ʱ� ���� ����
		setLayout(null);

		// exitButton�� ��ġ ����
		exitButton.setBounds(1170, 0, 30, 30);
		
		// �⺻ ���� ������ ����
		exitButton.setBorderPainted(false); 
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		
		exitButton.addMouseListener(new MouseAdapter() {
			// ���콺�� ������ ���� �ö� ���� �� 
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
			}
			// ���콺�� ������ �ۿ� ���� ��
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
			}
			// �������� Ŭ�� ���� ��
			@Override 
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				// ���α׷� ����
				System.exit(0);
			}
			
		});
		
		add(exitButton);
		
		// �޴��� ��ġ ���� 
		menuBar.setBounds(0, 0, 1200, 30); 
		
		// ���콺 ��ġ �������� 
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		
		//�޴� �ٸ� �巡�� �ؼ� ������ â�� ��ġ ����
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override 
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		
		add(menuBar);	

		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g); 
		this.repaint();
	}
}
