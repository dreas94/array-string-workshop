package se.lexicon.dreas94;

import java.util.Arrays;

public class NameRepository
{
    private static String[] names = new String[]{};

    public static int getSize()
    {
        return names.length;
    }

    public static void setNames(String[] names)
    {
        NameRepository.names = Arrays.copyOf(names,names.length);
    }

    public static void clear()
    {
        names = new String[]{};
    }

    public static String[] findAll()
    {
        return names;
    }
}
