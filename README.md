# Домашнее задание 2

## Задание 1 (ответ на вопрос):
- Бин, созданный через Dependency Injection, является Singleton(создаётся один раз и живёт пока живёт контекст) 
- Dependency LookUp позволяет создавать бин, который может умирать и создаваться несколько раз во время сессии
## Задание 2
Внедрение через @LookUp сделано в класса School и Student
## Задание 3
Внедрение через ApplicationContext реализовано в ScopeController.

RequestScope создаёт столько бинов, сколько у нас HTTP запросов.
Lockup создаёт бин при обращении


