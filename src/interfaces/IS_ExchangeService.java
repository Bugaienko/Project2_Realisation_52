package interfaces;
/*
@author Sergey Bugaienko
*/

import model.Currency;
import model.User;
import validators.exceptions.ExchangeDataError;

public interface IS_ExchangeService {

    boolean exchangeCurrency(User user, Currency currencySell, Currency currencyBuy, double amount, boolean isConfirmed) throws ExchangeDataError;
    boolean deposit(User user, Currency currency, double amount);


}
