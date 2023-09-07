import sys
import math
from abc import ABC, abstractmethod
import matplotlib.pyplot as plt
import numpy as np


def min(list_num):
    result = list_num[0]
    for i in list_num:
        if i < result:
            result = i
    return result


def third_po_count(x, a, b, c, d):
    return a*x**3 + b*x**2 + c*x +d


def log_count(x_i, a, b):
    return math.log(round(x_i, 3))*a+b


def max(list_num):
    result = list_num[0]
    for i in list_num:
        if i > result:
            result = i
    return result


def is_digit(d: str):
    if d[0] == "-":
        d = d[1:]
    l = d.split(".")
    if len(l) != 2 and len(l) != 1:
        return False
    for i in l:
        if not i.isdigit():
            return False
    return True


def formate_num(num: float):
    if num>0:
        return "+" + str(num)
    elif num<0:
        return str(num)
    else:
        return ""

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

    @abstractmethod
    def to_string(self):
        pass


class LinerFunction(AbstractFunction):
    def __init__(self, a, b, c, d):
        super().__init__(a, b, c, d)

    def getvalue(self, x: float):
        return self.a * x ** 3 + self.b * x ** 2 + self.c * x + self.d

    def to_string(self):
        s1 = ""
        s2 = ""
        s3 = ""
        s4 = ""
        if self.a != 0.0:
            s1 = str(round(self.a, 2)) + "x^3"
        if self.b != 0.0:
            s2 = formate_num(round(self.b, 2)) + "x^2"
        if self.c != 0.0:
            s3 = formate_num(round(self.c, 2)) + "x"
        if self.d != 0.0:
            s4 = formate_num(round(self.d, 2))
        return s1+s2+s3+s4


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


class InputError(Exception):
    def __init__(self, info):
        super().__init__(self)
        self.errorInfo = info

    def __str__(self):
        return self.errorInfo


class Solver(ABC):
    dots: []
    N = 0

    def __init__(self, dots_list: [], N):
        self.dots = dots_list
        self.N = N

    def sx(self):
        sum = 0
        for i in self.dots:
            sum = sum + i.get_x()
        return sum

    def sy(self):
        sum = 0
        for i in self.dots:
            sum = sum + i.get_y()
        return sum

    def sxx(self):
        sum = 0
        for i in self.dots:
            sum = sum + i.get_x()*i.get_x()
        return sum

    def sxy(self):
        sum = 0
        for i in self.dots:
            sum = sum + i.get_x()*i.get_y()
        return sum

    def sxxx(self):
        sum = 0
        for i in self.dots:
            sum = sum + i.get_x()*i.get_x()*i.get_x()
        return sum

    def sxxy(self):
        sum = 0
        for i in self.dots:
            sum = sum + i.get_x()*i.get_x()*i.get_y()
        return sum

    def sxxxy(self):
        sum = 0
        for i in self.dots:
            sum = sum + i.get_x()*i.get_x()*i.get_x()*i.get_y()
        return sum

    def sxxxx(self):
        sum = 0
        for i in self.dots:
            sum = sum + i.get_x()*i.get_x()*i.get_x()*i.get_x()
        return sum

    def sxxxxx(self):
        sum = 0
        for i in self.dots:
            sum = sum + i.get_x()*i.get_x()*i.get_x()*i.get_x()*i.get_x()
        return sum

    def sxxxxxx(self):
        sum = 0
        for i in self.dots:
            sum = sum + i.get_x()*i.get_x()*i.get_x()*i.get_x()*i.get_x()*i.get_x()
        return sum

    @abstractmethod
    def solve(self):
        pass


