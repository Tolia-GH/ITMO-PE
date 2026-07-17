## 1. Программирование на Python <br> Python 编程

### 1. Списковые включения и генераторы <br> 列表推导式与生成器 (List Comprehension and Generator)

Python 推导式是一种根据已有可迭代对象（iterable）快速创建新数据结构的方法，从一个数据序列构建另一个新的数据序列，用一行代码完成循环 + 条件判断 + 数据转换。适用于生成列表（list）、字典（dict）、集合（set）和生成器（Generator）。

---

列表推导式基本结构如下：

```python

[expression   for   item  in  iterable]
 ↑             ↑      ↑           ↑
结果如何生成  循环   当前元素    数据来源    
```

例如生成 1~10 的平方数：

```python
result=[
    x*x
    for x in range(1,11) # range 右边界不会被遍历到，故应设为 N+1
]
```

---


在以上基本结构的基础上，可以加入 `if` 条件过滤，形式如下：

```python
[expression for item in iterable if condition]
```

例如使用列表推导式得到10以内的偶数可以这样表示：

```python
even=[
    x
    for x in range(10)
    if x%2==0
]
```

得到输出结果`[0,2,4,6,8]`

---

除此之外，还可以使用 `if-else` 语句，形式如下：

```python
[value_if_true if condition else value_if_false for item in iterable]
```

例如，将数字分为奇数和偶数可以这样表示：

```python
result=[
    "even" if x%2==0 else "odd"
    for x in range(5)
]
```

得到结果：

```python
[
    'even',
    'odd',
    'even',
    'odd',
    'even'
]
```

---

列表推导式还可以进行嵌套，例如：

```python
matrix=[
    [1,2],
    [3,4]
]

result=[
    x*x
    for row in matrix
    for x in row
]
```

得到`result=[1,4,9,16]`

---

集合推导式与列表推导式相比，使用大括号`{}`进行包围，其语法如下：

```python
{expression for item in iterable}
```

由于集合的特性，不存在元素重复，因此我们可以使用集合推导式对列表元素自动去重，例如：

```python
numbers=[
    1,2,2,3,3
]

unique={
    x
    for x in numbers
}
```

得到结果：

```python
{1,2,3}
```

---

字典推导式可用于快速创建字典，其语法如下：

```python
{
    key:value
    for item in iterable
}
```

例如创建数字平方表：

```python
squares={
    x:x*x
    for x in range(5)
}
```

或字典交换：

```python
student={
    "Tom":20,
    "Bob":21
}

exchange={
    age:name
    for name,age in student.items()
}
```

---

生成器表达式用于生成一个生成器，其语法如下：

```python
generator=(
    x*x
    for x in range(1000000)
)
```

> 需要注意的是，生成器表达式虽然使用元组tuple所使用的小括号`()`表示，但得到是生成器，记录的是元素生成规则，而并非元组，Python 不存在元组推导式

当我们使用列表推导式时，在运行阶段，程序会直接立即计算全部列表数值并占用内存，当列表元素过多时，可能会造成内存溢出，而生成器表达式则仅仅记录元素的生成规则，并且只在调用 `next()` 方法时，才完成一次计算，返回单一元素结果，对内存占用低。

---

迭代器（Iterator）是一个可以保存当前遍历状态，并且能够返回下一个元素的对象。

迭代器对象从集合的第一个元素开始访问，直到所有的元素被访问完结束。迭代器只能往前不会后退。

迭代器有两个基本的方法：`__iter__()` 和 `__next__()`，`__iter__()` 返回迭代器自身， `__next__()` 返回下一个元素，当没有下一个元素时，抛出 `StopIteration` 异常。

而可以被迭代器迭代的对象则称之为可迭代对象 Iterable，可迭代对象本身没有 `__next__()` 方法，但可以通过 `__iter__()` 方法获得该对象的迭代器用于迭代自身

在 Python 中，list 列表，tuple 元组，string 字符串，dict 字典，set 集合，range 范围均属于可迭代对象，可以被迭代器遍历。

例如：

```python
numbers=[10,20,30]

iterator=iter(numbers)

print(next(iterator))
```

其中，列表 `numbers` 为可迭代对象，`iterator` 为 `numbers` 的迭代器

---

生成器（Generator）是一种特殊的迭代器，用于生成序列。与迭代器不同，迭代器需要实现迭代协议（Iterator Protocol），即提供 `__iter__()` 和 `__next__()` 方法；而生成器通常通过包含 `yield` 关键字的函数或生成器表达式创建，Python 会自动实现迭代协议。

