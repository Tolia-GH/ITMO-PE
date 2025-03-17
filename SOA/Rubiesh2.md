## [MainPage](../index.md)/[SOA](./README.md)/Rubiesh 2

### Вариант 1

#### 1. Варианты реализации Service Discovery

Service Discovery (Обнаружение сервисов) — автоматическое обнаружение, отслеживание и контроль состояния устройств и сервисов в компьютерной сети.

Он создан для того, чтобы с минимальными затратами можно было подключить новое приложение/сервис в уже существующее окружение.
Решаемые задачи
- Реконфигурация системы
- Упрощение администрирования
- Горизонтальная масштабируемость

Варианты реализации:
- Инфраструктурное ПО
  - SD конфигурируется на уровне управления ВМ/контейнеров (e.g.
docker, kubernetes)
- Прозрачно силами платформы (например напрямую в Java EE)
- Используя фреймворки (e.g. Spring Cloud)
- Специальное прикладное ПО (Consul, Zookeeper)

Это load balancer! (Или 2 способа использования SD load balancer-ом)

Существует два типа SD:

- client-side discovery - клиент запрашивает информацию о доступе к доступным экземплярам у SD, а дальше сам распределяет нагрузку между
ними
- server-side discovery - клиент использует посредника (SD) для запроса каталога услуг и выполнения запросов к ним

Примеры реализации:
- ZooKeeper
  - написан на Java,
  - крепок и стабилен, но тяжеловат в настройке.
  - устарел, почти не используется (в т.ч. требует понижение версии
спринга, чтобы все заработало)
- Consul
  - Server-side
  - чуть более тяжелый и медленный, чем ZooKeeper
  - Распределенный Service Discovery (ПО ставится на каждый комп)
  - работает по принципу ключ-значение
  - предлагает веб-интерфейс для работы со списками сервисов
- Eureka Server
  - Clients-side
  - Обязанность — давать имена каждому микросервису.
  - Каждый сервис регистрируется в Eureka и отправляет эхо-запрос
серверу Eureka, чтобы сообщить, что он активен.
  - Для этого сервис должен быть помечен как @EnableEurekaClient (или общее - @EnableDiscoveryClient), а сервер @EnableEurekaServer.


#### 2. Структура реестра UDDI

UDDI: Universal Description, Discovery and Integration — централизованное хранилище дескрипторов WSDL со стандартизированным API. Структура состоит из:

- Белые страницы - адрес, контакты и известные идентификаторы;
  - Основная информация о компании и ее бизнесе,
  - Основная контактная информация, включая название компании, адрес, контактный телефон,
  - Уникальные идентификаторы для налоговых идентификаторов
компании
- Желтые страницы - категоризация;
  - более подробная информация о компании (описания электронных возможностей, которые компания может предложить любому, кто хочет иметь с ней дело)
  - Желтые страницы используют общепринятые схемы промышленной классификации, отраслевые коды, коды идентификации предприятий
  - Почтовые и географические индексы
- Зеленые страницы - техническая информация о сервисе.
  - Различные интерфейсы
  - API
  - Информация об обнаружении и аналогичные данные, необходимые для поиска, связи и запуска веб-службы

Помимо этого, имеют место четыре типа записей:
- Business Entity — описывает бизнес, предоставивший данный сервис, эта запись включает информацию о категории, помогающую поисковым системам выполнять
поиск для определенного типа бизнеса.
- Business Service — класс сервисов внутри бизнеса. Каждый бизнес-сервис принадлежит нескольким бизнес-записям Business Entity.
- Binding Template (шаблон связывания) и Technology Model (технологическая модель) совместно определяют веб-сервис, как это описано в WSDL. Технологическая модель соответствует абстрактному описанию, а шаблон связывания соответствует протоколу.

#### 3. Сервис на JAX-WS реализующий DNS

```java
package dnsservice.endpoint;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(name = "DNS")
public class DNS {

    private Map<String, String> dnsRecords = new HashMap<>();

    public void DNS () {};

    @WebMethod
    public String getIPAddress(@WebParam(name = "domain") String domain) {
        return dnsRecords.get(domain);
    }

    @WebMethod
    public String updateIPAddress(@WebParam(name = "domain") String domain,
                                  @WebParam(name = "ip") String ip) {
        dnsRecord.put(domain, ip);
        return dnsRecords.get(domain);
    }
    
    @WebMethod
    public String deleteIPAddress(@WebParam(name = "domain") String domain) {
        //…if contains, .remove(domain)…, else, …
    }
    
    @WebMethod
    public String addIPAddress(@WebParam(name = "domain") String domain,
                               @WebParam(name = "ip") String ip) {
        //…
    }
}
```

