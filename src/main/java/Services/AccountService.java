package Services;

import DAO.AccountDao;
import Entity.Account;
import java.sql.SQLException;
import java.util.List;

public class AccountService {
    private AccountDao accountDao = new AccountDao();

    public List<Account> list() throws SQLException {
        return accountDao.list();
    }
}
