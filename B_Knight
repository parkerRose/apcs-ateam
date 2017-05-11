import java.util.ArrayList;

public class B_Knight extends Piece
{
    public B_Knight(String a)
    {
        super(a);
    }
    
    public B_Knight(int a, int b)
    {
        super(a, b);
    }
    
    public ArrayList<String> getPossibleMoves(Piece[][] board)
    {
        ArrayList<String> allPositions = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        
        if((position[0] <= 6 && position[1] <= 7) && (board[position[0] + 2][position[1] + 1] == null))
            allPositions.add(convertToString(position[0] + 2, position[1] + 1));
        if((position[0] <= 7 && position[1] <= 6) && (board[position[0] + 1][position[1] + 2] == null))
            allPositions.add(convertToString(position[0] + 1, position[1] + 2));
        if((position[0] >= 3 && position[1] >= 2) && (board[position[0] - 2][position[1] - 1] == null))
            allPositions.add(convertToString(position[0] - 2, position[1] - 1));
        if((position[0] >= 2 && position[1] >= 3) && (board[position[0] - 1][position[1] - 2] == null))
            allPositions.add(convertToString(position[0] - 1, position[1] - 2));
        if((position[0] <= 6 && position[1] >= 2) && (board[position[0] + 2][position[1] - 1] == null))
            allPositions.add(convertToString(position[0] + 2, position[1] - 1));
        if((position[0] <= 7 && position[1] >= 3) && (board[position[0] + 1][position[1] - 2] == null))
            allPositions.add(convertToString(position[0] + 1, position[1] - 2));
        if((position[0] >= 3 && position[1] <= 7) && (board[position[0] - 2][position[1] + 1] == null))
            allPositions.add(convertToString(position[0] - 2, position[1] + 1));
        if((position[0] >= 2 && position[1] <= 6) && (board[position[0] - 1][position[1] + 2] == null))
            allPositions.add(convertToString(position[0] - 1, position[1] + 2));
        
        return allPositions;
    }
    
    public ArrayList<String> getPossibleCaptures(Piece[][] board)
    {
        ArrayList<String> allCaptures = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        
        if((position[0] <= 6 && position[1] <= 7) && isAWhitePiece(board[position[0] + 2][position[1] + 1]))
            allCaptures.add(convertToString(position[0] + 2, position[1] + 1));
        if((position[0] <= 7 && position[1] <= 6) && isAWhitePiece(board[position[0] + 1][position[1] + 2]))
            allCaptures.add(convertToString(position[0] + 1, position[1] + 2));
        if((position[0] >= 3 && position[1] >= 2) && isAWhitePiece(board[position[0] - 2][position[1] - 1]))
            allCaptures.add(convertToString(position[0] - 2, position[1] - 1));
        if((position[0] >= 2 && position[1] >= 3) && isAWhitePiece(board[position[0] - 1][position[1] - 2]))
            allCaptures.add(convertToString(position[0] - 1, position[1] - 2));
        if((position[0] <= 6 && position[1] >= 2) && isAWhitePiece(board[position[0] + 2][position[1] - 1]))
            allCaptures.add(convertToString(position[0] + 2, position[1] - 1));
        if((position[0] <= 7 && position[1] >= 3) && isAWhitePiece(board[position[0] + 1][position[1] - 2]))
            allCaptures.add(convertToString(position[0] + 1, position[1] - 2));
        if((position[0] >= 3 && position[1] <= 7) && isAWhitePiece(board[position[0] - 2][position[1] + 1]))
            allCaptures.add(convertToString(position[0] - 2, position[1] + 1));
        if((position[0] >= 2 && position[1] <= 6) && isAWhitePiece(board[position[0] - 1][position[1] + 2]))
            allCaptures.add(convertToString(position[0] - 1, position[1] + 2));
        
        return allCaptures;
    }
}
