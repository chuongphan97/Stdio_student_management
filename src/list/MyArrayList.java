package list;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private static final int DEFAULT_SIZE = 10;

    private int size = 0;

    private T[] elements;

    public MyArrayList() {
        this.elements = (T[]) new Object[DEFAULT_SIZE];
    }

    private void ensureCapacity() {
        int newSize = elements.length + DEFAULT_SIZE;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public void add(T t) {
        if (this.size >= elements.length) {
            ensureCapacity();
        }
        elements[size++] = t;
    }

    @Override
    public void add(int index, T t) {
        if (this.size >= elements.length) {
            ensureCapacity();
        }
        for (int i = index; i < size; i++) {

        }
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean contain(T t) {
        return false;
    }

    @Override
    public int indexOf(T t) {
        return 0;
    }

    @Override
    public void clear() {

    }
}