Публикуем сервис:

```java
public class DNSServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish(
                "http://localhost:8080/dns",
                new DNS()
        );
    }
}
```

### Вариант 2

#### 1. Service Discovery на Java EE и его реализации

Все сервисы “by design” регистрируются в JNDI и доступны через CDI

- JNDI (Java Naming and Directory Interface) - Java API, которое предоставляет единообразный механизм взаимодействия Java-программы с различными службами имен и каталогов. “Под капотом” интеграция между JNDI и любой конкретной службой осуществляется с помощью интерфейса поставщика услуг. JNDI нужен для того, чтобы мы могли из Java-кода получить Java-объект из некоторого "Registry" объектов (как раз JNDI) по имени объекта, привязанного к этому объекту. То есть в JNDI зарегистрированы все микросервисы, и зная “логическое имя”, можно достать физический URI, и дополнительную метаинформацию
- CDI — это Contexts and Dependency Injection. Это спецификация Java EE, описывающая внедрение зависимостей (Dependency Injection) и контексты.

Конфигурация сервера приложений может быть распределённой:
- В виде пула экземпляров сервера.
- В виде кластера.

Если логику “под капотом” реализуют EJB, их можно масштабировать.

<По идее надо бы раскрыть, но хз че можно вписать>

Различные реализации Java EE предоставляют дополнительные механизмы для реализации Service Discovery. Например, Apache Tomcat имеет свой механизм обнаружения служб, а JBoss предлагает JMX для обнаружения служб. Также есть несколько реализаций Service Discovery на основе JAX-WS.

#### 2. Понятие микросервиса. Отличия и сходства от других сервисов.

Микросервисы – это шаблон сервис-ориентированной архитектуры, в котором приложения создаются как совокупность различных наименьших независимых (или слабо связанных), легко изменяемых модулей - микросервисов.

Нет четкой спецификации и стандартна, это больше “идеология”.

Микросервис - разновидность SOA, но есть различия:
- SOA ориентирована на повторное использование сервисов приложений, а микросервисы – на разъединение.
- SOA является полнофункциональным по своей природе, а Microservices – монолитным (поэтому MSA не предоставляет явной поддержки для разработки распределенных приложений)
- SOA-приложения созданы для выполнения многочисленных бизнес-задач, а в MSA выполняет одну бизнес-задачу. Поэтому SOA лучше для крупномасштабных интеграций, а MSA для небольших веб-приложений.
- SOA предполагает совместное хранение данных между службами, тогда как в микросервисах каждая служба может иметь независимое хранилище данных.
- SOA предназначен для совместного использования ресурсов между службами, а микросервисы – для размещения служб, которые могут функционировать независимо (или хотя бы ограниченный контекст для связи).
- В архитектуре SOA DevOps и Непрерывная доставка становятся популярными, но еще не стали массовыми, в то время как микросервисы уделяют большое внимание DevOps и Непрерывной доставке.
- SOA – это менее масштабируемая архитектура, а Microservices – очень масштабируемая архитектура.

#### 3. Написать двухтарифный счётчик электроэнергии для интеграции его в ИС-предприятия на JAX-WS

```java
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(name = "ElectricityMeterService")
public class ElectricityMeterService {
    
    @WebMethod
    public double getCurrentPowerConsumption(@WebParam(name = "tariff") int tariff) {
        // Реализация метода
    }
    
    @WebMethod
    public double getTotalPowerConsumption(@WebParam(name = "tariff") int tariff) {
        // Реализация метода
    }
    
    @WebMethod
    public String setTariff(@WebParam(name = "tariff") int tariff) {
        // Реализация метода
    }
    
    @WebMethod
    public String getCurrentTariff(@WebParam(name = "tariff") int tariff) {
        // Реализация метода
    }
    
    @WebMethod
    public GetInformationAboutTariffsRes getInformationAboutTariffs() {
        // Реализация метода
    }
}
```

### Вариант 3

#### 1. Концепция Service Discovery.

