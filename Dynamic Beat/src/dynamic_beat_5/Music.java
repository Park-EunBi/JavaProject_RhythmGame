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
	
	//생성자
	public Music(String name, boolean isLoop) {
		//오류 처리
		try {
			this.isLoop = isLoop;
			//음악 파일 불러오기
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

	//음악 재생 시간을 0.001초 단위로 받아 올 수 있는 메서드
	public int getTime() {
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	// 언제든지 안전하게 종료할 수 있도록 하는 메서드
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt(); // 종료
	}
	
	@Override
	// run - thread를 상속받으면 무조건 생기는 함수 
	public void run () {
		// 오류 처리
		try {
			// run 메서드에서 가장 중요한 부분 - 곡 실행 
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
