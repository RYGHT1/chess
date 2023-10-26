import javax.swing.*;
import java.awt.*;

public class Piece {
    boolean white;
    public ImageIcon icon;
    boolean visible = true;
    private void move(int x, int y) {
    }
    public static Piece getPiece(char ch) {
        boolean white = Character.isUpperCase(ch);
        char lowercaseCh = Character.toLowerCase(ch);
        return switch (lowercaseCh) {
            case 'k' -> new King(white);
            case 'q' -> new Queen(white);
            case 'r' -> new Rook(white);
            case 'b' -> new Bishop(white);
            case 'n' -> new Knight(white);
            case 'p' -> new Pawn(white);
            default -> throw new IllegalStateException("Unexpected value: " + lowercaseCh);
        };
    }
}