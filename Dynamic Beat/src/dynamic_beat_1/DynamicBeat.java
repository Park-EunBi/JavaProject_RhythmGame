package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
//	JFrame: gui ����� ���� ���
//	ctrl + shift + o �� ������ �ڵ� import
	
	//	������ - Ŭ������ ���� �̸��� ���� �޼ҵ�
	public DynamicBeat() {
		
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // ����ڰ� ũ�⸦ ������ �� ����
		setLocationRelativeTo(null); // ȭ���� �� �߾ӿ��� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â�� ������ ���ÿ� ���α׷� ����
		setVisible(true); // ���� â�� ȭ�鿡 ���� ��� �ǵ��� 
	}
	
}
