### Название проекта:
"Обменный пункт валюты"

**Описание проекта:**
Разработать консольное приложение для имитации работы обменного пункта валюты.
Пользователи могут регистрировать аккаунты, открывать счета в различных валютах, пополнять счета, осуществлять обмен валюты, а также просматривать историю своих операций.

**Техническое задание:**

1. Создать класс `User`, который будет хранить:
    - Имя пользователя.
    - HashMap счетов валют (`accounts`), где ключ - код валюты (String), значение - объект типа `Account`.

2. Создать класс `Account`, который будет хранить:
    - Баланс счета (`balance`).
    - Валюту счета (`currency`).
    - Историю операций (`operationsHistory`), которая является коллекцией объектов типа `Operation`.

3. Создать класс `Operation`, который будет хранить:
    - Тип операции (`type`).
    - Сумму операции (`amount`).
    - Валюту операции (`currency`).
    - Дату операции (`date`).
    - Курс валюты на момент операции (`rate`).

4. Создать класс `ExchangeRate`, который будет хранить курсы валют.
5. Курсы валют хранятся в HashMap, где ключ - код валюты, значение - текущий курс к евро.

5. Реализовать консольное меню с следующими функциями:
    - Регистрация нового пользователя.
    - Вход в аккаунт.
    - Просмотр баланса.
    - Пополнение счета в выбранной валюте.
    - Открытие нового счета в выбранной валюте.
    - Обмен валюты.
    - Просмотр истории операций.

6. Реализовать JUnit тесты для проверки функциональности (покрыть сервисный слой).

**Опционально:**
1. Возможность сохранения данных пользователя в файл и загрузки из файла.
2. Установка лимита на обмен валюты.
3. Просмотр курса валюты за определенный период времени.