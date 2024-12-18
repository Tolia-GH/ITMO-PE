# Криптографические системы с секретным ключом

## Лабораторная работа № 1 <br> 实验一: <br> Основы шифрования данных <br> 数据加密基础

### Цель работы: <br> 实验目的：

изучение основных принципов шифрования информации, знакомство с широко известными алгоритмами шифрования, приобретение навыков их программной реализации.  
学习信息加密的基本原理，了解广泛使用的加密算法，掌握其编程实现技能。

### Порядок выполнения работы <br> 实验步骤：

1. Ознакомьтесь с теоретическими основами шифрования данных, которые приведены в [1] и [2].  
   熟悉理论加密基础，参阅文献[1]和[2]。
2. Получите вариант задания у преподавателя.  
   向老师获取实验任务。
3. Напишите программу согласно варианту задания.  
   根据任务要求编写程序。
4. Отладьте разработанную программу и покажите результаты работы программы преподавателю.  
   调试开发的程序，并将程序结果展示给老师。
5. Составьте отчет по лабораторной работе.  
   编写实验报告。

### Содержание отчета <br> 实验报告内容：

Отчет по лабораторной работе должен содержать следующие сведения:  
实验报告应包含以下内容：
- название и цель работы;  
  实验名称和目的；
- вариант задания;  
  实验任务；
- листинг разработанной программы с комментариями;  
  带注释的程序代码；
- результаты работы программы.  
  程序运行结果。

### Варианты заданий <br> 实验任务选项：

1. Реализовать в программе шифрование и дешифрацию содержимого файла по методу Цезаря с ключевым словом.  
   使用关键字实现凯撒加密法对文件内容的加密和解密。
2. Реализовать шифрование и дешифрацию файла по методу Виженера. Ключевая фраза вводится. Реализовать в программе частотный криптоанализ зашифрованного текста.  
   实现维吉尼亚加密法对文件的加密和解密。密钥短语由用户输入。实现加密文本的频率密码分析。
3. Реализовать шифрование и дешифрацию файла с использованием метода биграмм. Ключевое слово вводится.  
   使用双字母加密法实现文件的加密和解密。密钥短语由用户输入。
4. Реализовать в программе шифрование и дешифрацию файла с использованием квадрата Полибия, обеспечив его случайное заполнение.  
   使用随机生成的波利比奥方阵，实现文件加密和解密。
5. Реализовать в программе шифрование и дешифрацию файла с использованием квадрата Кардано размером 4х4.  
   使用4x4的卡尔达诺方阵，实现文件的加密和解密。
6. Реализовать в программе шифрование и дешифрацию файла методом биграмм с двойным квадратом. Квадраты генерировать динамически для каждого шифрования.  
   使用双方阵双字母加密法，实现文件加密和解密。每次加密动态生成方阵。
7. Реализовать в программе шифрование и дешифрацию файла с использованием перестановочного шифра с ключевым словом. Ключевое слово вводится.  
   使用关键字的置换密码法，实现文件加密和解密。密钥短语由用户输入。
8. Реализовать в программе шифрование и дешифрацию файла с использованием аффинной криптосистемы. Провести частотный анализ зашифрованного файла, осуществляя проверку по файлу с набором ключевых слов.  
   使用仿射密码系统实现文件加密和解密。对加密文件进行频率分析，并用关键词文件进行校验。
9.  Реализовать шифрование и дешифрацию файла по методу Виженера с составным ключом. Набор ключей вводится.  
    使用复合密钥的维吉尼亚加密法，实现文件加密和解密。密钥由用户输入。
10. Реализовать в программе шифрование и дешифрацию\ содержимого файла по методу Цезаря. Провести частотный анализ зашифрованного файла, осуществляя проверку по файлу с набором ключевых слов.  
    使用凯撒加密法实现文件加密和解密。对加密文件进行频率分析，并用关键词文件进行校验。

### Контрольные вопросы <br> 控制问题：

1. Дайте определение следующим понятиям: шифр, криптография, криптоанализ, ключ.  
   给出以下术语的定义：密码、密码学、密码分析、密钥。