`yield` 关键字类似于普通函数中的 `return` 用于返回函数值，不同的是 `yield` 会在返回当前值时，会保存函数当前的执行状态，当函数下一次调用，会从当前状态继续执行。

例如以下函数定义了一个生成器：

```python
def countdown(n):
    while n > 0:
        yield n
        n -= 1 # 等价于 n = n - 1
 
# 创建生成器对象
generator = countdown(5)
 
# 通过迭代生成器获取值
print(next(generator))  # 输出: 5
print(next(generator))  # 输出: 4
print(next(generator))  # 输出: 3
 
# 使用 for 循环迭代生成器
for value in generator:
    print(value)  # 输出: 2 1
```

> 需要注意的是，直接调用生成器函数本身并不会执行函数内部的代码，而是生成一个该生成器的对象，如果要执行函数代码，需要调用 `next()` 方法

### 2. Декораторы и контекст-менеджеры <br> 装饰器与上下文管理器

在 Python 中，函数也是一种对象，可以被赋值，可以作为参数传递，也可以作为返回值返回

例如以下 `say_name()` 函数被赋值给 `func`，调用 `func` 输出 `"Anton"`：

```python
def say_name(name):
    print(name)

func = say_name

func("Anton")
```

而以下用例则将函数 `say_name()` 作为参数传递给函数 `greet()` 并调用执行，最终输出 `Hello! Anton`：

```python
def say_name(name):
    print(name)

def greet(func):
    print("Hello!", end=' ')
    func("Anton")

greet(say_name)
```

---

结合以上特性，我们便得到了 Python 中的装饰器（Decorator）。**装饰器的本质是一个接收函数作为参数，并返回一个新函数的函数**。通过装饰器，我们可以在不修改原函数的情况下，动态扩展原函数的功能。

将上述的用例改用装饰器表达如下，最终同样输出 `Hello! Anton`：

```python
def greet(func):
    def wrapper(*args, **kw):
        print("Hello!", end=' ')
        func(*args, **kw)
    return wrapper

@greet
def say_name(name):
    print(name)

say_name("Anton")
```

在上面的程序中，`greet` 是一个装饰器，在 Python 中使用 `@` 符号修饰于原函数的上方，而在 `say_name` 函数定义处上方添加 `@greet`，相当于执行了语句：

```python
say_name = greet(say_name)
```

而对于 `say_name()` 的参数，则通过 `wrapper()` 函数的 `(*args, **kw)`，进行传递，通过该方式可以接受任意参数的调用，如果 `wrapper()` 不需要任何参数，也可以省去 `(*args, **kw)` 的写法。

---

而如果需要让装饰器本身也引入参数，则可以在装饰器外围再套一层高阶函数，例如：

```python
def repeat(times):
    def greet(func):
        def wrapper(*args, **kw):
            for _ in range(times):
                print("Hello!", end=' ')
                func(*args, **kw)
        return wrapper
    return greet

@repeat(3)
def say_name(name):
    print(name)

say_name("Anton")
```

最终输出：

```python
Hello! Anton
Hello! Anton
Hello! Anton
```

---

除此之外，装饰器外也可以嵌套装饰器，例如：

```python
def decorator1(func):
    def wrapper():
        print("Decorator 1 before")
        func()
        print("Decorator 1 after")
    return wrapper

def decorator2(func):
    def wrapper():
        print("Decorator 2 before")
        func()
        print("Decorator 2 after")
    return wrapper

@decorator1
@decorator2
def hello():
    print("Hello")
```

该写法在执行时等价于

```python
hello = decorator1(decorator2(hello))
```

此时再调用 `hello()`，其执行过程如下：

```python
decorator1.wrapper()
    ↓
print("Decorator 1 before")
    ↓
decorator2.wrapper()
    ↓
print("Decorator 2 before")
    ↓
hello()
    ↓
print("Hello")
    ↓
print("Decorator 2 after")
    ↓
print("Decorator 1 after")
```

---

由于在 Python 中，类也和函数一样是一个对象，因此装饰器除了可以作用于函数，也可以作用于类。通过类装饰器，我们可以扩展类的方法和属性，控制实例化过程

例如我们有一个 `Student` 类，我们可以使用函数形式的类装饰器 `extend_class()` 对扩展一个 `age` 属性，并对 `introduce()` 方法进行扩展：

