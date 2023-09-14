import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int min37 = 1000;
        int max73 = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("pos.txt"))){
            String line;
            while((line = bufferedReader.readLine()) != null){
                int num = Integer.parseInt(line);
                list.add(num);
                if(num % 37 == 0 && num < min37){
                    min37 = num;
                }
                if (num % 73 == 0 && num > max73) {
                    max73 = num;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int count = 0;
        int minSum = 1000000;
        for (int i = 0; i < list.size() - 1; i++) {
            if ((list.get(i) == min37 && list.get(i+1) != max73) || (list.get(i) != min37 && list.get(i+1) == max73)) {
                count++;
                int sum = list.get(i) + list.get(i+1);
                if (sum < minSum) {
                    minSum = sum;
                }
            }
        }
        System.out.println(list);
        System.out.println("Количество пар: " + count);
        System.out.println("Минимальная сумма: " + minSum);
    }
}