2. Классифицируйте алгоритм, полученный в качестве задания к лабораторной работе.  
   对实验任务中的算法进行分类。
3. Чем отличаются одно- и многоалфавитные методы шифрования?  
   单字母加密和多字母加密方法有何区别？
4. В чем заключается основной принцип частотного криптоанализа?  
   频率密码分析的基本原理是什么？
5. Какой метод криптоанализа применим для вскрытия алгоритма, полученного вами в качестве задания к лабораторной работе?  
   针对实验任务中的算法，适用哪种密码分析方法？
6. Оцените мощность ключевого пространства вашего алгоритма.  
   评估你所用算法的密钥空间大小。

## Лабораторная работа № 2 Блочное симметричное шифрование

### Цель работы:

изучение структуры и основных принципов работы современных алгоритмов блочного симметричного шифрования, приобретение навыков программной реализации блочных симметричных шифров.  
研究现代分组对称加密算法的结构和基本操作原理，获得分组对称密码的软件实现技能。

### Порядок выполнения работы

1. Ознакомьтесь с теоретическими основами шифрования данных, которые приведены в [1] и [2].  
   熟悉[1]和[2]中给出的数据加密的理论基础。
2. Получите вариант задания у преподавателя.  
   从老师那里获取作业版本。
3. Напишите программу согласно варианту задания.  
   根据作业选项编写程序。
4. Отладьте разработанную программу и покажите результаты работы программы преподавателю.  
   调试开发的程序并向老师展示程序结果。
5. Составьте отчет по лабораторной работе.  
   撰写实验报告。

### Содержание отчета

Отчет по лабораторной работе должен содержать следующие сведения:  
实验室报告必须包含以下信息：
- название и цель работы;  
  作品的标题和目的；
- вариант задания;  
  任务选项；
- листинг разработанной программы с комментариями;  
  列出已开发的程序并附有评论；
- результаты работы программы.  
  计划的结果。

### Варианты заданий

Реализовать систему симметричного блочного шифрования, позволяющую шифровать и дешифровать файл на диске с использованием заданного блочного шифра в заданном режиме шифрования. Перечень блочных шифров и режимов шифрования приведен в таблице. Номер шифра и режима для реализации получить у преподавателя.  
实现对称块加密系统，允许您在给定的加密模式下使用给定的块密码来加密和解密磁盘上的文件。表中给出了分组密码和加密模式的列表。代码编号和实现方式可以向老师索取。

Таблица. Варианты заданий к лабораторной работе  
桌子。实验室工作的选择

![](./pic/Encript_Labs2-1.png)

### Контрольные вопросы

1. Перечислите основные обратимые операции, используемые в образующих функциях блочных шифров.  
   列出分组密码生成函数中使用的主要可逆运算。
2. Что такое сеть Фейштеля? В чем ее основные достоинства?  
   什么是Feishtel网络？它的主要优点是什么？
3. Какие параметры блочных шифров влияют на его криптостойкость?  
   分组密码的哪些参数会影响其密码强度？
4. Какие блочные шифры, построенные по принципу сети Фейштеля, вам известны?  
   你知道哪些基于Feishtel网络原理构建的分组密码？
5. Проведите сравнительный анализ алгоритмов ГОСТ 28147-89 и Rijndael.  
   对GOST 28147-89和Rijndael算法进行对比分析。
6. Проведите сравнительный анализ режимов шифрования CBC и ECB.  
   对CBC和ECB加密模式进行对比分析。
7. Проведите сравнительный анализ режимов шифрования CBC и CFB  
   对CBC和CFB加密模式进行对比分析

## Лабораторная работа № 3  <br> Поточное симметричное шифрование 

### Цель работы: 

изучение структуры и основных принципов работы современных алгоритмов поточного симметричного шифрования, приобретение навыков программной реализации поточных симметричных шифров.  
研究现代流对称加密算法的结构和基本工作原理，获得流对称密码的软件实现技能。

### Порядок выполнения работы 

1. Ознакомьтесь с теоретическими основами шифрования данных, которые приведены в [1] и [2].  
   熟悉[1]和[2]中给出的数据加密的理论基础。
