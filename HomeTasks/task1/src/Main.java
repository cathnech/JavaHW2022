import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    /*+Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
    Пример 1: а = 3, b = 2, ответ: 9
    Пример 2: а = 2, b = -2, ответ: 0.25
    Пример 3: а = 3, b = 0, ответ: 1
    Пример 4: а = 0, b = 0, ответ: не определено Пример 5
    входные данные находятся в файле input.txt в виде b3
    a 10
    Результат нужно сохранить в файле output.txt 1000*/
    public static void main(String[] args) throws IOException {
        int a = 3, b = 2;
//        int а = 2, b = -2;
//        int а = 3, b = 0;
//        int а = 0, b = 0;
        System.out.println(step(a, b));
        System.out.println(step(2, -2));
        System.out.println(step(3, 0));
        System.out.println(step(0, 0));

//        read
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String str;
        int a1 = 0,b1 = 0;
        while ((str = br.readLine()) != null) {
            String[] splitStr = str.split(" ");
            if (splitStr[0].equals("b"))
                b1 = Integer.parseInt(splitStr[1]);
            if (splitStr[0].equals("a"))
                a1 = Integer.parseInt(splitStr[1]);
        }
        br.close();

//        create and write

        try {
            FileWriter fw = new FileWriter("output.txt", false);
            fw.write(String.valueOf(step(a1,b1)));
            fw.append("\n");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    static double step(double a, int b) {
        double res = 1;
        int flag = 0;
        if (b < 0) {
            if (a==0)
                return Double.POSITIVE_INFINITY;
            b *= -1;
            flag = 1;
        } else if (b == 0) {
            res = a == 0 ? Double.NaN : 1; //return 1; because in math 0^0 = 1
            return res;
        }

        for (int i = 0;i<b;i++)
            res *=a;
        if (flag == 1)
            return 1/res;
        else
            return res;
    }
}
