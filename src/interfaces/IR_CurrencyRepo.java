package interfaces;
/*
@author Sergey Bugaienko
*/

import model.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IR_CurrencyRepo {
    Currency getCurrencyByCode(String curCode);
    List<Currency> getAllCurrencies();
    Rate getCurrencyRate(String curCode);
    Rate getCurrencyRate(Currency currency);

    List<Rate> getRateHistory(String curCode);
    List<Rate> getRateHistory(Currency currency);

    void addRateToHistory(String curCode, Rate rate);
    void addRateToHistory(Currency currency, Rate rate);

    Map<String, Rate> getRates();

    Currency createNewCurrency(String code, String title, double rate);

    void deleteCurrencyFromDB(Currency currency);

    void setRate(Currency currency, double rate);
}
