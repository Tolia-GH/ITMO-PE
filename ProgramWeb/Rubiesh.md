Рубежка №1

## Билет 1

- LESS / SASS / SCSS. Особенности, отличия, поддержка браузерами
  - Особнность: 
    - Sass — динамический язык стилей. Он имеет больше функций, чем css (такие как переменные, вложенность, вычисление, микширование (Mixin), наследование, обработка цвета, функции и т. д.), его легче читать.  
    Sass 是一种动态样式语言。比css比多出好些功能(如变量、嵌套、运算,混入(Mixin)、继承、颜色处理，函数等)，更容易阅读 
    - Синтаксис Sass очень неинтуитивен и не может быть совместим с синтаксисом CSS, поэтому синтаксис Sass был улучшен, и Sass 3 стал Scss (Sassy CSS).  
    Sass的语法很不直观，不能与CSS语法兼容，因此Sass语法进行了改良，Sass 3就变成了Scss(Sassy CSS)。 
    - SCSS (Sassy CSS) — это расширение синтаксиса CSS. Это означает, что каждый допустимый CSS также является допустимым оператором SCSS, совместимым с исходным синтаксисом, за исключением того, что исходный отступ заменен на {}  
    SCSS(Sassy CSS)是CSS语法的扩展。这意味着每一个有效的CSS也是一个有效的SCSS语句，与原来的语法兼容，只是用{}取代了原来的缩进 
    - Less также является динамическим языком стилей. CSS наделен динамическими функциями языка, такими как переменные, наследование, операции и функции. Less может работать как на стороне клиента (с поддержкой IE 6+, Webkit, Firefox), так и на стороне сервера (с Node.js).  
    Less也是一种动态样式语言。对CSS赋予了动态语言的特性，如变量，继承，运算， 函数。Less 既可以在客户端上运行 (支持IE 6+, Webkit, Firefox)，也可在服务端运行 (借助 Node.js)。
    - Браузеры могут не поддерживать их таблицы стилей, нужно преобразует в CSS при помощи транслятора  
      浏览器可能不支持他们的样式表，你需要使用编译器转换成 CSS 
- Отчличия:
  1. Среда компиляции отличается 编译环境不一样  
    Sass обрабатывается на стороне сервера, а Less необходимо преобразовать в CSS для обработки в браузере.  
    Sass是在服务端处理的，而Less是需要转为CSS到浏览器处理
  2. Знак переменных разный 变量符不一样  
    Less - `@`  
    Scss - `$`
  3. Выходные настройки разные 输出设置不一样
    В Less нет выходных настроек, а в Scss есть 4 варианта: `nested`, `compact`, `compressed`, `expanded`  
    Less 没有输出设置，而 Scss 有 4 个选项：`nested`, `compact`, `compressed`, `expanded` 
  4. Условные операторы 条件语句
    В Sass есть `if{}else{}`, `for{}`, а в Less нет.
  5. библиотека инструментов отличается 工具库不同

- Java SE, Java EE, Java ME. Платформа Java EE, понятие контейнера и компонента
  - JavaSE может разрабатывать и развертывать приложения Java для использования в настольных, серверных, встроенных средах и средах реального времени. Это основа EE и ME, а также конкретная реализация jdk, jvm и собственной коллекции API.  
    JavaSE 可以开发和部署在桌面、服务器、嵌入式环境和实时环境中使用的 Java 应用程序。是EE，和ME的基础，是 jdk，jvm 以及自带的 api 合集的具体实现
  - JavaEE на самом деле представляет собой набор спецификаций, разработанных на основе JavaSE (например, как инкапсулировать классы, какой метод использовать для обработки запросов веб-страниц и т. д.)  
    JavaEE，其实是基于 JavaSE 发展而来的一套规范（比如类怎么封装，网页的请求要用什么方法处理等等）
  - JavaME представляет собой набор спецификаций API-интерфейса, разработанных специально для встраиваемых устройств (таких как мобильные телефоны, КПК, ТВ-приставки, принтеры и т. д.)  
    JavaME 是一套运行专门为嵌入式设备（例如手机、PDA、电视机顶盒和打印机等）设计的api接口规范
  - Контейнер - среда работы комронента. Он управляет жизнь и взаимодействие компонент  
    容器——组件的环境。 它管理组件的生命和交互
  - Компонента - выполняет задание. Они не может взаимодействовать без контейнера  
    组件 - 执行任务。 没有容器就无法交互

  - Структура HTTP запроса, передающего логин и пароль пользователя

    ![avatar](pic/Rubiesh-1.1.png)
    ![avatar](pic/Rubiesh-1.2.png)
    логин и пароль пользователя в URL(login и password)  
    `POST /index.html?username=username&password=password HTTP/1.1`

