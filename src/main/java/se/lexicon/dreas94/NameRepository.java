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

    private static int findByBinarySearchFullName(final String fullName)
    {
        if(getSize() == 0)
            return -1;

        return Arrays.binarySearch(names,fullName);
    }

    public static Boolean removeElementFromRepository(int index)
    {
        if (names == null || index < 0 || index >= names.length)
        {
            return false;
        }

        String[] tempNames = new String[names.length - 1];

        for (int i = 0, k = 0; i < names.length; i++)
        {
            if (i == index)
            {
                continue;
            }

            tempNames[k++] = names[i];
        }

        names = Arrays.copyOf(tempNames, tempNames.length);
        return true;
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
        if(findByBinarySearchFullName(fullName) < 0)
            return null;

        return fullName;
    }

    public static boolean add(final String fullName)
    {
        if(find(fullName) != null)
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
        int index = findByBinarySearchFullName(original);
        if(index < 0 || findByBinarySearchFullName(updatedName) >= 0)
            return false;

        names[index] = updatedName;

        sortNames();

        return true;
    }

    public static boolean remove(final String fullName)
    {
        int index = findByBinarySearchFullName(fullName);

        if(index < 0)
            return false;

        return removeElementFromRepository(index);
    }
}
