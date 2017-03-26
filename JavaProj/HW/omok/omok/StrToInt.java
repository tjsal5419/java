package omok.omok;

public class StrToInt {
	
	public static boolean isNum(String strNum){
		char[] charNum = strNum.toCharArray();
		boolean isNum = true; 
		
		if(charNum.length>0){
			for(int i=0;i<charNum.length;i++)
			{
				if(charNum[i]<'0' || charNum[i]>'9')
					isNum = isNum & false; // 숫자가 아닌 경우 false 반환 
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
