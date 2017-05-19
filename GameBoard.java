/** Mandatory Objectives:
  * X All Piece subclasses have a getPossibleMoves(//parameters if any) method
  * X All Piece subclasses have a getPossibleCaptures(//parameters, if any) method
  * X     Pieces can only move to a square already not occupied
  * X     Jumping over a piece is not allowed (except for a knight)
  * X     A pawn can capture a piece diagonally
  * Check
  * Legal moves for the King (cannot move to a square that is attacked)
  */

/** Optional Objectives:
  * Display game pieces out of the game and total points of captures pieces per side
  * Pawn goes to the 8th square - convert to another piece
  * En Passant (pawn passes over the opposing pawn and captures it)
  * Checkmate
  * Stalemate
  */

import java.util.ArrayList;

public class GameBoard
{
    private Piece[][] board = new Piece[9][9];
    private int movesCount;
   
    
    public String getPlayer() {
        if (movesCount % 2 == 0)
            return "White";
        else
            return "Black";
    }
    
    public Piece[][] getBoard() {
        return board;
    }
    
    public void increaseMoves() {
        movesCount++;
    }
    
    public GameBoard()
    {
        for(int c = 1; c < board.length; c++) {
            board[2][c] = new Pawn(2,c,Piece.Color.BLACK);
            board[7][c] = new Pawn(7,c,Piece.Color.WHITE);
        }
        board[1][1] = new Rook(1,1,Piece.Color.BLACK);
        board[1][8] = new Rook(1,8,Piece.Color.BLACK);
        board[8][1] = new Rook(8,1,Piece.Color.WHITE);
        board[8][8] = new Rook(8,8,Piece.Color.WHITE);
        board[1][2] = new Knight(1,2,Piece.Color.BLACK);
        board[1][7] = new Knight(1,7,Piece.Color.BLACK);
        board[8][2] = new Knight(8,2,Piece.Color.WHITE);
        board[8][7] = new Knight(8,7,Piece.Color.WHITE);
        board[1][3] = new Bishop(1,3,Piece.Color.BLACK);
        board[1][6] = new Bishop(1,6,Piece.Color.BLACK);
        board[8][3] = new Bishop(8,3,Piece.Color.WHITE);
        board[8][6] = new Bishop(8,6,Piece.Color.WHITE);
        board[1][4] = new Queen(1,4,Piece.Color.BLACK);
        board[8][4] = new Queen(8,4,Piece.Color.WHITE);
        board[1][5] = new King(1,5,Piece.Color.BLACK);
        board[8][5] = new King(8,5,Piece.Color.WHITE);
    }
    
    public boolean isInRange(String input) {
        if(input.length() == 2) {
            String s = input.substring(0,1).toUpperCase();
            return input.length() == 2 && (s.equals("A") || s.equals("B") || s.equals("C") || s.equals("D") || s.equals("E") || s.equals("F") || s.equals("G") || s.equals("H")) && ('1' <= input.charAt(1) && input.charAt(1) <= '8');
        }
        return false;
    }
    
    public ArrayList<String> getAllGBMoves(String a)
    {
        int[] input = Piece.convertToChessInt(a);
        return board[input[0]][input[1]].getPossibleMoves(board);
    }
    
    public ArrayList<String> getAllGBCaptures(String a)
    {
        int[] input = Piece.convertToChessInt(a);
        return board[input[0]][input[1]].getPossibleCaptures(board);
    }
    
    /* public static boolean isAWhitePiece(String square)
     {
     return isAWhitePiece(board[Piece.convertToChessInt(square)[0]][Piece.convertToChessInt(square)[1]]);
     }
     
     public static boolean isABlackPiece(String square)
     {
     return isABlackPiece(board[Piece.convertToChessInt(square)[0]][Piece.convertToChessInt(square)[1]]);
     }
     
     public static boolean isAWhitePiece(int c, int b)
     {
     return isAWhitePiece(Piece.convertToString(c, b));
     }
     
     public static boolean isABlackPiece(int c, int b)
     {
     return isABlackPiece(Piece.convertToString(c, b));
     }
     
     */
    
    
    
    public boolean isValidStartSquare(String input)
    {
        if(isInRange(input)) {
            int[] arrInput = new int[2];
            arrInput = Piece.convertToChessInt(input);
            Piece a = board[arrInput[0]][arrInput[1]];
            
            if((this.getPlayer().equals("White"))&&((a instanceof King) || (a instanceof Queen) || (a instanceof Rook) || (a instanceof Bishop) || (a instanceof Knight) || (a instanceof Pawn))){
                return true;
            }
            
            if((this.getPlayer().equals("Black"))&&((a instanceof King) || (a instanceof Queen) || (a instanceof Rook) || (a instanceof Bishop) || (a instanceof Knight) || (a instanceof Pawn))){
                return true;
            }
        }
        return false;
    }
    
