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

## [MainPage](../index.md)/[Mathematics](README.md)/Advanced Mathematics

# 高等数学

## 第四章 不定积分

### §4.1 不定积分的概念与性质

- 原函数
  - 定义：如果在区间 $I$ 上，可导函数 $F(x)$ 的导函数为 $f(x)$，即对任意 $x\in I$，都有

  $$F'(x)=f(x)\quad或\quad {\rm d} F(x)=f(x){\rm d} x$$

  那么函数 $F(x)$ 就称为 $f(x)$ （或 $f(x){\rm d}x$）在区间 $I$ 上的一个原函数
  - 原函数存在定理
    - 如果函数 $f(x)$ 在区间 $I$ 上连续，那么在区间 $I$ 上存在可导函数 $F(x)$，使对任意 $x\in I$ 都有

    $$F'(x)=f(x)$$

    - 简单来说：连续函数一定有原函数
  - 注意
    1. 如果 $f(x)$ 在区间 $I$ 上有原函数，即有一个函数 $F(x)$，使对任意 $x\in I$，都有 $F'(x)=f(x)$，那么，对任意常数 $C$，显然也有

    $$[F(x)+C]'=f(x)$$

    即对任何常数 $C$，函数 $F(x)+C$ 也是 $f(x)$ 的原函数，也就是说，如果 $f(x)$ 有一个原函数，那么就有无限多个原函数
    1. 设 $F(x)$ 是 $f(x)$ 的一个原函数，$\varPhi(x)$ 是 $f(x)$ 的另一个原函数，则对任意一 $x\in I$ 有

    $$\varPhi'(x)=f(x)$$

    于是

    $$[\varPhi(x)-F(x)]'=\varPhi'(x)-F'(x)=f(x)-f(x)=0$$

    由于在一个区间上导数恒为 0 的函数必为常熟，因此表达式 $F(x)+C$ 可以表示 $f(x)$ 的任意一个原函数
- 不定积分
  - 定义：在区间 $I$ 上，函数 $f(x)$ 的带有任意常数项的原函数称为 $f(x)$ 的不定积分，记作
  
  $$\int f(x){\rm d}x$$

  其中记号 $\int$ 称为积分号，$f(x)$ 称为被积函数，$f(x){\rm d}x$ 称为被积表达式，$x$ 称为积分变量
  - 定理：若 $F(x)$ 是 $f(x)$ 在区间 $I$ 上的一个原函数，那么 $F(x)+C$ 就是 $f(x)$ 的不定积分，即
  
  $$\int f(x){\rm d}x=F(x)+C$$

  因而 $\int f(x){\rm d}x$ 可以表示 $f(x)$ 的任意一个原函数
- 基本积分表
  №|基本积分公式
  -|-
  1|$\int k{\rm d}x=$$kx+C$
  2|$\int x^\mu{\rm d}x=\frac{x^{\mu+1}}{\mu+1}+C$
  3|$\int\frac{1}{x}{\rm d}x=\ln{x}+C$
  4|$\int\frac{1}{1+x^2}{\rm d}x=\arctan{x}+C$
  5|$\int\frac{1}{\sqrt{1-x^2}}=\sin{x}+C$
  6|$\int\cos{x}{\rm d}x=\sin{x}+C$
  7|$\int\sin{x}{\rm d}x=-\cos{x}+C$
  8|$\int\frac{1}{\cos^2{x}}=\int\sec^2{x}{\rm d}x=\tan{x}+C$
  9|$\int\frac{1}{\sin^2{x}}=\int\csc^2{x}{\rm d}x=-\cot{x}+C$
  10|$\int\sec{x}\tan{x}{\rm d}x=\sec{x}+C$
  11|$\int\csc{x}\cot{x}{\rm d}x=-\csc{x}+C$
  12|$\int e^x{\rm d}x=e^x+C$
  13|$\int a^x{\rm d}x=\frac{a^x}{\ln{x}}+C$
