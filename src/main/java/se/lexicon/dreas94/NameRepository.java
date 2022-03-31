package se.lexicon.dreas94;

import java.util.Arrays;

public class NameRepository
{
    private static String[] names = new String[]{};

    private static void sortNames()
    {
        Arrays.sort(NameRepository.names);
    }

    public static int getSize()
    {
        return names.length;
    }

    public static void setNames(String[] names)
    {
        NameRepository.names = Arrays.copyOf(names,names.length);
        sortNames();
    }

    public static void clear()
    {
        names = new String[]{};
    }

    public static String[] findAll()
    {
        return names;
    }

    public static String find(final String fullName)
    {
        if(getSize() == 0 || Arrays.binarySearch(names,fullName) < 0)
            return fullName;

        return null;
    }

    public static boolean add(final String fullName)
    {
        if(find(fullName) == null)
            return false;

        names = Arrays.copyOf(names, names.length + 1);
        names[names.length - 1] = fullName;
        sortNames();

        return true;
    }
}