    public boolean isValidEndSquare(String start, String end)
    {
        if(isValidStartSquare(start)) {
            for(String a: getAllGBMoves(start)) {
                if(a.equals(end.toUpperCase()))
                    return true;
            }
            for(String a: getAllGBCaptures(start)) {
                if(a.equals(end.toUpperCase()))
                    return true;
            }
            
        }
        return false;
    }
    
    public void makeMove(String start, String end)
    {
        if(isValidEndSquare(start, end)) {
            Piece a = board[Piece.convertToChessInt(start)[0]][Piece.convertToChessInt(start)[1]];
            int b = Piece.convertToChessInt(end)[0];
            int c = Piece.convertToChessInt(end)[1];
            if (a instanceof King && a.getColor() == Piece.Color.BLACK)
                board[b][c] = new King (b, c,Piece.Color.BLACK);
            if (a instanceof Queen && a.getColor() == Piece.Color.BLACK)
                board[b][c] = new Queen (b, c,Piece.Color.BLACK);
            if (a instanceof Rook && a.getColor() == Piece.Color.BLACK)
                board[b][c] = new Rook (b, c,Piece.Color.BLACK);
            if (a instanceof Bishop && a.getColor() == Piece.Color.BLACK)
                board[b][c] = new Bishop (b, c,Piece.Color.BLACK);
            if (a instanceof Knight && a.getColor() == Piece.Color.BLACK)
                board[b][c] = new Knight (b, c,Piece.Color.BLACK);
            if (a instanceof Pawn && a.getColor() == Piece.Color.BLACK)
                board[b][c] = new Pawn (b, c,Piece.Color.BLACK);
            if (a instanceof King && a.getColor() == Piece.Color.WHITE)
                board[b][c] = new King (b, c,Piece.Color.WHITE);
            if (a instanceof Queen && a.getColor() == Piece.Color.WHITE)
                board[b][c] = new Queen (b, c,Piece.Color.WHITE);
            if (a instanceof Rook && a.getColor() == Piece.Color.WHITE)
                board[b][c] = new Rook (b, c,Piece.Color.WHITE);
            if (a instanceof Bishop && a.getColor() == Piece.Color.WHITE)
                board[b][c] = new Bishop (b, c,Piece.Color.WHITE);
            if (a instanceof Knight && a.getColor() == Piece.Color.WHITE)
                board[b][c] = new Knight (b, c,Piece.Color.WHITE);
            if (a instanceof Pawn && a.getColor() == Piece.Color.WHITE)
                board[b][c] = new Pawn (b, c,Piece.Color.WHITE);
            
            board[Piece.convertToChessInt(start)[0]][Piece.convertToChessInt(start)[1]] = null;
        }
    }
    
    public String toString()
    {
        String s = "";
        String add = "";
        
        s += "                        CHESS\n\n";
        s += "        A     B     C     D     E     F     G     H\n      _______________________________________________\n ";
        for(int r = 1; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                if (board[r][c] == null) {
                    if(c==0)
                        add = (9-r) + "  ";
                    else
                        add = "   ";
                }
                if (board[r][c] instanceof King && board[r][c].getColor() == Piece.Color.WHITE)
                    add = "W_K";
                if (board[r][c] instanceof Queen && board[r][c].getColor() == Piece.Color.WHITE)
                    add = "W_Q";
                if (board[r][c] instanceof Rook && board[r][c].getColor() == Piece.Color.WHITE)
                    add = "W_R";
                if (board[r][c] instanceof Bishop && board[r][c].getColor() == Piece.Color.WHITE)
                    add = "W_B";
                if (board[r][c] instanceof Knight && board[r][c].getColor() == Piece.Color.WHITE)
                    add = "W_N";
                if (board[r][c] instanceof Pawn && board[r][c].getColor() == Piece.Color.WHITE)
                    add = "W_P";
                if (board[r][c] instanceof King && board[r][c].getColor() == Piece.Color.BLACK)
                    add = "B_K";
                if (board[r][c] instanceof Queen && board[r][c].getColor() == Piece.Color.BLACK)
                    add = "B_Q";
                if (board[r][c] instanceof Rook && board[r][c].getColor() == Piece.Color.BLACK)
                    add = "B_R";
                if (board[r][c] instanceof Bishop && board[r][c].getColor() == Piece.Color.BLACK)
                    add = "B_B";
                if (board[r][c] instanceof Knight && board[r][c].getColor() == Piece.Color.BLACK)
                    add = "B_N";
                if (board[r][c] instanceof Pawn && board[r][c].getColor() == Piece.Color.BLACK)
                    add = "B_P";
                s += add + " | ";
            }
            s += "\n     |_____|_____|_____|_____|_____|_____|_____|_____|\n ";
        }
        return s;
    }
    
    
}
