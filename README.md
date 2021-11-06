
# Домашнее задание к занятию «2.1. Servlet Containers»

## CRUD

### Легенда

В рамках лекции мы реализовали практически полноценный In-Memory CRUD (Create Read Update Delete) сервер на базе сервлетов. Этому серверу не хватает двух вещей:
1. Причесать код (вынести методы в константы, убрать дублирующийся код)
1. Реализовать репозиторий (пока вместо репозитория установлена заглушка)

### Задача

1. Осуществите рефакторинг кода
1. Реализуйте репозиторий с учётом того, что методы репозитория могут вызываться конкурентно (т.е. в разных потоках)

Как должен работать `save`:
1. Если от клиента приходит пост с id = 0, значит это создание нового поста - вы сохраняете его в списке и присваиваете ему новый id (достаточно хранить счётчик с целым числом и увеличивать на 1 при создании каждого нового поста)
1. Если от клиента приходит пост с id != 0, значит это сохранение (обновление) существующего поста - вы ищете его в списке по id и обновляете (продумайте самостоятельно, что вы будете делать, если поста с таким id не оказалось: здесь могут быть разные стратегии)

### Результат

В качестве результата пришлите ссылку на ваш GitHub репозиторий в личном кабинете студента на сайте [netology.ru](https://netology.ru).
