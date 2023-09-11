from abc import ABC, abstractmethod
import numpy as np
import matplotlib.pyplot as plt
import math


class Error(Exception):  # for exceptions
    def __init__(self, info):
        super().__init__(self)
        self.errorInfo = info

    def __str__(self):
        return self.errorInfo


class Dot:
    x: float
    y: float

    def __init__(self, x: float, y: float):
        self.x = x
        self.y = y

    def to_string(self):
        print("(%.4f,%.4f)" % (self.x, self.y))

    def get_x(self):
        return self.x

    def get_y(self):
        return self.y


class AbstractFunction(ABC):
    left: float
    right: float
    y0: float
    h: float
    accuracy: float

    def __init__(self):
        pass

    @abstractmethod
    def getFXY(self, x: float, y: float):
        pass

    @abstractmethod
    def getTrueY(self, x: float):
        pass

    @abstractmethod
    def toString(self):
        pass


class Function1(AbstractFunction):
    left: float
    right: float
    y0: float
    h: float
    accuracy: float

    def __init__(self, left: float, right: float, y0: float, h: float, accuracy: float):
        super().__init__()
        self.left = left
        self.right = right
        self.y0 = y0
        self.h = h
        self.accuracy = accuracy

    def getFXY(self, x: float, y: float):
        return y + (1 + x) * y ** 2

    def getTrueY(self, x: float):
        return -1 / x

    def toString(self):
        return "y'=y'=y+(1+x)y^2"


def EnterToContinue():
    input("-------------Press Enter To Continue-------------")


class AbstractSolver(ABC):
    @abstractmethod
    def doIterate(self, func: AbstractFunction):
        pass


def eularSolver(func: AbstractFunction):
    print("Метод Эйлера:")
    print("%-10s %-10s %-10s %-10s %-10s" % ("i", "xi", "yi", "f(xi, yi)", "real yi"))
    res = []
    dev = []
    i = 0
    xi = func.left
    yi = func.y0
    h = func.h
    accuracy = func.accuracy
    while xi <= func.right:
        res.append([xi, yi])
        dev.append(abs(yi - func.getTrueY(xi)))
        print("%-10s %-10.4f %-10.4f %-10.4f %-10.4f" % (i, xi, yi, func.getFXY(xi, yi), func.getTrueY(xi)))
        if abs(yi - func.getTrueY(xi)) > accuracy:
            func.h = func.h / 2
            print("Погрешность: %.5f > %.5f" % (max(dev), accuracy))
            print("h = h / 2 = %.5f" % func.h)
            return eularSolver(func)
        yi = yi + h * func.getFXY(xi, yi)
        i = i + 1
        xi = xi + h
    print("Погрешность: %.20f" % max(dev))
    return res


def rungeSolver(func: AbstractFunction):
    print("Метод Эйлера:")
    res = []
    dev = []
    i = 0
    xi = func.left
    yi = func.y0
    h = func.h
    accuracy = func.accuracy
    print("%-10s %-10s %-10s %-10s %-10s" % ("i", "xi", "yi", "f(xi, yi)", "real yi"))
    while xi <= func.right:
        res.append([xi, yi])
        dev.append(abs(func.getTrueY(xi) - yi))

        if abs(yi - func.getTrueY(xi)) > accuracy:
            func.h = func.h / 2
            print("Погрешность: %.5f > %.5f" % (max(dev), accuracy))
            print("h = h / 2 = %.5f" % func.h)
            return rungeSolver(func)

        print("%-10.0f %-10.4f %-10.4f %-10.4f %-10.4f" % (i, xi, yi, func.getFXY(xi, yi), func.getTrueY(xi)))
        k1 = func.getFXY(xi, yi) * h
        k2 = func.getFXY(xi + h / 2, yi + k1 / 2) * h
        k3 = func.getFXY(xi + h / 2, yi + k2 / 2) * h
        k4 = func.getFXY(xi + h, yi + k3) * h

        yi = yi + (k1 + 2 * k2 + 2 * k3 + k4) / 6
        i = i + 1
        xi = xi + h

    print("Погрешность:%.20f" % max(dev))
    return res


