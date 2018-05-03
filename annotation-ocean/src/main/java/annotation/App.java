package annotation;

        import java.lang.reflect.Field;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class App {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("org.lyg.annotation.User");
        //创建对象
        User user = (User) clazz.newInstance();
        //检测类上有没有注解
        boolean existClassAnnotation = clazz.isAnnotationPresent(Description.class);
        if(existClassAnnotation){
            Description description = (Description) clazz.getAnnotation(Description.class);
            user.setAge(description.age());
            user.setAuthor(description.author());
            user.setDesc(description.desc());
        }
       // Field[] fields = clazz.getFields();获取的是非private字段
        Field[] fields = clazz.getDeclaredFields();
        Field.setAccessible(fields,true);
        Field isdefault = null;

        for (Field field:fields){
            if(field.getName().equals("isdefault")){
                isdefault = field;
            }
        }
        boolean existFieldAnnotation = isdefault.isAnnotationPresent(Update.class);
        if(existFieldAnnotation){
            Update update = (Update) isdefault.getAnnotation(Update.class);
            user.setIsdefault(Boolean.valueOf(update.value()));
            user.setAge(0);
            user.setAuthor("default");
            user.setDesc("default");
        }
        System.out.println(user);
    }
}
