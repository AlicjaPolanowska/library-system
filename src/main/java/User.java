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

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/my-local", "sa", "");) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Users(first_name,last_name,age,address) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, first_name);
                preparedStatement.setString(2, last_name);
                preparedStatement.setInt(3, age);
                preparedStatement.setString(4, address);

                int inserted = preparedStatement.executeUpdate();

                if (inserted != 1) {
                    throw new IllegalStateException(String.format("Should insert one row. Actually inserted: %d", inserted));
                }

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (!generatedKeys.next()) {
                        throw new IllegalStateException("Query did not return created primary key");
                    }

                    this.setId((int) generatedKeys.getLong(1));
                    System.out.println("Generated id is = " + this.getId());
                }
            } catch (SQLException ex) {
                throw new IllegalStateException("Could not execute query", ex);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
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
