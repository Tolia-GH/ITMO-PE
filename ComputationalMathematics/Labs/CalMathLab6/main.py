from abc import ABC, abstractmethod
import numpy as np
import matplotlib as plt
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
    h: float
    accuracy: float

    def __init__(self):
        pass

    def getFXY(self, x: float, y: float):
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

    def toString(self):
        return "y'=y'=y+(1+x)y^2"


def EnterToContinue():
    input("-------------Press Enter To Continue-------------")


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
except Error as e:
    print(e)
    EnterToContinue()