Service Discovery (Обнаружение сервисов) — автоматическое обнаружение, отслеживание и контроль состояния устройств и сервисов в компьютерной сети. SD создан для того, чтобы с минимальными затратами можно подключить новое приложение в уже существующее наше окружение. Используя Service Discovery, мы можем максимально разделить либо контейнер в виде докера, либо виртуальный сервис от того окружения, в котором он запущен.

Также Service Discovery позволяет обнаружить сбой и/или отказы. Service Discovery со своей стороны опрашивает зарегистрированное приложение на факт доступности.

Решаемые задачи
- Реконфигурация системы.
- Упрощение администрирования.
- Горизонтальная масштабируемость.
- Общая концепция универсальна (искать можно не только веб-сервисы!)
- Варианты реализации (не являются прямыми альтернативами!):
  - Инфраструктурное ПО (Kubernetes, nginx...).
  - Специальное прикладное ПО (Consul, ZooKeeper, Etcd...).
  - “Прозрачно” силами платформы (Java EE).
  - Фреймворк (Spring Cloud [Netflix]).

Два типа SD и варианты реализации см. [Вариант 1. Вопрос 1](#1-варианты-реализации-service-discovery)

#### 2. Smart endpoints & Dumb pipes в МСА.

Smart endpoints & Dumb pipes (SE & DP) - паттерн MSA для взаимодействия микросервисов по сети.

Начнем с контрпримера: в ESB реализован подход «умный канал и глупые сервисы»: умный канал — шина ESB, глупые сервисы — конечные системы. В противовес ESB, существует подход «умные сервисы и глупые каналы», используемый в МСА. Суть в том, что микросервисы (смарт эндпоинтс) должны выполнять свою собственную коммуникационную логику, а надстройка (pipes) по передаче сообщений (“from endpoint to endpoint”) должна иметь как можно более легковесную структуру.

В виде каналов в данном подходе выступают различные брокеры:
- Брокеры сообщений (message broker) - выступает посредником: преобразует сообщение по одному протоколу от приложения-источника в сообщение протокола приложения-приёмника. Так же брокер, например, проверяет сообщение на ошибки, маршрутизирует, и выполняет еще ряд функций (но тем не менее не бизнес-логику, оставаясь “dumb”)
- Событийные брокеры (event broker) - используется для передачи событий по схеме publish-subscribe.

А в виде сервисов — шлюзы (API Gateway), которые скрывают за собой реализацию и выносят наружу для взаимодействия API.

Плюсы:
- Возможность построения слабосвязанных систем
- Гибкость настройки, взаимозаменяемость инструментов взаимодействия
- Быстрота взаимодействия

Минусы:
- Сложность проектирования и реализации системы
- Требуются практики DevOps по настройке окружения
- В связи с общим трендом на микросервисы в корпоративной разработке, стоимость труда специалистов увеличивается

#### 3. Сервис Jax-ws по менеджменту учащихся.

```java
@WebService(endpointInterface = "shit.soa.StudentManagmentService")
public class StudentManagmentServiceImpl implements StudentManagmentService {
    
    @Inject
    private StudentManagmentRepository rep;
    
    @WebMehtod(operationName = "getAllStudents")
    @WebResult(name="student_list_dto")
    public StudentsListDTO getAllStudents(@WebParam(name="get_students_req_dto")
                                          GetAllStudentsReqDTO req) {
        return new StudentsListDTO().getStudents().addAll(rep.getStudents());
    }
    
    @WebMehtod(operationName = "getStudent")
    @WebResult(name="student")
    public Student getStudent(@WebParam(name="get_student_req_dto") GetStudentReqDTO req) {
        return rep.getStudent(req.getId)
    }
    
    @WebMehtod(operationName = "addStudent")
    @WebResult(name="student")
    public Student addStudent(@WebParam(name="add_student_req_dto") AddStudentReqDTO req) {
        return rep.addStudent(req.getName, req.getGroup, ...);
    }
    
    @WebMehtod(operationName = "updateStudent")
    @WebResult(name="student")
    public Student updateStudent(@WebParam(name="update_student_req_dto") UpdateStudentReqDTO req) {
        return rep.updateStudent(req.getId, req.getName, req.getGroup, ...);
    }
    
    //...
}
```

### Вариант 4

#### 1. Service Discovery в решениях на базе Spring Cloud Netflix

Spring Cloud Netflix — бандл для построения СОА систем на базе Spring Cloud Netflix и интеграции его в стек Netflix OSS посредством автоматической настройки и привязки к Spring Environment. Шаблоны внутри приложения настраиваются легко и быстро с помощью нескольких простых аннотаций, тем самым позволяя создать большие распределенные системы с проверенными в бою компонентами Netflix. Spring Cloud Netflix предоставляет client-side SD - Eureka.

Напомним, что client-side discovery - клиент запрашивает информацию о доступе к доступным экземплярам у SD, а дальше сам распределяет нагрузку между ними. В Client-side SD единственной «фиксированной точкой» в архитектуре является Service Registry, в котором должна регистрироваться каждая служба. Клиент сам имплементирует логику для взаимодействия со службой.

Каждый микросервис регистрируется на сервере Eureka, и Eureka знает все клиентские приложения, работающие на каждом порту и IP-адресе. Eureka Server также известен как Discovery Server.

С Netflix Eureka каждый клиент действует как “сервер” при подключении к сервису: клиент извлекает список всех подключенных экземпляров в service registry и отправляет все дальнейшие запросы к службам с помощью алгоритма балансировки нагрузки.

Обязанность Eureka — давать имена каждому микросервису. Эврика регистрирует микросервисы и отдает их ip другим микросервисам. Таким образом, каждый сервис регистрируется в Eureka и отправляет эхо-запрос серверу Eureka, чтобы сообщить, что он активен. Для этого сервис должен быть помечен как @EnableEurekaClient, а сервер @EnableEurekaServer.

#### 2. Технология JAX-WS и её использование для реализации веб-сервисов

Java API for XML Web Services (JAX-WS) — это прикладной программный интерфейс языка Java для создания веб-служб, входит в спецификацию Java EE.

JAX-WS является заменой технологии JAX-RPC, предоставляя более документо-ориентированную модель сообщений и упрощая разработку веб-служб за счёт использования аннотаций. Основан на разметке класса аннотациями (метапрограммировании), хорошо совместим с EJB.

В JAX-WS вызов операции веб-сервиса представлен протоколом SOAP — протоколом на основе XML. Спецификация SOAP определяет:

- структуру сообщения,
- правила кодирования
- соглашения для представления вызовов и ответов веб-сервиса.

Эти вызовы и ответы передаются как сообщения SOAP (файлы XML) по HTTP.

На стороне сервера разработчик:

- специфицирует операции веб-сервиса, определяя методы в интерфейсе, написанном на Java.
- Пишет классы с реализацией этих методов.

Для реализации клиентских классов, рахработчик:

- создает прокси (локальный объект, представляющий сервис),
- затем просто вызывает методы на прокси.

Кроме того, JAX-WS не ограничивает ни одну из сторон в используемых технологиях: клиент JAX-WS может получить доступ к веб-сервису, который не работает в платформе Java, и наоборот. Эта гибкость возможна благодаря использованию в JAX-WS технологий, определённых W3C: HTTP, SOAP и WSDL. WSDL определяет формат XML для описания сервиса как набора конечных точек, работающих с сообщениями.

Можно генерировать: WSDL <-> code (в обе стороны).

Аннотации JAX-WS

- `@WebService` — указывает на то, что Java класс (или интерфейс) является веб-сервисом.
- `@WebMethod` — позволяет настроить то, как будет отображаться метод класса на операцию сервиса.
- @WebParam — позволяет настроить то, как будет отображаться конкретный параметр операции на WSDL-часть (part) и XML элемент.
- `@WebResult` — позволяет настроить то, как будет отображаться возвращаемое значение операции на WSDL-часть (part) и XML элемент.
- `@Oneway` — указывает на то, что операция является односторонней, то есть не имеет выходных параметров.
- `@SOAPBinding` — позволяет настроить то, как будет отображаться сервис на протокол SOAP. 232\

Пример сервиса на JAX-WS: интерфейс

```java
@WebService
public interface EmployeeService {
    @WebMethod
    Employee getEmployee(int id);
    
    @WebMethod
    Employee updateEmployee(int id, String name);
    
    @WebMethod
    boolean deleteEmployee(int id);
    
    @WebMethod
    Employee addEmployee(int id, String name);
    //...
}
```

Пример сервиса на JAX-WS: реализация

```java
@WebService(endpointInterface = "com.example.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Inject
    private EmployeeRepository employeeRepositoryImpl;

    @WebMethod
    public Employee getEmployee(int id) {
        return employeeRepositoryImpl.getEmployee(id);
    }

    @WebMethod
    public Employee updateEmployee(int id, String name) {
        return employeeRepositoryImpl.updateEmployee(id, name);
    }
    // ...
}
```

Пример сервиса на JAX-WS: публикация

```java
public class EmployeeServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish(
                "http://localhost:8080/employeeservice",
                new EmployeeServiceImpl());
    }
}
```


#### 3. Набор микросервисов на Spring MVC, управляющий распределением по аудиториям и преподавателям студентов, ожидающих своей очереди на доп. Должна поддерживаться возможность добавления новых аудиторий и преподавателей и удаления существующих. В одной аудитории может находиться более одного преподавателя.

Пишем CRUD для аудиторий, это отдельный микросервис.

Controller:

```java
@RestController
public class AudienceController {
    private final AudienceService audienceService;
    @Autowired
    public AudienceController(AudienceService audienceService) {
    }
    
    @GetMapping("/audiences")
    public List<Audience> getAudiences() {
        return audienceService.getAudiences();
    }
    
    @PostMapping("/audiences")
    public Audience addAudience(@RequestBody Audience audience) {
        return audienceService.addAudience(audience);
    }
    
    @DeleteMapping("/audiences/{id}")
    public void deleteAudience(@PathVariable Long id) {
        audienceService.deleteAudience(id);
    }
}
```

Application:

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AudienceServiceApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(
                AudienceServiceApplication.class,
                args);
    }
}
```

Controller:

```java
@RestController
public class TeacherController {
    //...
}
```

Application:

```java
@SpringBootApplication
public class TeacherServiceApplication {
    // ...
}
```

АНАЛОГИЧНО пишем микросервис для студентов
//...

Последний шаг - микросервис, добавляющий студентов и преподавателей в аудитории (создает класс)

```java
@RestController(path = "/class")
public class ClassController {
    