class LinerSolver(Solver):
    def __init__(self, dots_list: [], N):
        super().__init__(dots_list, N)

    def solve(self):
        a = 0
        b = 0
        c = (self.sxy()*self.N - self.sx()*self.sy())/(self.sxx()*self.N - self.sx()*self.sx())
        d = (self.sxx()*self.sy() - self.sx()*self.sxy()) / (self.sxx()*self.N - self.sx()*self.sx())
        average_x = self.sx()/self.N
        average_y = self.sy()/self.N
        numerator = 0
        denominator = 0
        denominator_a = 0
        denominator_b = 0
        for i in self.dots:
            numerator = numerator + (i.get_x()-average_x)*(i.get_y()-average_y)
            denominator_a = denominator_a + (i.get_x()-average_x)**2
            denominator_b = denominator_b + (i.get_y()-average_y)**2
        denominator = (denominator_a*denominator_b)**0.5
        r = numerator/denominator
        print("Коэффициент корреляции Пирсона линейной зависимости: %.4f" % r)
        return LinerFunction(a, b, c, d)


class Second_Order_Polynomial_Solver(Solver):
    def __init__(self, dots_list: [], N):
        super().__init__(dots_list, N)

    def solve(self):
        A = np.array([
            [self.N, self.sx(), self.sxx()],
            [self.sx(), self.sxx(), self.sxxx()],
            [self.sxx(), self.sxxx(), self.sxxxx()]
        ])
        if np.linalg.det(A) == 0:
            raise InputError("These points can't be dealt with third order polynomial solver")
        B = [self.sy(), self.sxy(), self.sxxy()]
        answer = np.dot(np.linalg.inv(A), B)
        return LinerFunction(0, answer[2], answer[1], answer[0])


class Third_Order_Polynomial_Solver(Solver):
    def __init__(self, dots_list: [], N):
        super().__init__(dots_list, N)

    def solve(self):
        A = np.array([
            [self.N, self.sx(), self.sxx(), self.sxxx()],
            [self.sx(), self.sxx(), self.sxxx(), self.sxxxx()],
            [self.sxx(), self.sxxx(), self.sxxxx(), self.sxxxxx()],
            [self.sxxx(), self.sxxxx(), self.sxxxxx(), self.sxxxxxx()]
        ])
        if np.linalg.det(A) == 0:
            raise InputError("These points can't be dealt with third order polynomial solver")
        B = [self.sy(), self.sxy(), self.sxxy(), self.sxxxy()]
        answer = np.dot(np.linalg.inv(A), B)
        return LinerFunction(answer[3], answer[2], answer[1], answer[0])


