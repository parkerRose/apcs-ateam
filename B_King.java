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
    
    public boolean isSafeMove(String start, String end, Piece[][] board)
    {
        // ASSUME isValidEndSquare() returns true
        if(start != null && end != null) {
            for(Piece[] pArr: board) {
                for(Piece p: pArr) {
                    if(isAWhitePiece(p)) {
                        for(String str: p.getPossibleMoves(board)) {
                            if(end.equals(str) && !start.equals(str))
                                return false;
                        }
                        for(String str: p.getPossibleCaptures(board)) {
                            if(end.equals(str) && !start.equals(str))
                                return false;
                        }
                    }
                }
            }
        }
        return true;
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
        if((position[0] <= 7 && position[1] <= 7) && isAWhitePiece(board[position[0] + 1][position[1] + 1]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0] + 1, position[1] + 1));
        if((position[0] <= 7) && isAWhitePiece(board[position[0] + 1][position[1]]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0] + 1, position[1]));
        if((position[0] <= 7 && position[1] >= 2) && isAWhitePiece(board[position[0] + 1][position[1] - 1]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0] + 1, position[1] - 1));
        if((position[1] <= 7) && isAWhitePiece(board[position[0]][position[1] + 1]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0], position[1] + 1));
        if((position[1] >= 2) && isAWhitePiece(board[position[0]][position[1] - 1]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0], position[1] - 1));
        if((position[0] >= 2 && position[1] <= 7) && isAWhitePiece(board[position[0] - 1][position[1] + 1]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0] - 1, position[1] + 1));
        if((position[0] >= 2) && isAWhitePiece(board[position[0] - 1][position[1]]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0] - 1, position[1]));
        if((position[0] >= 2 && position[1] >= 2) && isAWhitePiece(board[position[0] - 1][position[1] - 1]) && isSafeMove(super.getPosition(), convertToString(position[0] + 1, position[1] + 1), board))
            allCaptures.add(convertToString(position[0] - 1, position[1] - 1));
        
        return allCaptures;
    }
}
