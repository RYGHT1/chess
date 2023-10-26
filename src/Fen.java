import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Fen {
    public static final String STARTING_POS = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    static final String fenFilePath = "resources/FenPuzzles";

    public static Piece[][] getMap(String fen) {
        try {
            String boardAttr = fen.substring(fen.indexOf(' '), fen.length() - 1);
        } finally {

            int row = 0;
            Piece[][] map = new Piece[8][8];
            for (String s : fen.split("/", 8)) {
                int offset = 0;
                for (int i = 0; i < s.length() && i < 8; i++) {
                    if (Character.isDigit(s.charAt(i))) {
                        offset += (s.charAt(i) - '1');
                    } else
                        map[row][i + offset] = Piece.getPiece(s.charAt(i));
                }
                row++;
            }
            return map;
        }
    }

    public static String getPuzzleFend() {
        String line = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fenFilePath));
            Random random = new Random();
            int lineNumber = random.nextInt(96);
            for (int i = 0; i < lineNumber; i++) {
                line = reader.readLine();
                if (line == null) {
                    reader.close();
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }
}