## Билет 2

  - ECMAScript - особенности, типы данных, инструкции.
    - это встраиваемый расширяемый не имеющий средств i/o язык программирования, используемый в качестве основы для построения других скриптовых языков  
      它是一种可嵌入、可扩展的 I/O 编程语言，用作构建其他脚本语言的基础
    - типы данных
      - примитивные: `Number`, `String`, `Boolean`, `Null`, `Undefined`
      - составные: `Object`, `List`, `Reference`
    - 15 инструкции: Блок, переменное, выражение, цикл, исключение и так далее. В ES6 есть Класс  
      15 条指令。 块、变量、表达式、循环、异常等等。 ES6 还有一个类
  - Правила трансляции JSP.
    - Обычные html и текст или `<%=expression%>` будет в out.print()
    - `<%java code%>` в `_jspService()` и наконец вызовываться `service()`
    - `<%! Field/Method Declaration %>` переводят в поля или метод servlet
    - `<%@ %>` управляет процесс трансляции

  - Написать код HTML-страницы, отправляющей номер вопроса и выбранный вариант ответа (латинская буква от "A" до "F") после получения некоего текста.  
    编写一个 HTML 页面，在收到一些文本后发送问题编号和所选答案（从“A”到“F”的拉丁字母）。
    ```html
    <body>
    <script>
    function send(){
    	let answer = document.getElementById("answer").value;
    	let pattern = /^(A|B|C|D|E|F)$/g
    	if(pattern.test(answer)){
    		let form = document.getElementById("form");
    		let data = new FormData(form)
    		let request = new XMLHttpRequest();
    		request.open("POST","url");
    		request.send()
    	}
    }
    </script>
    <form id = "form" method = "post" action = "url" onsubmit = "send()">
    	<input type = "text" id = "answer">
    	<button type = "submit" onclick="send()">submit</button>
    </form>
    <body>
    ```

## Билет 3

  - методы HTTP
    `get`, `post`, `delete`, `head`, `put`, `options`

  - жизненный цикл servlet
    1. Загрузка класса 加载类
    2. Создать экземплар 实例化
    3. вызов `init()`
    4. вызов `service()`
    5. вызов `destroy()`

  - написать на JS функцию, которая на странице заменяет все тестовые поля ввода на кнопки 
    用 JS 编写一个函数，用页面上的按钮替换所有测试输入字段
    ```javascript
    function replaceAllTextInputs(){
        Array.from(document.querySelectorAll("input[type=text], textarea"))
            .forEach(input => {
                let button = 		document.createElement('button').setAttribute("value",input.value);
                input.replaceWith(button);
            });
    }
    ```
  
## Билет 4

  - коды состояния HTTP HTTP 状态码
    - 1 - informational
    - 2 - success
    - 3 - redirection
    - 4 - client error
    - 5 - server error

  - Фильтры запросов. Реализация пред и пост обработки запросов  
    请求过滤器。请求前后处理的实现
    - Изменяем его url-pattern. Если в него клиент то пост, если в него servlet то пред

  - написать css правило, которое повернёт все картинки в форме с id=sampleForm на 90 градусов по часовой стрелке  
    编写一个 css 规则，将 id=sampleForm 形式的所有图像顺时针旋转 90 度
    ```css
    #sampleForm img{
    ​    transform: rotate(90deg)
    }
    ```