```python
def extend_class(cls):
    # 获取原有的初始化方法
    old_init = cls.__init__ 
    # 扩展原有的初始化方法
    def new_init(self, name="", age=0): 
        old_init(self, name)
        self.age = age
    # 替换原有的初始化方法
    cls.__init__ = new_init 

    # 获取原有的 introduce() 方法
    old_introduce = cls.introduce 
    # 扩展原有的 introduce() 方法
    def new_introduce(self): 
        print("Hello! My name is", end=" ")
        old_introduce(self)
        print("I am " + str(self.age) + " years old")

    # 替换原有的 introduce() 方法
    cls.introduce = new_introduce 

    return cls

@extend_class
class Student:
    def __init__(self, name=""):
        self.name=name

    def introduce(self):
        print(self.name)

anton = Student("Anton", 12)
```

现在调用 `anton.introduce()`，则会输出：

```
Hello! My name is Anton
I am 12 years old
```

---

上述以函数形式实现的类装饰器直接对原类进行了修改，破坏了原有 `Student` 类的实现，如果需要避免这一点，我们可以引入包装类作为代理进行扩展：

```python
def extend_class(cls):
    class Wrapper:
        def __init__(self, *args, age=0, **kwargs):
            # 创建原始对象
            self.wrapped = cls(*args, **kwargs)
            # 添加新属性
            self.age = age

        def __getattr__(self, name):
            # 转发未知属性给原始对象
            return getattr(self.wrapped, name)

        def introduce(self):
            print("Hello! My name is", end=" ")
            self.wrapped.introduce()
            print("I am " + str(self.age) + " years old")

    return Wrapper

@extend_class
class Student:
    def __init__(self, name=""):
        self.name=name

    def introduce(self):
        print(self.name)

anton = Student("Anton", 12)
```

---

除了函数形式的类装饰器，还有类形式的类装饰器，同样对于 `Student` 类，我们可以使用以下类装饰器进行扩展：

```python
class ExtendClass:
    def __init__(self, cls):
        self.cls = cls
        old_init = cls.__init__

        def new_init(instance,name="",age=0):
            old_init(instance,name)
            instance.age=age

        cls.__init__ = new_init

        old_introduce = cls.introduce

        def new_introduce(instance):
            print("Hello! My name is", end=" ")

            old_introduce(instance)

            print("I am " + str(instance.age) + " years old")

        cls.introduce = new_introduce

    def __call__(self,*args,**kwargs):

        return self.cls(*args,**kwargs)

@ExtendClass
class Student:
    def __init__(self, name=""):
        self.name=name

    def introduce(self):
        print(self.name)

anton = Student("Anton", 12)

anton.introduce()
```

---

同样，使用包装类的版本如下：

```python
class ExtendClass:
    def __init__(self, cls):
        # 保存原始类
        self.cls = cls

    def __call__(self, *args, age=0, **kwargs):
        # 创建包装对象
        return Wrapper(self.cls,*args,age=age,**kwargs)

class Wrapper:
    def __init__(self, cls, *args, age=0, **kwargs):
        # 创建原始对象
        self.wrapped = cls(*args, **kwargs)
        # 添加新的属性
        self.age = age

    def __getattr__(self, name):
        # 将未找到的属性转发给原始对象
        return getattr(self.wrapped, name)

    def introduce(self):
        print("Hello! My name is", end=" ")
        self.wrapped.introduce()
        print("I am " + str(self.age) + " years old")

@ExtendClass
class Student:
    def __init__(self, name=""):
        self.name = name

    def introduce(self):
        print(self.name)

anton = Student("Anton", age=12)

anton.introduce()
```

---

除此之外，Python 还内置了一些常用的装饰器：

- `@staticmethod`：用于定义类的静态方法、
- `@classmethod`：用于定义类方法
- `@property`：用于将方法变为属性

例如：

```python
class MyClass:
    @staticmethod
    def static_method():
        print("静态方法")

    @classmethod
    def class_method(cls):
        print(cls.__name__)

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, value):
        self._name = value
```

---

在 Python 中，上下文管理（Context Management）是一种用于管理资源生命周期的机制，可用于管理文件、数据库连接、网络连接、线程等资源。

例如，在传统方式中，手动管理文件资源如下：

```python
def get_content(filename):
    file = open(filename, "r")
    content = file.read()
    file.close()

    return content
```

