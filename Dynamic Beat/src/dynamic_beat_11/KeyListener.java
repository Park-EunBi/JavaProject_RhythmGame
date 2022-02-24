package dynamic_beat_11;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{

	// 키 이벤트를 감지하는 함수 오버라이드 

	@Override
	// 키를 눌렀다면 
	public void keyPressed(KeyEvent e) {
		// 게임이 진행되고 있지 않다면 
		if(DynamicBeat.game == null) {
			return;
		}
		// 해당 키를 누르면 
		if(e.getKeyCode() == KeyEvent.VK_S) {
			DynamicBeat.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			DynamicBeat.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			DynamicBeat.game.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			DynamicBeat.game.pressSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			DynamicBeat.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			DynamicBeat.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			DynamicBeat.game.pressL();
		}
	}
	
	@Override
	// 키를 뗐다면 
	public void keyReleased(KeyEvent e) {
		// 게임이 진행되고 있지 않다면 
		if(DynamicBeat.game == null)
			return;
		if(e.getKeyCode() == KeyEvent.VK_S) {
			DynamicBeat.game.releaseS();
    	}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			DynamicBeat.game.releaseD();
    	}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			DynamicBeat.game.releaseF();
    	}           
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			DynamicBeat.game.releaseSpace();
    	}           
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			DynamicBeat.game.releaseJ();
    	}           	
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			DynamicBeat.game.releaseK();
    	}           	
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			DynamicBeat.game.releaseL();
    	}           
	}

}
