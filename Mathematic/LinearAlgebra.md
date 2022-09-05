# 线性代数

## 第一章 行列式

### §1.1 二阶与三阶行列式

- 二阶行列式
    - 定义：数表
        由二元线性方程组：
        $$
        \begin{cases}
            a_{11}x_1+a_{12}x_2=b_1\\
            a_{21}x_1+a_{22}x_2=b_2\\
        \end{cases} \qquad (1)
        $$
        将其系数 $a_{11}$、$a_{12}$、$a_{21}$、$a_{22}$ 按其在方程组 $(1)$ 的位置排成二行二列：
        $$
        \begin{matrix}
            a_{11} & a_{12}\\
            a_{21} & a_{22}\\
        \end{matrix} \qquad (2)
        $$
        即为二阶行列式的数表
    - 定义：二阶行列式
        将数表 $(2)$ 左上和右下的系数相乘减去右上与左下的系数相乘得到的表达式 $a_{11}a_{22}-a_{12}a_{21}$ 即为数表 $(2)$ 所确定的 **二阶行列式**，并记作：
        $$
        \begin{vmatrix}
            a_{11} & a_{12}\\
            a_{21} & a_{22}\\
        \end{vmatrix}
        \qquad (3)
        $$
    - 定义：系数行列式
        由线性方程组的系数得来的行列式叫系数行列式
        - 定义：元素（元）
            - 行列式中的数 $a_{ij}$ 称为行列式的元素或元
            - 其中 $i$ 为行标，$j$ 为列标
            - 位于 $i$ 行 $j$ 列的元素称为行列式的 $(i,j)$ 元
    - 定理：二阶行列式的对角线法则
        见数列 $(2)$：
        ![](https://www.ranying.xyz/api/icsg/icsg-image/i/2021/07/03/za88ax.png)
        - 主对角线：$a_{11}$ 到 $a_{22}$ 的实现
        - 副对角线：$a_{12}$ 到 $a_{21}$ 的虚线
        二阶行列式便是主对角线上两元素之积减去副对角线上两元素之积所得的差
    - 应用：求解二元线性方程组
        用消元法解方程组 $(1)$ 可得
        $$x_1=\frac{b_1a_{22}-a_{12}b_2}{a_{11}a_{22}-a_{12}a_{21}} \qquad x_2=\frac{b_2a_{11}-a_{21}b_1}{a_{11}a_{22}-a_{12}a_{21}} \qquad (4)$$
        若记
        $$
        D=
        \begin{vmatrix}
            a_{11} & a_{12}\\
            a_{21} & a_{22}\\
        \end{vmatrix}  \qquad
        D_1=
        \begin{vmatrix}
            b_1 & a_{12}\\
            b_2 & a_{22}\\
        \end{vmatrix}  \qquad
        D_2=
        \begin{vmatrix}
            a_{11} & b_1\\
            a_{21} & b_2\\
        \end{vmatrix} 
        $$
        则 $(4)$ 可写成
        $$
        x_1=\frac{D_1}{D}=\frac{ 
        \begin{vmatrix}
            b_1 & a_{12}\\
            b_2 & a_{22}\\
        \end{vmatrix}  }{ 
        \begin{vmatrix}
            a_{11} & a_{12}\\
            a_{21} & a_{22}\\
        \end{vmatrix}  }
        \qquad
        x_2=\frac{D_2}{D}=\frac{ 
        \begin{vmatrix}
            a_{11} & b_1\\
            a_{21} & b_2\\
        \end{vmatrix}  }{ 
        \begin{vmatrix}
            a_{11} & a_{12}\\
            a_{21} & a_{22}\\
        \end{vmatrix}  }
        $$
- 三阶行列式
    - 定义：三阶行列式
        已知三行三列的数表
        $$
        \begin{matrix}
            a_{11} & a_{12} & a_{13}\\
            a_{21} & a_{22} & a_{23}\\
            a_{31} & a_{32} & a_{33}\\
        \end{matrix}
        $$
        记
        $$
        \begin{vmatrix}
            a_{11} & a_{12} & a_{13}\\
            a_{21} & a_{22} & a_{23}\\
            a_{31} & a_{32} & a_{33}\\
        \end{vmatrix}
        =a_{11}a_{22}a_{33}+a_{12}a_{23}a_{31}+a_{13}a_{21}a_{32}-a_{11}a_{23}a_{32}-a_{12}a_{21}a_{33}-a_{13}a_{22}a_{31}
        $$
    - 定理：三阶行列式的对角线法则
        由上述定义可知
        ![](https://www.ranying.xyz/api/icsg/icsg-image/i/2021/07/03/z04zj2.png)
        三阶行列式含 6 项，每项均由不同行不同列的三个元素的乘积并冠以正负号，其规律遵循下图的对角线法则：实现上三元素乘积冠以正号，虚线上冠以负号

### §1.2 全排列和对换

- 全排列（排列）
    - 定义：把 $n$ 个不同的元素排成一列，叫做这 $n$ 个元素的全排列（也简称排列），$n$ 个不同的元素的所有排列总数通常用 $P_n$ 表示
    - $P_n$ 的计算
        $$P_n=n \cdot (n-1) \cdot \ \cdots \ \cdot 3 \cdot 2 \cdot 1=n!$$
    - 逆序
        - 定义：对于 $n$ 个不同元素，先规定各元素之间有一个标准次序，于是在这 $n$ 个不同元素的任意排列中，当 **某一元素** 的先后次序与标准次序不同时，就说它构成一个逆序
    - 逆序数
        - 定义：一个排列中所有的逆序总数叫做这个排列的逆序数
        - 计算：
            不失一般性，设 $n$ 个元素为 $1$ 至 $n$ 这 $n$ 个自然数，并规定由小到大为标准次序
            设 $p_1p_2···p_n$ 为这 $n$ 个自然数的一个排列，考虑元素 $p_i \quad (i=1,2,···,n)$，如果比 $p_i$ 大的且排在 $p_i$前面的元素有 $t_i$ 个，就说 $p_i$ 这个元素的逆序数是 $t_i$，那么全体元素的逆序数之和为：
            $$t=t_1+t_2+···+t_n=\sum_{i=1}^n t_i$$
    - 奇排列
        - 定义：逆序数为奇数的排列叫奇排列
    - 偶排列
        - 定义：逆序数为偶数的排列叫偶排列
- 对换
    - 定义：在排列中，将任意两个元素对调，其余元素不动，这种作出新排列的方式叫作对换
    - 相邻对换
        - 定义：将相邻的两个元素对换，叫做相邻对换
    - 定理：一个排列中的任意两个元素对换，排列改变奇偶性
        - 推论：奇排列对换成标准排列的次数为奇数，偶排列为偶数

### §1.3 $n$ 阶行列式的定义

- $n$ 阶行列式
    - 定义：设有 $n^2$ 个数，排成 $n$ 行 $n$ 列的数表：
        $$
        \begin{matrix}
            a_{11} & a_{12} & \cdots & a_{1n}\\
            a_{21} & a_{22} & \cdots & a_{2n}\\
            \vdots & \vdots &  & \vdots\\
            a_{n1} & a_{n2} & \cdots & a_{nn}
        \end{matrix}
        $$
        作出表中位于不同行不同列的 $n$ 个数的乘积，并冠以符号 $(-1)^t$，得到项：
        $$(-1)^t a_{1p_1}a_{2p_2}···a_{np_n} \qquad (1)$$
        其中：
        - $p_1p_2···p_n$ 为自然数 $1,2,···,n$ 的一个排列
        - $t$ 为该排列的逆序数
        因为该排列共有 $n!$ 种，故所有这 $n!$ 个形如 $(1)$ 式的项的代数和：
        $$\sum (-1)^t a_{1p_1}a_{2p_2}···a_{np_n}$$
        称为 $n$ 阶行列式，记作：
        $$
        D=
        \begin{vmatrix}
            a_{11} & a_{12} & \cdots & a_{1n}\\
            a_{21} & a_{22} & \cdots & a_{2n}\\
            a_{31} & a_{32} & \cdots & a_{3n}\\
            \vdots & \vdots &  & \vdots\\
            a_{n1} & a_{n2} & \cdots & a_{nn}
        \end{vmatrix}
        $$
        简记作 $\det(a_{ij})$，其中 $a_{ij}$ 为行列式 $D$ 的 $(i,j)$ 元
    - 三角行列式
        - 下三角行列式
            $$
            \begin{vmatrix}
            a_{11} \\
            a_{21} & a_{22} \\
            \vdots & \vdots & \ddots & \\
            a_{n1} & a_{n2} & \cdots & a_{nn}\\
            \end{vmatrix} =a_{11}a_{22} \cdots a_{nn}
            $$
        - 上三角行列式
            $$
            \begin{vmatrix}
            a_{11} & a_{12} & \cdots & a_{1n}\\
                   & a_{22} & \cdots & a_{2n}\\
                   &        & \ddots & \vdots\\
                   &        &        & a_{nn}\\
            \end{vmatrix} =a_{11}a_{22} \cdots a_{nn}
            $$
    - 对角行列式
        - 定义：主对角线以下和以上的元素都为 $0$ 的行列式叫做<u>对角行列式</u>
            $$
            \begin{vmatrix}
            a_{11} & \\
                   & a_{22} & \\
                   &        & a_{33} \\
                   &        &        & \ddots \\
                   &        &        &        & a_{nn}
            \end{vmatrix} =a_{11}a_{22} \cdots a_{nn}
            $$
        - 其同样等于对角线的积    
    - 说明：以上的上（下）三角行列式与对角行列式都是按照主对角线进行的，如果按照副（次）对角线排列我们得到的结果需要判断正负号，即：$(-1)^t,t=\frac{n(n-1)}{2}.$
    
### §1.4 行列式的性质
- 转置行列式
    - 定义：将原有行列式 $D$ 所有元素的行标和列标对换得到行列式 $D^T$
    $$
    D=
    \begin{vmatrix}
        a_{11} & a_{12} & \cdots & a_{1n}\\
        a_{21} & a_{22} & \cdots & a_{2n}\\
        a_{31} & a_{32} & \cdots & a_{3n}\\
        \vdots & \vdots &  & \vdots\\
        a_{n1} & a_{n2} & \cdots & a_{nn}
    \end{vmatrix} \qquad
    D^T=
    \begin{vmatrix}
        a_{11} & a_{21} & \cdots & a_{n1}\\
        a_{12} & a_{22} & \cdots & a_{n2}\\
        a_{13} & a_{23} & \cdots & a_{n3}\\
        \vdots & \vdots &  & \vdots\\
        a_{1n} & a_{2n} & \cdots & a_{nn}
    \end{vmatrix}
    $$
    行列式 $D^T$ 称为行列式 D 的转置行列式
1. **性质：行列式与它的转置行列式相等**
    - 结论：行列式中的行与列具有同等的地位，行列式的性质凡是对行成立的对列也同样成立，反之亦然
2. **性质：对换行列式的两行（列），行列式变号**
    - 推论：如果行列式有两行（列）完全相同，则此行列式等于零
3. **性质：行列式的某一行（列）中所有的元素都乘同一数 $k$，等于用数 $k$ 乘此行列式**
    - 推论：行列式中某一行（列）的所有元素的公因子可以提到行列式记号的外面
4. **性质：行列式中如果有两行（列）元素成比例，则此行列式等于 $0$**
5. **性质：若行列式的某一行（列）的元素都是两数之和，例如某行列式第 $i$ 行：**
    $$
    D=
    \begin{vmatrix}
        a_{11} & a_{12} & \cdots & a_{1n}\\
        \vdots & \vdots &        & \vdots\\
        a_{i1}+a'_{i1} & a_{i2}+a'_{i2} & \cdots & a_{i3}+a'_{i3}\\
        \vdots & \vdots &        & \vdots\\
        a_{n1} & a_{n2} & \cdots & a_{nn}
    \end{vmatrix}
    $$
    **则该行列式等于以下两个行列式之和，即**
    $$
    D=
    \begin{vmatrix}
        a_{11} & a_{12} & \cdots & a_{1n}\\
        \vdots & \vdots &        & \vdots\\
        a_{i1} & a_{i2} & \cdots & a_{in}\\
        \vdots & \vdots &        & \vdots\\
        a_{n1} & a_{n2} & \cdots & a_{nn}
    \end{vmatrix} +
    \begin{vmatrix}
        a_{11} & a_{12} & \cdots & a_{1n}\\
        \vdots & \vdots &        & \vdots\\
        a'_{i1} & a'_{i2} & \cdots & a'_{in}\\
        \vdots & \vdots &        & \vdots\\
        a_{n1} & a_{n2} & \cdots & a_{nn}
    \end{vmatrix}
    $$
6. **性质：把行列式的某一行（列） $i$ 的各个元素乘以同一个数 $k$ 然后加到另一行 $j$ 上（记作 $r_j+kr_i$），行列式不变，即：**
    $$
    \begin{vmatrix}
        a_{11} & a_{12} & \cdots & a_{1n}\\
        \vdots & \vdots &        & \vdots\\
        a_{i1} & a_{i2} & \cdots & a_{in}\\
        \vdots & \vdots &        & \vdots\\
        a_{j1} & a_{j2} & \cdots & a_{jn}\\
        \vdots & \vdots &        & \vdots\\
        a_{n1} & a_{n2} & \cdots & a_{nn}
    \end{vmatrix}
    \xlongequal{r_j+kr_i}
    \begin{vmatrix}
        a_{11} & a_{12} & \cdots & a_{1n}\\
        \vdots & \vdots &        & \vdots\\
        a_{i1} & a_{i2} & \cdots & a_{in}\\
        \vdots & \vdots &        & \vdots\\
        a_{j1}+ka_{i1} & a_{j2}+ka_{i2} & \cdots & a_{jn}+ka_{in}\\
        \vdots & \vdots &        & \vdots\\
        a_{n1} & a_{n2} & \cdots & a_{nn}
    \end{vmatrix} \quad (i \neq j)
    $$

### §1.5 行列式按行（列）展开

- 余子式和代数余子式
    - 定义：在 $n$ 阶行列式中,把 $(i，j)$ 元 $a_{ij}$ 所在的第 $i$ 行和第 $j$ 列划去后，留下来的 $n-1$ 阶行列式叫做 $(i,j)$ 元 $a_{ij}$ 的 **余子式**,叫作 $M_{ij}$,记：
     $$A_{ij}=(-1)^{i+j}M_{ij}$$
    $A_{ij}$叫做 $(i，j)$ 元 $a_{ij}$ 的 **代数余子式**
- 引理：引理 一个 $n$ 阶行列式，如果其中第 $i$ 行所有元素除 $(i，j)$ 元 $a_{ij}$ 外都为零，那么这行列式等于 $a_{ij}$ 与它的代数余子式的乘积，即
 $$D=a_{ij}A_{ij}$$
- 定理2： 行列式等于它的任一行（列）的各元素与其对应的代数余子式乘积之和,即 
$$D=a_{i1}A_{i1}+a_{i2}A_{i2}+a_{i3}A_{i3}+ \cdots +a_{in}A_{in}$$
或
$$D=a_{1j}A_{1j}+a_{2j}A_{2j}+a_{3j}A_{3j}+ \cdots +a_{nj}A_{nj}$$
这叫做**行列式按行（列）展开法则**
- 异乘变零：行列式某一行(列)的元素与另一行(列)的对应元素的代数余子式乘积之和等于零 **(该元素与不是该元素本身的代数余子式相乘等于)**，即
$$a_{i1}A_{j1} + a_{i2}A_{j2} + \cdots + a_{in}A_{jn}= 0,i \ne j$$
或
$$a_{1i}A_{1j} + a_{2i}A_{2j} + \cdots + a_{ni}A_{nj}= 0,i \ne j$$
- **代数余子式重要性质**
$$\sum_{k=1}^n a_{ki}A_{kj}
\begin{cases}
            D, \qquad 当i=j\\
            0, \qquad 当 i\ne j\\
\end{cases}$$
或
$$\sum_{k=1}^n a_{ik}A_{jk}
\begin{cases}
            D, \qquad 当i=j\\
            0, \qquad 当 i\ne j\\
\end{cases}$$

## 第二章 矩阵及其运算

### §2.1 线性方程组和矩阵

- 线性方程组
    - $n$ 元非齐次线性方程组
        - 设有 $n$ 个未知数 $m$ 个方程的线性方程组
            $$
            \begin{cases}
                a_{11}x_1+a_{12}x_2+\cdots+a_{1n}x_n=b_1\\
                a_{21}x_1+a_{22}x_2+\cdots+a_{2n}x_n=b_2\\
                \cdots~\cdots~\cdots~\cdots\\
                a_{m1}x_1+a_{m2}x_2+\cdots+a_{mn}x_n=b_n\\
            \end{cases}
            $$
            其中：
            - $a_{ij}$ 是第 $i$ 个方程的第 $j$ 个未知数的系数
            - $b_i$ 是第 $i$ 个方程的常数项
            - $i=1,2,\cdots,m$ $j=1,2,\cdots,n$
            常数项 $b_1,b_2,\cdots,b_m$ 不全为零时，该线性方程组叫做 $n$ 元非齐次线性方程组
    - $n$ 元齐次线性方程组
        - 设有 $n$ 个未知数 $m$ 个方程的线性方程组
            $$
            \begin{cases}
                a_{11}x_1+a_{12}x_2+\cdots+a_{1n}x_n=0\\
                a_{21}x_1+a_{22}x_2+\cdots+a_{2n}x_n=0\\
                \cdots\cdots\cdots\cdots\\
                a_{m1}x_1+a_{m2}x_2+\cdots+a_{mn}x_n=0\\
            \end{cases}
            $$
            这种方程组叫做 $n$ 元齐次线性方程组
        - 零解：对于 $n$ 元齐次线性方程组，$x_1=x_2=\cdots=x_n=0$ 一定是它的解，这个解叫做齐次线性方程组的零解
        - 非零解：如果一组不全为零的数是该方程组的解，则它叫做齐次线性方程组的非零解
    - 线性方程组的矩形数表
        - 将线性方程组的系数 $a_{ij}(i=1,2,\cdots,m;j=1,2,\cdots,n)$ 和常数项 $b_1,b_2,\cdots,b_m$ 按照其在线性方程组中的排列构成 $m$ 行 $n$ 列的数表：
        $$
        \begin{matrix}
            a_{11} & a_{12} & \cdots & a_{1n} & b_1\\
            a_{21} & a_{22} & \cdots & a_{2n} & b_2\\
            \vdots & \vdots &        & \vdots & \vdots\\
            a_{m1} & a_{m2} & \cdots & a_{mn} & b_m\\
        \end{matrix}
        $$
        由此引出矩阵概念
- 矩阵
    - 定义
        - 由 $m\times n$ 个数 $a_{ij} (i=1,2,\cdots,m;j=1,2,\cdots,n)$ 排成的 $m$ 行 $n$ 列的数表，称为 $m$ 行 $n$ 列矩阵，简称 $m\times n$ 矩阵，为表示它是一个整体，总是加一个括弧，并用大写黑体字母表示它，记作：
            $$
            \bm{A}=
            \begin{pmatrix}
                a_{11} & a_{12} & \cdots & a_{1n}\\
                a_{21} & a_{22} & \cdots & a_{2n}\\
                \vdots & \vdots &        & \vdots\\
                a_{m1} & a_{m2} & \cdots & a_{mn}\\
            \end{pmatrix}
            $$
            其中：
            - 括号内的任意一个数都称为矩阵 $\bm{A}$ 的元素，简称元
            - 数 $a_{ij}$ 位于矩阵 $\bm{A}$ 的第 $i$ 行第 $j$ 列，称为矩阵 $\bm{A}$ 的 $(i,j)$ 元
            - 以数 $a_{ij}$ 为 $(i,j)$ 元的矩阵可简记作 $(a_{ij})$ 或$(a_{ij})_{m\times n}$. $m\times n$ 矩阵 $\bm{A}$ 也记作 $\bm{A}_{m\times n}$
    - 矩阵同型
        - 定义：两个矩阵的行数相等、列数也相等时，就称它们是同型矩阵
        - 矩阵相等：
            - 定义：如果 $\bm{A}=(a_{ij})$ j与 $\bm{B}=(b_{ij})$ 是同型矩阵，并且它们的对应元素相等，即
                $$a_{ij}=b_{ij}(i=1,2,\cdots,n;j=1,2,\cdots,n)$$
                那么就称矩阵 $\bm{A}$ 与矩阵 $\bm{B}$ 相等，记作 $\bm{A}=\bm{B}$
    - 线性变换
        - 定义：$n$ 个变量 $x_1,x_2,\cdots,x_n$ 与 $m$ 个变量 $y_1,y_2,\cdots,y_m$ 之间的关系式
            $$
            \begin{cases}
                y_1=a_{11}x_1+a_{12}x_2+\cdots+a_{1n}x_n\\
                y_2=a_{21}x_1+a_{22}x_2+\cdots+a_{2n}x_n\\
                \cdots\cdots\cdots\cdots\\
                y_m=a_{m1}x_1+a_{m2}x_2+\cdots+a_{mn}x_n\\
            \end{cases}\qquad(3)
            $$
            表示一个从变量 $x_1,x_2,\cdots,x_n$ 到变量 $y_1,y_2,\cdots,y_m$ 的线性变换，其中 $a_{ij}$ 为常数，线性变换 $(3)$ 的系数 $a_{ij}$ 构成矩阵 $\bm{A}=(a_{ij})_{m\times n}$
        - 给定了线性变换 $(3)$，它的系数所构成的矩阵（称为系数矩阵）也就确定；反之，如果给出一个矩阵作为线性变换的系数矩阵，则线性变换也就确定。在这个意义上，线性变换和矩阵之间存在着一一对应的关系 
    - 矩阵类别
        - 零矩阵：元素都是零的矩阵，注意不同型的零矩阵是不同的
        - 实矩阵：元素是实数的矩阵
        - 复矩阵：元素是复数的矩阵
        - 行矩阵（行向量）：只有一行的矩阵
        - 列矩阵（列向量）：只有一列的矩阵
        - $n$ 阶矩阵（$n$ 阶方阵）：行数与列数都等于 $n$ 的矩阵
        - 系数矩阵：由线性方程组的系数按照其在方程组中的排列得来的矩阵
        - 未知数矩阵：由线性方程组的未知数按照其在方程组中的排列得来的矩阵
        - 常数项矩阵：由线性方程组的常数项按照其在方程组中的排列得来的矩阵
        - 增广矩阵：由线性方程组的系数和常数项按照其在方程组中的排列得来的矩阵
        - 对角矩阵：从左上角到右下角的直线（叫做对角线）以外的元素都是 0.这种方阵称为对角矩阵，简称对角阵，记作 $\Lambda$
            - 单位矩阵：特别当对角线上的元素都为 1 的对角矩阵叫做单位矩阵，其线性变换叫恒等变换，记作 $\bm{E}$
    

### §2.2 矩阵的运算
[林鹏版](#林鹏版)
[Tolia版](#tolia-版)

#### 林鹏版
- 矩阵的加法
    - 定义 2：设有两个 $m×n$ 阵 $A=(a_{ij})$ 和 $B=(b_{ij}$)，那么矩阵 $A$ 与 $B$ 的和记作 $A +B$，规定为：
    $$
    A+B=\begin{cases}
        a_{11}+b_{11}\quad a_{12}+b_{12}\quad \cdots \quad a_{1n}+b_{1n}\\
        a_{21}+b_{21}\quad a_{22}+b_{22}\quad \cdots \quad a_{2n}+b_{2n}\\
        a_{m1}+b_{m1}\quad a_{m2}+b_{m2}\quad \cdots \quad a_{mn}+b_{mn}\\
    \end{cases}
    $$

        >应该注意，只有当两个矩阵是同型矩阵时，这两个矩阵才能进行加法运算.
    矩阵加法满足下列运算规律（设 $A，B，C$ 都是 $m×n$ 矩阵）：
        （1） $A+B=B+A$；
        （2） $(A+B)+C=A+(B +C)$.
        - 设矩阵 $A=(a_{ij})$，记
        $$-A=-(a_{ij})$$ 
        - $-A$ 称为矩阵 $A$ 的负矩阵，显然有
        $$A+(-A)=O$$
        - 由此规定矩阵的减法为
    $$A-B=A+(-B)$$
- 数与矩阵相乘
    - 数λ与矩阵 A 的乘积记作λA 或 Aλ，规定为
    $$
    \lambda A=A\lambda=\begin{cases}
        \lambda a_{11}\quad \lambda a_{12}\quad \cdots \quad \lambda a_{1n}\\
        \lambda a_{21}\quad \lambda a_{22}\quad \cdots \quad \lambda a_{2n}\\
        \lambda a_{m1}\quad \lambda a_{m2}\quad \cdots \quad \lambda a_{mn}\\
    \end{cases}
    $$
        >数乘矩阵满足下列运算规律（设 $A、B$ 为 $m×n$ 矩阵，$λ、μ$ 为数）：
       （1）$(λμ)A=λ(μA)$；
       （2）$(λ+μ)A=λA+μA$；
       （3）$λ(A+B)=λA+λB$.
    - **矩阵加法与数乘矩阵统称为矩阵的线性运算.**
- 矩阵与矩阵相乘
    - 定义4 设 $A=(a_{ij})$ 是一个 $m×s$ 矩阵，$B= (b_{ij})$ 是一个 $s×n$ 矩阵，那么规定矩阵 $A$ 与矩阵 $B$ 的乘积是一个 $m×n$ 矩阵 $C=(c_{ij})$，其中
    $$c_{ij}=a_{i1}b_{1j}+a_{i2}b_{2j}+\cdots+a_{is}b_{sj}=\sum_{k=1}^na_{ik}b_{kj}$$
    并把乘积记作
    $$C=AB$$
    - 对于两个 $n$ 阶方阵 $A,B$，若 $AB$=$BA$，则称方阵 $A$ 与 $B$ 是可交换的.
    - 矩阵的乘法虽不满足交换律，但仍满足下列结合律和分配律（假设运算都是可行的）： 
    （1）$(AB)C=A(B C)$；
    （2）$λ(AB)$=(λA)B=A(λB)（其中λ为数）；
    （3）$A(B+C)=AB+AC,(B+C)A=BA+CA$.
    - 对于单位矩阵 E
    $$EA=AE=A$$
        - 单位矩阵 $E$ 在矩阵乘法中的作用类似于数1
        - 由 $(λE)A=λA，A(λE)=λA$，可知纯量阵 $λE$ 与矩阵 $A$ 的乘积等于数 $λ$ 与 $A$ 的乘积.当 $A$ 为 $n$ 阶方阵时，有
       $$(\lambda E_n)A_n=\lambda A_n=A_n(\lambda E_n)$$
       表明纯量阵λE 与任何同阶方阵都是可交换的.
        - 矩阵的幂
           - 设 A 是 n 阶方阵，定义
           $$A^1=A,A^2=A^1A^1,\cdots ,A^{k+1}=A^kA^1$$
           其中 k 为正整数，这就是说，$A^k$ 就是 $k$ 个 $A$ 连乘.显然只有方阵的幂才有意义
           - 由于矩阵乘法适合结合律，所以矩阵的幂满足以下运算规律：
            $$A^kA^l=A_{k+l},\quad (A^k)^l=A^{kl}$$
            矩阵乘法一般不满足交换律，所以对于两个 $n$ 阶矩阵 $A$ 与 $B$，一般说来$(A B)^k\ne A^kB^k$，只有当 $A$ 与 $B$ 可交换时，才有 $(AB)^k=A^kB^k$.类似可知，例如 $(A+B)^2=A^2+2AB+B^2、(A-B)(A+B)=A^2-B^2$ 等公式，也只有当 $A$ 与 $B$ 可交换时才成立.
- 矩阵的转置
    - 把矩阵 $A$ 的行换成同序数的列得到一个新矩阵，叫做 $A$ 的转置矩阵，记作 $A^T$
    - 矩阵的转置也是一种运算，满足下述运算规律（假设运算都是可行的）：
    （1）$(A^T)^T=A$
    （2）$(A+B)^T=A^T+B^T$
    （3）$(\lambda A)^T=\lambda A^T$
    （4）$(AB)^T=B^TA^T$
    - 设 $A$ 为 $n$ 阶方阵，如果满足 $A^T=A$，即$a_{ij}=a_{ji}(i,j=1，2,\cdots,n)$，那么 $A$ 称为对称矩阵，简称对称阵.对称矩阵的特点是：它的元素以对角线为对称轴对应相等
- 方阵的行列式
    - 定义6：由 $n$ 阶方阵 $A$ 的元素所构成的行列式（各元素的位置不变），称为方阵 $A$ 的行列式，记作 $det A$ 或 $|A|$.
    - 由 $A$ 确定 $|A|$ 的这个运算满足下述运算规律（设$A、B$ 为 $n$ 阶方阵，$\lambda$ 为数）： 
    （1）$|A^T|=|A|$(行列式性质1)
    （2）$|\lambda A|=\lambda^n|A|$
    （3）$|AB|=|A||B|$ 

#### Tolia 版

- 矩阵加法
    - 定义：设有两个 $m\times n$ 阵 $\bm{A}=(a_{ij})$ 和 $\bm{B}=(b_{ij})$，那么矩阵 $\bm{A}$ 与 $\bm{B}$ 的和记作 $\bm{A}+\bm{B}$，规定为
        $$
        \bm{A}+\bm{B}=
        \begin{pmatrix}
            a_{11}+b_{11} & a_{12}+b_{12} & \cdots & a_{1n}+b_{1n}\\
            a_{21}+b_{21} & a_{22}+b_{22} & \cdots & a_{2n}+b_{2n}\\
            \vdots & \vdots & & \vdots\\
            a_{m1}+b_{m1} & a_{m2}+b_{m2} & \cdots & a_{mn}+b_{mn}\\
        \end{pmatrix}
        $$
    - 限制：只有当两个矩阵是同型矩阵时，这两个矩阵才能进行加法运算
    - 运算法则
        1. $\bm{A}+\bm{B}=\bm{B}+\bm{A}$
        2. $(\bm{A}+\bm{B})+\bm{C}=\bm{A}+(\bm{B}+\bm{C})$
- 矩阵减法
    - 负矩阵：设矩阵 $\bm{A}=(a_{ij})$，记
        $$-\bm{A}=(-a_{ij})$$
        则 $-\bm{A}$ 称为 $\bm{A}$ 的负矩阵
        - 对于负矩阵，显然有
            $$\bm{A}+(-\bm{A})=\bm{O}$$
            其中 $\bm{O}$ 为与 $\bm{A},\bm{B}$ 同型的零矩阵
    - 定义：
        $$\bm{A}-\bm{B}=\bm{A}+(-\bm{B})$$
- 矩阵乘法
    - 数与矩阵相乘
        - 定义：数 $\lambda$ 与矩阵 $\bm{A}$ 的乘积记作 $\lambda\bm{A}$ 或 $\bm{A}\lambda$，规定为
            $$
            \lambda\bm{A}=\bm{A}\lambda=
            \begin{pmatrix}
                \lambda a_{11} & \lambda a_{12} & \cdots & \lambda a_{1n}\\
                \lambda a_{21} & \lambda a_{22} & \cdots & \lambda a_{2n}\\
                \vdots & \vdots & & \vdots\\
                \lambda a_{m1} & \lambda a_{m2} & \cdots & \lambda a_{mn}\\
            \end{pmatrix}
            $$
        - 运算法则：
            1. $(\lambda\mu)\bm{A}=\lambda(\mu\bm{A})$
            2. $(\lambda+\mu)\bm{A}=\lambda\bm{A}+\mu\bm{A}$
            3. $\lambda(\bm{A}+\bm{B})=\lambda\bm{A}+\lambda\bm{B}$
    - 矩阵与矩阵相乘
        - 引入：设有两个线性变换
            $$
            \begin{cases}
                y_1=a_{11}x_1+a_{12}x_2+a_{13}x_3\\
                y_2=a_{21}x_1+a_{22}x_2+a_{23}x_3\\
            \end{cases}\qquad(1)
            \begin{cases}
                x_1=b_{11}t_1+b_{12}t_2\\
                x_2=b_{21}t_1+b_{22}t_2\\
                x_3=b_{31}t_1+b_{32}t_2\\
            \end{cases}\qquad(2)
            $$
            若想求出从 $t1,t2$ 到 $y1,y2$ 的线性变换，可将 $(2)$ 代入 $(1)$，便得
            $$
            \begin{cases}
                y_1=(a_{11}b_{11}+a_{12}b_{21}+a_{13}b_{31})t_1+(a_{11}b_{12}+a_{12}b_{22}+a_{13}b_{32})t_2\\
                y_2=(a_{21}b_{11}+a_{22}b_{21}+a_{23}b_{31})t_1+(a_{21}b_{12}+a_{22}b_{22}+a_{23}b_{32})t_2\\
            \end{cases}
            $$
            将上述的线性变换写作矩阵可得：
            $$
            \begin{pmatrix}
                a_{11} & a_{12} & a_{13}\\
                a_{21} & a_{22} & a_{23}\\
            \end{pmatrix}
            \begin{pmatrix}
                b_{11} & b_{12}\\
                b_{21} & b_{22}\\
                b_{31} & b_{32}\\
            \end{pmatrix}\\=
            \begin{pmatrix}
                a_{11}b_{11}+a_{12}b_{21}+a_{13}b_{31} & a_{11}b_{12}+a_{12}b_{22}+a_{13}b_{32}\\
                a_{21}b_{11}+a_{22}b_{21}+a_{23}b_{31} & a_{21}b_{12}+a_{22}b_{22}+a_{23}b_{32}\\
            \end{pmatrix}
            $$
            由此引出矩阵乘法定义
        - 定义：设 $\bm{A}=(a_{ij})$ 是一个 $m\times s$ 矩阵，$\bm{B}=(b_{ij})$ 是一个 $s\times n$ 矩阵，那么规定矩阵 $\bm{A}$ 与矩阵 $\bm{B}$ 的乘积是一个 $m\times n$ 矩阵 $\bm{C}=(c_{ij})$，其中
            $$c_{ij}=a_{i1}b_{1j}+a_{i2}b_{2j}+\cdots+a_{is}b_{sj}\\=\sum_{k=1}^sa_{ik}b_{kj}(i=1,2,\cdots,m;j=1,2,\cdots,n)$$
            并把此乘积记作 $\bm{C}=\bm{AB}$
        - 限制：只有当第一个矩阵（左矩阵）的列数等于第二个矩阵（右矩阵）的行数时，两个矩阵才能相乘
        - 行矩阵与列矩阵的乘积
            - 特别地，根据定义，一个 $1\times s$ 的矩阵与一个 $s\times 1$ 的矩阵的乘积为一个一阶方阵
                $$
                \begin{pmatrix}
                    a_{i1} & a_{i2} & \cdots a_{is}
                \end{pmatrix}
                \begin{pmatrix}
                    b_{1j}\\
                    b_{2j}\\
                    \vdots\\
                    b_{sj}\\
                \end{pmatrix}\\=
                a_{i1}b_{1j}+a_{i2}b_{2j}+\cdots+a_{is}b_{sj}=\sum_{k=1}^sa_{ik}b_{kj}=c_{ij}
                $$
            由此表明乘积矩阵 $\bm{AB}=\bm{C}$  的 $(i,j)$ 元 $c_{ij}$ 就是 $\bm{A}$ 的第 $i$ 行与 $\bm{B}$ 的第 $j$ 列的乘积
        - 运算规则：
            1. $\bm{AB}\neq\bm{BA}$
            2. $(\bm{AB})\bm{C}=\bm{A}(\bm{BC})$
            3. $\lambda(\bm{AB})=(\lambda\bm{A})\bm{B}=\bm{A}(\lambda\bm{B})(其中\lambda为数)$
            4. $\bm{A}(\bm{B}+\bm{C})=\bm{AB}+\bm{AC}=(\bm{B}+\bm{C})\bm{A}=\bm{BA}+\bm{CA}$
        - 矩阵的幂
            - 设 $\bm{A}$ 为 $n$ 阶方阵，矩阵的幂运算定义如下：
                $$\bm{A}^1=\bm{A},~\bm{A}^2=\bm{A}^1\bm{A}^1,~\cdots,~\bm{A}^{k+1}=\bm{A}^k\bm{A}^1$$
            - 运算规则：
                1. $\bm{A}^k+\bm{A}^l=\bm{A}^{k+l}$
                2. $(\bm{A}^k)^l=\bm{A}^{kl}$
- 矩阵转置
    - 定义：把矩阵 $\bm{A}$ 的行换成同序数的列得到一个新矩阵，叫做 $\bm{A}$ 的转置矩阵，记作 $\bm{A}\rm{^T}$
        $$
        \bm{A}=
        \begin{pmatrix}
            a_{11} & a_{12} & \cdots & a_{1n}\\
            a_{21} & a_{22} & \cdots & a_{2n}\\
            \vdots & \vdots &        & \vdots\\
            a_{m1} & a_{m2} & \cdots & a_{mn}\\
        \end{pmatrix}
        \bm{A}\rm{^T}=
        \begin{pmatrix}
            a_{11} & a_{21} & \cdots & a_{m1}\\
            a_{12} & a_{22} & \cdots & a_{m2}\\
            \vdots & \vdots &        & \vdots\\
            a_{1n} & a_{2n} & \cdots & a_{mn}\\
        \end{pmatrix}
        $$
    - 运算法则
        1. $(\bm{A}\rm{^T})\rm{^T}=\bm{A}$
        2. $(\bm{A}+\bm{B})\rm{^T}=\bm{A}\rm{^T}+\bm{B}\rm{^T}$
        3. $(\lambda\bm{A})\rm{^T}=\lambda\bm{A}\rm{^T}$
        4. $(\bm{AB})\rm{^T}=\bm{B}\rm{^T}\bm{A}\rm{^T}$
- 方阵的行列式
    - 定义：由 $n$ 阶方阵 $\bm{A}$ 的元素所构成的行列式（各元素的位置不变），称为方阵 $\bm{A}$ 的行列式，记作 $\det\bm{A}$ 或 $|\bm{A}|$
    - 辨析：方阵与行列式是两个不同的概念，$n$ 阶方阵是 $n^2$ 个数按一定方式排成的数表，而 $n$ 阶行列式则是这些数（也就是数表 $\bm{A}$）按一定的运算法则所确定的一个数
    - 运算规律：
        1. $|\bm{A}\rm{^T}|=\bm{A}$ （根据行列式性质 1）
        2. $|\lambda\bm{A}|=\lambda^n|\bm{A}|$
        3. $|\bm{AB}|=|\bm{A}||\bm{B}|$
    - 伴随矩阵
        - 定义：行列式 $\bm{A}$ 的各个元素的代数余子式 $A_{ij}$ 所构成的如下的矩阵
            $$
            A^*
            \begin{pmatrix}
                A_{11} & A_{12} & \cdots & A_{1n}\\
                A_{21} & A_{22} & \cdots & A_{2n}\\
                \vdots & \vdots &        & \vdots\\
                A_{m1} & A_{m2} & \cdots & A_{mn}\\
            \end{pmatrix}
            $$
            称为矩阵 $\bm{A}$ 的伴随矩阵，简称伴随阵

### §2.3 逆矩阵

- 逆矩阵
    - 引入：在数的乘法中，对不等于零的数 $a$ 总存在惟一的数 $b$，使 $ab=ba=1$，此数 $b$ 即是 $a$ 的倒数，利用倒数，数的除法可转化为乘积的形式，矩阵也类似
    - 定义：对于 $n$ 阶矩阵 $\bm{A}$，如果有一个 $n$ 阶矩阵 $\bm{B}$，使
        $$\bm{AB}=\bm{BA}=\bm{E}$$
        其中 $\bm{E}$ 为单位矩阵，则说矩阵 $\bm{A}$ 是可逆的，并把矩阵 $\bm{B}$ 称为 $\bm{A}$ 的逆矩阵，简称逆阵，记作 $\bm{A}^{-1}$，
    - 性质
        - 如果矩阵 $\bm{A}$ 是可逆的，那么 $\bm{A}$ 的逆矩阵是唯一的
        - 若矩阵 $\bm{A}$ 可逆，则 $\bm{A}\neq 0$
        - 若 $\bm{A}\neq 0$，则矩阵 $\bm{A}$ 可逆，且
            $$\bm{A}^{-1}=\frac{1}{\bm{|A|}}\bm{A}^*$$
            其中 $\bm{A}^*$ 为矩阵 $\bm{A}$ 的伴随矩阵
        - 若 $\bm{A}\neq 0$，则矩阵 $\bm{A}$ 为非奇异矩阵
        - 推论：若 $\bm{AB}=\bm{E}$ （或  $\bm{BA}=\bm{E}$），则 $\bm{B}=\bm{A}^{-1}$
    - 奇异矩阵：当 $\bm{A} = 0$ 时，$\bm{A}$ 称为奇异矩阵
    - 非奇异矩阵： 当 $\bm{A}\neq 0$ 时，$\bm{A}$ 称为非奇异矩阵
    - 运算规律
        1. 若 $\bm{A}$ 可逆，则 $\bm{A}^{-1}$ 亦可逆，且 $(\bm{A}^{-1})^{-1}=\bm{A}$ 
        2. 若 $\bm{A}$ 可逆，数 $\lambda\neq 0$，则 $\lambda\bm{A}$ 可逆，且 $(\lambda\bm{A})^{-1}=\frac{1}{\lambda}\bm{A}^{-1}$
        3. 若 $\bm{A}$ 、 $\bm{B}$ 为同阶矩阵且均可逆，则  $\bm{AB}$ 亦可逆，且 $(\bm{AB}^{-1})=\bm{B}^{-1}\bm{A}^{-1}$
 
 ### §2.4 克拉默法则

- 定义
    $$
    \begin{cases}
        a_{11}x_1+a_{12}x_2+\cdots+a_{1n}x_n=b_1\\
        a_{12}x_1+a_{22}x_2+\cdots+a_{2n}x_n=b_2\\
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\cdots \\
        a_{n1}x_1+a_{n2}x_2+\cdots+a_{nn}x_n=b_n\\
    \end{cases}\qquad(1)
    $$
    
    - 如果线性方程组 $(1)$ 的系数矩阵 $A$ 的行列式不等于零，即
    $$
    \bm A=
    \begin{vmatrix}
        a_{11} &\cdots & a_{1n}\\
       \vdots & &\vdots\\
        a_{m1} &  \cdots & a_{mn}\\
    \end{vmatrix} \ne 0
    $$
    那么方程组（9）有唯一解
    $$x_1=\frac{|A_1|}{|A|},x_2=\frac{|A_2|}{|A|},\cdots, x_n=\frac{|A_n|}{|A|}$$
    其中 $A_j(j=1,2,\cdots,n)$ 是把系数矩阵 $A$ 中第 $j$ 列的元素用方程组右端的常数项代替后所得到的 $n$ 阶矩阵，即
    $$
    \bm A_j=
    \begin{pmatrix}
        a_{11} &\cdots & a_{1,j-1} & b_1 & a_{1,j+1}& \cdots & a_{1n}\\
        \vdots & & \vdots & \vdots & \vdots & & \vdots\\
        a_{n1} & \cdots & a_{n,j-1} & b_n & a_{n,j+1} & \cdots & a_{nn}\\
    \end{pmatrix}
    $$
- 意义
    1. 克拉默法则可视为行列式的一个应用，又可看作逆矩阵的一个应用
    2. 它解决的是方程个数与未知数个数相等并且系数行列式不等于零的线性方程组。所以它既是第 1 章例 1 中用二阶行列式求解方程组的推广，又是求解一般线性方程组的一个特殊的情形

### §2.5 矩阵分块法

- 概念：对于行数和列数较高的矩阵 $\bm{A}$，运算时常采用分块法，使大矩阵的运算化成小矩阵的运算
- 定义：将矩阵 $\bm{A}$ 用若干条纵线和横线分成许多个小矩阵，每一个小矩阵称为 $\bm{A}$ 的子块，以子块为元素的形式上的矩阵称为分块矩阵
- 运算规则：与普通矩阵运算规则相类似
    - 矩阵加法：设矩阵 $\bm{A}$ 与 $\bm{B}$ 的行数列数相同，均采用相同的分块法：
        $$
        \bm{A}=\begin{pmatrix}
            \bm{A}_{11} & \cdots & \bm{A}_{1r}\\
            \vdots &        & \vdots\\
            \bm{A}_{s1} & \cdots & \bm{A}_{sr}\\
        \end{pmatrix},
        \bm{B}=\begin{pmatrix}
            \bm{B}_{11} & \cdots & \bm{B}_{1r}\\
            \vdots &        & \vdots\\
            \bm{B}_{s1} & \cdots & \bm{B}_{sr}\\
        \end{pmatrix}
        $$

        $$
        \bm{A}+\bm{B}=\begin{pmatrix}
            \bm{A}_{11}+\bm{B}_{11} & \cdots & \bm{A}_{1r}+\bm{B}_{1r}\\
            \vdots &        & \vdots\\
            \bm{A}_{s1}+\bm{B}_{s1} & \cdots & \bm{A}_{sr}+\bm{B}_{s1}\\
        \end{pmatrix}
        $$
    - 矩阵乘法：
        - 矩阵乘以常数：设矩阵 $A$ 与一常数 $\lambda$
            $$
            \bm{A}=\begin{pmatrix}
                \bm{A}_{11} & \cdots & \bm{A}_{1r}\\
                \vdots &        & \vdots\\
                \bm{A}_{s1} & \cdots & \bm{A}_{sr}\\
            \end{pmatrix}\\
            $$

            $$
            \lambda\bm{A}=\begin{pmatrix}
                \lambda\bm{A}_{11} & \cdots & \lambda\bm{A}_{1r}\\
                \vdots &        & \vdots\\
                \lambda\bm{A}_{s1} & \cdots & \lambda\bm{A}_{sr}\\
            \end{pmatrix}
            $$
        - 矩阵乘以矩阵：设 $\bm A$ 为 $m\times l$ 矩阵，$\bm B$ 为$l\times n$ 矩阵，分块成
            $$
            \bm{A}=\begin{pmatrix}
                \bm{A}_{11} & \cdots & \bm{A}_{1r}\\
                \vdots &        & \vdots\\
                \bm{A}_{s1} & \cdots & \bm{A}_{sr}\\
            \end{pmatrix},
            \bm{B}=\begin{pmatrix}
                \bm{B}_{11} & \cdots & \bm{B}_{1r}\\
                \vdots &        & \vdots\\
                \bm{B}_{s1} & \cdots & \bm{B}_{sr}\\
            \end{pmatrix}
            $$
            其中 $\bm A_{i1},\bm A_{i2},\cdots,\bm A_{it}$ 的列数分别等于 $\bm B_{1j},\bm B_{2j},\cdots,\bm B_{tj}$ 的行数，那么
            $$
            \bm{AB}=\begin{pmatrix}
                \bm{C}_{11} & \cdots & \bm{C}_{1r}\\
                \vdots &        & \vdots\\
                \bm{C}_{s1} & \cdots & \bm{C}_{sr}\\
            \end{pmatrix}
            $$
            其中
            $$\bm C_{ij}=\sum_{k=1}^t\bm A_{ik}\bm B_{kj}\quad(i=1,\cdots,s;j=1,\cdots,r)$$
    - 矩阵转置：设分块矩阵 $\bm A$
        $$
        \bm{A}=\begin{pmatrix}
            \bm{A}_{11} & \cdots & \bm{A}_{1r}\\
            \vdots &        & \vdots\\
            \bm{A}_{s1} & \cdots & \bm{A}_{sr}\\
        \end{pmatrix}
        $$
        则 
        $$
        \bm A\rm{^T}=
        \begin{pmatrix}
            \bm{A}\rm{^T}_{11} & \cdots & \bm{A}\rm{^T}_{1r}\\
            \vdots &        & \vdots\\
            \bm{A}\rm{^T}_{s1} & \cdots & \bm{A}\rm{^T}_{sr}\\
        \end{pmatrix}
        $$
- 分块对角矩阵：
    - 定义：设 $n$ 阶分块矩阵 $\bm A$
        $$
        \begin{pmatrix}
            \bm{A}_{11} &  & \bm O\\
            &    \ddots    & \\
            \bm O &  & \bm{A}_{nn}\\
        \end{pmatrix}
        $$
        那么称 $\bm A$ 为**分块对角矩阵**
    - 性质：分块对角矩阵的行列式具有下述性质
        - $$|\bm A|=|\bm A_{11}||\bm A_{22}|\cdots|\bm A_{nn}|$$
        - 若 $|\bm A_{ii}|\neq 0~(i=1,2,\cdots,n)$，则$|\bm A|\neq 1$，并有：
        $$
        \bm{A}^{-1}=\begin{pmatrix}
            \bm{A}^{-1}_{11} &  & \bm{O}\\
            & \ddots &\\
            &  & \bm{A}^{-1}_{nn}\\
        \end{pmatrix},
            $$


## 第三章 矩阵的初等变换与线性方程组

### 第一节 矩阵的初等变换

- 初等行变换与初等列变换及其逆变换
    - 下面三种变换称为矩阵的**初等行变换**：
        - 1.对换两行（对换 $i，j$ 两行，记作 $r_i\leftrightarrow r_j$），其逆变换就是本身；
        - 2.以数 $k\ne 0$ 乘某一行中的所有元（第 $i$ 行乘 $k$，记作 $r_i×k$），其逆变换为 $r_i×\frac{1}{k}$;
        - 3.把某一行所有元的 $k$ 倍加到另一行对应的元上去（第 $j$ 行的 $k$ 倍加到第 $i$ 行上，记作 $r_i +kr_j$）,其逆变换为 $r_i+(-k)r_j$
    - 把定义中的“行”换成“列”，即得矩阵的**初等列变换**的定义（所用记号是把“r”换成“c”）.
    - **矩阵的初等行变换与初等列变换，统称初等变换**
- 矩阵的等价
    - 由**初等行变换**得到：如果矩阵 $A$ 经有限次初等行变换变成矩阵 $B$，就称矩阵 $A$ 与 $B$ 行等价，记作
    - 由**初等列变换**得到：如果矩阵 $A$ 经有限次初等列变换变成矩阵 $B$，就称矩阵 $A$ 与 $B$ 列等价，记作
    - 由**初等变换**得到：如果矩阵 $A$ 经有限次初等变换变成矩阵 $B$，就称矩阵 $A$ 与 $B$ 等价，记作: $A\sim B$
    - 特点
        - 1.反身性 $A\sim B$；
        - 2.对称性 若 $A\sim B$，则 $B\sim B$；
        - 3.传递性 若 $A\sim B$，$B\sim B$，则 $A\sim C$
- 行阶梯形矩阵
    - 若非零矩阵满足以下，则为行阶梯形矩阵
        - 1.非零行在零行的上面；
        - 2.非零行的首非零元所在列在上一行（如果存在的话）的首非零元所在列的右面
- 最简行列式
    - 进一步，若 A 是行阶梯形矩阵，并且还满足：
        - 1.非零行的首非零元为1；
        - 2.首非零元所在的列的其他元均为0，
    则称 $A$ 为行最简形矩阵
- 标准型
    - 左上角为单位矩阵, 其余子块为0 的分块矩阵
- 矩阵的初等变换的基本性质
设 A 与 B 为 m×n 矩阵，那；
    - 1. 的充分必要条件是存在 $m$ 阶可逆矩阵 $P$，使 $PA=B$;
    - 2.$A\sim B$ 的充分必要条件是存在 $n$ 阶可逆矩阵 $Q$，使 $AQ=B$；
    - 3.$A\sim B$ 的充分必要条件是存在 $m$ 阶可逆矩阵 $P$ 及 $n$ 阶可逆矩阵 $Q$，使 $PAQ=B$.
- 初等变换的运算 
    - 设 $A$ 是一个 $m×n$ 矩阵，对 $A$ 施行一次初等行变换，相当于在 $A$ 的左边乘相应的 $m$ 阶初等矩阵；
    - 对 $A$ 施行一次初等列变换，相当于在 $A$ 的右边乘相应的 $n$ 阶初等矩阵.
- 方阵的可逆
    - 方阵 $A$ 可逆的充分必要条件是存在有限个初等矩阵 $P_1,P_2,\cdots ,P_l$，使 $A=P_1P_2\cdots P_l$
    - 推论：方阵 A 可逆的充分必要条件是 

## 第3章　矩阵的初等变换与线性方程组

### 第一节 矩阵的初等变换

- 初等变换
    - 初等行（列）变换
        1. 对换两行（列）（对换 $i,j$ 两行，记作 $r_i\leftrightarrow r_j$；对换 $i,j$ 两列，记作 $c_i\leftrightarrow c_j$）
        2. 以数 $k\neq0$ 乘某一行（列）中的所有元（第 $i$ 行乘 $k$，记作 $r_i\cdot k$；第 $i$ 列乘 $k$，记作 $c_i\cdot k$）
        3. 把某一行所有元的 $k$ 倍加到另一行（列）对应的元上去（第 $j$ 行的 $k$ 倍加到 第 $i$ 行上，记作 $r_i+kr_j$）
    - 定义：矩阵的初等行变换与初等列变换，统称初等变换 
    - 矩阵等价
        - 定义：
            - 如果矩阵 $\bm{A}$经有限次初等行变换变成矩阵 $\bm{B}$，就称矩阵 $\bm{A}$ 与 $\bm{B}$行等价，记作 $\bm{A}\overset{r}{\sim}\bm{B}$
            - 如果矩阵 $\bm{A}$ 经有限次初等列变换变成矩阵 $\bm{B}$，就称矩阵 $\bm{A}$ 与 $\bm{B}$ 列等价，记作 $\bm{A}\overset{c}{\sim} \bm{B}$
            - 如果矩阵 $\bm{A}$ 经有限次初等变换变成矩阵 $\bm{B}$，就称矩阵 $\bm{A}$ 与 $\bm{B}$ 等价，记作 $\bm{A}～\bm{B}$
        - 等价性质
            1. 反身性：$\bm{A}\sim  \bm{A}$
            2. 对称性：若 $\bm{A}\sim\bm{B}$，则 $\bm{B}\sim\bm{A}$
            3. 传递性：若 $\bm{A}\sim\bm{B},\bm{B}\sim \bm{C}$，则 $\bm{A}\sim\bm{C}$
    - 行阶梯形矩阵
        $$
        \begin{pmatrix}
            1 & 3 & -1 & 2 & 4\\
            0 & 1 & -1 & 1 & 3\\
            0 & 0 & 0 & 1 & -3\\
            0 & 0 & 0 & 0 & 0\\
        \end{pmatrix}
        $$
        像上述示例这样可画出一条从第一行某元左方的竖线开始到最后一列某元下方的横线结束的阶梯线，它的左下方的元全为0；<u>每段竖线的高度为一行</u>，竖线的右方的第一个元为**非零元**，称为**该非零行的首非零元**。具有这样特点的矩阵称为**行阶梯形矩阵**
        - 定义：非零矩阵若满足
            1. 非零行在零行的上面
            2. 非零行的首非 零元所在列在上一行（如果存在的话）的首非零元所在列的右面
             则称此矩阵为**行阶梯形矩阵**
        - 行最简形矩阵
            - 在行阶梯形矩阵的基础上，并且还满足：
                1. 非零行的首非零元为 1
                2. 首非零元所在的列的其他元均为 0
                则称为**行最简形矩阵**
                - 例如
                    $$
                    \begin{pmatrix}
                        1 & 0 & -1 & 0 & 4\\
                        0 & 1 & -1 & 0 & 3\\
                        0 & 0 & 0 & 1 & -3\\
                        0 & 0 & 0 & 0 & 0\\
                    \end{pmatrix}
                    $$
        - 标准形矩阵：对行最简形矩阵再施以初等列变换，可变成一种形状更简单的矩阵，称为标准形
    - 定理
        - 设 $\bm{A}$ 与 $\bm{B}$ 为 $m\times n$ 矩阵，那么
            1. $\bm{A}\overset{r}{\sim}\bm{B}$ 的充分必要条件是存在 $m$ 阶可逆矩阵 $\bm{P}$，使 $\bm{PA}=\bm{B}$； 
            2. $\bm{A}\overset{c}{\sim}\bm{B}$ 的充分必要条件是存在 $n$ 阶可逆矩阵 $\bm{Q}$，使 $\bm{AQ}=\bm{B}$； 
            3. $$\bm{A}\sim\bm{B}$$ 的充分必要条件是存在 $m$ 阶可逆矩阵 $P$ 及 $n$ 阶可逆矩阵 $\bm{Q}$，使 $\bm{PAQ}=\bm{B}$.
        - 推论
- 初等矩阵
    - 定义：由单位矩阵 $\bm E$ 经过一次初等变换得到的矩阵称为初等矩阵
    - 分类：三种初等变换对应有三种初等矩阵
        1. 把单位矩阵中第 $i,j$ 两行对换（或第 $i,j$ 两列对换），得初等矩阵
            $$
            \bm E(i,j)=
            \begin{pmatrix}
                1\\
                & \ddots\\
                & & 1\\
                & & & 0 & & \cdots&  & 1\\
                & & & & 1\\
                & & & \vdots & & \ddots & & \vdots\\
                & & & & & & 1\\
                & & & 1 & & \cdots & & 0\\
                & & & & & & & & 1\\
                & & & & & & & & & \ddots\\
                & & & & & & & & & & 1\\
            \end{pmatrix}
            \begin{aligned}
                \leftarrow 第~i~行\\
                \\
                \\
                \\
                \leftarrow 第~j~行\\
            \end{aligned}
            $$
            用 $m$ 阶初等矩阵 $\bm E_m(i,j)$ 左乘矩阵 $\bm A=(a_ij)_{m×n}$，得
            $$
            \bm E_m(i,j)\bm A=
            \begin{pmatrix}
                a_{11} & a_{12} & \cdots & a_{1n}\\
                \vdots & \vdots &        & \vdots\\
                a_{j1} & a_{j2} & \cdots & a_{jn}\\
                \vdots & \vdots &        & \vdots\\
                a_{i1} & a_{i2} & \cdots & a_{in}\\
                \vdots & \vdots &        & \vdots\\
                a_{m1} & a_{m2} & \cdots & a_{mn}\\
            \end{pmatrix}
            \begin{aligned}
                \leftarrow 第~i~行\\
                \\
                \leftarrow 第~j~行\\
            \end{aligned}
            $$
            其结果相当于对矩阵 $\bm A$ 施行第一种初等行变换：即把 $\bm A$ 的第 $i$ 行与第 $j$ 行对换（$r_i\leftrightarrow r_j$）
        2. 以数 $k\neq0$ 乘单位矩阵的第 $i$ 行（或第 $i$ 列），得初等矩阵
            $$
            \bm E(i(k))=
            \begin{pmatrix}
                1\\
                & \ddots\\
                & & 1\\
                & & & k\\
                & & & & 1\\
                & & & & & \ddots\\
                & & & & & & 1\\
            \end{pmatrix}
            \begin{aligned}
                \leftarrow 第~i~行
            \end{aligned}
            $$
            可以验知：
             - 以 $\bm E_m(i(k))$ 左乘矩阵 $\bm A$，其结果相当于以数 $k$ 乘 $\bm A$ 的第 $i$ 行 $(r_i\times k)$
             - 以 $\bm E_n(i(k))$ 右乘矩阵 $\bm A$，其结果相当于以数 $k$ 乘 $\bm A$ 的第 $i$ 列 $(c_i\times k)$
        3. 以k乘单位矩阵的第j行加到第i行上或以k乘单位矩阵的第i列加 到第j列上，得初等矩阵
            $$
            \bm E(ij(k))=
            \begin{pmatrix}
                1\\
                & \ddots\\
                & & 1 & \cdots & k\\
                & & & \ddots & \vdots\\
                & & & & 1\\
                & & & & & \ddots\\
                & & & & & & 1
            \end{pmatrix}
            \begin{aligned}
            \leftarrow 第~i~行\\
            \\
            \leftarrow 第~j~行\\
            \end{aligned}
            $$
            可以验知：
            - 以 $\bm E_m(ij(k))$ 左乘矩阵 $\bm A$，其结果相当于把 $\bm A$ 的第 $j$ 行乘 $k$ 加到第 $i$ 行上 $(r_i +kr_j)$
            - 以 $\bm E_n(ij(k))$右乘矩阵 $\bm A$，其结果相当于把 $\bm A$ 的第 $i$ 列乘 $k$ 加到第 $j$ 列上 $(c_j+kc_i)$
    - 性质
        1. 设 $\bm A$ 是一个 $m\times n$ 矩阵，对 $\bm A$ 施行一次初等行变换，相当于在 $\bm A$ 的 左边乘相应的 $m$ 阶初等矩阵；对 $\bm A$ 施行一次初等列变换，相当于在 $\bm A$ 的右边乘 相应的 $n$ 阶初等矩阵
        2. 初等矩阵都是可逆的，且其逆矩阵是同一类型的初等矩阵
           1. $\bm E(i,j)^{-1}=\bm E(i,j)$
           2. $\bm E(i(j))^{-1}=\bm E(i(\frac{1}{k}))$
           3. $\bm E(ij(k))^{-1}=\bm E(ij(-k))$
        3. 方阵 $\bm A$ 可逆的充分必要条件是存在有限个初等矩阵 $\bm P_1,\bm P_2,\cdots,\bm P_l$ 使 $\bm A =\bm P_1\bm P_2\cdots\bm P_l$
           推论：方阵 $\bm A$ 可逆的充分必要条件是 $\bm A\overset{r}{\sim}\bm E$
 
### 第二节 矩阵的秩

- $k$ 阶子式
    - 定义：在 $m\times n$ 矩阵 $\bm A$ 中，任取 $k$ 行与 $k$ 列$(k\le m，k\le n)$，位于这些行列交叉处的 $k^2$ 个元素，不改变它们在 $\bm A$ 中所处的位置次序而得的 $k$ 阶行列式，称为矩阵 $\bm A$ 的 $k$ 阶子式
    - 定理：$m\times n$ 矩阵 $\bm A$ 的 $k$ 阶子式共有 ${\rm C}^k_m\cdot{\rm C}^k_n$ 个
    - 引理：设 $\bm A\overset{r}{\sim}\bm B$ 则 $\bm A$ 与 $\bm B$ 中非零子式的最高阶数相等
- 矩阵的秩
    - 定义：设在矩阵 $\bm A$ 中有一个不等于 0 的 $r$ 阶子式 $\bm D$，且所有 $r+1$ 阶子式 （如果存在的话）全等于 0，那么 $\bm D$ 称为矩阵 $\bm A$ 的最高阶非零子式，数 $r$ 称为矩阵 $\bm A$ 的秩，记作 $R(\bm A)$。并规定零矩阵的秩等于 0
        > 由行列式的性质可知，在 $\bm A$ 中当所有 $r+1$ 阶子式全等于 0 时，所有高于 $r+1$ 阶的子式也全等于 0
        - 满秩矩阵与降秩矩阵
            - 定义：对于 $n$ 阶矩阵 $\bm A$，由于 $\bm A$ 的 $n$ 阶子式只有一个 $|\bm A|$，故当 $|\bm A|\neq0$ 时 $R(\bm A)=n$，当 $|\bm A|=0$ 时 $R(\bm A)<n$。可见可逆矩阵的秩等于矩阵的阶数，不可逆矩阵的秩小于矩阵的阶数。因此，可逆矩阵又称**满秩矩阵**，不可逆矩阵（奇异矩阵）又称**降秩矩阵**
            - 行（列）满秩矩阵：矩阵 $\bm A$ 的秩等于它的行（列）数，这样的矩阵称为行（列）满秩矩阵
            - 定理：设 $\bm{AB}=\bm O$，若 $\bm A$ 为列满秩矩阵，则 $\bm B=\bm O$
    - 定理：若 $\bm A\sim\bm B$，则 $R(\bm A)= R(\bm B)$
    - 推论：若可逆矩阵 $\bm P$、$\bm Q$ 使 $\bm {PAQ}=\bm B$，则 $R(\bm A)=R(\bm B)$
    - 矩阵求秩方法：对于一般的矩阵，当行数与列数较高时，按定义求秩是很麻烦的。然而对于行阶梯形矩阵，如前所示，它的秩就等于非零行的行数，一看便知毋须计算。因此依据上述定理把矩阵化为行阶梯形矩阵来求秩是方便而有效的方法
    - 性质
        1. $0\le R(\bm A_{m\times n})\le{\rm min}\{m,n\}$
        2. $R(\bm A^T)=R(\bm A)$
        3. 若 $\bm A\sim\bm B$，则 $R(\bm A)=R(\bm B)$
        4. 若 $\bm P$、$\bm Q$ 可逆，则 $R(\bm {PAQ})=R(\bm A)$
        5. ${\rm max}\{R(\bm A),R(\bm B)\}\le R(\bm A,\bm B)\le R(\bm A)+R(\bm B)$
            - 特别地，当 $\bm B=\bm b$ 为非零列向量时，有
            $R(\bm A)\le R(\bm A,\bm b)\le R(\bm A)+1$
        6. $R(\bm A+\bm B)\le R(\bm A)+R(\bm B)$
        7. $R(\bm{AB})\le {\rm min}\{R(\bm A),R(\bm B)\}$
        8. 若 $\bm A_{m×n}\bm B_{n×l}=\bm O$，则 $R(\bm A)+R(\bm B)\le n$