package javakurs.dritte_stunde.generic;

public class ChainedNodesUtil
{

    public static void main(String[] args)
    {
        ObjectFox<Integer> testObjekt1 = new ObjectFox<>(222,null);
        ObjectFox<Integer> testObjekt2 = new ObjectFox<>(202,testObjekt1);
        ObjectFox<Integer> testObjekt3 = new ObjectFox<>(200,testObjekt2);
        ObjectFox<Integer> testObjekt4 = new ObjectFox<>(2,testObjekt3);


        System.out.println(size(testObjekt4));
    }

    public static <TYPE extends Number>int size(ObjectFox<TYPE> obj)
    {
        int n = 1;
        while (obj.nachfolger != null){
            n++;
        }
        return n;
    }
}
