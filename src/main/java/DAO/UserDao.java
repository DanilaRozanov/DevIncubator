package DAO;

import Entity.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_incubator";


    static final String USER = "root";
    static final String PASSWORD = "12345";

    public List<User> list() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<User>();

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.prepareStatement("SELECT  * FROM user");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setUser_Id(resultSet.getInt("user_id"));
                user.setName(resultSet.getString("name"));
                user.setSurName(resultSet.getString("sureName"));
                users.add(user);
            }
        }
        finally {
            if (resultSet != null) try {
                resultSet.close();
            }
                catch (SQLException ignore) {
            }
            if (statement != null) try {
                statement.close();
            }
                catch (SQLException ignore) {
            }
            if (connection != null) try {
                connection.close();
            }
                catch (SQLException ignore) {
            }
        }
        return users;
    }

    public User getUserBy_Id(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = new User();

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.prepareStatement("Select * FROM user WHERE user_id = " + id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user.setUser_Id(resultSet.getInt("user_id"));
                user.setName(resultSet.getString("name"));
                user.setSurName(resultSet.getString("sureName"));
            }

        } finally {
            if (resultSet != null) try {
                resultSet.close();
            }
                catch (SQLException ignore) {
            }
            if (statement != null) try {
                statement.close();
            }
                catch (SQLException ignore) {
            }
            if (connection != null) try {
                connection.close();
            }
                catch (SQLException ignore) {
            }
        }
        return user;
    }

    public User getRichestUser() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = new User();

        try {

            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.prepareStatement("select user.user_id, user.name, user.sureName from account right outer join user on user.user_id=account.user_id where account=(select max(account) from account);"); // search by one highest account, not by sum
            resultSet = statement.executeQuery();
            while(resultSet.next()) {

                user.setUser_Id(resultSet.getInt("user_id"));
                user.setName(resultSet.getString("name"));
                user.setSurName(resultSet.getString("sureName"));

            }
        }
        finally {
            if (resultSet != null) try {
                resultSet.close();
            } catch (SQLException ignore) {
            }
            if (statement != null) try {
                statement.close();
            } catch (SQLException ignore) {
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException ignore) {
            }
        }
        return user;
    }
}
