import javax.swing.*;

public class King extends Piece{
    King(boolean white) {
        if (white) {
            icon = new ImageIcon("resources/white-king.png");
        } else {
            icon = new ImageIcon("resources/black-king.png");
        }
    }
}
