import java.util.ArrayList;

public class B_King extends Piece
{
    public B_King(String a)
    {
        super(a);
    }
    
    public B_King(int a, int b)
    {
        super(a, b);
    }
    
    public boolean isSafeMove(String end, Piece[][] board)
    {
        //ASSUMES isValidEndSquare() returns true
        boolean isSafe = true;
        board[convertToChessInt(super.getPosition())[0]][convertToChessInt(super.getPosition())[1]] = null;
        for(Piece[] pArr: board) {
            for(Piece p: pArr) {
                if(isAWhitePiece(p) && !(p instanceof W_King)) {
                    if (p instanceof W_Pawn) {
                        for(String str: ((W_Pawn)p).getSpecialPossibleCaptures(board)) {
                            if(end.toUpperCase().equals(str)) {
                                isSafe = false;
                            }
                        }
                    } else {
                        for(String str: p.getPossibleMoves(board)) {
                            if(end.toUpperCase().equals(str)) {
                                isSafe = false;
                            }
                        }
                    }
                }
            }
        }
        board[convertToChessInt(super.getPosition())[0]][convertToChessInt(super.getPosition())[1]] = new B_King(convertToChessInt(super.getPosition())[0], convertToChessInt(super.getPosition())[1]);
        return isSafe;
    }
    
    public boolean isInCheck(Piece[][] board)
    {
        boolean isInCheck = false;
        for(Piece[] pArr: board) {
            for(Piece p: pArr) {
                if(isAWhitePiece(p) && !(p instanceof W_King)) {
                    if(p instanceof W_Pawn) {
                        for(String str: p.getPossibleCaptures(board)) {
                            if(super.getPosition().equals(str))
                                isInCheck = true;
                        }
                    } else {
                        for(String str: p.getPossibleMoves(board)) {
                            if(super.getPosition().equals(str))
                                isInCheck = true;
                        }
                    }
                }
            }
        }
        return isInCheck;
    }
    
    public ArrayList<String> getPossibleMoves(Piece[][] board)
    {
        ArrayList<String> allPositions = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        for(int a = -1; a <= 1; a ++) {
            for(int b = -1; b <= 1; b ++) {
                if(!(a == 0 && b == 0) && (position[0] + a <= 8 && position[1] + b <= 8 && position[0] + a >= 1 && position[1] + b >= 1) && (board[position[0] + a][position[1] + b] == null) && isSafeMove(convertToString(position[0] + a, position[1] + b), board))
                    allPositions.add(convertToString(position[0] + a, position[1] + b));
            }
        }
        
        ArrayList<String> captures = getPossibleCaptures(board);
        for(int i = 0; i < captures.size(); i++) {
            allPositions.add(captures.get(i));
        }
        
        return allPositions;
    }
    
    public ArrayList<String> getPossibleCaptures(Piece[][] board)
    {
        ArrayList<String> allCaptures = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        for(int a = -1; a <= 1; a ++) {
            for(int b = -1; b <= 1; b ++) {
                if(!(a == 0 && b == 0) && (position[0] + a <= 8 && position[1] + b <= 8 && position[0] + a >= 1 && position[1] + b >= 1) && isAWhitePiece(board[position[0] + a][position[1] + b]) && isSafeMove(convertToString(position[0] + a, position[1] + b), board))
                    allCaptures.add(convertToString(position[0] + a, position[1] + b));
            }
        }
        
        return allCaptures;
    }
}
