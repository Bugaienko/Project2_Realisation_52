package interfaces;
/*
@author Sergey Bugaienko
*/

import model.Account;
import model.Currency;
import model.Operation;
import model.User;

import java.util.List;
import java.util.Optional;

public interface IR_AccountRepo {
    Account createAccount(User user, Currency currency);

    List<Account> getAllUsersAccounts(User user); // или id?

    boolean deleteAccount(User user, Account account);

    Optional<Account> getUserAccountByCurrency(User user, Currency currency);

    boolean applyOperation(Account account, Operation operation);

    List<Operation> getHistory(Account account);

    boolean isAccountExist(User user, Currency currency);


    List<User> getAllUsersWithAccountByCurrency(Currency currency);

    List<Account> getAllAccountsByCurrency(Currency currency);
}
