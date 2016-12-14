package ru.ifmo.ctddev.vr.arrayset;

import java.util.*;
/*
 * java -cp junit-4.11.jar:hamcrest-core-1.3.jar:quickcheck-0.6.jar:ArraySetTest.jar:./out/production/JavaCourse/ info.kgeorgiy.java.advanced.arrayset.Tester NavigableSet ru.ifmo.ctddev.vr.arrayset.ArraySet
 */
public class ArraySet<E extends Comparable<E>> extends AbstractSet<E> implements NavigableSet<E> {

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
        this.set = temp;
    }

    private ArraySet(Collection<E> set, Comparator<E> comparator, int i) {
        this.set = new ArrayList<>(set);
        this.comparator = comparator;
    }

    public ArraySet() {
        this(new ArrayList<>(), Comparator.naturalOrder());
        this.isDefaultOrder = true;
    }

    public ArraySet(Collection<E> set) {
        this(set, new ArraySetComparator<>());
        this.isDefaultOrder = true;
    }

    public ArraySet(Comparator<E> comparator) {
        this(new ArrayList<>(), comparator, 1);
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
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
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
        return new ArraySet<>(set, comparator.reversed(), 1);
    }

    @Override
    public Iterator<E> descendingIterator() {
        return descendingSet().iterator();
    }

    @Override
    public E lower(E e) {
        int index = lowerInd(e);
        return (index < 0) ? null : set.get(index);
    }

    public int lowerInd(E e) {
        int index = Collections.binarySearch(set, e, comparator);
        if (index == 0 || index == -1) {
            return -1;
        }
        return (index > 0) ? index - 1 : -index - 2;
    }

    @Override
    public E floor(E e) {
        int index = floorInd(e);
        return (index < 0) ? null : set.get(index);
    }

    public int floorInd(E e) {
        int index = Collections.binarySearch(set, e, comparator);
        if (index == -1) {
            return -1;
        }
        return (index >= 0) ? index : -index - 2;
    }

    @Override
    public E ceiling(E e) {
        int index = ceilingInd(e);
        return (index < 0) ? null : set.get(index);
    }

    public int ceilingInd(E e) {
        int index = Collections.binarySearch(set, e, comparator);

        if (index == -size() - 1) {
            return -1;
        }
        return (index >= 0) ? index : -index - 1;
    }

    @Override
    public E higher(E e) {
        int index = higherInd(e);
        return (index < 0) ? null : set.get(index);
    }

    public int higherInd(E e) {
        int index = Collections.binarySearch(set, e, comparator);

        if ((index == -size() - 1) || (index == size() - 1)){
            return -1;
        }
        return (index >= 0) ? index + 1 : - index - 1;
    }

    @Override
    public NavigableSet<E> subSet(E fromEl, boolean from, E toEl, boolean to) {
        return this.tailSet(fromEl, from).headSet(toEl, to);
    }

    public NavigableSet<E> subSetIndex(int from, int to) {
        if ((from < 0) || (to < 0) || (to - from < 0)) {
            return new ArraySet<>(comparator);
        }
        return new ArraySet<>(set.subList(from, to + 1), comparator, 1);
    }

    @Override
    public NavigableSet<E> headSet(E e, boolean in) {
        if (isEmpty()) {
            return new ArraySet<>(comparator);
        }
        int to = in ? floorInd(e) : lowerInd(e);
        return subSetIndex(0, to);
    }

    @Override
    public NavigableSet<E> tailSet(E e, boolean in) {
        if (isEmpty()) {
            return new ArraySet<>(comparator);
        }
        int from = in ? ceilingInd(e) : higherInd(e);
        return subSetIndex(from, size() - 1);
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
