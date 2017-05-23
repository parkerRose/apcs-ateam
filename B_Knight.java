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
        
        int j;
        for(int i = -2; i <= 2; i++) {
            j = 3 - Math.abs(i);
            if(i!= 0 && (position[0] + i >= 1 && position[0] + i <= 8 && position[1] + j >= 1 && position[1] + j <= 8) && (board[position[0] + i][position[1] + j] == null))
                allPositions.add(convertToString(position[0] + i, position[1] + j));
            j = -j;
            if(i!= 0 && (position[0] + i >= 1 && position[0] + i <= 8 && position[1] + j >= 1 && position[1] + j <= 8) && (board[position[0] + i][position[1] + j] == null))
                allPositions.add(convertToString(position[0] + i, position[1] + j));
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
        
        int j;
        for(int i = -2; i <= 2; i++) {
            j = 3 - Math.abs(i);
            if(i!= 0 && (position[0] + i >= 1 && position[0] + i <= 8 && position[1] + j >= 1 && position[1] + j <= 8) && isAWhitePiece(board[position[0] + i][position[1] + j]))
                allCaptures.add(convertToString(position[0] + i, position[1] + j));
            j = -j;
            if(i!= 0 && (position[0] + i >= 1 && position[0] + i <= 8 && position[1] + j >= 1 && position[1] + j <= 8) && isAWhitePiece(board[position[0] + i][position[1] + j]))
                allCaptures.add(convertToString(position[0] + i, position[1] + j));
        }
        
        return allCaptures;
    }
}