import java.util.ArrayList;

public class B_Rook extends Piece
{
    public B_Rook(String a, Color c)
    {
        super(a, c);
    }
    public B_Rook(int a, int b, Color c)
    {
        super(a, b, c);
    }
    
    public ArrayList<String> getPossibleMoves(Piece[][] board)
    {
        ArrayList<String> allPositions = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        
        boolean leaveLoop = false;
        for(int i = position[1] + 1; i <= 8; i++) {
            if((board[position[0]][i] == null) && !leaveLoop)
                allPositions.add(convertToString(position[0], i));
            else
                leaveLoop = true;
        }
        
        leaveLoop = false;
        for(int i = position[1] - 1; i >= 1; i--) {
            if((board[position[0]][i] == null) && !leaveLoop)
                allPositions.add(convertToString(position[0], i));
            else
                leaveLoop = true;
        }
        
        leaveLoop = false;
        for(int i = position[0] + 1; i <= 8; i++) {
            if((board[i][position[1]] == null) && !leaveLoop)
                allPositions.add(convertToString(i, position[1]));
            else
                leaveLoop = true;
        }
        
        leaveLoop = false;
        for(int i = position[0] - 1; i >= 1; i--) {
            if((board[i][position[1]] == null) && !leaveLoop)
                allPositions.add(convertToString(i, position[1]));
            else
                leaveLoop = true;
        }
        
        return allPositions;
    }
    
    public ArrayList<String> getPossibleCaptures(Piece[][] board)
    {
        ArrayList<String> allCaptures = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        
        boolean leaveLoop = false;
        int j = 0;
        for(int i = position[1] + 1; i <= 8; i++) {
            if((board[position[0]][i] == null) && !leaveLoop) {
            } else {
                leaveLoop = true;
                j = i;
            }
        }
        
        if(j != 0 && isAWhitePiece(board[position[0]][j]))
            allCaptures.add(convertToString(position[0], j));
        
        
        
        leaveLoop = false;
        j = 0;
        for(int i = position[1] - 1; i >= 1; i--) {
            if((board[position[0]][i] == null) && !leaveLoop) {
            } else {
                leaveLoop = true;
                j = i;
            }
        }
        
        if(j != 0 && isAWhitePiece(board[position[0]][j]))
            allCaptures.add(convertToString(position[0], j));
        
        
        
        leaveLoop = false;
        j = 0;
        for(int i = position[0] + 1; i <= 8; i++) {
            if((board[i][position[1]] == null) && !leaveLoop) {
            } else {
                leaveLoop = true;
                j = i;
            }
        }
        
        if(j != 0 && isABlackPiece(board[j][position[1]]))
            allCaptures.add(convertToString(j, position[1]));
        
        
        
        leaveLoop = false;
        j = 0;
        for(int i = position[0] - 1; i >= 1; i--) {
            if((board[i][position[1]] == null) && !leaveLoop) {
            } else {
                leaveLoop = true;
                j = i;
            }
        }
        
        if(j != 0 && isABlackPiece(board[j][position[1]]))
            allCaptures.add(convertToString(j, position[1]));
        
        return allCaptures;
    }
}