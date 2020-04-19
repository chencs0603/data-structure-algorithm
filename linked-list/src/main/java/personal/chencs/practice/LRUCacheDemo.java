package personal.chencs.practice;

import personal.chencs.practice.linked.LRUCache;

/**
 * @author: chencs
 * @date: 2020/4/19 15:59
 */
public class LRUCacheDemo {

    public static void main(String[] args) {
        LRUCache<Integer> lruCache = new LRUCache<Integer>(5);
        for (int i = 0 ; i < 4; i++) {
            lruCache.put(i);
        }
        System.out.println("-------原始数据-------");
        lruCache.printAll();

        System.out.println("-------加5后的数据-------");
        lruCache.put(5);
        lruCache.printAll();

        System.out.println("-------加6后的数据-------");
        lruCache.put(6);
        lruCache.printAll();

        System.out.println("-------加7后的数据-------");
        lruCache.put(7);
        lruCache.printAll();

        System.out.println("-------加3后的数据-------");
        lruCache.put(3);
        lruCache.printAll();
    }
}
