package personal.chencs.practice.linked;

/**
 * @author: chencs
 * @date: 2020/4/19 15:27
 */
public class LRUCache<T> {

    private Integer size;
    private SingleLinkedList<T> dataList;
    private Integer count;

    public LRUCache(Integer size) {
        this.size = size;
        this.dataList = new SingleLinkedList<T>();
        this.count = 0;
    }

    public void put(T data) {
        SingleLinkedNode<T> targetBeforeNode = dataList.findByDataReturnBeforeNode(data);
        if (null == targetBeforeNode) {
            // 数据不在缓存中
            if (count == size) {
                // 缓存已满，删除尾结点
                dataList.removeTail();
                count--;
            }
            // 直接插入到头结点
            dataList.insertToHead(data);
            count++;
        } else {
            // 数据已在缓存中存在
            // 删除该元素，并将该元素插入头结点
            dataList.deleteByData(data);
            dataList.insertToHead(data);
        }
    }

    public void printAll() {
        dataList.printAll();
    }
}
