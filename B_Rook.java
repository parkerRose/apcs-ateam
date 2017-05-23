import java.util.ArrayList;

public class B_Rook extends Piece
{
    public B_Rook(String a)
    {
        super(a);
    }
    public B_Rook(int a, int b)
    {
        super(a, b);
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
        
        int j = 0;
        for(int i = position[1] + 1; i <= 8; i++) {
            if(board[position[0]][i] == null) {
            } else {
                j = i;
                break;
            }
        }
        
        if(j != 0 && isAWhitePiece(board[position[0]][j]))
            allCaptures.add(convertToString(position[0], j));
        
        
        
        j = 0;
        for(int i = position[1] - 1; i >= 1; i--) {
            if(board[position[0]][i] == null) {
            } else {
                j = i;
                break;
            }
        }
        
        if(j != 0 && isAWhitePiece(board[position[0]][j]))
            allCaptures.add(convertToString(position[0], j));
        
        
        
        j = 0;
        for(int i = position[0] + 1; i <= 8; i++) {
            if(board[i][position[1]] == null) {
            } else {
                j = i;
                break;
            }
        }
        
        if(j != 0 && isAWhitePiece(board[j][position[1]]))
            allCaptures.add(convertToString(j, position[1]));
        
        
        
        j = 0;
        for(int i = position[0] - 1; i >= 1; i--) {
            if(board[i][position[1]] == null) {
            } else {
                j = i;
                break;
            }
        }
        
        if(j != 0 && isAWhitePiece(board[j][position[1]]))
            allCaptures.add(convertToString(j, position[1]));
        
        return allCaptures;
    }
}