import java.util.*;
public class Bishop extends Piece{
    public Bishop(String a, Color side)
    {
        super(a, side);
    }
    
    public Bishop(int a, int b, Color side)
    {
        super(a, b, side);
    }
    public ArrayList<String> getPossibleMoves(Piece[][] board)
    {
        ArrayList<String> allPositions = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        
        boolean leaveLoop = false;
        for(int i = 1; i < 8; i++) {
            if((1 <= position[0] + i && position[0] + i <= 8) && (1 <= position[1] + i && position[1] + i <= 8) && (board[position[0] + i][position[1] + i] == null) && !leaveLoop)
                allPositions.add(convertToString(position[0] + i, position[1] + i));
            else
                leaveLoop = true;
        }
        
        leaveLoop = false;
        for(int i = -1; i > -8; i--) {
            if((1 <= position[0] + i && position[0] + i <= 8) && (1 <= position[1] + i && position[1] + i <= 8) && (board[position[0] + i][position[1] + i] == null) && !leaveLoop)
                allPositions.add(convertToString(position[0] + i, position[1] + i));
            else
                leaveLoop = true;
        }
        
        leaveLoop = false;
        for(int i = 1; i < 8; i++) {
            if((1 <= position[0] + i && position[0] + i <= 8) && (1 <= position[1] - i && position[1] - i <= 8) && (board[position[0] + i][position[1] - i] == null && !leaveLoop))
                allPositions.add(convertToString(position[0] + i, position[1] - i));
            else
                leaveLoop = true;
        }
        
        leaveLoop = false;
        for(int i = -1; i > -8; i--) {
            if((1 <= position[0] + i && position[0] + i <= 8) && (1 <= position[1] - i && position[1] - i <= 8) && (board[position[0] + i][position[1] - i] == null) && !leaveLoop)
                allPositions.add(convertToString(position[0] + i, position[1] - i));
            else
                leaveLoop = true;
        }
        
        return allPositions;
    }
    public ArrayList<String> getPossibleCaptures(Piece[][] board)
    {
       
    }  
}