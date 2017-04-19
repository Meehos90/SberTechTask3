# language: ru


Функция: Огуречные тесты

Сценарий: Поиск ноутбука
    Дано открываем сайт yandex.ru
    Тогда выбираем пункт меню
    |Маркет|
    |Компьютеры|
    |Ноутбуки|
    |Перейти ко всем фильтрам|
    Тогда в поле с ценой до вводим значение "30000"
    И в блоке Производитель выбираем чекбоксы
    |HP|
    |Lenovo|
    И нажимаем кнопку "Показать подходящие"
    Тогда проверяем что количество товаров равно "12"
    И вводим название первого товара в поле поиска
    И нажимаем кнопку "Найти" для поиска
    Тогда в результатах поиска сравниваем названия товаров

Сценарий: Поиск планшета
    Дано открываем сайт yandex.ru
    Тогда выбираем пункт меню
    |Маркет|
    |Компьютеры|
    |Планшеты|
    |Перейти ко всем фильтрам|
    Тогда в поле с ценой от вводим значение "20000"
    Тогда в поле с ценой до вводим значение "25000"
    И в блоке Производитель выбираем чекбоксы
    |Acer|
    |DELL|
    И нажимаем кнопку "Показать подходящие"
    Тогда проверяем что количество товаров равно "12"
    И вводим название первого товара в поле поиска
    И нажимаем кнопку "Найти" для поиска
    Тогда в результатах поиска сравниваем названия товаров