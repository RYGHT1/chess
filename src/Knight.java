import javax.swing.*;

public class Knight extends Piece{
    Knight(boolean white) {
        if (white) {
            icon = new ImageIcon("resources/white-knight.png");
        } else {
            icon = new ImageIcon("resources/black-knight.png");
        }
    }
}
