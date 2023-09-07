import sys
import math
from abc import ABC, abstractmethod


class Error(Exception):
    def __init__(self, info):
        super().__init__(self)
        self.errorInfo = info

    def __str__(self):
        return self.errorInfo


class AbstractFunction(ABC):
    a: float
    b: float
    c: float
    d: float

    def __init__(self, a, b, c, d):
        self.a = a
        self.b = b
        self.c = c
        self.d = d

    @abstractmethod
    def getInt(self, a: float, b: float):  # get correct int
        pass

    @abstractmethod
    def getValue(self, x: float):  # get correct value
        pass


class Function(AbstractFunction):  # for ax^3 + bx^2 + cx + d
    def __init__(self, a, b, c, d):
        super(Function, self).__init__(a, b, c, d)

    def getInt(self, a: float, b: float):  # get correct int
        return (0.25 * self.a * b ** 4 + 1 / 3 * self.b * b ** 3 + self.c / 2 * b ** 2 + self.d * b) - (
                    0.25 * self.a * a ** 4 + 1 / 3 * self.b * a ** 3 + self.c / 2 * a ** 2 + self.d * a)

    def getValue(self, x: float):
        return self.a * x ** 3 + self.b * x ** 2 + self.c * x + self.d


class AbstractSolver(ABC):
    a: float  # left [a,b]
    b: float  # right [a,b]
    accuracy: float
    function: AbstractFunction

    def __init__(self, func: AbstractFunction, acc: float, a: float, b: float):
        self.function = func
        self.accuracy = acc
        self.a = a
        self.b = b

    @abstractmethod
    def getAccuracy(self, a, b):  # Lange's rule
        pass

    @abstractmethod
    def solve(self):
        pass


class RectangleSolver(AbstractSolver):
    def __init__(self, func: AbstractFunction, acc: float, a: float, b: float):
        super().__init__(func, acc, a, b)

    def getAccuracy(self, intH, int2H):  # Lange's rule
        return (int2H - intH) / 3

    def doProcess(self, vid, n: int):
        print("----------Rectangle Method of Integral----------")
        print("%-5s %-5s %-10s %-10s %-10s" % ("times", "n", "gap", "integral", "accuracy"))
        times = 0
        thisInt = 0.0
        nextInt: float
        calculateAccuracy = self.accuracy + 1
        while calculateAccuracy > self.accuracy:
            nextInt = 0
            i = 0
            gap = (self.b - self.a) / n
            if vid == "1":
                x = self.a
            elif vid == "2":
                x = self.a + gap/2
            elif vid == "3":
                x = self.a + gap
            else:
                raise Error("Error: vidIndex out of range")
            while i < n:
                nextInt += self.function.getValue(x) * gap
                x += gap
                i += 1

            calculateAccuracy = abs(self.getAccuracy(thisInt, nextInt))
            print("%-5d %-5d %-10f %-10f %-10f" % (times, n, gap, nextInt, calculateAccuracy))
            thisInt = nextInt
            n *= 2
            times += 1
        print("------------------------------------------------")
        print("Iterate times: %d" % (times - 1))
        print("Seperated squares: %d" % (n / 2))
        print("Answer: %.30f" % thisInt)
        print("Accuracy: %.30f" % calculateAccuracy)
        print()

    def solve(self):
        print("Choose a kind of method")
        print("1) Left")
        print("2) Middle")
        print("3) Right")
        vidIndex = input("input from 1 to 3: ")
        n = int(input("Please set initial number of squares to begin: "))
        self.doProcess(vidIndex, n)


