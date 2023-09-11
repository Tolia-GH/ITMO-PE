import numpy as np
import math
import matplotlib as plt


# first choice
def get_f1(x, y):
    return y + (1 + x) * y ** 2


# -1/x
def function1(x):
    return -1 / x


def get_f2(x, y):
    return math.log(x) + 3 * x


# xlnx + 3/2x^2-x-1/2
def function2(x):
    a = np.log(x)
    return x * a + 3 * x ** 2 / 2 - x - 0.5


def Euler(choose:str):
    print("Method Эйлера")
    result = []
    deviation = []
    if choose == "1":
        y = -1
        i = 0
        left = 1
        x0 = left
        print("%-10s %-10s %-10s %-10s %-10s"%("i","xi","yi","f(xi,yi)","Точное решение"))
        while round(x0,4) <= right:
            result.append([x0, y])
            deviation.append(abs(y-function1(x0)))
            print("%-10.0f %-10.4f %-10.4f %-10.4f %-10.4f"%(i,x0,y,get_f1(x0,y),function1(x0)))
            y = y + h*get_f1(x0,y)
            i = i + 1
            x0 = x0 + h
        print("Погрешность:%.4f"%max(deviation))
        return result
    elif choose == "2":
        y = 0
        i = 0
        left = 1
        x0 = left
        print("%-10s %-10s %-10s %-10s %-10s"%("i","xi","yi","f(xi,yi)","Точное решение"))
        while round(x0,4) <= right:
            result.append([x0, y])
            deviation.append(abs(y-function2(x0)))
            print("%-10.0f %-10.4f %-10.4f %-10.4f %-10.4f"%(i,x0,y,get_f2(x0,y),function2(x0)))
            y = y + h*get_f2(x0,y)
            i = i + 1
            x0 = x0 + h
        print("Погрешность:%.4f"%max(deviation))
        return result


def Runge_Kutta(choose:str):
    print("Method Рунге-Кутта")
    if choose == "1":
        y = -1
        i = 0
        left = 1
        x0 = left
        print("%-10s %-10s %-10s %-10s"%("i","xi","yi","Точное решение"))
        result = []
        deviation = []
        while round(x0,4) <= right:
            deviation.append(abs(function1(x0) - y))
            result.append([x0,y])
            print("%-10.0f %-10.4f %-10.6f %-10.6f"%(i,x0,y,function1(x0)))
            k1 = get_f1(x0,y)*h
            k2 = get_f1(x0+h/2,y+k1/2)*h
            k3 = get_f1(x0+h/2, y+k2/2)*h
            k4 = get_f1(x0+h, y+k3)*h
            y = y + (k1+2*k2+2*k3+k4)/6
            i = i + 1
            x0 = x0 + h
        print("Погрешность:%.8f"%max(deviation))
        return result
    else:
        y = 0
        i = 0
        left = 1
        x0 = left
        print("%-10s %-10s %-10s %-10s"%("i","xi","yi","Точное решение"))
        result = []
        deviation = []
        while round(x0,4) <= right:
            deviation.append(abs(function2(x0) - y))
            result.append([x0,y])
            print("%-10.0f %-10.4f %-10.6f %-10.6f"%(i,x0,y,function2(x0)))
            k1 = get_f2(x0,y)*h
            k2 = get_f2(x0+h/2,y+k1/2)*h
            k3 = get_f2(x0+h/2, y+k2/2)*h
            k4 = get_f2(x0+h, y+k3)*h
            y = y + (k1+2*k2+2*k3+k4)/6
            i = i + 1
            x0 = x0 + h
        print("Погрешность:%.8f"%max(deviation))
        return result
