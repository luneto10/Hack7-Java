package unl.soc;
/*
 * Name: Luciano Carvalho (lguedesdecarvalhon2@huskers.unl.edu)
 *
 * Date: 2023 - 10 - 12
 *
 * Some functions to manipulate a given list.
 */

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    /**
     * Checks if contains the value x in a list.
     */
    public static boolean contains(List<Integer> list, int x) {
        if (list == null) {
            throw new NullPointerException();
        }

        return list.contains(x);
    }

    /**
     * Checks if contains a value x in a list in the range
     * of the index i and j.
     */
    public static boolean containsWithin(List<Integer> list, int x, int i, int j) {
        if (list == null) {
            throw new NullPointerException();
        }

        if (i < 0 || j < 0) {
            throw new IllegalArgumentException();
        }

        for (int k = i; k <= j; k++) {
            if (list.get(k) == x) {
                return true;
            }
        }

        return false;
    }

    /**
     * Create a new copy of the list, increasing or decreasing its
     * size.
     */
    public static List<Integer> paddedCopy(List<Integer> list, int newSize) {
        if (list == null) {
            throw new NullPointerException();
        }

        if (newSize < 0) {
            throw new IllegalArgumentException();
        }

        List<Integer> listCopy = new ArrayList<>();

        if (newSize < list.size()) {
            for (int i = 0; i < newSize; i++) {
                listCopy.add(i, list.get(i));
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                listCopy.add(i, list.get(i));
            }

            for (int i = 0; i < (newSize - list.size()); i++) {
                listCopy.add((list.size()) + i, 0);
            }
        }
        return listCopy;
    }

    /**
     * Reverses the original list.
     */
    public static void reverse(List<Integer> list) {
        if (list == null) {
            throw new NullPointerException();
        }

        List<Integer> listCopy = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listCopy.add(i, list.get((list.size() - 1) - i));
        }

        list.clear();
        for (int i = 0; i < listCopy.size(); i++) {
            list.add(i, listCopy.get(i));
        }
    }

    /**
     * Returns a copy of the original list inverted.
     */
    public static List<Integer> reverseCopy(List<Integer> list) {
        if (list == null) {
            throw new NullPointerException();
        }

        List<Integer> listCopy = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listCopy.add(i, list.get((list.size() - 1) - i));
        }
        return listCopy;
    }
}


