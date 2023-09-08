import matplotlib.pyplot as plt
import numpy as np
import math
from abc import ABC, abstractmethod


class Error(Exception):  # for exceptions
    def __init__(self, info):
        super().__init__(self)
        self.errorInfo = info

    def __str__(self):
        return self.errorInfo


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


def printTable(table: []):
    i = 0
    stringTable = "x     y     \n"
    while i < len(table):
        j = 0
        while j < len(table[i]):
            stringTable = stringTable + ("%5.3f" % table[i][j]) + " "
            j = j + 1
        stringTable = stringTable + "\n"
        i = i + 1
    print(stringTable)
    return


class Point:
    x: float
    y: float

    def __init__(self, x: float, y: float):
        self.x = x
        self.y = y

    def getX(self):
        return self.x

    def getY(self):
        return self.y

    def toString(self):
        return "(" + str(round(self.x, 4)) + ", " + str(round(self.y, 4)) + ")"


class AbstractFunction(ABC):

    def __init__(self):
        pass

    @abstractmethod
    def getValue(self, x: float):
        pass

    @abstractmethod
    def toString(self):
        pass


class LinerFunction(AbstractFunction):
    a = 0
    b = 0

    def __init__(self, a: float, b: float):
        super().__init__()
        self.a = a
        self.b = b

    def getValue(self, x: float):
        return self.a * x + self.b

    def toString(self):
        return "f(x)=" + str(round(self.a, 4)) + "x" + str(round(self.b, 4))


class SecondFunction(AbstractFunction):
    a = 0
    b = 0
    c = 0

    def __init__(self, a: float, b: float, c: float):
        super().__init__()
        self.a = a
        self.b = b
        self.c = c

    def getValue(self, x: float):
        return self.a * x * x + self.b * x + self.c

    def toString(self):
        return "f(x)=" + str(round(self.a, 4)) + "x^2" + str(round(self.b, 4)) + "x" + str(round(self.c, 4))


def LagrangeAnalyze(points: [], x: float):
    li = []
    res = 0
    i = 0

    while i < len(points):
        yi = points[i].getY()

        j = 0
        lag = 1
        while j < len(points):
            if i != j:
                lag = lag * (x - points[j].getX()) / (points[i].getX() - points[j].getX())
            j = j + 1

        li.append(lag)
        print("l%d = %f" % (i, lag))

        res = res + yi * lag
        i = i + 1

    return res


def getH(points: []):
    h = points[1].x - points[0].x
    i = 2
    while i < len(points):
        if (points[i].x - points[i - 1].x) - h > 0.0001:
            # Due to the loss of precision in floating-point binary calculation,
            # it is considered that if the difference between 2 numbers is less than 0.0001, then they are equal
            raise Error("These points are not equal distance")
        i = i + 1
    return h


def GaussAnalyze(points: [], x: float):
    n = len(points)  # number of points
    middle = int((n - 1) / 2)  # center point index
    h = getH(points)  # distance between 2 x
    x0 = points[middle].x
    y0 = points[middle].y
    t = (x - x0) / h
    table = []

    res = y0

    i = 0
    while i < len(points):  # store xi and yi to Gauss table
        line = []
        table.append(line)

        table[i].append(points[i].x)
        table[i].append(points[i].y)
        i = i + 1

    i = 2
    while i < (len(points) + 1):  # get delta i yi
        j = 0
        while j < (len(points) - i + 1):
            table[j].append(table[j + 1][i - 1] - table[j][i - 1])
            j = j + 1
        i = i + 1
    printTable(table)

    i = 1
    tPart = 1
    while i < len(points):
        if x < x0:
            tPart = tPart * (t - (i - 1)/2)
            dyPart = table[int(middle - (i + 1) / 2)][i + 1]
            res = res + tPart / math.factorial(i) * dyPart
            i = i + 1

            tPart = tPart * (t + i/2)
            dyPart = table[int(middle - i / 2)][i + 1]
            res = res + tPart / math.factorial(i) * dyPart
            i = i + 1
        if x > x0:
            tPart = tPart * (t + (i - 1)/2)
            dyPart = table[int(middle - (i-1) / 2)][i + 1]
            res = res + tPart / math.factorial(i) * dyPart
            i = i + 1

            tPart = tPart * (t - i/2)
            dyPart = table[int(middle - i / 2)][i + 1]
            res = res + tPart / math.factorial(i) * dyPart
            i = i + 1

    return res


