package unl.soc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class teste {
    public static void main(String[] args) {
        int count = 0;
        Integer[] a = {10,42,85,76,10,11,73};
        List<Integer> lista = new ArrayList<>(Arrays.asList(a));
//        for (int i = 0; i < 10; i++){
//            lista.add(i, count);
//            count++;
//        }
        if (ListUtils.containsWithin(lista, 11, 6, 4)){
            System.out.println("Correct!!");
        }
//        List<Integer> listaCopia = ListUtils.paddedCopy(lista, 3);
//        System.out.println(lista);
//        System.out.println(listaCopia);
//        ListUtils.reverse(lista);
//        System.out.println(lista);
//        List<Integer> listaCopia2 = ListUtils.reverseCopy(lista);
//        System.out.println(listaCopia2);
    }
}
