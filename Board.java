package javaprogram;

public class Board {
 private static char[][] board;
 private static char p1Symbol;
private char p2Symbol;
 private static int  boardSize=3;
 public static int count=0;
 private static char empty=' ';
 public static  final int p1Wins=1;
 public static  final  int p2Wins=2;
 public static  final  int draw=3;
 public static  final  int incomplete=4;
 public static  final  int invalid=5;
 
 public Board(char player1,char player2) {
	 board=new char[boardSize][boardSize];
	 for(int i=0;i<board.length;i++) {
		 for(int j=0;j<board[i].length;j++) {
			 board[i][j]=empty;
		 }
	 }
	 this.p1Symbol=player1;
	 this.p2Symbol=player2;
 }
 public static void print() {
		  System.out.println("-----------------------------");
		  for(int i=0;i<boardSize;i++) {
			  for(int j=0;j<boardSize;j++) {
				  System.out.print("|"+board[i][j]+"|");
			  }
		  }
 }
 public static int move(char Symbol,int x,int y) {
	 if(x<0||x>=boardSize||y<0||y>=boardSize) {
		 return invalid;
	 }
	 board[x][y]=Symbol;
	 count++;
	 //row
	 if(board[x][0]==board[x][1]&&board[x][0]==board[x][2]) {
		 return Symbol==p1Symbol ? p1Wins: p2Wins;
	 }
	//column
	 if(board[0][y]==board[1][y]&&board[0][y]==board[0][2]) {
		 return Symbol==p1Symbol ? p1Wins: p2Wins;
	 }
	//diagnoals
	 if(board[0][0]!=empty&&board[0][0]==board[1][1]&&board[0][0]==board[2][2]) {
		 return Symbol==p1Symbol ? p1Wins: p2Wins;
	 }
	 if(board[0][0]!=empty&&board[0][2]==board[1][1]&&board[0][2]==board[2][0]) {
		 return Symbol==p1Symbol ? p1Wins: p2Wins;
	 }
	 if(count==boardSize*boardSize) {
		 return draw;
	 }
	 return incomplete;
 }
}
