package omok.omok;

public class Omok {
	private int inX,inY; // ��ǥ�� ���� x�� y 
	private String dol = "0"; // "0"�� �� ��, "1"�� ���� ��
	private String dolColor = null; // ���� ���� ����

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
