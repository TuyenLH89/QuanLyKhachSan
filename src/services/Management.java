package services;

public interface Management<T> {
    T findById(long id);
    void printList();
    void updateById(long id, T t);
    void add(T t);
    void deleteById(long id);
}
