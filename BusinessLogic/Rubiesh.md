# Rubiesh 1

## Билет 1

#### 1. Уровень бизнес-логики в программных системах зачем нужен, какую роль играет, как взаимодействует с другими уровнями.<br>软件系统中为什么需要业务逻辑层，它扮演什么角色，它如何与其他层交互。

#### 2. Распределенные транзакции, спецификация XA<br>分布式事务，XA 规范

#### 3. Диаграмма BPMN 2.0 для бизнес-процесса управления автомашина по продаже кофе (кофе-машина). Автомат должен уметь приготавливать несколько видов кофе, добавлять в кофе сливки и сахар и принимать к оплате наличные и карты и выдавать сдачу.<br>管理咖啡自动售货机（咖啡机）的业务流程的 BPMN 2.0 图。该机器必须能够准备多种类型的咖啡、向咖啡中添加奶油和糖、接受现金和银行卡付款以及找零。

[https://drive.google.com/file/d/1FcBR5zZ-QivXPxe4VO8fiK0eQmv7iv9E/view?usD=sharing](https://drive.google.com/file/d/1FcBR5zZ-QivXPxe4VO8fiK0eOmy7iy9E/view?usp=sharing)
можете исправлять если что, я хз, как это адекватно сделать

## Билет 2

#### 1. Spring Boot зачем нужен, как применяется, отличие от Spring обычного <br> 为什么需要Spring Boot，如何使用，与普通Spring的区别

#### 2. Программное и декларативное выполнение транзакций в spring <br> Spring 中事务的编程式和声明式执行

#### 3. Нарисовать BPMN 2.0 диаграмму: 1 ноября и 1 апреля должны отчислять студентов у которых хотя бы одна Академ. задолженность. <br>画一张 BPMN 2.0 图：11 月 1 日和 4 月 1 日，至少有一项学术债务的学生必须被开除。

## Билет 3

#### 1. BPMN и моделирование бизнес процессов.<br>BPMN 和业务流程建模。

#### 2. Политика безопасности в корпоративных приложения, зачем, за что отвечают, особенности реализации на уровне Бизнес-логики<br>企业应用程序中的安全策略、原因、它们负责什么、业务逻辑级别的实现功能

#### 3. Написать класс, реализующий транзакцию, которая получает Почку, Seller и Buyer и совершает акт купли-продажи. Причем продавец не может суммарно продать, а покупатель купить более 2 почек.<br>编写一个类，实现一个交易，该交易接收一个Kidney（肾）、Seller（卖家）和Buyer（买家），并执行买卖行为。卖家不能累计出售超过2个肾，买家也不能购买超过2个肾。

## Билет 4

#### 1. BPMN

#### 2. Spring security (роли и т.д.)

#### 3. Spring MVC rest. Штука, которая переводит деньги, и проверяет не превышен ли лимит переводов за месяц. <br>Spring MVC 的 REST 接口：一个用于转账的功能，并检查当月的转账额度是否已超限。

## Билет 5

#### 1. Основные концепции использующиеся в разработке бизнес логики. <br>开发业务逻辑时使用的基本概念。

#### 2. Выполнение. Распределенные транзакции в Spring и Jakarta EE. <br>执行。 Spring 和 Jakarta EE 中的分布式事务。

#### 3. BPMN для управления ядерным реактором. Исключение несанкционированной ядерной реакции с помощью отрицательной обратной связи. (BPMN для ядерного реактора. Должен реализовывать аварийную остановку) <br>用于核反应堆控制的 BPMN。使用负反馈消除未经授权的核反应。 （核反应堆BPMN。应实施紧急停堆）

## Билет 6

#### 1. Описание bpmn 2.0. принципы построения, основные элементы.<br>bpmn 2.0 的说明。构建原则、基本要素。

#### 2. Spring Security. Что, зачем, почему. Аннотации, файлы конфигурации.<br>Spring Security，是什么，用处，为什么，注释，配置文件

#### 3. REST API для системы быстрых платежей с проверкой месячного ограничения переводов в 100 000 р<br>用于快速支付系统的 REST API，可检查每月 100,000 卢布的转账限额

## Билет 7

#### 1. Объекты потока-управления BPMN 2.0 <br>BPMN 2.0 控制流对象

#### 2. JAAS (спизжено с конспекта) <br>2. JAAS

#### 3. Написать класс (валидатор) для автобуса, который позволяет покупать пассажиру билет. Деньги не списываются, если у человека недостаточно средств. Если человек уже оплатил и второй раз прикладывает карту, то средства не списываются. А также обнуляется билет по окончанию дня у данного пассажира. <br> 为允许乘客购买车票的公共汽车编写一个类（验证器）。如果一个人没有足够的资金，钱不会被注销。如果一个人已经付款并再次申请该卡，则不会扣除资金。乘客的机票也会在当天结束时重置。

# Rubiesh 2

## Билет ?:

#### 1. Распределённая обработка в JMS (Jakarta Messaging) <br> JMS（Jakarta Messaging）中的分布式处理

#### 2. Bpms описание, плюсы, минусы <br> Bpm 描述、优点、缺点

#### 3. Написать планировщик, используя Java SE, который запускается каждый день в 00.00 и отправляет сообщения от студентов преподавателю, когда тот проверит рубежку. Во избежание ddos атаки интервал между сообщениями 5 секунд. <br> 使用 Java SE 编写一个调度程序，每天 00:00 运行，并在老师检查里程碑时将学生的消息发送给老师。为了避免ddos攻击，消息之间的间隔为5秒。

## Билет ?:

#### 1. Active mq, архитектура, +/-, область применения <br> Active mq、架构、+/-、范围

#### 2. Жизненный цикл BPM: фазы и что на них происходит <br> BPM 生命周期：各个阶段以及其中发生的情况

#### 3. С помощью jakarta ee сделать планировщик: Блокировать стулом дверь аудитории после 5 минут от начала пары, если лектор в аудитории и включил проектор и при этом в аудитории есть пара. Получить расписание можно по isu api. <br> 使用 jakarta ee 制定计划：如果讲师在观众席中并且已打开投影仪并且观众席中有一对夫妇，则在课程开始 5 分钟后用椅子挡住教室门。您可以使用 isu api 获取时间表。

## Билет ?:

#### 1. Протоколы их плюсы и минусы <br> 协议及其优缺点

#### 2. Основные компоненты jbms (Camunda?) <br> jbms的主要组件（Camunda？）

#### 3. Написать Quartz, который каждый день в 10 и 22 проверяет у пациентов температуру, если было уже в 2 раза превышение, то вызвать врачей для проведения теста ПЦР, если тест положительный, то ограничить пациента и всех, кто с ним контактировал на 10 дней, все методы для работы с врачами уже есть <br> 写信给Quartz，每天10点和22点检查病人的体温，如果已经高了一倍，那就打电话给医生进行PCR检测，如果检测结果呈阳性，那就限制病人和所有接触过的人他呆了10天，仅此而已。已经有与医生合作的方法了

## Билет 3:

#### 1. Ресурсы и сообщения JMS <br> JMS 资源和消息

#### 2. Установка и конфигурация jbpm (Camunda?) <br> jbpm 安装和配置（Camunda？）

#### 3. Планировщик на Spring: просыпается каждые 5 минут рабочего времени с 11:00 до 17:00 (по будням), исключая обеденные перерыв с 13:00 до 15:00 и выполняет: <br> 春季调度程序：从 11:00 到 17:00（工作日），每 5 分钟工作时间唤醒一次，不包括 13:00 到 15:00 的午休时间，并执行：

## Билет 4:

#### 1. Модели поставки сообщений в JMS <br> JMS 消息传递模型

#### 2. Архитектура jBPM (Camunda) <br> jBPM 架构 (Camunda)

#### 3. Написать планировщик в cron, который каждый день в 5 утра кроме января, июля и августа будет запускать три скрипта <br> 在 cron 中编写一个调度程序，除了一月、七月和八月之外，每天早上 5 点运行三个脚本