def EnterToContinue():
    input("-------------Press Enter To Continue-------------")


def pointsAnalyze():
    print()
    print("Preparing for interpolation analyzing by points...")

    N = int(input("Please input number of points: "))
    Points = []
    print("Please input %d lines of each point by format 'x y'" % N)

    i = 0
    while i < N:
        pointString = input()
        pointStringArray = pointString.split(" ")
        for s in pointStringArray:
            if not is_digit(s):
                raise Error("Error: only accept input 2 float number")
        if len(pointStringArray) < 2:
            raise Error("Error: Please make sure that you only input 2 float number")
        x = float(pointStringArray[0])
        y = float(pointStringArray[1])
        Points.append(Point(x, y))
        i = i + 1

    xString = input("Please input coordinate x: ")
    if not is_digit(xString):
        raise Error("Error: only accept input float number")
    x = float(xString)

    print()
    print("Analyzing...")
    print()

    yByLagrange = LagrangeAnalyze(Points, x)
    print("Result coordinate Y by Lagrange: %.4f" % yByLagrange)

    yByGauss = GaussAnalyze(Points, x)
    print("Result coordinate Y by Gauss: %.4f" % yByGauss)


def functionAnalyze():
    print()
    print("Preparing for interpolation analyzing by function...")
    print()

    print("Please choose type of function: ")
    print("1 - Liner function: f(x) = ax + b")
    print("2 - Quadratic function： f(x) = ax^2 + bx + c")
    functionIndex = int(input("Enter your choice {1, 2}: "))
    print()

    function: AbstractFunction
    if functionIndex == 1:
        coefficientString = input("Please input coefficients of function by format 'a b': ")
        coefficientArray = coefficientString.split(" ")
        for c in coefficientArray:
            if not is_digit(c):
                raise Error("Error: only accept input float number")
        if len(coefficientArray) < 2:
            raise Error("Error: Please make sure that you only input 2 num")
        function = LinerFunction(float(coefficientArray[0]), float(coefficientArray[1]))
    elif functionIndex == 2:
        coefficientString = input("Please input coefficients of function by format 'a b c'")
        coefficientArray = coefficientString.split(" ")
        for c in coefficientArray:
            if not is_digit(c):
                raise Error("Error: only accept input float number")
        if len(coefficientArray) < 3:
            raise Error("Error: Please make sure that you only input 2 num")
        function = SecondFunction(float(coefficientArray[0]), float(coefficientArray[1]), float(coefficientArray[2]))
    else:
        raise Error("Error: only accept inputs '1' or '2'")

    print()
    N = int(input("Please input number of points: "))
    Points = []
    print("Please input %d lines of X coordinate of each point by format 'x'" % N)

    i = 0
    while i < N:
        pointString = input()
        pointStringArray = pointString.split(" ")
        for s in pointStringArray:
            if not is_digit(s):
                raise Error("Error: only accept input float number")
        if len(pointStringArray) < 1:
            raise Error("Error: Please make sure that you input 1 float number")
        x = float(pointStringArray[0])
        y = function.getValue(x)
        Points.append(Point(x, y))
        i = i + 1

    xString = input("Please input coordinate x: ")
    if not is_digit(xString):
        raise Error("Error: only accept input float number")
    x = float(xString)

    print()
    print("Analyzing...")
    print()

    yByLagrange = LagrangeAnalyze(Points, x)
    print("Result coordinate Y by Lagrange: %.4f" % yByLagrange)

    yByGauss = GaussAnalyze(Points, x)
    print("Result coordinate Y by Gauss: %.4f" % yByGauss)


EnterToContinue()
while True:
    try:
        print("Please choose what you want: ")
        print("1 - Interpolation analyze by certain points")
        print("2 - Interpolation analyze by given function")
        print("0 - Exit program")
        choiceIndex = input("Enter your choice {0, 1, 2}: ")
        if choiceIndex == "1":
            pointsAnalyze()
        elif choiceIndex == "2":
            functionAnalyze()
        elif choiceIndex == "0":
            exit(0)
        else:
            print("Error: only accept inputs '0', '1' or '2'")
        EnterToContinue()
    except Error as e:
        print(e)
        EnterToContinue()
