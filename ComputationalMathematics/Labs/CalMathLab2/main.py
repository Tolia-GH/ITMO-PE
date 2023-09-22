import sys
from abc import ABC, abstractmethod

import matplotlib.pyplot as plt
import numpy as np


class Error(Exception):
    def __init__(self, info):
        super().__init__(self)
        self.errorInfo = info

    def __str__(self):
        return self.errorInfo


class AbstractFunction(ABC):  # Abstract function f(x) = ax^3 + bx^2 + cx + d
    a = 0
    b = 0
    c = 0
    d = 0
    index = 0

    def __init__(self, a, b, c, d, index):  # initialization
        self.a = a
        self.b = b
        self.c = c
        self.d = d
        self.index = index

    @abstractmethod
    def getValue(self, x: float):  # get f(x)
        pass

    @abstractmethod
    def getDerValue(self, x: float):  # get f'(x)
        pass

    @abstractmethod
    def getDerDerValue(self, x: float): # get f''(x)
        pass

    # For method simple iterate，They are different ways to get x = φ(x) and φ'(x)
    @abstractmethod
    def getInverseValue_1(self, x: float):  # get φ1(x)
        pass

    @abstractmethod
    def getInverseDerValue_1(self, x: float):  # get φ1'(x)
        pass

    @abstractmethod
    def getInverseValue_2(self, x: float):  # get φ2(x)
        pass

    @abstractmethod
    def getInverseDerValue_2(self, x: float):  # get φ2'(x)
        pass

    @abstractmethod
    def getInverseValue_3(self, x: float):  # get φ3(x)
        pass

    @abstractmethod
    def getInverseDerValue_3(self, x: float):  # get φ3'(x)
        pass

    @abstractmethod
    def draw(self, a, b):
        pass


class DefaultFunction(AbstractFunction):  # for f(x) = ax^3 + bx^2 + cx + d

    def __init__(self, a, b, c, d, index):
        super(DefaultFunction, self).__init__(a, b, c, d, index)

    def getValue(self, x: float):  # f(x) = ax^3 + bx^2 + cx + d
        return self.a * x ** 3 + self.b * x ** 2 + self.c * x + self.d

    def getDerValue(self, x: float):  # f'(x) = 3x^2 + 2bx^ + c
        return 3 * self.a * x ** 2 + 2 * self.b * x + self.c

    def getDerDerValue(self, x: float):
        return 6 * self.a * x + 2 * self.b

    def getInverseValue_1(self, x: float):  # φ1(x) =
        return np.cbrt((-self.b * x ** 2 - self.c * x - self.d) / self.a)

    def getInverseDerValue_1(self, x: float):  # φ'(x)
        # if math.pow((-self.b * x ** 2 - self.c * x - self.d) / self.a, 2) < 0:
        #     return 2
        firstPart = 1 / (3 * np.cbrt(((-self.b * x ** 2 - self.c * x - self.d) / self.a) ** 2))
        secondPart = (-2 * self.b * x - self.c) / self.a
        return firstPart * secondPart

    def getInverseValue_2(self, x: float):
        return np.sqrt((-self.a * x ** 3 - self.c * x - self.d) / self.b)

    def getInverseDerValue_2(self, x: float):
        if (-self.a * x ** 3 - self.c * x - self.d) / self.b < 0:
            return 2
        firstPart = 1 / (2 * np.sqrt((-self.a * x ** 3 - self.c * x - self.d) / self.b))
        secondPart = (-3 * self.a * x ** 2 - self.c) / self.b
        return firstPart * secondPart

    def getInverseValue_3(self, x: float):
        return (-self.a * x ** 3 - self.b * x ** 2 - self.d) / self.c

    def getInverseDerValue_3(self, x: float):
        return (-3 * self.a * x ** 2 - 2 * self.b * x) / self.c

    def draw(self, a, b):
        x = np.arange(a, b, 0.1)
        y = self.a * x ** 3 + self.b * x ** 2 + self.c * x + self.d
        y1 = 0 * x
        plt.title("first function")
        plt.plot(x, y1)
        plt.plot(x, y)
        plt.show()