class TrapezoidalSolver(AbstractSolver):

    def __init__(self, func: AbstractFunction, acc: float, a: float, b: float):
        super().__init__(func, acc, a, b)

    def getAccuracy(self, intH, int2H):  # Lange's rule
        return (int2H - intH) / 3

    def doProcess(self, n: int):
        print("----------Rectangle Method of Integral----------")
        print("%-5s %-5s %-10s %-10s %-10s" % ("times", "n", "gap", "integral", "accuracy"))
        times = 0
        thisInt = 0.0
        nextInt: float
        calculateAccuracy = self.accuracy + 1
        while calculateAccuracy > self.accuracy:
            nextInt = 0
            i = 0
            gap = (self.b - self.a) / n
            thisX = self.a
            nextX = thisX + gap
            while i < n:
                nextInt += (self.function.getValue(thisX) + self.function.getValue(nextX)) * gap / 2
                thisX = nextX
                nextX += gap
                i += 1

            calculateAccuracy = abs(self.getAccuracy(thisInt, nextInt))
            print("%-5d %-5d %-10f %-10f %-10f" % (times, n, gap, nextInt, calculateAccuracy))
            thisInt = nextInt
            n *= 2
            times += 1
        print("------------------------------------------------")
        print("Iterate times: %d" % (times - 1))
        print("Seperated squares: %d" % (n / 2))
        print("Answer: %.30f" % thisInt)
        print("Accuracy: %.30f" % calculateAccuracy)
        print()

    def solve(self):
        n = int(input("Please set initial number of squares to begin: "))
        self.doProcess(n)


class SimpsonSolver(AbstractSolver):

    def __init__(self, func: AbstractFunction, acc: float, a: float, b: float):
        super().__init__(func, acc, a, b)

    def getAccuracy(self, intH, int2H):  # Lange's rule
        return (int2H - intH) / 15

    def doProcess(self, n: int):
        print("----------Rectangle Method of Integral----------")
        print("%-5s %-5s %-10s %-10s %-10s" % ("times", "n", "gap", "integral", "accuracy"))
        times = 0
        thisInt = 0.0
        nextInt: float
        calculateAccuracy = self.accuracy + 1
        while calculateAccuracy > self.accuracy:
            i = 1
            sumSin = 0
            sumDou = 0
            gap = (self.b - self.a) / n
            x = self.a + gap
            while i < n:
                if i % 2 == 0:
                    sumDou += self.function.getValue(x)
                else:
                    sumSin += self.function.getValue(x)
                x += gap
                i += 1
            nextInt = gap/3 * (self.function.getValue(self.a) + self.function.getValue(self.b) + 4 * sumSin + 2 * sumDou)
            calculateAccuracy = abs(self.getAccuracy(thisInt, nextInt))
            print("%-5d %-5d %-10f %-10f %-10f" % (times, n, gap, nextInt, calculateAccuracy))
            thisInt = nextInt
            n *= 2
            times += 1
        print("------------------------------------------------")
        print("Iterate times: %d" % (times - 1))
        print("Seperated squares: %d" % (n / 2))
        print("Answer: %.30f" % thisInt)
        print("Accuracy: %.60f" % calculateAccuracy)
        print()

    def solve(self):
        n = int(input("Please set initial number of squares to begin: "))
        self.doProcess(n)


while True:
    try:
        abcd = input("Please input parameters of function ax^3+bx^2+cx+d(input a, b, c, d), seperated by space: ")
        listABCD = abcd.split(" ")
        if len(listABCD) < 4:
            raise Error("Error: Input 4 parameters")
        ab = input("Please input the range of integration (a, b), seperated by space: ")
        listAB = ab.split(" ")
        if len(listAB) < 2:
            raise Error("Error: Input 2 parameters")

        accuracy = float(input("Please input accuracy: "))

        print("Please choose the method")
        print("1) Rectangle method")
        print("2) Trapezoidal method")
        print("3) Simpson method")
        methodIndex = input("input from 1 to 3: ")
        if methodIndex != "1" and methodIndex != "2" and methodIndex != "3":
            raise Error("Choose form 1, 2 and 3")

        function: AbstractFunction
        function = Function(float(listABCD[0]), float(listABCD[1]), float(listABCD[2]), float(listABCD[3]))

        if methodIndex == "1":
            solver = RectangleSolver(function, accuracy, float(listAB[0]), float(listAB[1]))
        elif methodIndex == "2":
            solver = TrapezoidalSolver(function, accuracy, float(listAB[0]), float(listAB[1]))
        elif methodIndex == "3":
            solver = SimpsonSolver(function, accuracy, float(listAB[0]), float(listAB[1]))
        else:
            raise Error("Error: methodIndex out of range")

        solver.solve()
    except Error as E:
        print(E)
        go_on = input("Input \"exit\" to exit, input others to continue")
        if go_on.lower() == "exit":
            sys.exit(1)
        print("\n")
