import java.sql.*;

public class User {
        private String first_name;
        private  String last_name;
        private  int age;
        private  String address;
        private int id;


    public User(String first_name, String last_name, int age, String address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.address = address;
    }

    public User(String first_name, String last_name, int age, String address,int id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.address = address;
        this.id=id;
    }


    public User() {

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "User{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
