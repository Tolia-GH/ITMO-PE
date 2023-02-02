# Рубежка №1

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
                let button = document.createElement('button').setAttribute("value",input.value);
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
      border:5px solid black;
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
      ​url: "url of servlet"
      ​data: {img_url: 'img_url',lastname:'lastname',firstname:'firstname'}
      ​dataType: "json"
    })
    ```

## Билет 7

  - DOM и BOM
    - DOM（document object model） 是文档对象模型，处理网页内容的方法和接口，是针对 XML 的基于树的API。描述了处理网页内容的方法和接口，是HTML和XML的API，DOM把整个页面规划成由节点层级构成的文档

      ![avatar](pic/Rubiesh-7.1.png)
    - BOM（browser object model） 是浏览器对象模型，提供与浏览器交互的方法和接口，例如跳转到另一个页面、前进、后退、获取屏幕的大小之类的参数等

      ![avatar](pic/Rubiesh-7.2.png)

  - Управление сессией. HttpSession.
    - Session：在计算机中，尤其是在网络应用中，称为“会话控制”。Session对象存储特定用户会话所需的属性及配置信息。这样，当用户在应用程序的 Web 页之间跳转时，存储在Session对象中的变量将不会丢失，而是在整个用户会话中一直存在下去。当用户请求来自应用程序的 Web页时，如果该用户还没有会话，则Web服务器将自动创建一个 Session对象。当会话过期或被放弃后，服务器将终止该会话
    - Создание: 
      1. 对于 php: 首先使用`session_start()`函数，PHP 从 session 仓库中加载已经存储的 session 变量，当执行PHP脚本时，通过使用`session_register()`函数注册 session 变量，当 PHP 脚本执行结束时，未被销毁的 session 变量会被自动保存在本地一定路径下的 session 库中，这个路径可以通过 php.ini 文件中的session.save_path 指定，下次浏览网页时可以加载使用
      2. 对于 Jsp: 若当前页面为浏览器（客户端）访问 web 应用的第一个资源页面且 Jsp的 Page 指定的 Session 属性的值为 true
      3. 对于 Servlet: 若当前 Servlet 为浏览器（客户端）访问 web 应用的第一个资源时，使用 `request.getSession()` 或 `request.getSession(true)` 创建
    - Получение: Получить из Cookie
    - Destroy: `session.invalidate()` или в элементе <session-timeout> определяет время жизни
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
    - Cascading Style Sheets (CSS) is a style sheet language used for describing the presentation of a document written in a markup language such as HTML or XML.

    ```css
    Selector {
        key : value
    }
    ```

    - приоритеты
      - 继承性（Inheritance）：CSS 的继承特性指的是应用在一个标签上的那些 CSS 属性（Attributes）被传到其子标签上
      1. 最近的祖先样式比其他祖先样式优先级高
        ```html
        <!-- 类名为 son 的 div 的 color 为 blue -->
        <div style="color: red">
            <div style="color: blue">
                <div class="son"></div>
            </div>
        </div>
        ```
      2. 标签直接拥有的属性比从祖先那里继承来的属性优先级高
        ```html
        <!-- 类名为 son 的 div 的 color 为 blue -->
        <div style="color: red">
            <div class="son" style="color: blue"></div>
        </div>
        ```
      3. 优先级关系：内联样式 > ID 选择器 > 类选择器 = 属性选择器 = 伪类选择器 > 标签选择器 = 伪元素选择器  
        inline style > ID selector > class selector = attribute selector = pseudo class selector > tag selector = pseudo element selector
      4. 计算选择符中 ID 选择器的个数（a），计算选择符中类选择器、属性选择器以及伪类选择器的个数之和（b），计算选择符中标签选择器和伪元素选择器的个数之和（c）。按 a、b、c 的顺序依次比较大小，大的则优先级高，相等则比较下一个。若最后两个的选择符中 a、b、c 都相等，则按照"就近原则"来判断
      5. 属性后插有 `!important` 的属性拥有最高优先级。若同时插有 `!important`，则再利用规则 3、4 判断优先级

  - MVC : назначение, элементы, примеры реализации

    ![](pic/Rubiesh-8.1.png)
    - MVC 是软件工程中的一种软件架构模式，把软件系统分为三个基本部分：模型（Model）、视图（View）和控制器（Controller）
      - 模型（Model） - 程序员编写程序应有的功能（实现算法等等）、数据库专家进行数据管理和数据库设计(可以实现具体的功能)
      - 视图（View） - 界面设计人员进行图形界面设计
      - 控制器（Controller）- 负责转发请求，对请求进行处理
    - JavaScript 范例
      ```javascript
      /** 模拟 Model, View, Controller */
      var M = {}, V = {}, C = {};

      /** Model 负责存放资料 */
      M.data = "hello world";

      /** View 负责将资料输出给用户 */
      V.render = (M) => { alert(M.data); }

      /** Controller 作为连接 M 和 V 的桥梁 */
      C.handleOnload = () => { V.render(M); }

      /** 在网页读取的时候呼叫 Controller */
      window.onload = C.handleOnload;
      ``` 
    - Основная цель применения этой концепции состоит в отделении [бизнес-логики](https://ru.wikipedia.org/wiki/Бизнес-логика) (*модели*) от её визуализации.За счёт такого повышается возможность [повторного использования кода](https://ru.wikipedia.org/wiki/Повторное_использование_кода).  
      应用这个概念的主要目的是将业务逻辑（模型）与其可视化分离，因此增加了代码重用的可能性。

  - Реализовать функцию на JavaScript, которая будет закрывать текущее окно, если в нем открыт [https://www.google.ru](https://www.google.ru/) ([Возможный ответ](http://pastebin.com/72gLeMH7))
    实现一个 JavaScript 函数，如果 [https://www.google.ru](https://www.google.ru/) 在其中打开，该函数将关闭当前窗口
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
      在调用者操作时动态更改页面
    - AJAX: `XmlHttpRequest()`. Отправить запрос в север, и потом динамически изменять страницу на основе ответа.
      向服务器发送请求，然后根据响应动态更改页面。
    - Все могут динамичеки изменять страницу 
      都可以动态改变页面
    - DHTML все операции совершенны в клиенте.  AJAX взаймодействует с сервером  
      DHTML 的所有操作都在客户端完成，而 AJAX 需要与服务器交互

  - Какие проблемы возникают при параллельной  обработке запросов в JSP, как этого можно избежать?  
    JSP 并行处理请求会出现什么问题，如何避免？ 
    Может быть конфликты. Непредсказуемые процесс программы и результаты. Можем делать асихронно или `savebuy()`.  
    可能会有冲突。 不可预测的程序过程和结果。 我们可以异步（asynchronously）或 `savebuy()` 来完成
  - Написать js функцию, которая заменяет содержимое с именем класса "nyan" на изображение по ссылке:  
    编写一个 js 函数，将类名“nyan”的内容替换为链接处的图片：http://www.example.com/nyancat.gif ([Возможный ответ](http://pastebin.com/HFiFU850))
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
      REST 将使用所有 HTTP 方法，而 RPC 将仅使用 Get 和 Post
    - Rest - подход к архитектуре сетевых протоколов, обеспечивающих доступ к ресурсам
      一种提供资源访问的网络协议架构方法 
    - RPC - подход, основенный на вызове удаленных процедур  
      基于远程过程调用的方法

  - RequestDispatcher

    - Полученны из контекста(абсолютная путь) или request(абсолютная или относительная)  
      从上下文（绝对路径）或请求（绝对或相对）获取
    - dispatch the request to another resource with `forward()`;  
      使用 `forward()` 将请求分派到另一个资源

  - Правило css, меняющее цвет фона на желтый, если ссылка посещена и не лежит в классе "news" ([Возможный ответ](http://pastebin.com/Y9Crhmaq))
    ```css
    not(.news)>a:visited {
        color: yellow;
    }
    ```

## Билет 11

  - javascript, особенности, что для чего и тд
    - javascript is a script language based on objects and events, it defines the behaviors of websites
    - 解释型语言（interpreted language），边运行边解释
    - 基于对象
    - 弱类型的
    - 动态的
    - 跨平台的（仅需浏览器支持，无需通过 web 服务器）

  - JSP actions

    - XML-элемент, позволяющие управлять поведением сервлет  
      用于控制 servlet 行为的 XML 元素  
      `<jsp : action attribute = "value"/>`

  - php скрипт, который достаёт из get запроса имя и фамилию и приветствует пользователя, выводя html страницу ([Возможный ответ](http://pastebin.com/pWbJWbM5))
    ```php
    <?php     
    $name = $_GET['name'];     
    echo 'Hello ' . ($name?$name:'noname');
    ?>
    ```

## Билет 12:

  - структура протокола http, характеристики  http协议结构、特点
    - 结构
     
      ![avatar](pic/Rubiesh-1.1.png)
      ![avatar](pic/Rubiesh-1.2.png)

      Сообщение(запрос и ответ, они все состоят из стартовой строки, заголовка и тело) и соединение. И каждый запрос имеет свой TCP соединение.  
      消息（请求和响应，它们都由起始行、标题和正文组成）和连接。 每个请求都有自己的 TCP 连接。
    - 特点
      - 支持客户/服务器模式
      - 简单快速：客户向服务器请求服务时，只需传送请求方法和路径，因而 HTTP 服务器的程序规模小，通信速度很快
      - 灵活：HTTP允许传输任意类型的数据对象。正在传输的类型由 Content-Type 加以标记
      - 无连接：无连接的含义是限制每次连接只处理一个请求。服务器处理完客户的请求，并收到客户的应答后，即断开连接。采用这种方式可以节省传输时间
      - 无状态：HTTP协议是无状态协议。无状态是指协议对于事务处理没有记忆能力。缺少状态意味着如果后续处理需要前面的信息，则它必须重传，这样可能导致每次连接传送的数据量增大。另一方面，在服务器不需要先前信息时它的应答就较快

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

- AJAX 是一种在无需重新加载整个网页的情况下，能够更新部分网页的技术
  - 优点
    - 能在不刷新整个页面的前提下与服务器通信维护数据。这使得Web应用程序更为迅捷地响应用户交互，并避免了在网络上发送那些没有改变的信息，减少用户等待时间
    - AJAX 使用异步方式与服务器通信，不需要打断用户的操作，具有更加迅速的响应能力。优化了 Browser 和S erver 之间的沟通，减少不必要的数据传输、时间及降低网络上数据流量
    - AJAX 可以把以前一些服务器负担的工作转嫁到客户端，利用客户端闲置的能力来处理，减轻服务器和带宽的负担，提升站点性能
    - AJAX 使 WEB 中的界面与应用分离（也可以说是数据与呈现分离），有利于分工合作、减少非技术人员对页面的修改造成的WEB应用程序错误、提高效率、也更加适用于现在的发布系统
  - 缺点：
    - 在动态更新页面的情况下，用户无法回到前一个页面状态
    - AJAX 暴露了浏览器与服务器交互的细节
    - 对搜索引擎的支持比较弱。如果使用不当，AJAX 会增大网络数据的流量，从而降低整个系统的性能
    - 破坏程序的异常处理机制
    - AJAX 不能很好支持移动设备

  - Экономия трафика, уменшение нагрузка на сервер, ускорение реакции интерфейса
  - усложение проекта, требуется javascript, отсутствие интеграции со стандартными инструментами браузера

- Директива page: назначение, особенности, атрибуты
  - JSP страница может послать сообщение соответствующему контейнеру с указаниями действий, которые необходимо провести. Эти сообщения называются директивами.  
  JSP 页面可以向适当的容器发送一条消息，其中包含有关操作的说明。 这些消息称为指令
  - Все директивы начинаются с <%@, затем следует название директивы и один или несколько атрибутов со значениями, и заканчиваются %>. Форму записи директив можно изобразить следующим образом:  
    所有指令均以 <%@ 开头，后跟指令名称和一个或多个属性值，并以 %> 结尾。指令的形式可以表示如下：
  - `<%@ directive attribute = "value" %>`
  - 页面指令选项
    - import 使一个JAVA导入声明被插入到最终页面文件。
    - contentType 规定了生成内容的类型。当生成非HTML内容或者当前字符集并非默认字符集时使用。
    - errorPage 处理HTTP请求时，如果出现异常则显示该错误提示信息页面。
    - isErrorPage 如果设置为TRUE，则表示当前文件是一个错误提示页面。
    - isThreadSafe 表示最终生成的servlet是否具有线程安全性。

- Написать конфигурацию сервлета (org.xxx.MyServlet) с помощью аннотации. Сервлет должен принимать все запросы от файлов .html .xhtml  
  使用注释编写 servlet 配置 (org.xxx.MyServlet)。 servlet 必须接受来自 .html .xhtml 文件的所有请求
  ```java
  @WebServlet(name = "org.xxx.MyServlet", value = "/servlet")
  ```

## Билет 14

  - структура http запроса

    ![avatar](pic/Rubiesh-1.1.png)
    ![avatar](pic/Rubiesh-1.2.png)

  - типы данных php

    `interger`, `float`, `double`, `boolean`, `string`, `NULL`

  - сервлет перенаправляющий все запросы на страницу google  
    将所有请求重定向到谷歌页面的 servlet（[Возможный ответ](http://pastebin.com/EnTVLpNG)）
    ```java
    class ToGoogleServlet extends HttpServlet{
    ​    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
            ​response.sendRedirect("http://google.com;")
    ​    }
    }
    ```

## Билет 15

  - Php, особенности и запуск
    - PHP is a open-soursce general-perpose scripting language, suitable for web development, and can be embedded in HTML, often used ny developers to write dynamic page.
    - characteristics
      - OOP
      - type-weak language
      - Cross-platform, run on web server
      - simple gramma
    - runing
      - Scanning: convert php code to language tokens
      - Parsing: convert tokens to meaningful expression
      - Compilation: compile expretion to opcodes
      - Execution: execute opcodes in order, to realize php funxtions

  - Long Polling vs WebSockets

    Long polling is much more resource intensive on servers whereas WebSockets have an extremely lightweight footprint on servers. Long polling also requires many hops between servers and device
    长轮询在服务器上占用的资源要多得多，而 WebSockets 在服务器上的占用空间非常小。 长轮询还需要在服务器和设备之间进行多次跳转

  - Написать JSP страницу, которая будет возвращать количество сессий, обратившихся к ней за последние 60 секунд и формировать вывод в HTML 
    编写一个 JSP 页面，该页面将返回在过去 60 秒内访问它的会话数并以 HTML 格式生成输出

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
    - Вызов программ на севере использователем. Каждый запрос обрабатывается одельным процессом СGI-прогораммы  
    用户调用服务器上的程序。 每个请求都由一个单独的 CGI 程序进程处理
    - Преимущества: программы могут быть написаы на множестве языков  
      优点：可以用多种语言编写程序  
      исключены конфликты при параллельной обработке   ​нескольких запросов  
      消除了并行处理多个请求时的冲突
    - Недостатки: Высокие расходы. Слабое разделение уровня представления и бизнес-логики 
      缺点：成本高。 表示层和业务逻辑之间的弱分离

  - Написать сервлет, который принимает из http запроса параметр name и выводит его. Если параметр не обнаружен то вывести Anonymous user  
    编写一个从 http 请求中获取名称参数并将其输出的 servlet。 如果未找到该参数，则显示匿名用户 ([Возможный ответ](http://pastebin.com/tHgjJSLz))
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
    - Безопасность, высокая стабильность, быстрее 
      安全、高稳定、更快  
    - Не может работать долго, иначе север его убирает.  
      它不能长时间工作，否则服务器将其删除。
    - Все запросы могут обрабатываться одним процессом 
      所有请求都可以由一个进程处理
  - Суперглобальные массивы в PHP (SuperGlobal massive)  
    Предопределённые массивы, имеющие глобальную область видимости  PHP 中的超全局数组 (SuperGlobal massive)
    - `$_GLOBALS` - массив всех глобальных переменных 所有全局变量的数组
    - `$_SERVER` - параметры, которые ОС передаёт серверу при его запуске 操作系统启动时传递给服务器的参数
    - `$_ENV` - переменные среды ОС 操作系统环境变量
      `$_POST, $_GET, $_COOKIE, $_REQUEST, $_FILE, $_SESSION`
  - Страница JSP, проверяющая есть ли /какой-то параметр/ в запросе и если нету - выводящая сообщение об ошибке 
    检查请求中是否有/some parameter/的JSP页面，如果没有，则显示错误消息 ([Возможный ответ](http://pastebin.com/9yVFXZku))
    ```java
    <%-- Страница JSP, проверяющая есть ли /какой-то параметр/ в запросе и если нету - выводящая сообщение об ошибке  --%>
 
    <%@ page contentType="text/html; charset=UTF-8" language="java"%>
    <%= request.getParameter("parameterName")==null?"400 - your did not set parameter":request.getParameter("parameterName")  %>
    ```

## Билет 18

  - ООП в PHP

    Как java в PHP тоже есть класс. Наследование тоже не запрещено. Могут решить проблемы при создании экземплар.
    和java一样，PHP也有一个类。 继承也不被禁止。 可以解决创建实例时的问题。

    ```php
    <?php
    class phpClass {
      var $var1;
      var $var2 = "constant string";
      
      function myfunc ($arg1, $arg2) {
        [..]
      }
      [..]
    }
    ?>
    ```

  - Предопределенные переменные JSP

    Суперглобальные массивы в PHP (SuperGlobal massive)

  - Код фильтра запросов, запрещающий доступ к приложению неавторизированным пользователям(у неавт пол в запросе отсутствует заголовок x-application-user)  
    拒绝未经授权用户访问应用程序的请求过滤器代码（请求中的非授权字段没有 x-application-user 标头）  ([Возможный ответ](http://pastebin.com/qTuT55Fg))
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
    ```html
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
      `action = "url"` - куда отправитьs

  - конфигурация сервлетов. файл web.xml servlet 配置
    ```xml
    <servlet>
      ​<servlet-name>name</servlet-name>
      ​<servlet-class>classname</servlet-class> 
    </servlet>

    <servlet-mapping>
      ​<servlet-name>name</servlet-name>
      ​<url-pattern>/url</url-pattern>
    </servlet-mapping>
    ```

  - написать css правило, которое при клике на ссылку добавляет ей подчеркивание, всем кроме ссылок в теге h1  
    写一个 css 规则，当点击一个链接时，给它添加一个下划线，除了 h1 标签中的链接 ([Возможный ответ](http://pastebin.com/Y9Crhmaq))
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
    使用 HttpServletRequest 接收请求并进行处理。 并且响应存储在 HttpServletResponse
- многоуровневая архитектура приложения 分层应用架构
  - Presentatio: самый верхний уровень. Что мы видим
  - logic: Между другими двумя.Получать запрос, читать данные из data, делать обработку, отправить результат клиенту  
  - data:Сохранение данных
- с помощью jquery посчитать количество div с классом lecture содержащие «де-факто»  
  使用 jquery 计算包含“事实上”的讲座类的 div 数量

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
    提交问题编号和从 a 到 f 的选择的 html 表单
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

# Рубежка №2

Это, надеюсь, сборник билетов по 2-ому рубежу 2022 по вебу. Оно обязательно заполнится…
Нумерация взята по выданным билетам, а в скобочках указан номер билета согласно этому доку.

Если вы не кидали свой билет, то докиньте. Если помните номер, тоже сообщите. Всем спасибо!

P.S. Документ в процессе редакции, попозже наведу красоту

## Билет ? (НОВЫЙ!)

## Билет 1
- Фазы jsf: Invoke Application и Render Response  
  jsf 阶段：调用应用程序和呈现响应  
  При поступлении запроса необходимо выполнить определенную цепочку действий, чтобы проанализировать запрос и подготовить ответ. За программиста это делает фреймворк(JSF)  
  当收到请求时，有必要执行特定的一系列操作以分析请求并准备响应。 程序员用框架来做这件事 (JSF)

  - Жизненный цикл запроса ответа: 响应请求生命周期：
    - Восстановление представления 恢复视图
    - Получение параметров запроса 获取请求参数
    - Проверка значений 值的验证
    - Обновление свойств бинов 更新 Bin 属性
    - Обработка приложения 处理请求
    - Формирования ответа 生成响应
  - Invoke Application(Обработка приложения) 调用应用程序  
    На данном этапе JSF обрабатывает события, вызванные нажатием кнопок, ссылок и т.д. Также решаются вопросы навигации(если ее затрагивали)  
    在此阶段，JSF 处理通过单击按钮、链接等触发的事件。 导航问题也已解决（如果受到影响）

    Вызывается метод `UIViewRoot#processApplication()` для обработки событий. Перехватить обработку можно переопределением `ActionListener`  
    调用 `UIViewRoot#processApplication()` 方法来处理事件。 可以通过重新定义 `ActionListener` 来拦截处理
  - Render Response(Формирование ответа) 呈现响应  
    JSF генерирует ответ, используя данные, полученные на предыдущих шагах. Обновляет представление страницы, используя managed bean, после чего генерируется html страница, которая отправляется пользователю. Так же, если на предыдущих шага происходили ошибки, то они собираются в тег `<messages>`.  
    JSF 使用在前面的步骤中接收到的数据生成响应。 使用托管 bean 更新页面视图，之后生成 html 页面并发送给用户。 此外，如果在前面的步骤中发生错误，它们将被收集在 `<messages>` 标记中。


- Способы задания конфигурации в Spring   
  Spring 配置方式

  1. конфигурация с помощью конфиг файла applicationContext.xml. 使用配置文件 applicationContext.xml 进行配置。
    В него в ручную прописываются все бины, создание объектов, их типы и т.д. Далее этот файл нужно указать при создании `ClassPathXmlApplicationContext`.  
    所有 bean、对象创建、它们的类型等都是手动写入其中的。接下来，必须在创建 `ClassPathXmlApplicationContext` 时指定此文件。
  2. конфигурирование спринга с помощью Java кода 使用 Java 代码的 spring 配置
    Для этого нужно создать класс с аннотацией Configuration, и в нем, путем добавления методов с различными аннотациями(bean например) конфигурировать спринг.  
    为此，您需要创建一个带有注解 `Configuration` 的类，并在其中通过添加带有各种注解的方法（例如 bean）来配置 spring。
  Так же спринг приложение можно конфигурировать только аннотациями, добавляя к классам аннотации Component, Bean и т.д. Внедрение зависимостей происходит через аннотацию Autowired.  
  另外，一个 spring 应用可以只配置注解，给类添加 Component、Bean 等注解。依赖注入通过 Autowired 注释发生。
- Написать исходный код CDI бина, реализующего паттерн «команда» (Command Pattern)  
  编写实现命令模式的 CDI bean 的源代码

  ```java
  interface Command {
    void execute();
  }

  @Named(value=”cmd1”)
  @ApplicationScoped
  public class Cmd1 implements Command {
    void execute() { ... };
  }

  @Named(value=”cmd2”)
  @ApplicationScoped
  public class Cmd2 implements Command {
    void execute() { ... };
  }

  @Named
  @ApplicationScoped
  public class MyBean implements Command {
    private final Command cmd1, cmd2;
  
    @Inject
    public MyBean(@Named(“cmd1”) Command cmd1, @Named(“cmd2”) Command cmd2) {
      this.cmd1 = cmd1;
      this.cmd2 = cmd2;
    }

    public void cmd(int n) {
      if (n == 1) cmd1.execute();
      if (n == 2) cmd2.execute();
    }
  }

  ```

## Билет 2
- Принципы IoC и CDI. Реализация в Java EE  
  - Inversion of Control (инверсия управления)   
    принцип работы программы, который диктует нам как писать слабо связанный код. Он говорит, что компонент системы должен быть как можно более изолированным от других. Так же есть IoC контейнер, который упрощает работу с компонентами, автоматизирует написание кода, в общем по максимуму берет работу с компонентами на себя.  
    Inversion of Control（控制反转）——程序的原理，它指示我们如何编写松散 耦合的代码。 他说系统组件应该尽可能地与其他组件隔离开来。 还有一个 IoC 容器可以简化组件的工作，自动编写代码，一般来说，最大限度地利用组件的工作。
  - Contexts and Dependency Injection(внедрение зависимостей)   
    позволяет снизить (или совсем убрать) зависимость компонента от контейнера (не требуется реализации каких-либо интерфейсов, не нужны прямые вызовы API, реализуется через аннотации).  
    让你减少（或完全移除）组件对容器的依赖（不需要接口，不需要直接调用API，它是通过注解实现的）。
  - IoC и CDI реализованы в Java EE IoC 和 CDI 在 Java EE 中实现
    1. создать файл beans.xml, куда прописать настройку всех созданных бинов.  
      创建一个 beans.xml 文件，您可以在其中为所有创建的 bean 设置设置
    2. с помощью аннотации Inject внедрить зависимость в конструкторы.  
      使用 Inject 注释，将依赖项注入构造函数
    Также у бинов есть скоупы (Request, Session, Application и тд), по которым контейнер, понимает когда уничтожать или создавать новый бин.  
    Bean 也有范围（请求、会话、应用程序等），容器通过这些范围了解何时销毁或创建新的 bean。
- Архитектура Vue.js (компоненты, экземпляры, директивы)  
  - Vue.js — JS фреймворк, для разработки UI. Использует архитектуру MVVM.  
    Vue.js 是一个用于 UI 开发的 JS 框架。 使用 MVVM 架构。

    MVVM — Паттерн разработки, позволяющий разделить приложение на три функциональные части:  
    MVVM 是一种开发模式，允许您将应用程序分为三个功能部分：

    - Model - основная логика программы (работа с данными, вычислениями, запросы и т.д.)  
      模型——程序的主要逻辑（处理数据、计算、查询等）
    - View - вид или представление (пользовательский интерфейс)  
      查看 - 外观或界面（用户界面）
    - ViewModel - модель представления, которая служит прослойкой между View и Model  
      一个视图模型，充当视图和模型之间的层

  - Экземпляр:  
    В любом приложении есть хотя бы 1(центральный) экземпляр.  
    每个应用程序至少有 1 个（中央）实例。  
    Экземпляр привязывается к узлу DOM, с помощью свойства `el`.  
    使用 `el` 属性将实例绑定到 DOM 节点。  
    У экземпляра есть: 该实例具有：  
    
    - `$data` — Объект с данными 带有数据的对象
    - `$props` — Объект, содержащий текущие входные параметры, которые получил компонент. 包含组件收到的当前的对象。
    - `$el` — элемент, которым управляет экземпляр 由实例管理的元素
    - `$methods` (тут понятно)
    - и другие по типу рутов, парентов и тд. 和其他按根，父母等类型。

  - Компонент:  
    расширяют функциональность экземпляров  
    扩展实例的功能
    не привязываются к узлам html, а используют собственную разметку, из-за чего их очень удобно переиспользовать.  
    不绑定 html 节点，而是使用自己的标记，这样复用起来非常方便。

  - Директивы:  
    Позволяют выполнять операции, например итерирование по массиву или включение элементов по условию.  
    允许您执行操作，例如遍历数组或按条件包含元素。
    В разметке представляют собой атрибуты тегов.  
    在标记中，它们是标记属性。
- JSF страница, динамически подгружаемая и выводящая новостную ленту с новостями формата: автор, заголовок, дата, иллюстрация, аннотация и полный текст (показывается при нажатии на соответствующую строчку)    
  动态加载和显示新闻提要的 JSF 页面，格式为：作者、标题、日期、插图、摘要和全文（单击相应行时显示）
  ```xhtml
  <html
  xmlns:f”http://…
  xmlns:h”http://…
  xmlns:ui”http://…>
  <f:view>
  <h:head>
    ...
      <title>JSF PAGE</title>
    ...
  <h:head>
  <h:body>
  ...
    <ui:repeat value”#{news.list} var=”news”>
      <h:outputText value=”#{news.title”} />
      <h:outputText value=”#{news.author”} />
      <h:graphicImage library="#{news.photo}" name="img.png"/>
      <h:outputText value=”Раскрыть новость”/>
      <h:outputText styleClass=”hid text” value=”#{news.text} />
    </ui:repeat>
    ...
  </h:body>
  </f:view>
  </html>
  ```

## Билет 3  
- Реализация шаблона MVC в JSF  
  - Model в JSF это managed bean, джава классы, которые содержат бизнес-логику и передаются юзеру. К ним указываются аннотации, с помощью которых настраивается их поведение.  
    JSF 中的模型是一个托管 bean，包含业务逻辑并传递给用户的 Java 类。 为它们指定了注释，并借助这些注释配置了它们的行为。

  - View в JSF это верстка, написанная в расширении xhtml. Это очень удобный формат,так как он понятен браузеру, а также его можно расширять, добавляя библиотеки.  
    JSF 中的视图是用 xhtml 扩展名编写的布局。 这是一种非常方便的格式，因为浏览器可以理解它，并且还可以通过添加库来扩展它。

  - Controller в JSF мы не пишем руками, он реализуется фреймворком, нам нужно лишь указывать в верстке action’ы по которым фреймворк будет понимать, что мы хотим получить.  
    我们不用在 JSF 中手写 Controller，它是由框架实现的，我们只需要在布局中指定动作，框架就会明白我们想要得到什么。
- Основные аннотации Java EE CDI  
  У CDI Bean’ов есть множество аннотаций: CDI Beans 有很多注解：
  - `@NoneScoped` - контекст не определён, жизненным циклом управляют другие бины;  
    未定义上下文，其他 beans 管理生命周期；
  - `@RequestScoped` - контекст - запрос;
    上下文 - 请求；
  - `@ViewScoped` - контекст-страница(компонент создается один раз при обращении к странице, и используется ровно столько, сколько пользователь находится на странице);
    页面上下文（该组件在访问页面时创建一次，并且只要用户在页面上就被使用）；
  - `@SessionScoped` - контекст - сессия;  
    上下文 - 会话；
  - `@ApplicationScoped` - контекст - приложение;  
    上下文 - 应用
  - `@CustomScoped` - компонент создается и сохраняется в коллекции типа Map. Областью жизни управляет программист.  
    组件被创建并存储在 Map 类型的集合中。 生活区由程序员管理。
  - `@Informal` — “бин-наследник”  
    继承 bean
  - `@Inject` - используется для указания точки внедрения зависимости. Контейнер находит все подходящие реализации интерфейса и создает объект привязанный к скоупу контроллера. Инъекции могут происходить в поле, в метод и в конструкторе  
    用于指示依赖项的注入点。 容器找到所有匹配的接口实现并创建一个绑定到控制器范围的对象。 注入可以发生在字段、方法和构造函数中
  - `@Named` - используется, для того, чтобы выдать имя бину, тогда его можно будет использовать на jsf странице. Как правило эта аннотация используется в совокупности с аннотацией скоупа  
    用来给 bean 起一个名字，然后就可以在 jsf 页面上使用了。通常，此注释与范围注释一起使用
  - `@Qualifier` - аннотация, которая используется для создания аннотаций-спецификаторов, которые четко указывают, какой бин надо инжектить. Над классом ставится аннотация для указания квалификатора бина. Над точкой внедрения ставится такая же аннотация.   
    是一个注释，用于创建明确指示要注入哪个 bean 的说明符注释。 注释放在类上方以指示 bean 限定符。 同样的注解放在注入点上方
  - `@Alternative` - может применяться к двум или нескольким компонентам, а затем, в зависимости от развертывания, в файле настройки CDI beans.xml указывается компонент для использования.  
    可以应用于两个或多个 bean，然后根据部署，CDI beans.xml 配置文件指定要使用的 bean。

- Написать React компонент формирующий таблицу пользователей, данные приходят в props   
  编写一个形成用户表的 React 组件，数据来自 props
  ```js
  function UsersTable(props) 
  {
    return 
    (
      {
        props.data  && <table className=”table”>
          <thead>
          <tr><td>Name</td><td>Surname</td>...</tr>
          </thead>
          <tbody>
          {
            data.map (
              (user, i) => (
                <tr key={i}>
                <td>{user.name}</td>
                <td>{user.surname}</td>
                ...
                </tr>
              )
            )
          }
            </tbody>
        </table>
      }
    )
  }
  ```
## Билет 4  
- Spring Web MVC: View Resolvers  
  Реализация MVC в SPRING: SPRING 中的 MVC 实现：
  - Диспетчер сервлет получает запрос, далее он смотрит в свои настройки, чтобы понять какому контроллеру передавать запрос.  
    servlet 调度程序接收请求，然后查看其设置以确定将请求发送到哪个控制器。
  - Далее в контроллере происходит обработка запроса. После обработки ответ приходит на диспетчера.  
    接下来，在控制器中处理请求。 处理后，响应到达调度程序。
  - На основании полученных данных, диспетчер ищет нужное ему представление (ViewResolver).  
    根据接收到的数据，调度器寻找他需要的视图（ViewResolver）
  - В представление передаются данные модели(или в модель, если это нужно), и представление посылается пользователю.  
    模型数据被传递给视图（或者如果需要的话传递给模型），然后视图被发送给用户。
  - View Resolver — интерфейс, реализуемый объектами, которые способны находить представление по его имени. Так же возможна поддержка локализации.  
    View Resolver 是由能够通过名称查找视图的对象实现的接口。 本地化支持也是可能的。

- Angular: ключевые особенности, отличия от AngularJS   
  Angular 2 как и AngularJS реализуют модель MVVM  
  Angular 2 和 AngularJS 一样，实现了 MVVM 模型

  Однако AngularJS в настоящее время является устаревшим, в нем были проблемы с производительностью, неупорядоченная документация и много лишних инструментов.  
  然而，AngularJS 目前已被弃用，存在性能问题、文档混乱以及大量冗余工具。

  В AngularJS жесткие рамки для компонентов, их сложно использовать повторно, в Angular’е есть иерархия компонентов, что дает возможность легко и просто реюзать их.  
  AngularJS 有一个严格的组件框架，它们很难重用，Angular 有一个组件层次结构，这使得重用它们变得容易和简单。

  AngularJS универсален, но гораздо менее безопасен и управляем.  
  AngularJS 是通用的，但安全性和可管理性要差得多。

  AngularJS задействует JavaScript, Angular же использует TypeScript (а значит меньше кода, выше безопасность и в общем  язык современнее).  
  AngularJS 使用 JavaScript，Angular 使用 TypeScript（这意味着更少的代码、更高的安全性和通常更现代的语言）

  Еще Angular адаптирован под слабые мобильные устройства(чего нет в AngularJS).  
  Angular 也适用于弱移动设备（AngularJS 中没有）。
- Написать веб-приложение на JSF (xhtml + CDI-бин) со списком студентов и бин, который будет реализовывать логику отчисления студентов. Напротив каждого имени студента должна быть кнопка "отчислить". Обновление должно производиться при помощи AJAX   
  编写一个 JSF Web 应用程序（xhtml + CDI bean），其中包含一个学生列表和一个将实现学生开除逻辑的 bean。 每个学生名字的对面应该有一个按钮“开除”。 更新应使用 AJAX 完成  
  java:
  ```java
  @Named(value = “student”)
  @SessionScoped
  public class Student implements Serializable {
    private DBHelper dbhelper;
    public void deleteUser(username) {
      dbhelper.removeByUsername(username);
    }
    
    public List<User> getList() {
      return dbhelper.getStudents();
    }
    
  }
  ```

  xhtml:
  ```xhtml
  <html
  xlmn:"http://..."
  xlmn:h "https://..."
  xlmn:f "https://..."
  xlmn:ui "https://..."
  >
  <f:view>
  <h:head>
    ...
    <title>Список на отчисление</title
    ...
  </h:head>
  <h:body>
    <ui:repeat id="table" className="table" value="student.list" var="student" />
    <div class=”row”>
          <h:outputText value=”#{student.user.name}” />
          <h:commandButton id=”#{student.user.name”} action=”#{student.delete(student.user.name)}”>
                <f:ajax execute=”#{student.user.name”}” render=”table” />
          </h:commandButton>
    </div>
  </ui:repeat>
  </h:body>
  </f:view>
  </html>
  ```

## Билет 5  

- Профили и платформы Java EE  
  - В JavaEE существует два профиля:
    - Web Profile — содержит в себе только те компоненты, которые нужны для работы веб приложения, это Servlet’ы, JSP, JSF, JPA, CDI, EJB.  
      Web 配置文件 - 仅包含 Web 应用程序工作所需的那些组件，这些组件是 Servlets、JSP、JSF、JPA、CDI、EJB。
    - Full Profile — полный сборник джавы ее, в нем по мимо Web есть еще JAX-RS, JAX-WS, JAXB, JNDI и еще очень много всего.  
      Full Profile - Java EE 的完整集合，除了 Web，它还有 JAX-RS、JAX-WS、JAXB、JNDI 等等。
  - Существует 3 самых известных API: JME, JSE, JEE
    - JME-(Java Micro Edition) представляет из себя API и минимально требовательную VM для разработки и старта приложения на смартфоне/планшете. Основана на более ранней версии JSE, поэтому некоторые функции (напр. дженерики) не работают  
      JME-（Java Micro Edition）是一个 API 和一个要求最低的 VM，用于在智能手机/平板电脑上开发和启动应用程序。 基于 JSE 的早期版本，因此某些功能（例如泛型）不起作用
    - JSE-(Java Standard Edition) занимается обеспечением основными стандартными функциями самой Java, и она определяет абсолютно все: базовые типы и объекты языка, классы более высокого уровня, производительность приложения в сети и обеспечение защищенности. Включает в себя пакеты: `java.util`、`java.math`、`java.io`、`java.nio`、`java.lang` и тд.  
      JSE-（Java 标准版）关注于提供 Java 本身的基本标准特性，它绝对定义了一切：语言的基本类型和对象、高级类、应用程序网络性能和安全性。 包括包：`java.util`、`java.math`、`java.io`、`java.nio`、`java.lang` 等。
    - JEE-(Java Enterprise Edition) для разработки Enterprise приложений. Она строится на основе платформы JSE, а еще дает возможность разработки более крупно масштабируемых , сложно уровневых и безопасных программ. Содержит: WebSocket, JSF, Unified EL, API для веб-служб RESTful, DI, EJB, JPA, и Java Transaction API.  
      JEE-（Java Enterprise Edition）用于开发企业应用程序。 它建立在 JSE 平台之上，还支持开发更大、更复杂、分层和更安全的程序。 包含：WebSocket、JSF、统一 EL、RESTful Web 服务 API、DI、EJB、JPA 和 Java 事务 API。
    Все платформы Java поддерживают полный функционал языка Java и отличаются лишь наличием или отсутствием определенных API.  
    所有 Java 平台都支持 Java 语言的全部功能，只是在存在或不存在某些 API 时有所不同。
- Типы DI в Spring  
  В Spring реализовано три типа внедрения зависимостей:  
  Spring实现了三种类型的依赖注入：

  - Constructor-based DI - контейнер вызовет конструктор с аргументами бинов, которые потом заинджектятся в класс  
    基于构造函数的 DI - 容器将使用 bean 参数调用构造函数，然后将其注入到类中
    @Autowired Car(Wheel w)...
  - Setter-based DI - сначала контейнер вызовет конструктор бина без аргументов, после вызовет помеченные аннотациями @Autowired сеттеры и впихнет туда нужные зависимости  
    基于 Setter 的 DI - 首先，容器将调用不带参数的 bean 构造函数，然后它将调用标有 @Autowired 注释的 setter 并将必要的依赖项推送到那里
  - Field-based DI - контейнер через рефлексию будет в поля класса пропихивать зависимости (не рекомендуется к использованию, рефлексия ест много ресурсов, очень легко нарушить Single Responsibility принцип, тяжело отлаживать)  
    Field-based DI - 容器会通过反射将依赖推送到类的字段中（不推荐使用，反射很吃资源，很容易违背单一职责原则，很难调试）
- Интерфейс на React, формирующий две страницы с разными URL: Главную (/home) и Новости (/news). Переход между страницами должен осуществляться посредством гиперссылок.  
  生成两个具有不同 URL 的页面的 React 界面：主页 (/home) 和新闻 (/news)。 页面之间的转换应通过超链接进行。  
  ```js
  const router = createBrowserRouter([
    {
      path: “/home”,
      element: (
        <h1>Home</h1>
        <a href=”/news”>News</a>
      )
    },
    {
      path: “/news”,
      element: (
        <h1>News<h1>
        <a href=”/home”>Home</a>
      )
    }
  ])
  ReactDOM.createRoot(document.getElementById(“root”)).render
  (
    <RouterProvider router={router}/>
  )
  ```

## Билет 6  

- Структура JSF приложения  
  JSF - высокоуровневый веб фреймворк (каркас для будущего приложения). Он абстрагирует программиста от работы с http протоколом напрямую.  

  JSF 是一种高级 Web 框架（用于未来应用程序的框架）。 它将程序员从直接使用 http 协议中抽象出来。

  Основан на использовании компонентов.  
  基于组件的使用。

  Фреймворк реализует шаблон MVC.  
  该框架实现了 MVC 模式。
   
  JSP или XHTML - страницы содержащие компоненты GUI.  
  JSP 或 XHTML - 包含 GUI 组件的页面。

  Элемент (компонент) страницы формирует из себя по сути тэг.  
  页面的元素（组件）本质上是一个标签

  JSP или XHTML представляют из себя обычный HTML , но со своими тэгами. Т.е. помимо дефолтных body, input, table и тд, есть еще тэги для кнопок слайдеров и тд.  
  JSP 或 XHTML 是纯 HTML，但有自己的标签。 那些。 除了默认的 body、input、table 等，还有 slider buttons 等标签。

  Для этого в стандартной структуре jsf есть:  
  为此，在标准的 jsf 结构中有：
  - Библиотека тэгов - они описывают эти дополнительные тэги jsf.  
    标签库——它们描述了这些额外的 jsf 标签。
  - Управляемые бины - бины управляемые рантаймом jsf (контейнером), чем является faces Servlet.
    托管 bean - 由 jsf 运行时（容器）管理的 bean，即 faces Servlet。
  - Дополнительные объекты (компоненты, конверторы и валидаторы)
    附加对象（组件、转换器和验证器）
  - Дополнительные тэги  
    附加标签
  - Конфигурация - faces-config.xml (опционально)  
    配置 - faces-config.xml（可选）
  - Дескриптор развертывания - как и для любого веб приложения  
    部署描述符——对于任何 Web 应用程序

- Spring MVC: особенности, интеграция в Spring  
  Фреймворк Spring MVC обеспечивает архитектуру паттерна MVC при помощи слабо связанных готовых компонентов.  
  Spring MVC 框架为 MVC 模式的体系结构提供了松散耦合的预构建组件。

  - Model (Модель) инкапсулирует (объединяет) данные приложения, в целом они будут состоять из POJO («Старых добрых Java-объектов», или бинов).  
    模型（Model）封装（组合）应用程序数据，一般来说，它们将由 POJO（“Good Old Java Objects”，或 beans）组成。
  - View (Отображение, Вид) отвечает за отображение данных Модели, — как правило, генерируя HTML, которые мы видим в своём браузере.  
    视图（Display，View）负责显示模型的数据——通常，生成我们在浏览器中看到的 HTML。
  - Controller (Контроллер) обрабатывает запрос пользователя, создаёт соответствующую Модель и передаёт её для отображения на View.  
    控制器（Controller）处理用户的请求，创建合适的Model并传递给View显示。

  Spring Web MVC – “базовый” фреймворк в составе Spring для разработки веб-приложений.  
  Spring Web MVC 是Spring 中用于开发Web 应用程序的“核心”框架。

  Основан на паттерне MVC (внезапно!)  
  基于MVC模式

  Back-end; универсальный, удобен для разработки REST API.  
  后端； 通用，方便REST API开发

  На клиентской стороне интегрируется с популярными JS-фреймворками.  
  在客户端，集成了流行的JS框架。

  Удобно интегрируется с Thymeleaf.  
  方便地与Thymeleaf 集成。

- Написать CDI Bean калькулятор, поддерживающий 4 базовые операции для целых чисел  
  编写支持 4 种基本整数运算的 CDI Bean 计算器  
  ```java
  @Named(value=”calc”)
  @ApplicationScoped
  public class Calc {
    public int add(int a, int b) { return a + b; }
    public int sub(int a, int b) { return a - b; }
    public int mul(int a, int b) { return a * b; }
    public int div(int a, int b) { return a / b; }
  }
  ```  

## Билет 7  

- Spring MVC: обработка запросов, DispatcherServlet   
  Вся логика работы Spring MVC построена вокруг DispatcherServlet, который принимает и обрабатывает все HTTP-запросы и ответы на них. При получении запроса, происходит следующая цепочка событий:  
  Spring MVC 的整个逻辑是围绕 DispatcherServlet 构建的，它接收并处理所有 HTTP 请求和对它们的响应。 收到请求后，会发生以下事件链：  

  1. DispatcherServlet обращается к интерфейсу HandlerMapping, который определяет какой контроллер должен быть вызван  
    DispatcherServlet 访问 HandlerMapping 接口，该接口决定调用哪个controller
  2. Контроллер принимает запрос и вызывает служебный метод, который возвращает в диспатчер имя View  
    控制器接收请求并调用一个实用方法，该方法将视图的名称返回给调度程序（dispatcher）
  3. При помощи ViewResolver диспатчер определяет, какой View надо использовать  
    使用 ViewResolver，dispatcher 决定使用哪个 View
  4. После того, как View создан, диспатчер отправляет данные модели в виде атрибутов, которые уже в конечном итоге отображаются в браузере  
    View创建后，dispatcher 将数据以属性的形式发送给model，最终已经显示在浏览器中
  
- Single Page Application(SPA): преимущества, недостатки
  Это веб-приложение, использующее единственный HTML-документ как оболочку для всех веб-страниц и динамически подгружает HTML, CSS, JS код, обычно посредством AJAX  
  这是一个 Web 应用程序，它使用单个 HTML 文档作为所有网页的包装器，并动态加载 HTML、CSS、JS 代码，通常通过 AJAX

  Преимущества: 
  1. легкость создания из-за огромного количества готовых библиотек и фреймворков.  
    由于大量现成的库和框架，易于创建。
  2. Простое кэширование данных, так как они загружаются в один запрос.  
    简单的数据缓存，因为它们是在一个请求中加载的
  3. Скорость работы, потому что основная часть ресурсов уже загружена, а на страничку подгружаются только необходимые данные, что и экономит время.  
    工作速度，因为主要部分资源已经加载完毕，页面只加载必要的数据，节省了时间

  Недостатки: 
  1. “Тяжелые” клиентские фреймворки  
    “重”客户端框架
  2. Без JS невозможно пользоваться полным функционалом приложения  
    没有JS，无法使用应用的全部功能
  3. Невозможность индексации страниц браузерами (SEO), т.к. содержимое генерируется/рендерится не сервером сразу а динамически на уже загруженной дефолтной странице  
    浏览器无法索引页面 (SEO)，因为 服务器不会立即生成/呈现内容，而是在已加载的默认页面上动态生成/呈现 
  
- Интерфейс JSF (xhtml страница + CDI), реализующий ввод паспортных данных (серия, номер, день, место)  
  java:  
  ```java
  @ManagedBean 
  @SessionScoped 
  @Setter 
  @Getter 
  public class PassportInputBean {
    private String series;
    private String number;
    private Date date;
    private String place;

    @ManagedProperty(value = "#{repoBean}") 
    private PassportRepo repo;
    public void storePassportData() {
      repo.store(series, number, date, place);
    }
  }
  ```
  xhtml:  
  ```html
  <h:form>
  Введите серию
  <h:inputText type="text" value="#{passportInputBean.series}"
  required="true"/>

  Введите номер
  <h:inputText type="text" value="#{passportInputBean.number}"> 

  Введите дату
  <h:inputText value="#{passportInputBean.date}">
  <f:convertDateTime pattern="yyyy-MM-dd"/>
  </h:inputText>

  Введите место рождения
  <h:inputText type="text" value="#{passportInputBean.place}">

  <h:commandButton value="Отправить" action="#{passportInputBean.storePassportData()}"> 

  </h:form>
  ```

## Билет 8  

- Технология RMI. Использование RMI в Java EE   
  Система Java Remote Method Invocation (RMI) позволяет объекту, запущенному на одной виртуальной машине Java, вызывать методы объекта, запущенного на другой виртуальной машине Java. Работает поверх TCP. В общем случае, объекты передаются по значению (копии), следовательно, передаваемые объекты должны быть Serializable.  
  Java 远程方法调用 (RMI) 系统允许运行在一个 Java 虚拟机中的对象调用运行在另一个 Java 虚拟机中的对象的方法。 通过 TCP 工作。 一般情况下，对象都是按值（拷贝）传递的，所以传递的对象必须是Serializable的。

  Для работы RMI нужно:

  - Server side
    1. Создать интерфейс 创建接口
    2. Реализовать его и создать объект 实现并创建一个对象
    3. Получить stub(объект-заглушка, который будет отдан клиенту, реализует коммуникацию через RMI протокол)  
      获取 stub（将给客户端的 stub 对象通过RMI协议实现通信）
    4. Создать registry(реестр, откуда клиент будет получать объекты)
      创建注册表（客户端将从中接收对象的注册表）
    5. Привязать созданную заглушку к реестру(привязка идет по имени)
      将创建的存根绑定到注册表（绑定按名称进行）
  - Client side
    1. Создать такой же интерфейс, что и на сервере(либо не создавать, если этот интерфейс доступен и клиенту, и серверу)  
      创建与服务端相同的接口（如果此接口对客户端和服务端都可用，则不创建）
    2. Подключиться к реестру сервера  
      连接到服务器注册表  
    3. Достать нужный stub  
      获得正确的存根
    4. Прикастить к интерфейсу  
      附加到接口
    5. Вызвать нужные методы
      调用需要的方法


- Управление состоянием в React. Flux & Redux   
  - Flux — архитектура для создания приложений на React, в которой описывается, как хранить, изменять и отображать глобальные данные (состояние).  
    Flux 是一种用于创建 React 应用程序的架构，它描述了如何存储、修改和显示全局数据（状态）。
    Основные концепции: 基本概念：  
    - Dispatcher принимает события от представления (например от кнопок интерфейса) и отправляет их на обработку хранилищу данных (Store).  
      Dispatcher 从视图（例如，从界面按钮）接收事件，并将它们发送到数据存储（Store）进行处理。
    - Store — синглтон, в котором хранятся данные. Только Store знает, как менять данные. Напрямую из React-компонента их изменить нельзя. После изменения данных Store посылает события представлению, и оно перерисовывается.  
      Store - 存储数据的单例。 只有 Store 知道如何更改数据。 您不能直接从 React 组件更改它们。 数据改变后，Store 发送事件给视图，视图被重绘。
  - Redux — небольшая библиотека, реализующая упрощенный паттерн Flux. В Redux нет Dispatcher, но есть store — синглтон, хранилище состояние всего приложения. Изменения состояния производятся при помощи чистых функций (reducers)  
    Redux 是一个实现简化的 Flux 模式的小型库。 Redux 中没有 Dispatcher，但是有一个 store - 一个单例，整个应用的状态的 store。 使用纯函数（reducer）进行状态更改
- Привести фрагмент кода управляемого бина, увеличивающего на 1 значение, отображаемое на кнопке при каждом клике по ней:   
  ```java
  @ManagedBean
  @ApplicationScoped
  public class MyBean implements Serializable {
      private int value = 0;
      public void increment() {
          value++;
      }
      public int getValue() {
          return value;
      }
      public void setValue(int value) {
          this.value = value;
      }
  }

  <h:commandButton actionListener = "#{MyBean.increment}" value = "{bean.value}"/>
  ```   

## Билет 9  

- JNDI. JNDI в Java EE. Способы взаимодействия с JNDI. Их преимущества и недостатки.  
  JNDI — API для доступа к объектам по их именам. Организовано в виде службы имен и каталогов.  
  JNDI 是一种通过名称访问对象的 API。 组织为命名和目录服务。

  Чаще всего JNDI используется в enterprise-разработке. Главный юзкейс — настройка доступа к базе данных. Приложение знает только JNDI-имя, например “java:comp/env/Db” а сами детали подключения описываются администратором в веб контейнере.  
  大多数情况下，JNDI 用于企业开发。 主要用例是设置对数据库的访问。 应用程序只知道 JNDI 名称，例如“java:comp/env/Db”，连接细节本身由管理员在 Web 容器中描述。

  JNDI поддерживает разные реализации сервиса служб имен и каталогов. Некоторые из них: DNS, RMI, LDAP, COBRA.  
  JNDI 支持命名和目录服务的不同实现。 其中一些是：DNS、RMI、LDAP、COBRA。

  Преимущества JNDI:  
  - удобство настройки приложения 易于应用程序设置
  - пароли к бд лежат отдельно от приложения, что безопаснее  
    数据库密码与应用程序分开，更安全
  - при изменении бд (например от тестовой к проду) не нужно пересобирать приложение  
    更改数据库时（例如，从测试到生产），您不需要重建应用程序

  Недостатки:
  - зависимость от контейнера 容器依赖
  - при использовании старой версии log4j есть уязвимость (log4shell) основанная на jndi  
    使用旧版本的 log4j 时存在基于 jndi 的漏洞 (log4shell)
- React. Особенности. Архитектура   
  React — JS библиотека для разработки пользовательского интерфейса. Позволяет создавать свои собственные компоненты, с пропсами (атрибутами) и стейтом (данными). Компоненты рендерятся в HTML.  
  React 是一个用于开发用户界面的 JS 库。 允许您使用道具（属性）和状态（数据）创建自己的组件。 组件以 HTML 呈现

  Особенности:
  - передача данных от родителя к детям 从父母到孩子的数据传输
  - виртуальный DOM 虚拟 DOM
  - JSX - это  JS с HTML внутри JSX 是 JS 里面有 HTML
  React отвечает за представление интерфейса и не навязывает какую-то определенную архитектуру. При написании сложных приложений, работающих с большим количеством данных, часто применяется архитектура Flux и библиотека Redux.  
  React 负责表示界面，不强加任何特定的架构。 在编写处理大量数据的复杂应用程序时，通常会使用 Flux 架构和 Redux 库。
- Сделать бин который показывает время в минутах со старта сервера  
  制作一个容器，以分钟为单位显示自服务器启动以来的时间  
  ```java
  @Named(“serverTimer”)
  @ApplicaitonScoped
  public class ServerTimer {
      private long start;
      public ServerTimer() {
          start = System.currentTimeMillis();
      }
      public long getTime() {
        return (System.currentTimeMillis() - start) / 60000;
      }
  }

  ```

## Билет 10   

- Платформы Java. Сходства и различия.  
  Существует 3 самых известных API: JME, JSE, JEE
    - JME-(Java Micro Edition) представляет из себя API и минимально требовательную VM для разработки и старта приложения на смартфоне/планшете. Основана на более ранней версии JSE, поэтому некоторые функции (напр. дженерики) не работают  
      JME-（Java Micro Edition）是一个 API 和一个要求最低的 VM，用于在智能手机/平板电脑上开发和启动应用程序。 基于 JSE 的早期版本，因此某些功能（例如泛型）不起作用
    - JSE-(Java Standard Edition) занимается обеспечением основными стандартными функциями самой Java, и она определяет абсолютно все: базовые типы и объекты языка, классы более высокого уровня, производительность приложения в сети и обеспечение защищенности. Включает в себя пакеты: `java.util`、`java.math`、`java.io`、`java.nio`、`java.lang` и тд.  
      JSE-（Java 标准版）关注于提供 Java 本身的基本标准特性，它绝对定义了一切：语言的基本类型和对象、高级类、应用程序网络性能和安全性。 包括包：`java.util`、`java.math`、`java.io`、`java.nio`、`java.lang` 等。
    - JEE-(Java Enterprise Edition) для разработки Enterprise приложений. Она строится на основе платформы JSE, а еще дает возможность разработки более крупно масштабируемых , сложно уровневых и безопасных программ. Содержит: WebSocket, JSF, Unified EL, API для веб-служб RESTful, DI, EJB, JPA, и Java Transaction API.  
      JEE-（Java Enterprise Edition）用于开发企业应用程序。 它建立在 JSE 平台之上，还支持开发更大、更复杂、分层和更安全的程序。 包含：WebSocket、JSF、统一 EL、RESTful Web 服务 API、DI、EJB、JPA 和 Java 事务 API。
    Все платформы Java поддерживают полный функционал языка Java и отличаются лишь наличием или отсутствием определенных API.  
    所有 Java 平台都支持 Java 语言的全部功能，只是在存在或不存在某些 API 时有所不同。
- Двухфазные и трехфазные конструкторы в Spring и Java EE  
  - Двухфазовые конструкторы в Spring: обычный конструктор + метод с аннотацией @PostConstruct. Сначала вызовется обычный конструктор, а затем помеченный метод. Аннотация является частью Java EE и работает в Spring.  
    Spring 中的两阶段构造函数：常规构造函数 + 带有 @PostConstruct 注解的方法。 常规构造函数将首先被调用，然后是标记的方法。 注解是 Java EE 的一部分，在 Spring 中工作
  - Трехфазовый конструктор(третья фаза изменения объекта до его использования) в Spring : сначала был нативный конструктор, потом обработались зависимости, уже с обработанными зависимостями вызвалось конструирование объекта, а потом добавились срезы(аспекты).  
    Spring中的一个三阶段构造函数（第三阶段在使用之前改变一个对象）：首先有一个原生的构造函数，然后处理依赖，调用处理依赖的对象构造，然后添加切片（切面）

    Аспекты(срезы)- это “вкрапления”, которые позволяют вам изменить поведение таким же образом, как меняются данные при настройке бина. Такой конструктор имеет свой скоуп. Его следует использовать для создания бинов “по настроению”.  
    方面（切片）是“插入”，允许您以与配置 bean 时数据更改相同的方式更改行为。 这样的构造函数有它自己的作用域。 它应该用于创建自定义 bean。

- Написать страницу JSF, которая бы выводила сначала 10 простых чисел, а затем с помощью Ajax запроса ещё 10.  
  编写一个 JSF 页面，首先输出 10 个质数，然后使用 Ajax 请求再输出 10 个。
  ```java
  @Named
  @SessionScoped
  public class PrimeCalculator implements Serializable {
      private final List<Integer> primes = new ArrayList<>();

      public PrimeCalculator() { generatePrimes(10); }

      public void generatePrimes(int count) {
          if (primes.isEmpty()) { primes.add(2); count--; }
          for (int i = 0; i < count; i++) {
              int cur = primes.get(primes.size() - 1) + 1;
              search: while (true) {
                  for (int factor = 2; factor < cur; factor++) {
                      if (cur % factor == 0) { cur++; continue search; }
                  }
                  primes.add(cur);
                  break;
              }
          }
      }

      public List<Integer> getPrimes() {
          return primes;
      }
  }

  <h:form>
      <ui:repeat value="#{primeCalculator.primes}" var="prime" varStatus="status">
          #{prime}#{status.last ? "" : ", "}
      </ui:repeat>
      <h:commandButton action="#{primeCalculator.generatePrimes(10)}" value="Еще 10"/>
  </h:form>
  ```

## Билет 11   

- Java EE CDI Beans стереотипы(Sterotype)  
  Stereotype — аннотация, включающая в себя много аннотаций. Мы можем создать свой стереотип и использовать его:  
  Stereotype 是一个包含很多注解的注解。  我们可以创建自己的原型并使用它：

  ```java
  @ApplicaitonScoped
  @Named
  @Secure
  public @interface myStereotype() {}
  ```

  Также существуют стандартные стереотипы, например @Model (`@RequestScoped + @Named`)  
  还有标准的构造型，如 @Model (`@RequestScoped + @Named`)

  При применении аннотации `@MyStereotype` будут включатся все перечисленные аннотации. Один бин может использовать несколько стереотипов.  
  应用 `@MyStereotype` 注释时，将包含所有列出的注释。  一个 bean 可以使用多个构造型。

  Если у вас будут разные scope в стереотипах, то у вас не скомпилится, либо вам надо будет указать скоуп прямо перед бином. По поводу имен бинов ещё круче: в стереотипах нельзя задавать имена бинов  
  如果您在构造型中有不同的范围，那么它不会为您编译，或者您需要在 bean 之前指定范围。  至于 bean 的名字，就更酷了：你不能在构造型中设置 bean 的名字

- Разметка страницы в React- приложениях. JSX  
  В React приложениях разметка пишется в JSX файлах. JSX — надстройка над JS, которая позволяет вкраплять HTML-синтаксис в код. Можно использовать стандартные HTML элементы (такие как div, span, h1, input) так и кастомные React компоненты.  
  在 React 应用程序中，标记是用 JSX 文件编写的。 JSX 是 JS 的附加组件，允许您将 HTML 语法散布到代码中。 您可以使用标准 HTML 元素（例如 div、span、h1、input）以及自定义 React 组件。  

  JSX код: 
  `<div className=”foo”>text</div>` компилируется в вызов функции `React.createElement(“div”, { className: “foo”}, “text”)`  
  `<div className="foo">text</div>` 编译为函数调用 `React.createElement("div", { className: "foo"}, "text")`
- JSF Manager Bean, после инициализации HTTP-сессии формирующий коллекцию с содержимым таблицы Н_УЧЕБНЫЕ_ПЛАНЫ. Для доступа к БД необходимо использовать JDBC-ресурс jdbc/OrbisPool.  
  JSF 管理器 Bean，在初始化 HTTP 会话后，形成一个包含 N_CURRICULUM 表内容的集合。 要访问数据库，您必须使用 jdbc/OrbisPool JDBC 资源。
  
  ```java
  @Named("myBean")
  @SessionScoped
  class MyBean {
      private List<String> plans;

      private List<String> getPlans() {
      return plans;
      }

      @Resource(name="jdbc/OrbisPool",type=DataSource.class)
      private DataSource dataSource;

      @PostConstruct
      private void loadPlans() {
      try (var conn = dataSource.getConnection()) {
        var stmt = conn.createStatement();
        var rs = stmt.executeQuery("SELECT name FROM plans");
        plans = new ArrayList<>();
        while (rs.next()) {
          plans.add(rs.getString("name"));
        }
      }
      }
  }
  ```

## Билет 12

- Location Transparency в Java EE  
  Этот принцип в Java EE заключается в том, что за интерфейсом могут скрываться различные его реализации. Если мы вызываем локальный компонент, то мы обращаемся с его ссылкой, так как все происходит на локальной JVM, а вот если мы обращаемся к удаленному компоненту, то мы обратимся к нему с помощью RMI(удаленный вызов методов). Будут созданы два утилитарных объекта: stub(сторона вызова) и skeleton(сторона удаленного компонента), которые будут транслировать локальные вызовы в вызовы по сети и обратно. Таким образом, не важно где находится вызываемый компонент. В Java EE в первую очередь реализуется через JNDI — API для предоставления доступа к объектам по имени, нежели по их физической локации.  
  Java EE 中的这一原则是不同的实现可以隐藏在一个接口后面。  如果我们调用一个本地组件，那么我们访问它的引用，因为一切都发生在本地 JVM 上，但是如果我们访问一个远程组件，那么我们将使用 RMI（远程方法调用）访问它。  将创建两个实用程序对象：stub（调用端）和 skeleton（远程组件端），它们会将本地调用转换为网络调用，反之亦然。  因此，调用的组件位于何处并不重要。  在 Java EE 中，它主要通过 JNDI 实现，JNDI 是一种 API，用于通过名称而不是物理位置提供对对象的访问。
- Spring MVC часть представления  
  Представление отвечает за то, как будут визуализироваться данные в браузере пользователя.  
  视图负责数据在用户浏览器中的呈现方式。

  За поиск представления по имени отвечает интерфейс ViewResolver.  
  ViewResolver 接口负责按名称查找视图。

  Spring MVC поддерживает множество различных представлений. Можно генерировать html, pdf, csv, json, использовать различные шаблонизаторы: JSP, Thymeleaf, Freemaker.  
  Spring MVC 支持许多不同的视图。  您可以生成 html、pdf、csv、json，使用各种模板引擎：JSP、Thymeleaf、Freemaker。

  ViewResolver - интерфейс, при помощи которого DispatcherServlet определяет какое представление нужно использовать на основании имени.  
  ViewResolver - DispatcherServlet 用于根据其名称确定要使用哪个视图的接口。

- Написать managed bean и задать ему scope такой же как у бина otherBean  
  编写一个托管 bean 并赋予它与 otherBean 相同的作用域  

  ```java
  @ManagedBean
  @NoneScoped
  public class TestBean implements Serializable{
    int a;
    public int getA(){
      return a++;
    }

    public void setA(int a){
      this.a=a;
    }
  }

  @MangedBean
  @RequestScoped
  public class OtherMyBean implements Serializable{
    int a;
    @ManagedProperty(value=”#{testBean}”)
    TestBean testBean = new TestBean();
    
    public void setTestBean(TestBean testBean){
      this.testBean=testBean;
    }

    public TestBean getTestBean(){
      return testBean;
    }

    public int getA(){
      System.out.println(testBean.getA());
      return a+1;
    }

    public void setA(int a){
      this.a=a;
    }
  }
  ```

## Билет 13

- Валидаторы в JSF. Создание, назначение и тд.  
  Валидаторы в JSF — реализации интерфейса `Validator`. Метод validate принимает `FacesContext, UiComponent` и значение (Object), которое необходимо валидировать.  
  JSF 中的验证器是 `Validator` 接口的实现。 validate 方法采用 `FacesContext、UiComponent` 和要验证的值 (Object)。

  Валидатор можно повесить на компоненты при помощи тега `<f:validator validatorId=”com.example.MyValidator”/>`  
  可以使用 `<f:validator validatorId=”com.example.MyValidator”/>` 标签将验证器附加到组件

  Чтобы JSF зарегистрировал кастомный валидатор, используется аннотация `@FacesValidator`. Существует 3 самых известных API: JME, JSE, JEE  
  为了让 JSF 注册自定义验证器，使用了 `@FacesValidator` 注释。有 3 个最著名的 API：JME、JSE、JEE ([参见 Билет 10](#билет-10-1))

  Также есть встроенные валидаторы: `BeanValidator` (вызывает метод на бине для валидации), `DoubleRangeValidator, LengthValidator, RegexValidator, RequiredValidator`.  
  还有内置验证器：`BeanValidator`（调用 bean 上的方法进行验证）、`DoubleRangeValidator、LengthValidator、RegexValidator、RequiredValidator`。

- Реализация контроллера в Spring Web MVC  
  Контроллер – специальный класс, помеченный аннотацией @Controller (или RestController). Задача контроллера - перехватывать входящие запросы, паковать данные в нужный формат, отправлять эти данные нужной модели, а затем ответ от модели передать обратно в DispatcherServlet. На методы контроллера вешаются разные аннотации, такие как `@GetMapping, @PostMapping` (это для путей запроса) и аннотации для получения данных из запроса, такие как `@PathVariable или @ResourcesVarible`.  
  控制器是一个用@Controller（或RestController）注解注解的特殊类。 控制器的任务是拦截传入的请求，以所需格式打包数据，将此数据发送到所需模型，然后将模型的响应传递回 DispatcherServlet。 控制器方法上挂了各种注解，例如@GetMapping、@PostMapping（这是针对请求路径的）和用于从请求中接收数据的注解，例如@PathVariable 或@ResourcesVarible。
- Vue.js простейший чат бот, который на любое сообщение отвечает «сам дурак»  
  Vue.js 实现最简单的聊天机器人，可以响应“сам дурак”的任何消息

  ```json
  <template>
    <input v-model="message_value" placeholder="message"/> 
    <button @click="send">send</button> 
    <li v-for="item in message_history" :key="item"> 
      {{item}}
    </li> 
  </template> 

  <script>
    export default { 
      data() { 
        return { 
          message_value: '', 
          message_history: [] 
        } 
      }, 
      methods: {
        send() {
          this.message_history.push(this.message_value); 
          this.message_history.push("сам дурак"); this.message_value = "";
        }
      }
    } 
  </script>
  ```

## Билет 14

- Фаза формирования представления  
  Фаза формирования представления (RestoreView), на этой фазе фреймворк(JSF) делает следующее:
  - Если это первое обращение клиента, то создаются объекты, назначаются слушатели, валидаторы, конверторы, все это помещается в FacesContext и отправляется на создание ответа юзеру.
  - Если FacesContext уже есть (это не первый запрос и все объекты уже созданы), то проверяется тип запроса, а после запускаются процессы рендера новых страниц(если это GET) и создание/изменение данных(если это POST).
  Доп инфа:
  1. Формирование представления (Restore view)
    Создаются объекты дерева компонентов, начиная с UIViewRoot, назначаются слушатели, конверторы и валидаторы. Все элементы помещаются в FacesContext. Если клиент уже заходил на эту страницу, то состояния представления синхронизируются с клиентом.
  2. JSF начинает фазу восстановления представления, как только щелкает ссылка или кнопка и JSF получает запрос. На этом этапе JSF создает представление, связывает обработчики событий и средства проверки с компонентами пользовательского интерфейса и сохраняет представление в экземпляре FacesContext. Экземпляр FacesContext теперь будет содержать всю информацию, необходимую для обработки запроса.

- Spring framework. Отличия от Java EE  
  Java EE — это, грубо говоря, конструктор, она модульная, можно делать свои сборки, подключать и отключать совсем маленькие модули. В ней есть множество реализаций представлений, бинов и т.д. что делает ее идеальной для разработки монолитного масштабируемого приложения.

  Spring — также разделен на модули, но эти модули довольно крупные и скорее удобно дополняют друг-друга чем живут обособленно. Спринг ставит более жесткие рамки, диктуя как писать приложении, и в каких-то случаях это очень важно. Этот фреймворк подходит для небольших веб приложений, либо для микросервисной архитектуры. Тот же ajax, который в JavaEE пишется 1 строчкой(благодаря JSF), в спринге нужно писать руками.  

  Доп инфа:
  Java EE +|Java EE -|Spring +|Spring -
  ---|---|---|---|
  Считается более надежным и масштабируемым решением|Сложная среда разработки|Проще чем Java EE|Отсуствует четкая направленность и понимание разработчиков зачем Spring нужен фундаментально
  Java EE - утвержденный стандарт|-|Обеспечивает слабую связность приложений - потому что изначально задумывался лишь для реальзации IoC|Медленее чем Java EE (нигде не пиншут почему)
  -|-|Не требует использования корпоративоного контейнера (севера прилодений такого как tomcat, glassfish...)|-
  -|-|опенсурс/-
  -|-|нам практик говарил, что Spring выигрывает из-за Spring boot и Spring data|а вот по сравнению Java EE тут security сложнее

- RestController, который реализует перевод градусов Цельсия в Фаренгейты и обратно  
  RestController 实现从摄氏度到华氏度的转换，反之亦然
  ```Java
  @RestController
  class TempController {
    @GetMapping("/convert/c/f")
    double celsiusToFahrenheit(@RequestParam double celsius) {
        return celsius * 1.8 + 32.0;
    }

    @GetMapping("/convert/f/c")
    double fahrenheitToCelsius(@RequestParam double fahrenheit) {
        return (fahrenheit - 32.0) / 1.8;
    }
  }
  ```

## Билет 15

- Java EE CDI Beans прерывание жизненного цикла (Interception)  
- Компоненты React. State & props. "Умные" и "Глупые" компоненты  
- Написать JSF страницу и многострочным полем, в которое можно вводить только стройные символы латинице.  

## Билет 16

## Билет 17

- Angular компонент, который позволяет поделиться чем-то в VK, Twitter, Facebook (API для соцсетей можно описать текстом)  

## Билет 18  
- Построение интерфейсов на JSF. Иерархия компонентов JSF.  
- Java EE CDI Beans: принципы инъекции бинов.  
- Приложение на Angular, реализующее форму для заполнения бланка на отчисление по собственному желанию. Форма должна принимать на вход имя пользователя и дату, и формировать заполненный бланк заявления (на клиентской стороне)  

## Билет 19  

- Managed Beans что это, применение, вызов из jsp/xhtml  
- Архитектура и состав Spring MVC  
- Написать на Angular интерфейс, который проверяет если ли в куки sessionid и если нет, отправляет пользователя на аутентификацию по логину и паролю  

## Билет 20  

- Контекст управляемых бинов. Конфигурация контекста бина  
- Шаблоны MVVM и MVP. Сходства и отличия от MVC  
- Компонент для React, формирующий строку с автодополнением. Массив значений для автодополнения должен получаться с сервера посредством запроса к REST API  

## Билет 21  

- REST в спринге: методы и аргументы  
- Навигация в React. React Router  
- Реализовать бронь авиабилетов на jsf  

## Билет 22  

- Класс FacesServlet - назначение, особенности конфигурации  
- Vue.js - ключевые особенности, преимущества и недостатки  
- REST - контроллер на Spring Web MVC, предоставляющий CRUD-интерфейс к таблице со списком покемонов  

## Билет 23  

- Конвертеры JSF, создание и назначение  
- Реализация model в Spring web MVC  
- Написать на vue.js интерфейс для навигации по текстовому документу, представленному в виде большой строки, должны быть реализованы переходы на следующую и предыдущую страницу  

## Билет 24  

- CDI Beans  
- Angular DI  
- JSF страничка с данными из бина  

## Билет 25  

- Шаблоны и представление в Angular  
- Dependency Lookup Spring  
- Конфигурация, чтобы JSF обрабатывал все запросы приходящие с .xhtml и со всех URL, начинающихся с /faces/  

## Билет 26  

- Process validations phase, Update module values phase  
- Жизненный цикл Spring-приложения  
  1. Создается контейнер
  2. Контейнер считывает конфиг
  3. Загружается описание бинов из конфига и classpath (с аннотацией)
  4. Создаются экземпляры бинов
  5. Производится внедрение зависимостей
  6. Вызывается PostConstructor
  7. Вызываются callback’и BeanPostProcessor
  8. Приложение запущено
  9. Приложение закрывается
  10.  Вызываются PreDestroy, callback’и
  11.  Приложение остановлено

  Подробно:
  - Жизненный цикл сприга до создания объекта:
    - Конфигурация, написанная на xml или в виде Java кода …, попадает в BeanDefinitionReader, объект, который парсит конфигурация в том или ином виде. После считывания он выдает BeanDefinitionы. Сам BeanDefinition хранит всю информацию о том, каким образом спрингу создавать бины, как бин определен, какие зависимости в себе содержит, какие аннотацию и другие настройки.
    - Если Bean настроен как Singleton (этот тип бинов у спринга по умолчанию), то он в конвейере будет обработан сразу, т.е его прогонят по жизненному циклу бина, будет создан объект и он попадет в IoC контейнер. (not Lazy Bean)
    - Если Lazy Bean - не будет создан сразу, только при необходимости (по запросу). - т.е если его не найдут в IoC, но он есть в BeanDefinition, то он будет создан и помещен туда.
    - Prototype (не Singleton) - создается когда будет необходимо. Они не попадают в IoC контейнер (так сказал Письмак). Спринг управляет им до момента как мы его заполучили. Как только он создан и отдан, он перестает управлять его жизненным циклом. ~ Т.е выполнение инструкций при при удалении будет недоступно.
    - 
- интерфейс на Angular, который выводит интерактивные часы с обновление каждую секунду  

## Билет 27  

- Реализация Ajax в jsp  
- CDI beans: контекст (Bean Scope)  
- Интерфейс реализации логин+пароль на React. На стороне сервера- Rest API