- 不定积分的性质 
  - 性质1：设函数 $f(x)$ 及 $g(x)$ 的原函数存在，则

    $$\int[f(x)+g(x)]{\rm d}x=\int f(x){\rm d}x+\int g(x){\rm d}x\qquad(1.3)$$

    - 证明：将 $(1.3)$ 式右端求导，得

    $$\left[\int f(x){\rm d}x+\int g(x){\rm d}x\right]'=\left[\int f(x){\rm d}x\right]'+\left[\int g(x){\rm d}x\right]'=f(x)+g(x)$$

    这表示，$(1.3)$ 式右端是 $f(x)+g(x)$ 的原函数，又 $(1.3)$ 式右端有两个积分记号，形式上含两个任意常数，由于任意常数之和仍未任意常数，故实际上含一个任意常熟，因此 $(1.3)$ 式右端是 $f(x)+g(x)$ 的不定积分
    - 适用范围：对于有限个函数都成立
  - 性质2：设函数 $f(x)$ 的原函数存在，$k$ 为非零常数，则

    $$\int kf(x){\rm d}x=k\int f(x){\rm d}x$$

### §4.2 换元积分法

- 第一类换元法
  - 设 $f(u)$ 具有原函数 $F(u)$，即

    $$F'(u)=f(u), \int f(u){\rm d}u=F(u)+C$$

    如果 $u$ 是中间变量：$u=\varphi(x)$，且设 $\varphi(x)$ 可微，那么根据复合函数微分法，有

    $${\rm d}F[\varphi(x)]=f[\varphi(x)]\varphi'(x){\rm d}x$$

    从而根据不定积分的定义得到

    $$\int f[\varphi(x)]\varphi'(x){\rm d}x=F[\varphi(x)]+C=\left[\int f(u){\rm d}u\right]_{u=\varphi(x)}$$

  - 定理：设 $f(u)$ 具有原函数，$u=\varphi(x)$ 可导，则有换元公式

    $$\int f[\varphi(x)]\varphi'(x){\rm d}x=\left[\int f(u){\rm d}u\right]_{u=\varphi(x)}$$

- 第二类换元法

### §4.3 分部积分法

### §4.4 有理函数的积分

- 有理函数（有理分式）
  - 定义：两个多项式的商 $\frac{P(x)}{Q(x)}$ 称为有理函数，又称有理分式（我们总嘉定分子多项式 $P(x)$ 与分母多项式 $Q(x)$ 之间没有公因式）
  - 真分式：当分子多项式 $P(x)$ 的次数小于分母多项式 $Q(x)$ 时，这种有理函数为真分式
    - 对于真分式 $\frac{P(x)}{Q(x)}$，如果分母可以分解为两个多项式的乘积
    
      $$Q(x)=Q_1(x)Q_2(x)$$

      且 $Q_1(x)$ 与 $Q_2(x)$ 没有公因式，那么它可以拆分成两个真分式的和

      $$\frac{P(x)}{Q(x)}=\frac{P_1(x)}{Q_1(x)}+\frac{P_2(x)}{Q_2(X)}$$

      上述步骤成为把真分式化成部分分式之和，如果 $Q_1(x)$ 或 $Q(x)$ 还能进一步分解，则将其继续拆分，直到最后有理函数的分解式中只出现多项式、$\frac{P_1(x)}{(x-a)^k}$、$\frac{P_2(x)}{(x^2+px+q)^l}$ 等三类函数（其中 $p^2-4q<0,P_1(x)$ 为小于 $k$ 次的多项式，$P_2(x)$ 为小于 $2l$ 次的多项式），便容易求出积分
  - 假分式：当分子多项式 $P(x)$ 的次数大于分母多项式 $Q(x)$ 时，这种有理函数为假分式
    - 对于假分式，利用多项式的除法，总可以将其化成一个多项式与一个真分式的和
    - 

### §4.5 积分表的使用

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
