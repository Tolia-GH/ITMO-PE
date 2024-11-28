import numpy as np

# 定义状态空间
states = [
    (0, 0, 0, 0), (0, 0, 1, 0), (0, 1, 0, 0), (0, 1, 0, 1), (0, 1, 0, 2),
    (0, 1, 1, 0), (0, 1, 1, 1), (0, 1, 1, 2),
    (1, 0, 0, 0), (1, 0, 1, 0), (1, 1, 0, 0), (1, 1, 0, 1), (1, 1, 0, 2),
    (1, 1, 1, 0), (1, 1, 1, 1), (1, 1, 1, 2)
]

# 状态数
num_states = len(states)

# 定义到达强度 λ 和处理强度 μ
lambda_ = 0.3  # 请求到达强度
mu = 0.05  # 请求处理强度
p_service1 = 0.4  # 选择服务1的概率
p_service2 = 0.55  # 选择服务2的概率
p_service3 = 0.05  # 选择服务3的概率

# 初始化状态转移矩阵
transition_matrix = np.zeros((num_states, num_states))

# 定义从一个状态到另一个状态的转移强度
for i, state_from in enumerate(states):
    A, B, C, D = state_from

    # 处理到达请求的情况
    # 1. 请求到达并且选择服务1 (A)
    if A == 0:  # 服务1空闲
        to_state = (1, B, C, D)  # 服务1开始处理请求
        transition_matrix[i][states.index(to_state)] += lambda_ * p_service1

    # 2. 请求到达并且选择服务2 (B)
    if B == 0 and D < 2:  # 服务2空闲并且缓冲区未满
        to_state = (A, 1, C, D + 1)  # 服务2开始处理请求并且缓冲区加1
        transition_matrix[i][states.index(to_state)] += lambda_ * p_service2
    elif B == 0 and D == 2:  # 服务2空闲但缓冲区满
        to_state = (A, 0, C, D)  # 请求被丢弃，状态不变
        transition_matrix[i][states.index(to_state)] += lambda_ * p_service2

    # 3. 请求到达并且选择服务3 (C)
    if C == 0:  # 服务3空闲
        to_state = (A, B, 1, D)  # 服务3开始处理请求
        transition_matrix[i][states.index(to_state)] += lambda_ * p_service3

    # 处理请求完成的情况（即状态的离开）
    # 4. 服务1处理完成
    if A == 1:
        to_state = (0, B, C, D)  # 服务1空闲，状态变为服务1空闲
        transition_matrix[i][states.index(to_state)] += mu

    # 5. 服务2处理完成
    if B == 1:
        to_state = (A, 0, C, D)  # 服务2空闲，状态变为服务2空闲
        transition_matrix[i][states.index(to_state)] += mu

    # 6. 服务3处理完成
    if C == 1:
        to_state = (A, B, 0, D)  # 服务3空闲，状态变为服务3空闲
        transition_matrix[i][states.index(to_state)] += mu

# 输出转移矩阵
print("状态转移矩阵：")
print(transition_matrix)

