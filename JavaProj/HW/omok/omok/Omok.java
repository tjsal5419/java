package omok.omok;

public class Omok {
	private int inX,inY; // 좌표를 위한 x와 y 
	private String dol = "0"; // "0"은 흰 돌, "1"은 검은 돌
	private String dolColor = null; // 돌의 색을 저장

	public Omok() {
		}

	public String getDol() {
		return dol;
	}

	public String getDolColor() {
		return dolColor;
	}

	public void setXY(int inX, int inY) {
		this.inX = inX;
		this.inY = inY;
	}


	public int getInX() {
		return inX;
	}



	public int getInY() {
		return inY;
	}



	public void setDol(String dol) {
		this.dol = dol;
	}


	public void setDolColor(String dolColor) {
		this.dolColor = dolColor;
	}
	

	
	/*int back_white_x = 0, back_white_y = 0, back_black_x = 0, back_black_y = 0;
	*/

}