class AbstractSolver(ABC):
    left: float
    right: float
    accuracy: float
    function: AbstractFunction

    def __init__(self, function: AbstractFunction):
        self.function = function

    @abstractmethod
    def doIterate(self, function_index, inputs):
        pass

    @abstractmethod
    def solve(self, inputs):
        pass


class SimpleIterateSolver(AbstractSolver):
    def __init__(self, function: AbstractFunction):
        super().__init__(function)
        self.a = 0
        self.b = 0

    def doIterate(self, function_index, inputs):
        print("Possibility %d is running" % function_index)

        print("-------------------Method Simple iterate-------------------")
        print(
            "%-10s %-10s %-10s %-10s %-10s %-10s" % ("times", "x(k)", "f(x(k))", "x(k+1)", "φ(x(k))", "|x(k)-x(k+1)|"))

        times = 0
        calculateAccuracy = 10
        start = float(inputs[0])
        self.accuracy = float(inputs[1])
        ans: float
        while calculateAccuracy >= self.accuracy:
            self.a = start

            f1 = self.function.getValue(self.a)
            if function_index == 1:
                start = self.function.getInverseValue_1(start)
                if abs(self.function.getInverseDerValue_1(start)) >= 1:
                    print("-----------------------------------------------------------")
                    print("During the process we got a point doesnt meet requirement at %d iterate" % times)
                    return
            elif function_index == 2:
                start = self.function.getInverseValue_2(start)
                if abs(self.function.getInverseDerValue_2(start)) >= 1:
                    print("-----------------------------------------------------------")
                    print("During the process we got a point doesnt meet requirement at %d iterate" % times)
                    return
            elif function_index == 3:
                start = self.function.getInverseValue_3(start)
                if abs(self.function.getInverseDerValue_3(start)) >= 1:
                    print("-----------------------------------------------------------")
                    print("During the process we got a point doesnt meet requirement at %d iterate" % times)
                    return

            self.b = start
            calculateAccuracy = abs(self.function.getValue(self.b))
            print("%-10d %-10.4f %-10.4f %-10.4f %-10.4f %-10.4f" %
                  (times, self.a, f1, self.b, self.b, calculateAccuracy))
            times = times + 1
        print("-----------------------------------------------------------")
        print("Iterate times:%d" % times)
        print("Answer: %.4f" % self.b)
        print("Accuracy: %.4f" % calculateAccuracy)
        print("F(x) of answer: %.4f" % self.function.getValue(self.b))
        self.function.draw(int(self.a - 1), int(self.b + 1))

    def solve(self, inputs):
        start = float(inputs[0])
        self.accuracy = float(inputs[1])

        DerPhi1 = self.function.getInverseDerValue_1(start)
        DerPhi2 = self.function.getInverseDerValue_2(start)
        DerPhi3 = self.function.getInverseDerValue_3(start)

        print("φ'1(%f)=%.4f" % (start, DerPhi1))
        print("φ'2(%f)=%.4f" % (start, DerPhi2))
        print("φ'3(%f)=%.4f" % (start, DerPhi3))

        if abs(DerPhi1) < 1:
            self.doIterate(1, inputs)
        if abs(DerPhi2) < 1:
            self.doIterate(2, inputs)
        if abs(DerPhi3) < 1:
            self.doIterate(3, inputs)
        else:
            raise Error("This point can't be a start point cause it doesn't meet the convergence requirements")