## Билет 5

  - Структура Html-документа
    ```html
    <!DOCTYPE html> <!--заявление о документе-->
    <html>

        <head>
            <meta charset="utf-8">
            <!--заголовок, содержит метаинформацию о документе-->
        </head>

        <body>
        ​    <!--тело документа, содержит все содержимое видимой страницы-->
        </body>
    
    </html>
    ```
    
  - Servlet - особенности, отличия от CGI/ FastCGI
    - CGI
      - 当用户访问我们的 Web 应用时，会发起一个 HTTP 请求。最终 Web 服务器接收到这个请求
      - Web 服务器创建一个新的 CGI 进程。在这个进程中，将 HTTP 请求数据已一定格式解析出来，并通过标准输入和环境变量传入到 URL 指定的 CGI 程序（PHP 应用 `$_SERVER`） 
      - Web 应用程序处理完成后将返回数据写入到标准输出中，Web 服务器进程则从标准输出流中读取到响应，并采用 HTTP 协议返回给用户响应
    - FastCGI
      - FastCGI 允许应用服务进程复用同一个监听端口，多线程并行处理请求
      - FastCGI 进程管理器启动时会创建一个 主（Master） 进程和多个 CGI 解释器进程（Worker 进程），然后等待 Web 服务器的连接。
      - Web 服务器接收 HTTP 请求后，将 CGI 报文通过 套接字（UNIX 或 TCP Socket）进行通信，将环境变量和请求数据写入标准输入,转发到 CGI 解释器进程。
      - CGI 解释器进程完成处理后将标准输出和错误信息从同一连接返回给 Web 服务器。
      - CGI 解释器进程等待下一个 HTTP 请求的到来。
    - Servlet только занимает один процесс с могими потоками чтобы контролировать запросы. А CGI один запрос, один процесс.Eсли в FastCGI , так, как вы сами напишете
      - 特性：
        - Servlet 具备 Java 的平台无关性
        - 高效，每次调用 Servlet 时并不是新启用一个进程，而是在一个 Web 服务器的进程中共享和分离线程
      - 原理
        - 首先，由客户端发起请求。
        - 然后，Servlet 容器接收到客户端的请求，解析请求协议和数据，如果 servlet 程序还没有被加载，就会执行加载过程并调用 service() 方法，否则直接调用 service() 方法。
        - 最后，如果关闭Servlet容器时，这个时候，Servlet 容器就会根据契约，调用 destroy() 方法，该方法一般都用来编写一些释放资源的逻辑
  
  - Написать CSS правило, которое будет обводить все картинки в классе news в рамку при наведении мышю  
    编写一个 CSS 规则，在悬停时将新闻类中的所有图像框在一个框架中
    ```css
    .news img:hover{
    ​	  border:5px solid black;
    }
    ```
  
## Билет 6

  - Super agent

    - Superagent is a powerful and well-readable lightweight ajax API, a library about HTTP, Easy to learn and use  
      Superagent 是一个强大且易读的轻量级 ajax API，一个关于 HTTP 的库，易于学习和使用

      ```javascript
      var superagent = require('superagent');

      superagent
          .post('/api')
          .send({
              'key': 'value'
          })
          .set('header_key', 'header_value')
          .end(function(err, res) {
              if (err) {
                  //产生错误执行语句
              } else {
                  //执行语句
              }
          })
      ```

  - Шаблоны проектирования, архитектурные, для чего нужны, разница 设计模式、架构、它们的用途、区别  
    - проектирования - повторная архитектурная контрукция как решение типовой проблемы  
      设计模式——重新架构设计作为一个常见问题的解决方案 
    - архитекрурные: Более высокий уровень. Дело обычно с целыми компонентами или модуль. Описывают структуру всей системы или приложения
      架构——更高的级别。 这种情况通常是描述整个系统或应用程序的组件或模块

  - Jquery ajax запрос на сервлет, ответ от сервлета - объект json, вывести на страницу firstname, lastname, img_url
    ```javascript
    $.ajax({
      ​	url: "url of servlet"
      ​	data: {img_url: 'img_url',lastname:'lastname',firstname:'firstname'}
      ​	dataType: "json"
    })
    ```

