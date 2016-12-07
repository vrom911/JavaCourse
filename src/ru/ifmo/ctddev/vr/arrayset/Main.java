package ru.ifmo.ctddev.vr.arrayset;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);
        list.add(3);
//        System.out.println(list);
//        System.out.println(list.subList(4, 5));
//        Comparator<Integer> com = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer integer, Integer t1) {
//                if (t1 - integer > 2) return 1;
//                else if (t1 - integer == 2) return 0;
//                return -1;
//            }
//        };
        ArraySet<Integer> set = new ArraySet<>(list);
        list.sort(set.comparator());
        System.out.println(Collections.binarySearch(list, 0, set.comparator()));
        System.out.println(set);
        System.out.println(set.subSet(1, false, 5, true));
        System.out.println(set.tailSet(1, false));
//        System.out.println(set.first());
//        System.out.println(set.lower((5)));
//        System.out.println(set.floor((5)));
//        System.out.println(set.ceiling((5)));
//        System.out.println(set.higher((5)));
    }
}
