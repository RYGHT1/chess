import javax.swing.*;
import java.awt.*;

public class Pawn extends Piece{
    Pawn(boolean white) {
        if (white) {
            icon = new ImageIcon("resources/white-pawn.png");
        } else {
            icon = new ImageIcon("resources/black-pawn.png");
        }
    }
}
