import java.util.List;

public class Person implements Cloneable {

    String name;
    String age;
    List<Person> friend;

    public Person(){}

    public Person(String name, String age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Person> getFriend() {
        return friend;
    }

    public void setFriend(List<Person> friend) {
        this.friend = friend;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
