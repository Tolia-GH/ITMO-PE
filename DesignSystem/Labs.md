## Лабораторная работа 1. Интерфейсы ввода-вывода общего назначения (GPIO)

### Цели работы

1. Получить базовые знания о принципах устройства стенда SDK-1.1M и программировании микроконтроллеров.  
   获得有关SDK-1.1M支架设计和微控制器编程原理的基本知识。
2. Изучить устройство интерфейсов ввода-вывода общего назначения (GPIO) в микроконтроллерах и приемы использования данных интерфейсов.  
   研究微控制器中通用输入/输出接口（GPIO）的设计以及如何使用这些接口。

### Задание

Разработать и реализовать драйверы управления светодиодными индикаторами и чтения состояния кнопки стенда SDK-1.1М (расположены на боковой панели стенда). Обработка нажатия кнопки в программе должна включать программную защиту от дребезга. Функции и другие компоненты драйверов должны быть универсальными, т. е. пригодными для использования в любом из вариантов задания и не должны содержать прикладной логики программы. Функции драйверов должны быть неблокирующими, то есть не должны содержать ожиданий события (например, нажатия кнопки). Также, в драйверах не должно быть пауз с активным ожиданием (функция HAL_Delay() и собственные варианты с аналогичной функциональностью).  
开发并实现用于控制 LED 指示灯和读取 SDK-1.1M 支架按钮（位于支架侧面板上）状态的驱动程序。程序中处理按钮按下操作必须包含软件防弹跳保护。驱动程序的功能和其他组件必须是通用的，即适合在任何版本的任务中使用，并且不得包含程序的应用逻辑。驱动程序函数必须是非阻塞的，即它们不能包含等待事件（例如，按下按钮）。此外，驱动程序不应因主动等待而暂停（HAL_Delay() 函数及其具有类似功能的变体）。

При необходимости параллельного выполнения разных процессов (например, опроса кнопки и ожидания перед переключением светодиодов) следует организовать псевдопараллельную работу процессов в стиле кооперативной многозадачности. Это возможно сделать без существенной потери точности соблюдения необходимых интервалов времени между действиями, поскольку действия выполняются очень быстро по сравнению с промежутками ожидания между ними. Каждый процесс (который может быть выражен всего в нескольких строках кода) должен использовать не активное ожидание (HAL_Delay()), а считывать текущее значение миллисекундного счетчика (HAL_GetTick()), проверяя, прошло ли необходимое количество времени для выполнения следующего действия. После проверки и (при необходимости) выполнения действия управление должно передаваться следующему процессу, чтобы он тоже мог провести такую проверку.  
如果需要并行执行不同的进程（例如，轮询按钮并在切换 LED 之前等待），则应以协作多任务处理的方式组织进程的伪并行操作。这可以在维持动作之间所需时间间隔的准确性方面没有显着损失的情况下完成，因为与动作之间的等待时间相比，动作执行得非常快。每个进程（可以用几行代码表达）不应该使用主动等待（HAL_Delay()），而是读取毫秒计数器的当前值（HAL_GetTick()），检查所需的时间是否已达到通过执行下一步操作。检查并（如有必要）执行操作后，控制必须转移到下一个流程，以便它也可以执行此类验证。

Контакты подключения кнопки и светодиодов должны быть настроены в режиме GPIO. Использование прерываний и дополнительных таймеров (кроме SysTick) не допускается.  
按钮和 LED 连接引脚必须配置为 GPIO 模式。不允许使用中断和附加定时器（SysTick 除外）。

Написать программу с использованием разработанных драйверов в соответствии с вариантом задания.  
根据任务选项，使用开发的驱动程序编写程序。

### Порядок выполнения работы

1. Изучить:  
   学习：
- устройство и инструкцию по эксплуатации стенда SDK-1.1M;  
  展台SDK-1.1M的设计和操作说明；
- основные характеристики микроконтроллера STM32 по листу данных (datasheet); документация выложена на сайте производителя [34] (например, см. документацию микроконтроллера STM32F427VIT6 [41], обозначение документа - DS9405 [7]);  
  据数据表的 STM32 微控制器的主要特性；文档发布在制造商的网站上 [34]（例如，请参阅 STM32F427VIT6 微控制器的文档 [41]，文档名称 - DS9405 [7]）；
- разделы учебного пособия:  
  手册各部分：
  - 1.1. Сигналы сброса и синхронизации;  
    复位和同步信号； 
  - 1.2. Интерфейс ввода-вывода общего назначения (GPIO);  
    通用输入/输出接口（GPIO）；
- электрическую принципиальную схему стенда в части управления светодиодами и кнопкой, используемыми в данной работе;  
  控制本作品中使用的 LED 和按钮的支架电路图；
