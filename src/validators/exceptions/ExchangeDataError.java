package validators.exceptions;
/*
@author Sergey Bugaienko
*/

public class ExchangeDataError extends Exception{

    public ExchangeDataError(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Ошибка ввода данных для обмена валюты | " +  super.getMessage();
    }
}
