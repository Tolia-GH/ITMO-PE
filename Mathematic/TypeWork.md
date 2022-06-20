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

## [主页](../index.md)/[数学](README.md)/Типовой Расчёт

# Типовой Расчёт

## Задание №1

$$\begin{split}
    &\int\frac{e^{\tan{x}}+2}{\cos^2{x}}{\rm d}x\\
    =&\int(e^{\tan{x}}+2)\sec^2{x}{\rm d}x\\
    =&\int(2\sec^2(x)+e^{\tan{x}}\sec^2{x}){\rm d}x\\
    =&\int e^{\tan{x}}\sec^2{x}{\rm d}x+2\int\sec^2(x){\rm d}x\\
    &Пуcть\ u=\tan{x}\ и\ {\rm d}u=\sec^2{x}\\
    =&\int e^u{\rm d}u+2\int\sec^2(x){\rm d}x\\
    =&e^u+2\int\sec^2(x){\rm d}x+C\\
    =&e^{\tan{x}}+2\tan(x)+C
\end{split}$$

## Задание №2

$$\begin{split}
    &\int\sin^2{(2x+1)}\cdot \cos^2{(2x+1)}{\rm d}x\\
    &Пуcть\ u=2x+1\ и\ {\rm d}u=2{\rm d}x\\
    =&\frac{1}{2}\int\sin^2(u)\cos^2(u){\rm du}\\
    =&\frac{1}{2}\int\sin^2(u)(1-\sin^2(u)){\rm d}u\\
    =&\frac{1}{2}\int(\sin^2(u)-\sin^4(u)){\rm d}u\\
    =&\frac{1}{2}\int\sin^2(u){\rm d}u-\frac{1}{2}\int\sin^4(u){\rm}u\\
    =&\frac{1}{8}\sin^3(u)\cos(u)+\frac{1}{8}\int\sin^2(u){\rm d}u\\
    =&\frac{1}{8}\sin^3(u)\cos(u)+\frac{1}{8}\int\frac{1-\cos(2u)}{2}{\rm d}u\\
    =&\frac{1}{8}\sin^3(u)\cos(u)-\frac{1}{16}\int\cos(2u){\rm d}u+\frac{1}{16}\int 1{\rm d}u\\
    =&\frac{1}{8}\sin^3(u)\cos(u)-\frac{1}{32}\int\cos(2u){\rm d}(2u)+\frac{1}{16}\int 1{\rm d}u\\
    =&-\frac{\sin(2u)}{32}+\frac{1}{8}\sin^3(u)\cos(u)+\frac{1}{16}\int 1{\rm d}u\\
    =&-\frac{\sin(2u)}{32}+\frac{u}{16}+\frac{1}{8}\sin^3(u)\cos(u)+C\\
    =&-\frac{\sin(4x+2)}{32}+\frac{2x+1}{16}+\frac{1}{8}\sin^3(2x+1)\cos^3(2x+1)+C
\end{split}
$$

## Задание №3

