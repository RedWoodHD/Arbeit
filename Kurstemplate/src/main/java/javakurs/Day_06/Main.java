package javakurs.Day_06;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        File file = new File(".");
        searchForTextFiles(file);
    }

    public static void searchForTextFiles(final File fileOrDirectory)
    {
        if (fileOrDirectory.isDirectory())
        {
            File[] elements = fileOrDirectory.listFiles();
            if (elements == null)
            {
                return;
            }
            for (File currentFile : elements)
            {
                searchForTextFiles(currentFile);
            }
        }
        else if (fileOrDirectory.isFile())
        {
            if (fileOrDirectory.getName().toLowerCase().endsWith(".java"))
            {
                System.out.println(fileOrDirectory.getAbsolutePath());
            }
        }
    }
}
