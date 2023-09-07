import matplotlib.pyplot as plt
import numpy as np
import math
from abc import ABC, abstractmethod


def min(list_num: []):
    result = list_num[0]
    for i in list_num:
        if i < result:
            result = i
    return result


def max(list_num: []):
    result = list_num[0]
    for i in list_num:
        if i > result:
            result = i
    return result


class AbstractFunction(ABC):
    a = 0
    b = 0
    c = 0
    d = 0

    def __init__(self, a, b, c, d):
        self.a = a
        self.b = b
        self.c = c
        self.d = d

    @abstractmethod
    def getvalue(self, x: float):
        pass


class FirstFunction(AbstractFunction):
    def __init__(self, a, b, c, d):
        super(FirstFunction, self).__init__(a, b, c, d)

    def getvalue(self, x: float):
        return self.a * x ** 3 + self.b * x ** 2 + self.c * x + self.d


class SecondFunction(AbstractFunction):
    def __init__(self, a, b, c, d):
        super().__init__(a, b, c, d)

    def getvalue(self, x: float):
        return self.a * math.exp(x) + self.b * x ** 2 + self.c * x + self.d


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


def Lagrange(dots: [], x: float):
    length = len(dots)
    result = 0
    index = 0
    while length > 0:
        length = length - 1
        y_i = dots[length].get_y()
        coefficient = 1
        while index < len(dots):
            if index != length:
                a = x - dots[index].x
                b = dots[length].x - dots[index].x
                coefficient = coefficient * a
                coefficient = coefficient / b
            index = index + 1
        index = 0
        result = result + y_i * coefficient
    return result


def get_t(x, dots: []):
    return (x - dots[0].x) / (dots[1].x - dots[0].x)


## k - 第几个det，从1开始。 i - 从0开始
def get_det_y(dots: [], i: int, k: int):
    if k == 1:
        return dots[i + 1].y - dots[i].y
    elif k == 0:
        return dots[i].y
    else:
        return get_det_y(dots, i + 1, k - 1) - get_det_y(dots, i, k - 1)


def t_s(x: float, i: int, dots: []):
    k = 0
    result = 1
    while i > 0:
        i = i - 1
        result = result * (get_t(x, dots) - k)
        k = k + 1
    return result


# make sure that x_i - x_i-1 = x_i+1 - x_i
def Newton(dots: [], x: float):
    times = len(dots)
    i = 0
    result = 0
    while times > 0:
        times = times - 1
        if i == 0:
            result = result + dots[0].y
        else:
            result = result + get_det_y(dots, 0, i) * t_s(x, i, dots) / (math.factorial(i))
        i = i + 1
    return result


def get_special_t(x, dots: []):
    mid = 0
    if len(dots) % 2 == 0:
        mid = int(len(dots) / 2 - 1)
    else:
        mid = int((len(dots) - 1) / 2)
    return (x - dots[mid].x) / (dots[1].x - dots[0].x)


## Стирлинга
def Stirling(t: float, dots: []):
    result = 0
    times = len(dots)
    ## 一次循环加一
    i = 0
    ## 两次循环加一
    k = 0
    special = 1
    mid = 0
    if len(dots) % 2 == 0:
        mid = int(len(dots) / 2 - 1)
    else:
        mid = int((len(dots) - 1) / 2)
    while times > 0:
        if i % 2 == 0:
            if i == 0:
                result = result + dots[mid].y
                k = k + 1
            else:
                p1 = special * t ** 2 / math.factorial(i)
                p2 = get_det_y(dots, mid - k, i)
                result = result + p1 * p2
                special = special * (t ** 2 - k ** 2)
                k = k + 1
        else:
            p1 = special * t / math.factorial(i)
            p2 = (get_det_y(dots, mid - k, i) + get_det_y(dots, mid - k + 1, i)) / 2
            result = p1 * p2 + result
        i = i + 1
        times = times - 1
    return result