$$\begin{split}
    &\int\frac{(2-x){\rm d}x}{\sqrt{3x^2+2x-5}}\\
    &{\rm d}(3x^2+2x-5)=(6x+2){\rm d}x\\
    =&-\frac{1}{6}\int\frac{6x+2}{\sqrt{3x^2+2x-5}}{\rm d}x+\frac{7}{3}\int\frac{ {\rm d}x}{\sqrt{3x^2+2x-5}}\\
    &Пусть\ u=3x^2+2x-5, {\rm d}u=(6x+2){\rm d}x\\
    =&-\frac{1}{6}\int\frac{ {\rm d}u}{\sqrt{u}}+\frac{3}{7}\int\frac{ {\rm d}x}{\sqrt{3x^2+2x-5}}\\
    =&-\frac{1}{3}\sqrt{u}+\frac{3}{7}\int\frac{ {\rm d}x}{\sqrt{3x^2+2x-5}}+C\\
    =&-\frac{1}{3}\sqrt{u}+\frac{3}{7}\int\frac{ {\rm d}x}{\sqrt{(\sqrt{3}x+\frac{1}{\sqrt{3}})^2-\frac{16}{3}}}+C\\
    &Заменим\ впоследнем\ интеграле\ t=\sqrt{3}x+\frac{1}{\sqrt{3}}, k^2=\frac{16}{3}, {\rm d}x=\frac{1}{\sqrt{3}} {\rm d}t\\
    =&-\frac{1}{3}\sqrt{u}+\frac{3}{7\sqrt{3}}\int\frac{ {\rm d}x}{\sqrt{t^2-k^2}}+C\\
    =&-\frac{1}{3}\sqrt{u}+\frac{3}{7\sqrt{3}}\arcsin(\frac{k}{t})+C\\
    =&-\frac{1}{3}\sqrt{u}+\frac{3}{7\sqrt{3}}\arcsin(\frac{k}{t})+C\\
    =&-\frac{1}{3}\sqrt{3x^2+2x-5}+\frac{3}{7\sqrt{3}}\arcsin(\frac{\sqrt{\frac{16}{3}}}{\sqrt{3}x+\frac{1}{\sqrt{3}}})+C\\
    =&-\frac{1}{3}\sqrt{3x^2+2x-5}+\frac{3\sqrt{3}}{21}\arcsin(\frac{\sqrt{16}}{3x+1})+C
\end{split}
$$

## Задание №4

$$\begin{split}
    &\int\frac{x(x+4){\rm d}x}{(x+2)^2(x^2-3x+8)}\\
    &Пусть \frac{x(x+4){\rm d}x}{(x+2)^2(x^2-3x+8)}=\frac{A}{x+2}+\frac{B}{(x+2)^2}+\frac{Cx+D}{x^2-3x+8}\\
    &\begin{cases}
        0=16A+8B+4D\\
        4=2A-3B+4C+4D\\
        1=-A+B+4C+D\\
        0=A+C
    \end{cases}\Rightarrow
    \begin{cases}
        A=-\frac{7}{81}\\
        B=-\frac{2}{9}\\
        C=\frac{7}{81}\\
        D=\frac{64}{81}
    \end{cases}\\
    =&\int\frac{7x+64}{81(x^2-3x+8)}-\frac{7}{81(x+2)}-\frac{2}{9(x+2)^2} {\rm d}x\\
    =&\frac{1}{81}\int\frac{7x+64}{x^2-3x+8} {\rm d}x-\frac{7}{81}\int\frac{1}{x+2} {\rm d}x-\frac{2}{9}\int\frac{1}{(x+2)^2}{\rm d}x\\
    =&\frac{1}{81}\int\frac{7x+64}{x^2-3x+8} {\rm d}x-\frac{7}{81}\ln(x+2)+\frac{2}{9(x+2)}+C\\
    =&\frac{7}{162}\int\frac{2x-3}{x^2-3x+8}{\rm d}x+\frac{149}{162}\int\frac{ {\rm d}x}{x^2-3x+8}-\frac{7}{81}\ln(x+2)+\frac{2}{9(x+2)}+C\\
    &Пусть\ u=x^2-3x+8,{\rm d}u=2x-3{\rm d}x\\
    =&\frac{7}{162}\int\frac{ {\rm d}u}{u}+\frac{149}{162}\int\frac{ {\rm d}x}{x^2-3x+8}-\frac{7}{81}\ln(x+2)+\frac{2}{9(x+2)}+C\\
    =&\frac{149}{162}\int\frac{ {\rm d}x}{x^2-3x+8}+\frac{7}{162}\ln(u)-\frac{7}{81}\ln(x+2)+\frac{2}{9(x+2)}+C\\
    =&\frac{149}{162}\int\frac{ {\rm d}x}{x^2-3x+8}+\frac{7}{162}\ln(x^2-3x+8)-\frac{7}{81}\ln(x+2)+\frac{2}{9(x+2)}+C\\
    =&\frac{149}{162}\int\frac{ {\rm d}x}{(x-\frac{3}{2})^2+\frac{23}{4}}+\frac{7}{162}\ln(x^2-3x+8)-\frac{7}{81}\ln(x+2)+\frac{2}{9(x+2)}+C\\
    &Пусть\ s=x-\frac{3}{2},{\rm d}s={\rm d}x\\
    =&\frac{149}{162}\int\frac{ {\rm d}s}{(s)^2+\frac{23}{4}}+\frac{7}{162}\ln(x^2-3x+8)-\frac{7}{81}\ln(x+2)+\frac{2}{9(x+2)}+C\\
    =&\frac{298}{1863}\int\frac{ {\rm d}s}{\frac{4s^2}{23}+1}+\frac{7}{162}\ln(x^2-3x+8)-\frac{7}{81}\ln(x+2)+\frac{2}{9(x+2)}+C\\
    &Пусть\ v=\frac{2u}{\sqrt{23}},{\rm d}v=\frac{2}{\sqrt{23}}{\rm d}u\\
    =&\frac{298}{1863}\frac{2}{\sqrt{23}}\int\frac{ {\rm d}v}{v^2+1}+\frac{7}{162}\ln(x^2-3x+8)-\frac{7}{81}\ln(x+2)+\frac{2}{9(x+2)}+C\\
    =&\frac{298}{1863}\frac{2\sqrt{23}}{23}\arctan(s)+\frac{7}{162}\ln(x^2-3x+8)-\frac{7}{81}\ln(x+2)+\frac{2}{9(x+2)}+C\\
