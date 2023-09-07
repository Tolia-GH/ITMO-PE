import sys
import math
from abc import ABC, abstractmethod
import matplotlib.pyplot as plt
import numpy as np


def is_digit(d: str):  # judge whether a string is number
    if d[0] == "-":
        d = d[1:]
    digits = d.split(".")
    if len(digits) != 2 and len(digits) != 1:
        return False
    for digit in digits:
        if not digit.isdigit():
            return False
    return True


def formateNum(num: float):  # to add '+' and '-' before number
    if num > 0:
        return "+" + str(num)
    elif num < 0:
        return str(num)
    else:
        return ""


def linerAnalyze(points: []):
    avgX = 0
    avgY = 0

    for point in points:
        avgX = avgX + point.getX()
        avgY = avgY + point.getY()

    avgX = avgX / len(points)
    avgY = avgY / len(points)

    rNumer = 0
    rDomi1 = 0
    rDomi2 = 0

    for point in points:
        rNumer = rNumer + ((point.getX() - avgX) * (point.getY() - avgY))
        rDomi1 = rDomi1 + math.pow((point.getX() - avgX), 2)
        rDomi2 = rDomi2 + math.pow((point.getY() - avgY), 2)

    return rNumer / math.sqrt(rDomi1 * rDomi2)


class Error(Exception):  # for exceptions
    def __init__(self, info):
        super().__init__(self)
        self.errorInfo = info

    def __str__(self):
        return self.errorInfo


class FunctionNotAvailableException(Exception):
    def __init__(self, info):
        super().__init__(self)
        self.errorInfo = info

    def __str__(self):
        return self.errorInfo


class Point:  # class for single Point
    x: float
    y: float

    def __init__(self, x: float, y: float):
        self.x = x
        self.y = y

    def getX(self):
        return self.x

    def getY(self):
        return self.y


class AbstractFunction(ABC):
    a = 0
    b = 0

    S = 0
    delta = 0
    R2 = 0

    def __init__(self, a: float, b: float):
        self.a = a
        self.b = b

    @abstractmethod
    def getValue(self, x: float):
        pass

    def doAnalyze(self, points: []):
        self.S = 0
        self.delta = 0
        self.R2 = 0

        sumPhi = 0
        sumPhi2 = 0

        for point in points:
            self.S = self.S + math.pow((self.getValue(point.getX()) - point.getY()), 2)
            sumPhi = sumPhi + self.getValue(point.getX())
            sumPhi2 = sumPhi2 + math.pow(self.getValue(point.getX()), 2)

        self.delta = math.sqrt(self.S / len(points))
        self.R2 = 1 - (self.S / (sumPhi2 - (math.pow(sumPhi, 2) / len(points))))

    @abstractmethod
    def toString(self):
        pass


class LinerFunction(AbstractFunction):  # function for φ(x) = ax + b
    def __init__(self, a, b):
        super().__init__(a, b)

    def getValue(self, x: float):
        return self.a * x + self.b

    def doAnalyze(self, points: []):
        super().doAnalyze(points)

    def toString(self):

        strFunction = ""

        if self.a != 0:
            strFunction = strFunction + str(round(self.a, 4)) + "x"
        if self.b != 0:
            strFunction = strFunction + formateNum(round(self.b, 4))

        return strFunction


class SecondFunction(AbstractFunction):  # function for φ(x) = ax^2 + bx + c

    c = 0

    def __init__(self, a: float, b: float, c: float):
        super().__init__(a, b)
        self.c = c

    def getValue(self, x: float):
        return self.a * x * x + self.b * x + self.c

    def doAnalyze(self, points: []):
        super().doAnalyze(points)

    def toString(self):

        strFunction = ""

        if self.a != 0:
            strFunction = strFunction + str(round(self.a, 4)) + "x^2"
        if self.b != 0:
            strFunction = strFunction + formateNum(round(self.b, 4)) + "x"
        if self.c != 0:
            strFunction = strFunction + formateNum(round(self.c, 4))

        return strFunction


