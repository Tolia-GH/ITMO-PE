Dima, [Oct 2, 2024 at 21:21:21]:
РК РСХД:

1) WAL/Cluster
2) ROLE/REVOKE
3) Существуют 3 роли student1, student2, teacher. 
Также существуют 2 схемы: test, studs. 
В схеме studs 2 таблицы: 
- Exams
- Groups
В схеме test:
- Exams

У пользователей student1, student2 нет прав на изменения каких-либо таблиц.
Пользователь teacher может добавлять данные в таблицы (возможно было в какие-то конкретные).

Задание
Напишите код который:

Вариант 1:
БД Education
Вариант 1:
-У student1 и student2 есть права на изменения таблицы studs.Exams
-у student1 есть права на изменения таблицы studs.Group (у student2 их нет)
-Подключение по tcp/ip, по имени пользователя

Вариант 2:

* выдавать права напрямую нельзя


БД Education
...

БД Education
Вариант 1:
-У student1 и student2 есть права на изменения таблицы studs.Exams
-у student1 есть права на изменения таблицы studs.Group (у student2 их нет)
-Подключение по tcp/ip, по имени пользователя