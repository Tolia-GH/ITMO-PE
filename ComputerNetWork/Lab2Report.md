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

## [MainPage](../../../index.md)/[DataBase](../../README.md)/Lab 1

<center>
<p>Университет ИТМО<br>Факультет ФПИ и КТ</p>
<br><br><br><br><br><br>
<h2>Отчёт по лабораторной работе 1</h2>
<h1>«Компьютерные сети»</h1>
</center>

<br><br><br><br><br><br><br><br><br><br>

<div align="right">Студент: Чжоу Хунсян</div>
<div align="right">Группа: P33131</div>
<div align="right">Преподаватель:</div>

<center>
<br><br>
<p>Санкт-Петербург 2024</p>
<br>
</center>

---

> Вариант: 24
> Количество компьютеро в сети 1 (N1): 4 
> Количество компьютеро в сети 2 (N1): 3 
> Количество компьютеро в сети 3 (N1): 2 
> Класс IP-адресов: В
> IP : 165.31.35.10

## 1. ЦЕЛЬ РАБОТЫ

Изучение принципов настройки и функционирования локальных сетей, построенных с использованием концентраторов и коммутаторов, а также процессов передачи данных на основе стека протоколов TCP/IP, с использованием программы моделирования компьютерных сетей NetEmul.  

В процессе выполнения лабораторной работы (ЛР) необходимо:  
在进行实验室工作（LP）的过程中，有必要：

- построить модели трёх локальных сетей:  
  1) односегментной сети с использованием концентратора,  
  2) односегментной сети с использованием коммутатора;  
  3) многосегментной локальной сети;  
- выполнить настройку сети, заключающуюся в присвоении IP-адресов интерфейсам сети;  
- выполнить тестирование разработанных сетей путем проведения экспериментов по передаче данных (пакетов и кадров) на основе протоколов UDP и TCP;  
- проанализировать результаты тестирования и сформулировать выводы об эффективности смоделированных вариантов построения локальных сетей;  
- сохранить разработанные модели локальных сетей для демонстрации процессов передачи данных при защите лабораторной работы.  

### Этап 1. Локальная сеть с концентратором (Сеть 1) 

1. Построение сети с концентратором.

   ![](./pic/Lab2Report1-1.png)

   PC 1

   ![](./pic/Lab2Report1-2.png)

   ![](./pic/Lab2Report1-3.png)

   PC 2

   ![](./pic/Lab2Report1-4.png)

   ![](./pic/Lab2Report1-5.png)

   PC 3

   ![](./pic/Lab2Report1-6.png)

   ![](./pic/Lab2Report1-7.png)

   PC 4

   ![](./pic/Lab2Report1-8.png)

   ![](./pic/Lab2Report1-9.png)

2. Настройка компьютеров.
   
   ![](./pic/Lab2Report2-1.png)

   ![](./pic/Lab2Report2-2.png)

   ![](./pic/Lab2Report2-3.png)

   ![](./pic/Lab2Report2-4.png)

   ![](./pic/Lab2Report2-5.png)

3. **Анализ таблиц**  

   PC 1

   ![](./pic/Lab2Report3-1.png)

   ![](./pic/Lab2Report3-2.png)

   PC 2

   ![](./pic/Lab2Report3-3.png)

   ![](./pic/Lab2Report3-4.png)

   PC 3

   ![](./pic/Lab2Report3-5.png)

   ![](./pic/Lab2Report3-6.png)

   PC 4

   ![](./pic/Lab2Report3-7.png)

   ![](./pic/Lab2Report3-8.png)

4. **Тестирование сети (отправка пакетов)**.

   UDP (PC 1 -> PC 4)

   ![](./pic/Lab2Report4-1.png)

   TCP (PC 2 -> PC 3)

   ![](./pic/Lab2Report4-2.png)

### Этап 2. Локальная сеть с коммутатором (Сеть 2) 

5. Построение локальной сети с коммутатором. 
   
   ![](./pic/Lab2Report5-1.png)

   ![](./pic/Lab2Report5-2.png)

6. **Анализ таблиц**. 

   PC 1

   ![](./pic/Lab2Report6-1.png)

   ![](./pic/Lab2Report6-2.png)

   PC 2

   ![](./pic/Lab2Report6-3.png)

   ![](./pic/Lab2Report6-4.png)

   PC 3

   ![](./pic/Lab2Report6-5.png)

   ![](./pic/Lab2Report6-6.png)

7. **Тестирование сети (отправка пакетов)**.  

   UDP (PC 1 -> PC 2)

   ![](./pic/Lab2Report7-1.png)

   TCP

   ![](./pic/Lab2Report7-2.png)

### Этап 3. Многосегментная локальная сеть (Сеть 3) 

8. Формирование сети.  

9. Тестирование сети (отправка пакетов).  

   UDP (PC 1 -> PC 8)

   TCP (PC 1 -> PC 9)