上述代码存在一个潜在问题：如果函数在执行 `file.read()` 的过程中发生异常，例如文件读取失败或程序抛出异常，那么程序会立即跳出当前执行流程，而后续的 `file.close()` 将不会被执行，造成资源泄漏

为了保证资源能够在任何情况下被正确释放，可以使用 `try...finally` 结构：

```python
def get_content(filename):
    file = open(filename, "r")
    try:
        content = file.read()
        return content
    finally:
        file.close()
```

无论 `try` 代码块是否正常执行，`finally` 中的代码都会被执行，因此可以保证文件资源被释放。

然而在实际开发中，如果对于每一种资源都手动编写 `try...finally`，会产生大量重复样板代码，不易于开发维护

因此 Python 提供了上下文管理协议（Context Management Protocol），该协议要求对象实现两个方法：

- `__enter__()`：进入上下文时调用，返回值赋给 `as` 后的变量
- `__exit__()`：退出上下文时调用，处理清理工作

上下文管理协议的 `__exit__()` 方法接收三个参数：

- `exc_type`：异常类型
- `exc_val`：异常值
- `exc_tb`：异常追踪信息

如果 `__exit__()` 返回 `True`，则表示异常已被处理，不会继续传播；返回 `False` 或 `None`，异常则会继续向外传播。

在实际开发中，可以通过 `with` 关键字自动管理资源生命周期，上述代码于是可以简化为：

```python
def get_content(filename):
    with open(filename, "r") as file:
        content = file.read()
    return content
```

在这里 `with` 后面的表达式返回的对象必须是一个上下文管理器（Context Manager），而 `open()` 返回的文件对象（file object）正是一个实现了上下文管理协议（Context Management Protocol）的对象，因此可以直接用于 `with` 语句。

当程序进入 `with` 代码块时，Python 会自动调用上下文管理器 `open()` 的 `__enter__()` 方法，执行代码块，并在离开时自动调用 `__exit__()` 方法释放资源，即使发生异常，资源也会被自动关闭

---

除了使用 `with` 关键字，我们也可以通过自定义类实现上下文管理协议的 `__enter__()` 和 `__exit__()` 方法创建自定义的上下文管理器，例如以下基于上下文管理器实现的计时器：

```python
import time

class Timer:
    def __enter__(self):
        import time
        self.start = time.time()
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        import time
        self.end = time.time()
        print(f"cost: {self.end - self.start:.2f} second")
        return False # 注意不要忽略 exit 的返回值造成异常处理出现问题

# 对代码执行时间进行计时
with Timer() as t:
    # 执行一些耗时操作
    time.sleep(1)
```

---

然而对于很多简单场景，手动定义一个类会显得比较繁琐。为此，Python 还提供了 `contextlib` 包以简化上下文管理：

```python
from contextlib import contextmanager

@contextmanager
def context():
    # 进入 with 之前执行的代码，等价于 __enter__()
    yield resource # yield 返回的值，等价于 __enter__() 的返回值
    # 离开 with 之后执行的代码，正常情况下对应__exit__()
```

> 需要注意的是，`@contextmanager` 不保证异常情况下 `yield` 之后的代码也能正常执行，为保证异常安全，还是需要将 `yield` 及之后的代码使用 `try...finally` 包围

以上基于上下文管理器实现的计时器使用 `contextlib` 实现如下：

```python
import time
from contextlib import contextmanager

@contextmanager
def Timer():

    # 进入 with 之前执行
    start = time.time()

    # 将控制权交给 with 代码块
    yield

    # 离开 with 之后执行
    end = time.time()
    print(f"cost: {end - start:.2f} second")

# 对代码执行时间进行计时
with Timer():
    # 执行一些耗时操作
    time.sleep(1)
```

### 3. Типизация и статическая проверка <br> 类型注解于静态类型检查

Python 是一种动态类型语言（Dynamically Typed Language），变量的类型不需要提前声明，而实在运行过程中动态确定，并且同一个变量的类型可能随运行场景动态改变。这简化了程序设计，但在工程场景下也埋下了语法歧义与难以维护的隐患。

例如以下代码既可以用于数字相加，也可以用于字符串拼接，导致用法不不统一：

```python
def add(a, b):
    return a + b
```

为此，Python 提供了类型注解 Type Hints 用以标注变量、函数参数和返回值的类型，其中变量和参数在其名称后使用 `:` 后接类型表示，函数返回值在函数声明后使用 `->` 后接类型表示

