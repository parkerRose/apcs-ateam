import java.util.ArrayList;

public class W_Knight extends Piece
{
    public W_Knight(String a)
    {
        super(a);
    }
    
    public W_Knight(int a, int b)
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
        
        if((position[0] <= 6 && position[1] <= 7) && isABlackPiece(board[position[0] + 2][position[1] + 1]))
            allCaptures.add(convertToString(position[0] + 2, position[1] + 1));
        if((position[0] <= 7 && position[1] <= 6) && isABlackPiece(board[position[0] + 1][position[1] + 2]))
            allCaptures.add(convertToString(position[0] + 1, position[1] + 2));
        if((position[0] >= 3 && position[1] >= 2) && isABlackPiece(board[position[0] - 2][position[1] - 1]))
            allCaptures.add(convertToString(position[0] - 2, position[1] - 1));
        if((position[0] >= 2 && position[1] >= 3) && isABlackPiece(board[position[0] - 1][position[1] - 2]))
            allCaptures.add(convertToString(position[0] - 1, position[1] - 2));
        if((position[0] <= 6 && position[1] >= 2) && isABlackPiece(board[position[0] + 2][position[1] - 1]))
            allCaptures.add(convertToString(position[0] + 2, position[1] - 1));
        if((position[0] <= 7 && position[1] >= 3) && isABlackPiece(board[position[0] + 1][position[1] - 2]))
            allCaptures.add(convertToString(position[0] + 1, position[1] - 2));
        if((position[0] >= 3 && position[1] <= 7) && isABlackPiece(board[position[0] - 2][position[1] + 1]))
            allCaptures.add(convertToString(position[0] - 2, position[1] + 1));
        if((position[0] >= 2 && position[1] <= 6) && isABlackPiece(board[position[0] - 1][position[1] + 2]))
            allCaptures.add(convertToString(position[0] - 1, position[1] + 2));
        
        return allCaptures;
    }
}