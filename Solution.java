package lab3;

import java.io.*;
import java.util.*;

/*. Написать программу копирования файла. В выходном файле содержатся только те предложения,
в которых было найдено слово, введенное с клавиатуры.
Чтение происходит блоками. Обработать ошибки.*/
public class Solution {
    public static void main(String[] args)
    {
        try {
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
            String word = sc.readLine();

            File file = new File("c:\\Users\\Owlet\\Downloads\\cod1.txt");
            File file1 = new File ("c:\\Users\\Owlet\\Downloads\\cod.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            OutputStream out = new FileOutputStream(file1);

            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                char[] temp = line.toCharArray();
                if (line.contains(word))
                {
                    for (Character i: temp)
                    out.write(i);
                    out.write('\n');
                }
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
