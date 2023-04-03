package com.shop1.shop1.repository;

import com.shop1.shop1.constant.ItemSellStatus;
import com.shop1.shop1.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;
    @Test
    @DisplayName("상품저장테스트")
    public void createItemTest(){
        Item item = new Item();
        item.setItemNm("테스트상품1");
        item.setPrice(10000);
        item.setItemDetail("test1 상품 상세 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        Item savedItem = itemRepository.save(item);
        System.out.println(savedItem.toString());
    }
    public void createItemList() {

        for(int i=1; i<=10; i++){
            Item item = new Item();
            item.setItemNm("테스트상품"+i);
            item.setPrice(10000 + i);
            item.setItemDetail("test"  + " 상품 상세 설명"+i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item savedItem = itemRepository.save(item);
            //System.out.println(savedItem.toString();
        }
    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNmTest() {
        this.createItemList();
        List<Item> itemList = itemRepository.findByItemNm("테스트상품1");
        for(Item item: itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("상품명 이나 상품 상세설명으로 찾기")
    public void findByItemNmOrItemDetail() {
        this.createItemList();
        List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트상품1", "test 상품 상세 설명5");
        for(Item item: itemList) {
            System.out.println(item.toString());
        }
    }

    /*
    @Test
    @DisplayName("@Query를 이용한 상품 조회")
    public void findByItemDetailTest(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByItemDetail("test 상품 상세 설명");
        for(Item item: itemList) {
            System.out.println(item.toString());
        }
    }
     */

}