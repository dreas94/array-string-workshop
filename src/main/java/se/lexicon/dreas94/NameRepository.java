package se.lexicon.dreas94;

import java.util.Arrays;

public class NameRepository
{
    private static String[] names = new String[]{};

    private static void sortNames()
    {
        Arrays.sort(NameRepository.names);
    }

    private static String[] genericArrayAdd(String[] array, String str)
    {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = str;

        return array;
    }

    private static String[] findByFirstOrLastName(final String firstName, final String lastName)
    {
        String[] foundNames = new String[]{};
        for(String name : names)
        {
            String[] splitName = name.split(" ");

            if((splitName[0].equals(firstName)) || (splitName[1].equals(lastName)))
            {
                foundNames = genericArrayAdd(foundNames, name);
            }
        }

        if(foundNames.length == 0)
        {
            return null;
        }

        return foundNames;
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

        names = genericArrayAdd(names, fullName);
        sortNames();

        return true;
    }

    public static String[] findByFirstName(final String firstName)
    {
        return findByFirstOrLastName(firstName, null);
    }

    public static String[] findByLastName(final String lastName)
    {
        return findByFirstOrLastName(null, lastName);
    }

    public static boolean update(final String original, final String updatedName)
    {
        if(getSize() == 0)
            return false;

        int index = Arrays.binarySearch(names,original);

        if(index < 0 || find(updatedName) == null)
            return false;

        names[index] = updatedName;

        return true;
    }
}