于是上述 `add()` 函数可以使用类型注解表示为：

```python
def add(a: int, b: int) -> int:
    return a+b
```

需要注意的是，Python 的类型注解不同于 C/Java 语言的强类型检查，没有改变 Python 的动态类型的机制，也不会对变量本身的类型进行强制限制，只是提供了类型提示以及静态检查的功能，因此 `add("hello", "world")` 仍然可以正常执行并返回 `helloworld`

---

除了对基础的变量，参数和函数返回值进行类型标注，也可以引入 `typing` 模块对列表、字典等容器类型进行标注：

```
from typing import List, Dict, Tuple, Set

# List[int] 表示这是一个只包含整数的列表
numbers: List[int] = [1, 2, 3, 4, 5]

# Dict[str, int] 表示这是一个键为字符串、值为整数的字典
student_scores: Dict[str, int] = {"Alice": 95, "Bob": 88}

# Tuple[int, str, bool] 表示这是一个包含整数、字符串、布尔值的元组
person_info: Tuple[int, str, bool] = (25, "Alice", True)

# Set[str] 表示这是一个只包含字符串的集合
unique_names: Set[str] = {"Alice", "Bob", "Charlie"}
```

`typing` 还提供了以下复杂类型标注功能：

- 联合类型（Union）：当值可能是多种类型之一时使用
  
  ```python
  from typing import Union

  def process_input(data: Union[str, int, List[int]]) -> None:
      """处理可能是字符串、整数或整数列表的输入"""
      if isinstance(data, str):
          print(f"字符串: {data}")
      elif isinstance(data, int):
          print(f"整数: {data}")
      elif isinstance(data, list):
          print(f"列表: {data}")

  process_input("hello")    # 输出：字符串: hello
  process_input(42)         # 输出：整数: 42  
  process_input([1, 2, 3])  # 输出：列表: [1, 2, 3]
  ```

- 可选类型（Optional）：当值可能是某种类型或者是 None 时使用

  ```python
  from typing import Optional

  def find_student(name: str) -> Optional[str]:
      """根据名字查找学生，可能找到也可能返回None"""
      students = {"Alice": "A001", "Bob": "B002"}
      return students.get(name)  # 可能返回字符串或None

  # 等价于 Union[str, None]
  ```

---

而当类型很复杂时，例如我们要标注一个二维坐标列表的类型时，可以使用类型别名（Type Alias）

---

对于静态类型检查，Python 提供了 `Mypy` 工具，我们需要首先安装它：

```
pip install mypy
```

对于存在潜在类型问题的 Python 文件：

```python
# example.py
def add_numbers(a: int, b: int) -> int:
    return a + b

result = add_numbers("5", "3")  # 这里有问题！传入了字符串
```

可以运行 mypy 检查

```
mypy example.py
```

会得到类似这样的输出，提示类型错误：

```python
example.py:4: error: Argument 1 to "add_numbers" has incompatible type "str"; expected "int"
example.py:4: error: Argument 2 to "add_numbers" has incompatible type "str"; expected "int"
Found 2 errors in 1 file (checked 1 source file)
```

现代集成开发环境工具，大部分已经内置了类型检查支持，自动提供错误高亮提示以及智能补全建议


---

### 4. Асинхронность (asyncio) <br> 异步编程

程序执行通常有两种方式：同步（synchronous）和异步（asynchronous）。

同步程序按照代码顺序一步一步执行，例如以下模拟烹饪的程序

```python
import time

def prepare_ingredients(ingredients): # 备菜
    print("Begin preparing ingredients")
    time.sleep(200)
    print("Ingredients are prepared")
    return "prepared " + ingredients

def boil_water(water): # 烧水
    print("Begin boiling water")
    time.sleep(300)
    print("Water is ready")
    return "hot " + water

def cooking(): # 烹饪
    prepare_ingredients("")
    boil_water("water")
```

执行过程

```python
开始备菜 prepare_ingredients
    ↓
等待200秒
    ↓
完成备菜 prepare_ingredients
    ↓
开始烧水 boil_water
    ↓
等待300秒
    ↓
完成烧水
```

总时间约为500秒，且等等待期间，当前线程处于阻塞状态，无法继续执行后续代码，因此 CPU 计算资源没有被当前任务充分利用。这种由等待输入输出操作导致的等待称为 I/O 阻塞（I/O blocking）。

