package hasmrp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

class MapOperations {
    // HashMap Operations
    public static class MyHashMap<K, V> {
        private HashMap<K, V> hashMap;

        public MyHashMap() {
            this.hashMap = new HashMap<>();
        }

        public void put(K key, V value) {
            hashMap.put(key, value);
        }

        public V get(K key) {
            return hashMap.get(key);
        }

        public boolean containsKey(K key) {
            return hashMap.containsKey(key);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return hashMap.entrySet();
        }

        public int size() {
            return hashMap.size();
        }

        public V remove(K key) {
            return hashMap.remove(key);
        }

        public void clear() {
            hashMap.clear();
        }
    }

    // TreeMap Operations
    public static class MyTreeMap<K, V> {
        private TreeMap<K, V> treeMap;

        public MyTreeMap() {
            this.treeMap = new TreeMap<>();
        }

        public void put(K key, V value) {
            treeMap.put(key, value);
        }

        public V get(K key) {
            return treeMap.get(key);
        }

        public boolean containsKey(K key) {
            return treeMap.containsKey(key);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return treeMap.entrySet();
        }

        public int size() {
            return treeMap.size();
        }

        public V remove(K key) {
            return treeMap.remove(key);
        }

        public void clear() {
            treeMap.clear();
        }
    }

    // LinkedHashMap Operations
    public static class MyLinkedHashMap<K, V> {
        private LinkedHashMap<K, V> linkedHashMap;

        public MyLinkedHashMap() {
            this.linkedHashMap = new LinkedHashMap<>();
        }

        public void put(K key, V value) {
            linkedHashMap.put(key, value);
        }

        public V get(K key) {
            return linkedHashMap.get(key);
        }

        public boolean containsKey(K key) {
            return linkedHashMap.containsKey(key);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return linkedHashMap.entrySet();
        }

        public int size() {
            return linkedHashMap.size();
        }

        public V remove(K key) {
            return linkedHashMap.remove(key);
        }

        public void clear() {
            linkedHashMap.clear();
        }
    }

    // NavigableMap Operations
    public static class MyNavigableMap<K, V> {
        private NavigableMap<K, V> navigableMap;

        public MyNavigableMap() {
            this.navigableMap = new TreeMap<>();
        }

        public void put(K key, V value) {
            navigableMap.put(key, value);
        }

        public V get(K key) {
            return navigableMap.get(key);
        }

        public boolean containsKey(K key) {
            return navigableMap.containsKey(key);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return navigableMap.entrySet();
        }

        public int size() {
            return navigableMap.size();
        }

        public V remove(K key) {
            return navigableMap.remove(key);
        }

        public void clear() {
            navigableMap.clear();
        }

        public K firstKey() {
            return navigableMap.firstKey();
        }

        public K lastKey() {
            return navigableMap.lastKey();
        }

        public Map.Entry<K, V> firstEntry() {
            return navigableMap.firstEntry();
        }

        public Map.Entry<K, V> lastEntry() {
            return navigableMap.lastEntry();
        }

        public Map.Entry<K, V> ceilingEntry(K key) {
            return navigableMap.ceilingEntry(key);
        }

        public Map.Entry<K, V> floorEntry(K key) {
            return navigableMap.floorEntry(key);
        }

        public Map.Entry<K, V> higherEntry(K key) {
            return navigableMap.higherEntry(key);
        }

        public Map.Entry<K, V> lowerEntry(K key) {
            return navigableMap.lowerEntry(key);
        }

        public NavigableMap<K, V> descendingMap() {
            return navigableMap.descendingMap();
        }

        public NavigableSet<K> navigableKeySet() {
            return navigableMap.navigableKeySet();
        }

        public NavigableSet<Map.Entry<K, V>> descendingEntrySet() {
            return (NavigableSet<Entry<K, V>>) navigableMap.descendingMap().entrySet();
        }
    }
}

