import java.util.ArrayList;

public class W_Pawn extends Piece
{
    public W_Pawn(String a)
    {
        super(a);
    }
    
    public W_Pawn(int a, int b)
    {
        super(a, b);
    }
    
    public ArrayList<String> getPossibleMoves(Piece[][] board)
    {
        ArrayList<String> allPositions = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        
        if(position[0] == 7 && board[position[0] - 1][position[1]] == null && board[position[0] - 2][position[1]] == null) {
            allPositions.add(convertToString(position[0] - 2, position[1]));
        }
        
        if(position[0] >= 3 && board[position[0] - 1][position[1]] == null)
            allPositions.add(convertToString(position[0] - 1, position[1]));
        
        return allPositions;
    }
    
    public ArrayList<String> getPossibleCaptures(Piece[][] board)
    {
        ArrayList<String> allCaptures = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        
        if(position[0] >= 3 && isABlackPiece(board[position[0] - 1][position[1] + 1])) {
            allCaptures.add(convertToString(position[0] - 1, position[1] + 1));
        }
        
        if(position[0] >= 3 && isABlackPiece(board[position[0] - 1][position[1] - 1])) {
            allCaptures.add(convertToString(position[0] - 1, position[1] - 1));
        }
        
        return allCaptures;
    }
}