2. Получите вариант задания у преподавателя.  
   从老师那里获取作业版本。
3. Напишите программу согласно варианту задания.  
   根据作业选项编写程序。
4. Отладьте разработанную программу и покажите результаты работы программы преподавателю.  
   调试开发的程序并向老师展示程序结果。
5. Составьте отчет по лабораторной работе  
   撰写实验报告

### Содержание отчета 

Отчет по лабораторной работе должен содержать следующие сведения:  
实验室报告必须包含以下信息：
- название и цель работы;  
  作品的标题和目的；
- вариант задания;  
  任务选项；
- листинг разработанной программы с комментариями;  
  列出已开发的程序并附有评论；
- результаты работы программы.  
  计划的结果。

### Варианты заданий 

1. Реализовать в программе поточное кодирование текста, вводимого с клавиатуры, с помощью заданной нелинейной схемы, испльзующей дополнительные ячейки памяти РС.  
   使用使用附加 PC 存储单元的给定非线性电路，在程序中实现从键盘输入的文本的流编码。

![](./pic/Encript_Labs3-1.png)

2. Реализовать в программе поточное кодирование текста, вводимого с клавиатуры, с помощью заданной нелинейной схемы РС с управляемым тактированием.  
   使用具有受控时钟的给定非线性 PC 电路，在程序中实现从键盘输入的文本的流编码。

![](./pic/Encript_Labs3-2.png)

3. Реализовать в программе поточное кодирование текста, вводимого с клавиатуры, с помощью заданной нелинейной схемы РС.  
   使用给定的非线性PC电路在程序中实现从键盘输入的文本的流编码。

![](./pic/Encript_Labs3-3.png)

Контрольные вопросы 

1. Какие методы формирования потока ключей для поточных шифров вам известны? 
2. Что такое регистр сдвига с линейной обратной связью? 
3. Каков критерий оптимальности структуры регистра сдвига с линейной обратной связью? 
4. Для чего регистры сдвига с линейной обратной связью объединяют в нелинейные схемы подключения? 
5. Что такое проблемы линейной сложности и корреляционной связи схем, использующих сдвиговые регистры с линейной обратной связью? 
6. Объясните принцип работы сдвигового регистра с обратной связью по переносу. 
7. Каков критерий оптимальности структуры регистра сдвига с обратной связью по переносу?

## Лабораторная работа № 1 <br> Атака на алгоритм шифрования RSA посредством метода Ферма 

### Цель работы: 

изучить атаку на алгоритм шифрования RSA посредством метода Ферма.  
研究使用 Fermat 方法对 RSA 加密算法的攻击。

Порядок выполнения работы: 

- ознакомьтесь с теорией, изложенной в [3]. («Взлом алгоритма RSA при неудачном выборе параметров криптосистемы»);  
  熟悉[3]中概述的理论。 （“通过选择不成功的密码系统参数来破解 RSA 算法”）；
- получите вариант задания у преподавателя;  
  从老师那里获取作业版本；
- используя разложение модуля на простые числа методом Ферма и полученные исходные данные, определите следующие показатели:  
  利用费马方法将模分解为素数以及得到的初始数据，确定以下指标：
- множители модуля ($p$ и $q$);  
  模量因子（$p$ 和 $q$）；
- значение функции Эйлера для данного модуля $\varphi(N)$;  
  给定模块 $\varphi(N)$ 的欧拉函数值；
- обратное значение экспоненты по модулю $\varphi(N)$;  
  指数模 $\varphi(N)$ 的倒数；
- дешифруйте зашифрованный текст, исходный текст должен быть фразой на русском языке;  
  解密密文，原文必须是俄语短语；
- результаты и промежуточные вычисления оформите в виде отчета.  
  以报告的形式呈现结果和中间计算。

Примечание. Для выполнения практического задания рекомендуется использовать программу BCalc.exe.  
笔记。为了完成实际任务，建议使用BCalc.exe程序。

Пример выполнения лабораторной работы c помощью программы BCalc  
使用 BCalc 程序执行实验室工作的示例

