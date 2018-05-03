package annotation;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
@Description(age=19,desc = "desc",author = "author")
public class User {
    private String author;
    private String desc;
    private int age;
    @Update("true")
    private boolean isdefault = false;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isdefault() {
        return isdefault;
    }

    public void setIsdefault(boolean isdefault) {
        this.isdefault = isdefault;
    }

    @Override
    public String toString() {
        return "User{" +
                "author='" + author + '\'' +
                ", desc='" + desc + '\'' +
                ", age=" + age +
                ", isdefault=" + isdefault +
                '}';
    }
}
