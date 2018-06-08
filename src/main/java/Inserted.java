import java.sql.*;
import java.text.SimpleDateFormat;

public class Inserted {
    public static void insUser(User u) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/my-local", "sa", "");) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Users(first_name,last_name,age,address) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, u.getFirst_name());
                preparedStatement.setString(2, u.getLast_name());
                preparedStatement.setInt(3, u.getAge());
                preparedStatement.setString(4, u.getAddress());

                int inserted = preparedStatement.executeUpdate();

                if (inserted != 1) {
                    throw new IllegalStateException(String.format("Should insert one row. Actually inserted: %d", inserted));
                }

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (!generatedKeys.next()) {
                        throw new IllegalStateException("Query did not return created primary key");
                    }

                    u.setId((int) generatedKeys.getLong(1));
                    System.out.println("Generated user id is = " + u.getId());
                }
            } catch (SQLException ex) {
                throw new IllegalStateException("Could not execute query", ex);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void insCard(Card c) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/my-local", "sa", "");) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Cards(user_id,library_id) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, c.getUser().getId());
                preparedStatement.setInt(2, c.getLibrary().getId());
                int inserted = preparedStatement.executeUpdate();

                if (inserted != 1) {
                    throw new IllegalStateException(String.format("Should insert one row. Actually inserted: %d", inserted));
                }

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (!generatedKeys.next()) {
                        throw new IllegalStateException("Query did not return created primary key");
                    }

                    c.setId((int) generatedKeys.getLong(1));

                    System.out.println("Generated card id is = " + c.getId());
                }
            } catch (SQLException ex) {
                throw new IllegalStateException("Could not execute query", ex);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


    public static void insBook(Book b) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/my-local", "sa", "");) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Books(author, code, title, pagesCount, category, library_id, card_id, date_from, date_to) VALUES(?,?,?,?,?,?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, b.getAuthor());
                preparedStatement.setString(2, b.getCode());
                preparedStatement.setString(3, b.getTitle());
                preparedStatement.setInt(4, b.getPagesCount());
                preparedStatement.setInt(5, b.getCategory().ordinal());
                preparedStatement.setInt(6, b.getLibrary().getId());
                preparedStatement.setInt(7, b.getCard_id());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                if (b.getDate_from() == null || b.getDate_to() == null) {
                    preparedStatement.setTimestamp(8, null);
                    preparedStatement.setTimestamp(9, null);
                } else {
                    preparedStatement.setTimestamp(8, java.sql.Timestamp.valueOf(sdf.format(b.getDate_from().getTime())));
                    preparedStatement.setTimestamp(9, java.sql.Timestamp.valueOf(sdf.format(b.getDate_to().getTime())));
                }

                int inserted = preparedStatement.executeUpdate();

                if (inserted != 1) {
                    throw new IllegalStateException(String.format("Should insert one row. Actually inserted: %d", inserted));
                }

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (!generatedKeys.next()) {
                        throw new IllegalStateException("Query did not return created primary key");
                    }

                    b.setId((int) generatedKeys.getLong(1));
                    System.out.println("Generated book id is = " + b.getId());
                }
            } catch (SQLException ex) {
                throw new IllegalStateException("Could not execute query", ex);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    public static void insLibrary(Library l) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/my-local", "sa", "");) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Libraries(address, name) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, l.getAddress());
                preparedStatement.setString(2, l.getName());

                int inserted = preparedStatement.executeUpdate();

                if (inserted != 1) {
                    throw new IllegalStateException(String.format("Should insert one row. Actually inserted: %d", inserted));
                }

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (!generatedKeys.next()) {
                        throw new IllegalStateException("Query did not return created primary key");
                    }

                    l.setId((int) generatedKeys.getLong(1));
                    System.out.println("Generated library id is = " + l.getId());

                }
            } catch (SQLException ex) {
                throw new IllegalStateException("Could not execute query", ex);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