Исходные данные: N = 65815671868057; e = 7423489; C = 38932868535359. Найти  
源数据：N=65815671868057； e = 7423489； C = 38932868535359。查找  

1. Вычисляем n = [sqrt(N)] + 1. В поле A помещаем N, в поле B - 2; нажимаем кнопку «D = A^(1/B)». В поле D заносится число 8112686, в первую строку таблицы - сообщение «[error]». Это свидетельствует, о том, что N не является квадратом целого числа.  
   计算n = [sqrt(N)] + 1。将N放入字段A，2放入字段B；按“D = A^(1/B)”按钮。在字段 D 中输入数字 8112686，并在表的第一行中输入消息“[错误]”。这表明 N 不是整数的平方。
2. t1 = n + 1. Возводим число t1 в квадрат: A: = 8112687, B: = 2, C: = 0 (возведение в квадрат будет производиться не по правилам модульной арифметики), нажимаем «D = A^B mod C» => D = t1^2 = 65815690359969. Вычисляем w1 = t1^2 - N. Для этого A:= t1^2, B:= –N, затем нажимаем «D = A + B» => D = w1 = 18491912. Проверяем, является ли w1 квадратом целого числа: A:= w1, B:= 2, нажимаем «D = A^(1/B)» => в первой строке таблицы появляется сообщение «[error]», следовательно проделываем п. 2 заново с t2 = n + 2 и так далее, пока не найдем, что некое wi является квадратом целого числа.  
   t1 = n + 1. 对数 t1 求平方：A: = 8112687, B: = 2, C: = 0（根据模运算规则不会平方），按“D = A^B mod C " => D = t1^2 = 65815690359969。计算 w1 = t1^2 - N。对于这个 A:= t1^2, B:= –N，然后按“D = A + B” => D = w1 = 18491912。检查 w1 是否是整数的平方：A:= w1, B:= 2，按“D = A^(1/B)” => 消息“[error]”出现在表的第一行，因此我们再次执行步骤 2，t2 = n + 2 依此类推，直到我们发现某个 wi 是一个整数的平方。
3. При вычислении квадратного корня w5 первая строка таблицы остается пустой, а D = sqrt(w5) = 9132, что свидетельствует об успехе факторизации. t5 = 8112691.  
   计算w5的平方根时，表格第一行保持为空，D = sqrt(w5) = 9132，表示因式分解成功。 t5 = 8112691。
4. Вычисляем p = t5 + sqrt(w5); A:= t5, B:= sqrt(w5), нажимаем «D = A + B»  => D = p = 8121823; q = t5 - sqrt(w5) = 8103559. Вычисляем Phi(N) = (p - 1)(q - 1), A:= 8121822, B:= 8103558, нажимаем «D = A∙B» => D = = Phi(N) = 65815655642676. Вычисляем d, как обратный к e: A:= e, B:= –1, C:= Phi(N), нажимаем «D = A^B mod C» => D = d = 12490789985101.  
   计算p = t5 + sqrt(w5)； A:= t5, B:= sqrt(w5)，按“D = A + B” => D = p = 8121823； q = t5 - sqrt(w5) = 8103559. 计算 Phi(N) = (p - 1)(q - 1), A:= 8121822, B:= 8103558，按“D = A∙B” => D = = Phi(N) = 65815655642676。我们将 d 计算为e 的逆：A:= e, B:= –1, C:= Phi(N)，按“D = A^B mod C” => D = d = 12490789985101。
5. Производим дешифрацию шифрблока С: A:= C; B:= d; C:= N. Нажимаем «D = A^B mod C». В поле D находится исходное сообщение M = 3402418120. Переводим M в текстовый вид. Для этого A:= M, нажимаем «D = text(A)» => D =  = «КМЗИ».  
   我们解密密码块C：A:= C； B: = d; C:= N。按“D = A^B mod C”。在字段 D 中有原始消息 M = 3402418120。我们将 M 转换为文本形式。要执行此操作，A:= M，请按“D = 文本(A)” => D = =“KMZI”。

Снимок экрана с окном программы «BCalc» приведен ниже.  
BCalc 程序窗口的屏幕截图如下所示。

