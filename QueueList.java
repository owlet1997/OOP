package lab1;

import java.util.*;

public class QueueList extends ParamList {

    public static void main(String[] args)
    {
        Deque<ParamList> list = new LinkedList<>();
        list.push(new ParamList<>(32));
        list.push(new ParamList<>("catherine"));
        list.push(new ParamList<>(45));
        list.push(new ParamList<>("cathere"));
        list.push(new ParamList<>(38));
        list.push(new ParamList<>(39));
        list.push(new ParamList<>("carine"));
        list.push(new ParamList<>(352));
        list.push(new ParamList<>("caterine"));
        list.push(new ParamList<>(302));
        list.push(new ParamList<>("cathrine"));
        list.push(new ParamList<>(320));
        print(list,1);
        avg(list);
        print(list,2);
      Scanner sc = new Scanner(System.in);
        int rey = sc.nextInt();
        delKey(list, rey);
        print(list,3);
        refresh(list);

    }

    public static Deque<ParamList> refresh(Deque<ParamList> arr)
    {
        ArrayList<Integer> count = new ArrayList<>();
        Iterator<ParamList> it = arr.iterator();
        while (it.hasNext()) {
            String z = it.next().toString();
            char[] how = z.toCharArray();
            p(how.length);
            count.add(how.length);
        }
        int min = Collections.min(count);
        p("Minimum is "+min);
        Deque<ParamList> arr1 = new LinkedList<>();
        Iterator<ParamList> it1 = arr.iterator();
        while (it1.hasNext()) {
            String z = it1.next().toString();
            char[] how = z.toCharArray();
            char[] how2 = new char[how.length-min];
            for (int i = 0; i<how2.length;i++) {
                how2[i] = how[i];
            }
            String k = new String(how2);
            arr1.offerLast(new ParamList<>(k));
        }
        print(arr1, 4);
        return arr1;
    }

    public static Deque<ParamList> delKey(Deque<ParamList> arr, int n)
    {
        ArrayList<ParamList> list = arrayIt(arr);
        list.remove(n);
        for (int i=0; i<list.size(); i++)
        {
            arr.offerLast(list.get(i));
        }
        return arr;
    }

    public static ArrayList<ParamList> arrayIt(Deque<ParamList> arr)
    {
        ArrayList<ParamList> list = new ArrayList<>();

        Iterator<ParamList> it = arr.iterator();
        while (it.hasNext()) {
            list.add(it.next());
            it.remove();
        }
        return list;
    }
    public static void print(Deque<ParamList> arr, int x)
    {
        p("Task "+x);
        Iterator<ParamList> it = arr.iterator();
        while (it.hasNext())
            p(it.next());

    }
    public static Deque<ParamList> avg(Deque<ParamList> arr)
    {
        int sum = 0;
        int count = 0;
        Iterator<ParamList> it = arr.iterator();
        while (it.hasNext())
        {
            String z = it.next().toString();
            char[] how = z.toCharArray();
            sum+=how.length;
            count++;
        }

        arr.push(new ParamList<>(sum/count));
        p("Количество символов: "+sum+", количество объектов: "+count);
        return arr;
    }

    public static void p(Object o)
    {
        System.out.println(o.toString());
    }
    @Override
    public String toString() {
        if ((this.str instanceof Integer)||(this.str instanceof Double)) return String.valueOf(str);

        return (String) str;
    }
}
