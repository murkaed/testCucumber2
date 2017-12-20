# language: ru

Функционал: СУА/базовый функционал №1

  @1
  Сценарий: Создание нового актива для ФО типа КО

    Дано пользователь открывает сайт
    И пользователь вводит валидные "sua_all" и "Q1w2e3r4"
    И пользователь нажимает кнопку "Войти"
    И пользователь выбирает ФО типа "КО"

    И пользователь нажимает кнопку "Сбор и ведение данных" и выбирает создание актива
    И пользователь проверяет наличие надписи "Список активов"
    И пользователь нажимает кнопку "Создать"
    И пользователь выбирает в выпадающем списке "Ссудная и приравненная к ней задолженность"
    И пользователь нажимает кнопку "Далее"
    И пользователь проверяет наличие необходимых закладок на форме "карточка актива"
      | Основная информация |
      | Приём               |
      | План работы         |
      | Судебная работа     |
      | Инвентаризация      |
      | Хранение            |
      | Аренда              |
      | Оценка              |
      | Реализация          |
      | Списание            |
      | Утилизация          |
      | Связи с активами    |
      | Вовлечённые стороны |
    И пользователь заполняет все необходимые поля валидными данными
      | 61401484848484848484 |
      | 6140008              |
      | 614008               |
      | 614008               |
    И проверка на автозаполнение поля "Текущая балансовая стоимость"
    И пользователь жмет кнопку "Номер кредитного договора"


