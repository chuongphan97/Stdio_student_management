package list;

public interface MyList<E> {

    public int getSize();

    public E get(int index);

    public void add(E e);

    public void add(int index, E e);

    public E remove(int index);

    public boolean contain(E e);

    public int indexOf(E e);

    public void clear();
}
