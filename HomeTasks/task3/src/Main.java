public class Main {
    /*+Написать программу вычисления n-ого треугольного числа.*/
    public static void main(String[] args) {
        int n = 2;
        int t = ((n * (n + 1)) / 2);
        System.out.printf("Tn = %d, n = %d\n", t, n);
        System.out.print(drawT("", t, n));
    }

    static String drawT(String str, int num, int n) {
        if (num == 1)
            return "1\n";
        str = num + "\t";
        if (((n * (n + 1)) / 2) == num) {
            n--;
            str += "\n";
        }
        return drawT(str, --num, n) + str;
    }
}

