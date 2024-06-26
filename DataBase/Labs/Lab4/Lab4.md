<head>
  <script src="https://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML" type="text/javascript"></script>
  <script type="text/x-mathjax-config">
    MathJax.Hub.Config({
      tex2jax: {
      skipTags: ['script', 'noscript', 'style', 'textarea', 'pre'],
      inlineMath: [['$','$']]
      }
    });
  </script>
</head>

## [MainPage](../../../index.md)/[DataBase](../../README.md)/Lab 4

<center>
<p>Университет ИТМО</p>
<p>Факультет ФПИ и КТ</p>
<br><br><br><br><br>
<h2>Отчёт по лабораторной работе 4</h2>
<h1>«Информационная система и база данных»</h1>
<h3>Вариант: 13180</h3>
</center>

<br><br><br><br><br><br><br><br><br><br><br><br>

<div align="right">Студент: Чжоу Хунсян</div>
<div align="right">Группа: P33131</div>
<div align="right">Преподаватель:</div>

- [1 Текст задания.](#1-текст-задания)
- [Запрос 1](#запрос-1)
  - [Выполнение](#выполнение)
  - [План](#план)
  - [Предложенные индексы](#предложенные-индексы)
- [Запрос 2](#запрос-2)
  - [Выполнение](#выполнение-1)
  - [План](#план-1)
  - [Предложенные индексы:](#предложенные-индексы-1)
- [Вывод](#вывод)


# 1 Текст задания.

**Задание.**

Составить запросы на языке SQL (пункты 1-2).  
在 SQL 中创建查询（步骤 1-2）。

Для каждого запроса предложить индексы, добавление которых уменьшит время выполнения запроса (указать таблицы/атрибуты, для которых нужно добавить индексы, написать тип индекса; объяснить, почему добавление индекса будет полезным для данного запроса).  
对于每个查询，建议索引，添加索引将减少查询执行时间（指定需要添加索引的表/属性，编写索引类型；解释为什么添加索引对此查询有用）。

Для запросов 1-2 необходимо составить возможные планы выполнения запросов. Планы составляются на основании предположения, что в таблицах отсутствуют индексы. Из составленных планов необходимо выбрать оптимальный и объяснить свой выбор.  
对于查询1-2，有必要制定可能的查询执行计划。 计划是基于表上没有索引的假设制定的。 您必须从制定的计划中选择最佳的一项并解释您的选择。

Изменятся ли планы при добавлении индекса и как?  
添加索引时计划是否会改变以及如何改变？

Для запросов 1-2 необходимо добавить в отчет вывод команды EXPLAIN ANALYZE [запрос]  
对于查询 1-2，您需要将 EXPLAIN ANALYZE [query] 命令的输出添加到报告中

Подробные ответы на все вышеперечисленные вопросы должны присутствовать в отчете (планы выполнения запросов должны быть нарисованы, ответы на вопросы - представлены в текстовом виде).  
报告中必须包含上述所有问题的详细答案（必须绘制查询执行计划，问题的答案必须以文本形式呈现）。

1. Сделать запрос для получения атрибутов из указанных таблиц, применив фильтры по указанным условиям:  
    Таблицы: Н_ЛЮДИ, Н_ВЕДОМОСТИ.  
    Вывести атрибуты: Н_ЛЮДИ.ИМЯ, Н_ВЕДОМОСТИ.ЧЛВК_ИД.  
    Фильтры (AND):  
    a) Н_ЛЮДИ.ИД = 152862.  
    b) Н_ВЕДОМОСТИ.ДАТА < 2022-06-08.  
    Вид соединения: RIGHT JOIN.  
2. Сделать запрос для получения атрибутов из указанных таблиц, применив фильтры по указанным условиям:  
    Таблицы: Н_ЛЮДИ, Н_ВЕДОМОСТИ, Н_СЕССИЯ.  
    Вывести атрибуты: Н_ЛЮДИ.ФАМИЛИЯ, Н_ВЕДОМОСТИ.ЧЛВК_ИД, Н_СЕССИЯ.ДАТА.  
    Фильтры (AND):  
    a) Н_ЛЮДИ.ИД > 152862.  
    b) Н_ВЕДОМОСТИ.ИД = 1250972.  
    c) Н_СЕССИЯ.ЧЛВК_ИД = 100012.  
    Вид соединения: LEFT JOIN.

# Запрос 1

## Выполнение

```SQL
SELECT "Н_ЛЮДИ"."ИМЯ", "Н_ВЕДОМОСТИ"."ЧЛВК_ИД" FROM "Н_ЛЮДИ"
RIGHT JOIN "Н_ВЕДОМОСТИ" on "Н_ЛЮДИ"."ИД" = "Н_ВЕДОМОСТИ"."ЧЛВК_ИД"
WHERE
    "Н_ЛЮДИ"."ИД" = 152862 AND
    "Н_ВЕДОМОСТИ"."ДАТА" < '2022-06-08';
```

Результат

```
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
Елена,152862
```

```SQL
EXPLAIN ANALYZE
SELECT "Н_ЛЮДИ"."ИМЯ", "Н_ВЕДОМОСТИ"."ЧЛВК_ИД" FROM "Н_ЛЮДИ"
RIGHT JOIN "Н_ВЕДОМОСТИ" on "Н_ЛЮДИ"."ИД" = "Н_ВЕДОМОСТИ"."ИД"
WHERE
    "Н_ЛЮДИ"."ИД" = 152862 AND
    "Н_ВЕДОМОСТИ"."ДАТА" < '2022-06-08';
```

Результат

```
Nested Loop  (cost=0.58..208.47 rows=64 width=17) (actual time=0.019..0.072 rows=43 loops=1)
"  ->  Index Scan using ""ЧЛВК_PK"" on ""Н_ЛЮДИ""  (cost=0.28..8.30 rows=1 width=17) (actual time=0.008..0.008 rows=1 loops=1)"
"        Index Cond: (""ИД"" = 152862)"
"  ->  Index Scan using ""ВЕД_ЧЛВК_FK_IFK"" on ""Н_ВЕДОМОСТИ""  (cost=0.29..199.53 rows=64 width=4) (actual time=0.009..0.056 rows=43 loops=1)"
"        Index Cond: (""ЧЛВК_ИД"" = 152862)"
"        Filter: (""ДАТА"" < '2022-06-08 00:00:00'::timestamp without time zone)"
Planning Time: 0.199 ms
Execution Time: 0.101 ms
```

## План

1. 
    $$\Pi_{Н\_ЛЮДИ.ИМЯ,\ Н\_ВЕДОМОСТИ.ЧЛВК\_ИД}\\
    |\\
    \sigma_{Н\_ЛЮДИ.ИД = 152862}\\
    |\\
    \sigma_{Н\_ВЕДОМОСТИ.ДАТА < '2022-06-08'}\\
    |\\
    \bowtie_{Н\_ЛЮДИ.ИД = Н\_ВЕДОМОСТИ}\\
    |\qquad\qquad\qquad\qquad|\\
    Н\_ЛЮДИ\qquad Н\_ВЕДОМОСТИ
    $$

2. 
    $$\Pi_{Н\_ЛЮДИ.ИМЯ,\ Н\_ВЕДОМОСТИ.ЧЛВК\_ИД}\\
    |\\
    \bowtie_{Н\_ЛЮДИ.ИД = Н\_ВЕДОМОСТИ}\\
    |\qquad\qquad\qquad\qquad\qquad|\\
    \sigma_{Н\_ЛЮДИ.ИД = 152862}\quad\sigma_{Н\_ВЕДОМОСТИ.ДАТА < '2022-06-08'}\\
    |\qquad\qquad\qquad\qquad\qquad\qquad\qquad|\\
    Н\_ЛЮДИ\qquad\qquad\qquad\quad Н\_ВЕДОМОСТИ
    $$

Воторой вариант лучше. Тут делать выборку раньше, благодаря которого уменьшает количество проверок в `join`. И он тоже является вариантом системы.

## Предложенные индексы

- В таблице `Н_ЛЮДИ` идет выборка столбцы `ИД`, поэтому можно создать hash index на `ИД`.
- В таблице `Н_ВЕДОМОСТИ` идет сравнение столбцы `ДАТА`. Поэтому можно создать b-tree index на `ДАТА`.

# Запрос 2

## Выполнение

```SQL
SELECT "Н_ЛЮДИ"."ФАМИЛИЯ", "Н_ВЕДОМОСТИ"."ЧЛВК_ИД", "Н_СЕССИЯ"."ДАТА" FROM "Н_ЛЮДИ"
LEFT JOIN "Н_ВЕДОМОСТИ" on "Н_ЛЮДИ"."ИД" = "Н_ВЕДОМОСТИ"."ЧЛВК_ИД"
LEFT JOIN "Н_СЕССИЯ" on "Н_ЛЮДИ"."ИД" = "Н_СЕССИЯ"."ЧЛВК_ИД"
WHERE
    "Н_ЛЮДИ"."ИД" > 152862 AND
    "Н_ВЕДОМОСТИ"."ИД" = 1250972 AND
    "Н_СЕССИЯ"."ЧЛВК_ИД" = 100012;
```

Результат

```

```

```SQL
EXPLAIN ANALYZE
SELECT "Н_ЛЮДИ"."ФАМИЛИЯ", "Н_ВЕДОМОСТИ"."ЧЛВК_ИД", "Н_СЕССИЯ"."ДАТА" FROM "Н_ЛЮДИ"
LEFT JOIN "Н_ВЕДОМОСТИ" on "Н_ЛЮДИ"."ИД" = "Н_ВЕДОМОСТИ"."ЧЛВК_ИД"
LEFT JOIN "Н_СЕССИЯ" on "Н_ЛЮДИ"."ИД" = "Н_СЕССИЯ"."ЧЛВК_ИД"
WHERE
    "Н_ЛЮДИ"."ИД" > 152862 AND
    "Н_ВЕДОМОСТИ"."ИД" = 1250972 AND
    "Н_СЕССИЯ"."ЧЛВК_ИД" = 100012;
```

Результат

```
Nested Loop  (cost=5.03..39.98 rows=6 width=28) (actual time=0.035..0.036 rows=0 loops=1)
  ->  Nested Loop  (cost=0.70..16.75 rows=1 width=24) (actual time=0.034..0.035 rows=0 loops=1)
"        ->  Index Scan using ""ЧЛВК_PK"" on ""Н_ЛЮДИ""  (cost=0.28..8.30 rows=1 width=20) (actual time=0.018..0.019 rows=1 loops=1)"
"              Index Cond: ((""ИД"" < 152862) AND (""ИД"" = 100012))"
"        ->  Index Scan using ""ВЕД_PK"" on ""Н_ВЕДОМОСТИ""  (cost=0.42..8.44 rows=1 width=4) (actual time=0.014..0.014 rows=0 loops=1)"
"              Index Cond: (""ИД"" = 1250972)"
"              Filter: (""ЧЛВК_ИД"" = 100012)"
              Rows Removed by Filter: 1
"  ->  Bitmap Heap Scan on ""Н_СЕССИЯ""  (cost=4.33..23.17 rows=6 width=12) (never executed)"
"        Recheck Cond: (""ЧЛВК_ИД"" = 100012)"
"        ->  Bitmap Index Scan on ""SYS_C003500_IFK""  (cost=0.00..4.33 rows=6 width=0) (never executed)"
"              Index Cond: (""ЧЛВК_ИД"" = 100012)"
Planning Time: 0.213 ms
Execution Time: 0.074 ms
```

## План

1. 
    $$\Pi_{Н\_ЛЮДИ.ФАМИЛИЯ,\ Н\_ВЕДОМОСТИ.ЧЛВК\_ИД, Н\_СЕССИЯ.ДАТА}\\
    |\\
    \sigma_{Н\_ЛЮДИ.ИД \gt 152862}\\
    |\\
    \sigma_{Н\_ВЕДОМОСТИ.ИД = 1250972}\\
    |\\
    \sigma_{Н\_СЕССИЯ.ЧЛВК\_ИД = 100012}\\
    |\\
    \bowtie_{Н\_ЛЮДИ.ИД = Н\_СЕССИЯ}\\
    |\qquad\qquad\qquad\qquad\qquad|\\
    \bowtie_{Н\_ЛЮДИ.ИД = Н\_ВЕДОМОСТИ.ЧЛВК\_ИД}\quad Н\_СЕССИЯ\\
    |\qquad\qquad\qquad\qquad|\qquad\qquad\qquad\\
    Н\_ЛЮДИ\qquad Н\_ВЕДОМОСТИ\qquad\qquad\qquad\\
    $$

2. 
    $$\Pi_{Н\_ЛЮДИ.ФАМИЛИЯ,\ Н\_ВЕДОМОСТИ.ЧЛВК\_ИД, Н\_СЕССИЯ.ДАТА}\\    
    |\\
    \bowtie_{Н\_ЛЮДИ.ИД = Н\_СЕССИЯ}\\
    |\qquad\qquad\qquad\qquad\qquad|\\
    \bowtie_{Н\_ЛЮДИ.ИД = Н\_ВЕДОМОСТИ.ЧЛВК\_ИД}\quad \sigma_{Н\_СЕССИЯ.ЧЛВК\_ИД = 100012}\\
    |\qquad\qquad\qquad\qquad|\qquad\qquad\qquad\qquad\qquad|\\
    \sigma_{Н\_ЛЮДИ.ИД \gt 152862}\qquad\sigma_{Н\_ВЕДОМОСТИ.ИД = 1250972}\qquadН\_СЕССИЯ\\
    |\qquad\qquad\qquad\qquad|\qquad\qquad\qquad\\
    Н\_ЛЮДИ\qquad Н\_ВЕДОМОСТИ\qquad\qquad\qquad\\
    $$

Воторой вариант лучше. Как первый запрос, тут тоже делать выборку раньше, благодаря которого уменьшает количество проверок в `join`. И он тоже является вариантом системы.

## Предложенные индексы:
- В таблице `Н_ЛЮДИ` идет сравнение столбцы `ИД`, поэтому можно создать b-tree index на `ИД`.
- В таблице `Н_ВЕДОМОСТИ` идет выборка столбцы ИД. Поэтому можно создать hash index на ИД.
- В таблице `Н_СЕССИЯ` идет выборка столбцы `ЧЛВК_ИД`. Поэтому можно создать hash index на `ЧЛВК_ИД`.

При добовалении индекса структура плана не изменяется, но его реализации изменяется. Например, если добавим hash индекс в первую таблицу, тут структура план будет как текущая, но Nested Loop будет меняется Hash Join.

# Вывод