常见的 I/O 阻塞包括：

- 网络 I/O：如 HTTP 请求、API 调用、下载文件、WebSocket
  ```python
  response = requests.get(url)
  ```
- 文件 I/O：文件读写等
  ```python
  data=open("large_file.txt").read()
  ```
- 数据库 I/O：增删查改等操作
  ```python
  result = database.query()
  ```
- ...

这些操作往往其等待时间远大于 CPU 计算时间，长时间的空闲等待会拖慢整个流程的执行效率

而异步编程（asyncio）则主要解决这种 I/O 阻塞问题，通过在 I/O 等待期间切换任务，提高单线程处理大量 I/O 操作的效率。

对此，Python 提供了 `asyncio` 包以实现异步编程，它提供了以下核心概念：协程（Coroutine），事件循环（Event Loop），任务（Task）与未来对象（Future）用于实现单线程异步并发

1. 协程（Coroutine）：协程是一种特殊函数，可以在执行过程中暂停，保存状态并在稍后恢复执行。协程通过 `async def` 关键字定义，并通过 `await` 关键字暂停执行，等待异步操作完成。
   
   ```python
   import asyncio

   async def boil_water(water): # 烧水
       print("Begin boiling water")
       await asyncio.sleep(300)
       print("Water is ready")

   asyncio.run(boil_water("water"))
   ```
2. 异步任务（Task）：当程序需要同时运行多个协程时，需要将协程封装为任务，即协程的包装对象，它将协程注册到事件循环中，使事件循环能够调度它。我们可以通过 `asyncio.create_task()` 函数创建 Task，并将其添加到事件循环中
   
   ```python
   async def cook():
       boil_water1 = asyncio.create_task(boil_water("300 ml water"))
       boil_water2 = asyncio.create_task(boil_water("anather 300 ml water"))

       await boil_water1
       await boil_water2
   
   asyncio.run(cook())
   ```
   
3. 事件循环（Event Loop）：事件循环是 `asyncio` 的核心调度机制，负责管理所有 Task 任务，检查异步操状态，恢复已经完成等待的任务并调度可以继续执行的任务。它相当于一个任务调度器，当某个 Task 因为 await 等待 I/O 操作而暂停时，事件循环会将控制权交给其他处于 Ready 状态的 Task；当等待操作完成后，再恢复原 Task 的执行。
   
   ```python
              Event Loop
                  |
      -------------------------
      |           |           |
   Task A      Task B      Task C
      |
   await等待
      |
   切换执行其他就绪Task
   ```

4. 未来对象（Future）：Future 是 `asyncio` 中用于表示异步操作结果的对象，相当于一个结果占位符，在异步操作开始时，Future 处于 `Pending` 状态；当异步操作完成后，可以通过 `set_result()` 保存结果，或者通过 `set_exception()` 保存异常。其他协程可以通过 `await` 等待 Future 完成并获取最终结果。
   
   > 在实际开发中，Future 通常由底层框架创建和管理，而开发者更多使用 Task。Task 本身继承自 Future，用于封装和调度 Coroutine。
   
   ```python
   async def cook():
       meal = asyncio.Future()
       meal.set_result("Meal is ready")
       result = await meal
   ```

通过结合上述概念，我们可以以异步方式实现最初的例子：

```python
import asyncio

async def prepare_ingredients(ingredients): # 备菜
    print("Begin preparing ingredients")
    await asyncio.sleep(200)
    print("Ingredients are prepared")

    return "prepared " + ingredients

async def boil_water(water):  # 烧水
    print("Begin boiling water")
    await asyncio.sleep(300)
    print("Water is ready")

    return "hot " + water

async def cook(meal):
    task_prepare_vegetable = asyncio.create_task(prepare_ingredients("vegetable"))
    task_boil_water = asyncio.create_task(boil_water("water"))

    vegetable = await task_prepare_vegetable
    water = await task_boil_water

    meal = meal + ": " + vegetable + ", " + water

    return meal

if __name__ == "__main__":
    results = asyncio.run(cook("Soup"))
    print(results)
```

最终输出

```
Begin preparing ingredients
Begin boiling water
Ingredients are prepared
Water is ready
Soup: prepared vegetable, hot water
```

对比最初同步的版本所需大约 500 秒的执行时间，使用了 `asyncio` 的异步版本耗时缩短至 300 秒，显著提升了程序执行效率