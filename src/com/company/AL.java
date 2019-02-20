package com.company;

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

  public void addAll(List<E> cs) {
    for (int i = 0; i < cs.size(); i++) {
      add(cs.get(i));
    }
  }

  public void remove(int i) {
    if (i <= (this.size() - 1) && this.get(i) != null) {
      store[i] = null;
      for (int y = i; y < this.size() - 1; y++) {
        store[y] = this.get(y + 1);
      }
      this.size = this.size() - 1;
    }
  }

  public void insert(int i, E e) {
    if (i >= 0) {
      if (i > this.size - 1) {
        add(e);
      } else {
        this.add(this.get(this.size-1));
        for(int j = this.size-1; j >= i; j--) {
          store[j+1] = store[j];
        }
        store[i] = e;
      }
    }
  }

  public boolean contains(E e) {
    boolean result = false;
    for (int i = 0; i < this.size; i++) {
      if (this.get(i).equals(e)) result = true;
    }
    return result;
  }

  public void reverse() {
    AL<E> newList = new AL<>();
    for(int i = this.size-1; i >=0; i--) {
      newList.add(this.get(i));
    }
    this.store = newList.store;
  }

  public void forEach(Consumer<? super E> consumer) {
    for (int i = 0; i < this.size; i++) consumer.accept(this.get(i));
  }

  public boolean startsWith(List<E> that) {
    System.out.println("that size:" + that.size());
    System.out.println("this size:" + this.size);
    if (that.size() > this.size) return false;
    if (that.size() == 0 && this.size == 0) return true;
    for (int i = 0; i > this.size; i++) {
      if (this.get(i) != that.get(i)) return false;
    }
    return true;
  }

  public boolean endsWith(List<E> that) {
    if (that.size() > this.size) return false;
    if (that.size() == 0 && this.size == 0) return true;
    for (int i = this.size-1; i < 0; i--) {
      if (this.get(i) != that.get(i)) return false;
    }
    return true;
  }

  public List<E> sublist(int i, int l) {
    AL<E> newList = new AL<>();
    if (l > this.size - 1) l = this.size - 1;
    if (i <= this.size - 1) {
      for (int j = i; j <= l; j++) {
        newList.add(this.get(j));
      }
    }
    for (int j = 0; j < newList.size; j++) {
      System.out.println(newList.store[j]);
    }
    return newList;
  }

  public void sortBy(Comparator<? super E> cmp) {
    for (int n=this.size; n > 1; n--) {
      for (int i = 0; i < n-1; i++) {
        if (cmp.compare(this.get(i), this.get(i+1)) > 0) {
          E temp1 = this.get(i);
          E temp2 = this.get(i+1);
          store[i] = temp2;
          store[i+1] = temp1;
        }
      }
    }
  }

  public boolean containsWith(Predicate<E> pred) {
    if (this.size == 0) return false;
    for (int i = 0; i < this.size; i++) {
      if (pred.test(this.get(i))) return true;
    }
    return false;
  }

  public int size() {
    return size;
  }

  public E get(int i) {
    return store[i];
  }
}