![](./pic/Encript_Labs4-1.png)

### Варианты заданий

Вариант | Модуль, N | Экспонента, е | Блок зашифрованного текста, C
--------|-----------|---------------|------------------------
23 | 48992988576733 | 4545733 | 12530303611339 <br> 47274247086952 <br> 20068556933394 <br> 41300245344157 <br> 27564916776233 <br> 45997492729411 <br> 11416336760074 <br> 17516700753417 <br> 10586755223028 <br> 5642378694993 <br> 17949047899806 <br> 13276902592875

## Лабораторная работа № 2 <br> Атака на алгоритм шифрования RSA методом повторного шифрования 

### Цель работы: 

изучить атаку на алгоритм шифрования RSA посредством повторного шифрования.  
研究通过重加密对RSA加密算法的攻击。

### Порядок выполнения работы: 

- ознакомьтесь с теорией в [3], рассмотренной в подразделе  («Атака повторным шифрованием»);  
  阅读[3]中的理论，在小节（“重新加密攻击”）中讨论；
- получите вариант задания у преподавателя;  
  从老师那里获取作业版本；
- по полученным исходным данным, используя метод перешифрования, определите порядок числа e в конечном поле $Z_\varphi(N)$;  
  利用接收到的初始数据，利用重加密方法，确定有限域 $Z_\varphi(N)$ 中数字e的阶；
- используя значение порядка экспоненты, получите исходный текст методом перешифрования;  
  利用指数阶值，利用重加密方法得到原始文本；
- результаты и промежуточные вычисления оформите в виде отчета.  
  以报告的形式格式化结果和中间计算。

Примечание. Для выполнения практического задания рекомендуется использовать программу PS.exe.  
笔记。为了完成实际任务，建议使用PS.exe程序。

Пример выполнения лабораторной работы c помощью программы PS  
使用 PS 程序执行实验室工作的示例

Исходные данные: $N$ = 453819149023; $e$ = 1011817; $C$ = 442511634532.  
源数据：$N$ = 453819149023； $e$ = 1011817； $C$ = 442511634532。

1. Определить порядок экспоненты. Для этого необходимо ввести значение модуля в поле N, экспоненты в поле e, в поле $Y$ записывается произвольное число, меньше чем N. После этого нужно нажать кнопку Запуск повторного шифрования и дождаться, пока в поле $X$ появится значение, равное корню е степени от числа $Y$ по модулю $N$, а в поле $i$ - порядок e в конечном поле $Z_\varphi(N)$. В данном примере он составляет 435.  
   确定指数的阶数。为此，您需要在 N 字段中输入模值，在 e 字段中输入指数，在 $Y$ 字段中写入小于 N 的任意数字。之后，您需要单击“开始重新加密”。按钮并等待，直到等于根的值出现在 $X$ 字段中 e 数 $Y$ mod $N$ 的幂，并且在字段 $i$ 中出现 e 在有限字段 $Z_\varphi( N）$。在本例中为 435。
2. Дешифровать зашифрованный текст. Для этого нужно в область редактирования поля $C$ поместить блоки зашифрованного текста, разделенные символом конца строки, значение модуля в поле $N$, экспоненты в поле e и порядка экспоненты в поле $i$. Затем нажать на кнопку Дешифрация и дождаться появления исходного текста в области редактирования $M$. Ответ - открытый текст - «null».  
   解密密文。为此，您需要在 $C$ 字段的编辑区域中放置以行尾字符分隔的密文块、$N$ 字段中的模值、e 字段中的指数以及指数阶数在 $i$ 字段中。然后点击解密按钮，等待源文本出现在$M$编辑区域中。答案是明文——“null”。

### Варианты заданий

Вариант | Модуль, N | Экспонента, е | Блок зашифрованного текста, C
--------|-----------|---------------|------------------------
23 | 888532740131 | 508097 | 251133768996 <br> 359801014616 <br> 557356431645 <br> 75854873865 <br> 768478933532 <br> 624174758081 <br> 306027834198 <br> 586384787006 <br> 155294489444 <br> 358096762086 <br> 197284968232 <br> 498688500894 <br> 467532994504