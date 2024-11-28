import numpy as np

# 定义状态集合
states = []
for A in [0, 1]:  # 服务器1的占用状态
    for B in [0, 1]:  # 服务器2的占用状态
        for C in range(5 if A == 1 else 1):  # 服务器1缓冲区
            for D in range(2 if B == 1 else 1):  # 服务器2缓冲区
                states.append((A, B, C, D))

# 状态数量
num_states = len(states)

# 初始化转移强度矩阵
Q = np.zeros((num_states, num_states))

# 参数
λ = 0.3  # 到达强度
p1 = 0.4  # 选择服务1的概率
p2 = 0.6  # 选择服务2的概率
μ = 0.05  # 处理完成的强度

# 定义状态转移逻辑
for i, (A, B, C, D) in enumerate(states):
    # 到达请求的转移
    if A == 1 and C < 4:  # 到达请求选择服务器1，且缓冲区未满
        new_state = (A, B, C + 1, D)
        j = states.index(new_state)
        Q[i, j] += λ * p1
    if A == 0:  # 到达请求选择服务器1，服务器空闲
        new_state = (1, B, 0, D)
        j = states.index(new_state)
        Q[i, j] += λ * p1
    if B == 1 and D < 1:  # 到达请求选择服务器2，且缓冲区未满
        new_state = (A, B, C, D + 1)
        j = states.index(new_state)
        Q[i, j] += λ * p2
    if B == 0:  # 到达请求选择服务器2，服务器空闲
        new_state = (A, 1, C, 0)
        j = states.index(new_state)
        Q[i, j] += λ * p2

    # 服务完成的转移
    if A == 1:  # 服务器1处理完成
        if C > 0:  # 缓冲区中有请求
            new_state = (A, B, C - 1, D)
        else:  # 无缓冲请求
            new_state = (0, B, 0, D)
        j = states.index(new_state)
        Q[i, j] += μ
    if B == 1:  # 服务器2处理完成
        if D > 0:  # 缓冲区中有请求
            new_state = (A, B, C, D - 1)
        else:  # 无缓冲请求
            new_state = (A, 0, C, 0)
        j = states.index(new_state)
        Q[i, j] += μ

# 对角线元素调整为负的出强度
for i in range(num_states):
    Q[i, i] = -np.sum(Q[i, :])

# 输出转移强度矩阵
np.set_printoptions(precision=3, suppress=True)
print("状态转移强度矩阵 Q:")
print(Q)

