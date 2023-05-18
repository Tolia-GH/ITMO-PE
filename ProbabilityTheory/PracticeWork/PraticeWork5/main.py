import math
import matplotlib.pyplot as plt
import numpy as np


def print_array(arr):
    output = ""
    for i in arr:
        output += str(i) + " "
    print(output)


input_array = [-1.35, -0.42, 0.38, 1.21, 0.35, 1.56, 0.8, 0.14, -1.49, 0.35, -0.34, -0.73, 0.69, 0.55, 1.11, 0.62, 0.93, 0.42, 1.0, -0.48]

print("Исходные данные:")
print_array(input_array)

print("Вариационный ряд:")
var_array = input_array.copy()
var_array.sort()
print_array(var_array)
print()

print("Первая порядковая статистика: ", var_array[0])

print("n-ая порядковая статистика: ", var_array[-1])

print("Размах выборки: ", var_array[-1] - var_array[0])

print()
stat_arr = {i: 0 for i in var_array}
for i in var_array:
    stat_arr[i] += 1

var_data_without_copies = list(set(var_array))
var_data_without_copies.sort()
p_arr = {i: 0 for i in var_array}
for i in var_data_without_copies:
    p_arr[i] = stat_arr[i] / len(var_array)

M = 0
for i in var_data_without_copies:
    M += i * p_arr[i]
print("Математическое ожидание: ", round(M, 7))

D = 0
for i in var_data_without_copies:
    D += ((i - M) ** 2) * stat_arr[i]
D /= len(var_array)
print("Среднеквадратичное отклонение: ", math.sqrt(D))

S = 0
for i in var_data_without_copies:
    S += ((i - M) ** 2) * stat_arr[i]
S /= len(var_array) - 1
print("Исправленное выборочное среднеквадратичное отклонение: ",
      math.sqrt(S))


def F(x):
    ans = 0
    for i in var_data_without_copies:
        if i < x:
            ans += p_arr[i]
    return ans


print()
print("F:")
print(f"Для x <= {var_data_without_copies[0]}: 0")
var_summ = p_arr[var_data_without_copies[0]]
prev = var_data_without_copies[0]
for i in var_data_without_copies[1:]:
    print(f"Для {prev} < x <= {i}: {var_summ}")
    var_summ += p_arr[i]
    var_summ = round(var_summ, 7)
    prev = i
print(f"Для {prev} < x: {var_summ}")
print()

print('Интервальный статистический ряд:')
h = round((var_data_without_copies[-1] - var_data_without_copies[0]) / (1 + math.log(20, 2)), 1)
start = var_data_without_copies[0] - h / 2
finish = start + h
arr_fr1 = []
arr_fr2 = []
num = 0
for i in var_data_without_copies:
    if i < finish:
        num += stat_arr[i]
    else:
        arr_fr1.append((start + finish) / 2)
        arr_fr2.append(num / len(var_array))
        print("[", start, ", ", finish, "): частота: ", num, " частотность: ", num / len(var_array))
        num = 0
        start = finish
        finish = start + h
        num += stat_arr[i]
arr_fr1.append((start + finish) / 2)
arr_fr2.append(num / len(var_array))
print("[", start, ", ", finish, "): частота: ", num, " частотность: ", num / len(var_array))

x = np.linspace(var_array[0] - 0.5, var_array[-1] + 0.5, 10000)
y = [F(i) for i in x]

fig = plt.figure()
ax = fig.add_subplot(1, 1, 1)
ax.spines['left'].set_position('center')
ax.spines['bottom'].set_position('zero')
ax.spines['right'].set_color('none')
ax.spines['top'].set_color('none')
ax.xaxis.set_ticks_position('bottom')
ax.yaxis.set_ticks_position('left')

plt.plot(x, y, 'b')
plt.show()

plt.bar(arr_fr1, arr_fr2)
plt.show()

plt.plot(arr_fr1, arr_fr2, marker="o")
plt.show()
