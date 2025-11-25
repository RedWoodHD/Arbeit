package javakurs.JavaKurs_1.Rekursion;

public class Main
{
    public static void main(String[] args)
    {
        calculateFibonacci(10);
        System.out.println("Es wurden "+ bunnyEarsCount(10)+ " Hasenohren gezählt");

    }

    private static int bunnyEarsCount(int i)
    {
        if (i==0) return 0;
        return bunnyEarsCount(i-1) + 2;
    }

    private static void calculateFibonacci(int i)
    {
        rekursion(i, 0, 1);
    }

    private static void rekursion(int i, int entry1, int entry2)
    {
        int result = 0;
        System.out.print(entry1+", ");
        result = entry2 + entry1;
        if (i == 0)
        {
            return;
        }
        rekursion(i - 1, entry2, result);

    }
}
