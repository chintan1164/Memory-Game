import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class Printboardwc
{
    Printboardwc(String cards[][],String board[][])
    {
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";
        for(int i=0;i<4;i++)
        {
            System.out.print(YELLOW + "|" + RESET);
            for(int j=0;j<4;j++)
            {
                if(board[i][j]==" _ ")
                {
                    System.out.print(YELLOW + board[i][j] + RESET);
                }
                else
                {
                    System.out.print(RED + board[i][j] + RESET);
                }
                System.out.print(YELLOW + "|" + RESET);;
            }
            System.out.println("");
        }
    }
}

class Shufflecard
{
    Shufflecard(String cards[][],String board[][])
    {
        Random random = new Random();
        ArrayList<String> letter = new ArrayList<String>();
        letter.add("A");
        letter.add("B");
        letter.add("C");
        letter.add("D");
        letter.add("E");
        letter.add("F");
        letter.add("G");
        letter.add("H");
        letter.add("A");
        letter.add("B");
        letter.add("C");
        letter.add("D");
        letter.add("E");
        letter.add("F");
        letter.add("G");
        letter.add("H");
        
        int index;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                index = random.nextInt(letter.size());
                cards[i][j] = letter.get(index);
                letter.remove(index);
            }
        }
    }
}

class CheckInput 
{
    CheckInput(String cards[][],String board[][])
    {
	    String RESET = "\u001B[0m"; 
	    String GREEN = "\u001B[32m";
        Scanner Scan= new Scanner(System.in);
        there: while(true)
        {
            gameover go = new gameover();
            if(!(go.gameover(cards,board)))
            {
                
                System.out.print("Select row  1 - 4 :");
                int row1 = Scan.nextInt();
                if(row1>4)
                {
                    System.out.println("Invalid row...");
                    System.out.println();
                    continue there;
                }
                System.out.print("Select column  1 - 4 :");
                int column1 = Scan.nextInt();
                if(column1>4)
                {
                    System.out.println("Invalid column...");
                    System.out.println();
                    continue there;
                }
                System.out.println();
                if(!board[row1-1][column1-1].equals(" _ "))
                {
                    System.out.println();
                    System.out.println("You already Entered.... ");
                    System.out.println();
                    
                    Printboardwc pbwc = new Printboardwc(cards,board);
                    continue;
                }
                else
                {
                    board[row1-1][column1-1] = " " + cards[row1-1][column1-1] + " ";
                    Printboardwc pbwc = new Printboardwc(cards,board);
                }
                System.out.print("Select row  1 - 4 :");
                int row2 = Scan.nextInt();
                if(row2>4)
                {
                    System.out.println("Invalid row ...");
                    System.out.println();
                    continue there;
                }
                System.out.print("Select column  1 - 4 :");
                int column2 = Scan.nextInt();
                if(column2>4)
                {
                    System.out.println("Invalid column...");
                    System.out.println();
                    continue there;
                }
                System.out.println();
                if(!board[row2-1][column2-1].equals(" _ "))
                {
                    System.out.println();
                    System.out.println("Already Entered :- ");
                    board[row1-1][column1-1] = " _ ";
                    System.out.println();
                    
                    Printboardwc pbwc = new Printboardwc(cards,board);
                    continue;
                }
                else
                {
                    board[row2-1][column2-1] = " " + cards[row2-1][column2-1] + " ";
                    if(board[row1-1][column1-1].equals(board[row2-1][column2-1]))
                    {
                        Printboardwc pbwc = new Printboardwc(cards,board);
                        System.out.println();
                        System.out.println("Correct !!");
                        System.out.println();
                    }
                    
                    else
                    {
                        Printboardwc pbwc1 = new Printboardwc(cards,board);
                        System.out.println();
                        System.out.println("False ..!");
                        board[row1-1][column1-1] = " _ ";
                        board[row2-1][column2-1] = " _ ";
                        System.out.println();
                        Printboardwc pbwc2 = new Printboardwc(cards,board);
                    }
                    
                }
            }
            else
            {
                System.out.println(GREEN + "Game Over ..!" + RESET);
                System.out.println();
                break;
            }
        }
    }
}

class gameover
{
    boolean gameover(String cards[][],String board[][])
    {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(board[i][j].equals(" _ "))
                {
                    return false;
                }
            }
        }
        return true;
    }
}

class Main
{
	public static void main(String[] args) 
	{
	    String RESET = "\u001B[0m";
	    String board[][]=new String[4][4];
        String cards[][]=new String[4][4];
	    Scanner Scan= new Scanner(System.in);
	    while(true)
	    {
	        System.out.println("Press n for new game , q for quit");
	        String nq = Scan.nextLine();
	        if(nq.equals("q"))
	        {
	            System.out.println("Exiting....");
	            break;
	        }
	        else if(nq.equals("n"))
	        {
	            Shufflecard sc = new Shufflecard(cards,board);
	            for(int i=0;i<4;i++)
	            {
	                for(int j=0;j<4;j++)
	                {
	                    board[i][j] = " _ ";
	                }
	            }
	            Printboardwc pbwcc = new Printboardwc(cards,board);
	            CheckInput ci = new CheckInput(cards,board);
	            continue;
	        }
	        else
	        {
	            System.out.println("Invalid Character...." );
	            continue;
	        }
	    }
	}
}