\end{split}
$$

## Задание №5

$$\begin{split}
    &\int\frac{ {\rm d}x}{2\sqrt{x+5}-\sqrt[3]{x+5}-\sqrt[4]{x+5}}\\
    &Здесь\ k_1=3,k_2=2,поэтому\ p=12.\\
    &Пусть\ x+5=t^{12}\ Тогда\ x=t^{12}-5,{\rm d}x=12t^{11}{\rm d}t\\
    =&\int\frac{12t^{11} {\rm d}t}{2t^6-t^4-t^3}\\
    =&12\int\frac{t^{11}{\rm d}t}{2t^6-t^4-t^3}\\
    =&12\int\frac{t^8{\rm d}t}{2t^3-t-1}\\
    &разделить\ \frac{t^8{\rm d}t}{2t^3-t-1}, получим:\\
    &\frac{t^8{\rm d}t}{2t^3-t-1}=\frac{t^5}{2}+\frac{t^4}{4}+\frac{t^2}{4}+\frac{t}{8}+\frac{1}{5(t-1)}+\frac{-t-2}{40(2t^2+2t+1)}+\frac{1}{4}\\
    =&12\int\frac{t^5}{2}+\frac{t^4}{4}+\frac{t^2}{4}+\frac{t}{8}+\frac{1}{5(t-1)}+\frac{-t-2}{40(2t^2+2t+1)}+\frac{1}{4}{\rm d}t\\
    =&\frac{3}{10}\int\frac{-t-2}{2t^2+t+1}{\rm d}t+6\int t^5{\rm d}t+3\int t^3{\rm d}t+3\int t^2{\rm d}t+\frac{3}{2}\int t{\rm d}t+\frac{12}{5}\int\frac{ {\rm d}t}{t-1}+3\int {\rm d}t\\
    =&\frac{3}{10}\int\left(-\frac{4t+2}{4(2t^2+2t+1)}-\frac{3}{2(2t^2+2t+1)}\right){\rm d}t+6\int t^5{\rm d}t+3\int t^3{\rm d}t+3\int t^2{\rm d}t+\frac{3}{2}\int t{\rm d}t+\frac{12}{5}\int\frac{ {\rm d}t}{t-1}+3\int {\rm d}t\\
    =&-\frac{3}{40}\int\frac{4t+2}{2t^2+2t+1}{\rm d}t-\frac{9}{20}\int\frac{ {\rm d}t}{2t^2+2t+1}+6\int t^5{\rm d}t+3\int t^3{\rm d}t+3\int t^2{\rm d}t+\frac{3}{2}\int t{\rm d}t+\frac{12}{5}\int\frac{ {\rm d}t}{t-1}+3\int {\rm d}t\\
    =&-\frac{3}{40}\int\frac{ {\rm d}(2t^2+2t+1)}{2t^2+2t+1}-\frac{9}{20}\int\frac{ {\rm d}t}{(\sqrt{2}t+\frac{1}{\sqrt{2}})^2+\frac{1}{2}}+6\int t^5{\rm d}t+3\int t^3{\rm d}t+3\int t^2{\rm d}t+\frac{3}{2}\int t{\rm d}t+\frac{12}{5}\int\frac{ {\rm d}t}{t-1}+3\int {\rm d}t\\
    =&-\frac{3}{40}\int\frac{ {\rm d}(2t^2+2t+1)}{2t^2+2t+1}-\frac{9}{10\sqrt{2}}\int\frac{ {\rm d}(\sqrt{2t}+\frac{1}{\sqrt{2}})}{2(\sqrt{2}t+\frac{1}{\sqrt{2}})^2+1}+6\int t^5{\rm d}t+3\int t^3{\rm d}t+3\int t^2{\rm d}t+\frac{3}{2}\int t{\rm d}t+\frac{12}{5}\int\frac{ {\rm d}t}{t-1}+3\int {\rm d}t\\
    =&-\frac{3}{40}\ln(2t^2+2t+1)-\frac{9}{20}\arctan(2t+1)+t^6+\frac{3}{4}t^4+t^3+\frac{3}{4}t^2+\frac{12}{5}\ln(t-1)+3t+C\\
    &(t=\sqrt[12]{x+5})
