package DAO;

import Entity.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_incubator";


    static final String USER = "root";
    static final String PASSWORD = "12345";


    public List<Account> list() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Account> accounts = new ArrayList<Account>();

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.prepareStatement("SELECT  * FROM account");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Account account = new Account();
                account.setAccount_Id(resultSet.getInt("account_id"));
                account.setAccount(resultSet.getInt("account"));
                account.setUser_Id(resultSet.getInt("user_id"));
                accounts.add(account);
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
        return accounts;
    }
}