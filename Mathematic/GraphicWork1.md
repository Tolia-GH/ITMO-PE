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

## [MainPage](../index.md)/[Mathematics](./README.md)/Graphic Work

## Задание 1

Решить СЛАУ методом Гаусса (аналитически) и модифицированным методом Гаусса (ММГ)(посмотрите файл “численные методы”). Реализовать код для алгоритма ММГ и сравнить результаты численного и аналитического подхода.  
通过高斯方法（解析）和修正高斯方法 (ММГ) 求解线性代数方程组（SLAE）参见文件“数值方法”。 实现 ММГ 算法的代码并比较数值和解析方法的结果。

**Main Algorithm:**

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

View More in [GitHub](https://github.com/Tolia-GH/Semester-2/tree/main/Mathematic/GraphicWork/GraphicWork-1)

Download [Application](https://github.com/Tolia-GH/Semester-2/releases/download/Mathematic/GraphicWork.jar)

### 1.1

$$\begin{cases}
    3x-2y-3z=0\\
    x+5y+3z=1\\
    2x-3y-4z=3\\
\end{cases}$$

![](../pic/GraphicWork1/GraphicWork1-1.png)

### 1.2

$$\begin{cases}
    2x+y+4z=-5\\
    x+3y-6z=2\\
    3x-2y+2z=9\\
\end{cases}$$

![](../pic/GraphicWork1/GraphicWork1-2.png)

### 1.3

$$\begin{cases}
    x-2y+3z=6\\
    2x-y-z=3\\
    3x-4y+z=2\\
\end{cases}$$

![](../pic/GraphicWork1/GraphicWork1-3.png)

### 1.4

$$\begin{cases}
    2x+2y-3z=1\\
    x-5y+2z=-15\\
    2x-y-7z=-1\\
\end{cases}$$

![](../pic/GraphicWork1/GraphicWork1-4.png)

### 1.5

$$\begin{cases}
    3x+3y-2z=-3\\
    x+3y+2z=2\\
    2x+2y+z=-1\\
\end{cases}$$

![](../pic/GraphicWork1/GraphicWork1-5.png)

## Задание 2

## Задание 3

Разобраться с материалом (пункт 5) и аналогично с приведенными примерами аналитически и численно найти минимумы функции.Сделать график и указать найденную точку.  
处理材料（第 5 点）并类似地处理给出的示例，分析和数值地找到函数的最小值。绘制图表并指出找到的点。

**Main Algorithm:**

- [Аналитическим](https://math1.ru/education/sys_lin_eq/kapelli.html)
- [Численным](https://indrag49.github.io/Numerical-Optimization/conjugate-gradient-methods-1.html#the-scipy.optimize.minimize-function)
  - Linear Conjugate Gradient Algorithm (Пример врзьмем из первой задачи)
    ```python
    import numpy as np
    import math


    def f(x):  # Define the objective function
        return 5*x[0]**2 + 6*x[0]*x[1] + 5*x[1]**2 - 8*math.sqrt(2)*x[0] - 8*math.sqrt(2)*x[1]

    A = np.array(([5, 3], [3, 5]), dtype=float)
    b = np.array([8*math.sqrt(2.), 8*math.sqrt(2.)])

    eigs = np.linalg.eigvals(A)
    print("The eigenvalues of A:", eigs)

    if (np.all(eigs>0)):
        print("A is positive definite")
    elif (np.all(eigs>=0)):
        print("A is positive semi-definite")
    else:
        print("A is negative definite")

    if (A.T==A).all()==True: print("A is symmetric")

    def linear_CG(x, A, b, epsilon):
        res = A.dot(x) - b  # Initialize the residual
        delta = -res  # Initialize the descent direction

        while True:

            if np.linalg.norm(res) <= epsilon:
                return x, f(x)  # Return the minimizer x* and the function value f(x*)

            D = A.dot(delta)
            beta = -(res.dot(delta)) / (delta.dot(D))  # Line (11) in the algorithm
            x = x + beta * delta  # Generate the new iterate

            res = A.dot(x) - b  # generate the new residual
            chi = res.dot(D) / (delta.dot(D))  # Line (14) in the algorithm
            delta = chi * delta - res  # Generate the new descent direction


    linear_CG(np.array([0, 0]), A, b, 10**-5)
    ```
  - Nonlinear Conjugate Gradient Algorithm (Пример врзьмем из первой задачи)
    - Fletcher-Reeves algorithm
      ```python
      from autograd import grad
      import autograd.numpy as np
      import math
      from scipy.optimize import line_search
      NORM = np.linalg.norm

      def func(x): # Objective function
          return 5*x[0]**2 + 6*x[0]*x[1] + 5*x[1]**2 - 8*math.sqrt(2)*x[0] - 8*math.sqrt(2)*x[1]

      Df = grad(func) # Gradient of the objective function

      def Fletcher_Reeves(Xj, tol, alpha_1, alpha_2):
          x1 = [Xj[0]]
          x2 = [Xj[1]]
          D = Df(Xj)
          delta = -D # Initialize the descent direction
          
          while True:
              start_point = Xj # Start point for step length selection 
              beta = line_search(f=func, myfprime=Df, xk=start_point, pk=delta, c1=alpha_1, c2=alpha_2)[0] # Selecting the step length
              if beta!=None:
                  X = Xj+ beta*delta #Newly updated experimental point
              
              if NORM(Df(X)) < tol:
                  x1 += [X[0], ]
                  x2 += [X[1], ]
                  return X, func(X) # Return the results
              else:
                  Xj = X
                  d = D # Gradient at the preceding experimental point
                  D = Df(Xj) # Gradient at the current experimental point
                  chi = NORM(D)**2/NORM(d)**2 # Line (16) of the Fletcher-Reeves algorithm
                  delta = -D + chi*delta # Newly updated descent direction
                  x1 += [Xj[0], ]
                  x2 += [Xj[1], ]
                  
      print(Fletcher_Reeves(np.array([-1.7, -3.2]), 10**-5, 10**-4, 0.38))
      ```
    - Polak-Ribiere algorithm
      ```python
      from autograd import grad
      import autograd.numpy as np
      import math
      from scipy.optimize import line_search
      NORM = np.linalg.norm

      def func(x): # Objective function
          return 5*x[0]**2 + 6*x[0]*x[1] + 5*x[1]**2 - 8*math.sqrt(2)*x[0] - 8*math.sqrt(2)*x[1]

      Df = grad(func) # Gradient of the objective function

      def Polak_Ribiere(Xj, tol, alpha_1, alpha_2):
          x1 = [Xj[0]]
          x2 = [Xj[1]]
          D = Df(Xj)
          delta = -D # Initialize the descent direction
          
          while True:
              start_point = Xj # Start point for step length selection 
              beta = line_search(f=func, myfprime=Df, xk=start_point, pk=delta, c1=alpha_1, c2=alpha_2)[0] # Selecting the step length
              if beta!=None:
                  X = Xj+ beta*delta # Newly updated experimental point 
              
              if NORM(Df(X)) < tol:
                  x1 += [X[0], ]
                  x2 += [X[1], ]
                  return X, func(X) # Return the results
              else:
                  Xj = X
                  d = D # Gradient of the preceding experimental point
                  D = Df(Xj) # Gradient of the current experimental point
                  chi = (D-d).dot(D)/NORM(d)**2 
                  chi = max(0, chi) # Line (16) of the Polak-Ribiere Algorithm
                  delta = -D + chi*delta # Newly updated direction
                  x1 += [Xj[0], ]
                  x2 += [Xj[1], ]
                  
      print(Polak_Ribiere(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2))
      ```
    - Hestenes-Stiefel algorithm
      ```python
      from autograd import grad
      import autograd.numpy as np
      import math
      from scipy.optimize import line_search
      NORM = np.linalg.norm

      def func(x): # Objective function
          return 5*x[0]**2 + 6*x[0]*x[1] + 5*x[1]**2 - 8*math.sqrt(2)*x[0] - 8*math.sqrt(2)*x[1]

      Df = grad(func) # Gradient of the objective function

      def Hestenes_Stiefel(Xj, tol, alpha_1, alpha_2):
          x1 = [Xj[0]]
          x2 = [Xj[1]]
          D = Df(Xj)
          delta = -D
          
          while True:
              start_point = Xj # Start point for step length selection 
              beta = line_search(f=func, myfprime=Df, xk=start_point, pk=delta, c1=alpha_1, c2=alpha_2)[0] # Selecting the step length
              if beta!=None:
                  X = Xj+ beta*delta
              
              if NORM(Df(X)) < tol:
                  x1 += [X[0], ]
                  x2 += [X[1], ]
                  return X, func(X)
              else:
                  Xj = X
                  d = D
                  D = Df(Xj)
                  chi = D.dot(D - d)/delta.dot(D - d) # See line (16)
                  delta = -D + chi*delta
                  x1 += [Xj[0], ]
                  x2 += [Xj[1], ]

      print(Hestenes_Stiefel(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2))
      ```
    - Dai-Yuan algorithm
      ```python
      from autograd import grad
      import autograd.numpy as np
      import math
      from scipy.optimize import line_search
      NORM = np.linalg.norm

      def func(x): # Objective function
          return 5*x[0]**2 + 6*x[0]*x[1] + 5*x[1]**2 - 8*math.sqrt(2)*x[0] - 8*math.sqrt(2)*x[1]

      Df = grad(func) # Gradient of the objective function

      def Dai_Yuan(Xj, tol, alpha_1, alpha_2):
          x1 = [Xj[0]]
          x2 = [Xj[1]]
          D = Df(Xj)
          delta = -D
          
          while True:
              start_point = Xj # Start point for step length selection 
              beta = line_search(f=func, myfprime=Df, xk=start_point, pk=delta, c1=alpha_1, c2=alpha_2)[0] # Selecting the step length
              if beta!=None:
                  X = Xj+ beta*delta
              
              if NORM(Df(X)) < tol:
                  x1 += [X[0], ]
                  x2 += [X[1], ]
                  return X, func(X)
              else:
                  Xj = X
                  d = D
                  D = Df(Xj)
                  chi = NORM(D)**2/delta.dot(D - d) # See line (16)
                  delta = -D + chi*delta
                  x1 += [Xj[0], ]
                  x2 += [Xj[1], ]
                  
      print(Dai_Yuan(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2))
      ```
    - Hager-Zhang algorithm
      ```python
      from autograd import grad
      import autograd.numpy as np
      import math
      from scipy.optimize import line_search
      NORM = np.linalg.norm

      def func(x): # Objective function
          return 5*x[0]**2 + 6*x[0]*x[1] + 5*x[1]**2 - 8*math.sqrt(2)*x[0] - 8*math.sqrt(2)*x[1]

      Df = grad(func) # Gradient of the objective function

      def Hager_Zhang(Xj, tol, alpha_1, alpha_2):
          x1 = [Xj[0]]
          x2 = [Xj[1]]
          D = Df(Xj)
          delta = -D
          
          while True:
              start_point = Xj # Start point for step length selection 
              beta = line_search(f=func, myfprime=Df, xk=start_point, pk=delta, c1=alpha_1, c2=alpha_2)[0] # Selecting the step length
              if beta!=None:
                  X = Xj+ beta*delta
              
              if NORM(Df(X)) < tol:
                  x1 += [X[0], ]
                  x2 += [X[1], ]
                  return X, func(X)
              else:
                  Xj = X
                  d = D
                  D = Df(Xj)
                  Q = D - d
                  M = Q - 2*delta*NORM(Q)**2/(delta.dot(Q))
                  N = D/(delta.dot(Q))
                  chi = M.dot(N) # See line (19)
                  delta = -D + chi*delta
                  x1 += [Xj[0], ]
                  x2 += [Xj[1], ]
                  
      print(Hager_Zhang(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2))
      ```
  - `scipy.optimize.minimize()` Function
    ```python
    from autograd import grad
    import autograd.numpy as np
    from scipy.optimize import minimize
    import math

    def func(x): # Objective function
        return 5*x[0]**2 + 6*x[0]*x[1] + 5*x[1]**2 - 8*math.sqrt(2)*x[0] - 8*math.sqrt(2)*x[1]

    Df = grad(func) # Gradient of the objective function

    res=minimize(fun=func, x0=np.array([-9., 4.]), jac=Df, method='CG', options={'gtol':10**-6, 'disp':True, 'return_all':True})

    cnt = 1 # counter
    for i in res.allvecs: 
        print(i)
        cnt = cnt + 1
        # if cnt == 100:
            # break;
    ```
View More in [GitHub](https://github.com/Tolia-GH/Semester-2/blob/main/Mathematic/GraphicWork/GraphicWorks-3.ipynb)

### 3.1

$$z=5x^2+5y^2+6xy-8\sqrt{2}x-8\sqrt{2}y$$

- **Аналитическим:**

  Для начала найдём частные производные первого порядка:

  $$\begin{split}
      \frac{\partial z}{\partial x}&=10x+6y-8\sqrt{2}\\
      \frac{\partial z}{\partial y}&=6x+10y-8\sqrt{2}\\
  \end{split}$$

  Составим систему уравнений

  $$\begin{cases}
      \frac{\partial z}{\partial x}&=0\\
      \frac{\partial z}{\partial y}&=0\\
  \end{cases}\Rightarrow
  \begin{cases}
      10x+6y-8\sqrt{2}=0\\
      6x+10y-8\sqrt{2}=0\\
  \end{cases}
  $$

  Получим, что:

  $$\begin{cases}
      x=\frac{1}{\sqrt{2}}\\
      y=\frac{1}{\sqrt{2}}\\
  \end{cases}$$

  Теперь найдём частные производные второго порядка:

  $$\frac{\partial^2z}{\partial x^2}=10;
  \frac{\partial^2z}{\partial y^2}=10;
  \frac{\partial^2z}{\partial x\partial y}=6$$

  Вычислим значение $\Delta$:

  $$\Delta
  =\frac{\partial^2z}{\partial x^2}\cdot\frac{\partial^2z}{\partial y^2}-(\frac{\partial^2z}{\partial x\partial y})^2
  =10\cdot10-6^2
  =64$$

  Так как $\Delta>0$ и $\frac{\partial^2z}{\partial x^2}>0$, о согласно алгоритму точка $(\frac{1}{\sqrt{2}},\frac{1}{\sqrt{2}})$ есть точкой минимума функции $z$.

  Минимум функции $z$ найдём, подставив в заданную функцию координаты точки $(\frac{1}{\sqrt{2}},\frac{1}{\sqrt{2}})$

  $$z_{min}=z(\frac{1}{\sqrt{2}},\frac{1}{\sqrt{2}})=-8$$

- **Численным :**

  ![](../pic/GraphicWork1/GraphicWork3-1.1.png)
  ![](../pic/GraphicWork1/GraphicWork3-1.2.png)

  - **linear conjugate gradient algorithm**
    ```python
    linear_CG(np.array([0, 0]), A, b, 10**-5)
    ```
    result
    ```
    The eigenvalues of A: [8. 2.]
    A is positive definite
    A is symmetric
    (array([1.41421356, 1.41421356]), 0.0)
    ```

  - **Nonlinear Conjugate Gradient Algorithm**
    - **Fletcher-Reeves Algorithm**
      ```python
      Fletcher_Reeves(np.array([2., -1.8]), 10**-5, 10**-4, 0.38)
      ```
      result
      ```
      (array([0.70710678, 0.70710678]), -8.000000000000002)
      ```
    - **Polak-Ribiere Algorithm**
      ```python
      Polak_Ribiere(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([0.70710678, 0.70710678]), -8.000000000000002)
      ```
    - **Hestenes-Stiefel Algorithm**
      ```python
      Hestenes_Stiefel(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([0.70710678, 0.70710678]), -8.000000000000002)
      ```
    - **Dai-Yuan Algorithm**
      ```python
      Dai_Yuan(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([0.70710678, 0.70710678]), -8.000000000000002)
      ```
    - **Hager-Zhang Algorithm**
      ```python
      Hager_Zhang(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([0.70710678, 0.70710678]), -8.000000000000002)
      ```
  - `scipy.optimize.minimize()` Function
    ```python
    res=minimize(fun=func, x0=np.array([-9., 4.]), jac=Df, method='CG', options={'gtol':10**-6, 'disp':True, 'return_all':True})

    for i in res.allvecs: print(i)
    ```
    result
    ```
    Optimization terminated successfully.
         Current function value: -8.000000
         Iterations: 3
         Function evaluations: 7
         Gradient evaluations: 7
    [-9.  4.]
    [-4.20069713  5.57136627]
    [0.7676896  0.77699143]
    [0.70710678 0.70710678]
    ```
### 3.2

$$17x^2+8y^2+12xy-32\sqrt{5}x-16\sqrt{5}y+60$$

- **Аналитическим:**

  Для начала найдём частные производные первого порядка:

  $$\begin{split}
      \frac{\partial z}{\partial x}&=34x+12y-32\sqrt{5}\\
      \frac{\partial z}{\partial y}&=12x+16y-16\sqrt{5}\\
  \end{split}$$

  Составим систему уравнений

  $$\begin{cases}
      \frac{\partial z}{\partial x}&=0\\
      \frac{\partial z}{\partial y}&=0\\
  \end{cases}\Rightarrow
  \begin{cases}
      34x+12y-32\sqrt{5}=0\\
      12x+16y-16\sqrt{5}=0\\
  \end{cases}
  $$

  Получим, что:

  $$\begin{cases}
      x=\frac{4}{\sqrt{5}}\\
      y=\frac{2}{\sqrt{5}}\\
  \end{cases}$$

  Теперь найдём частные производные второго порядка:

  $$\frac{\partial^2z}{\partial x^2}=34;
  \frac{\partial^2z}{\partial y^2}=16;
  \frac{\partial^2z}{\partial x\partial y}=12$$

  Вычислим значение $\Delta$:

  $$\Delta
  =\frac{\partial^2z}{\partial x^2}\cdot\frac{\partial^2z}{\partial y^2}-(\frac{\partial^2z}{\partial x\partial y})^2
  =34\cdot16-12^2
  =400$$

  Так как $\Delta>0$ и $\frac{\partial^2z}{\partial x^2}>0$, о согласно алгоритму точка $(\frac{4}{\sqrt{5}},\frac{2}{\sqrt{5}})$ есть точкой минимума функции $z$.

  Минимум функции $z$ найдём, подставив в заданную функцию координаты точки $(\frac{4}{\sqrt{5}},\frac{2}{\sqrt{5}})$

  $$z_{min}=z(\frac{4}{\sqrt{5}},\frac{2}{\sqrt{5}})=-20$$

- **Численным :**

  ![](../pic/GraphicWork1/GraphicWork3-2.1.png)
  ![](../pic/GraphicWork1/GraphicWork3-2.2.png)

  - **linear conjugate gradient algorithm**
    ```python
    linear_CG(np.array([0, 0]), A, b, 10**-5)
    ```
    result
    ```
    The eigenvalues of A: [20.  5.]
    A is positive definite
    A is symmetric
    (array([3.57770876, 1.78885438]), 60.00000000000004)
    ```

  - **Nonlinear Conjugate Gradient Algorithm**
    - **Fletcher-Reeves Algorithm**
      ```python
      Fletcher_Reeves(np.array([2., -1.8]), 10**-5, 10**-4, 0.38)
      ```
      result
      ```
      (array([1.78885438, 0.89442719]), -20.0)
      ```
    - **Polak-Ribiere Algorithm**
      ```python
      Polak_Ribiere(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([1.78885438, 0.89442719]), -20.0)
      ```
    - **Hestenes-Stiefel Algorithm**
      ```python
      Hestenes_Stiefel(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([1.78885438, 0.89442719]), -20.0)
      ```
    - **Dai-Yuan Algorithm**
      ```python
      Dai_Yuan(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([1.78885438, 0.89442719]), -20.0)
      ```
    - **Hager-Zhang Algorithm**
      ```python
      Hager_Zhang(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([1.78885438, 0.89442719]), -20.0)
      ```
  - `scipy.optimize.minimize()` Function
    ```python
    res=minimize(fun=func, x0=np.array([-9., 4.]), jac=Df, method='CG', options={'gtol':10**-6, 'disp':True, 'return_all':True})

    for i in res.allvecs: print(i)
    ```
    result
    ```
    Optimization terminated successfully.
         Current function value: -20.000000
         Iterations: 4
         Function evaluations: 10
         Gradient evaluations: 10
    [-9.  4.]
    [0.22748061 6.23374967]
    [2.63288256 1.26322356]
    [1.80471577 0.86244626]
    [1.78885438 0.89442719]
    ```

### 3.3

$$3x^2+3y^2-2xy+8\sqrt{2}x-8\sqrt{2}y$$

**Аналитическим:**

Для начала найдём частные производные первого порядка:

$$\begin{split}
    \frac{\partial z}{\partial x}&=6x-2y+8\sqrt{2}\\
    \frac{\partial z}{\partial y}&=-2x+6y-8\sqrt{2}\\
\end{split}$$

Составим систему уравнений

$$\begin{cases}
    \frac{\partial z}{\partial x}&=0\\
    \frac{\partial z}{\partial y}&=0\\
\end{cases}\Rightarrow
\begin{cases}
    6x-2y+8\sqrt{2}=0\\
    -2x+6y-4\sqrt{2}=0\\
\end{cases}
$$

Получим, что:

$$\begin{cases}
    x=-\sqrt{2}\\
    y=\sqrt{2}\\
\end{cases}$$

Теперь найдём частные производные второго порядка:

$$\frac{\partial^2z}{\partial x^2}=6;
\frac{\partial^2z}{\partial y^2}=6;
\frac{\partial^2z}{\partial x\partial y}=-2$$

Вычислим значение $\Delta$:

$$\Delta
=\frac{\partial^2z}{\partial x^2}\cdot\frac{\partial^2z}{\partial y^2}-(\frac{\partial^2z}{\partial x\partial y})^2
=32$$

Так как $\Delta>0$ и $\frac{\partial^2z}{\partial x^2}>0$, о согласно алгоритму точка $(-\sqrt{2},\sqrt{2})$ есть точкой минимума функции $z$.

Минимум функции $z$ найдём, подставив в заданную функцию координаты точки $(-\sqrt{2},\sqrt{2})$

$$z_{min}=z(-\sqrt{2},\sqrt{2})=-16$$

- **Численным :**

  ![](../pic/GraphicWork1/GraphicWork3-3.1.png)
  ![](../pic/GraphicWork1/GraphicWork3-3.2.png)

  - **linear conjugate gradient algorithm**
    ```python
    linear_CG(np.array([0, 0]), A, b, 10**-5)
    ```
    result
    ```
    The eigenvalues of A: [4. 2.]
    A is positive definite
    A is symmetric
    (array([-2.82842712,  2.82842712]), 1.4210854715202004e-14)
    ```

  - **Nonlinear Conjugate Gradient Algorithm**
    - **Fletcher-Reeves Algorithm**
      ```python
      Fletcher_Reeves(np.array([2., -1.8]), 10**-5, 10**-4, 0.38)
      ```
      result
      ```
      (array([-1.41421356,  1.41421356]), -16.0)
      ```
    - **Polak-Ribiere Algorithm**
      ```python
      Polak_Ribiere(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([-1.41421356,  1.41421356]), -16.0)
      ```
    - **Hestenes-Stiefel Algorithm**
      ```python
      Hestenes_Stiefel(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([-1.41421356,  1.41421356]), -16.0)
      ```
    - **Dai-Yuan Algorithm**
      ```python
      Dai_Yuan(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([-1.41421356,  1.41421356]), -16.0)
      ```
    - **Hager-Zhang Algorithm**
      ```python
      Hager_Zhang(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([-1.41421356,  1.41421356]), -16.0)
      ```
  - `scipy.optimize.minimize()` Function
    ```python
    res=minimize(fun=func, x0=np.array([-9., 4.]), jac=Df, method='CG', options={'gtol':10**-6, 'disp':True, 'return_all':True})

    for i in res.allvecs: print(i)
    ```
    result
    ```
    Optimization terminated successfully.
         Current function value: -16.000000
         Iterations: 3
         Function evaluations: 7
         Gradient evaluations: 7
    [-9.  4.]
    [-4.6800171   1.38461326]
    [-1.95786819  0.49922811]
    [-1.41421356  1.41421356]
    ```

### 3.4

$$13x^2+37y^2+18xy-16\sqrt{10}x-48\sqrt{10}y+120$$

- **Аналитическим:**

  Для начала найдём частные производные первого порядка:

  $$\begin{split}
      \frac{\partial z}{\partial x}&=26x+18y-16\sqrt{10}\\
      \frac{\partial z}{\partial y}&=18x+74y-48\sqrt{10}\\
  \end{split}$$

  Составим систему уравнений

  $$\begin{cases}
      \frac{\partial z}{\partial x}&=0\\
      \frac{\partial z}{\partial y}&=0\\
  \end{cases}\Rightarrow
  \begin{cases}
      26x+18y-16\sqrt{10}=0\\
      18x+74y-48\sqrt{10}=0\\
  \end{cases}
  $$

  Получим, что:

  $$\begin{cases}
      x=\sqrt{\frac{2}{5}}\\
      y=3\sqrt{\frac{2}{5}}\\
  \end{cases}$$

  Теперь найдём частные производные второго порядка:

  $$\frac{\partial^2z}{\partial x^2}=26;
  \frac{\partial^2z}{\partial y^2}=74;
  \frac{\partial^2z}{\partial x\partial y}=18$$

  Вычислим значение $\Delta$:

  $$\Delta
  =\frac{\partial^2z}{\partial x^2}\cdot\frac{\partial^2z}{\partial y^2}-(\frac{\partial^2z}{\partial x\partial y})^2
  =1600$$

  Так как $\Delta>0$ и $\frac{\partial^2z}{\partial x^2}>0$, о согласно алгоритму точка $(\sqrt{\frac{2}{5}},3\sqrt{\frac{2}{5}})$ есть точкой минимума функции $z$.

  Минимум функции $z$ найдём, подставив в заданную функцию координаты точки $(\sqrt{\frac{2}{5}},3\sqrt{\frac{2}{5}})$

  $$z_{min}=z(\sqrt{\frac{2}{5}},3\sqrt{\frac{2}{5}})=-40$$

- **Численным :**

  ![](../pic/GraphicWork1/GraphicWork3-4.1.png)
  ![](../pic/GraphicWork1/GraphicWork3-4.2.png)

  - **linear conjugate gradient algorithm**
    ```python
    linear_CG(np.array([0, 0]), A, b, 10**-5)
    ```
    result
    ```
    The eigenvalues of A: [10. 40.]
    A is positive definite
    A is symmetric
    (array([1.26491106, 3.79473319]), 120.0)
    ```

  - **Nonlinear Conjugate Gradient Algorithm**
    - **Fletcher-Reeves Algorithm**
      ```python
      Fletcher_Reeves(np.array([1.7, -3.2]), 10**-5, 10**-4, 0.38)
      ```
      result
      ```
      (array([0.63245562, 1.89736657]), -39.999999999999915)
      ```
    - **Polak-Ribiere Algorithm**
      ```python
      Polak_Ribiere(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([0.63245553, 1.8973666 ]), -40.0)
      ```
    - **Hestenes-Stiefel Algorithm**
      ```python
      Hestenes_Stiefel(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([0.63245553, 1.8973666 ]), -39.99999999999997)
      ```
    - **Dai-Yuan Algorithm**
      ```python
      Dai_Yuan(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([0.63245557, 1.89736658]), -40.0)
      ```
    - **Hager-Zhang Algorithm**
      ```python
      Hager_Zhang(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      (array([0.63245553, 1.8973666 ]), -40.0)
      ```
  - `scipy.optimize.minimize()` Function
    ```python
    res=minimize(fun=func, x0=np.array([-9., 4.]), jac=Df, method='CG', options={'gtol':10**-6, 'disp':True, 'return_all':True})

    for i in res.allvecs: print(i)
    ```
    result
    ```
    Optimization terminated successfully.
         Current function value: -40.000000
         Iterations: 5
         Function evaluations: 11
         Gradient evaluations: 11
    [-9.  4.]
    [-3.96758714  4.42109473]
    [-1.75871852  1.7543011 ]
    [0.67068117 1.8484627 ]
    [0.66911507 1.88886852]
    [0.63245553 1.8973666 ]
    ```

### 3.5

$$4x^2+4y^2-10xy-27\sqrt{2}x+27\sqrt{2}y+72$$

- **Аналитическим:**

  Для начала найдём частные производные первого порядка:

  $$\begin{split}
      \frac{\partial z}{\partial x}&=8x-10y-27\sqrt{2}\\
      \frac{\partial z}{\partial y}&=-10x+8y+27\sqrt{2}\\
  \end{split}$$

  Составим систему уравнений

  $$\begin{cases}
      \frac{\partial z}{\partial x}&=0\\
      \frac{\partial z}{\partial y}&=0\\
  \end{cases}\Rightarrow
  \begin{cases}
      8x-10y-27\sqrt{2}=0\\
      -10x+8y+27\sqrt{2}=0\\
  \end{cases}
  $$

  Получим, что:

  $$\begin{cases}
      x=-\frac{27}{41\sqrt{2}}\\
      y=-\frac{243}{41\sqrt{2}}\\
  \end{cases}$$

  Теперь найдём частные производные второго порядка:

  $$\frac{\partial^2z}{\partial x^2}=8;
  \frac{\partial^2z}{\partial y^2}=8;
  \frac{\partial^2z}{\partial x\partial y}=-10$$

  Вычислим значение $\Delta$:

  $$\Delta
  =\frac{\partial^2z}{\partial x^2}\cdot\frac{\partial^2z}{\partial y^2}-(\frac{\partial^2z}{\partial x\partial y})^2
  =-36$$

  Так как $\Delta<0$ и $\frac{\partial^2z}{\partial x^2}>0$, то в расматриваемой стационарной точке экстремума нет.

  $z_{min}$ нет

- **Численным :**

  ![](../pic/GraphicWork1/GraphicWork3-5.1.png)
  ![](../pic/GraphicWork1/GraphicWork3-5.2.png)

  - **linear conjugate gradient algorithm**
    ```python
    linear_CG(np.array([0, 0]), A, b, 10**-5)
    ```
    result
    ```
    Excepion Thrown
    ```

  - **Nonlinear Conjugate Gradient Algorithm**
    - **Fletcher-Reeves Algorithm**
      ```python
      Fletcher_Reeves(np.array([2., -1.8]), 10**-5, 10**-4, 0.38)
      ```
      result
      ```
      Excepion Thrown
      ```
    - **Polak-Ribiere Algorithm**
      ```python
      Polak_Ribiere(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      Excepion Thrown
      ```
    - **Hestenes-Stiefel Algorithm**
      ```python
      Hestenes_Stiefel(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      Excepion Thrown
      ```
    - **Dai-Yuan Algorithm**
      ```python
      Dai_Yuan(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      Excepion Thrown
      ```
    - **Hager-Zhang Algorithm**
      ```python
      Hager_Zhang(np.array([-1.7, -3.2]), 10**-6, 10**-4, 0.2)
      ```
      result
      ```
      Excepion Thrown
      ```
  - `scipy.optimize.minimize()` Function
    ```python
    res=minimize(fun=func, x0=np.array([-9., 4.]), jac=Df, method='CG', options={'gtol':10**-6, 'disp':True, 'return_all':True})

    cnt = 1
    for i in res.allvecs: 
        print(i)
        cnt = cnt + 1
        if cnt == 100:
            break;
    ```
    result
    ```
    Warning: Desired error not necessarily achieved due to precision loss.
         Current function value: -638620327919368979750444359794842489522837784210241723938786265042735602834508285086468598139971152546157831852651824542545365471759667590398833531804304515787429656631266562372974429354184368346116323803136.000000
         Iterations: 35
         Function evaluations: 3678
         Gradient evaluations: 3678
    [-9.  4.]
    [-0.64683233 -4.90936412]
    [-5676.36346356 -5721.40996218]
    [-5878690.51418104 -5920731.02435051]
    [-6.08585229e+09 -6.12936947e+09]
    [-6.30031185e+12 -6.34536253e+12]
    [-6.52232876e+15 -6.56896698e+15]
    [-6.75216933e+18 -6.80045104e+18]
    [-6.99010926e+21 -7.04009237e+21]
    [-7.23643397e+24 -7.28817843e+24]
    [-7.49143892e+27 -7.54500681e+27]
    [-7.75543000e+30 -7.81088556e+30]
    [-8.02872386e+33 -8.08613363e+33]
    [-8.31164835e+36 -8.37108118e+36]
    [-8.60454281e+39 -8.66607000e+39]
    [-8.90775860e+42 -8.97145395e+42]
    [-9.22165941e+45 -9.28759933e+45]
    [-9.54662179e+48 -9.61488536e+48]
    [-9.88303553e+51 -9.95370464e+51]
    [-1.02313042e+55 -1.03044636e+55]
    [-1.05918455e+58 -1.06675829e+58]
    [-1.09650919e+61 -1.10434983e+61]
    [-1.13514911e+64 -1.14326605e+64]
    [-1.17515067e+67 -1.18355364e+67]
    [-1.21656185e+70 -1.22526093e+70]
    [-1.25943231e+73 -1.26843794e+73]
    [-1.30381349e+76 -1.31313647e+76]
    [-1.34975862e+79 -1.35941013e+79]
    [-1.39732281e+82 -1.40731443e+82]
    [-1.44656312e+85 -1.45690684e+85]
    [-1.49753861e+88 -1.50824683e+88]
    [-1.55031042e+91 -1.56139599e+91]
    [-1.60494187e+94 -1.61641808e+94]
    [-1.66149847e+97 -1.67337909e+97]
    [-1.72004807e+100 -1.73234736e+100]
    [-1.78066091e+103 -1.79339361e+103]
    ```

## Задание 4