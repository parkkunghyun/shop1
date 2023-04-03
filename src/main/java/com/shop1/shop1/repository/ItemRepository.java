package com.shop1.shop1.repository;

import com.shop1.shop1.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ItemRepository extends JpaRepository<Item, Long> {
    // JpaRepository는 두개의 제네릭 타입 -> 첫번쩨는 entity, 두번째는 그 entity의 pk 타입
    // <S extends T> save(S entity)
    // void delete(T entity)
    // count()
    // Iterable<T> findAl

    List<Item> findByItemNm(String itemNm);

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    List<Item> findByPriceLessThan(Integer price);


    // JPQL 방식인 Query어노테이션 사용!
    //@Query("select i from item i where i.itemDetail like %:itemDetail% order by i.price desc")
    //List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

}
