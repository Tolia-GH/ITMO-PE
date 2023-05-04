<head>
    <script src="https://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML" type="text/javascript"></script>
    <script type="text/x-mathjax-config">
        MathJax.Hub.Config({
            tex2jax: {
            skipTags: ['script', 'noscript', 'style', 'textarea', 'pre'],
            inlineMath: [['<img src="https://latex.codecogs.com/gif.latex?&#x27;,&#x27;"/>']]
            }
        });
    </script>
</head>
  
##  [MainPage](../index.md )/[Probability Theory](README.md )/Lecture
  
  
- [MainPage/Probability Theory/Lecture](#mainpageprobability-theorylecture )
- [Лекция 1](#лекция-1 )
  - [Основные понятия и определения](#основные-понятия-и-определения )
  - [Основные понятия и определения](#основные-понятия-и-определения-1 )
  - [Основные понятия и определения](#основные-понятия-и-определения-2 )
  - [Основные понятия и определения](#основные-понятия-и-определения-3 )
  - [Строгие определения](#строгие-определения )
  - [Свойства операций над событиями](#свойства-операций-над-событиями )
  - [Вероятность. Аксиомы теории вероятностей.](#вероятность-аксиомы-теории-вероятностей )
  - [Основные теоремы и следствия теории вероятностей](#основные-теоремы-и-следствия-теории-вероятностей )
  - [Основные теоремы и следствия теории вероятностей](#основные-теоремы-и-следствия-теории-вероятностей-1 )
  - [Основные теоремы и следствия теории вероятностей](#основные-теоремы-и-следствия-теории-вероятностей-2 )
  - [Классическая схема вычисления вероятностей](#классическая-схема-вычисления-вероятностей )
  - [Декартово произведение множеств и правило умножения](#декартово-произведение-множеств-и-правило-умножения )
  - [Декартово произведение множеств и правило умножения](#декартово-произведение-множеств-и-правило-умножения-1 )
  - [Правило умножения и правило сложения](#правило-умножения-и-правило-сложения )
  - [Размещения и перестановки](#размещения-и-перестановки )
  - [Размещения с повторениями](#размещения-с-повторениями )
  - [Сочетания](#сочетания )
  - [Сочетания с повторениями](#сочетания-с-повторениями )
  - [Перестановки с повторениями](#перестановки-с-повторениями )
  - [Геометрическая схема вычисления вероятности](#геометрическая-схема-вычисления-вероятности )
  - [Условная вероятность](#условная-вероятность )
  - [Вероятность произведения двух событий](#вероятность-произведения-двух-событий )
  - [Независимость событий](#независимость-событий )
  - [Независимость системы событий](#независимость-системы-событий )
  - [Формула полной вероятности](#формула-полной-вероятности )
  - [Формула полной вероятности](#формула-полной-вероятности-1 )
  - [Формула Байеса](#формула-байеса )
- [Лекция 2 СЛУЧАЙНЫЕ ВЕЛИЧИНЫ](#лекция-2-случайные-величины )
  - [Независимые испытания. Схема Бернулли.](#независимые-испытания-схема-бернулли )
  - [Формула Бернулли.](#формула-бернулли )
  - [Полиномиальное распределение](#полиномиальное-распределение )
  - [Теорема Пуассона](#теорема-пуассона )
  - [Математическая модель простейшего потока событий](#математическая-модель-простейшего-потока-событий )
  - [Локальная теорема Муавра-Лапласа](#локальная-теорема-муавра-лапласа )
  - [Функция Гаусса](#функция-гаусса )
  - [Интегральная теорема Муавра-Лаплоса](#интегральная-теорема-муавра-лаплоса )
  - [Нормированная функция Лапласа](#нормированная-функция-лапласа )
  - [Функция Лапласа](#функция-лапласа )
  - [Случайная величина](#случайная-величина )
  - [Строгое определение](#строгое-определение )
  - [Многоугольник (полигон) распределения](#многоугольник-полигон-распределения )
  - [Дискретная случайная величина](#дискретная-случайная-величина )
  - [Дискретная случайная величина](#дискретная-случайная-величина-1 )
  - [Функция распределения случайной величины](#функция-распределения-случайной-величины )
  - [Свойства функции распределения](#свойства-функции-распределения )
  - [Непрерывная случайная величина](#непрерывная-случайная-величина )
  - [Функция распределения дискретной случайной величины](#функция-распределения-дискретной-случайной-величины )
  - [Плотность распределения вероятностей](#плотность-распределения-вероятностей )
  - [Свойства плотности распределения](#свойства-плотности-распределения )
- [Лекция 3 Числовые характеристики случайных величин](#лекция-3-числовые-характеристики-случайных-величин )
  - [Числовые характеристики случайных величин](#числовые-характеристики-случайных-величин )
  - [Математическое ожидание дискретной случайной величины](#математическое-ожидание-дискретной-случайной-величины )
  - [Вероятностный смысл математического ожидания](#вероятностный-смысл-математического-ожидания )
  - [Математическое ожидание дискретной случайной величины](#математическое-ожидание-дискретной-случайной-величины-1 )
  - [Математическое ожидание непрерывной случайной величины](#математическое-ожидание-непрерывной-случайной-величины )
  - [Свойства математического ожидания](#свойства-математического-ожидания )
  - [Дисперсия случайной величины](#дисперсия-случайной-величины )
  - [Дисперсия случайной величины](#дисперсия-случайной-величины-1 )
  - [Свойства дисперсии](#свойства-дисперсии )
  - [Свойства дисперсии](#свойства-дисперсии-1 )
  - [Среднее квадратическое отклонение](#среднее-квадратическое-отклонение )
  - [Стандартная случайная величина](#стандартная-случайная-величина )
  - [Моменты случайной величины](#моменты-случайной-величины )
  - [Центральный момент](#центральный-момент )
  - [Производящая функция](#производящая-функция )
  - [Производящая функция](#производящая-функция-1 )
- [Лекция 4](#лекция-4 )
  
  
##  Лекция 1
  
  
###  Основные понятия и определения
  
  
**Теория вероятностей** — это математическая дисциплина, в рамках которой моделируют и изучают такие события в повседневной жизни, науке и технике, которые носят случайный характер.
  
В теории вероятностей первичным понятием является произвольное множество. Элементы <img src="https://latex.codecogs.com/gif.latex?&#x5C;omega"/> этого множества называют **элементарными событиями**, а само множество <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/> называют **пространством элементарных событий**.
  
Для описания каждой реальной задачи пространство <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/> выбирается наиболее подходящим образом. Пусть, например, опыт состоит в подбрасывании один раз правильной шестигранной игральной кости. Наблюдаемый результат — число очков на верхней грани. Пространство элементарных событий <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/> в этом случае равно множеству <img src="https://latex.codecogs.com/gif.latex?&#x5C;{1,%202,%203,%204,%205,%206&#x5C;}"/>, а элементарные события — цифры от одной до шести.
  
Пространство <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/> может быть **дискретным** или **непрерывным**. Дискретные пространства подразделяются на конечные и счетные — эквивалентные множеству натуральных чисел.
  
Если пространство <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/> дискретно, то **случайным событием** может быть любое подмножество пространства элементарных событий. События обозначают прописными буквами латинского алфавита: <img src="https://latex.codecogs.com/gif.latex?A,%20B,%20C,%20...,%20Z"/> . Говорят, что событие A произошло (наступило, реализовалось), если результатом опыта явился элементарный исход, принадлежащий <img src="https://latex.codecogs.com/gif.latex?A"/>.
  
###  Основные понятия и определения
  
  
Событие, совпадающее с пустым множеством <img src="https://latex.codecogs.com/gif.latex?&#x5C;varnothing"/> , называется невозможным событием, а событие, совпадающее со всем множеством <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/>, — достоверным событием. Невозможное событие не происходит ни в одном опыте, а достоверное — осуществляется всегда.
  
Если пространство <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/> непрерывно, то событиями являются не любые его подмножества, а только те, которые принадлежат <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma"/> - алгебре событий, т. е. семейству подмножеств, замкнутому относительно основных операций над множествами. Для того, чтобы задать <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma"/> - алгебру событий, надо предварительно определить основные операции и отношения между событиями. Поскольку любое событие отождествляется с некоторым множеством, то над событиями можно совершать те же операции, что и над множествами.
  
Множества, состоящие из одинаковых элементов, называют равными.
  
Если каждый элемент множества <img src="https://latex.codecogs.com/gif.latex?A"/> является также элементом множества <img src="https://latex.codecogs.com/gif.latex?B"/> , то пишут <img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;subset%20B"/> и говорят, что <img src="https://latex.codecogs.com/gif.latex?A"/> есть подмножество <img src="https://latex.codecogs.com/gif.latex?B"/> или <img src="https://latex.codecogs.com/gif.latex?A"/> включено в <img src="https://latex.codecogs.com/gif.latex?B"/> или <img src="https://latex.codecogs.com/gif.latex?A"/> внутри <img src="https://latex.codecogs.com/gif.latex?B"/> .
  
###  Основные понятия и определения
  
  
С помощью логических символов определение включения одного множества в другое записывается следующим образом:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;subset%20B%20&#x5C;Leftrightarrow%20&#x5C;forall%20x(x%20&#x5C;in%20A%20&#x5C;rightarrow%20x%20&#x5C;in%20B)%20&#x5C;Leftrightarrow%20(x%20&#x5C;in%20A%20&#x5C;Rightarrow%20x%20&#x5C;in%20B)."/></p>  
  
  
Если <img src="https://latex.codecogs.com/gif.latex?A"/> и <img src="https://latex.codecogs.com/gif.latex?B"/> — события и <img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;subset%20B"/> , то говорят, что **из события** <img src="https://latex.codecogs.com/gif.latex?A"/> **следует событие** <img src="https://latex.codecogs.com/gif.latex?B"/> . Иначе говоря, событие B происходит всякий раз, как происходит событие <img src="https://latex.codecogs.com/gif.latex?A"/> . В примере с игральной костью из события «число выпавших очков будет кратно 5 » следует событие «число выпавших очков будет нечетно», так как <img src="https://latex.codecogs.com/gif.latex?&#x5C;{5&#x5C;}%20&#x5C;subset%20&#x5C;{1,%203,%205&#x5C;}"/>.
  
**Суммой двух событий** <img src="https://latex.codecogs.com/gif.latex?A"/> и <img src="https://latex.codecogs.com/gif.latex?B"/> называется событие <img src="https://latex.codecogs.com/gif.latex?A%20+%20B"/>, являющееся объедине- нием <img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;cup%20B"/>. Событие <img src="https://latex.codecogs.com/gif.latex?A%20+%20B"/> состоит в том, что произошло по крайней мере одно из событий A или B.
  
**Произведением событий** <img src="https://latex.codecogs.com/gif.latex?A"/> и <img src="https://latex.codecogs.com/gif.latex?B"/> называется событие AB, равное пересечению <img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;cap%20B"/>. Событие <img src="https://latex.codecogs.com/gif.latex?AB"/> происходит тогда и только тогда, когда происходит и <img src="https://latex.codecogs.com/gif.latex?A"/> и <img src="https://latex.codecogs.com/gif.latex?B"/>.
  
Если множества не имеют общих элементов, то их называют непересекающимися, а соответствующие события –– несовместными. Для двух множеств <img src="https://latex.codecogs.com/gif.latex?A"/> и <img src="https://latex.codecogs.com/gif.latex?B"/> в этом случае <img src="https://latex.codecogs.com/gif.latex?AB%20=%20&#x5C;varnothing"/> . Например, события «выпадет чётное число очков» и «выпадет нечётное число очков» несовместны, так как множества <img src="https://latex.codecogs.com/gif.latex?A%20=%20&#x5C;{2,%204,%206&#x5C;}"/> и <img src="https://latex.codecogs.com/gif.latex?B%20=%20&#x5C;{1,%203,%205&#x5C;}"/> не пересекаются. 
  
###  Основные понятия и определения
  
  
События <img src="https://latex.codecogs.com/gif.latex?A_1,%20A_2,...%20,%20A_n"/> образуют **полную группу**, если они попарно несовместны, а в сумме дают достоверное событие. Например, указанные выше события <img src="https://latex.codecogs.com/gif.latex?A%20=%20&#x5C;{2,%204,%206&#x5C;}"/> и <img src="https://latex.codecogs.com/gif.latex?B%20=%20&#x5C;{1,%203,%205&#x5C;}"/> образуют полную группу.
  
Разностью двух множеств <img src="https://latex.codecogs.com/gif.latex?A"/> и <img src="https://latex.codecogs.com/gif.latex?B"/> называют множество <img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;setminus%20B"/> , состоящее из тех элементов, которые входят в <img src="https://latex.codecogs.com/gif.latex?A"/> , но не входят в <img src="https://latex.codecogs.com/gif.latex?B"/> :
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;setminus%20B%20=%20&#x5C;{x%20&#x5C;in%20&#x5C;Omega%20|x%20&#x5C;in%20A%20&#x5C;cap%20x%20ƒ&#x5C;in%20B&#x5C;}"/></p>  
  
  
Разности множеств соответствует **разность событий**. Это новое событие, состоящее в том, что A происходит, а B не происходит. Например, если <img src="https://latex.codecogs.com/gif.latex?A%20=%20&#x5C;{1,%202,%203,%204&#x5C;}"/> — множество очков меньших пяти, <img src="https://latex.codecogs.com/gif.latex?B%20=%20&#x5C;{2,%204,%206&#x5C;}"/> — множество чётных очков, то <img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;%20B%20=%20&#x5C;{1,%203&#x5C;}"/>. Если рассматривается разность между пространством элементарных событий и некоторым множеством <img src="https://latex.codecogs.com/gif.latex?A"/> , то разность <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega%20&#x5C;setminus%20A"/> называется **дополнением множества** <img src="https://latex.codecogs.com/gif.latex?A"/> и обозначается <img src="https://latex.codecogs.com/gif.latex?&#x5C;overline{A}"/> . Событие <img src="https://latex.codecogs.com/gif.latex?&#x5C;overline{A}"/> называют событием **противоположным** <img src="https://latex.codecogs.com/gif.latex?A"/> . Это событие,состоящее в том, что <img src="https://latex.codecogs.com/gif.latex?A"/> не происходит. Так, событием противоположным событию <img src="https://latex.codecogs.com/gif.latex?A%20=%20&#x5C;{1,%202,%203,%204&#x5C;}"/> будет событие выпадение числа очков больших или равных пяти .
  
###  Строгие определения
  
  
**Определение <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma"/> -алгебры.** Семейство подмножеств <img src="https://latex.codecogs.com/gif.latex?S"/> пространства <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/> называют <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma"/> -алгеброй, если выполняются следующие условия:
-  пустое множество <img src="https://latex.codecogs.com/gif.latex?&#x5C;varnothing"/> и само пространство <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/> входят в <img src="https://latex.codecogs.com/gif.latex?S"/> ;
-  данное семейство замкнуто относительно теоретико- множественных операций, включая счетные объединения и пересечения множеств из <img src="https://latex.codecogs.com/gif.latex?S"/> .
  
**Определение события.**
  
Событием называют некоторое подмножество пространства элемен- тарных событий <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/> , принадлежащее <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma"/> - алгебре пространства <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/> .
  
###  Свойства операций над событиями
  
  
Операции над событиями обладают следующими свойствами:
- <img src="https://latex.codecogs.com/gif.latex?A+B%20=%20B+A&#x5C;%20A&#x5C;cdot%20B%20=%20B&#x5C;cdot%20A"/> (переместительное)
- <img src="https://latex.codecogs.com/gif.latex?(A+B)&#x5C;cdot%20C%20=%20A&#x5C;cdot%20C%20+%20B&#x5C;cdot%20C,%20A&#x5C;cdot%20B%20+%20C=(A+C)&#x5C;cdot(B+C)"/> (распределительное)
- <img src="https://latex.codecogs.com/gif.latex?(A+B)+C=A+(B+C),%20(A&#x5C;cdot%20B)&#x5C;cdot%20C=A&#x5C;cdot(B&#x5C;cdot%20C)"/> (сочетательное)
- <img src="https://latex.codecogs.com/gif.latex?A+A=A,%20A&#x5C;cdot%20A%20=%20A"/>
- <img src="https://latex.codecogs.com/gif.latex?A+&#x5C;Omega%20=%20&#x5C;Omega,%20A&#x5C;cdot%20&#x5C;Omega=A"/>
- <img src="https://latex.codecogs.com/gif.latex?A+&#x5C;overline{A}=&#x5C;Omega,%20A&#x5C;cdot&#x5C;overline{A}=&#x5C;varnothing"/>
- <img src="https://latex.codecogs.com/gif.latex?&#x5C;overline{&#x5C;varnothing}=&#x5C;Omega,&#x5C;overline{&#x5C;Omega}=&#x5C;varnothing,&#x5C;overline{&#x5C;overline{A}}=A"/>
- <img src="https://latex.codecogs.com/gif.latex?A-B=A&#x5C;cdot&#x5C;overline{B}"/>
- <img src="https://latex.codecogs.com/gif.latex?&#x5C;overline{A+B}=&#x5C;overline{A}&#x5C;cdot&#x5C;overline{B},%20&#x5C;overline{A&#x5C;cdot%20B}=&#x5C;overline{A}+&#x5C;overline{B}"/> (закон Де Моргана)
  
###  Вероятность. Аксиомы теории вероятностей.
  
  
Вероятностью называется числовая функция <img src="https://latex.codecogs.com/gif.latex?P%20:%20F%20&#x5C;rightarrow%20R"/>, заданная на <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma"/>-алгебре событий <img src="https://latex.codecogs.com/gif.latex?F"/> , которая должна удовлетворять трем аксиомам:
1) <img src="https://latex.codecogs.com/gif.latex?P(A)%20&#x5C;ge%200"/> для любого <img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;in%20F"/> (неотрицательность <img src="https://latex.codecogs.com/gif.latex?P"/>); 
2) <img src="https://latex.codecogs.com/gif.latex?P(&#x5C;Omega%20)%20=%201"/> (нормированность <img src="https://latex.codecogs.com/gif.latex?P"/>);
3) <img src="https://latex.codecogs.com/gif.latex?P(A%20+%20B)%20=%20P(A)%20+%20P(B)"/> для любых <img src="https://latex.codecogs.com/gif.latex?A,%20B%20&#x5C;in%20F%20,%20AB%20=%20&#x5C;varnothing"/> (аддитивность <img src="https://latex.codecogs.com/gif.latex?P"/>): для несовместных событий вероятность суммы событий равна сумме их вероятностей.
  
Тройку <img src="https://latex.codecogs.com/gif.latex?&#x5C;{&#x5C;Omega%20,%20S,%20P%20&#x5C;}"/>, где <img src="https://latex.codecogs.com/gif.latex?S"/> есть <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma"/> -алгебра подмножеств пространства элементарных событий <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/> , <img src="https://latex.codecogs.com/gif.latex?P"/> — числовая функция, удовлетворяющая трем аксиомам, называют **вероятностным пространством** случайного опыта, а неотрицательную, нормированную и аддитивную вероятностную функцию <img src="https://latex.codecogs.com/gif.latex?P%20(A),%20A%20&#x5C;in%20S,%20A%20&#x5C;subset%20&#x5C;Omega"/> — **распределением вероятностей**.
  
Аксиоматическая теория вероятностей в ее современном виде была создана русским математиком А. Н. Колмогоровым в 1933 году.
  
###  Основные теоремы и следствия теории вероятностей
  
  
**Теорема (о монотонности распределения вероятностей)**.
  
Если из события <img src="https://latex.codecogs.com/gif.latex?A"/> следует событие <img src="https://latex.codecogs.com/gif.latex?B"/> , то справедлива формула: 
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P%20(A)%20&#x5C;le%20P%20(B)"/></p>  
  
  
**Доказательство**.
Так как <img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;subset%20B"/> , то событие B представимо в виде
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?B%20=%20B&#x5C;Omega%20%20=%20B(A%20+&#x5C;overline{A})%20=%20BA%20+%20B&#x5C;overline{A}=%20A%20+%20B&#x5C;overline{A}"/></p>  
  
  
Отсюда, используя аксиому сложения, получим <img src="https://latex.codecogs.com/gif.latex?P%20(B)%20=%20P%20(A)%20+%20P%20(B&#x5C;overline{A})"/> .
Так как в силу аксиомы 1 справедливо неравенство <img src="https://latex.codecogs.com/gif.latex?P%20(B&#x5C;overline{A})%20&#x5C;ge%200"/> , то из предшествующего равенства следует доказательство теоремы.
  
###  Основные теоремы и следствия теории вероятностей
  
  
**Теорема (о вероятности противоположного события)**.
  
Вероятность противоположного события вычисляется по формуле: 
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P%20(&#x5C;overline{A})%20=%201%20−%20P%20(A)"/></p>  
  
  
**Доказательство**. Из равенства <img src="https://latex.codecogs.com/gif.latex?A%20+%20A%20^-%20=%20&#x5C;Omega"/> и аксиомы сложения следует <img src="https://latex.codecogs.com/gif.latex?P%20(A)%20+%20P%20(A^-)%20=%20P%20(&#x5C;Omega%20)"/> . В силу аксиомы нормированности <img src="https://latex.codecogs.com/gif.latex?P%20(&#x5C;Omega%20)%20=%201"/> , так что из предшествующего равенства получаем доказываемую формулу.
  
Отсюда, учитывая, что невозможное и достоверное события взаимно противоположны, т. е. справедливо равенство <img src="https://latex.codecogs.com/gif.latex?&#x5C;varnothing%20+%20&#x5C;Omega%20%20=%20&#x5C;Omega"/> , выводится утвер- ждение <img src="https://latex.codecogs.com/gif.latex?P%20(&#x5C;varnothing)%20=%200"/>: «**вероятность невозможного события равна нулю**».
  
Для любого события <img src="https://latex.codecogs.com/gif.latex?A"/> истинны соотношения <img src="https://latex.codecogs.com/gif.latex?&#x5C;varnothing%20&#x5C;subset%20A%20&#x5C;subset%20&#x5C;Omega"/>. Отсюда,
учитывая монотонность распределения вероятностей, следуют неравенства <img src="https://latex.codecogs.com/gif.latex?0%20&#x5C;le%20P%20(A)%20&#x5C;le%201"/> , утверждающие, что **вероятность любого события всегда лежит между нулем и единицей.**
  
###  Основные теоремы и следствия теории вероятностей
  
  
**Теорема (о вероятности суммы совместных событий)**.
  
Для любых двух событий верна формула сложения вероятностей:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P%20(A%20&#x5C;cup%20B)%20=%20P%20(A)%20+%20P%20(B)%20−%20P%20(AB)"/></p>  
  
  
**Доказательство**. Представим событие <img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;cup%20B"/> в виде <img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;cup%20B%20=%20A%20+%20B&#x5C;overline{A}"/>, а
событие <img src="https://latex.codecogs.com/gif.latex?B"/> в виде <img src="https://latex.codecogs.com/gif.latex?B%20=%20B&#x5C;overline{A}+BA"/> . События в правых частях данных равенств несовместны, поэтому по аксиоме сложения получим: 
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P(A&#x5C;cup%20B)=P(A)+P(B&#x5C;overline{A}),%20P(B)=P(B&#x5C;overline{A})+P(BA)"/></p>  
  
  
Отсюда следует доказываемая формула сложения вероятностей.
Из формулы сложения вероятностей по индукции выводится общая формула вероятности суммы любого конечного числа событий. В частности, формула вычисления вероятности суммы трех событий имеет вид
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P%20(A%20&#x5C;cup%20B%20&#x5C;cup%20C)%20=%20P%20(A)%20+%20P%20(B)%20+%20P%20(C)%20−%20P%20(AB)%20−%20P%20(AC)%20−%20P%20(BC)%20+%20P%20(ABC)"/></p>  
  
  
###  Классическая схема вычисления вероятностей
  
  
Пусть пространство элементарных событий <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/>  конечно, состоит из <img src="https://latex.codecogs.com/gif.latex?n"/> равновероятных исходов, вероятность каждого исхода равна <img src="https://latex.codecogs.com/gif.latex?1&#x2F;n"/> и, следовательно, сумма вероятностей всех исходов равна единице. Определим вероятность каждого события <img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;subset%20&#x5C;Omega"/> как сумму вероятностей тех исходов, которые входят в это подмножество. Все аксиомы теории вероятностей выполняются при такой схеме задания вероятностей событий, и, соответственно, выполняются все выводы, которые следуют из аксиом. Данную конечную схему вычисления вероятностей называют классической, а вероятность любого события <img src="https://latex.codecogs.com/gif.latex?A%20&#x5C;subset%20&#x5C;Omega"/> находят по формуле классической вероятности:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P(A)=&#x5C;frac{N(A)}{N(&#x5C;Omega)}"/></p>  
  
  
где буквой <img src="https://latex.codecogs.com/gif.latex?N"/> обозначено число элементов в множестве.
  
Таким образом, вероятность любого случайного события в классической схеме равна отношению числа исходов, благоприятствующих появлению этого события, к общему числу элементарных исходов.
  
При решении многих задач с использованием классической схемы часто оказываются полезными различные комбинаторные формулы.
  
###  Декартово произведение множеств и правило умножения
  
  
Пусть заданы два множества <img src="https://latex.codecogs.com/gif.latex?A"/> и <img src="https://latex.codecogs.com/gif.latex?B"/> с произвольным числом элементов любой природы в каждом множестве. Образуем новое множество по правилу: <img src="https://latex.codecogs.com/gif.latex?D%20=%20&#x5C;{(a,%20b)|a%20&#x5C;in%20A,%20b%20&#x5C;in%20B&#x5C;}"/>. Это новое множество называется **прямым или декартовым произведением множеств** <img src="https://latex.codecogs.com/gif.latex?A"/> и <img src="https://latex.codecogs.com/gif.latex?B"/> и обозначается <img src="https://latex.codecogs.com/gif.latex?D%20=%20A%20&#x5C;times%20B"/> . Элементы прямого произведения представляют собой упорядоченные пары, причём две упорядоченные пары равны только в том случае, когда у них равны первые элементы и равны вторые элементы.
  
**Пример**. Имея множества <img src="https://latex.codecogs.com/gif.latex?A%20=%20&#x5C;{1;%202&#x5C;}"/> и <img src="https://latex.codecogs.com/gif.latex?B%20=%20&#x5C;{&#x5C;alpha;%20&#x5C;beta&#x5C;}"/> , можно образовать декартовы произведения следующего вида:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?D_1=A&#x5C;times%20B=&#x5C;{(1,&#x5C;alpha);(1,&#x5C;beta);%20(2,&#x5C;alpha);(2,&#x5C;beta)&#x5C;}"/></p>  
  
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?D_1=A&#x5C;times%20B=&#x5C;{(&#x5C;alpha,1);(&#x5C;alpha,2);%20(&#x5C;beta,1);(&#x5C;beta,2)&#x5C;}"/></p>  
  
  
Как видно из примера, декартово произведение не обладает свойством коммутативности. Свойство коммутативности выполняется только для равных между собой множеств.
  
###  Декартово произведение множеств и правило умножения
  
  
Если дана система множеств <img src="https://latex.codecogs.com/gif.latex?A_1,%20A_2,...%20,%20A_n"/> , то элементами декартова произведения являются упорядоченные наборы (<img src="https://latex.codecogs.com/gif.latex?a_1,%20a_2,...%20,%20a_n"/>) , т. е.:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?A_1%20&#x5C;times%20A_2%20&#x5C;times%20···%20&#x5C;times%20A_n%20=%20{(a_1,%20a_2,%20...%20,%20a_n)|a_1%20&#x5C;in%20A_1,%20a_2%20&#x5C;in%20A_2,%20...,%20a_n%20&#x5C;in%20A_n}"/></p>  
  
  
В том случае, когда сомножители декартова произведения являются конечными множествами, можно непосредственно подсчитать, что число упорядоченных наборов (<img src="https://latex.codecogs.com/gif.latex?a_1,%20a_2,%20...,%20a_n"/>) в декартовом произведении равно произведению чисел элементов в каждом из множеств, т. е. справедлива формула:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?N%20(A_1%20&#x5C;times%20A_2%20&#x5C;times%20···%20&#x5C;times%20A_n)%20=%20N%20(A_1)%20·%20N%20(A_2)&#x5C;quad%20N(A_n)"/></p>  
  
  
Данная формула является основной в комбинаторном анализе и обычно называется **принципом или правилом умножения**.
  
В частности, в рассмотренном ранее примере исходных множеств всего два и каждое содержит по два элемента, так что в декартовом произведении содержится четыре элемента.
  
###  Правило умножения и правило сложения
  
  
**Правило умножения**. Если из некоторого конечного множества первый элемент <img src="https://latex.codecogs.com/gif.latex?a_1"/> можно выбрать <img src="https://latex.codecogs.com/gif.latex?n_1"/> способами, а второй элемент <img src="https://latex.codecogs.com/gif.latex?a_2"/> можно выбрать <img src="https://latex.codecogs.com/gif.latex?n_2"/> способами, то оба элемента <img src="https://latex.codecogs.com/gif.latex?(a_1,%20a_2)"/> в указанном порядке можно выбрать <img src="https://latex.codecogs.com/gif.latex?n_1%20·%20n_2"/> способами.
  
**Правило сложения**. Если из некоторого конечного множества первый элемент <img src="https://latex.codecogs.com/gif.latex?a_1"/> можно выбрать <img src="https://latex.codecogs.com/gif.latex?n_1"/> способами, а второй элемент <img src="https://latex.codecogs.com/gif.latex?a_2"/> можно выбрать <img src="https://latex.codecogs.com/gif.latex?n_2"/> способами, то хотя бы один из этих элементов (<img src="https://latex.codecogs.com/gif.latex?a_1"/> или <img src="https://latex.codecogs.com/gif.latex?a_2"/>) можно выбрать <img src="https://latex.codecogs.com/gif.latex?n_1%20+%20n_2"/> способами.
  
Правила умножения и сложения справедливы для любого конечного числа (два и более) выбираемых элементов.
  
###  Размещения и перестановки
  
  
Пусть имеется некоторое множество из <img src="https://latex.codecogs.com/gif.latex?n"/> элементов. Каждое его упорядоченное подмножество, состоящее из <img src="https://latex.codecogs.com/gif.latex?k"/> элементов, называется **размещением из** <img src="https://latex.codecogs.com/gif.latex?n"/> **элементов по** <img src="https://latex.codecogs.com/gif.latex?k"/> . Согласно определению, одно размещение отличается от другого либо составом элементов, либо их порядком.
  
Число размещений находится по правилу умножения в виде
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?A_n^k=n&#x5C;cdot(n-1)&#x5C;cdot(n-2)&#x5C;cdot...&#x5C;cdot(n-k+1)"/></p>  
  
  
или
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?A_n^k=&#x5C;frac{n!}{(n-k)!}"/></p>  
  
  
В частном случае <img src="https://latex.codecogs.com/gif.latex?k%20=%20n"/> размещения называют **перестановками**. Одна перестановка отличается от другой только порядком расположения элементов, а число всевозможных перестановок в конечном множестве из <img src="https://latex.codecogs.com/gif.latex?n"/> элементов вычисляется по следующей формуле:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_n=A_n^n=n!"/></p>  
  
  
###  Размещения с повторениями
  
  
Пусть некоторый опыт состоит в случайном выборе <img src="https://latex.codecogs.com/gif.latex?k"/> элементов из множества, содержащего n элементов. Выбор организован таким образом, что каждый выбранный элемент возвращается обратно, так что при следующем выборе может быть взят как новый элемент, так и прежний. В дальнейшем отобранные элементы упорядочиваются либо в порядке поступления, либо по указанному в решаемой задаче правилу. Полученное таким образом соединение называют **размещением с повторениями**. Одно размещение с повторениями может отличаться от другого элементами, их порядком и количеством повторений элементов. Число всех размещений из <img src="https://latex.codecogs.com/gif.latex?n"/> элементов по <img src="https://latex.codecogs.com/gif.latex?k"/> с повторениями обозначается <img src="https://latex.codecogs.com/gif.latex?&#x5C;overline{A_n^k}"/> и находится по следующей формуле:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;overline{A_n^k}=n^k"/></p>  
  
  
При выводе данной формулы использовался комбинаторный принцип умножения <img src="https://latex.codecogs.com/gif.latex?k"/> множеств, каждое из которых содержит <img src="https://latex.codecogs.com/gif.latex?n"/> элементов.
  
###  Сочетания
  
  
Любое подмножество из <img src="https://latex.codecogs.com/gif.latex?k"/> элементов некоторого множества из <img src="https://latex.codecogs.com/gif.latex?n"/> элементов называют **сочетанием из** <img src="https://latex.codecogs.com/gif.latex?n"/> **по** <img src="https://latex.codecogs.com/gif.latex?k"/> . Одно сочетание отличается от другого хотя бы одним элементом. Число сочетаний находят по формулам:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?C_n^k=&#x5C;frac{A_n^k}{k!}=&#x5C;frac{n(n-1)(n-2)&#x5C;cdots(n-k+1)}{k!}=&#x5C;frac{n!}{k!(n-k)!}"/></p>  
  
  
Действительно, любое подмножество, содержащее <img src="https://latex.codecogs.com/gif.latex?k"/> элементов множества из <img src="https://latex.codecogs.com/gif.latex?n"/> элементов, может быть упорядочено <img src="https://latex.codecogs.com/gif.latex?k!"/> способами. Таким образом, общее число размещений <img src="https://latex.codecogs.com/gif.latex?A_n^k"/>  больше общего числа соответствующих сочетаний <img src="https://latex.codecogs.com/gif.latex?C_n^k"/> в <img src="https://latex.codecogs.com/gif.latex?k!"/> раз, т. е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?A_n^k=k!&#x5C;cdot%20C_n^k"/></p>  
  
  
Разделив формулы для числа размещений на <img src="https://latex.codecogs.com/gif.latex?k!"/>, получим формулу вычисления количества сочетаний.
  
Для чисел <img src="https://latex.codecogs.com/gif.latex?C_n^k"/> , называемых также **биномиальными коэффициентами**, справедливы следующие тождества:
  
<img src="https://latex.codecogs.com/gif.latex?C_n^k=C_n^{n-k}"/> - (свойство симметрии),
<img src="https://latex.codecogs.com/gif.latex?C_{n+1}=C_n^k+C_n^{k-1}"/> - (рекуррентное соотношение),
<img src="https://latex.codecogs.com/gif.latex?C_n^0+C_n^1+C_n^2+&#x5C;cdots+C_n^n=2^n"/> - (следствие биномиальной формулы Ньютона).
  
###  Сочетания с повторениями
  
  
В данной схеме случайный выбор <img src="https://latex.codecogs.com/gif.latex?k"/> элементов из множества, содержащего <img src="https://latex.codecogs.com/gif.latex?n"/> элементов, организован таким образом, что каждый выбранный элемент возвращается обратно, так что при каждом следующем выборе может быть взят как новый элемент, так и любой ранее выбранный. Полученное таким образом соединение называют **сочетанием с повторениями**. Одно сочетание с повторениями отличается от другого хотя бы одним элементом или числом повторений элемента. Число всех сочетаний с повторениями из <img src="https://latex.codecogs.com/gif.latex?n"/> элементов по <img src="https://latex.codecogs.com/gif.latex?k"/> обозначается <img src="https://latex.codecogs.com/gif.latex?&#x5C;overline{C_n^k}"/> и находится по следующей формуле:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;overline{C_n^k}=C_{c+k-1}^k"/></p>  
  
  
Действительно, в соответствии со схемой с возвращением и упорядочиванием, используя правило умножения, получим, что число упорядоченных соединений длиной <img src="https://latex.codecogs.com/gif.latex?k"/> равно <img src="https://latex.codecogs.com/gif.latex?n(n%20+%201)(n%20+%202)%20&#x5C;cdots%20(n%20+%20k%20−%201)"/> . Разделив данное число на k! и домножив числитель и знаменатель полученной дроби на <img src="https://latex.codecogs.com/gif.latex?(n%20−%201)!"/> , найдем число сочетаний с повторениями в указанном выше виде
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;overline{C_n^k}=&#x5C;frac{(n-1)!&#x5C;cdot%20n(n+1)(n+2)&#x5C;cdots(n+k-1)}{k!&#x5C;cdot(n-1)!}=&#x5C;frac{(n+k-1)!}{k!&#x5C;cdot(n-1)!=C_{n+k-1}^k}"/></p>  
  
  
###  Перестановки с повторениями
  
  
В схеме упорядоченных разбиений множество, содержащее n элементов, разбивается на k упорядоченных подмножеств так, что первое подмножество содержит <img src="https://latex.codecogs.com/gif.latex?n_1"/> элементов первого типа, второе — <img src="https://latex.codecogs.com/gif.latex?n_2"/> элементов второго типа и т. д., а последнее — <img src="https://latex.codecogs.com/gif.latex?n_k"/> элементов <img src="https://latex.codecogs.com/gif.latex?k"/> -того типа, причем <img src="https://latex.codecogs.com/gif.latex?n_1%20+%20n_2%20+%20&#x5C;cdots%20+%20n_k%20=%20n"/>. Каждое такое разбиение образует соединение из <img src="https://latex.codecogs.com/gif.latex?n"/> элементов, которое называют **перестановкой с повторениями**. Число всех перестановок с повторениями называется **полиноминальным коэффициентом**, обозначается <img src="https://latex.codecogs.com/gif.latex?P_n(n_1,%20n_2,%20&#x5C;cdots%20,%20n_k)"/> и вычисляется по следующей формуле:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_n(n_1,%20n_2,%20&#x5C;cdots%20,%20n_k)=&#x5C;frac{n!}{n_1!&#x5C;cdot%20n_2!&#x5C;cdot...&#x5C;cdot%20n_k!}"/></p>  
  
  
Действительно, в соответствии со схемой разбиения множества на упорядоченную конечную систему подмножеств и, используя правило умножения, получим, что число таких соединений длиной <img src="https://latex.codecogs.com/gif.latex?n"/> находится с помощью следующих преобразований:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_n(n_1,%20n_2,%20&#x5C;cdots,%20n_k)=C_n^{n_1}&#x5C;cdot%20C_{n-n_1}^{n_2}&#x5C;cdot%20C_{n-n_1-n_2}^{n_3}&#x5C;cdot...&#x5C;cdot%20C_{n_k}^{n_k}&#x5C;&#x5C;=&#x5C;frac{n!}{n_1!(n-n_1)!}&#x5C;cdot&#x5C;frac{(n-1)!}{n_2!(n-n_1-n_2)!}&#x5C;cdot...&#x5C;cdot&#x5C;frac{n_k!}{0!&#x5C;cdot%20n_k!}=&#x5C;frac{n!}{n_1!&#x5C;cdot%20n_2&#x5C;cdot...&#x5C;cdot%20n_k!}"/></p>  
  
  
###  Геометрическая схема вычисления вероятности
  
  
Формула классической вероятности следующим образом обобщается на случай непрерывных пространств элементарных исходов. Рассмотрим в качестве <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma"/> -алгебры <img src="https://latex.codecogs.com/gif.latex?S"/> систему измеримых подмножеств пространства <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/>  . Пусть условия опыта таковы, что вероятность попадания в произвольное измеримое подмножество пропорциональна мере этого подмножества и не зависит от его местоположения в пространстве <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/>  . Данный опыт можно интерпретировать как бросание случайной точки на пространство <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/>. При этих условиях вероятность появления любого события <img src="https://latex.codecogs.com/gif.latex?A"/> из <img src="https://latex.codecogs.com/gif.latex?S"/> вычисляется по так называемой **формуле геометрической вероятности**:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P(A)=&#x5C;frac{&#x5C;mu(A)}{&#x5C;mu(&#x5C;Omega)}"/></p>  
  
  
где буквой <img src="https://latex.codecogs.com/gif.latex?&#x5C;mu"/> обозначена мера множества (длина, площадь или объем ).
  
Геометрическая вероятность события <img src="https://latex.codecogs.com/gif.latex?A"/> из <img src="https://latex.codecogs.com/gif.latex?S"/> удовлетворяет всем аксиомам теории вероятностей, что позволяет применять к ней утверждения и теоремы, доказанные в рамках аксиоматики Колмогорова.
  
###  Условная вероятность
  
  
Пусть <img src="https://latex.codecogs.com/gif.latex?A"/> и <img src="https://latex.codecogs.com/gif.latex?B"/> - два события, рассматриваемые в данном оппыте. Наступление одоного события (скажем, <img src="https://latex.codecogs.com/gif.latex?A"/>) может влиять на вощможность наступления другого (<img src="https://latex.codecogs.com/gif.latex?B"/>). Для характеристики зависимости одних событий от других вводится понятие условной вероятность.
  
**Условной вероятностью события** <img src="https://latex.codecogs.com/gif.latex?B"/> при условии реализации события <img src="https://latex.codecogs.com/gif.latex?A"/> называется отношение вероятности произведения событий <img src="https://latex.codecogs.com/gif.latex?A"/> и <img src="https://latex.codecogs.com/gif.latex?B"/> к вероятности события <img src="https://latex.codecogs.com/gif.latex?A"/>, т.е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_A(B)=&#x5C;frac{P(AB)}{P(A)},%20P(A)&#x5C;ne0"/></p>  
  
  
Другие обозначение: 
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P(B&#x5C;lvert%20A)=&#x5C;frac{P(A&#x5C;cdot%20B)}{P(A)}"/></p>  
  
  
Вероятность <img src="https://latex.codecogs.com/gif.latex?P(B)"/>, в отличие от условной, называется безусловной вероятность.
  
###  Вероятность произведения двух событий
  
  
Вероятность произведения двух событий равна произведению безусловной вероятности одного из них на условную вероятность другого, при условии, что первое событие произошло:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P(AB)=P(A)&#x5C;cdot%20P_A(B)=P(B)&#x5C;cdot%20P_B(A);P(A)&gt;0,%20P(B)&gt;0"/></p>  
  
  
**Доказательство**. Данные формулы непосредственно следуют из определения условной вероятности.
  
Применяя правило умножения индуктивно получают **формулу умножения вероятностей для системы событий** в следующем виде:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P(A_1A_2&#x5C;cdots%20A_n)=P(A_1)&#x5C;cdot%20P_{A_1}(A_2)&#x5C;cdot%20P_{A_1A_2}(A_3)&#x5C;cdots%20P_{A_1A_2&#x5C;cdots%20A_n-1}(A_n)"/></p>  
  
  
###  Независимость событий
  
  
События <img src="https://latex.codecogs.com/gif.latex?A"/> и <img src="https://latex.codecogs.com/gif.latex?B"/> называются независимыми, если вероятность произведения данных событий равна произведению их вероятностей:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P(AB)=A(A)&#x5C;cdot%20P(B)"/></p>  
  
  
Для двух независимых событий условная вероятность каждого из событий равна безусловной вероятности, что вытекает из следующих соотношений:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_A(B)=&#x5C;frac{P(AB)}{P(A)}=&#x5C;frac{P(A)&#x5C;cdot%20P(B)}{P(A)}=P(B),P(A)&#x5C;ne0"/></p>  
  
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_B(A)=&#x5C;frac{P(AB)}{P(B)}=&#x5C;frac{P(A)&#x5C;cdot%20P(B)}{P(B)}=P(A),P(B)&#x5C;ne0"/></p>  
  
  
Таким образом, для независимых событий появление одного из событий никак не влияет на вероятность появления другого.
Иногда именно равенство <img src="https://latex.codecogs.com/gif.latex?PA(B)%20=%20P%20(B)"/> берут за исходное определение независимости события <img src="https://latex.codecogs.com/gif.latex?B"/> от события <img src="https://latex.codecogs.com/gif.latex?A"/> . Однако, мы будем использовать более симметричное определение независимости, рассмотренное А.Н. Колмогоровым.
  
**Пример**. Проводится опыт, состоящий в двукратном подбрасывании симметричной монеты. В этом случае пространство элементарных событий состоит из четырех исходов: <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega%20%20=%20&#x5C;{%20ГГ,%20ГР,%20РГ,%20РР%20&#x5C;}"/>. Рассмотрим событие <img src="https://latex.codecogs.com/gif.latex?A%20=%20&#x5C;{%20ГГ,%20ГР%20&#x5C;}"/> «выпадение «герба» при первом подбрасывании монеты» и событие <img src="https://latex.codecogs.com/gif.latex?B%20=%20{%20ГГ,%20РГ%20}"/> — «выпадение «герба» при втором подбрасывании». Тогда произведение событий <img src="https://latex.codecogs.com/gif.latex?AB%20=%20&#x5C;{%20ГГ%20&#x5C;}"/> — выпадение герба при первом и втором подбрасывании монеты. По классической схеме вычисления вероятностей <img src="https://latex.codecogs.com/gif.latex?P(A)=P(B)=1&#x2F;2,%20P(AB)=1&#x2F;4"/>. События <img src="https://latex.codecogs.com/gif.latex?A"/> и <img src="https://latex.codecogs.com/gif.latex?B"/> независимы, поскольку выполняется условие <img src="https://latex.codecogs.com/gif.latex?P%20(AB)%20=%20P%20(A)%20&#x5C;cdot%20P%20(B)"/>.
  
**Для двух независимых событий формула вероятности произведения событий имеет вид**:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P(AB)=P(A)&#x5C;cdot%20P(B)"/></p>  
  
  
###  Независимость системы событий
  
  
Система из n событий называется независимой, если для любой ее подсистемы из <img src="https://latex.codecogs.com/gif.latex?k%20&#x5C;le%20n"/> событий справедливы следующие формулы :
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P(A_1A_2&#x5C;cdots%20A_k)=P(A_1)&#x5C;cdot%20P(A_2)&#x5C;cdot%20...&#x5C;cdot%20P(A_k)"/></p>  
  
  
Из независимости системы событий непосредственно из опре- деления следует попарная независимость событий. Обратное утверждение неверно
  
Для системы из n независимых событий формула вероятности произведения событий выводится по индукции и имеет вид:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P(A_1A_2&#x5C;cdots%20A_n)=P(A_1)&#x5C;cdot%20P(A_2)&#x5C;cdot%20...&#x5C;cdot%20P(A_n)"/></p>  
  
  
###  Формула полной вероятности
  
  
Одним из следствий совместного применения теорем сложения и умножения вероятностей являются формулы полной вероятности и Байеса. Напомним, что события <img src="https://latex.codecogs.com/gif.latex?A_1,%20A_2,%20...,%20A_n"/> образуют полную группу, если <img src="https://latex.codecogs.com/gif.latex?A_i&#x5C;cdot%20A_j=&#x5C;varnothing,%20i&#x5C;ne%20j,%20&#x5C;sum_{i=1}^nA_i=&#x5C;Omega"/>. Систему таких событий называют также разбиением.
  
**Теорема**. Пусть события <img src="https://latex.codecogs.com/gif.latex?H_1,%20H_2,%20...,%20H_n"/>. образуют полную группу. Тогда для любого, наблюдаемого в опыте, события А имеет место формула полной вероятности.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P(A)=&#x5C;sum_{i=1}^nP(H_i)&#x5C;cdot%20P(A&#x5C;lvert%20H_i)"/></p>  
  
  
###  Формула полной вероятности
  
  
**Доказательство**:
Так как <img src="https://latex.codecogs.com/gif.latex?H_1+H_2+...%20+H_n%20=%20&#x5C;Omega"/>, то в силу свойств операций над событиями 
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?A%20=%20A%20&#x5C;cdot%20&#x5C;Omega%20=%20A%20&#x5C;cdot%20(H_1%20+%20H_2%20+%20...%20+%20H_n)%20=A%20&#x5C;cdot%20H_1%20+%20A%20&#x5C;cdot%20H_2%20+%20...%20+%20A&#x5C;cdot%20H_n"/></p>  
  
  
Из того, что <img src="https://latex.codecogs.com/gif.latex?H_i&#x5C;cdot%20H_j=&#x5C;varnothing"/>, следует, что <img src="https://latex.codecogs.com/gif.latex?(A&#x5C;cdot%20H_i)&#x5C;cdot(A&#x5C;cdot%20H_j)=&#x5C;varnothing,%20i&#x5C;ne%20j"/> т. е. события <img src="https://latex.codecogs.com/gif.latex?A&#x5C;cdot%20H_i"/> и <img src="https://latex.codecogs.com/gif.latex?A&#x5C;cdot%20H_j"/> также несовместны. Тогда по тео]>еме сложения вероятностей <img src="https://latex.codecogs.com/gif.latex?P(A)%20=%20P(A&#x5C;cdot%20H_1)%20+%20P(A%20&#x5C;cdot%20Н_2)%20+%20...%20+%20P(A&#x5C;cdot%20H_n)"/> т.е. <img src="https://latex.codecogs.com/gif.latex?P(A)%20=%20&#x5C;sum_{i=1}^n%20P(A&#x5C;cdot%20H_i)"/>. По теореме умножения вероятностей <img src="https://latex.codecogs.com/gif.latex?P(A%20&#x5C;cdot%20H_i)=P(H_i)&#x5C;cdot%20P(A&#x5C;lvert%20H_i)"/>, откуда и следует формула полной вероятности.
  
В формуле полной вероятности события <img src="https://latex.codecogs.com/gif.latex?H_1,%20H_2,%20...,%20H_n"/> обычно называют гипотезами} они исчерпывают все возможные предположения (гипотезы) относительно исходов как бы первого этапа опыта, событие <img src="https://latex.codecogs.com/gif.latex?A"/> — один из возможных исходов второго этапа.
  
###  Формула Байеса
  
  
Следствием формулы полной вероятности является формула Байеса или теорема гипотез. Она позволяет переоценить вероятности гипотез <img src="https://latex.codecogs.com/gif.latex?H_i"/>, принятых до опыта и называемых априорными («а priori», доопытные, лат.) по результатам уже проведенного опыта, т. е. найти условные вероятности <img src="https://latex.codecogs.com/gif.latex?P(H_i&#x5C;lvert%20A)"/>, которые называют апостериорными («а posteriori», послеопытные).
  
**Теорема**. Пусть события <img src="https://latex.codecogs.com/gif.latex?H_1,%20H_2,%20...,%20H_n"/> образуют полную группу событий. Тогда условная вероятность события <img src="https://latex.codecogs.com/gif.latex?H_k(k%20=%201,n)"/> при условии, что событие <img src="https://latex.codecogs.com/gif.latex?A"/> произошло, задается формулой
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P(H_k&#x5C;lvert%20A)=&#x5C;frac{P(H_k)&#x5C;cdot%20P(A&#x5C;lvert%20H_k)}{P(A)}"/></p>  
  
  
где <img src="https://latex.codecogs.com/gif.latex?P(A)%20=%20P(H_1)&#x5C;cdot%20P(A&#x5C;lvert%20H_1)+%20...%20+%20P(H_n)&#x5C;cdot%20P(A&#x5C;lvert%20H_n)"/> — формула полной вероятности
  
**Доказательство**:
Применив формулы условной вероятности и умножения вероятностей, имеем
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P(H_k&#x5C;lvert%20A)=&#x5C;frac{P(H_k&#x5C;cdot%20A)}{P(A)}=&#x5C;frac{P(H_k)&#x5C;cdot%20P(A&#x5C;lvert%20H_k)}{P(A)}"/></p>  
  
  
где <img src="https://latex.codecogs.com/gif.latex?P(A)"/> — формула полной вероятности
  
##  Лекция 2 СЛУЧАЙНЫЕ ВЕЛИЧИНЫ
  
  
###  Независимые испытания. Схема Бернулли.
  
  
С понятием «независимых событий» связано понятие «независи­
мых испытаний (опытов)».
  
Несколько опытов называются независимыми, если их исходы
представляют собой независимые события (независимые в совокупно­
сти).
  
Последовательность <img src="https://latex.codecogs.com/gif.latex?n"/> независимых испытаний, в каждом из кото­рых может произойти некоторое событие <img src="https://latex.codecogs.com/gif.latex?A"/> (его называют **успехом**) с вероятностью <img src="https://latex.codecogs.com/gif.latex?P(A)%20=%20p"/> или противоположное ему событие <img src="https://latex.codecogs.com/gif.latex?A"/> (его на­ зывают неудачей) с вероятностью <img src="https://latex.codecogs.com/gif.latex?P(&#x5C;overline{A})%20=%20q%20=%201%20-%20p)"/>, называется **схемой Бернулли**.
  
Например, при стрельбе по мишени: событие <img src="https://latex.codecogs.com/gif.latex?A"/> попадание
(успех), событие <img src="https://latex.codecogs.com/gif.latex?&#x5C;overline{A}"/> — промах (неудача); при обследовании п изделий на предмет годности: событие <img src="https://latex.codecogs.com/gif.latex?A"/> — деталь годная (успех), событие <img src="https://latex.codecogs.com/gif.latex?A"/> деталь бракованная (неудача) и т. д.
  
В каждом таком опыте ПЭС состоит только из двух элементар­ ных событий, т. е. <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega%20=%20{&#x5C;omega_0,&#x5C;omega_1}"/>, где <img src="https://latex.codecogs.com/gif.latex?&#x5C;omega_0"/> — неудача, <img src="https://latex.codecogs.com/gif.latex?&#x5C;omega_1"/> успех, при этом <img src="https://latex.codecogs.com/gif.latex?A%20=%20{&#x5C;omega_1},%20&#x5C;overline{A}%20—%20{&#x5C;omega_0}"/>. Вероятности этих событий обозначают че­ рез р и q соответственно (<img src="https://latex.codecogs.com/gif.latex?p%20+%20q%20=%201"/>). Множество элементарных исхо­ дов для п опытов состоит из <img src="https://latex.codecogs.com/gif.latex?2^n"/> элементов. Например, прп <img src="https://latex.codecogs.com/gif.latex?n%20=%203"/>, т. е. опыт повторяется 3 раза, <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega=&#x5C;big&#x5C;{&#x5C;frac{&#x5C;overline{A},&#x5C;overline{A},&#x5C;overline{A}}{&#x5C;omega_0};&#x5C;frac{A,A,&#x5C;overline{A}}{&#x5C;omega_1};&#x5C;frac{&#x5C;overline{A},A,&#x5C;overline{A}}{&#x5C;omega_2};&#x5C;frac{&#x5C;overline{A},A,A}{&#x5C;omega_3};&#x5C;frac{A,&#x5C;overline{A},&#x5C;overline{A}}{&#x5C;omega_4};&#x5C;frac{A,&#x5C;overline{A},A}{&#x5C;omega_5};&#x5C;frac{&#x5C;overline{A},&#x5C;overline{A},A}{&#x5C;omega_6};&#x5C;frac{A,A,A}{&#x5C;omega_7}"/>. Вероятность каждого элемен­тарного события определяется однозначно. По теореме умножения ве­роятность события, скажем <img src="https://latex.codecogs.com/gif.latex?&#x5C;omega_6=(&#x5C;overline{A},&#x5C;overline{A},A)"/>, равна <img src="https://latex.codecogs.com/gif.latex?q&#x5C;cdot%20q&#x5C;cdot%20p=pq^2"/>, события <img src="https://latex.codecogs.com/gif.latex?&#x5C;omega_7%20-%20p&#x5C;cdot%20p&#x5C;cdot%20p=p^3q^0"/> и т. д.
  
Часто успеху сопоставляют число 1, неудаче — число 0. Элемен­ тарным событием для п опытов будет последовательность из п нулей и единиц. Тройка чисел <img src="https://latex.codecogs.com/gif.latex?(0,0,0)"/> означает, что во всех трех опытах со­бытие А не наступило; тройка чисел <img src="https://latex.codecogs.com/gif.latex?(0,1,0)"/> означает, что событие <img src="https://latex.codecogs.com/gif.latex?A"/> наступило во 2-м опыте, а в 1-м и 3-м — не наступило.
  
###  Формула Бернулли.
  
  
Простейшая задача, относящаяся к схеме Бернулли, состоит в
определении вероятности того, что в п независимых испытаниях собы­тие <img src="https://latex.codecogs.com/gif.latex?A"/> наступит <img src="https://latex.codecogs.com/gif.latex?m"/> раз (<img src="https://latex.codecogs.com/gif.latex?0&#x5C;le%20m&#x5C;le%20n"/>). Обозначается искомая вероятность так: <img src="https://latex.codecogs.com/gif.latex?P_n(m)"/> или <img src="https://latex.codecogs.com/gif.latex?P_{n,m}"/> или <img src="https://latex.codecogs.com/gif.latex?P(&#x5C;mu_n=m)"/>, где <img src="https://latex.codecogs.com/gif.latex?&#x5C;mu_n"/> — число появления события <img src="https://latex.codecogs.com/gif.latex?A"/> в серии из <img src="https://latex.codecogs.com/gif.latex?n"/> опытов.
  
Например, при бросании игральной кости 3 раза <img src="https://latex.codecogs.com/gif.latex?P_3(2)"/> означает вероятность того, что в 3-х опытах событие <img src="https://latex.codecogs.com/gif.latex?А"/> — выпадение цифры
4 произойдет 2 раза. Очевидно,
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_3(2)=p^2q+p^2q+p^2q=&#x5C;Big[&#x5C;{(A,A,&#x5C;overline{A});(A,&#x5C;overline{A},A);(&#x5C;overline{A},A,A)&#x5C;}&#x5C;Big]=3p^2q=3&#x5C;cdot(&#x5C;frac{1}{6})^2&#x5C;cdot&#x5C;frac{5}{6}=&#x5C;frac{5}{72}=0.069"/></p>  
  
  
**Теорема** Если производится <img src="https://latex.codecogs.com/gif.latex?n"/> независимых испытаний, в каждом из которых вероятность появления события <img src="https://latex.codecogs.com/gif.latex?A"/> равна <img src="https://latex.codecogs.com/gif.latex?p"/>, а вероятность его непоявления равна <img src="https://latex.codecogs.com/gif.latex?q%20=%201%20—%20p"/>, то вероятность того, что событие <img src="https://latex.codecogs.com/gif.latex?A"/> произойдет т раз определяется **формулой Бернулли**
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_n(m)=C_n^m&#x5C;cdot%20p^m&#x5C;cdot%20q^{n-m},%20m=0,1,2,&#x5C;cdots,n"/></p>  
  
  
**Доказательство:**
Вероятность одного сложного события, состоящего в том, что со­бытие <img src="https://latex.codecogs.com/gif.latex?A"/> в <img src="https://latex.codecogs.com/gif.latex?n"/> независимых опытах появится т раз в первых т опы­тах и не появится <img src="https://latex.codecogs.com/gif.latex?(n-m)"/> раз в остальных опытах (это событие <img src="https://latex.codecogs.com/gif.latex?&#x5C;underbrace{A&#x5C;cdot%20A&#x5C;cdot%20A&#x5C;cdot%20A&#x5C;cdot%20...%20&#x5C;cdot%20A}_{m&#x5C;%20раз}&#x5C;cdot&#x5C;underbrace{&#x5C;overline{A}&#x5C;cdot%20&#x5C;overline{A}&#x5C;cdot%20&#x5C;overline{A}&#x5C;cdot%20&#x5C;overline{A}&#x5C;cdot%20...%20&#x5C;cdot%20&#x5C;overline{A}}_{(n-m)&#x5C;%20раз}"/> по теореме умножения вероятностей равна <img src="https://latex.codecogs.com/gif.latex?p^mq^{n-m}"/>. Вероятность появления события А снова т раз, но в другом порядке (например, <img src="https://latex.codecogs.com/gif.latex?&#x5C;overline{A}&#x5C;cdot&#x5C;underbrace{A&#x5C;cdot%20A&#x5C;cdot%20...&#x5C;cdot%20A}_{m&#x5C;%20раз}&#x5C;overline{A}&#x5C;cdot&#x5C;overline{A}&#x5C;cdot%20...&#x5C;cdot&#x5C;overline{A}"/> или <img src="https://latex.codecogs.com/gif.latex?A&#x5C;overline{A}A&#x5C;overline{A}&#x5C;cdot...&#x5C;cdot%20A&#x5C;overline{A}"/> и т. д.) будет той же самой, т. е. <img src="https://latex.codecogs.com/gif.latex?p^mq^{n-m}"/> 
  
Число таких сложных событий — в <img src="https://latex.codecogs.com/gif.latex?n"/> опытах т раз встречается со­ бытие А в различном порядке — равно числу сочетаний из п по т. е. <img src="https://latex.codecogs.com/gif.latex?C_n^m"/>. Так как все эти сложные события несовместны, то по теореме сло­ жения вероятностей искомая вероятностъ равна сумме вероятностей всех возможных сложных событий, т. е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_n(m)=&#x5C;underbrace{p^mq^{n-m}+&#x5C;cdots+p^mq^{n-m}}_{C_n^m%20слагаеиых}=C_n^mp^mq^{n-m}&#x5C;quad%20m=0,1,&#x5C;cdots,n"/></p>  
  
  
Можно заметить, что вероятности <img src="https://latex.codecogs.com/gif.latex?P_n(m),%20m=0,1,&#x5C;cdots,%20n"/> являются коэффициентами при хт в разложении <img src="https://latex.codecogs.com/gif.latex?(q+px)^n"/> по формуле бинома Ньютона:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?(q+px)^n=q^n+C^1_nq^{n-1}px+C_n^2q^{n-2}p^2x^2+&#x5C;cdots+C_n^mq^{n-m}p^mx^m+&#x5C;cdots+p^nx^n"/></p>  
  
  
Поэтому совокупность вероятностей <img src="https://latex.codecogs.com/gif.latex?P_n(m)"/> называют **биномиальным законом распределения вероятностен** (см. п. 2.7), а функцию <img src="https://latex.codecogs.com/gif.latex?&#x5C;varphi(x)=(q+px)^n"/> — **производящей функцией** для последовательности неза­висимых опытов.
  
###  Полиномиальное распределение
  
  
Если в каждом из независимых испытаний вероятности наступле­ ния события <img src="https://latex.codecogs.com/gif.latex?A"/> **разные**, то вероятность того, что событие <img src="https://latex.codecogs.com/gif.latex?A"/> наступит <img src="https://latex.codecogs.com/gif.latex?m"/> раз в <img src="https://latex.codecogs.com/gif.latex?n"/> опытах, равна коэффициенту при <img src="https://latex.codecogs.com/gif.latex?m"/>-й степени многочлена <img src="https://latex.codecogs.com/gif.latex?&#x5C;varphi_n(z)=(q_1+p_1z)(q_2+p^2z)&#x5C;cdot...&#x5C;cdot(q_n+p^nz)"/>, где <img src="https://latex.codecogs.com/gif.latex?&#x5C;varphi_n(z)"/> — производящая функция.
  
Если в серии из <img src="https://latex.codecogs.com/gif.latex?n"/> независимых опытов, в каждом из которых может произойти одно и только одно из <img src="https://latex.codecogs.com/gif.latex?k"/> событий <img src="https://latex.codecogs.com/gif.latex?A_1,A-2,&#x5C;cdots%20A_k"/> соответ­ствующими вероятностями <img src="https://latex.codecogs.com/gif.latex?p_1,p_2,&#x5C;cdots%20p_k"/> то вероятность того, что в этих опытах событие <img src="https://latex.codecogs.com/gif.latex?A_1"/> появится <img src="https://latex.codecogs.com/gif.latex?M_1"/> раз, событие <img src="https://latex.codecogs.com/gif.latex?A_2%20-%20m_2"/> раз, <img src="https://latex.codecogs.com/gif.latex?..."/> событие <img src="https://latex.codecogs.com/gif.latex?A_k%20-%20m_k"/> раз, равна
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_n(m_1,m_2,&#x5C;cdots%20m_k)=&#x5C;frac{n!}{m_1!m_2!&#x5C;cdots%20m_k!}p_1^{m_1}p_2^P{m_2}&#x5C;cdots%20p_k^{m_k}"/></p>  
  
  
где <img src="https://latex.codecogs.com/gif.latex?m_1+m_2+&#x5C;cdots+m_k=n"/>. Вероятности (1.33) называются полиноми­ альным распределением.
  
###  Теорема Пуассона
  
  
**Теорема** Если число испытаний неограничено увеличивается
<img src="https://latex.codecogs.com/gif.latex?(n&#x5C;to%20&#x5C;infty)"/> и вертятность <img src="https://latex.codecogs.com/gif.latex?p"/> наступления события <img src="https://latex.codecogs.com/gif.latex?A"/> в каждом испытании неограничено уменьшается <img src="https://latex.codecogs.com/gif.latex?(p%20&#x5C;to%200)"/>, но так, что их произведение <img src="https://latex.codecogs.com/gif.latex?np"/> является постоянной величиной (<img src="https://latex.codecogs.com/gif.latex?np%20=%20a%20=%20const"/>), то вероятность <img src="https://latex.codecogs.com/gif.latex?P_n(m)"/> удовлетворяет предельному равенству
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;lim_{n&#x5C;to&#x5C;infty}P_n(m)=&#x5C;frac{a^m%20e^{-a}}{m!}"/></p>  
  
  
Это выражение называется ассимптотической формулой Пуассона.
  
**Доказательство**:
  
Преобразуем формулу Бернулли с учетом того, что <img src="https://latex.codecogs.com/gif.latex?p=&#x5C;frac{a}{n}"/>:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;begin{split}%20%20%20%20P_n(m)=&#x5C;frac{n!}{m!(n-m)!}&#x5C;cdot(&#x5C;frac{a}{n})^m&#x5C;cdot(1-&#x5C;frac{a}{n}^{n-m})=&#x5C;&#x5C;%20%20%20%20&#x5C;frac{n(n-1)(n-2)&#x5C;cdots(n-(m-1))}{m!}&#x5C;cdot&#x5C;frac{a^m}{n^m}&#x5C;cdot(1-&#x5C;frac{a}{n})^n&#x5C;cdot(1-&#x5C;frac{a}{n})^{-m}&#x5C;&#x5C;%20%20%20%20=&#x5C;frac{a^m}{m!}&#x5C;cdot&#x5C;frac{n}{n}&#x5C;cdot&#x5C;frac{n-1}{n}&#x5C;cdot&#x5C;frac{n-2}{n}&#x5C;cdot...&#x5C;cdot&#x5C;frac{n-(m-1)}{n}&#x5C;cdot(1-&#x5C;frac{a}{n})^n&#x5C;cdot(1-&#x5C;frac{a}{n})^{-m}&#x5C;&#x5C;%20%20%20%20=&#x5C;frac{a^m}{m!}&#x5C;cdot1&#x5C;cdot(1-&#x5C;frac{1}{n})&#x5C;cdot(1-&#x5C;frac{2}{n})&#x5C;cdot...&#x5C;cdot(1-&#x5C;frac{m-1}{n})&#x5C;cdot(1-&#x5C;frac{a}{n})^n&#x5C;cdot(1-&#x5C;frac{a}{n})^{-m}&#x5C;&#x5C;&#x5C;end{split}"/></p>  
  
  
Переходя к пределу при <img src="https://latex.codecogs.com/gif.latex?n&#x5C;to%20&#x5C;infty"/>, получим <img src="https://latex.codecogs.com/gif.latex?&#x5C;lim_{n&#x5C;to&#x5C;infty}P_n(m)=&#x5C;frac{a^me^{-a}}{m!}"/> (<img src="https://latex.codecogs.com/gif.latex?&#x5C;lim_{n&#x5C;to&#x5C;infty}(1-&#x5C;frac{a}{n})^n=e^{-a}"/> согласно второму замечательному пределу)
  
Из предельного равенства теоремы Пуассона при больших <img src="https://latex.codecogs.com/gif.latex?n"/> и малых <img src="https://latex.codecogs.com/gif.latex?p"/> вытекает приближенная формула Пуассона:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_n(m)&#x5C;approx&#x5C;frac{a^me^{-a}}{m!},%20a=np,%20m=0,1,2&#x5C;cdots"/></p>  
  
  
Формула применяется, когда вероятность успеха крайне мала, т. е. сам по себе успех является редким событием. Её обычно используют, когда <img src="https://latex.codecogs.com/gif.latex?n&#x5C;ge%2050"/> а <img src="https://latex.codecogs.com/gif.latex?np%20&#x5C;le%2010"/>
  
Формула Пуассона находит применение **в теории массового обслуживания**.
  
###  Математическая модель простейшего потока событий
  
  
Формулу Пуассона можно считать математической моделью про­стейшего потока событий.
  
**Потоком событий** называют последовательность событий, насту­ пающих в случайные моменты времени (например, поток посетителей в парикмахерской, поток вызовов на телефонной станции, поток отказов элементов, поток обслуженных абонентов и т.п.).
  
Поток событий, обладающий свойствами стационарности, ординар­ ности и отсутствия последствия называется **простейшим (пуассоновским) потоком**.
  
Свойство **стационарности** означает, что вероятность появления к событий на участке времени длины <img src="https://latex.codecogs.com/gif.latex?&#x5C;tau"/> зависит только от его длины (т. е. не зависит от начала его отсчета). Следовательно, **среднее число событий, появляющихся в единицу времени,** так называемая **интен­ сивность** <img src="https://latex.codecogs.com/gif.latex?&#x5C;lambda"/> потока, есть величина постоянная: <img src="https://latex.codecogs.com/gif.latex?&#x5C;lambda(t)=&#x5C;lambda"/>.
  
Свойство ординарности означает, что событие появляется не груп­ пами, а поодиночке. Другими словами, вероятность появления более одного события на малый участок времени <img src="https://latex.codecogs.com/gif.latex?&#x5C;Delta%20t"/> пренебрежительно мала по сравнению с вероятностью появления только одного события (на­пример, поток катеров, подходящих к причалу, ординарен).
  
Свойство **отсутствия последствия** означает, что вероятность по­ явления <img src="https://latex.codecogs.com/gif.latex?k"/> событий на любом участке времени длины <img src="https://latex.codecogs.com/gif.latex?&#x5C;tau"/> не зависит от того, сколько событий появилось на любом другом не пересекающимся с ним участком (говорят: «будущее» потока не зависит от «прошлого», например, поток людей, входящих в супермаркет).
  
Можно доказать, что вероятность появления <img src="https://latex.codecogs.com/gif.latex?m"/> событий простей­
шего потока за время продолжительностью <img src="https://latex.codecogs.com/gif.latex?t"/> определяется формулой Пуассона
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_t(m)=p_m=&#x5C;frac{(&#x5C;lambda%20t)^m&#x5C;cdot%20e^{-&#x5C;lambda%20t}}{m!}"/></p>  
  
  
В тех случаях, когда число испытаний <img src="https://latex.codecogs.com/gif.latex?n"/> велико, а вероятность <img src="https://latex.codecogs.com/gif.latex?p"/> не близка к нулю (<img src="https://latex.codecogs.com/gif.latex?p&#x5C;ne%200%20p&#x5C;ne%201"/>), для вычисления биномиальных вероятностей используют теоремы Муавра-Лапласа. Приведем только их формулировки в силу сложности доказательства.
  
###  Локальная теорема Муавра-Лапласа
  
  
**Теорема Локальная теорема Муавра-Лапласа** Если вероят- ность р наступления события <img src="https://latex.codecogs.com/gif.latex?A"/> в каждом испытании постоянна и отлична от нуля и единицы, а число независимых испытаний достаточно велико, то вероятность <img src="https://latex.codecogs.com/gif.latex?P_n(m)"/> может быть вычислена по приближенной формуле
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_n(m)&#x5C;approx&#x5C;frac{1}{&#x5C;sqrt{npq}}&#x5C;cdot&#x5C;frac{1}{&#x5C;sqrt{2&#x5C;pi}}e^{-&#x5C;frac{x^2}{2}}"/></p>  
  
  
где <img src="https://latex.codecogs.com/gif.latex?x=&#x5C;frac{m-np}{&#x5C;sqrt{npq}}"/>
  
Равенство тем точнее, чем больше <img src="https://latex.codecogs.com/gif.latex?n"/>.
  
###  Функция Гаусса
  
  
Выражение
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;frac{1}{&#x5C;sqrt{2&#x5C;pi}}e^{-&#x5C;frac{x^2}{2}}=&#x5C;varphi(x)"/></p>  
  
  
называется **функцией Гаусса**, а ее график — **кривой вероятностей**
  
![](pic/Lec2-1.png )
  
###  Интегральная теорема Муавра-Лаплоса
  
  
В тех случаях, когда требуется вычислить вероятность того, что
в п независимых испытаниях событие <img src="https://latex.codecogs.com/gif.latex?A"/> появится не менее <img src="https://latex.codecogs.com/gif.latex?k_1"/> раз, но не более <img src="https://latex.codecogs.com/gif.latex?k_2"/> раз, т. е. <img src="https://latex.codecogs.com/gif.latex?P_n(k_1&#x5C;le%20m&#x5C;le%20k_2)"/> или <img src="https://latex.codecogs.com/gif.latex?P_n(k_1;k_2)"/>, используют инте­ гральную теорему Муавра—Лапласа (является частным случаем более общей теоремы — центральной предельной теоремы).
  
**Теорема (Интегральная теорема Муавра-Лапласа)** Если ве­
роятность р наступления события А в каждом испытании постоянна и
отлична от нуля и единицы, то вероятность <img src="https://latex.codecogs.com/gif.latex?P_n(k_1&#x5C;le%20m&#x5C;le%20k_2)"/> может быть найдена по приближенной формуле
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_n(k_1&#x5C;le%20m&#x5C;le%20k_2)&#x5C;approx&#x5C;frac{1}{&#x5C;sqrt{2&#x5C;pi}}&#x5C;int_{x_1}^{x_2}e^{-&#x5C;frac{x^2}{2}}{%20&#x5C;rm%20d}%20x"/></p>  
  
  
где 
- <img src="https://latex.codecogs.com/gif.latex?x_1=&#x5C;frac{k_1-np}{&#x5C;sqrt{npq}}"/>
- <img src="https://latex.codecogs.com/gif.latex?x_2=&#x5C;frac{k_2-np}{&#x5C;sqrt{npq}}"/>
  
Равенство тем точнее, чем больше <img src="https://latex.codecogs.com/gif.latex?n"/>.
  
###  Нормированная функция Лапласа
  
  
для упрощения вычислений, вводят специальную функцию
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;Phi_0(x)=&#x5C;frac{1}{2&#x5C;pi}&#x5C;int_0^xe^{-&#x5C;frac{t^2}{2}}{%20&#x5C;rm%20d}t"/></p>  
  
  
называемую нормированной **функцией Лапласа**.
  
![](pic/Lec2-2.png )
  
###  Функция Лапласа
  
  
Наряду с нормированной функцией Лапласа используют функцию
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;Phi(x)=&#x5C;frac{1}{&#x5C;sqrt{2&#x5C;pi}}&#x5C;int_{-&#x5C;infty}^xe^{-&#x5C;frac{t^2}{2}}{%20&#x5C;rm%20d}t"/></p>  
  
  
называемую также **функцией Лапласа**. Для нее справедливо равенство <img src="https://latex.codecogs.com/gif.latex?&#x5C;Phi(-x)+&#x5C;Phi(x)=1"/>; она связана с функцией <img src="https://latex.codecogs.com/gif.latex?&#x5C;Phi_0(x)"/> формулой
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;Phi(x)=0.5+&#x5C;Phi_0(x)"/></p>  
  
  
Приближенную формулу для вычисления вероятности <img src="https://latex.codecogs.com/gif.latex?P_n(k_1&#x5C;le%20m&#x5C;le%20k_2)"/> можно записать в виде 
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P_n(k_1&#x5C;le%20m&#x5C;le%20k_2)%20=%20&#x5C;Phi(x_2)-&#x5C;Phi(x_1)=&#x5C;Phi(x_2)-&#x5C;Phi(x_1)"/></p>  
  
  
Где
- <img src="https://latex.codecogs.com/gif.latex?x_1=&#x5C;frac{k_1-np}{&#x5C;sqrt{npq}}"/>
- <img src="https://latex.codecogs.com/gif.latex?x_2=&#x5C;frac{k_2-np}{&#x5C;sqrt{npq}}"/>
  
###  Случайная величина
  
  
Под **случайной величиной** понимаю! величину, которая в результатк опыта принимает то или иное значение, причем неизвестно заранее, какое именно.
  
Примерами с. в. могут служить: 
1) <img src="https://latex.codecogs.com/gif.latex?X"/> число очковч появляющихся при бросании игральной кости; 
2) <img src="https://latex.codecogs.com/gif.latex?Y"/> — число выстрелов до первого попадания в цель; 
3) <img src="https://latex.codecogs.com/gif.latex?Z"/> — время безотказной работы прибора и т.п.
  
(рост человека, курс доллара, количество бракованных деталей в пар­тии, температура воздуха, выигрыш игрока, координата точки при слу­чайном выборе ее на <img src="https://latex.codecogs.com/gif.latex?[0;%201]"/>, прибыль фирмы, ...).
  
Случайная величина, принимающая конечное или счетное множе­ ство значений, называется дискретной (сокращенно: д. с. в.).
  
Если же множество возможных значений с. в. несчетно, то такая величина называется непрерывной (сокращенно: н.с. в.).
  
###  Строгое определение
  
  
Случайной величиной <img src="https://latex.codecogs.com/gif.latex?X"/> называется числовая функция, опреде­ ленная на пространстве элементарных событий <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/>, которая каждому элементарному событию w ставит в соответствие число <img src="https://latex.codecogs.com/gif.latex?X(&#x5C;Omega)"/>, т.е. 
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?X=X(&#x5C;omega),%20&#x5C;omega&#x5C;in&#x5C;Omega%20(или&#x5C;%20X=f(&#x5C;omega))"/></p>  
  
  
**Пример**. Опыт состоит в бросании монеты 2 раза. На ПЭС <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega=&#x5C;{&#x5C;omega_1,&#x5C;omega_2,&#x5C;omega_3,&#x5C;omega_4&#x5C;}"/>, где <img src="https://latex.codecogs.com/gif.latex?&#x5C;omega_1=ГГ,%20&#x5C;omega_2=ГР,%20&#x5C;omega_3=РГ,%20&#x5C;omega_4=РР"/>, можно рассмотреть с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> — число появлений герба. С. в. <img src="https://latex.codecogs.com/gif.latex?X"/> является функ­ цией от элементарного события <img src="https://latex.codecogs.com/gif.latex?&#x5C;omega_i"/>: <img src="https://latex.codecogs.com/gif.latex?X(&#x5C;omega_1)=2,%20X(&#x5C;omega_2)=1,%20X(&#x5C;omega_3)=1,X(&#x5C;omega_4)=0"/>; <img src="https://latex.codecogs.com/gif.latex?X"/> - д. с. в. со значениями <img src="https://latex.codecogs.com/gif.latex?x_1=0,x_2=1,x_3=2"/>.
  
Отметим, что если множество 12 конечно или счетно, то случай­ ной величиной является любая функция, определенная на <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/>. В общем случае функция <img src="https://latex.codecogs.com/gif.latex?X%20(&#x5C;omega)"/> должна быть такова, чтобы для любых <img src="https://latex.codecogs.com/gif.latex?x&#x5C;in%20R"/> событие <img src="https://latex.codecogs.com/gif.latex?A=&#x5C;{&#x5C;omega:%20X(&#x5C;omega)%20&lt;%20x&#x5C;}"/> принадлежало <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma"/>-алгебре множеств <img src="https://latex.codecogs.com/gif.latex?S"/> и, значит, для любого такого события была определена вероятность <img src="https://latex.codecogs.com/gif.latex?P(A)=P(X&lt;x)"/>
  
Закон распределения случайной величины
  
Для полного описания с. в. недостаточно лишь знания ее возмож­ ных значений; необходимо еще знать вероятности этих значений.
  
Любое правило (таблица, функция, график), позволяющее нахо­ дить вероятности произвольных событий <img src="https://latex.codecogs.com/gif.latex?A&#x5C;subseteq%20S"/> (<img src="https://latex.codecogs.com/gif.latex?S"/> — <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma"/>-алгебра собы­тий пространства <img src="https://latex.codecogs.com/gif.latex?&#x5C;Omega"/>). в частности, указывающее вероятности отдель­ ных значений случайной величины или множества этих значений, на­зывается **законом распределения случайной величины** (или просто: **рас­пределением**). Про с. в. говорят, что «она подчиняется данному закону распределения»:
  
Пусть <img src="https://latex.codecogs.com/gif.latex?Х"/> — д.с.в., которая принимает значения <img src="https://latex.codecogs.com/gif.latex?x_1,x_2,x_3,&#x5C;cdots,x_n,&#x5C;cdots"/> (множество этих значений конечно или счетно) с некоторой вероят­ностью <img src="https://latex.codecogs.com/gif.latex?p_i"/> где <img src="https://latex.codecogs.com/gif.latex?i%20=%201,2,3,&#x5C;cdots,n,&#x5C;cdots"/> **Закон распределения** д. с. в. удобно задавать с помощью формулы <img src="https://latex.codecogs.com/gif.latex?p_i%20=%20P&#x5C;{X%20=%20x_i,&#x5C;},%20i%20=%201,2,3,...,n,.."/> определяющей вероятность того, что в результате опыта с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> примет значение <img src="https://latex.codecogs.com/gif.latex?x_i"/>. Для д. с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> закон распределения может быть задан в виде таблицы, распределения:
  
 Множ. |  - | - | - | - | -
---|---|---|---|---|---
<img src="https://latex.codecogs.com/gif.latex?X"/> | <img src="https://latex.codecogs.com/gif.latex?x_1"/> | <img src="https://latex.codecogs.com/gif.latex?x_2"/> | ... | <img src="https://latex.codecogs.com/gif.latex?x_n"/> | ...
<img src="https://latex.codecogs.com/gif.latex?P"/> | <img src="https://latex.codecogs.com/gif.latex?p_1"/> | <img src="https://latex.codecogs.com/gif.latex?p_2"/> | ... | <img src="https://latex.codecogs.com/gif.latex?p_n"/> | ...
  
где первая строка содержит все возможные значения (обычно в порядке возрастания) с. в., а вторая — их вероятности. Такую таблицу называ­ют **рядом распределения**.
  
Так как события <img src="https://latex.codecogs.com/gif.latex?&#x5C;{X%20=%20x_1&#x5C;}"/>, <img src="https://latex.codecogs.com/gif.latex?&#x5C;{X%20=%20x_2&#x5C;}%20..."/> несовместны и образуют полную группу, то сумма их вероятностей равна единице т. е. <img src="https://latex.codecogs.com/gif.latex?&#x5C;sum_{i}p_i=1"/>
  
###  Многоугольник (полигон) распределения
  
  
Закон распределения д. с. в. можно задать **графически**, если на оси абсцисс отложить возможные значения с. в., а на оси ординат — вероят­ности этих значений. Ломаную, соединяющую последовательно точки <img src="https://latex.codecogs.com/gif.latex?(x_1,p_1),(x_2,p_2),&#x5C;cdots"/> называют **многоугольником** (или полигоном) распределения (см. рис. 17). 
  
![](pic/Lec2-3.png )
  
###  Дискретная случайная величина
  
  
Случайная величина <img src="https://latex.codecogs.com/gif.latex?X"/> **дискретна**, если существует конечное или счетное множество чисел <img src="https://latex.codecogs.com/gif.latex?x_1,x_2,&#x5C;cdots"/> таких, что <img src="https://latex.codecogs.com/gif.latex?P&#x5C;{X%20=%20x_i&#x5C;}%20p_i%20&gt;%20О%20(i%20=%201,2,...)"/> и <img src="https://latex.codecogs.com/gif.latex?p_i%20+%20p_2%20+%20p_3%20+%20...%20=%201"/>.
  
Определим математические операции над дискретными с. в.
  
**Суммой (разностью, произведением)** д. с. в. <img src="https://latex.codecogs.com/gif.latex?X"/>, принимающей зна­чения <img src="https://latex.codecogs.com/gif.latex?x_i"/> с вероятностями <img src="https://latex.codecogs.com/gif.latex?p_i%20=%20P&#x5C;{X%20=%20x_i&#x5C;},%20i%20=%201,2,...,%20n"/> и д. с. в. <img src="https://latex.codecogs.com/gif.latex?Y"/>, при­ нимающей значения <img src="https://latex.codecogs.com/gif.latex?y_j"/> с вероятностями <img src="https://latex.codecogs.com/gif.latex?p_j%20=%20P&#x5C;{Y%20=%20y_j&#x5C;},%20j%20=%201,2,...,m"/>, называется д. с. в. <img src="https://latex.codecogs.com/gif.latex?Z%20=%20X%20+%20Y%20(Z%20=%20X%20-%20Y,%20Z%20=%20X%20&#x5C;cdot%20У)"/>, принимающая
значения <img src="https://latex.codecogs.com/gif.latex?z_{ij}=x_i+y_j%20(z_{ij}=x_i-y_j,z_{ij}=x_i&#x5C;cdot%20y_j)"/>  с вероятностями <img src="https://latex.codecogs.com/gif.latex?p_{ij}=P&#x5C;{X=x_i,%20Y=y_j&#x5C;}"/> = для всех указанных значений <img src="https://latex.codecogs.com/gif.latex?i"/> и <img src="https://latex.codecogs.com/gif.latex?j"/>. В случае совпадения некоторых сумм <img src="https://latex.codecogs.com/gif.latex?x_i+y_j"/> (разностей <img src="https://latex.codecogs.com/gif.latex?x_i-y_j"/>, произведений <img src="https://latex.codecogs.com/gif.latex?x_iy_j"/>) соответствующие вероятности складываются.
  
###  Дискретная случайная величина
  
  
Произведение д. с. в. на число с называется д. с. в. с <img src="https://latex.codecogs.com/gif.latex?X"/>, принимающая значения <img src="https://latex.codecogs.com/gif.latex?cx_i"/>, с вероятностями <img src="https://latex.codecogs.com/gif.latex?p_i=P&#x5C;{x=x_i&#x5C;}"/>.
  
Две д.с.в. <img src="https://latex.codecogs.com/gif.latex?X"/> и <img src="https://latex.codecogs.com/gif.latex?Y"/> называются **независимыми**, если события <img src="https://latex.codecogs.com/gif.latex?&#x5C;{X=x_i&#x5C;}=A-i"/> и <img src="https://latex.codecogs.com/gif.latex?&#x5C;{Y=y_j&#x5C;}=B_j"/> независимы для любых <img src="https://latex.codecogs.com/gif.latex?i=1,2,&#x5C;cdots,%20n;%20j=1,2,&#x5C;cdots,%20m"/> т.е. 
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P&#x5C;{X=x_i;%20Y=y_j&#x5C;}=P&#x5C;{X=x_i&#x5C;}&#x5C;cdot%20P&#x5C;{Y=y_j&#x5C;}"/></p>  
  
  
  
В противном случае с. в. называются зависимыми. Несколько с. в. на­ зываются взаимно независимыми, если закон распределения любой из них не зависит от того, какие возможные значения приняли остальные величины.
  
###  Функция распределения случайной величины
  
  
Очевидно, ряд распределения с. в. может быть построен только для д. с. в.; для н. с. в. нельзя даже перечислить все ее возможные значения.
  
Для характеристики поведения н. с. в. целесообразно использовать вероятность события <img src="https://latex.codecogs.com/gif.latex?&#x5C;{X%20&lt;%20x&#x5C;}"/> (а не <img src="https://latex.codecogs.com/gif.latex?&#x5C;{X%20=%20x&#x5C;}"/>), где <img src="https://latex.codecogs.com/gif.latex?x"/> — некоторое дей­ ствительное число. С точки зрения практики нас мало интересует собы­ тие, состоящее, например, в том, что лампочка проработает ровно 900 часов, т. е. <img src="https://latex.codecogs.com/gif.latex?X%20=%20900"/>. Более важным является событие вида <img src="https://latex.codecogs.com/gif.latex?&#x5C;{X%20&lt;%20900&#x5C;}"/> (или <img src="https://latex.codecogs.com/gif.latex?&#x5C;{X%20&gt;%20900&#x5C;}"/>). Такое событие имеет ненулевую вероятность; при из­ менении х вероятность события <img src="https://latex.codecogs.com/gif.latex?&#x5C;{X%20&lt;%20x&#x5C;}"/> в общем случае будет менять­ся. Следовательно, вероятность <img src="https://latex.codecogs.com/gif.latex?Р&#x5C;{%20X%20&lt;%20x&#x5C;}"/> является функцией от <img src="https://latex.codecogs.com/gif.latex?x"/>.
  
Универсальным способом задания закона распределения вероятно­ стей, пригодным как для дискретных, так и для непрерывных случай­ных величин, является ее функция распределения, обозначаемая <img src="https://latex.codecogs.com/gif.latex?F_X(x)"/> (или просто <img src="https://latex.codecogs.com/gif.latex?F(x)"/>, без индекса, если ясно, о какой с. в. идет речь).
  
Функцией распределения с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> называется функция <img src="https://latex.codecogs.com/gif.latex?F(x)"/>, которая для любого числа х Е R равна вероятности события <img src="https://latex.codecogs.com/gif.latex?&#x5C;{X%20&lt;%20x&#x5C;}"/>.
  
Таким образом, по определению
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?F(x)=P&#x5C;{X&lt;x&#x5C;}"/></p>  
  
  
т.е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?F(x)=P&#x5C;{&#x5C;omega:%20X(&#x5C;omega)&lt;x&#x5C;}"/></p>  
  
  
Функцию <img src="https://latex.codecogs.com/gif.latex?F(x)"/> называют также **интегральной функцией распределения**. Геометрически равенство можно истолковать так: <img src="https://latex.codecogs.com/gif.latex?F(x)"/> есть вероятность того, что с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> примет значение, которое изображается на числовой оси точкой, лежащей  <img src="https://latex.codecogs.com/gif.latex?x"/> .т, т. е. случайная точка <img src="https://latex.codecogs.com/gif.latex?X"/> попадет в интервал <img src="https://latex.codecogs.com/gif.latex?(-&#x5C;infty,%20x)"/>
  
![](pic/Lec2-4.png )
  
###  Свойства функции распределения
  
  
Функция распределения обладает следующими свойствами:
  
1. <img src="https://latex.codecogs.com/gif.latex?F(x)"/> ограничена, т. е.
   <p align="center"><img src="https://latex.codecogs.com/gif.latex?0&#x5C;le%20F(x)&#x5C;le%201"/></p>  
  
2. <img src="https://latex.codecogs.com/gif.latex?F(x)"/> — неубывающая функция на <img src="https://latex.codecogs.com/gif.latex?R"/>, т.е. если <img src="https://latex.codecogs.com/gif.latex?x_1%20&gt;%20x_2"/>, то
   <p align="center"><img src="https://latex.codecogs.com/gif.latex?F(x_2)&#x5C;ge%20F(x_1)"/></p>  
  
3. <img src="https://latex.codecogs.com/gif.latex?F(x)"/> обращает в ноль на минус бесконечности и равна единице в плюс: бесконечности, т. е.
   <p align="center"><img src="https://latex.codecogs.com/gif.latex?F(-&#x5C;infty)=0&#x5C;qquad%20F(+&#x5C;infty)=1"/></p>  
  
4. Вероятность попадания с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> в промежуток <img src="https://latex.codecogs.com/gif.latex?[а,%20b)"/> равна прираще­ нию ее функции распределения на этом промежутке, т. е.
   <p align="center"><img src="https://latex.codecogs.com/gif.latex?P&#x5C;{a&#x5C;le%20X%20&lt;%20b&#x5C;}=F(b)-F(a)"/></p>  
  
5. <img src="https://latex.codecogs.com/gif.latex?F(x)"/> непрерывна слева, т. е.
   <p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;lim_{x&#x5C;to%20x_0-0}F(x)=F(x_0)"/></p>  
  
  
###  Непрерывная случайная величина
  
  
С помощью функции распределения можно вычислить вероятность события <img src="https://latex.codecogs.com/gif.latex?&#x5C;{X%20&#x5C;ge%20x&#x5C;}"/>:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P&#x5C;{X&#x5C;ge%20x&#x5C;}=1-F(x)"/></p>  
  
  
Можно дать **более точное определение н. с. в.**
  
  
Случайную величину <img src="https://latex.codecogs.com/gif.latex?X"/> называют **непрерывной**, если ее функция распределения непрерывна в любой точке и дифференцируема всюду, кроме, может быть, отдельных точек.
  
для н. с. в. справедливы равенства
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P&#x5C;{a&#x5C;le%20x&lt;b&#x5C;}=P&#x5C;{a&lt;x&lt;b&#x5C;}=P&#x5C;{a&#x5C;le%20x&#x5C;le%20b&#x5C;}=P&#x5C;{X&#x5C;in(x,b]&#x5C;}"/></p>  
  
  
###  Функция распределения дискретной случайной величины
  
  
Функция распределения д. с. в. имеет вид
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?F(x)=&#x5C;sum_{x_i&lt;x}p_i"/></p>  
  
  
Здесь суммирование ведется по всем <img src="https://latex.codecogs.com/gif.latex?i"/>, для которых <img src="https://latex.codecogs.com/gif.latex?x_i&lt;x"/>.
  
###  Плотность распределения вероятностей
  
  
**Плотностью распределения вероятностей** (**плотностью распреде­ ления, плотностью вероятностей** или просто **плотностью**) непрерыв­ ной случайной величины X называется производная ее функции рас­пределения.
  
Обозначается плотность распределения н.с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> через <img src="https://latex.codecogs.com/gif.latex?f_X(x)"/> (или <img src="https://latex.codecogs.com/gif.latex?p_X(x)"/>) или просто <img src="https://latex.codecogs.com/gif.latex?f(x)"/> (или <img src="https://latex.codecogs.com/gif.latex?p(x)"/>), если ясно о какой с. в. идет речь.
  
Таким образом, по определению
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?f(x)=F&#x27;(x)"/></p>  
  
  
Функцию <img src="https://latex.codecogs.com/gif.latex?f(x)"/> называют также **дифференциальной функцией распреде­ ления**; она является одной из форм закона распределения случайной величины, существует только для непрерывных случайных величин.
  
Установим вероятностный смысл плотности распределения. Из определения производной следует
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?f(x)=&#x5C;lim_{&#x5C;Delta%20x&#x5C;to%200}&#x5C;frac{&#x5C;Delta%20F(x)}{&#x5C;Delta%20x}=&#x5C;lim_{&#x5C;Delta%20x&#x5C;to%200}&#x5C;frac{F(x+&#x5C;Delta%20x-F(x))}{&#x5C;Delta%20x}"/></p>  
  
  
Но согласно формуле <img src="https://latex.codecogs.com/gif.latex?P&#x5C;{a&#x5C;le%20X&lt;b&#x5C;}=F(b)-F(a)"/>
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?F(x+&#x5C;Delta%20x)-F(x)=P&#x5C;{x&#x5C;le%20X&lt;x+&#x5C;Delta%20x&#x5C;}"/></p>  
  
  
Отношение <img src="https://latex.codecogs.com/gif.latex?&#x5C;frac{x&#x5C;le%20X&lt;x+&#x5C;Delta%20x}{&#x5C;Delta%20x}"/> представляет собой среднюю вероятность, которая приходится на единицу длины участка <img src="https://latex.codecogs.com/gif.latex?[x,x+&#x5C;Delta%20x]"/>, т.е. среднюю плотность распределения вероятности. Тогда
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?f(x)=&#x5C;lim_{&#x5C;Delta%20x&#x5C;to%200}&#x5C;frac{P&#x5C;{x&#x5C;le%20X&lt;%20x+&#x5C;Delta%20x&#x5C;}}{&#x5C;Delta%20x}"/></p>  
  
  
т. е. плотность распределения есть предел отношения вероятности по­ падания с.в.в промежуток <img src="https://latex.codecogs.com/gif.latex?[x;x+&#x5C;Delta%20%20x)"/> к длине <img src="https://latex.codecogs.com/gif.latex?&#x5C;Delta%20x"/> этого промежутка, когда <img src="https://latex.codecogs.com/gif.latex?&#x5C;Delta%20x"/> стремится к нулю.
  
Из равенства следует, что
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?P&#x5C;{x&#x5C;le%20X&lt;x+&#x5C;Delta%20x&#x5C;}&#x5C;approx%20f(x)&#x5C;Delta%20x"/></p>  
  
  
То есть **плотность вероятности определяется как функция** <img src="https://latex.codecogs.com/gif.latex?f(x)"/>, удо­влетворяющая условию <img src="https://latex.codecogs.com/gif.latex?P&#x5C;{x%20&#x5C;le%20X%20&lt;%20x%20+%20{%20&#x5C;rm%20d}%20x&#x5C;}%20&#x5C;approx%20f(x)%20{%20&#x5C;rm%20d}x"/>; выражение <img src="https://latex.codecogs.com/gif.latex?f(x)%20{%20&#x5C;rm%20d}x"/> называется элементом вероятности.
  
  
Отметим, что плотность <img src="https://latex.codecogs.com/gif.latex?f(x)"/> аналогична таким понятиям, как плотность распределения масс на оси абсцисс или плотность тока в
теории электричества.
  
###  Свойства плотности распределения
  
  
Плотность распределения обладает следующими свойствами:
1. <img src="https://latex.codecogs.com/gif.latex?f(x)"/> неотрицательная, т.е.
   <p align="center"><img src="https://latex.codecogs.com/gif.latex?f(x)&#x5C;ge%200"/></p>  
  
2. Вероятность попадания н.с. в. в промежуток <img src="https://latex.codecogs.com/gif.latex?[а;%20b]"/>\ равна определенному интегралу от ее плотности в пределах от <img src="https://latex.codecogs.com/gif.latex?а"/> до <img src="https://latex.codecogs.com/gif.latex?b"/>, т. е. 
   <p align="center"><img src="https://latex.codecogs.com/gif.latex?Р&#x5C;{a&#x5C;le%20X%20&#x5C;le%20b&#x5C;}=%20&#x5C;int_a^b%20f(x)%20{%20&#x5C;rm%20d}x"/></p>  
  
3. Функция распределения н. с. в. может быть выражена через ее плотность вероятности по формуле
   <p align="center"><img src="https://latex.codecogs.com/gif.latex?F(x)=&#x5C;int_{-&#x5C;infty}^xf(t)%20{%20&#x5C;rm%20d}t"/></p>  
  
4. Условие нормировки: несобственный интеграл от плотности веро­ ятности н.с. в. в бесконечных пределах равен единице, т. е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;int_{-&#x5C;infty}^&#x5C;infty%20f(x)%20{&#x5C;rm%20d}x=1"/></p>  
  
  
##  Лекция 3 Числовые характеристики случайных величин
  
  
###  Числовые характеристики случайных величин
  
  
Закон распределения полностью характеризует случайную величи­ ну. Однако при решении многих практических задач достаточно знать лишь некоторые числовые параметры, характеризующие отдельные существенные свойства (черты) закона распределения с. в. Такие чи­ сла принято называть числовыми характеристиками с. в.
  
Важнейшими среди них являются характеристики положения: ма­ тематическое ожидание (центр распределения с. в.), мода» медиана; ха­ рактеристики рассеяния: дисперсия (отклонение значений с. в. от ее
центра)» среднее квадратическое отклонение.
  
###  Математическое ожидание дискретной случайной величины
  
  
**Математическим ожиданием** (или **средним** значением) д.с. в. <img src="https://latex.codecogs.com/gif.latex?X"/>, имеющей закон распределениям <img src="https://latex.codecogs.com/gif.latex?p_i=Р&#x5C;{X%20=%20x_i&#x5C;},%20i%20—%201,2,3,...,%20n"/>, назы­ вается число, равное сумме произведений всех ее значений на соответ­ ствующие им вероятности.
  
Математическое ожидание (сокращенно: м. о.) обозначается через <img src="https://latex.codecogs.com/gif.latex?MX"/> (или: <img src="https://latex.codecogs.com/gif.latex?M[X]"/>, <img src="https://latex.codecogs.com/gif.latex?M(X)"/>, <img src="https://latex.codecogs.com/gif.latex?EX"/>, <img src="https://latex.codecogs.com/gif.latex?m_X"/>, <img src="https://latex.codecogs.com/gif.latex?a_X"/>).
  
Таким образом, по определению
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?MX=&#x5C;sum_{i=1}^nx_i&#x5C;cdot%20p_i"/></p>  
  
  
Если число возможных значений с. в. X бесконечно (счетно), то
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?MX=&#x5C;sum_{i=1}^&#x5C;infty%20x_i&#x5C;cdot%20p_i"/></p>  
  
  
причем ряд в правой части предполагается сходящимся (в противном случае с. в. X не имеет м. о.).
  
###  Вероятностный смысл математического ожидания
  
  
Вероятностный смысл математического ожидания состоит в том, п что оно является средним значением с. в. Действительно, т. к. <img src="https://latex.codecogs.com/gif.latex?&#x5C;sum_{i=1}^n%20p_i=1"/>, то 
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?MX=&#x5C;sum_{i=1}^n=&#x5C;frac{&#x5C;sum_{i=1}^n%20x_ip_i}{&#x5C;sum_{i=1}^n%20p_i}=x_{среднее}"/></p>  
  
  
###  Математическое ожидание дискретной случайной величины
  
  
Значение математического ожидания удовлетворяет следующему неравенству:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;min&#x5C;{x_i&#x5C;}&#x5C;le%20M(X)&#x5C;le&#x5C;max&#x5C;{x_i&#x5C;}"/></p>  
  
  
Для вычисления математического ожидания достаточно знать закон распределения случайной величины.
  
###  Математическое ожидание непрерывной случайной величины
  
  
Математическим ожиданием п. с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> с плотностью вероятности
<img src="https://latex.codecogs.com/gif.latex?f(x)"/>, называется число
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?MX=&#x5C;int_{-&#x5C;infty}^&#x5C;infty%20x%20&#x5C;cdot%20f(x)%20{&#x5C;rm%20d}x"/></p>  
  
  
Интеграл в правой части равенства предполагается абсолютно сходящимся, т. е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?MX=&#x5C;int_{-&#x5C;infty}^&#x5C;infty%20&#x5C;lvert%20x&#x5C;rvert%20&#x5C;cdot%20f(x)%20{&#x5C;rm%20d}x&#x5C;lt%20&#x5C;infty"/></p>  
  
  
(в противном случае н.с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> не имеет м.о.).
  
###  Свойства математического ожидания
  
  
1. Математическое ожидание постоянной равно самой этой постоян­ ной, т. е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?Mc=c"/></p>  
  
  
2. Постоянный множитель выносится за знак м.о., т. е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?M(cX)=cMX"/></p>  
  
  
3. М.о. суммы с. в. равно сумме их м.о., т. е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?M(X+Y)=MX+MY"/></p>  
  
  
4. М. о. отклонения с. в. от ее м. о. равно нулю, т. е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?M(X-MX)%20=%200"/></p>  
  
  
5. М.о. произведения независимых с.в. равно произведению их м.о., т. е. если <img src="https://latex.codecogs.com/gif.latex?X"/> и <img src="https://latex.codecogs.com/gif.latex?Y"/> независимы, то
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?M(X&#x5C;cdot%20Y)=MX&#x5C;cdot%20MY"/></p>  
  
  
###  Дисперсия случайной величины
  
  
**Дисперсией** (**рассеянием**) с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> называется математическое ожи­ дание квадрата ее отклонения от своего математического ожидания.
  
Обозначается дисперсия через <img src="https://latex.codecogs.com/gif.latex?DX"/> (или <img src="https://latex.codecogs.com/gif.latex?D[X]"/>, <img src="https://latex.codecogs.com/gif.latex?D_X"/>, <img src="https://latex.codecogs.com/gif.latex?D(X)"/>). Таким образом, по определению
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?DX=M(X-MX)^2"/></p>  
  
  
или <img src="https://latex.codecogs.com/gif.latex?DX=MX^2"/>, или <img src="https://latex.codecogs.com/gif.latex?DX=M(X-m_X)^2"/>. Дисперсия характеризует разброс значений с. в. X относительно ее м. о. Из определения диспер­сии следуют формулы для ее вычисления:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?DX%20=%20&#x5C;sum_i(x_i-MX)^2&#x5C;cdot%20p_i%20&#x5C;%20-&#x5C;%20для&#x5C;%20д.с.в.&#x5C;%20X"/></p>  
  
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?DX=&#x5C;int_{-&#x5C;infty}^{+&#x5C;infty}(x-MX)^2&#x5C;cdot%20f(x)%20{&#x5C;rm%20d}x%20&#x5C;%20-&#x5C;%20для&#x5C;%20н.с.в.&#x5C;%20X"/></p>  
  
  
###  Дисперсия случайной величины
  
  
На практике дисперсию с. в. удобно находить по формуле
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?DX=MX^2-(MX)^2"/></p>  
  
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?D(X)=M(X^2)-(M(X))^2=&#x5C;sum_{i=1}^n%20x_i^2%20p_i-(M(X))^2=x_1^2&#x5C;cdot%20p_1+x_2^2&#x5C;cdot%20p_2+&#x5C;cdots+x_n^2&#x5C;cdot%20p_n-(M(X))^2"/></p>  
  
  
Доказательство:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;begin{split}%20%20%20DX=&amp;M(X^2-2X&#x5C;cdot%20MX+(MX)^2)&#x5C;&#x5C;%20%20%20=&amp;MX^2-M(2X&#x5C;cdot%20MX)+M(MX)^2&#x5C;&#x5C;%20%20%20=&amp;MX^2-2MX&#x5C;cdot%20MX+(MX)^2&#x5C;&#x5C;%20%20%20=&amp;MX^2-(MX)^2&#x5C;&#x5C;&#x5C;end{split}"/></p>  
  
  
###  Свойства дисперсии
  
  
1. Дисперсия постоянной равна нулю, т. е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?Dc=0"/></p>  
  
  
2. Постоянный множитель можно выносить за знак дисперсии, возве­ дя его в квадрат, т. е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?DcX=c^2DX"/></p>  
  
  
3. Дисперсия суммы независимых с. в. равна сумме их дисперсий, т.е. если X и Y независимы, то
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?D(X+Y)=DX+DY"/></p>  
  
  
4. Дисперсия с. в. не изменится, если к этой с. в. прибавить постоян­ ную, т, е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?D(X+c)=DX"/></p>  
  
  
5. Если с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> и <img src="https://latex.codecogs.com/gif.latex?Y"/> независимы, то
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?D(XY)=MX^2+MY^2-(MX)^2&#x5C;cdot(MY)^2"/></p>  
  
  
###  Свойства дисперсии
  
  
**Пояснение**. Случайные величины <img src="https://latex.codecogs.com/gif.latex?X"/> и <img src="https://latex.codecogs.com/gif.latex?Y"/> называются **неза­висимыми** тогда и только тогда, когда случайные события <img src="https://latex.codecogs.com/gif.latex?&#x5C;{X%20=%20x_i&#x5C;}"/> и <img src="https://latex.codecogs.com/gif.latex?&#x5C;{Y%20=%20y_j&#x5C;}"/> при любых <img src="https://latex.codecogs.com/gif.latex?i"/> и <img src="https://latex.codecogs.com/gif.latex?j"/> являются независимыми.
  
Из данного определения следует, что при любых <img src="https://latex.codecogs.com/gif.latex?i"/> и <img src="https://latex.codecogs.com/gif.latex?j"/> вероят­ность события <img src="https://latex.codecogs.com/gif.latex?&#x5C;{X%20=%20x_i&#x5C;}"/> не зависит от того, произошло событие <img src="https://latex.codecogs.com/gif.latex?&#x5C;{Y%20=%20y_j&#x5C;}"/> или нет. Другими словами, независимые случайные ве­личины <img src="https://latex.codecogs.com/gif.latex?X"/> и <img src="https://latex.codecogs.com/gif.latex?Y"/> не могут влиять друг на друга, взаимовлияние от­ сутствует.
  
###  Среднее квадратическое отклонение
  
  
Дисперсия <img src="https://latex.codecogs.com/gif.latex?DX"/> имеет размерность квадрата с. в, <img src="https://latex.codecogs.com/gif.latex?X"/>, что в сравни­ тельных целях неудобно. Когда желательно, чтобы оценка разброса (рассеяния) имела размерность с. в., используют еще одну числовую характеристику — среднее квадратическое отклонение (сокращенно: с. к. о.).
  
**Средним квадратическим отклонением** или **стандартным откло­ нением** с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> называется квадратный корень из ее дисперсии, обозна­чают через <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma_X"/> (или <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma%20X"/>, <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma[Х]"/>, <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma"/>). Таким образом, по определению
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma_X=&#x5C;sqrt{DX}"/></p>  
  
  
Из свойств дисперсии вытекают соответствующие свойства с. к. о.: <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma%20c=0,%20&#x5C;sigma_{cX}=&#x5C;lvert%20c&#x5C;rvert&#x5C;sigma_X,&#x5C;sigma(c+X)=&#x5C;sigma_X"/>
  
###  Стандартная случайная величина
  
  
Для изучения свойств случайного явления, независящих от выбо­ ра масштаба измерения и положения центра группирования, исходную случайную величину <img src="https://latex.codecogs.com/gif.latex?X"/> приводят к некоторому стандартному виду: ее центрируют,т.е.записываютразность <img src="https://latex.codecogs.com/gif.latex?X-MX"/> (геометрическиозна­ чает, что начало координат переносится в точку с абсциссой, равной м. о.), затем делят на с. к. о. <img src="https://latex.codecogs.com/gif.latex?&#x5C;sigma_X"/>
  
Случайную величину <img src="https://latex.codecogs.com/gif.latex?Z=&#x5C;frac{X-MX}{&#x5C;sigma_X}"/> называют **стандартной слу­чайной величиной**. Ее м. о. равно 0, а дисперсия равна 1. Действительно,
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?MZ=M(&#x5C;frac{X-MX}{&#x5C;sigma_X})=&#x5C;frac{1}{&#x5C;sigma_X}M(X-MX)=0"/></p>  
  
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?DZ=&#x5C;frac{1}{&#x5C;sigma^2_X}D(X-MX)=&#x5C;frac{DX}{&#x5C;sigma^2_X}=&#x5C;frac{DX}{DX}=1"/></p>  
  
  
То есть <img src="https://latex.codecogs.com/gif.latex?Z"/> — **центрированная** (<img src="https://latex.codecogs.com/gif.latex?MZ%20=%200"/>) и нормированная. (<img src="https://latex.codecogs.com/gif.latex?DZ%20=%201"/>) случайная величина.
  
###  Моменты случайной величины
  
  
Математическое ожидание и дисперсия являются частными случа­ ями следующих более общих понятий — моментов с. в.
  
**Начальным моментом порядка** <img src="https://latex.codecogs.com/gif.latex?k"/> с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> называется м.о. <img src="https://latex.codecogs.com/gif.latex?k"/>-й сте­пени этой величины, обозначается через <img src="https://latex.codecogs.com/gif.latex?&#x5C;alpha_k"/>
  
Таким образом, по определению
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;alpha_k=M(X^k)"/></p>  
  
  
Для д. с. в. начальный момент выражается суммой:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?a_k=&#x5C;sum_i%20x_i^k&#x5C;cdot%20p_i"/></p>  
  
  
а для н. с. в. — интегралом:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;alpha_k=&#x5C;int_{-&#x5C;infty}^&#x5C;infty%20x^k&#x5C;cdot%20f(x){&#x5C;rm%20d}x"/></p>  
  
  
В частности, <img src="https://latex.codecogs.com/gif.latex?&#x5C;alpha_1=MX"/>, т.е. начальный момент 1-го порядка есть м.о.
  
###  Центральный момент
  
  
**Центральным моментом порядка** <img src="https://latex.codecogs.com/gif.latex?k"/> с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> называется м. о. вели­чины <img src="https://latex.codecogs.com/gif.latex?(X%20—%20MX)^k"/>. обозначается через <img src="https://latex.codecogs.com/gif.latex?&#x5C;mu_k"/>.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;mu_k=M(X-MX)^k"/></p>  
  
  
В частности, <img src="https://latex.codecogs.com/gif.latex?&#x5C;mu_2=DX"/>, т. е. центральный момент 2-го порядка есть дисперсия; <img src="https://latex.codecogs.com/gif.latex?&#x5C;mu_1=M(X-MX)=0"/> (см. свойство 4 м. о.).
  
Для д. с. в.:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;mu_k=&#x5C;sum_i(x_i-MX)^k&#x5C;cdot%20p_i"/></p>  
  
  
а для и. с. в.:
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;mu_k=&#x5C;int_{-&#x5C;infty}^&#x5C;infty(x-MX)^k&#x5C;cdot%20f(x){&#x5C;rm%20d}x"/></p>  
  
  
###  Производящая функция
  
  
Нахождение важнейших числовых характеристик д. с. в. с целыми неотрицательными значениями удобно производить с помощью произ­ водящих функций.
  
Пусть д. с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> принимает значения <img src="https://latex.codecogs.com/gif.latex?0,1,2,&#x5C;cdots,k,&#x5C;cdots"/> с вероятностями <img src="https://latex.codecogs.com/gif.latex?p_0,p_1,p_2,&#x5C;cdots,p_k=P&#x5C;{X=k&#x5C;},&#x5C;cdots"/>
  
**Производящей функцией** для д. с. в. <img src="https://latex.codecogs.com/gif.latex?X"/> называется функция вида
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;varphi(z)=&#x5C;sum_{k=0}^&#x5C;infty%20p_k&#x5C;cdot%20z^k=p_0+p_1z+p_2z^2+&#x5C;cdots"/></p>  
  
  
где <img src="https://latex.codecogs.com/gif.latex?z"/> -— произвольный параметр, <img src="https://latex.codecogs.com/gif.latex?0%20&#x5C;lt%20z%20&#x5C;le%201"/>.
  
Отметим, что коэффициентами степенного ряда являются вероятности закона распределения д. с. в. <img src="https://latex.codecogs.com/gif.latex?X"/>
  
###  Производящая функция
  
  
Дифференцируя по <img src="https://latex.codecogs.com/gif.latex?z"/> производящую функцию, получим
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;varphi&#x27;(z)=&#x5C;sum_{k=0}^&#x5C;infty%20k&#x5C;cdot%20p_k&#x5C;cdot%20z^{k-1}"/></p>  
  
  
Тогда
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;varphi&#x27;(1)=&#x5C;sum_{k=0}^&#x5C;infty%20k&#x5C;cdot%20p_k=MX=&#x5C;alpha_1"/></p>  
  
  
т.е.
  
<p align="center"><img src="https://latex.codecogs.com/gif.latex?&#x5C;alpha_1=MX=&#x5C;alpha&#x27;(1)"/></p>  
  
  
  
  
##  Лекция 4
  
  