class HordSolver(AbstractSolver):

    def __init__(self, function: AbstractFunction):
        super().__init__(function)

    def doIterate(self, function_index, inputs):
        print("--------------------------------Method Hord iterate--------------------------------")
        print("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s" % (
            "times", "a", "b", "x", "f(a)", "f(b)", "f(x)", "|x(k)-x(k+1)|"))
        accuracy = self.accuracy
        a = self.left
        b = self.right
        calculateAccuracy = abs(a - b)
        xLast = a
        xi: float
        times = 0

        while calculateAccuracy > accuracy:
            fa = self.function.getValue(a)
            fb = self.function.getValue(b)
            xi = (a * fb - b * fa) / (fb - fa)
            calculateAccuracy = abs(xLast - xi)
            xLast = xi
            fxi = self.function.getValue(xi)
            print("%-10d %-10.4f %-10.4f %-10.4f %-10.4f %-10.4f %-10.4f %-10.4f" % (
                times, a, b, xi, fa, fb, fxi, calculateAccuracy))
            times = times + 1
            if fa * fxi < 0:
                b = xi
            elif fb * fxi < 0:
                a = xi
            else:
                print("-----------------------------------------------------------------------------------")
                print("No result")
                return
        ans = xi
        print("-----------------------------------------------------------------------------------")
        print("Iterate times:%d" % times)
        print("Answer: %.4f" % ans)
        print("Accuracy: %.4f" % calculateAccuracy)
        print("F(x) of answer: %f" % self.function.getValue(ans))
        self.function.draw(int(ans - 1), int(ans + 1))

    def solve(self, inputs):
        self.left = float(inputs[0])
        self.right = float(inputs[1])
        self.accuracy = float(inputs[2])

        self.doIterate(1, inputs)


class SecantSolver(AbstractSolver):
    def __init__(self, function: AbstractFunction):
        super().__init__(function)
        self.a = 0
        self.b = 0

    def getNextPoint(self):
        fraction = (self.a - self.b) / (self.function.getValue(self.a) - self.function.getValue(self.b))
        return self.b - self.function.getValue(self.b) * fraction

    def doIterate(self, inputs):
        if self.function.getValue(self.a) * self.function.getValue(self.b) >= 0:
            raise Error("In this range no solution")
        ans: float
        times = 0
        calculateAccuracy = 10
        print("-------------------Method Secant Start-------------------")
        print("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s" % ("times", "x(k-1)", "f(x(k-1))", "x(k)",
                                                                   "f(x(k))", "x(k+1)", "f(x(k+1))", "|x(k)-x(k+1)|"))
        while calculateAccuracy >= self.accuracy:
            printA = self.a
            printB = self.b

            f1 = self.function.getValue(self.a)
            f2 = self.function.getValue(self.b)
            nextPoint = self.getNextPoint()
            temp = self.b
            self.b = nextPoint
            self.a = temp
            calculateAccuracy = abs(self.a - self.b)
            printC = self.b
            f3 = self.function.getValue(self.b)
            ans = printC
            print("%-10d %-10.4f %-10.4f %-10.4f %-10.4f %-10.4f %-10.4f %-10.4f" %
                  (times, printA, f1, printB, f2, printC, f3, calculateAccuracy))
            times = times + 1
        print("-----------------------------------------------------------")
        print("Iterate times:%d" % times)
        print("Answer: %f" % ans)
        print("Accuracy: %.4f" % calculateAccuracy)
        print("F(x) of answer: %f" % self.function.getValue(ans))
        self.function.draw(int(self.a - 1), int(self.b + 1))

    def solve(self, inputs):
        input1 = inputs[0]  # x0
        input2 = inputs[1]  # x1
        input3 = inputs[2]  # accuracy
        self.a = float(input1)
        self.b = float(input2)
        self.accuracy = float(input3)

        self.doIterate(inputs)


