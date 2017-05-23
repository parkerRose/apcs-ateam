import java.util.ArrayList;

public class B_Pawn extends Piece
{
    public B_Pawn(String a)
    {
        super(a);
    }
    
    public B_Pawn(int a, int b)
    {
        super(a, b);
    }
    
    public ArrayList<String> getPossibleMoves(Piece[][] board)
    {
        ArrayList<String> allPositions = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        
        if(position[0] == 2 && board[position[0] + 1][position[1]] == null && board[position[0] + 2][position[1]] == null) {
            allPositions.add(convertToString(position[0] + 2, position[1]));
        }
        
        if(position[0] <= 6 && board[position[0] + 1][position[1]] == null)
            allPositions.add(convertToString(position[0] + 1, position[1]));
        
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
        
        if(position[0] <= 6 && position[1] <= 7 && isAWhitePiece(board[position[0] + 1][position[1] + 1])) {
            allCaptures.add(convertToString(position[0] + 1, position[1] + 1));
        }
        
        if(position[0] <= 6 && position[1] >= 2 && isAWhitePiece(board[position[0] + 1][position[1] - 1])) {
            allCaptures.add(convertToString(position[0] + 1, position[1] - 1));
        }
        
        return allCaptures;
    }
    
    public ArrayList<String> getSpecialPossibleCaptures(Piece[][] board)
    {
        ArrayList<String> allSpecialCaptures = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        
        if(position[0] <= 7 && position[1] <= 7) {
            allSpecialCaptures.add(convertToString(position[0] + 1, position[1] + 1));
        }
        
        if(position[0] <= 7 && position[1] >= 2) {
            allSpecialCaptures.add(convertToString(position[0] + 1, position[1] - 1));
        }
        
        return allSpecialCaptures;
    }
}