package validators.exceptions;
/*
@author Sergey Bugaienko
*/

public class AdminRequestDataError extends Exception{
    public AdminRequestDataError(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Ошибка ввода данных администратором | " + super.getMessage();
    }
}