def adamsSolver(func: AbstractFunction):
    h = func.h
    x0 = func.left
    x1 = x0 + h
    x2 = x1 + h
    x3 = x2 + h

    if x3 >= func.right:
        print("Метод Адмаса не подходит")
        return []

    y0 = func.y0
    y1 = func.getTrueY(x1)
    y2 = func.getTrueY(x2)
    y3 = func.getTrueY(x3)

    f0 = func.getFXY(x0, y0)
    f1 = func.getFXY(x1, y1)
    f2 = func.getFXY(x2, y2)
    f3 = func.getFXY(x3, y3)

    res = []
    dev = []

    res.append([x0, y0])
    res.append([x1, y1])
    res.append([x2, y2])
    res.append([x3, y3])
    dev.append(0)
    dev.append(0)
    dev.append(0)
    dev.append(0)

    print("Метод Адамса")
    print("%-10s %-10s %-10s %-10s" % ("i", "xi", "yi", "Точное решение"))
    print("%-10.0f %-10.4f %-10.4f %-10.4f" % (0, x0, y0, func.getTrueY(x0)))
    print("%-10.0f %-10.4f %-10.4f %-10.4f" % (1, x1, y1, func.getTrueY(x1)))
    print("%-10.0f %-10.4f %-10.4f %-10.4f" % (2, x2, y2, func.getTrueY(x2)))
    print("%-10.0f %-10.4f %-10.4f %-10.4f" % (3, x3, y3, func.getTrueY(x3)))
    i = 4
    xi = x3
    yi = y3
    while xi <= func.right:
        det1f = f3 - f2
        det2f = f3 - 2 * f2 + f1
        det3f = f3 - 3 * f2 + 3 * f1 - f0
        yi = yi + h * func.getFXY(xi, yi) + h ** 2 * det1f / 2 + 5 * h ** 3 * det2f / 12 + 3 * h ** 4 * det3f / 8
        xi = xi + h
        dev.append(abs(func.getTrueY(xi) - yi))
        res.append([xi, yi])
        print("%-10.0f %-10.4f %-10.4f %-10.4f" % (i, xi, yi, func.getTrueY(xi)))

        f0 = f1
        f1 = f2
        f2 = f3
        f3 = func.getFXY(xi, yi)
        i = i + 1
    print("Погрешность:%.8f" % max(dev))
    return res


try:
    while True:
        function: AbstractFunction

        EnterToContinue()
        print("Please choose a function: ")
        print("1 - y' = y + (1 + x)y^2, y(1) = -1")

        functionIndex = int(input("Enter your choice {1}: "))
        leftI = float(input("Input left bound: "))
        rightI = float(input("Input right bound: "))
        y0I = float(input("Input y(%.3f): " % leftI))
        hI = float(input("Input the gap h: "))
        accuracyI = float(input("Input accuracy: "))
        if functionIndex == 1:
            function = Function1(leftI, rightI, y0I, hI, accuracyI)
        else:
            raise Error("Error: only accept inputs '1'")

        resultE = eularSolver(function)
        resultR = rungeSolver(function)
        resultA = adamsSolver(function)

        plt.plot([resultE[0][0], resultE[1][0]], [resultE[0][1], resultE[1][1]], color="red", label="Euler")
        count = 1
        while count < len(resultE) - 1:
            plt.plot([resultE[count][0], resultE[count + 1][0]], [resultE[count][1], resultE[count + 1][1]],color="red")
            count = count + 1

        plt.plot([resultR[0][0], resultR[1][0]], [resultR[0][1], resultR[1][1]], color="blue", label="Lunge")
        count = 1
        while count < len(resultE) - 1:
            plt.plot([resultR[count][0], resultR[count + 1][0]], [resultR[count][1], resultR[count + 1][1]],
                     color="blue")
            count = count + 1

        plt.plot([resultA[0][0], resultA[1][0]], [resultA[0][1], resultA[1][1]], color="green", label="Adams")
        count = 1
        while count < len(resultE) - 1:
            plt.plot([resultA[count][0], resultA[count + 1][0]], [resultA[count][1], resultA[count + 1][1]],
                     color="green")
            count = count + 1

        xRange = np.arange(leftI, rightI, 0.01)
        yRange = [function.getTrueY(xi) for xi in xRange]
        plt.plot(xRange, yRange, color="black", label="Точное решение")

        plt.legend()
        plt.show()
except Error as e:
    print(e)
    EnterToContinue()
