package Services;

import DAO.UserDao;
import Entity.User;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public List<User> list() throws SQLException {
        return userDao.list();
    }

    public User getUserBy_Id(int id) throws SQLException {
        return userDao.getUserBy_Id(id);
    }

    public User getRichestUser() throws  SQLException {
        return userDao.getRichestUser();
    }
}
