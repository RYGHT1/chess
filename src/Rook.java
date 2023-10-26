import javax.swing.*;

public class Rook extends Piece{
    Rook(boolean white) {
        if (white) {
            icon = new ImageIcon("resources/white-rook.png");
        } else {
            icon = new ImageIcon("resources/black-rook.png");
        }
    }
}
