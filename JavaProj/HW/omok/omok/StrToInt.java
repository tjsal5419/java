package omok.omok;

public class StrToInt {
	
	public static boolean isNum(String strNum){
		char[] charNum = strNum.toCharArray();
		boolean isNum = true; 
		
		if(charNum.length>0){
			for(int i=0;i<charNum.length;i++)
			{
				if(charNum[i]<'0' || charNum[i]>'9')
					isNum = isNum & false; // ���ڰ� �ƴ� ��� false ��ȯ 
			}
			
		}
		else
			isNum = false;
		return isNum;
	}

	public static int changeNum(String strNum)
	{
		return Integer.parseInt(strNum);
	}

}