class ThirdFunction(AbstractFunction):  # function for φ(x) = ax^3 + bx^2 + cx + d

    c = 0
    d = 0

    def __init__(self, a: float, b: float, c: float, d: float):
        super().__init__(a, b)
        self.c = c
        self.d = d

    def getValue(self, x: float):
        return self.a * x * x * x + self.b * x * x + self.c * x + self.d

    def doAnalyze(self, points: []):
        super().doAnalyze(points)

    def toString(self):

        strFunction = ""

        if self.a != 0:
            strFunction = strFunction + str(round(self.a, 4)) + "x^3"
        if self.b != 0:
            strFunction = strFunction + formateNum(round(self.b, 4)) + "x^2"
        if self.c != 0:
            strFunction = strFunction + formateNum(round(self.c, 4)) + "x"
        if self.d != 0:
            strFunction = strFunction + formateNum(round(self.d, 4))

        return strFunction


class LogFunction(AbstractFunction):  # function for φ(x) = a*ln(x) + b
    def __init__(self, a, b):
        super().__init__(a, b)

    def getValue(self, x: float):
        return self.a * math.log(x) + self.b

    def doAnalyze(self, points: []):
        super().doAnalyze(points)

    def toString(self):

        strFunction = ""

        if self.a != 0:
            strFunction = strFunction + str(round(self.a, 4)) + "ln(x)"
        if self.b != 0:
            strFunction = strFunction + formateNum(round(self.b, 4))

        return strFunction


class ExpFunction(AbstractFunction):  # function for φ(x) = a*e^(bx)
    def __init__(self, a, b):
        super().__init__(a, b)

    def getValue(self, x: float):
        return self.a * math.exp(x * self.b)

    def doAnalyze(self, points: []):
        super().doAnalyze(points)

    def toString(self):

        strFunction = ""

        if self.a != 0:
            strFunction = strFunction + str(round(self.a, 4)) + "e^("
        if self.b != 0:
            strFunction = strFunction + str(round(self.b, 4)) + "x)"

        return strFunction


class PowerFunction(AbstractFunction):  # function for φ(x) = ax^b
    def __init__(self, a, b):
        super().__init__(a, b)

    def getValue(self, x: float):
        return self.a * math.pow(x, self.b)

    def doAnalyze(self, points: []):
        super().doAnalyze(points)

    def toString(self):

        strFunction = ""

        if self.a != 0:
            strFunction = strFunction + str(round(self.a, 4)) + "x^"
        if self.b != 0:
            strFunction = strFunction + str(round(self.b, 4))

        return strFunction


class AbstractSolver(ABC):
    N = 0
    Points = []

    def __init__(self, num: int, points: []):
        self.N = num
        self.Points = points

    def sumX(self):
        sum = 0
        for point in self.Points:
            sum = sum + point.getX()
        return sum

    def sumY(self):
        sum = 0
        for point in self.Points:
            sum = sum + point.getY()
        return sum

    def sumXX(self):
        sum = 0
        for point in self.Points:
            sum = sum + math.pow(point.getX(), 2)
        return sum

    def sumXY(self):
        sum = 0
        for point in self.Points:
            sum = sum + point.getX() * point.getY()
        return sum

    def sumXXX(self):
        sum = 0
        for point in self.Points:
            sum = sum + math.pow(point.getX(), 3)
        return sum

    def sumXXY(self):
        sum = 0
        for point in self.Points:
            sum = sum + math.pow(point.getX(), 2) * point.getY()
        return sum

    def sumXXXY(self):
        sum = 0
        for point in self.Points:
            sum = sum + math.pow(point.getX(), 3) * point.getY()
        return sum

    def sumXXXX(self):
        sum = 0
        for point in self.Points:
            sum = sum + math.pow(point.getX(), 4)
        return sum

    def sumXXXXX(self):
        sum = 0
        for point in self.Points:
            sum = sum + math.pow(point.getX(), 5)
        return sum

    def sumXXXXXX(self):
        sum = 0
        for point in self.Points:
            sum = sum + math.pow(point.getX(), 6)
        return sum

    @abstractmethod
    def solve(self):
        pass


class LinerSolver(AbstractSolver):
    def __init__(self, num: int, points: []):
        super().__init__(num, points)

    def solve(self):
        A = np.array([
            [self.N, self.sumX()],
            [self.sumX(), self.sumXX()],
        ])
        if np.linalg.det(A) == 0:
            raise FunctionNotAvailableException("These points can't be dealt with liner solver")
        B = [self.sumY(), self.sumXY()]
        answer = np.dot(np.linalg.inv(A), B)
        return LinerFunction(answer[1], answer[0])