- раздел «General purpose I/O (GPIO)» из справочного руководства (reference manual) по микроконтроллерам линейки STM32F4 (обозначение документа - RM0090 [4]), знать устройство портов ввода-вывода, режимы их работы и способы настройки.  
  STM32F4 系列微控制器参考手册（文档名称 - RM0090 [4]）中的“通用 I/O (GPIO)”部分，了解 I/O 端口的设计、其操作模式和配置方法。
2. Создать и настроить пустой проект программы для SDK-1.1M.  
   为SDK-1.1M 创建并配置一个空程序项目。
3. Настроить тактовые частоты.  
   设置时钟频率。
4. Настроить сигналы GPIO, необходимые для выполнения задания.  
   配置完成作业所需的 GPIO 信号。
5. Изучить:  
   学习：
- состав стандартного драйвера GPIO из библиотеки HAL (файлы stm32f4xx_hal_gpio.c/.h в проекте), знать основные определения и функции, принцип работы драйвера. Справочная информация находится в комментариях в файле драйвера в документации (обозначение документа - UM1725 Description of STM32F4 HAL and low-layer drivers [42]) с сайта производителя;  
  由HAL库（项目中的文件stm32f4xx_hal_gpio.c/.h）组成标准GPIO驱动程序，了解驱动程序的基本定义和功能、工作原理。帮助信息位于制造商网站文档中驱动程序文件的注释中（文档名称 - UM1725 STM32F4 HAL 和低层驱动程序说明 [42]）；
- содержимое инициализационного кода в созданных генератором файлах gpio.c/.h.  
  生成器创建的 gpio.c/.h 文件中初始化代码的内容。
6. Разработать драйверы управления светодиодами и чтения состояния кнопки.  
   开发用于控制 LED 和读取按钮状态的驱动程序。
7. Разработать программу согласно варианту задания и провести ее тестирование.  
   根据作业选项开发程序并测试。
8. Модифицировать программу: отключить в графическом конфигураторе настройку портов GPIO. Разработать собственные функции для инициализации и использования портов GPIO (можно с использованием объявленных в стандартной библиотеке структур и констант). Заменить в программе использование библиотечных функций работы с GPIO на вызов собственных реализаций.  
   修改程序：在图形配置器中禁用GPIO端口的配置。开发您自己的函数来初始化和使用 GPIO 端口（您可以使用标准库中声明的结构体和常量）。通过调用您自己的实现来替换在程序中使用库函数来处理 GPIO。

### Вариант 2

Реализовать простой имитатор гирлянды с переключением режимов. Должно быть реализовано не менее четырех последовательностей переключения светодиодов, обязательно с разной частотой мигания (должны быть визуально отличимыми). В каждом режиме задействуется не менее двух светодиодов. По нажатию кнопки происходит циклическое переключение режимов. При повторном входе в какой-либо режим анимация на светодиодах должна запускаться с того места, на котором в прошлый раз была прервана переключением на следующий режим. Удерживание зажатой кнопки не должно приводить к «повисанию» анимации.  
实现一个带有模式切换的简单花环模拟器。必须实施至少四个 LED 开关序列，并且始终具有不同的闪烁频率（必须在视觉上可区分）。每种模式至少使用两个 LED。通过按下按钮，模式会循环切换。当您重新进入任何模式时，LED 上的动画应从上次切换到下一个模式而中断的点开始。按住按钮不应导致动画冻结。

## Лабораторная работа 2. Последовательный интерфейс UART

### Цели работы

1. Изучить протокол передачи данных по интерфейсу UART.
2. Получить базовые знания об организации системы прерываний в микроконтроллерах на примере микроконтроллера STM32.
3. Изучить устройство и принципы работы контроллера интерфейса UART, получить навыки организации обмена данными по UART в режимах опроса и прерываний.

Задание

Разработать и реализовать два варианта драйверов UART для стенда SDK-1.1M: с использованием и без использования прерываний. Драйверы, использующие прерывания, должны обеспечивать работу в «неблокирующем» режиме (возврат из функции происходит сразу же, без ожидания окончания приема/отправки), а также буферизацию данных для исключения случайной потери данных. В драйвере, не использующем прерывания, функция приема данных также должна быть «неблокирующей», то есть она не должна зависать до приема данных (которые могут никогда не поступить). При использовании режима «без прерываний» прерывания от соответствующего блока UART должны быть запрещены.

Написать с использованием разработанных драйверов программу, которая выполняет определенную вариантом задачу. Для всех вариантов должно быть реализовано два режима работы программы: с использованием и без использования прерываний. Каждый принимаемый стендом символ должен отсылаться обратно, чтобы он был выведен в консоли (так называемое «эхо»). Каждое новое сообщение от стенда должно выводиться с новой строки. Если вариант предусматривает работу с командами, то на каждую команду должен выводиться ответ, определенный в задании или «ОК», если ответ не требуется. Если введена команда, которая не поддерживается, должно быть выведено сообщение об этом.

Скорость работы интерфейса UART должна соответствовать указанной в варианте
задания