\end{split}
$$

## Задание №6

$$\begin{split}
    &\int\frac{\sqrt{(1-x^2)^3}}{x^2}{\rm d}x\\
    =&\int\frac{(1-x^2)\sqrt{1-x^2}}{x^2}{\rm d}x\\
    =&\int\frac{\sqrt{1-x^2}}{x^2}{\rm d}x-\int\sqrt{1-x^2}{\rm d}x\\
    &a=1,x=a\sin t=\sin t,{\rm d}x=\cos t{\rm d}t\\
    =&\int\frac{\sqrt{1-\cos^2t}}{\sin^2t}\cos t{\rm d}t-\int\sqrt{1-\sin^2t}\cos t{\rm d}t\\
    =&\int\frac{\cos t}{\sin t}{\rm d}t-\int\cos^2t{\rm d}t\\
    =&\int\frac{ {\rm d}(\sin t)}{\sin t}-\frac{1}{2}\int(\cos(2t)+1){\rm d}t\\
    =&\ln(\sin t)-\frac{1}{4}\int\cos(2t){\rm d}(2t)-\frac{1}{2}\int{\rm d}t+C\\
    =&\ln(\sin t)-\frac{1}{4}\sin(2t)-\frac{t}{2}+C\\
    &t=\arcsin x\\
    =&\ln x-\frac{1}{2}(x\sqrt{1-x^2})-\frac{1}{2}\arcsin x+C
\end{split}
$$

## Задание №7

$$\begin{split}
    &\int\frac{\cos{x}{\rm d}x}{(1-\cos{x})^3}\\
    &Пусть\ t=\tan\frac{x}{2},то\ x=2\arctan t,{\rm d}x=\frac{2{\rm d}t}{1+t^2}\\
    &\sin x=2\frac{\tan\frac{x}{2}}{1+\tan^2\frac{x}{2}}=\frac{2t}{1+t^2};\cos x=\frac{1-\tan^2\frac{x}{2}}{1+\tan^2\frac{x}{2}}=\frac{1-t^2}{1+t^2}\\
    =&\int\frac{2(1-t^2)}{(1+t^2)^2(1-\frac{1-t^2}{1+t^2})^3}{\rm d}t\\
    =&\int\frac{1-t^4}{4t^6}{\rm d}t\\
    =&\frac{1}{4}\int\frac{1-t^4}{t^6}{\rm d}t\\
    =&\frac{1}{4}\int\frac{1}{t^6}{\rm d}t-\frac{1}{4}\int\frac{1}{t^2}{\rm d}t\\
    =&\frac{1}{4t}-\frac{1}{20t^5}+C\\
    &t=\tan\frac{x}{2}\\
    =&\frac{1}{4}\cot\frac{x}{2}-\frac{1}{20}\cot^5\frac{x}{2}+C
