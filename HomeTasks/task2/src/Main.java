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
        public static int c = 1; // команда 1 (к1): увеличить в с раза, а умножается на c
        public static int d = 2; // команда 2 (к2): увеличить на d , к a прибавляется d
        //        public static int c = 5, d = 3;
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
        else {
            System.out.println(bestWayForResult(a, b, ""));
            System.out.println("Count of ways is " + allWays(a, b));
        }
    }

    //функция, которая выдаёт набор команд, позволяющий число a превратить в число b
    static String bestWayForResult(int a, int b, String res) {
        if (a == b)
            return String.valueOf(a);

        if ((b % constants.c == 0) && (a <= b / constants.c) && (constants.c != 1)) {
            res += bestWayForResult(a, (b / constants.c), res);
            if (res.contentEquals(constants.mistake))
                return constants.mistake;
            else
                return res + "*" + constants.c + "(cmd1)";
        } else if (a <= b - constants.d) {
            res += bestWayForResult(a, (b - constants.d), res);
            if (res.contentEquals(constants.mistake))
                return constants.mistake;
            else
                return res + "+" + constants.d + "(cmd2)";
        } else
            return constants.mistake;
    }

    //функция, которая выдаёт возможное количество путей, позволяющих число a превратить в число b
    static int allWays(int a, int b) {
        if (a == b)
            return 1;
        if ((b % constants.c == 0) && (constants.c != 1))
            return allWays(a, b / constants.c) + allWays(a, b - constants.d);
        if (a <= b - constants.d)
            return allWays(a, b - constants.d);
        else
            return 0;
    }
}