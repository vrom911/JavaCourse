package ru.ifmo.ctddev.vr.arrayset;

import java.util.*;
/*
 * java -cp junit-4.11.jar:hamcrest-core-1.3.jar:quickcheck-0.6.jar:ArraySetTest.jar:./out/production/JavaCourse/ info.kgeorgiy.java.advanced.arrayset.Tester NavigableSet ru.ifmo.ctddev.vr.arrayset.ArraySet
 */
public class ArraySet<E> extends AbstractSet<E> implements NavigableSet<E> {

    private final ArrayList<E> set;
    private final Comparator<E> comparator;
    private boolean isDefaultOrder = false;

    public ArraySet(Collection<E> set, Comparator<E> comparator) {
        ArrayList<E> list = new ArrayList<>(set);
        this.comparator = comparator;
        list.sort(this.comparator);
        ArrayList<E> temp = new ArrayList<>();
        for (E e : list) {
            if (temp.isEmpty() || this.comparator.compare(e, temp.get(temp.size() - 1)) != 0) {
                temp.add(e);
            }
        }
        this.set = new ArrayList<>(temp);
    }

    public ArraySet() {
        this(new ArrayList<>(), new ArraySetComparator<E>());
        this.isDefaultOrder = true;
    }

    public ArraySet(Collection<E> set) {
        this(set, new ArraySetComparator<>());
        this.isDefaultOrder = true;
    }

    public ArraySet(Comparator<E> comparator) {
        this(new ArrayList<>(), comparator);
    }

    @Override
    public int size() {
        return this.set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Iterator<E> iterator = set.iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public E next() {
                return iterator.next();
            }
        };
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return set.get(0);
    }

    @Override
    public E last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return set.get(set.size() - 1);
    }

    @Override
    public boolean contains(Object o) {
        E el = (E) o;
        return Collections.binarySearch(set, el, comparator) >= 0;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object e : collection) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public NavigableSet<E> descendingSet() {
        ArrayList<E> descendingSet = new ArrayList<>(set);
        return new ArraySet<>(descendingSet, comparator.reversed());
    }

    @Override
    public Iterator<E> descendingIterator() {
        return descendingSet().iterator();
    }

    @Override
    public E lower(E e) {
        return helpLowerHigher(this.iterator(), e, 1);
    }

    @Override
    public E floor(E e) {
        return helpFloorCeiling(this.iterator(), e, 1);
    }

    @Override
    public E ceiling(E e) {
        return helpFloorCeiling(this.descendingIterator(), e, -1);
    }

    @Override
    public E higher(E e) {
        return helpLowerHigher(this.descendingIterator(), e, -1);
    }

    private E helpLowerHigher(Iterator<E> i, E e, int flag) {
        E result = null;
        while (i.hasNext()) {
            E next = i.next();
            if (comparator.compare(e, next) == flag) {
                result = next;
            } else {
                return result;
            }
        }
        return result;
    }

    private E helpFloorCeiling(Iterator<E> i, E e, int flag) {
        E result = null;
        while (i.hasNext()) {
            E next = i.next();
            if (comparator.compare(e, next) == flag  || comparator.compare(e, next) == 0) {
                result = next;
            } else {
                return result;
            }
        }
        return result;
    }

    @Override
    public NavigableSet<E> subSet(E fromEl, boolean from, E toEl, boolean to) {
        if (isEmpty() || (comparator.compare(fromEl, toEl) == 0 && !(from && to))) {
            return new ArraySet<>(new ArrayList<>(), comparator);
        }
        fromEl = from ? ceiling(fromEl) : higher(fromEl);
        toEl = to ? floor(toEl) : lower(toEl);
        if ((fromEl == null && !contains(null)) || (toEl == null && !contains(null))) {
            return new ArraySet<>(new ArrayList<>(), comparator);
        }
        if (set.indexOf(toEl) - set.indexOf(fromEl) >= 0) {
            return new ArraySet<>(set.subList(set.indexOf(fromEl), set.indexOf(toEl) + 1), comparator);
        } else {
            return new ArraySet<>(new ArrayList<>(), comparator);
        }
    }

    @Override
    public NavigableSet<E> headSet(E e, boolean in) {
        if(isEmpty()) {
            return new ArraySet<>(new ArrayList<>(), comparator);
        }
        return subSet(first(), true, e, in);
    }

    @Override
    public NavigableSet<E> tailSet(E e, boolean in) {
        if(isEmpty()) {
            return new ArraySet<>(new ArrayList<>(), comparator);
        }
        return subSet(e, in, last(), true);
    }

    @Override
    public Comparator<E> comparator() {
        return isDefaultOrder ? null : comparator;
    }

    @Override
    public NavigableSet<E> subSet(E e, E e1) {
        return subSet(e, true, e1, false);
    }

    @Override
    public NavigableSet<E> headSet(E e) {
        return headSet(e, false);
    }

    @Override
    public NavigableSet<E> tailSet(E e) {
        return tailSet(e, true);
    }

    @Override
    public String toString() {
        return "ArraySet{" +
                "set=" + set +
                '}';
    }

    /*
     * Actually shouldn't be here...
     */
    @Override
    public E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

}
