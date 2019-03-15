package lab1;

import java.util.*;



public class ParamList<T> extends Solution{
    T str;

    public ParamList(){}

    public ParamList(T o)
    {
        str = o;
    }

    public static void main(String[] args)
    {
        ParamList<Integer> g = new ParamList<>(77);
        ParamList<String> g1 = new ParamList<>("value");
        ParamList<Integer> g2 = new ParamList<>(12);
        ParamList<String> g3 = new ParamList<>("cat");
        ParamList<String> g4 = new ParamList<>("dog");
        ParamList<String> g5 = new ParamList<>("flower");
        ParamList<String> g6 = new ParamList<>("file");
        ParamList<Integer> g7 = new ParamList<>(162);
        ParamList<Integer> g8 = new ParamList<>(124);
        ParamList<Integer> g9 = new ParamList<>(212);


        ArrayList<ParamList> arr = new ArrayList<>();
        Collections.addAll(arr, g,g1,g2,g3,g4,g5,g6,g7,g8,g9);

        print(arr, 0);
        avg(arr);
        print(arr, 1);
        int rey = gotKey();
        delKey(arr, rey);
        print(arr, 2);
        refresh(arr);


    }

    public static void print(List<ParamList> arr, int x)
    {
        System.out.println("\nTask"+x);
        for (ParamList a: arr)
            System.out.println(a);
    }

    public static ArrayList<ParamList> avg(ArrayList<ParamList> arr)
    {
        int sum = 0;
        int count = 0;
        for (ParamList a: arr)
        {
            String z = a.toString();
            char[] how = z.toCharArray();
            sum+=how.length;
            count++;
        }

        arr.add(0,new ParamList<>((double) sum/count));
        System.out.println("Количество символов: "+sum+", количество объектов: "+count);
        return arr;
    }

    public static ArrayList<ParamList> delKey(ArrayList<ParamList> arr, int key)
    {
        System.out.println(arr.get(key)+" removed");
        arr.remove(key);
        return arr;
    }

    public static ArrayList<ParamList> refresh(ArrayList<ParamList> arr)
    {
        ArrayList<Integer> count = new ArrayList<>();
        for (ParamList a: arr)
             {
                 String z = a.toString();
                 char[] how = z.toCharArray();
                 count.add(how.length);
             }
        ArrayList<ParamList> arr1 = new ArrayList<>();
        int min = Collections.min(count);
        System.out.println("Minimum is "+min);
        for (ParamList a: arr)
        {
            String z = a.toString();
            char[] howto = z.toCharArray();
            char[] how = new char[howto.length-min];
            for (int i = 0; i<how.length;i++)
                how[i] = howto[i];
            String k = new String(how);
            arr1.add(new ParamList<>(k));
        }
        print(arr1, 3);
        return arr1;
    }

    @Override
    public String toString() {
       if ((this.str instanceof Integer)||(this.str instanceof Double)) return String.valueOf(str);

       return (String) str;
    }
}
