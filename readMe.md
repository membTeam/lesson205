# (12.10.2023) Домашнее задание 2.5

## Проект выполнен на основе Spring Data JDBC

### Общее описание
- Для сокращение кода использована утилита lombok
- ВСЕ методы, согласно задания, реализованы на уровне EmploeeRepostory
- Структура проекта
  - models.Emploee бизнес модель, с которой выполняются ВСЕ действия
  - repositories.EmploeeRepositories интерфейс репозитория
  - service.* 
    - классы исключений (RintimeException)
    - EmploeeService интерфейс сервиса контроллера
    - EmploeeServiceImpl реализация интерфейса
  - web.*Controller контроллеры
    - HomeController (для доступа к БД H2:  localhost:8080/h2-console)
    - EmploeeController контроллер REST api
  - configProject.*
    - ConfigProject конфигурирование допустимого размера списка сотрудников
    - GenerationId интерфейс for Emploee (для заполнения id во время записи)
    - PersistenceConfig класс конфигурации во время заполнения БД
  - EmploeeTesting тестирование базовых операций с репозиторием
    