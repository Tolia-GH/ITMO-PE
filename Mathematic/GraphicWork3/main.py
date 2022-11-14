
import numpy as np
import math


def f(x):  # Define the objective function
    return 5*x[0]**2 + 6*x[0]*x[1] + 5*x[1]**2 - 8*math.sqrt(2)*x[1] - 8*math.sqrt(2)*x[0]


A = np.array(([5, 3], [3, 5]), dtype=float)
b = np.array([8*math.sqrt(2), 8*math.sqrt(2)])


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


linear_CG(np.array([2.3, -2.2]), A, b, 10**-5)

import numpy as np
import math
from scipy.optimize import line_search

NORM = np.linalg.norm


def func(x):  # Objective function
    return x[0] ** 4 - 2 * x[0] ** 2 * x[1] + x[0] ** 2 + x[1] ** 2 - 2 * x[0] + 1


Df = grad(func)  # Gradient of the objective function


def Fletcher_Reeves(Xj, tol, alpha_1, alpha_2):
    x1 = [Xj[0]]
    x2 = [Xj[1]]
    D = Df(Xj)
    delta = -D  # Initialize the descent direction

    while True:
        start_point = Xj  # Start point for step length selection
        beta = line_search(f=func, myfprime=Df, xk=start_point, pk=delta, c1=alpha_1, c2=alpha_2)[
            0]  # Selecting the step length
        if beta != None:
            X = Xj + beta * delta  # Newly updated experimental point

        if NORM(Df(X)) < tol:
            x1 += [X[0], ]
            x2 += [X[1], ]
            return X, func(X)  # Return the results
        else:
            Xj = X
            d = D  # Gradient at the preceding experimental point
            D = Df(Xj)  # Gradient at the current experimental point
            chi = NORM(D) ** 2 / NORM(d) ** 2  # Line (16) of the Fletcher-Reeves algorithm
            delta = -D + chi * delta  # Newly updated descent direction
            x1 += [Xj[0], ]
            x2 += [Xj[1], ]


Fletcher_Reeves(np.array([2., -1.8]), 10 ** -5, 10 ** -4, 0.38)
