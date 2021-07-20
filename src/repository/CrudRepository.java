package repository;

/**
 * Created by Hayk on 18.07.2021.
 */
 interface CrudRepository<T,Integer> {
  public void create(T t);
  public void update(T t,Integer id);
  public void delete(Integer id);
}