class SecondSolver(AbstractSolver):
    def __init__(self, num: int, points: []):
        super().__init__(num, points)

    def solve(self):
        A = np.array([
            [self.N, self.sumX(), self.sumXX()],
            [self.sumX(), self.sumXX(), self.sumXXX()],
            [self.sumXX(), self.sumXXX(), self.sumXXXX()]
        ])
        if np.linalg.det(A) == 0:
            raise FunctionNotAvailableException("These points can't be dealt with second order polynomial solver")
        B = [self.sumY(), self.sumXY(), self.sumXXY()]
        answer = np.dot(np.linalg.inv(A), B)
        return SecondFunction(answer[2], answer[1], answer[0])


class ThirdSolver(AbstractSolver):
    def __init__(self, num: int, points: []):
        super().__init__(num, points)

    def solve(self):
        A = np.array([
            [self.N, self.sumX(), self.sumXX(), self.sumXXX()],
            [self.sumX(), self.sumXX(), self.sumXXX(), self.sumXXXX()],
            [self.sumXX(), self.sumXXX(), self.sumXXXX(), self.sumXXXXX()],
            [self.sumXXX(), self.sumXXXX(), self.sumXXXXX(), self.sumXXXXXX()]
        ])
        if np.linalg.det(A) == 0:
            raise FunctionNotAvailableException("These points can't be dealt with third order polynomial solver")
        B = [self.sumY(), self.sumXY(), self.sumXXY(), self.sumXXXY()]
        answer = np.dot(np.linalg.inv(A), B)
        return ThirdFunction(answer[3], answer[2], answer[1], answer[0])


class LogSolver(AbstractSolver):

    def __init__(self, num: int, points: []):
        super().__init__(num, points)

    def solve(self):
        tempPoints = []
        tempFunction: AbstractFunction

        for point in self.Points:
            if point.getX() > 0:
                tempPoints.append(Point(math.log(point.getX()), point.getY()))
            else:
                raise FunctionNotAvailableException("These points can't be dealt with log solver")

        tempSolver = LinerSolver(tempPoints.__len__(), tempPoints)
        tempFunction = tempSolver.solve()

        return LogFunction(tempFunction.a, tempFunction.b)


class ExpSolver(AbstractSolver):

    def __init__(self, num: int, points: []):
        super().__init__(num, points)

    def solve(self):
        tempPoints = []
        tempFunction: AbstractFunction

        for point in self.Points:
            if point.getY() > 0:
                tempPoints.append(Point(point.getX(), math.log(point.getY())))
            else:
                raise FunctionNotAvailableException("These points can't be dealt with exp solver")

        tempSolver = LinerSolver(tempPoints.__len__(), tempPoints)
        tempFunction = tempSolver.solve()

        return ExpFunction(math.exp(tempFunction.b), tempFunction.a)


class PowerSolver(AbstractSolver):

    def __init__(self, num: int, points: []):
        super().__init__(num, points)

    def solve(self):
        tempPoints = []
        tempFunction: AbstractFunction

        for point in self.Points:
            if point.getX() > 0 and point.getY() > 0:
                tempPoints.append(Point(math.log(point.getX()), math.log(point.getY())))
            else:
                raise FunctionNotAvailableException("These points can't be dealt with power solver")

        tempSolver = LinerSolver(tempPoints.__len__(), tempPoints)
        tempFunction = tempSolver.solve()

        return PowerFunction(math.exp(tempFunction.b), tempFunction.a)


# main part
X = []
Y = []
Points = []

