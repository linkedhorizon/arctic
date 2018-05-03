package annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Update {
    String value();
}