    private final ClassService classService;
    
    @Autowired
    public ClassController(ClassService ClassService) {
    }
    
    @GetMapping("/student")
    public boolean applyStudent(
            @RequestParam(name = "student_id") Long studentId,
            @RequestParam(name = "audience_id") Long audienceId) {
        return classService.applyStudent(studentId, audienceId);
    }

    //Ну...И так же препода добавляем
}
```

### Вариант 5

#### 1. Реализация микросервисов на Spring Cloud.

Spring Cloud
- Инструментарий на базе Spring для построения распределенных систем (а не облако от Spring!)
- Следующий уровень инфраструктурной иерархии (Spring -> Spring Boot -> Spring Cloud).
- Ключевые возможности:
  - Распределённая конфигурация с версионированием.
  - Регистрация и автообнаружение сервисов.
  - Маршрутизация вызовов.
  - Организация взаимного вызова сервисов.

Архитектура Spring Cloud

![](./pic/Rubiesh2-1.png)

Микросервисы на Spring Cloud
- Решение “из коробки” для реализации MSA.
- Расширяет возможности Spring Boot.
- Включает в себя следующий набор компонентов:
  - Spring Cloud Config Server.
  - Auth Server.
  - API Gateway.
  - Service Discovery.
  - Клиентский балансировщик, Circuit Breaker и HTTP-клиент.
  - Панель мониторинга.

#### 2. Service Discovery и Service Registry.

Service Discovery — см [Вариант 1 вопрос 1](#1-варианты-реализации-service-discovery)

- Service Discovery – это процесс, позволяющий клиентам автоматически найти и использовать доступные службы. Примерами Service Discovery могут быть DNS, различные протоколы динамической конфигурации или протоколы обнаружения служб, такие как SLP или UPnP.

Решаемые задачи:
- реконфигурация системы
- упрощение администрирования
- горизонтальная масштабируемость

- Service Registry – Ключевой компонент, SD. Это хранилище данных, используемое для хранения информации об услугах, доступных для других систем. Оно может содержать информацию о местоположении служб, метаданные и обнаруженные атрибуты, протоколы доступа и другую полезную информацию. Поэтому его необходимо обновлять и регулярно поддерживать.

Service Registry
- API для взаимодействия с реестром сервисов.
- Есть имплементации для популярных реестров (Eureka, Consul, ZooKeeper, Kubernetes...)
- Базовый интерфейс – DiscoveryClient.

![](./pic/Rubiesh2-2.png)

#### 3. Веб-сервис на JAX-WS, управляющий процессом выпечки колобков. Выпечка пирожка состоит из последовательности взаимозависимых этапов, выполнение которых должен обеспечивать сервис - поскребание по сусекам, подготовка теста, лепка заготовки, термическая обработка.

```java
@WebService(endpointInterface = "shit.soa.BakeryService")
public class BakeryServiceImpl extends BakeryService {
    @Inject
    private DoBakeryService doService;

