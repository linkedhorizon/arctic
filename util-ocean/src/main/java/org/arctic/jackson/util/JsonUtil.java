package org.arctic.jackson.util;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.arctic.jackson.bean_test.User;
import org.arctic.time.util.DateTimeUtil;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25 0025.
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        //对象的所有字段全部列入
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.ALWAYS);

        //取消默认转换timestamps形式
        objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,false);

        //忽略空bean转json错误
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);

        //所有的日期格式都同一为以下的格式，即yyyy-MM-dd HH:mm:ss
        objectMapper.setDateFormat(new SimpleDateFormat(DateTimeUtil.STANDARD_FORMAT));

        //忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    public static <T> String obj2String(T obj){
        try {
            return obj instanceof String ? (String)obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static <T> String obj2StringPretty(T obj){
        try {
            return obj instanceof String ? (String)obj : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public  static <T> T string2Obj(String str,Class<T> clazz){
        if(StringUtils.isEmpty(str) || clazz == null){
            return null;
        }
        try {
            return clazz.equals(String.class) ? (T)str : objectMapper.readValue(str,clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T str2Obj(String str, TypeReference<T> typeReference){
        if(StringUtils.isEmpty(str) || typeReference == null){
            return null;
        }

        try {
            return (T)(typeReference.getType().equals(String.class) ? str : objectMapper.readValue(str,typeReference));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T str2Obj(String str, Class<?> collectionClass,Class<?> ...elementsClass){
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass,elementsClass);
        try {
            return objectMapper.readValue(str,javaType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args){
        User user1 = new User();
        user1.setDatetime(new Date());
        user1.setUsername("jack");
        user1.setPassword("rose");

        User user2 = new User();
        user2.setDatetime(new Date());
        user2.setUsername("jack");
        user2.setPassword("rose");

        String str_json = JsonUtil.obj2StringPretty(user1);
        System.out.println("str_json:"+str_json);

        User user_obj = JsonUtil.string2Obj(str_json,User.class);
        System.out.println(user_obj);

        System.out.println("---list序列化案例---");
        List<User> list = Lists.newArrayList();
        list.add(user1);
        list.add(user2);
        String userList_str = JsonUtil.obj2String(list);
        System.out.println(userList_str);//执行通过，说明集合转为String是可以的

        //反序列化无法成功，需要使用以下的方法
        System.out.println("---list反序列化案例之一---");
        List<User> list_obj1 = str2Obj(userList_str, new TypeReference<List<User>>() {
        });
        System.out.println("size:"+list_obj1.size());

        System.out.println("---list反序列化案例之二---");
        List<User> list_obj2 = str2Obj(userList_str,List.class,User.class);
        System.out.println("size:"+list_obj2.size());
    }
}
