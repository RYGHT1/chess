import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JPanel implements KeyListener, MouseMotionListener, MouseListener {
    Color black_square = new Color(0xB3CFE0);
    Color white_square = new Color(0x5A73A9);
    Piece[][] piece_map; //R, N, B, K, Q, P
    Graphics2D g2d;
    private boolean white_bottom = true;
    private static int square_size;
    Piece dragged;
    Point piece_loc = new Point();

    ChessBoard() {
        this.setFocusable(true);
        requestFocusInWindow();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        piece_map = Fen.getMap(Fen.getPuzzleFend());
        square_size = Main.SIZE / 8;
    }

    @Override
    public void paintComponent(Graphics g) {
        drawBoard(g);
        drawPieces();
    }

    private void drawBoard(Graphics g) {
        int n = 0;
        if (!white_bottom)
            n++;
        g2d = (Graphics2D) g;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if ((x + y + n) % 2 == 0) {
                    g2d.setColor(white_square);
                } else
                    g2d.setColor(black_square);
                g2d.fillRect(square_size * x, square_size * y, square_size * (x + 1), square_size * (y + 1));
            }
        }
    }

    private void drawPieces() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (dragging && piece_map[y][x] == dragged) {
                    g2d.drawImage(dragged.icon.getImage(), piece_loc.x, piece_loc.y, square_size, square_size, null);
                }
                if (piece_map[y][x] != null && piece_map[y][x].visible && piece_map[y][x].icon != null && piece_map[y][x] != dragged) {
                    g2d.drawImage(piece_map[y][x].icon.getImage(), square_size * x, square_size * y, square_size, square_size, null);
                }

            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            flipMap();
            white_bottom = !white_bottom;
            repaint();
        }
    }

    private void flipMap() {
        Piece[][] foo = new Piece[8][8];
        for (int i = 0; i < piece_map.length; i++) {
            for (int j = 0; j < piece_map[0].length; j++) {
                foo[7 - j][7 - i] = piece_map[j][i];
            }
        }
        piece_map = foo;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    Point mouse_start;
    boolean dragging = false;

    @Override
    public void mousePressed(MouseEvent e) {
        mouse_start = e.getPoint();
        piece_loc.x = e.getX() - mouse_start.x % square_size;
        piece_loc.y = e.getY() - mouse_start.y % square_size;
        dragged = piece_map[mouse_start.y / square_size][mouse_start.x / square_size];
        if (dragged != null) {
            dragging = true;
            dragged.visible = false;
            repaint();
        }

//        piece_starting_grid_x = e.getX() / square_size;
//        piece_starting_grid_y = e.getY() / square_size;
//        dragged = piece_map[piece_starting_grid_y][piece_starting_grid_x];
//        if (dragged != null) {
//            click_x = (e.getX() % square_size);
//            click_y = (e.getY() % square_size);
//            piece_x = e.getX() - click_x;
//            piece_y = e.getY() - click_y;
//            dragged.visible = false;
//            repaint();
//        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        dragging = false;
        dragged.visible = true;
        int new_grid_x = e.getX() / square_size;
        int new_grid_y = e.getY() / square_size;
        if (new_grid_x >= 0 && new_grid_x < 8 && new_grid_y >= 0 && new_grid_y < 8) {
            piece_map[new_grid_y][new_grid_x] = dragged;
            dragged = new Piece();
            piece_map[mouse_start.y / square_size][mouse_start.x / square_size] = new Piece();
        }
        repaint();
        //TODO handle case where new location == old location (piece disappears)


//        if (dragged != null) {
//            dragged.visible = true;
//            int new_grid_x = piece_x / square_size;
//            int new_grid_y = piece_y / square_size;
//            if (new_grid_x >= 0 && new_grid_x < 8 && new_grid_y >= 0 && new_grid_y < 8) {
//                piece_map[new_grid_y][new_grid_x] = dragged;
//                dragged = new Piece();
//                piece_map[piece_starting_grid_y][piece_starting_grid_x] = new Piece();
//            }
//        }
//        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseDragged(MouseEvent e) {
        if (dragged != null) {
            piece_loc.setLocation(e.getX() - (mouse_start.x % square_size), e.getY() - (mouse_start.y % square_size));
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}