N = 4
times = N
x_s = []
y_s = []
dots = []
dot_string_list = []
try:
    choice = input("Please choose the input model 'file/input':\n")
    choice = choice.lower()
    if choice == "input":
        print("Please input %d points, which are seperated by space 'x y'" % N)
        while times > 0:
            times = times - 1
            dot_string = input()
            dot_string_list = dot_string.split(" ")
            for s in dot_string_list:
                if not is_digit(s):
                    raise InputError("Please input number for coordinate")
            if len(dot_string_list) != 2:
                raise InputError("Please make sure that you only input 2 num")
            x = float(dot_string_list[0])
            y = float(dot_string_list[1])
            dots.append(Dot(x, y))
            x_s.append(x)
            y_s.append(y)
    elif choice == "file":
        f = input("Please input file name:\n")
        fp = open(f, "r")
        for line in fp:
            dot_string_list = line.split(" ")
            dot_string_list[1] = dot_string_list[1].strip("\n")
            for s in dot_string_list:
                if not is_digit(s):
                    raise InputError("Please input number for coordinate")
            if len(dot_string_list) != 2:
                raise InputError("Please make sure that you only input 2 num")
            x = float(dot_string_list[0])
            y = float(dot_string_list[1])
            dots.append(Dot(x, y))
            x_s.append(x)
            y_s.append(y)
        if len(dots) != N:
            raise InputError("Make sure that amount dots in your file is 10")
    # liner
    print("--------------------------------------------------------------")
    print("Функция линейной зависимости в разработке")
    liner_solver = LinerSolver(dots, N)
    liner_one = liner_solver.solve()
    print(liner_one.to_string())
    print("--------------------------------------------------------------")
    # second order polynomial
    print("Полиномиальная функция 2-й степени в разработке ")
    se_poly_going = True
    try:
        second_order_polynomial_solver = Second_Order_Polynomial_Solver(dots, N)
        second_order_polynomial_one = second_order_polynomial_solver.solve()
        print(second_order_polynomial_one.to_string())
    except InputError as ie:
        print(ie)
        se_poly_going = False
    print("--------------------------------------------------------------")
    # power function
    power_going = True
    print("Стенпенная функция в разработке ")
    po_dots = []
    for i in dots:
        if i.get_y()>0 and i.get_x()>0:
            new_y = math.log(i.get_y())
            new_x = math.log(i.get_x())
            po_dots.append(Dot(new_x, new_y))
        else:
            power_going = False
    if power_going:
        po_solver = LinerSolver(po_dots, N)
        po_one = po_solver.solve()
        print(po_one.to_string())
    else:
        print("Not all points can be dealt with power method")
    print("--------------------------------------------------------------")
    # log function y = alnx + b
    print("Логарифмическая функция в разработке ")
    log_dots = []
    log_one: AbstractFunction
    log_going = True
    for i in dots:
        if i.get_x() > 0:
            new_x = math.log(i.get_x())
            log_dots.append(Dot(new_x, i.get_y()))
        else:
            log_going = False
            break
    if log_going:
        log_solver = LinerSolver(log_dots, N)
        log_one = log_solver.solve()
        print(log_one.to_string())
    else:
        print("These points can't be dealt with log function")
    print("--------------------------------------------------------------")
    # exponential function
    print("Экспоненциальная функция в разработке ")
    ex_dots = []
    ex_going = True
    ex_one: AbstractFunction
    for i in dots:
        if i.get_y()>0:
            new_y = math.log(i.get_y())
            ex_dots.append(Dot(i.get_x(), new_y))
        else:
            ex_going = False
            break
    if not ex_going:
        print("These points can't be dealt with exponential function")
    else:
        ex_solver = LinerSolver(ex_dots, N)
        ex_one = ex_solver.solve()
        print(ex_one.to_string())
    print("--------------------------------------------------------------")
    # third order polynomial
    print("Полиномиальная функция 3-й степени в разработке ")
    third_po_going = True
    try:
        third_order_polynomial_solver = Third_Order_Polynomial_Solver(dots, N)
        third_order_polynomial_one = third_order_polynomial_solver.solve()
        print(third_order_polynomial_one.to_string())
    except InputError as i:
        print(i)
        third_po_going = False
    print("--------------------------------------------------------------")
    # Here we start drawing graph
    x_min = min(x_s)
    x_max = max(x_s)
    y_min = min(y_s)
    y_max = max(y_s)
    xpoints = np.array(x_s)
    ypoints = np.array(y_s)
    plt.plot(xpoints, ypoints, 'o')
    x_range = np.arange(x_min-1, x_max+1, 0.1)
    # liner
    y_range = liner_one.a * x_range**3 + liner_one.b * x_range**2 + liner_one.c * x_range + liner_one.d
    lab1 = "liner(" + liner_one.to_string() + ")"
    plt.plot(x_range, y_range, "red", label=lab1)
    # second order polynomial
    if se_poly_going:
        y_range = second_order_polynomial_one.a * x_range**3 + second_order_polynomial_one.b*x_range**2 + second_order_polynomial_one.c*x_range + second_order_polynomial_one.d
        lab2 = "poly_second(" + second_order_polynomial_one.to_string() + ")"
        plt.plot(x_range, y_range, "blue", label=lab2)
    # power function
    if power_going:
        y_range = math.exp(round(po_one.d, 5))*x_range**round(po_one.c, 5)
        lab3 = "power(" + str(round(math.exp(po_one.d), 2))+"x^" + str(round(po_one.c, 2)) + ")"
        plt.plot(x_range, y_range, "yellow", label=lab3)
    # log
    if log_going:
        if x_min <= 1:
            x_range = np.arange(0.1, x_max + 1, 0.1)
        y_range = [log_count(x_i, log_one.c, log_one.d) for x_i in x_range]
        lab4 = "log(" + str(round(log_one.c, 2)) + "lnx+" + str(round(log_one.d, 2)) + ")"
        plt.plot(x_range, y_range, "green", label=lab4)
    # exponential
    if ex_going:
        x_range = np.arange(x_min - 1, x_max + 1, 0.1)
        y_range = [math.exp(ex_one.d)*math.exp(ex_one.c*x_i) for x_i in x_range]
        lab5 = "exponential(" + str(round(ex_one.d, 2)) + "e^" + str(round(ex_one.c, 2))+"x)"
        plt.plot(x_range, y_range, "black", label=lab5)
    # third polynomial
    if third_po_going:
        y_range = [third_order_polynomial_one.getvalue(x_i) for x_i in x_range]
        label_a = str(round(third_order_polynomial_one.a, 2))
        label_b = formate_num(round(third_order_polynomial_one.b, 2))
        label_c = formate_num(round(third_order_polynomial_one.c, 2))
        label_d = formate_num(round(third_order_polynomial_one.d, 2))
        lab6 = "poly_third(" + label_a + "x^3" + label_b + "x^2" + label_c + "x" + label_d + ")"
        plt.plot(x_range, y_range, "orange", label=lab6)
    plt.legend()
    plt.show()
    # find the best
    # liner
    best_function = "Функция линейной зависимости"
    best_value = 0
    temp = 0
    for i in dots:
        temp = temp + ( liner_one.getvalue(i.get_x()) - i.get_y())**2
    temp = (temp/N)**0.5
    print("For power function, it's Среднеквадратичное отклонение:%f" % temp)
    best_value = temp
    # power
    if power_going:
        temp = 0
        for i in dots:
            temp = temp + (math.exp(po_one.d) * i.get_x() ** po_one.c - i.get_y())**2
        temp = (temp/N)**0.5
        print("For power function, it's Среднеквадратичное отклонение:%f"%temp)
        if temp < best_value:
            best_value = temp
            best_function = "степенная функция"
    # second order polynomial
    if se_poly_going:
        temp = 0
        for i in dots:
            temp = temp + (second_order_polynomial_one.getvalue(i.get_x()) - i.get_y())**2
        temp = (temp/N)**0.5
        print("For second order polynomial function, it's Среднеквадратичное отклонение:%f" % temp)
        if temp < best_value:
            best_value = temp
            best_function = "полиномиальная функция 2-й степени"
    # third order polynomial
    if third_po_going:
        temp = 0
        for i in dots:
            temp = temp + (third_order_polynomial_one.getvalue(i.get_x()) - i.get_y())**2
        temp = (temp/N)**0.5
        print("For third order polynomial, it's Среднеквадратичное отклонение:%f" % temp)
        if temp < best_value:
            best_value = temp
            best_function = "полинаминальная функция 3-й степени"
    # log
    if log_going:
        temp = 0
        for i in dots:
            temp = temp + (log_count(i.get_x(), log_one.c, log_one.d) - i.get_y())**2
        temp = (temp/N)**0.5
        print("For log function, it's Среднеквадратичное отклонение:%f" % temp)
        if temp < best_value:
            best_value = temp
            best_function = "логарифмическая функция"
    # exponential function
    if ex_going:
        temp = 0
        for i in dots:
            temp = temp + (math.exp(ex_one.d)*math.exp(ex_one.c*i.get_x()) - i.get_y())**2
        temp = (temp/N)**0.5
        print("For exponential function, it's Среднеквадратичное отклонение:%f" % temp)
        if temp < best_value:
            best_value = temp
            best_function = "экспоненциальная функция"
    print("The best function is %s with coefficient:%.20f" % (best_function, best_value))
except InputError as i:
    print(i)