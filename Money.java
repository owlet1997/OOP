package lab1;

import java.util.ArrayList;
import java.util.Vector;
import  java.util.Collections;
import java.util.Scanner;

public class Money {
    private String valute;
    private double cash;

    public String getValute() {
        return valute;
    }

    public void setValute(String valute) {
        this.valute = valute;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    private boolean vid;

    public Double getCash()
    {
        return this.cash;
    }

    public Money() {}
    public Money(String valute, double cash, boolean vid)
    {
        this.valute = valute;
        this.cash = cash;
        this.vid = vid;
    }

    public Money(String valute, double cash)
    {
        this.valute = valute;
        this.cash = cash;
    }

    public static void main(String[] args) {
        Vector<Money> mon = getVec();
        print(mon, 0);
        avg(mon);
        print(mon, 1);

        System.out.println("Введите ключ");
        Scanner sc = new Scanner(System.in);
        int key1 = sc.nextInt();

        delKey(mon, key1);
        print(mon, 2);
        refresh(mon);
        print(mon,3);

    }
    public static Vector<Money> getVec()
    {
        Vector<Money> mon = new Vector<>();

        Money rub = new Money("rubl", 150, true);
        Money dol = new Money("dollar", 400, true);
        Money cent = new Money("cent", 1, false);
        Money crona = new Money("crona", 25, true);
        Money bit = new Money("bitcoin", 26);
        Collections.addAll(mon, rub, dol, cent, crona, bit);
        return mon;
    }

    public static Vector<Money> refresh(Vector<Money> arr)
    {
        ArrayList<Double> cash = new ArrayList<>();
        for (Money a: arr) {
            if (a.valute.equals("AVG")) continue;
            cash.add(a.cash);
        }
        double z = Collections.min(cash);

        System.out.println("Minimum is "+z);

        for (Money a:arr)
            a.cash = a.cash - z;

        return arr;
    }

    public static Vector<Money> delKey(Vector<Money> arr, int key)
    {
        System.out.println(arr.elementAt(key)+" removed");
        arr.remove(key);
        print(arr,3);
        return arr;
    }

    public static void print(Vector<Money> arr, int x)
    {
        System.out.println("\nTask"+x);
        for (Money a: arr)
            System.out.println(a);
    }

    public static Vector<Money> avg(Vector<Money> arr)
    {
        float sum = 0;
        int count = 0;
        for (Money a: arr)
        {
            sum+=a.cash;
            count++;
        }
        arr.add(0,new Money("AVG",sum/count));
        return arr;
    }

    @Override
    public String toString() {
        String s;
        if (this.valute.equals("AVG")) return this.valute + " , количество: "+this.cash;
        if (this.valute.equals("bitcoin")) s = "криптовалюта";
        else s = this.vid? "банкнота":"монета";
        return this.valute + " , количество: "+this.cash+" , вид: "+s;
    }
}
