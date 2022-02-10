package dynamic_beat_6;

import java.awt.Color;
import java.awt.Cursor;
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
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	// 좌 우 이동 버튼 추가 
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.jpg"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.jpg"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.jpg"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.jpg"));

	// 타이틀 이미지 추가 
	private Image titleImage = new ImageIcon(Main.class.getResource("../images/music1.png"))
			.getImage();
	
	// selectedImage 변수 추가
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/GameImage1.jpg"))
			.getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg"))
			.getImage();

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	// 좌 우 버튼 추가 
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	
	
	private int mouseX, mouseY;
	
	// 메인 페이지를 확인하는 변수
	private boolean isMainScreen = false;
	
	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); 
		setLayout(null);

		exitButton.setBounds(1170, 0, 30, 30);
		
		exitButton.setBorderPainted(false); 
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		
		exitButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override 
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
			
		});
		
		add(exitButton);
		
		startButton.setBounds(40, 250, 400, 100);
		
		startButton.setBorderPainted(false); 
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		
		startButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override 
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				
				startButton.setVisible(false);
				quitButton.setVisible(false); 
				// 버튼이 보이도록 코드 추가 
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
						.getImage();
				// 화면이 전환됨을 알림
				isMainScreen = true;
			}
			
		});
		
		add(startButton); 
		
		quitButton.setBounds(40, 380, 400, 100);
		
		quitButton.setBorderPainted(false); 
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		
		quitButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override 
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
			
			
		});
		
		add(quitButton); 
		
		// leftButton 추가 
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		
		leftButton.setBorderPainted(false); 
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		
		leftButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override 
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start(); 
				}
				// 왼쪽 버튼 이벤트
			
			
		});
		
		add(leftButton); 
		
		// rightButton 추가
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);	
		rightButton.setBorderPainted(false); 
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		
		rightButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override 
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				// 오른쪽 버튼 이벤트
			}
			
			
		});
		
		add(rightButton); 
		
		
		menuBar.setBounds(0, 0, 1200, 30); 
		
		
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		
		
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
		g.drawImage(background, 0, 0, null);
		// isMainScreen == true 이면 배경 이미지 바꾸기 
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		
		paintComponents(g); 
		this.repaint();
	}
}