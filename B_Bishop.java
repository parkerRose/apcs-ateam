import java.util.ArrayList;

public class B_Bishop extends Piece 
{
    public B_Bishop(String a)
    {
        super(a);
    }
    
    public B_Bishop(int a, int b)
    {
        super(a, b);
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
        for(int i = 1; i < 8; i++) {
            if((1 <= position[0] + i && position[0] + i <= 8) && (1 <= position[1] + i && position[1] + i <= 8) && board[position[0] + i][position[1] + i] == null) {
            } else {
                j = i;
                break;
            }
        }
        
        if ((1 <= position[0] + j && position[0] + j <= 8) && (1 <= position[1] + j && position[1] + j <= 8) && isAWhitePiece(board[position[0] + j][position[1] + j]))
            allCaptures.add(convertToString(position[0] + j, position[1] + j));
        
        
        
        j = 0;
        for(int i = -1; i > -8; i--) {
            if((1 <= position[0] + i && position[0] + i <= 8) && (1 <= position[1] + i && position[1] + i <= 8) && board[position[0] + i][position[1] + i] == null) {
            } else {
                j = i;
                break;
            }
        }
        
        if ((1 <= position[0] + j && position[0] + j <= 8) && (1 <= position[1] + j && position[1] + j <= 8) && isAWhitePiece(board[position[0] + j][position[1] + j]))
            allCaptures.add(convertToString(position[0] + j, position[1] + j));
        
        
        
        
        j = 0;
        for(int i = 1; i < 8; i++) {
            if((1 <= position[0] + i && position[0] + i <= 8) && (1 <= position[1] - i && position[1] - i <= 8) && board[position[0] + i][position[1] - i] == null) {
            } else {
                j = i;
                break;
            }
        }
        
        if ((1 <= position[0] + j && position[0] + j <= 8) && (1 <= position[1] - j && position[1] - j <= 8) && isAWhitePiece(board[position[0] + j][position[1] - j])) {
            allCaptures.add(convertToString(position[0] + j, position[1] - j));
        }
        
        
        j = 0;
        for(int i = -1; i > -8; i--) {
            if((1 <= position[0] + i && position[0] + i <= 8) && (1 <= position[1] - i && position[1] - i <= 8) && board[position[0] + i][position[1] - i] == null) {
            } else {
                j = i;
                break;
            }
        }
        
        if ((1 <= position[0] + j && position[0] + j <= 8) && (1 <= position[1] - j && position[1] - j <= 8) && isAWhitePiece(board[position[0] + j][position[1] - j]))
            allCaptures.add(convertToString(position[0] + j, position[1] - j));
        
        return allCaptures;
    }
}
