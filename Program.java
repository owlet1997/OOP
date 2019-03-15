package lab1;

import java.util.*;

public class Program extends Solution {
    public static void main(String[] args)
    {
        Deque<Float> vec = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        p("Введите количество элементов");
        int n = sc.nextInt();
        for (int i=0; i<n; i++)
        {
            p("Введите элемент " + (i+1));
            vec.offer(sc.nextFloat());
        }
        print(vec, 0);
        avg(vec,n);
        print(vec, 1);

        int key = gotKey();
        delKey(vec, key);
        print(vec, 2);
        refresh(vec);
        print(vec,3);
    }

    public static Deque<Float> refresh(Deque<Float> arr)
    {
        float min = Collections.min(arr);
        p("Minimum is "+min);
        ArrayList<Float> list = arrayIt(arr);

        for (int i=0; i<list.size(); i++)
        {
            arr.offerLast(list.get(i)-min);
        }
        return arr;
    }

    public static void print(Deque<Float> arr, int x)
    {
        p("Task "+x);
        Iterator<Float> it = arr.iterator();
        while (it.hasNext()) {
            Float s = it.next();
            p(s);
        }
    }
    public static void p(Object o)
    {
        System.out.println(o.toString());
    }

    public static Deque<Float> avg(Deque<Float> arr, int n)
    {
        float sum = 0;

        Iterator<Float> it = arr.iterator();
        while (it.hasNext()) {
            sum+= it.next();
        }
        arr.push(sum/n);
        return arr;
    }

    public static ArrayList<Float> arrayIt(Deque<Float> arr)
    {
        ArrayList<Float> list = new ArrayList<>();

        Iterator<Float> it = arr.iterator();
        while (it.hasNext()) {
            list.add(it.next());
            it.remove();
        }
        return list;
    }

    public static Deque<Float> delKey(Deque<Float> arr, int n)
    {
        ArrayList<Float> list = arrayIt(arr);
        list.remove(n);
        for (int i=0; i<list.size(); i++)
        {
            arr.offerLast(list.get(i));
        }
        return arr;
    }
}
