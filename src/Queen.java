import javax.swing.*;

public class Queen extends Piece{
    Queen(boolean white) {
        if (white) {
            icon = new ImageIcon("resources/white-queen.png");
        } else {
            icon = new ImageIcon("resources/black-queen.png");
        }
    }
}
