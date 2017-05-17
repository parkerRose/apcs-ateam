import java.util.ArrayList;

public class W_Bishop extends Piece
{
    public W_Bishop(String a)
    {
        super(a);
    }
    
    public W_Bishop(int a, int b)
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
        
        return allPositions;
    }
    
    public ArrayList<String> getWPossibleCaptures(Piece[][] board)
    {
        ArrayList<String> allCaptures = new ArrayList<String>();
        int[] position = super.convertToChessInt(super.getPosition());
        
        boolean leaveLoop = false;
        int j = 0;
        for(int i = 1; i < 8; i++) {
            if((1 <= position[0] + i && position[0] + i <= 8) && (1 <= position[1] + i && position[1] + i <= 8) && (board[position[0] + i][position[1] + i] == null) && !leaveLoop) {
            } else {
                leaveLoop = true;
                j = i;
            }
        }
        
        if ((1 <= position[0] + j && position[0] + j <= 8) && (1 <= position[1] + j && position[1] + j <= 8) && isABlackPiece(board[position[0] + j][position[1] + j]))
            allCaptures.add(convertToString(position[0] + j, position[1] + j));
        
        
        
        leaveLoop = false;
        j = 0;
        for(int i = -1; i > -8; i--) {
            if((1 <= position[0] + i && position[0] + i <= 8) && (1 <= position[1] + i && position[1] + i <= 8) && (board[position[0] + i][position[1] + i] == null) && !leaveLoop) {
            } else {
                leaveLoop = true;
                j = i;
            }
        }
        
        if ((1 <= position[0] + j && position[0] + j <= 8) && (1 <= position[1] + j && position[1] + j <= 8) && isABlackPiece(board[position[0] + j][position[1] + j]))
            allCaptures.add(convertToString(position[0] + j, position[1] + j));
        
        
        
        
        leaveLoop = false;
        j = 0;
        for(int i = 1; i < 8; i++) {
            if((1 <= position[0] + i && position[0] + i <= 8) && (1 <= position[1] - i && position[1] - i <= 8) && (board[position[0] + i][position[1] - i] == null && !leaveLoop)) {
            } else {
                leaveLoop = true;
                j = i;
            }
        }
        
        if ((1 <= position[0] + j && position[0] + j <= 8) && (1 <= position[1] - j && position[1] - j <= 8) && isABlackPiece(board[position[0] + j][position[1] - j]))
            allCaptures.add(convertToString(position[0] + j, position[1] + j));
        
        
        
        leaveLoop = false;
        j = 0;
        for(int i = -1; i > -8; i--) {
            if((1 <= position[0] + i && position[0] + i <= 8) && (1 <= position[1] - i && position[1] - i <= 8) && (board[position[0] + i][position[1] - i] == null) && !leaveLoop) {
            } else {
                leaveLoop = true;
                j = i;
            }
        }
        
        if ((1 <= position[0] + j && position[0] + j <= 8) && (1 <= position[1] - j && position[1] - j <= 8) && isABlackPiece(board[position[0] + j][position[1] - j]))
            allCaptures.add(convertToString(position[0] + j, position[1] + j));
        
        return allCaptures;
    }
}