import javax.swing.*;

public class Main {
    public static final int SIZE = 1000;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new ChessBoard());
        frame.setSize(SIZE,SIZE);
        frame.setLocation(920,40);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}