\end{split}
$$

## Задание №8

$$\begin{split}
    &\int^\frac{2}{3}_\frac{1}{3}(x^2-x+1)e^{3x}{\rm d}x\\
    =&\int^\frac{2}{3}_\frac{1}{3}(e^{3x}x^2-e^{3x}x+e^{3x}){\rm d}x\\
    =&\int^\frac{2}{3}_\frac{1}{3}e^{3x}x^2{\rm d}x-\int^\frac{2}{3}_\frac{1}{3}e^{3x}e{\rm d}x+\int^\frac{2}{3}_\frac{1}{3}e^{3x}{\rm d}x\\
    &u=x^2,{\rm d}u=2x{\rm d}x\\
    &{\rm d}v=e^{3x},v=\frac{e^{3x}}{3}\\
    =&\left.\frac{1}{3}e^{3x}x^2\right|^\frac{2}{3}_\frac{1}{3}-\frac{5}{3}\int^\frac{2}{3}_\frac{1}{3}e^{3x}x{\rm d}x+\int^\frac{2}{3}_\frac{1}{3}e^{3x}{\rm d}x\\
    =&\frac{1}{27}e(4e-1)-\frac{5}{3}\int^\frac{2}{3}_\frac{1}{3}e^{3x}x{\rm d}x+\int^\frac{2}{3}_\frac{1}{3}e^{3x}{\rm d}x\\
    &u'=x,{\rm d}u'={|rm d}x\\
    &{\rm d}v'=e^{3x},v'=\frac{e^{3x}}{3}\\
    =&\frac{1}{27}e(4e-1)+\left.(-\frac{5}{9}e^{3x})\right|^\frac{2}{3}_\frac{1}{3}+\frac{14}{9}\int^\frac{2}{3}_\frac{1}{3}e^{3x}{\rm d}x\\
    =&\frac{1}{27}e(4e-1)-\frac{5}{27}e(2e-1)+\frac{14}{9}e^{3x}{\rm d}x\\
    =&\frac{1}{27}e(4e-1)-\frac{5}{27}e(2e-1)+\left.\frac{14}{27}e^{3x}\right|^\frac{2}{3}_\frac{1}{3}\\
    =&\frac{1}{27}e(4e-1)-\frac{5}{27}e(2e-1)+\frac{14}{27}e(e-1)\\
    =&\frac{2}{27}e(4e-5)
\end{split}
$$

## Задание №9

$$\begin{split}
    &\int^\frac{\pi}{2}_0\sin{\varphi}\sqrt{\cos{\varphi}}{\rm d}\varphi\\
    &Пусть\ \phi=\cos\varphi,{\rm d}\phi={\rm d}\varphi\\
    =&-\int^0_1\sqrt{\phi}{\rm d}\phi\\
    =&\int^1_0\sqrt{\phi}{\rm d}\phi\\
    =&\left.\frac{2}{3}\phi^\frac{3}{2}\right|^1_0\\
    =&\frac{2}{3}
\end{split}
$$

## Задание №10

Найдите площадь области, ограниченной кривыми, заданными в декартовых координатах

<div align=center><img src="pic/TypeWork-1.png"></div>
<center>График Функция</center>

$$
\begin{cases}
    f_1:x^2+y^2=16x\\
    f_2:y^2=8x\\
\end{cases}\Rightarrow
\begin{cases}
    f_1:y=\sqrt{16x-x^2}\\
    f_2:y=2\sqrt{2x}
\end{cases}
$$

Очевидно, что $f_1$ - окружность,и Площать $S_1=64\pi$

$$\begin{split}
    &Пусть\ S_\Delta=\int^8_0(f_1-f_2){\rm d}x=\int^8_0(\sqrt{16x-x^2}-2\sqrt{2x}){\rm d}x\\
    &=16\pi-\int^8_02\sqrt{2x}{\rm d}x\\
    &=16\pi-2\sqrt{2}\int^8_0\sqrt{x}{\rm d}x\\
    &=16\pi-\left.\frac{4}{3}\sqrt{2}x^\frac{3}{2}\right|^8_0\\
    &=16\pi-\frac{128}{3}\\
    &