try:
    N = int(input("Please input the number of points: "))
    print("Please input %d lines of each point by format 'x y'" % N)

    i = 0
    while i < N:
        pointString = input()
        pointStringArray = pointString.split(" ")
        for s in pointStringArray:
            if not is_digit(s):
                raise Error("Error: only accept input integer number")
        if len(pointStringArray) < 2:
            raise Error("Error: Please make sure that you only input 2 num")

        X.append(float(pointStringArray[0]))
        Y.append(float(pointStringArray[1]))
        Points.append(Point(X[i], Y[i]))
        i = i + 1

    print()

    print("Results:")
    print("Коэффициент корреляции Пирсона: %8.6f" % linerAnalyze(Points))

    minX = min(X)
    maxX = max(X)
    minY = min(Y)
    maxY = max(Y)

    # show points
    xPoints = np.array(X)
    yPoints = np.array(Y)
    plt.plot(xPoints, yPoints, 'o')

    print("| Function type | Function expression | мера отклонения S | среднеквадричное отклонение delta |")

    # Liner
    try:
        linerSolver = LinerSolver(N, Points)
        linerFunction = linerSolver.solve()
        linerFunction.doAnalyze(Points)
        print("| φ(x)=ax+b           | %-30s | %8.6f | %8.6f | %8.6f |" % (linerFunction.toString(), linerFunction.S, linerFunction.delta, linerFunction.R2))
        xRange = np.arange(min(X) - 1, max(X) + 1, 0.1)
        yRange = [linerFunction.getValue(xi) for xi in xRange]
        labelLiner = "φ(x)=" + linerFunction.toString()
        plt.plot(xRange, yRange, "red", label=labelLiner)
    except FunctionNotAvailableException as FE:
        print(FE)

    # Second
    try:
        secondSolver = SecondSolver(N, Points)
        secondFunction = secondSolver.solve()
        secondFunction.doAnalyze(Points)
        print("| φ(x)=ax^2+bx+c      | %-30s | %8.6f | %8.6f | %8.6f |" % (secondFunction.toString(), secondFunction.S, secondFunction.delta, secondFunction.R2))
        xRange = np.arange(min(X) - 1, max(X) + 1, 0.1)
        yRange = [secondFunction.getValue(xi) for xi in xRange]
        labelSecond = "φ(x)=" + secondFunction.toString()
        plt.plot(xRange, yRange, "orange", label=labelSecond)
    except FunctionNotAvailableException as FE:
        print(FE)

    # third
    try:
        thirdSolver = ThirdSolver(N, Points)
        thirdFunction = thirdSolver.solve()
        thirdFunction.doAnalyze(Points)
        print("| φ(x)=ax^3+bx^2+cx+d | %-30s | %8.6f | %8.6f | %8.6f |" % (thirdFunction.toString(), thirdFunction.S, thirdFunction.delta, thirdFunction.R2))
        xRange = np.arange(min(X) - 1, max(X) + 1, 0.1)
        yRange = [thirdFunction.getValue(xi) for xi in xRange]
        labelThird = "φ(x)=" + thirdFunction.toString()
        plt.plot(xRange, yRange, "pink", label=labelThird)
    except FunctionNotAvailableException as FE:
        print(FE)

    # log
    try:
        logSolver = LogSolver(N, Points)
        logFunction = logSolver.solve()
        logFunction.doAnalyze(Points)
        print("| φ(x)=alnx+b         | %-30s | %8.6f | %8.6f | %8.6f |" % (logFunction.toString(), logFunction.S, logFunction.delta, logFunction.R2))
        xRange = np.arange(min(X) - 1, max(X) + 1, 0.1)
        if min(X) <= 1:
            xRange = np.arange(0.1, max(X) + 1, 0.1)
        yRange = [logFunction.getValue(xi) for xi in xRange]
        labelLog = "φ(x)=" + logFunction.toString()
        plt.plot(xRange, yRange, "green", label=labelLog)
    except FunctionNotAvailableException as FE:
        print(FE)

    # exp
    try:
        expSolver = ExpSolver(N, Points)
        expFunction = expSolver.solve()
        expFunction.doAnalyze(Points)
        print("| φ(x)=ae^(bx)        | %-30s | %8.6f | %8.6f | %8.6f |" % (expFunction.toString(), expFunction.S, expFunction.delta, expFunction.R2))
        xRange = np.arange(min(X) - 1, max(X) + 1, 0.1)
        yRange = [expFunction.getValue(xi) for xi in xRange]
        labelExp = "φ(x)=" + expFunction.toString()
        plt.plot(xRange, yRange, "blue", label=labelExp)
    except FunctionNotAvailableException as FE:
        print(FE)

    # power
    try:
        powerSolver = PowerSolver(N, Points)
        powerFunction = powerSolver.solve()
        powerFunction.doAnalyze(Points)
        print("| φ(x)=ax^b           | %-30s | %8.6f | %8.6f | %8.6f |" % (powerFunction.toString(), powerFunction.S, powerFunction.delta, powerFunction.R2))
        xRange = np.arange(min(X) - 1, max(X) + 1, 0.1)
        yRange = [powerFunction.getValue(xi) for xi in xRange]
        labelPower = "φ(x)=" + powerFunction.toString()
        plt.plot(xRange, yRange, "black", label=labelPower)
    except FunctionNotAvailableException as FE:
        print(FE)

    plt.legend()
    plt.show()

except Error as e:
    print(e)
