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
        
        for(int i = -2; i <= 2; i++) {
            for(int j = -2; j <= 2; j++) {
                if((i!= 0 && j != 0) && (position[0] + i >= 1 && position[0] + i <= 8 && position[1] + j >= 1 && position[1] + j <= 8) && (board[position[0] + i][position[1] + j] == null))
            allPositions.add(convertToString(position[0] + i, position[1] + j));
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
        
        for(int i = -2; i <= 2; i++) {
            for(int j = -2; j <= 2; j++) {
                if((i!= 0 && j != 0) && (position[0] + i >= 1 && position[0] + i <= 8 && position[1] + j >= 1 && position[1] + j <= 8) && isABlackPiece(board[position[0] + i][position[1] + j]))
            allCaptures.add(convertToString(position[0] + i, position[1] + j));
            }
        }
        
        return allCaptures;
    }
}