public class Mairn {
    public static void main(String[] args) {
        // Testing HashMap
        MapOperations.MyHashMap<String, Integer> myHashMap = new MapOperations.MyHashMap<>();
        myHashMap.put("One", 1);
        myHashMap.put("Two", 2);
        System.out.println("HashMap Size: " + myHashMap.size());
        System.out.println("HashMap Contains Key 'One': " + myHashMap.containsKey("One"));
        System.out.println("HashMap Contains Key 'Three': " + myHashMap.containsKey("Three"));
        System.out.println("HashMap Entry Set: " + myHashMap.entrySet());
        myHashMap.remove("One");
        System.out.println("HashMap Size after Removal: " + myHashMap.size());
        myHashMap.clear();
        System.out.println("HashMap Size after Clear: " + myHashMap.size());

        // Testing TreeMap
        MapOperations.MyTreeMap<String, Integer> myTreeMap = new MapOperations.MyTreeMap<>();
        myTreeMap.put("Three", 3);
        myTreeMap.put("Four", 4);
        System.out.println("TreeMap Size: " + myTreeMap.size());
        System.out.println("TreeMap Contains Key 'Three': " + myTreeMap.containsKey("Three"));
        System.out.println("TreeMap Contains Key 'Five': " + myTreeMap.containsKey("Five"));
        System.out.println("TreeMap Entry Set: " + myTreeMap.entrySet());
        myTreeMap.remove("Three");
        System.out.println("TreeMap Size after Removal: " + myTreeMap.size());
        myTreeMap.clear();
        System.out.println("TreeMap Size after Clear: " + myTreeMap.size());

        // Testing LinkedHashMap
        MapOperations.MyLinkedHashMap<String, Integer> myLinkedHashMap = new MapOperations.MyLinkedHashMap<>();
        myLinkedHashMap.put("Five", 5);
        myLinkedHashMap.put("Six", 6);
        System.out.println("LinkedHashMap Size: " + myLinkedHashMap.size());
        System.out.println("LinkedHashMap Contains Key 'Five': " + myLinkedHashMap.containsKey("Five"));
        System.out.println("LinkedHashMap Contains Key 'Seven': " + myLinkedHashMap.containsKey("Seven"));
        System.out.println("LinkedHashMap Entry Set: " + myLinkedHashMap.entrySet());
        myLinkedHashMap.remove("Five");
        System.out.println("LinkedHashMap Size after Removal: " + myLinkedHashMap.size());
        myLinkedHashMap.clear();
        System.out.println("LinkedHashMap Size after Clear: " + myLinkedHashMap.size());

        // Testing NavigableMap
        MapOperations.MyNavigableMap<String, Integer> myNavigableMap = new MapOperations.MyNavigableMap<>();
        myNavigableMap.put("Seven", 7);
        myNavigableMap.put("Eight", 8);
        System.out.println("NavigableMap Size: " + myNavigableMap.size());
        System.out.println("NavigableMap Contains Key 'Seven': " + myNavigableMap.containsKey("Seven"));
        System.out.println("NavigableMap Contains Key 'Ten': " + myNavigableMap.containsKey("Ten"));
        System.out.println("NavigableMap Entry Set: " + myNavigableMap.entrySet());
        System.out.println("NavigableMap First Key: " + myNavigableMap.firstKey());
        System.out.println("NavigableMap Last Key: " + myNavigableMap.lastKey());
        System.out.println("NavigableMap First Entry: " + myNavigableMap.firstEntry());
        System.out.println("NavigableMap Last Entry: " + myNavigableMap.lastEntry());
        System.out.println("NavigableMap Ceiling Entry for 'Eight': " + myNavigableMap.ceilingEntry("Eight"));
        System.out.println("NavigableMap Floor Entry for 'Eight': " + myNavigableMap.floorEntry("Eight"));
        System.out.println("NavigableMap Higher Entry for 'Eight': " + myNavigableMap.higherEntry("Eight"));
        System.out.println("NavigableMap Lower Entry for 'Eight': " + myNavigableMap.lowerEntry("Eight"));
        System.out.println("NavigableMap Descending Entry Set: " + myNavigableMap.descendingEntrySet());
        myNavigableMap.remove("Seven");
        System.out.println("NavigableMap Size after Removal: " + myNavigableMap.size());
        myNavigableMap.clear();
        System.out.println("NavigableMap Size after Clear: " + myNavigableMap.size());
    }
}