    @WebMehtod(operationName = "poskrebanie")
    @WebResult(name = "poskrebanie_res_dto")
    public PoskrebanieResDto poskrebanie(@WebParam(name = "poskrebanie_req_dto")
                                         PoskrebanieReqDto req) {
        return new doService.doPoskrebanie(req); //delaet poskrebanie
    }

    @WebMehtod(operationName = "test_preparing")
    @WebResult(name = "test_preparing_res_dto")
    public TestPreparingResDto test_preparing(@WebParam(name = "poskrebanie_req_dto")
                                              TestPreparingReqDto req) {
        return new doService.doTestPreparing(req); //delaet testa preparing
    }

    @WebMehtod(operationName = "lepka")
    @WebResult(name = "lepka_res_dto")
    public LepkagResDto lepka(@WebParam(name = "lepka_req_dto") LepkaReqDto req) {
        return new doService.doLepka(req); //delaet lepka ZagotoVki
    }

    @WebMehtod(operationName = "term_handling")
    @WebResult(name = "term_handling_res_dto")
    public TermHandlingResDto termHandling(@WebParam(name = "term_handling_req_dto")
                                           TermHandlingReqDto req) {
        return new doService.doTermHandling(req); //delaet term handling
    }
}
```

### Вариант 6

#### 1. Реализация Service Discovery на уровне инфраструктурного ПО

#### 2. Реализация микросервисов на Java EE

#### 3. Конфигурация в Consul сервиса по выпеканию пирожков с пулом экземпляров сервиса. Сервис реализован на Jakarta EE и развернут в контейнере приложений Wildfly на серверах helios, terra и aqua

### Вариант 7

#### 1. Consul. Назначение, архитектура, возможности

#### 2. Микросервисы на spring boot

#### 3. Написать на JAX-WS сервис по управлению процессом изготовления резиновых уточек

### Вариант 8

#### 1. Service Discovery

#### 2. Smart Endpoints & Dump pipes

#### 3. Jax-ws сервис по управлению контингентом в университете

### Вариант 9

#### 1. Основные проблема коммуникации микросервисов и способы их решения

#### 2. Circuit Breaker. Принципы, реализация, примеры использования.

#### 3. JAX-WS сервис по управлению авиаперелётами

### Вариант 10

#### 1. Load Balancer в Spring Cloud.

#### 2. Mule ESB, основные свойства и понятия.

#### 3. Конфигурация на Consul пула серверов WildFly, на которых развёрнута Jakarta EE система по выпеканию пирожков.

### Вариант 11

#### 1. Оркестровка и хореография микросервисов

#### 2. Top-down и bottom-up стратегии при использовании аннотаций wsdl

#### 3. Конфигурация Spring Boot сервиса для подключения Consul, он живет на localhost на 8500 порту

### Вариант 12

#### 1. Свойства и ключевые особенности микросервиса.

#### 2. Структура документа WSDL

#### 3. Конфигурация, регистрирующая в Consul пул экземпляров СУБД MySQL. Сервисы расположены на машинах ra, helios и anubis, экземпляры занимают порт 3306 на каждой из машин. Конфигурация должна обеспечивать проверку того, запущены ли экземпляры каждого из сервисов.

### Вариант 13

#### 1. Преимущества и недостатки MSA по сравнению с “обычной” SOA.

#### 2. Аннотации JAX-WS

#### 3. Конфигурация, регистрирующая в Consul пул сервисов libreoffice … обработкой документов. Сервисы расположены на машинах aqua, …, по пути /usr/bin/soffice. Конфигурация должна обеспечивать проверку запущены ли экземпляры сервисов.

### Вариант 14

#### 1. UDDI

#### 2. Design for failure

#### 3. конфиг для консула чтобы зарегать 3 бд

### Вариант 15

#### 1. Service Discovery в решениях на базе Spring Cloud Netflix

#### 2. Сервисные шины особенности, преимущества и недостатки, использование в решениях на базе SOA

#### 3. Набор микросервисов на Spring MVC, реализующий параллельную сортировку элементов массива. Алгоритм сортировки мож но выбрать любой подходящий.