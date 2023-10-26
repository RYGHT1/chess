import javax.swing.*;

public class Bishop extends Piece{
    Bishop(boolean white) {
        if (white) {
            icon = new ImageIcon("resources/white-bishop.png");
        } else {
            icon = new ImageIcon("resources/black-bishop.png");
        }
    }
}
