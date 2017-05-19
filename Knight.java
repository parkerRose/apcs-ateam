import java.util.ArrayList;
public class Knight extends Piece{
      public Knight(String a, Color c)
    {
        super(a, c);
    }
    
    public Knight(int a, int b, Color c)
    {
        super(a, b, c);
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
        
        if((position[0] <= 6 && position[1] <= 7) && isOppositeSide(board[position[0] + 2][position[1] + 1],this))
            allCaptures.add(convertToString(position[0] + 2, position[1] + 1));
        if((position[0] <= 7 && position[1] <= 6) && isOppositeSide(board[position[0] + 1][position[1] + 2],this))
            allCaptures.add(convertToString(position[0] + 1, position[1] + 2));
        if((position[0] >= 3 && position[1] >= 2) && isOppositeSide(board[position[0] - 2][position[1] - 1],this))
            allCaptures.add(convertToString(position[0] - 2, position[1] - 1));
        if((position[0] >= 2 && position[1] >= 3) && isOppositeSide(board[position[0] - 1][position[1] - 2],this))
            allCaptures.add(convertToString(position[0] - 1, position[1] - 2));
        if((position[0] <= 6 && position[1] >= 2) && isOppositeSide(board[position[0] + 2][position[1] - 1],this))
            allCaptures.add(convertToString(position[0] + 2, position[1] - 1));
        if((position[0] <= 7 && position[1] >= 3) && isOppositeSide(board[position[0] + 1][position[1] - 2],this))
            allCaptures.add(convertToString(position[0] + 1, position[1] - 2));
        if((position[0] >= 3 && position[1] <= 7) && isOppositeSide(board[position[0] - 2][position[1] + 1],this))
            allCaptures.add(convertToString(position[0] - 2, position[1] + 1));
        if((position[0] >= 2 && position[1] <= 6) && isOppositeSide(board[position[0] - 1][position[1] + 2],this))
            allCaptures.add(convertToString(position[0] - 1, position[1] + 2));
        
        return allCaptures;
    }
}
  