import java.util.Scanner;

public class Main {
/*+На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
- команда 1 (к1): увеличить в с раза, а умножается на c
- команда 2 (к2): увеличить на d ( +2 ), к a прибавляется d
написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b или сообщить, что это невозможно
Пример 1: а = 1, b = 7, c = 2, d = 1
ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1.
Пример 2: а = 11, b = 7, c = 2, d = 1
ответ: нет решения.
*Подумать над тем, как сделать минимальное количество команд*/


    public static class constants {
        public static int c = 2, d = 6;
        public static String mistake = " нет решения";
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("int a: ");
        int a = iScanner.nextInt();
        System.out.printf("int b: ");
        int b = iScanner.nextInt();

        if ((a >= b) || ((b - a) < constants.d))
            System.out.println(constants.mistake);
        else
            System.out.println(bestWayForResult(a, b, ""));
    }

    //функция, которая выдаёт набор команд, позволяющий число a превратить в число b
    static String bestWayForResult(int a, int b, String res) {
        if (a == b) {
            return String.valueOf(a);
        }

        if ((b % constants.c == 0) && (a <= b / constants.c)) {
            res += bestWayForResult(a, (b / constants.c), res);
            if (res == constants.mistake) return constants.mistake;
            return res + "*" + constants.c + "(cmd1)";
        } else if (a <= b - constants.d) {
            res += bestWayForResult(a, (b - constants.d), res);
            if (res == constants.mistake) return constants.mistake;
            return res + "+" + constants.d + "(cmd2)";
        } else {
            return constants.mistake;
        }
    }
}

