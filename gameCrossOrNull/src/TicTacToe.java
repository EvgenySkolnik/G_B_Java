import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static void start(){
        char[][] field = getEmptyField();

        drawField(field);

        while (true) {
            doPlayerMove(field);
            if (isWin(field, 'X')) {
                System.out.println("Congratulations!!! you are winner!!!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("This is draw. Try again.");
                break;
            }

            doAIMove(field);
            if (isWin(field, '0')) {
                System.out.println("Sorry!!! You are loser :(");
                break;
            }
            if (isDraw(field)) {
                System.out.println("This is draw. Try again.");
                break;
            }
        }
    }

    static boolean isDraw(char[][] field) {
        for (int h = 0; h < field.length; h++) {
            for (int v =0; v< field.length; v++) {
                if (isEmptyCell(field, h, v)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isWin(char[][] field, char sign) {
        
        // new logic commit
        // diagonal
        boolean toright, toleft;
        toright = true;
        toleft = true;
        for (int i=0; i< field.length; i++) {
            toright &= (field[i][i] == sign);
            toleft &= (field[field.length-i-1][i] == sign);
        }

        if (toright || toleft) return true;


        //horizont & vertical
        boolean cols, rows;
        for (int col = 0; col < field.length; col++) {
            cols = true;
            rows = true;
            for (int row = 0; row < field.length; row++) {
                cols &= (field[col][row] == sign);
                rows &= (field[row][col] == sign);
            }
            if (cols || rows) return true;
        }
        return false;
    }
 /*       // Horiz
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == sign && field[i][1] == sign && field[i][2] == sign) {
                return true;
            }
        }
        // Vert
        for (int i = 0; i < field.length; i++) {

            if (field[0][i] == sign && field[1][i] == sign && field[2][i] == sign) {
                return true;

            }
        }
        // Diagonal
            if (field[0][0] == sign && field[1][1] == sign && field[2][2] == sign) {
                return true;
            }
            else if (field[0][2] == sign && field[1][1] == sign && field[2][0] == sign) {
                return true;

        }
        return false;
    }
*/
    static void doAIMove(char[][] field) {
        Random random = new Random();
        int hor, ver;
        do {
            hor = random.nextInt(field.length);
            ver = random.nextInt(field.length);
        } while (isNotEmptyCell(field, hor, ver));

        System.out.println("Your opponent's(AI) move...");

        field [hor][ver] ='0';
        drawField(field);

    }

    static void doPlayerMove (char[][] field) {
        int hor, ver;
        do {
            System.out.println(" Your chance. Please enter coordinates..");
            hor = getCoordinate('H');
            ver = getCoordinate('V');
        } while ( isNotEmptyCell(field, hor, ver));

        field [hor] [ver] = 'X';
        drawField(field);
    }

    static boolean isEmptyCell(char[][] field, int hor, int ver) {
        return field[hor][ver] == '-';
    }
    static boolean isNotEmptyCell(char[][] field, int hor, int ver) {
        return !isEmptyCell(field, hor, ver);
    }

    static int getCoordinate (char position) {
        Scanner scanner = new Scanner(System.in);
        int coordinate;

        do {
            System.out.printf("please enter %s-coordinate [in range 1-3] ...%n", position);
            coordinate = scanner.nextInt() -1;
        } while (coordinate < 0 || coordinate >2);
        return coordinate;
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j< field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    static char[][] getEmptyField() {
        return new char[][] {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}

        };
    }
}
