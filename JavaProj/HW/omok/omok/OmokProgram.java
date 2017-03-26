package omok.omok;
import java.util.Scanner;

public class OmokProgram { 	 // made by 선미

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String reStart;
		char a ;
		do{ // 반복 게임을 위한 while문 
		OmokStart();
		reStart = scan.nextLine(); // 재시작 여부 입력받아옴
			if(reStart.equals("n"))
			{
				System.out.println("───────────────End!───────────────");
				System.out.println("오목게임을 종료합니다.");
				break;
			}
		}while(reStart.equals("y"));
	}
	
	public static void OmokStart(){
		// 오목판그리기\
		Scanner scan1 = new Scanner(System.in);
		int m = 0;
		int n = 0; // 오목판을 그리기 위한 x,y 좌표 
		String strM, strN;
		boolean isString = true;
		// 객체 생성(보드, 턴, 오목알)
		System.out.println("──────────────────────────────────\n");
		System.out.println("가로 x줄, 세로 y줄 을 입력해 오목판을 생성하세요.");
		System.out.println("가로 x줄, 세로 y줄 을 입력해 오목판을 생성하세요. (x enter y)");

		while(isString) // 좌표 값 입력 받음 -> 숫자를 입력 했는지, 그 수가 7 이상인지 검사
		{
			System.out.println("●○●○●○오목판을 만들기 위해서는 7 이상의 좌표 값을 입력해주세요.●○●○●○");
			scan1 = new Scanner(System.in);
			strM = scan1.nextLine();
			strN = scan1.nextLine();

			if(StrToInt.isNum(strM) && StrToInt.isNum(strN))
			{
				m = StrToInt.changeNum(strM) +1; // 라인의 번호 줄을 고려해, 입력 값에 1을 추가 
				n = StrToInt.changeNum(strN) +1;
				if(m<8 && n<8)
					System.out.println("최소한의 오목판을 만들기 위하여 7 이상의 좌표 값이 필요합니다.");
				else
					isString = false;
			}
			else
				System.out.println("숫자를 입력해주시기 바랍니다.");
		}
		
		Board board = new Board(m, n);
		Omok omok = new Omok();
		Turn turn = new Turn();
		boolean start = true;
		
		// 보드 그려준다.
		board.drawBoard();

		System.out.println("");
		System.out.println("가로는 행, 세로는 열로 (x,y)로 입력해주세요.");

		System.out.println("───────────────오목게임───────────────");
		System.out.println("by 선미\n");

		// 흑, 흰돌 선택 가능 
		turn.selectTurn(omok);
		
		
		System.out.println("───────────────Start!───────────────");
		System.out.println();
		while (start) 
		{ // 게임 반복을 위한 while문
			
			System.out.println();
			String dolColor = omok.getDolColor(); // 돌의 색깔 가져옴
			String dol = omok.getDol(); // 놓을 오목 돌 가져옴
			
			System.out.println(dolColor + " 의 차례입니다. (x enter y) : ");
			boolean isNum = true;
			int inX = 0;
			int inY =0;
			
			while(isNum)
			{				
				String strInX = scan1.nextLine();
				String strInY = scan1.nextLine();
				if(StrToInt.isNum(strInX) && StrToInt.isNum(strInY))
				{
					inX = StrToInt.changeNum(strInX) -1; // 라인의 번호 줄을 고려해, 입력 값에 1을 추가 
					inY = StrToInt.changeNum(strInY) -1;
					isNum = false;
				}
				else
					System.out.println("숫자를 입력해주세요. (x enter y) ");
			}
		
/*			InputChangeInt xy = new InputChangeInt();
			xy.input();
			int inX = xy.getIntX();
			int inY = xy.getIntY();
			*/
			boolean isPut = board.isPut(inX,inY); // 범위, 오목알 존재 검사 만족
			
			if(isPut)
				{
					System.out.println("────────────────────────────");
					omok.setXY(inX, inY); // X,Y값 설정
					board.saveBackOmok(omok); // 무르기를 위해 돌을 놓기 전의 값(기존의 값) 저장
					board.putDol(omok); // 새 위치에 돌을 놓음.(새로운 값 을 받음)
					// 오목표 출력 & 한 수 무르기

					board.drawBoard();
					String isBack;
					
					do { // [y/n]이 아닌 경우를 제어하기 위한 do~while문
						System.out.println("한 수 무르시겠습니까? [y/n]");
						isBack = scan1.nextLine();

						if (isBack.equals("y")) {
							board.setBackOmok(omok);	// 원래 돌로 돌려놓음
							break;
						}

						else if (isBack.equals("n")) // 수를 무르지 않고 다음 턴 진행
						{
							
							if(board.checkWin(omok)){
								System.out.println("─────────────────────────────");
								System.out.printf("**********************%s의 승리입니다.**********************\n", dolColor);
								System.out.println("─────────────────────────────");
								// 게임을 새로 진행할지 묻는 쿼리 추가해야함!!
								System.out.println("게임을 계속 진행하시려면 y, 끝내려면 n을 눌러주세요.[y / n]");
								start=false;
								break;
							}
							turn.changeTurn(omok); //omok의 턴을 바꿔준다.
							break;
							
							
						}
						else // y, n 둘 다 입력하지 않은 경우 
							System.out.println("y 또는 n을 입력해주세요.");
						
					 } while (!isBack.equals("y") || !isBack.equals("n")); // do while 문 조건문, y,n 둘 다 입력하지 않은 경우
				}

		}			
	}

}

