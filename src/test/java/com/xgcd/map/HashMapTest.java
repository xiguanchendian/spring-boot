//package com.xgcd.map;
//
//import java.util.HashMap;
//
//public class HashMapTest {
//    public static void main(String[] args) {
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("abc", "123");
//        System.out.println(map.get("abc"));// 123
//    }
//
//    /**
//     * Implements Map.get and related methods.
//     *
//     * @param hash hash for key
//     * @param key the key
//     * @return the node, or null if none
//     */
//    final HashMap.Node<K,V> getNode(int hash, Object key) {
//        HashMap.Node<K,V>[] tab; HashMap.Node<K,V> first, e; int n; K k;
//        if ((tab = table) != null && (n = tab.length) > 0 &&
//                (first = tab[(n - 1) & hash]) != null) {
//            // 直接命中返回该元素
//            if (first.hash == hash && // always check first node
//                    ((k = first.key) == key || (key != null && key.equals(k))))
//                return first;
//            if ((e = first.next) != null) {
//                // 遍历红黑树查找元素
//                if (first instanceof HashMap.TreeNode)
//                    return ((HashMap.TreeNode<K,V>)first).getTreeNode(hash, key);
//                // 遍历链表查找元素
//                do {
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k))))
//                        return e;
//                } while ((e = e.next) != null);
//            }
//        }
//        return null;
//    }
//
//    /**
//     * Implements Map.put and related methods.
//     *
//     * @param hash hash for key
//     * @param key the key
//     * @param value the value to put
//     * @param onlyIfAbsent if true, don't change existing value
//     * @param evict if false, the table is in creation mode.
//     * @return previous value, or null if none
//     */
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//                   boolean evict) {
//        // tab为数组，p是每个桶
//        HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
//        // 如果数组(table)为空，则调用resize()扩容创建一个数组
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length;
//        // 计算元素索要存储的数组下标，算法是(n-1)&hash，如果此下标没有元素则直接插入
//        if ((p = tab[i = (n - 1) & hash]) == null)
//            tab[i] = newNode(hash, key, value, null);
//        // 如果在数组table的下标i位置已经有元素了，也就是发生了所谓的hash碰撞，有两种情况：
//        // 1、key值是一样的，直接替换value值(也就是覆盖)
//        // 2、key值不一样，又有两种处理方式，判断链表是否是红黑树：
//            // 2.1 是红黑树，存储在红黑树中
//            // 2.2 是正常的链表，则存储在i位置的链表中(直接插到最后面)
//        else {
//            HashMap.Node<K,V> e; K k;
//            // 1、key值一样
//            if (p.hash == hash &&
//                    ((k = p.key) == key || (key != null && key.equals(k))))
//                e = p;
//            // 2.1 是红黑树
//            else if (p instanceof HashMap.TreeNode)
//                e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//            // 2.2 不是红黑树即是链表，遍历链表
//            else {
//                for (int binCount = 0; ; ++binCount) {
//                    // 遍历直到链表尾端都没有找到key值相同的节点，则生成一个新的Node
//                    if ((e = p.next) == null) {
//                        // 创建链表节点并插入尾部
//                        p.next = newNode(hash, key, value, null);
//                        // 超过了链表的设置长度8则转为红黑树
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                            treeifyBin(tab, hash);
//                        break;
//                    }
//                    // 如果节点key存在，则覆盖原来位置上的key，同时将原来位置的元素沿着链表向后移动一位
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k))))
//                        break;
//                    p = e;
//                }
//            }
//            if (e != null) { // existing mapping for key
//                V oldValue = e.value;
//                if (!onlyIfAbsent || oldValue == null)
//                    e.value = value;
//                afterNodeAccess(e);
//                return oldValue;
//            }
//        }
//        ++modCount;
//        if (++size > threshold)
//            resize();
//        afterNodeInsertion(evict);
//        return null;
//    }
//}