def dot_table(times: int):
    dots_result = []
    x: float
    print("Please choose the input model")
    print("1)File")
    print("2)Keyboard input")
    model = input()
    if model == "2":
        print("Please input %d dots(x y):" % times)
        while times > 0:
            times = times - 1
            dot_string = input()
            dot_list = dot_string.split(" ")
            x = float(dot_list[0])
            y = float(dot_list[1])
            new_dot = Dot(x, y)
            dots_result.append(new_dot)
    elif model == "1":
        f = input("Please input file name:\n")
        fp = open(f, "r")
        for line in fp:
            dot_list = line.split(" ")
            x = float(dot_list[0])
            y = float(dot_list[1])
            new_dot = Dot(x, y)
            dots_result.append(new_dot)
    print("Please input x:")
    x_s = input()
    x = float(x_s)
    result_y_L = Lagrange(dots_result, x)
    print("Result with Lagrange:%.9f" % result_y_L)
    result_y_N = Newton(dots_result, x)
    print("Result with Newton:%.9f" % result_y_N)
    special_t = get_special_t(x, dots_result)
    if abs(special_t) <= 0.25 and len(dots_result) % 2 != 0:
        result_y_S = Stirling(special_t, dots_result)
        print("Result with Stirling:%.9f" % result_y_S)
    '''if 0.75 >= abs(special_t) >= 0.25 and len(dots_result) %2 == 0:
        result_y_B = Bessel(special_t, dots_result)
        print("Result with Bessel:%.9f" % result_y_B)'''
    x_list = []
    y_list = []
    for i in dots_result:
        x_list.append(i.x)
        y_list.append(i.y)
    x_min = min(x_list)
    x_max = max(x_list)
    xpoints = np.array(x_list)
    ypoints = np.array(y_list)
    plt.plot(xpoints, ypoints, 'o')
    x_range = np.arange(x_min, x_max + 4, 0.1)
    y_range_L = Lagrange(dots_result, x_range)
    plt.plot(x_range, y_range_L, "red",label = "Лагранжа")
    y_range_N = Newton(dots_result, x_range)
    plt.plot(x_range, y_range_N, "black", label = "Ньютона")
    if len(dots_result) % 2 != 0:
        y_range_S = Stirling(get_special_t(x_range, dots_result), dots_result)
        plt.plot(x_range, y_range_S, "purple",label = "Стирлинга")
    '''if len(dots_result) %2 == 0:
        y_range_B = Bessel(get_special_t(x_range, dots_result), dots_result)
        plt.plot(x_range, y_range_B, "Orange")'''
    plt.plot(x, result_y_L, 's', color="green")
    plt.legend()
    plt.show()


def function(N: int):
    times = N
    dots_result = []
    print("Please choose your equations:")
    print("1) ax^3 + bx^2 + cx + d")
    print("2) ae^x + bx^2 + cx + d")
    equation = input()
    string_coeffi = input("Please input the coefficients of your equation(a, b, c and d). Split by space:\n")
    list_coeffi = string_coeffi.split(" ")
    my_function: AbstractFunction
    if equation == "1":
        my_function = FirstFunction(float(list_coeffi[0]), float(list_coeffi[1]), float(list_coeffi[2]),
                                    float(list_coeffi[3]))
    elif equation == "2":
        my_function = SecondFunction(float(list_coeffi[0]), float(list_coeffi[1]), float(list_coeffi[2]),
                                     float(list_coeffi[3]))
    print("Please input %d dots(x):" % times)
    while times > 0:
        times = times - 1
        dot_string = input()
        x = float(dot_string)
        y = my_function.getvalue(x)
        new_dot = Dot(x, y)
        dots_result.append(new_dot)
    print("Please input x:")
    x_s = input()
    x = float(x_s)
    result_y_L = Lagrange(dots_result, x)
    result_y_N = Newton(dots_result, x)
    print("Result with Lagrange:%.9f" % result_y_L)
    print("Result with Newton:%.9f" % result_y_N)
    special_t = get_special_t(x, dots_result)
    if abs(special_t) <= 0.25 and len(dots_result) % 2 != 0:
        result_y_S = Stirling(special_t, dots_result)
        print("Result with Stirling:%.9f" % result_y_S)
    x_list = []
    y_list = []
    for i in dots_result:
        x_list.append(i.x)
        y_list.append(i.y)
    x_min = min(x_list)
    x_max = max(x_list)
    xpoints = np.array(x_list)
    ypoints = np.array(y_list)
    plt.plot(xpoints, ypoints, 'o')
    x_range = np.arange(x_min, x_max + 0.1, 0.1)
    y_range_L = Lagrange(dots_result, x_range)
    plt.plot(x_range, y_range_L, "red", label = "Лагранжа")
    y_range_N = Newton(dots_result, x_range)
    plt.plot(x_range, y_range_N, "black", label = "Ньютона")
    if len(dots_result) % 2 != 0:
        y_range_S = Stirling(get_special_t(x_range, dots_result), dots_result)
        plt.plot(x_range, y_range_S, "purple",label = "Стирлинга")
    plt.plot(x, result_y_N, 's', color="green")
    plt.legend()
    plt.show()
    print(Newton(dots_result,6))



N = 5
dots = []
choice = ""
print("Please choose the model:")
print("1)Function")
print("2)Dot table")
choice = input()
if choice == "2":
    dot_table(N)
elif choice == "1":
    function(N)