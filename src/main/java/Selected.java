import java.sql.*;

public class Selected {
    public static User getUser(int v_id){
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/my-local", "sa", "");) {
            try (PreparedStatement statement = connection.prepareStatement("select first_name,last_name,age,address from users where id = ?;")) {
                statement.setInt(1, v_id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (!resultSet.next()) {
                        return null;
                    } else {
                        String v_first_name= resultSet.getString(1);
                        String v_last_name=resultSet.getString(2);
                        int v_age=resultSet.getInt(3);
                        String v_address=resultSet.getString(4);
                        return new User(v_first_name,v_last_name,v_age,v_address,v_id);
                    }
                }
            } catch (SQLException ex) {
                throw new IllegalStateException("Could not execute query", ex);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Card getCard(int v_id){
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/my-local", "sa", "");) {
            try (PreparedStatement statement = connection.prepareStatement("select library_id,user_id from cards where id = ?;")) {
                statement.setInt(1, v_id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (!resultSet.next()) {
                        return null;
                    } else {
                        int v_lId= resultSet.getInt(1);
                        int v_uId=resultSet.getInt(2);

                        User user = Selected.getUser(v_uId);
                        Library lib = Selected.getLibrary(v_lId);
                        return new Card(user,lib,v_id);
                    }
                }
            } catch (SQLException ex) {
                throw new IllegalStateException("Could not execute query", ex);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private static Library getLibrary(int v_Id) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/my-local", "sa", "");) {
            try (PreparedStatement statement = connection.prepareStatement("select id,address,name from libraries where id = ?;")) {
                statement.setInt(1, v_Id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (!resultSet.next()) {
                        return null;
                    } else {
                        int vId= resultSet.getInt(1);
                        String vAddress=resultSet.getString(2);
                        String vName=resultSet.getString(3);
                        return new Library(vAddress,vName,vId);
                    }
                }
            } catch (SQLException ex) {
                throw new IllegalStateException("Could not execute query", ex);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    private static Book getBook(int v_Id) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/my-local", "sa", "");) {
            try (PreparedStatement statement = connection.prepareStatement("select id,author,code,title,pagescount,category,card_id,date_from,date_to,library_id from books where id = ?;")) {
                statement.setInt(1, v_Id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (!resultSet.next()) {
                        return null;
                    } else {
                        int vId= resultSet.getInt(1);
                        String vAuthor = resultSet.getString(2);
                        String vCode = resultSet.getString(3);
                        String vTitle = resultSet.getString(4);
                        int vPages = resultSet.getInt(5);
                        int vCategory = resultSet.getInt(6);
                        String vCard_id = resultSet.getString(7);
                        Date vDateF = resultSet.getDate(8);
                        Date vDateT = resultSet.getDate(9);
                        int vLibId = resultSet.getInt(10);

                        Library lib = Selected.getLibrary(vLibId);
                        return new Book(vId, vAuthor,vCode,vTitle,vPages, CategoriesEnum.Categories.values()[vCategory],
                        vCard_id, vDateF, vDateT,lib);
                    }
                }
            } catch (SQLException ex) {
                throw new IllegalStateException("Could not execute query", ex);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

}
