package name.panitz.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class AL<E> implements List<E> {
  protected E[] store = (E[]) new Object[5];
  protected int size = 0;

  public AL(E... es) {
    for (E e : es)
      add(e);
  }

  private void mkNewStore() {
    E[] newStore = (E[]) new Object[size + 5];
    for (int i = 0; i < store.length; i++)
      newStore[i] = store[i];
    store = newStore;
  }

  public void add(E e) {
    if (store.length <= size)
      mkNewStore();
    store[size++] = e;
  }

  public int size() {
    return size;
  }

  public E get(int i) {
    return store[i];
  }
}