class NewtonSolver(AbstractSolver):
    def __init__(self, function: AbstractFunction):
        super().__init__(function)

    def doIterate(self, inputs):
        xi: float
        xPast: float
        fxPast: float
        fxi: float
        times = 0
        calculateAccuracy = abs(self.left - self.right)
        print("----------------------Method Newton Start----------------------")
        print("%-10s %-10s %-10s %-10s %-10s %-10s" % ("times", "xn", "f(xn)", "f'(xn)", "xn+1", "|xn+1-xn|"))

        if self.function.getValue(self.left) * self.function.getDerDerValue(self.left) > 0:
            xPast = self.left
            fXPast = self.function.getValue(xPast)
            fDerXPast = self.function.getDerValue(xPast)
        elif self.function.getValue(self.right) * self.function.getDerDerValue(self.right) > 0:
            xPast = self.right
            fXPast = self.function.getValue(xPast)
            fDerXPast = self.function.getDerValue(xPast)
        else:
            print("No results")
            return

        while calculateAccuracy > self.accuracy:
            xi = xPast - (fXPast / fDerXPast)
            calculateAccuracy = abs(xPast - xi)
            print("%-10d %-10.4f %-10.4f %-10.4f %-10.4f %-10.4f" % (
                times, xPast, fXPast, fDerXPast, xi, calculateAccuracy))
            xPast = xi
            fXPast = self.function.getValue(xPast)
            fDerXPast = self.function.getDerValue(xPast)
            times = times + 1

        ans = xi
        print("-----------------------------------------------------------------")
        print("Iterate times:%d" % times)
        print("Answer: %.4f" % ans)
        print("Accuracy: %.4f" % calculateAccuracy)
        print("F(x) of answer: %.4f" % self.function.getValue(ans))
        self.function.draw(int(ans - 1), int(ans + 1))

    def solve(self, inputs):
        self.left = float(inputs[0])
        self.right = float(inputs[1])
        self.accuracy = float(inputs[2])

        self.doIterate(inputs)


class SolverForSystem:
    # first point for iterate x1
    a: float
    # second point for iterate x2
    b: float
    accuracy: float
    '''
    0.1x^2+x+0.2y^2-0.3=0
    0.2x^2+y-0.1xy-0.7=0
    '''

    def __init__(self):
        pass

    def getValue1(self):  # f1(x1,x2) = 0.1x1^2 + x1 + 0.2x2^2 -0.3
        return 0.1 * self.a ** 2 + 0.2 * self.b ** 2 + self.a - 0.3

    def getValue2(self):  # f2(x1,x2) = 0.2x1^2 + x2 + 0.1x1x2 -0.7
        return 0.2 * self.a ** 2 + self.b - 0.1 * self.a * self.b - 0.7

    # x1 = 0.3-0.1x1^2-0.2x2^2
    def firstIterator(self, x1, x2):  # φ1(x1,x2)
        return 0.3 - 0.1 * x1 ** 2 - 0.2 * x2 ** 2

    # -0.2x1
    def firstDerOnX(self, x1):  # dφ1(x1,x2)/dx1
        return 0.2 * x1

    # -0.4x2
    def firstDerOnY(self, x2):  # dφ1(x1,x2)/dx2
        return -0.4 * x2

    # x2 = 0.7-0.2x1^2+0.1x1x2
    def secondIterator(self, x1, x2):  # φ2(x1,x2)
        return 0.7 - 0.2 * x1 ** 2 - 0.1 * x1 * x2

    # -0.4x1+0.1x2
    def secondDerOnX(self, x1, x2):  # dφ2(x1,x2)/dx1
        return -0.4 * x1 + 0.1 * x2

    # 0.1x1
    def secondDerOnY(self, x1):  # dφ2(x1,x2)/dx2
        return 0.1 * x1

    def draw(self, a: int, b: int):
        y = np.arange(-4, 4, 0.1)
        x = np.arange(a, b, 0.1)
        x, y = np.meshgrid(x, y)
        plt.contour(x, y, 0.1 * x ** 2 + x + 0.2 * y ** 2 - 0.3, [0])
        plt.contour(x, y, 0.2 * x ** 2 + y - 0.1 * x * y - 0.7, [0])
        plt.show()

    def solve(self, inputs):
        input1 = inputs[0]  # x1
        input2 = inputs[1]  # x2
        input3 = inputs[2]  # accuracy
        sumDer1 = abs(self.firstDerOnX(float(input1))) + abs(self.firstDerOnY(float(input2)))
        sumDer2 = abs(self.secondDerOnX(float(input1), float(input2))) + abs(self.secondDerOnY(float(input1)))
        if (sumDer1 < 1) and (sumDer2 < 1):
            self.a = float(input1)
            self.b = float(input2)
            self.accuracy = float(input3)
            calculateAccuracy = 10
            times = 0
            print("-------------------Method Simple iterate(for system)-------------------")
            print("%-10s %-10s %-10s %-10s %-10s" % ("x1", "x2", "φ(x1)", "φ(x2)", "max(|xi(k+1)-xi(k)|)"))
            while calculateAccuracy >= self.accuracy:
                times = times + 1
                tempA = self.a
                tempB = self.b
                self.a = self.firstIterator(tempA, tempB)
                self.b = self.secondIterator(tempA, tempB)
                calculateAccuracy = max(abs(tempB - self.b), abs(tempA - self.a))
                print("%-10.4f %-10.4f %-10.4f %-10.4f %-10.4f" % (tempA, tempB, self.a, self.b, calculateAccuracy))
            print("------------------------------------------------------------------------")
            print("Iterated %d times" % times)
            print("Result for the first equation: %.4f" % self.getValue1())
            print("Result for the second equation: %.4f" % self.getValue2())
            print("Result x:%.4f" % self.a)
            print("Result y:%.4f" % self.b)
            self.draw(int(self.b - 1), int(self.b + 1))
        else:
            raise Error("Near this point no solution")