\end{split}
$$

Площадь области,ограниченной заданными кривыми $S$:

$$S=S_1-2S\Delta=64\pi-2(16\pi-\frac{128}{3})=32\pi+\frac{256}{3}$$


## Задание №11

Найдите длину кривой $L$, заданной в декартовых координатах

$$y^2-2y=4x\quad -1\le x\le 0$$

<div align=center><img src="pic/TypeWork-2.png"></div>
<center>График Функция</center>

Очевидно, что L равна его обратной фукцией в части $(-1\le y\le 0)$:

$$x^2-2x=4y\quad -1\le y\le 0$$

<div align=center><img src="pic/TypeWork-3.png"></div>
<center>График Функция</center>

$$\begin{split}
    x^2&-2x=4y\\
    \Rightarrow y&=\frac{x^2}{4}-\frac{x}{2}\\
    y'&=\frac{x}{2}-\frac{1}{2}\\
    L&=\int^0_{-1}\sqrt{1+y'^2}{\rm d}x\\
    &=\int^0_{-1}\sqrt{1+(\frac{x}{2}-\frac{1}{2})^2}{\rm d}x\\
    &=\frac{1}{2}\int^0_{-1}\sqrt{x^2-2x+5}{\rm d}x\\
    Пусть\ u&=x-1,{\rm d}u={\rm d}x\\
    L&=\frac{1}{2}\int^{-1}_{-2}\sqrt{u^2+4}{\rm d}u\\
    Пусть\ u&=2\tan(t),{\rm d}u=2\sec^2(t){\rm d}t\\
    L&=2\int^{-\arctan\frac{1}{2}}_{-\frac{\pi}{4}}\sec^3(t){\rm d}t\\
    &=\left.\tan(t)\sec(t)\right|^{-\arctan\frac{1}{2}}_{-\frac{\pi}{4}}+\int^{-\arctan\frac{1}{2}}_{-\frac{\pi}{4}}\sec(t){\rm d}t\\
    &=\sqrt{2}-\frac{\sqrt{5}}{4}+\int^{-\arctan\frac{1}{2}}_{-\frac{\pi}{4}}\sec(t){\rm d}t\\
    &=\sqrt{2}-\frac{\sqrt{5}}{4}+\left.\ln(\tan(t)+\sec(t))\right|^{-\arctan\frac{1}{2}}_{-\frac{\pi}{4}}\\
    &=\sqrt{2}-\frac{\sqrt{5}}{4}-\ln(\sqrt{2}-1)+\ln(\frac{1}{2}(\sqrt{5}-1))
\end{split}$$

## Задание №12

Вычислите
- а) Площадь, Органиченную осью абсцисс и верзиерой

$$\begin{cases}
    x=2t\\
    y=\frac{8}{1+t^2}
\end{cases}$$

Из формулы $x$ получим $t=\frac{x}{2}$, подставляем в $y$:

$$\begin{split}
    y&=\frac{8}{1+(\frac{x}{2})^2}=\frac{32}{x^2+4}\\
    S&=\int^{+\infty}_{-\infty}\frac{32}{x^2+4}{\rm d}x\\
    &=32\int^{+\infty}_{\infty}\frac{1}{x^2+4}{\rm d}x\\
    &=64\int^{\infty}_0\frac{1}{x^2+4}{\rm d}x\\
    &=32\int^{\infty}_0\frac{1}{\frac{x^2}{4}+1}{\rm d}(\frac{x}{2})\\
    &=\left.\lim_{a\rightarrow\infty}32\arctan(\frac{x}{2})\right|^a_0\\
    &=16\pi
\end{split}$$

