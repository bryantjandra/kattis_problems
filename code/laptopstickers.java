
import java.util.*;
import java.io.*;

class laptopstickers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        int L = Integer.parseInt(tokens[0]);
        int H = Integer.parseInt(tokens[1]);
        char[][] laptop = new char[H][L];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < L; j++) {
                laptop[i][j] = '_';
            }
        }
        int K = Integer.parseInt(tokens[2]);
        for (int i = 0; i < K; i++) {
            tokens = br.readLine().split(" ");
            int l = Integer.parseInt(tokens[0]);
            int h = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);
            int row = Integer.parseInt(tokens[3]);
            for (int j = row; j < row + h; j++) {
                if (j >= H) {
                    break;
                }
                for (int x = col; x < col + l; x++) {
                    if (x >= L) {
                        break;
                    }
                    laptop[j][x] = (char) ('a' + i);
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < L; j++) {
                pw.print(laptop[i][j]);
            }
            pw.println();
        }
        pw.close();
    }
}

// 1st sticker = a's, 2nd sticker = b's