def go_on():
    try:
        function: AbstractFunction
        solver: AbstractSolver

        print("Please choose an equation from options:")
        print("0) f(x)=x^3-x+4")
        print("1) f(x)=x^3-2.92x^2+1.435x+0.791")
        print("2)")
        print("0.1x^2+x+0.2y^2-0.3=0")
        print("0.2x^2+y-0.1xy-0.7=0")

        functionIndex = input("Input 0-2:")

        if functionIndex == "0":
            function = DefaultFunction(1, 0, -1, 4, 0)
        elif functionIndex == "1":
            function = DefaultFunction(1, -2.92, 1.435, 0.791, 1)
        elif functionIndex == "2":
            function = DefaultFunction(0, 0, 0, 0, 2)
        else:
            raise Error("Please enter 0-2 to choose the method you want")

        if functionIndex == "0" or functionIndex == "1":
            print("Please choose the method to solve equation:")
            print("1) Simple iteration method")
            print("2) The hord method")
            print("3) The Newton method")
            print("4) The Secant method")
            methodIndex = input("Enter 1-4:")
        elif functionIndex == "2":
            print("Please choose the method to solve equation:")
            print("5) Simple iteration method for system")
            methodIndex = input("Enter 5:")
        else:
            raise Error("Please choose the given methods")

        if methodIndex == "1":
            inputStart = input("Please inpout start point:")
            inputAccuracy = input("Please input accuracy:")
            inputs = [inputStart, inputAccuracy]
            solver = SimpleIterateSolver(function)
            solver.solve(inputs)
        elif methodIndex == "2":
            inputA = input("Please input left range:")
            inputB = input("Please input right range:")
            inputAccuracy = input("Please input accuracy:")
            inputs = [inputA, inputB, inputAccuracy]
            solver = HordSolver(function)
            solver.solve(inputs)
        elif methodIndex == "3":
            inputA = input("Please input left range:")
            inputB = input("Please input right range:")
            inputAccuracy = input("Please input accuracy:")
            inputs = [inputA, inputB, inputAccuracy]
            solver = NewtonSolver(function)
            solver.solve(inputs)
        elif methodIndex == "4":
            inputA = input("Please input left range:")
            inputB = input("Please input right range:")
            inputAccuracy = input("Please input accuracy:")
            inputs = [inputA, inputB, inputAccuracy]
            solver = SecantSolver(function)
            solver.solve(inputs)
        elif methodIndex == "5":
            input1 = input("Please input the start point of x:")
            input2 = input("Please input the start point of y:")
            input3 = input("Please input the accuracy:")
            inputs = [input1, input2, input3]
            systemSolver = SolverForSystem()
            systemSolver.solve(inputs)
    except Error as e:
        print(e)


while True:
    command = input("System: Please input your command: (go_on/exit)")
    if command == "go_on":
        go_on()
    elif command == "exit":
        sys.exit(1)