- б) Длину дуги кривой

  $$r=6\sin^3{(\frac{\varphi}{3})}$$

  $$r'=6\sin^2(\frac{\varphi}{3})\cos(\frac{\varphi}{3})$$

  $$\begin{split}
    L&=\int^{\varphi_2}_{\varphi_1}\sqrt{r^2+r'^2}{\rm d}\varphi\\
    &=\int^{\varphi_2}_{\varphi_1}\sqrt{36\sin^6(\frac{\varphi}{3})+36\sin^4(\frac{\varphi}{3})\cos^2(\frac{\varphi}{3})}{\rm d}\varphi\\
    &=\int^{\varphi_2}_{\varphi_1}6\sin^2(\frac{\varphi}{3}){\rm d}\varphi
  \end{split}
  $$

  потому что $r\ge0$, мы получим $\sin^3(\frac{\varphi}{3})\ge0$, то $\varphi_1=0,\varphi_2=3\pi$, поэтому

  $$\begin{split}
    L&=\int^{3\pi}_{0}6\sin^2(\frac{\varphi}{3}){\rm d}\varphi\\
    &=6\int^{3\pi}_{0}\sin^2(\frac{\varphi}{3}){\rm d}\varphi\\
    &=18\int^{\pi}_{0}\sin^2(\frac{\varphi}{3}){\rm d}(\frac{\varphi}{3})\\
    &=18\int^{\pi}_{0}(\frac{1-\cos(\frac{2\varphi}{3})}{2}){\rm d}(\frac{\varphi}{3})\\
    &=9\int^{\pi}_0{\rm d}(\frac{\varphi}{3})-9\int^{\pi}_0\cos(\frac{2\varphi}{3}){\rm d}(\frac{\varphi}{3})\\
    &=9\int^{\pi}_0{\rm d}(\frac{\varphi}{3})\\
    &=9\pi
  \end{split}$$

## Задание №13

Найдите значение несобственного интеграла или установите его расходимость.
- а)
  
$$
\begin{split}
    &\int^{+\infty}_0(4-3x)e^{-3x}{\rm d}x\\
    =&4\int^{+\infty}_0e^{-3x}{\rm d}x-3\int^{+\infty}_0xe^{-3x}{\rm d}x\\
    =&4\lim_{b\rightarrow\infty}\int^{b}_0e^{-3x}{\rm d}x-3\lim_{b\rightarrow\infty}\int^{b}_0xe^{-3x}{\rm d}x\\
    =&3\lim_{b\rightarrow\infty}\int^b_0e^{-3x}{\rm d}x+\left.\lim_{b\rightarrow\infty}xe^{-3x}\right|^b_0\\
    =&3\lim_{b\rightarrow\infty}\int^b_0e^{-3x}{\rm d}x+\lim_{b\rightarrow\infty}be^{-3b}\\
    =&3\lim_{b\rightarrow\infty}\int^b_0e^{-3x}{\rm d}x+0\\
    =&\left.e^{-3b}\right|^{0}_{-\infty}\\
    =&1
\end{split}$$

- б)

$$\begin{split}
    &\int^\frac{1}{2}_0\frac{x^3{\rm d}x}{\sqrt{1-16x^4}}\\
    Пусть\ u=&1-16x^4\quad{\rm d}u=-64x^3{\rm d}x\\
    =&-\frac{1}{64}\int^0_1\frac{1}{\sqrt{u}}{\rm d}u\\
    =&\frac{1}{64}\int^1_0\frac{1}{\sqrt{u}}{\rm d}u\\
    =&\left.\lim_{b\rightarrow0^+}\frac{\sqrt
    u}{32}\right|^1_b\\
    =&\frac{\sqrt{1}}{32}-\frac{\sqrt{0}}{32}\\
    =&\frac{1}{32}
\end{split}$$

<style type="text/css">
    #footer {
        position: relative;
        margin: 0 auto;
        line-height: 20px;
        text-align: center;
        font-size: 12px;
        letter-spacing: 1px;
    }
 
    .content {
        height: 1800px;
        width: 100%;
        text-align: center;
    }
</style>

<div id="footer">
    Powered by
    <a href="https://html5up.net">HTML</a>, 
    <a href="https://markdown.com.cn/">markdown</a>, 
    <a href="https://www.latex-project.org/">LaTeX</a>
    <br>
    Copyright © 2022 | 
    <a href="https://tolia-gh.github.io">Tolia</a>
    <br>
    All Rights Reserved.
    <br>
</div>