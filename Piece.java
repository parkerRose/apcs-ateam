import java.util.ArrayList;

public abstract class Piece
    
{
    private String position;
    public enum Color {
        WHITE, BLACK
    }
    private Color side;
    public Piece(String a, Color c)
    {
        position = a;
        side = c;
    }
    
    public Piece(int a, int b, Color c)
    {
        position = convertToString(a, b);
        side = c;
    }
   
    public String getPosition()
    {
        return position;
    }
    public Color getColor (){
        return side;
    }
    public boolean isOppositeSide (Piece a, Piece b){
        boolean out = false;
        if(b.getColor() == BLACK && a.getColor() == WHITE){
            out = true;
        }
        if(b.getColor() == WHITE && a.getColor() == BLACK){
            out = true;
        }
        return out;
    }
    public void setNewPosition(int a, int b)
    {
        position = convertToString(a, b);
    }
    
    public boolean isAWhitePiece(Piece a)
    {
        return side == WHITE;
       
    }
    
    public boolean isABlackPiece(Piece a)
    {
        return side == BLACK;
    } 
    //public boolean isOppositeSide(
    
    public abstract ArrayList<String> getPossibleMoves(Piece[][] board);
    
    public abstract ArrayList<String> getPossibleCaptures(Piece[][] board);
    
    public static int[] convertToChessInt(String a)
    {
        if(a.length() == 2) {
            int[] pos = new int[2];
            String first = a.substring(0,1);
            char second = a.charAt(1);
            if(second == '1')
                pos[0] = 8;
            if(second == '2')
                pos[0] = 7;
            if(second == '3')
                pos[0] = 6;
            if(second == '4')
                pos[0] = 5;
            if(second == '5')
                pos[0] = 4;
            if(second == '6')
                pos[0] = 3;
            if(second == '7')
                pos[0] = 2;
            if(second == '8')
                pos[0] = 1;
            
            if(first.toUpperCase().equals("A"))
                pos[1] = 1;
            if(first.toUpperCase().equals("B"))
                pos[1] = 2;
            if(first.toUpperCase().equals("C"))
                pos[1] = 3;
            if(first.toUpperCase().equals("D"))
                pos[1] = 4;
            if(first.toUpperCase().equals("E"))
                pos[1] = 5;
            if(first.toUpperCase().equals("F"))
                pos[1] = 6;
            if(first.toUpperCase().equals("G"))
                pos[1] = 7;
            if(first.toUpperCase().equals("H"))
                pos[1] = 8;
            
            return pos;
        }
        
        return null;
    }
    
    public static String convertToString(int a, int b)
    {
        if((1 <= a && a <= 8) && (1 <= b && b <= 8))
        {
            String pos = "";
            if(b == 1)
                pos += "A";
            if(b == 2)
                pos += "B";
            if(b == 3)
                pos += "C";
            if(b == 4)
                pos += "D";
            if(b == 5)
                pos += "E";
            if(b == 6)
                pos += "F";
            if(b == 7)
                pos += "G";
            if(b == 8)
                pos += "H";
            
            pos += (9-a);
            
            return pos;
        }
        return null;
    }
    
    /*
     public static int[] convertToInt(String a)
     {
     if(a.length() == 2) {
     int[] pos = new int[2];
     String first = a.substring(0,1);
     char second = a.charAt(1);
     if(second == '1')
     pos[1] = 1;
     if(second == '2')
     pos[1] = 2;
     if(second == '3')
     pos[1] = 3;
     if(second == '4')
     pos[1] = 4;
     if(second == '5')
     pos[1] = 5;
     if(second == '6')
     pos[1] = 6;
     if(second == '7')
     pos[1] = 7;
     if(second == '8')
     pos[1] = 8;
     
     if(first.toUpperCase().equals("A"))
     pos[0] = 1;
     if(first.toUpperCase().equals("B"))
     pos[0] = 2;
     if(first.toUpperCase().equals("C"))
     pos[0] = 3;
     if(first.toUpperCase().equals("D"))
     pos[0] = 4;
     if(first.toUpperCase().equals("E"))
     pos[0] = 5;
     if(first.toUpperCase().equals("F"))
     pos[0] = 6;
     if(first.toUpperCase().equals("G"))
     pos[0] = 7;
     if(first.toUpperCase().equals("H"))
     pos[0] = 8;
     
     return pos;
     }
     
     return null;
     }
     
     public static String convertToString(int[] a)
     {
     if(a.length == 2)
     {
     String pos = "";
     if(a[0] == 1)
     pos += "A";
     if(a[0] == 2)
     pos += "B";
     if(a[0] == 3)
     pos += "C";
     if(a[0] == 4)
     pos += "D";
     if(a[0] == 5)
     pos += "E";
     if(a[0] == 6)
     pos += "F";
     if(a[0] == 7)
     pos += "G";
     if(a[0] == 8)
     pos += "H";
     
     pos += a[1];
     
     return pos;
     }
     return null;
     }
     */
}