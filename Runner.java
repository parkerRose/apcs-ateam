import java.util.Scanner;
import java.util.ArrayList;

public class Runner
{
    public static String printArr (ArrayList<String> Arr)
    {
        if(Arr.size() == 0) {
            return "none";
        }
        if(Arr.size() == 1) {
            return Arr.get(0);
        }
        if(Arr.size() == 2) {
            return Arr.get(0) + " and " + Arr.get(1);
        }
        String s = "";
        for(int i = 0; i < Arr.size() - 2; i ++)
            s += Arr.get(i) + ", ";
        s += Arr.get(Arr.size() - 2) + ", and " + Arr.get(Arr.size() - 1);
        
        return s;
    }
    
    public static void main (String [] args)
    {
        boolean gameIsOver = false;
        String inputStart;
        String inputEnd;
        
        GameBoard b = new GameBoard();
        System.out.println(b);
        
        Scanner scan = new Scanner (System.in);
        
        while (!gameIsOver) {
            
            System.out.println(b.getPlayer() + "'s turn. Please enter the start square of the piece you would like to move in the format \"(Column#)(Row#)\" (An example is A1):");
            inputStart = scan.nextLine().toUpperCase();
            
            while (!b.isValidStartSquare(inputStart)) {
                System.err.println("An invalid start square was entered. " + b.getPlayer() + "'s turn. Please enter a valid start square in the format \"(Column#)(Row#)\" (An example is A1):");
                inputStart = scan.nextLine().toUpperCase();
            }
            
            if(!(printArr(b.getAllGBMoves(inputStart)).equals("none"))) {
                System.out.println("The possible end positions for this piece are " + printArr(b.getAllGBMoves(inputStart)) + ". The possible captures are " + printArr(b.getAllGBCaptures(inputStart)) + ". Please choose enter one of these possible end positions below:");
                inputEnd = scan.nextLine().toUpperCase();
                while (!b.isValidEndSquare(inputStart, inputEnd)) {
                    System.err.println("An invalid end square was entered. " + b.getPlayer() + "'s turn. The possible end positions for this piece are " + printArr(b.getAllGBMoves(inputStart)) + ". The possible captures are: " + printArr(b.getAllGBCaptures(inputStart)) + ". Please choose enter one of these possible end positions below:");
                    inputEnd = scan.nextLine().toUpperCase();
                }
                b.makeMove(inputStart, inputEnd);
                System.out.println(b);
                if(b.areKingsTouching())
                    System.err.println("ERROR: Kings are touching -> Reset Game");
                if(!b.GBisInCheck().equals("Neither"))
                    System.err.println(b.GBisInCheck() + " is in check!");
                b.increaseMoves();
            } else {
                System.err.println("Sorry, no valid end positions for this piece exist.");
            }
        }
    }

}