package javaprogram;
import java.util.Scanner;
public class TicTacToe {

	private Player player1,player2;
	private Board board;
	private int counttime;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         TicTacToe t=new TicTacToe();
         t.startGame();
	}
	public void startGame() {
      player1=takePlayerInput(++counttime);
      player2=takePlayerInput(++counttime);
      while(player1.getSymbol()==player2.getSymbol()) {
    	  Scanner input=new Scanner(System.in);
    	  System.out.println("Symbol is already Taken!Enter a new Symbol");
    	  player2.setSymbol(input.next().charAt(0));
      }
      board=new Board(player1.getSymbol(),player2.getSymbol());
      boolean PlayerTurn=true;
    int status=Board.incomplete;
    while(status == Board.incomplete) {
    	 if(PlayerTurn) {
    		 Scanner input=new Scanner(System.in);
    		 System.out.println("Player 1"+player1.getName()+"'s Turn");
    		 System.out.println("Enter the X value:");
    		 int x=input.nextInt();
    		 System.out.println("Enter the Y value:");
    		 int y=input.nextInt();
    		 status=Board.move(player1.getSymbol(),x,y);
    		 if(status==Board.invalid) {
    			 System.out.println("Invlaid Move try again!");
    		 }
    	 }
    	 else {
    		 Scanner input=new Scanner(System.in);
    		 System.out.println("Player 2"+player2.getName()+"'s Turn");
    		 System.out.println("Enter the X value:");
    		 int x=input.nextInt();
    		 System.out.println("Enter the Y value:");
    		 int y=input.nextInt();
    		 status=board.move(player2.getSymbol(),x,y);
    		 if(status==Board.invalid) {
    			 System.out.println("Invlaid Move try again!");
    		 }
    		PlayerTurn=!PlayerTurn;
    		Board.print();
  
    	 }
      }
     if(status==Board.p1Wins) {
    	 System.out.println(player1.getName()+"wins");
     }
     else if(status==Board.p2Wins) {
    	 System.out.println(player2.getName()+"wins"); 
     }
	}
	private Player takePlayerInput(int num) {
		    Scanner input=new Scanner(System.in);
			System.out.println("Enter the Player"+num+"Name");
			String Name=input.next();
			System.out.println("Enter the playe"+num+" Symbol");
			char Symbol=input.next().charAt(0);
			Player P=new Player(Name,Symbol);
			return P;
	}

}
