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

## [MainPage](../index.md)/[Mathematics](README.md)/Graphic Work

## Задание 1

Решить СЛАУ методом Гаусса (аналитически) и модифицированным методом Гаусса (ММГ)(посмотрите файл “численные методы”). Реализовать код для алгоритма ММГ и сравнить результаты численного и аналитического подхода.  
通过高斯方法（解析）和修正高斯方法 (ММГ) 求解线性代数方程组（SLAE）参见文件“数值方法”。 实现 ММГ 算法的代码并比较数值和解析方法的结果。

### 1.1

$$\begin{cases}
    3x-2y-3z=0\\
    x+5y+3z=1\\
    2x-3y-4z=3\\
\end{cases}$$

### 1.2

$$\begin{cases}
    2x+y+4z=-5\\
    x+3y-6z=2\\
    3x-2y+2z=9\\
\end{cases}$$

### 1.3

$$\begin{cases}
    x-2y+3z=6\\
    2x-y-z=3\\
    3x-4y+z=2\\
\end{cases}$$

### 1.4

$$\begin{cases}
    2x+2y-3z=1\\
    x-5y+2z=-15\\
    2x-y-7z=-1\\
\end{cases}$$

### 1.5

$$\begin{cases}
    3x+3y-2z=-3\\
    x+3y+2z=2\\
    2x+2y+z=-1\\
\end{cases}$$

main Algorithm:

```Java
double[][] matrixTable = new double[3][4];
double resultX;
double resultY;
double resultZ;

for (int i = 0; i < n - 1; i++) {
    for (int j = i + 1; j < n; j++) {
        double div = matrixTable[j][i]/matrixTable[i][i];
        for (int k = 0; k < n + 1; k++) {
            matrixTable[j][k] = matrixTable[j][k] - div * matrixTable[i][k];
            //matrixTable[j][k] *= matrixTable[i][i];
        }
    }
}

for (int i = n-1; i > 0; i--) {
    for (int j = i-1; j >= 0 ; j--) {
        double div = matrixTable[j][i]/matrixTable[i][i];
        for (int k = 0; k < n + 1; k++) {
            matrixTable[j][k] = matrixTable[j][k] - div * matrixTable[i][k];
            //matrixTable[j][k] *= matrixTable[i][i];
        }
    }
}

for (int i = 0; i < n; i++) {
    double div = matrixTable[i][i];
    for (int j = 0; j < n + 1; j++) {
        matrixTable[i][j] = matrixTable[i][j]/div;
    }
}

resultX = matrixTable[0][3];
resultY = matrixTable[1][3];
resultZ = matrixTable[2][3];
```

View More in [GitHub](https://github.com/Tolia-GH/Semester-2/tree/main/Mathematic/GraphicWork)

Download [Application](https://github.com/Tolia-GH/Semester-2/releases/download/Mathematic/GraphicWork.jar)

## Задание 2

## Задание 3

Разобраться с материалом (пункт 5) и аналогично с приведенными примерами аналитически и численно найти минимумы функции.Сделать график и указать найденную точку.  
处理材料（第 5 点）并类似地处理给出的示例，分析和数值地找到函数的最小值。绘制图表并指出找到的点。

### 3.1

$$5x^2+5y^2+6xy-8\sqrt{2}x-8\sqrt{2}y$$

### 3.2

$$17x^2+8y^2+12xy-32\sqrt{5}x-16\sqrt{5}y+60$$

### 3.3

$$3x^2+3y^2-2xy+8\sqrt{2}x-8\sqrt{2}y$$

### 3.4

$$13x^2+37y^2+18xy-16\sqrt{10}x-48\sqrt{10}y+120$$

### 3.5

$$4x^2+4y^2-10xy-27\sqrt{2}x+27\sqrt{2}y+72$$

## Задание 4