## Билет 7

  - DOM и BOM
    - DOM（document object model） 是文档对象模型，处理网页内容的方法和接口，是针对 XML 的基于树的API。描述了处理网页内容的方法和接口，是HTML和XML的API，DOM把整个页面规划成由节点层级构成的文档

      ![avatar](pic/Rubiesh-7.1.png)
    - BOM（browser object model） 是浏览器对象模型，提供与浏览器交互的方法和接口，例如跳转到另一个页面、前进、后退、获取屏幕的大小之类的参数等

      ![avatar](pic/Rubiesh-7.2.png)

  - Управление сессией. HttpSession.
    - Создание: 
      1. 对于 Jsp: 若当前页面为浏览器（客户端）访问web应用的第一个资源页面且 Jsp的 Page 指定的 Session 属性的值为 true
      2. 对于 Servlet: 若当前 Servlet 为浏览器（客户端）访问 web 应用的第一个资源时，使用 request.getSession() 或 request.getSession(true) 创建
    - Получение: Получить из Cookie
    - Destroy: session.invalidate() или в элементе <session-timeout> определяет время жизни
  - Написать JS-функцию, которая запрещает вводить любые символы, кроме цифр и букв латинского алфавита 
    ```javascript
    function fixValue(){
    ​    if (this.value.match(*/[ ^ a-z0-9]/ig*) !== null)
            ​this.value = '';
    }  

    function setValidation(){      
    ​    let inputs = document.querySelectorAll('input[type=text], input[type=email], input[type=password], textarea');  
    ​    Array.from(inputs).forEach( 
            ​input => {     
    ​            input.addEventListener('input', fixValue)
    ​       } 
    ​    );
    }
    ```

