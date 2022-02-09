package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
//	JFrame: gui 사용을 위해 상속
//	ctrl + shift + o 를 누르면 자동 import
	
	//	생성자 - 클래스와 같은 이름을 가진 메소드
	public DynamicBeat() {
		
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 사용자가 크기를 변경할 수 없음
		setLocationRelativeTo(null); // 화면의 정 중앙에서 시작
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫음과 동시에 프로그램 종료
		setVisible(true); // 게임 창이 화면에 정상 출력 되도록 
	}
	
}
