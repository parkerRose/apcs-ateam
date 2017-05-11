import java.util.ArrayList;

public class W_King extends Piece
{
    public W_King(String a)
    {
        super(a);
    }
    
    public W_King(int a, int b)
    {
        super(a, b);
    }
    
    public boolean isSafeMove(String start, String end, Piece[][] board)
    {
        // ASSUME isValidEndSquare() returns true
        if(start != null && end != null) {
            for(Piece[] pArr: board) {
                for(Piece p: pArr) {
                    if(isABlackPiece(p)) {
                        for(String str: p.getPossibleMoves(board)) {
                            System.out.println("moves_str " + str);
                            System.out.println("moves_end " + end);
                            if(end.equals(str) && !start.equals(p.getPosition()))
                                return false;
                        }
                        for(String str: p.getPossibleCaptures(board)) {
                            System.out.println("captures_str " + str);
                            System.out.println("captures_end " + end);
                            if(end.equals(str) && !start.equals(p.getPosition()))
                                return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    public ArrayList<String> getPossibleMoves(Piece[][] board)
    {
        ArrayList<String> allPositions = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        if((position[0] <= 7 && position[1] <= 7) && (board[position[0] + 1][position[1] + 1] == null) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allPositions.add(convertToString(position[0] + 1, position[1] + 1));
        if((position[0] <= 7) && (board[position[0] + 1][position[1]] == null) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allPositions.add(convertToString(position[0] + 1, position[1]));
        if((position[0] <= 7 && position[1] >= 2) && (board[position[0] + 1][position[1] - 1] == null) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allPositions.add(convertToString(position[0] + 1, position[1] - 1));
        if((position[1] <= 7) && (board[position[0]][position[1] + 1] == null) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allPositions.add(convertToString(position[0], position[1] + 1));
        if((position[1] >= 2) && (board[position[0]][position[1] - 1] == null) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allPositions.add(convertToString(position[0], position[1] - 1));
        if((position[0] >= 2 && position[1] <= 7) && (board[position[0] - 1][position[1] + 1] == null) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allPositions.add(convertToString(position[0] - 1, position[1] + 1));
        if((position[0] >= 2) && (board[position[0] - 1][position[1]] == null) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allPositions.add(convertToString(position[0] - 1, position[1]));
        if((position[0] >= 2 && position[1] >= 2) && (board[position[0] - 1][position[1] - 1] == null) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allPositions.add(convertToString(position[0] - 1, position[1] - 1));
        
        return allPositions;
    }
    
    public ArrayList<String> getPossibleCaptures(Piece[][] board)
    {
        ArrayList<String> allCaptures = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        if((position[0] <= 7 && position[1] <= 7) && isABlackPiece(board[position[0] + 1][position[1] + 1]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0] + 1, position[1] + 1));
        if((position[0] <= 7) && isABlackPiece(board[position[0] + 1][position[1]]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0] + 1, position[1]));
        if((position[0] <= 7 && position[1] >= 2) && isABlackPiece(board[position[0] + 1][position[1] - 1]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0] + 1, position[1] - 1));
        if((position[1] <= 7) && isABlackPiece(board[position[0]][position[1] + 1]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0], position[1] + 1));
        if((position[1] >= 2) && isABlackPiece(board[position[0]][position[1] - 1]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0], position[1] - 1));
        if((position[0] >= 2 && position[1] <= 7) && isABlackPiece(board[position[0] - 1][position[1] + 1]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0] - 1, position[1] + 1));
        if((position[0] >= 2) && isABlackPiece(board[position[0] - 1][position[1]]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0] - 1, position[1]));
        if((position[0] >= 2 && position[1] >= 2) && isABlackPiece(board[position[0] - 1][position[1] - 1]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0] - 1, position[1] - 1));
        
        return allCaptures;
    }
}