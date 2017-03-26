import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.tree.FixedHeightLayoutCache;

public class BmpProgram {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("res/StephansPlatz.bmp");
		byte[] fileHeader = new byte[14];
		fis.read(fileHeader);
		
		//����ũ��
		int fileSize = getFileSize(fileHeader);
		
		System.out.printf("���� ������ : %d", fileSize);
		System.out.println();
		
	/*	byte[] bmpHeader = new byte[92];
		fis.read(bmpHeader);
		
		fis.close();
		
		int widthSize;
		widthSize = ((int)bmpHeader[4]) & 0x000000ff | 
						((int)bmpHeader[5]) << 8 & 0x0000ff00 | 
						((int)bmpHeader[6])<< 16 & 0x00ff0000 | 
						((int)bmpHeader[7])<< 24 & 0xff000000;
		System.out.printf("�ʺ� ������ : %d", widthSize);
*/
		
	}

	public static int getFileSize(byte[] fileHeader) {
		int fileSize = ((int)fileHeader[5]) << 24 & 0xff000000 | 
						((int)fileHeader[4]) << 16 & 0x00ff0000|
						((int)fileHeader[3]) << 8 & 0x0000ff00|
						((int)fileHeader[2]) & 0x000000ff;
		return fileSize;
	}
}