## Билет 8

  - CSS : назначение, правила, приоритеты
    - определяет как страница выглядит. Разделение содержимого и представления

    ```css
    Selector{

      key : value

    }
    ```

    - `!important >` в `<style = ""> > #id >` колчество class(тем больше, тем выше) >  количество имени

  - MVC : назначение, элементы, примеры реализации
    - Основная цель применения этой концепции состоит в отделении [бизнес-логики](https://ru.wikipedia.org/wiki/Бизнес-логика) (*модели*) от её визуализации.За счёт такогповышается возможность [повторного использования кода](https://ru.wikipedia.org/wiki/Повторное_использование_кода).
    -  Сontroller(управляет другие), Model(как работает), View(как выглядит)

  - Реализовать функцию на JavaScript, которая будет закрывать текущее окно, если в нем открыт [https://www.google.ru](https://www.google.ru/) ([Возможный ответ](http://pastebin.com/72gLeMH7))
    ```javascript
    // Реализовать функцию на JavaScript, которая будет закрывать текущее окно, если в нем открыт https://www.google.ru
 
    function close(){
        let isGoogle = documet.URL.match(/^https?:\/\/(www\.)?google\.com(\/.*)?$/ig);
        if (isGoogle)
        window.close();     
    }
    ```

## Билет 9

  - AJAX и DHTML - описание, сходства и различия

    - DHTML: Css, JS, Dom, HTML. Динамичеки изменяет страницу при операции позователя
    - AJAX: XmlHttpRequest(). Отправить запрос в север, и потом динамически изменять страницу на основе ответа.
    - Все могут  динамичеки изменять страницу
    - DHTML все операции совершенны в клиенте.  AJAX взаймодействует с сервером

  - Какие проблемы возникают при параллельной обработке запросов в JSP, как этого можно избежать?  
     Может быть конфликты. Непредсказуемые процесс программы и результаты. Можем делать асихронно или savebuy().  
  - Написать js функцию, которая заменяет содержимое с именем класса "nyan" на изображение по ссылке: http://www.example.com/nyancat.gif ([Возможный ответ](http://pastebin.com/HFiFU850))
    ```javascript
    // Написать js функцию, которая заменяет содержимое <div> с именем класса "nyan"  
    // на изображение по ссылке: http://www.example.com/nyancat.gif   

    function replaceWithNyan(){    
        let img = document.createElement('img');  
        img.src = 'http://www.example.com/nyancat.gif';   
        Array.from(document.querySelectorAll('.nyan')).forEach(   
            div => {       
                div.innerHTML = '';       
                div.appendChild(img);     
            }      
        );     
    }
    ```
## Билет 10

  - Rest и RPC

    - REST будет использовать все методы HTTP, а RPC только будет использовать Get и  Post
    - Rest - подход к архитектуре сетевых протоколов, обеспечивающих доступ к ресурсам
    - RPC - подход, основенный на вызове удаленных процедур

  - RequestDispatcher

    - Полученны из контекста(абсолютная путь) или request(абсолютная или относительная)
    - dispatch the request to another resource with forward();

  - Правило css, меняющее цвет фона на желтый, если ссылка посещена и не лежит в классе "news" ([Возможный ответ](http://pastebin.com/Y9Crhmaq))
    ```css
    not(.news)>a:visited {
        color: yellow;
    }
    ```

## Билет 11

  - javascript, особенности, что для чего и тд

    - объектно-ориентированный скриптовый язык программирования для придания интерактивность странтицам.
    - Из ECMAscript, DOM, BOM

  - JSP actions

    - XML-элемент, позволяющие управлять поведением сервлет
    - <jsp : action attribute = "value"/>

  - php скрипт, который достаёт из get запроса имя и фамилию и приветствует пользователя, выводя html страницу ([Возможный ответ](http://pastebin.com/pWbJWbM5))
    ```php
    <?php     
    $name = $_GET['name'];     
    echo 'Hello ' . ($name?$name:'noname');
    ?>
    ```

## Билет 12:

  - структура протокола http, характеристики

    Сообщение(запрос и ответ, они все состоят из стартовой строки, заголовка и тело) и соединение. И каждый запрос имеет свой TCP соединение.

  - жизненный цикл jsp

    - Трансляция в сервлет
    - компиляция сервлета
    - загразка класса сервлета
    - создать экземпляра сервлета
    - вызов jspinit()
    - вызов jspService()
    - вызов jspDestroy

  - написать на php класс ([Возможный ответ](http://pastebin.com/qy4x8CTa))
    ```php
    class User{
        private $userName;
        private $age;

        function __constuctor($userName, $age){
        ​    $this->userName = $userName;
        ​    $this->age = $age;
        }

        function whois(){
        ​    return 'Name: ' . $this->userName . '\nAge: ' . $this->age;
        }
    }
    ```

## Билет 13

  - Преимущества и недостатки ajax

    - Экономия трафика, уменшение нагрузка на сервер, ускорение реакции интерфейса
    - усложение проекта, требуется javascript, отсутствие интеграции со стандартными инструментами браузера

  - Директива page: назначение, особенности, атрибуты

    - управлять параметр JSP страницы
    - `<% @ directive attribute = "value" %>`
    - атрибуты определяют что делать

  - Написать конфигурацию сервлета (org.xxx.MyServlet) с помощью аннотации. Сервлет должен принимать все запросы от файлов .html .xhtml
    ```java
    @WebServlet(name = "org.xxx.MyServlet", value = "/servlet")
    ```

## Билет 14

  - структура http запроса

    ![avatar](pic/Rubiesh-1.1.png)
    ![avatar](pic/Rubiesh-1.2.png)

  - типы данных php

    `interger`, `float`, `double`, `boolean`, `string`, `NULL`

  - сервлет перенаправляющий все запросы на страницу google ([Возможный ответ](http://pastebin.com/EnTVLpNG))
    ```java
    class ToGoogleServlet extends HttpServlet{
    ​    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    ​response.sendRedirect("http://google.com;")
    ​    }
    }
    ```

## Билет 15

  - Php, особенности и запуск

     скриптовый язык, часто используемый для написания веб-приложений.  ООП

  - Long Polling vs WebSockets

    Long polling is much more resource intensive on servers whereas WebSockets have an extremely lightweight footprint on servers. Long polling also requires many hops between servers and device

  - Написать JSP страницу, которая будет возвращать количество сессий, обратившихся к ней за последние 60 секунд и формировать вывод в HTML

    в jsp

    ```jsp
    <%Enumeration e = session.getAttributeNames();
        int count = 0;
        while(e.hasMoreElements()) {
            count = count+1;
            e.nextElement();
        }
        response.getWriter().println(e);
    %>
    ```

    в xml

    ```xml
      <session-config>
        <session-timeout>60</session-timeout>
      </session-config>
    ```

## Билет 16:

  - элементы JSP  
    `<%-- omment --%>` `<%@ directive %>` `<%! decl%>` `<% code %>` `<%= expression%>`
  - CGI - обработка запроса, преимущества и недостатки  
    Вызов программ на севере использователем. Каждый запрос обрабатывается одельным процессом СGI-прогораммы  
    - Преимущества: программы могут быть написаы на множестве языков  
      исключены конфликты при параллельной обработке  
      ​нескольких запросов  
    -  Недостатки: Высокие расходы. Слабое разделение уровня представления и бизнес-логики

  - Написать сервлет, который принимает из http запроса параметр name и выводит его. Если параметр не обнаружен то вывести Anonymous user ([Возможный ответ](http://pastebin.com/tHgjJSLz))
    ```java
    import java.io.PrintWriter;
    import java.io.IOException;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServleResponse;
    
    
    class HelloServlet extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
response.setContentType("text/html; charset=UTF-8");
    
    String name = request.getParameter("name");
    PrintWriter out = response.getWriter();
    
    name = name==null?"Anonymous user":name;
    out.println("<h1>Hello " + name + "</h1>");
    out.close();
    }
    }
    ```

## Билет 17:

  - FastCGI. Плюсы, минусы, отличия от CGI
    -  Безопасность, высокая стабильность, быстрее
    -  Не может работать долго, иначе север его убирает.
    -  Все запросы могут обрабатываться одним процессом
  - Суперглобальные массивы в PHP (SuperGlobal massive)  
    Предопределённые массивы, имеющие глобальную область видимости
    - `$_GLOBALS` - массив всех глобальных переменных
    - `$_SERVER` - параметры, которые ОС передаёт серверу при его запуске
    - `$_ENV` - переменные среды ОС
      `$_POST, $_GET, $_COOKIE, $_REQUEST, $_FILE, $_SESSION`
  - Страница JSP, проверяющая есть ли /какой-то параметр/ в запросе и если нету - выводящая сообщение об ошибке ([Возможный ответ](http://pastebin.com/9yVFXZku))
    <%= request.getParameter("parameterName")==null?"400 - your did not set parameter":request.getParameter("parameterName") %>

## Билет 18

  - ООП в PHP

    Как java в PHP тоже есть класс. Наследование тоже не запрещено. Могут решить проблемы при создании экземплар.

  - Предопределенные переменные JSP

    Суперглобальные массивы в PHP (SuperGlobal massive)

  - Код фильтра запросов, запрещающий доступ к приложению неавторизированным пользователям(у неавт пол в запросе отсутствует заголовок x-application-user) ([Возможный ответ](http://pastebin.com/qTuT55Fg))
    ```java
    import java.io.*;
    import javax.servlet.*;
    import javax.servlet.http.*;
    
    // Код фильтра запросов, запрещающий доступ к приложению неавторизированным
    // пользователям(у неавт пол в запросе отсутствует заголовок x-application-user)
    
    class AuthFilter extends ServletFilter{
            public void init(FilterConfig config){}
    
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException{
                    String auth = request.getHeader("x-application-user");
                    if (auth == null || auth.equals("")){
                            PrintWriter out = response.getWriter();
                            response.setContentType("text/html; charset=UTF-8");
                            out.println("WTF?! You are not authorized");
                    }else{
                            chain.doFilter(request, response);
                    }
    
            }
    
            public void destroy(){}
    }
    ```

## Билет 19

  - Конфигурация PHP-интеррпретатора, способы интеграции PHP-интеррпретатора с веб-сервером

    -   интеграции PHP-интеррпретатора и веб-сервер являются средой PHP. 

  - ServletContext - особенности, для чего нужен

    -  контейнер, где сохраняет все данные в одном севере. Он общое пространство для всех клиенте
    -  Получения глобальные параметры. Читения файла ресурсов проектов. Переводить запрос

  - Код jsp-страницы показывающий содержимое корзины юзера. Содержимое корзины - коллекциия объектов класса ShoppingItem который содержит имя, стоимость и количество заказанного товара - хранится в отдельном managed bean. ([Возможный ответ](http://pastebin.com/pBA7f4Zt))
    ```jsp
    <%@ import="my.package.ShoppingItem" %>
    <%@ import="java.util.Collection" %>
    <%@ contentType="text/html;charset=UTF-8" language="java"%>
    <jsp:useBean id="managed" class="my.package.ManagedBean" scope="session">
    <html>
    <head>
            <meta charset="utf-8">
    </head>
    <body>
    <table>
            <tr>
                    <th>name</th>
                    <th>price</th>
                    <th>count</th>
            </tr>
    <% Collection<ShoppingItem> basket = mananged.getBasket();
            for (ShoppingItem position: basket){ %>
                    <tr>
                            <td><%= position.getName() %></td>
                            <td><%= position.getPrice() %></td>
                            <td><%= position.getCount() %></td>
                    </tr>
            <%}%>
    </table>
    </body>
    ```

## Билет 20

  - HTML формы

    - cбор ввод разных видов использователя

      text, checkbox, radio, button, password

       action = "url" - куда отправитьs

  - конфигурация сервлетов. файл web.xml
    ```xml
    <servlet>
      ​	<servlet-name>name</servlet-name>
      ​	<servlet-class>classname</servlet-class> 
    </servlet>

    <servlet-mapping>
      ​	<servlet-name>name</servlet-name>
      ​	<url-pattern>/url</url-pattern>
    </servlet-mapping>
    ```

  - написать css правило, которое при клике на ссылку добавляет ей подчеркивание, всем кроме ссылок в теге h1 ([Возможный ответ](http://pastebin.com/Y9Crhmaq))
    ```
    not(h1) a:active {
      text-decoration: underline;
    }
    ```

## Билет 21

  - jQuery.
    - Библиотека Javascript, чтобы легче использовать javascript 
  - Архитектуры model 1 и model 2.
    - model 1: клиент отправляет запросы jsp или сервлет. И потом то jsp (или сервлет) завершает все задания
    - model 2: обычно при MVC. Задания завершены нескольких jsp( или сервлетов)
  - Написать php скрипт, формирующий форму для ввода логина и пароля и отправляющий запрос сервису authorize.php с помощью UserAgent. Если пользователь корректный, то скрипт должен редиректить на страницу pagename.php.

## Билет 22

  - Экмаскрипт, преимущества 6й и 7й версии
    - Можно писать класс
    - Новые операции, например, функция с ->(похож на lambda в java), которые упрощают прогромирование
  - ГоФ паттерны. Что такое? Основные виды, примеры
    - Повторимая архитектурная конструкция, которая решает какую-то проблема.
    - Порождающие: builder, factory, одиночка
      Структурная: bridge, proxy, adapter, decorator
      Поведенческие: command, iterator, observer
  - Написать html страницу и сервлет, возвращающий странице количество активных сессий

## Билет 23

  - обработка http с помощью servlet
    - При помощи HttpServletRequest получить запрос и делать обработку. И ответ сохраняется в HttpServletResponse
  - многоуровневая архитектура приложения
    - Presentatio: самый верхний уровень. Что мы видим
    - logic: Между другими двумя.Получать запрос, читать данные из data, делать обработку, отправить результат клиенту  
    - data:Сохранение данных
  - с помощью jquery посчитать количество div с классом lecture содержащие «де-факто»

## Билет 24

  - ECMAScript, типы данных, особенности, инструкции
    - это встраиваемый расширяемый не имеющий средств [ввода-вывода](https://ru.wikipedia.org/wiki/Ввод-вывод) язык программирования,  для построения других скриптовых языков
    - примитивные: Number,String,Boolean, Null, Undefined  
      составные: Object, List, Reference
    - Блок, переменное, выражение, цикл, исключение и так далее. В ES6 есть Класс
  - цикл жизни jsp
    - Трансляция в сервлет
    - компиляция сервлета
    - загразка класса сервлета
    - создать экземпляра сервлета
    - вызов jspInit()
    - вызов jspService()
    - вызов jspDestroy()
  
  - html форма отправляющая номер вопроса и выбор от a до f
    ```html
    <body>
        <script>
            function send(){
              let form = document.getElementById("form");
              let data = new FormData(form)
              let request = new XMLHttpRequest();
              request.open("POST","url");
              request.send()
            }
        </script>

        <form id = "form" method = "post" action = "url" onsubmit = send()>
            <input type = radio value = "a" name = "choice">a<br>
            <input type = radio value = "b" name = "choice">b<br>
            <input type = radio value = "c" name = "choice">c<br>
            <input type = radio value = "d" name = "choice">d<br>
            <input type = radio value = "e" name = "choice">e<br>
            <input type = radio value = "f" name = "choice">f<br>
        </form>
    <body>
    ```