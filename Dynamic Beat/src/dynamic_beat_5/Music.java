package dynamic_beat_5;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	//������
	public Music(String name, boolean isLoop) {
		//���� ó��
		try {
			this.isLoop = isLoop;
			//���� ���� �ҷ�����
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

	//���� ��� �ð��� 0.001�� ������ �޾� �� �� �ִ� �޼���
	public int getTime() {
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	// �������� �����ϰ� ������ �� �ֵ��� �ϴ� �޼���
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt(); // ����
	}
	
	@Override
	// run - thread�� ��ӹ����� ������ ����� �Լ� 
	public void run () {
		// ���� ó��
		try {
			// run �޼��忡�� ���� �߿��� �κ� - �� ���� 
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
