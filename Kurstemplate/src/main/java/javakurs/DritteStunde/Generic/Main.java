package javakurs.DritteStunde.Generic;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Typ typInteger = new Typ();
        Typ typString = new Typ();
        Typ typDouble = new Typ();

        typDouble.setDoublee(13.15);
        typInteger.setDoublee(200);
        typString.setString("Olaf");

        List<Integer> a = new ArrayList<>();

        ObjectFox<Integer> testObjekt1 = new ObjectFox<>(222,null);
        ObjectFox<Integer> testObjekt2 = new ObjectFox<>(202,testObjekt1);
        ObjectFox<Integer> testObjekt3 = new ObjectFox<>(200,testObjekt2);
        ObjectFox<Integer> testObjekt4 = new ObjectFox<>(2,testObjekt3);

        ObjectBunny<String> objectBunny1 = new ObjectBunny<>("2", null);
        ObjectBunny<String> objectBunny2 = new ObjectBunny<>("200", objectBunny1);
        ObjectBunny<String> objectBunny3 = new ObjectBunny<>("5000", objectBunny2);
        ObjectBunny<String> objectBunny4 = new ObjectBunny<>("Peter", objectBunny3);

        ObjectBunny<ObjectBunny> test1 = new ObjectBunny<>(null,null);
        ObjectBunny<ObjectBunny> test2 = new ObjectBunny<>(test1,test1);

        ObjectVixen objectVixen = new ObjectVixen(12,null);
        ObjectVixen objectVixen2 = new ObjectVixen(2,objectVixen);


        System.out.println(ChainedNodesUtil.size(testObjekt4));

    }
}
