package org.lyg.sortedmap;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

/**
 * 一直一个HashMap<Integer,User>集合，User有name(String)和age(int)属性。请写一个方法实现对
 * HashMap的排序功能，该方法接收HashMap<Integer,User>为形参，返回类型为HashMap<Integer,User>,
 * 要求对HashMap中的User的age倒序进行排序。排序是key=value键值对不能拆散。
 *
 * 注意：做这一道题必须对集合的体系结构非常的熟悉。HashMap本身就是不可排序的，但是该到底偏偏让
 * 给hashMap排序，那我们就得想在API中有没有这样的Map结构是有序的，LinkedHashMap就是，它是Map结构，也是
 * 链表结构，有序的，更重要的是它是hashMap的子类，我们返回LinkedHashMap<Integer,User>即可，还符合面向接口的思想。
 * 但凡是对集合的操作，我们应该保持一个原则就是能用JDK中的API就用jdk中的API，比如排序算法我们不应该去用冒泡或者选择，
 * 而是首先想到Collections集合工具类。
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        HashMap<Integer,User> users = new HashMap<Integer,User>();
        users.put(1,new User("张三",25));
        users.put(3,new User("李四",22));
        users.put(2,new User("王五",28));
        System.out.println(users);
        HashMap<Integer,User> sortusers = sortHashMap(users);
        System.out.println(sortusers);
    }
    public static HashMap<Integer,User> sortHashMap(HashMap<Integer,User> users){
        //首先拿到map键值对集合
        Set<Entry<Integer,User>> entrySet = users.entrySet();
        //将set集合转为list集合，为了使用工具类的排序方法
        List<Entry<Integer,User>> list = new ArrayList<Entry<Integer, User>>(entrySet);
        //使用Collections集合工具类对list进行排序，排序规则使用匿名内部类来实现
        Collections.sort(list, new Comparator<Entry<Integer, User>>() {
            @Override
            public int compare(Entry<Integer, User> o1, Entry<Integer, User> o2) {
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });
        //创建一个新的有序的HashMap子类的集合
        LinkedHashMap<Integer,User> linkedHashMap = new LinkedHashMap<Integer, User>();
        //将List中的数据存储在LinkedHashMap中
        for(Entry<Integer,User> entry : list){
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        return linkedHashMap;
    }
}
