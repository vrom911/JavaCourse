package ru.ifmo.ctddev.vr.arrayset;

import java.util.Comparator;

public class ArraySetComparator<E> implements Comparator<E> {

    @Override
    public int compare(E e1, E e2) {
        if (e1 == null) {
            return -1;
        }
        if (e2 == null) {
            return 1;
        }
        return ((Comparable) e1).compareTo(e2);
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}