def Andamc(choose,Ry):
    if choose == "1":
        i = 0
        y0_3 = []
        x0_3 = [1, 1+h, 1+2*h, 1+3*h]
        y0_3.append(-1)
        left = 1
        result = []
        times = (right - left) / h
        dievation = []
        if times < 4:
            print("Метод Адмаса не подходит")
            return []
        while i < 3:
            y0_3.append(Ry[i+1][1])
            i = i + 1
        i = 0
        print("Метод Адамса")
        print("%-10s %-10s %-10s %-10s"%("i","xi","yi","Точное решение"))
        while i < 4:
            print("%-10.0f %-10.4f %-10.4f %-10.4f"%(i, x0_3[i], y0_3[i],function1(x0_3[i])))
            dievation.append(abs(function1(x0_3[i])-y0_3[i]))
            result.append([x0_3[i],y0_3[i]])
            i = i + 1
        ## i = 4
        f0 = get_f1(x0_3[0],y0_3[0])
        f1 = get_f1(x0_3[1],y0_3[1])
        f2 = get_f1(x0_3[2],y0_3[2])
        f3 = get_f1(x0_3[3],y0_3[3])
        times = times - 3
        y = y0_3[3]
        x = x0_3[3]
        while times > 0:
            det_1_f = f3 - f2
            det_2_f = f3 - 2*f2 + f1
            det_3_f = f3 - 3*f2 + 3*f1 - f0
            y = y + h*get_f1(x,y) + h**2*det_1_f/2 + 5*h**3*det_2_f/12 + 3*h**4*det_3_f/8
            x = x + h
            dievation.append(abs(function1(x)-y))
            result.append([x,y])
            print("%-10.0f %-10.4f %-10.4f %-10.4f"%(i, x, y,function1(x)))
            f0 = f1
            f1 = f2
            f2 = f3
            f3 = get_f1(x,y)
            times = times - 1
            i = i + 1
        print("Погрешность:%.8f"%max(dievation))
    elif choose == "2":
        i = 0
        y0_3 = []
        x0_3 = [1, 1+h, 1+2*h, 1+3*h]
        y0_3.append(0)
        left = 1
        result = []
        times = (right - left) / h
        dievation = []
        if times < 4:
            print("Метод Адмаса не подходит")
            return []
        while i < 3:
            y0_3.append(Ry[i+1][1])
            i = i + 1
        i = 0
        print("Метод Адамса")
        print("%-10s %-10s %-10s %-10s"%("i","xi","yi","Точное решение"))
        while i < 4:
            print("%-10.0f %-10.4f %-10.4f %-10.4f"%(i, x0_3[i], y0_3[i],function2(x0_3[i])))
            dievation.append(abs(function2(x0_3[i])-y0_3[i]))
            result.append([x0_3[i],y0_3[i]])
            i = i + 1
        ## i = 4
        f0 = get_f2(x0_3[0],y0_3[0])
        f1 = get_f2(x0_3[1],y0_3[1])
        f2 = get_f2(x0_3[2],y0_3[2])
        f3 = get_f2(x0_3[3],y0_3[3])
        times = times - 3
        y = y0_3[3]
        x = x0_3[3]
        while times > 0:
            det_1_f = f3 - f2
            det_2_f = f3 - 2*f2 + f1
            det_3_f = f3 - 3*f2 + 3*f1 - f0
            y = y + h*get_f2(x,y) + h**2*det_1_f/2 + 5*h**3*det_2_f/12 + 3*h**4*det_3_f/8
            x = x + h
            dievation.append(abs(function2(x)-y))
            result.append([x,y])
            print("%-10.0f %-10.4f %-10.4f %-10.4f"%(i, x, y,function2(x)))
            f0 = f1
            f1 = f2
            f2 = f3
            f3 = get_f2(x,y)
            times = times - 1
            i = i + 1
        print("Погрешность:%.8f"%max(dievation))
    return result

print("Please choose a formal:")
print("1)y'=y+(1+x)y^2,y(1)=-1")
print("2)y'=lnx+3x,y(1)=0")
func = input()
inter = input("Правая граница:")
right = float(inter)
h_string = input("Please input the gap:")
h = float(h_string)
# Эйлера
result_O = []
result_O = Euler(func, result_O, h)
count = 0
while count < len(result_O) - 1:
    if count == 0:
        plt.plot([result_O[count][0], result_O[count + 1][0]], [result_O[count][1], result_O[count + 1][1]],
                 color="red",
                 label="Эйлера")
    else:
        plt.plot([result_O[count][0], result_O[count + 1][0]], [result_O[count][1], result_O[count + 1][1]],
                 color="red")
    count = count + 1
print("")
# Рунге-Кутта
result_R = []
result_R_and_gap = Runge_Kutta(func, result_R, h)
result_R = result_R_and_gap['result']
Andamc_gap = result_R_and_gap['gap']
count = 0
while count < len(result_R) - 1:
    if count == 0:
        plt.plot([result_R[count][0], result_R[count + 1][0]], [result_R[count][1], result_R[count + 1][1]],
                 color="blue",
                 label="Рунге-Кутта")
    else:
        plt.plot([result_R[count][0], result_R[count + 1][0]], [result_R[count][1], result_R[count + 1][1]],
                 color="blue")
    count = count + 1
plt.legend()
print("")
# Адамса
result_A = []
result_A = Andamc(func, result_R, Andamc_gap)
if len(result_A) != 0:
    count = 0
    while count < len(result_A) - 1:
        if count == 0:
            plt.plot([result_A[count][0], result_A[count + 1][0]], [result_A[count][1], result_A[count + 1][1]],
                     color="orange",
                     label="Адамса")
        else:
            plt.plot([result_A[count][0], result_A[count + 1][0]], [result_A[count][1], result_A[count + 1][1]],
                     color="orange")
        count = count + 1
    plt.legend()
print("")
# Точное
left = 1
x_range = np.arange(left, right, 0.01)
if func == "1":
    y_range = function1(x_range)
    plt.plot(x_range, y_range, color="green", label="Точное решение")
elif func == "2":
    y_range = function2(x_range)
    plt.plot(x_range, y_range, color="green", label="Точное решение")
plt.legend()

plt.show()

print("Finished")