import numpy as np
import matplotlib.pyplot as plt

# 生成一些示例数据
np.random.seed(42)
num_samples = 100
X1 = 2 * np.random.rand(num_samples, 1)
X2 = 3 * np.random.rand(num_samples, 1)
y = 4 + 2 * X1 + 3 * X2 + np.random.randn(num_samples, 1)

# 将偏置项加入X矩阵
X_b = np.c_[np.ones((num_samples, 1)), X1, X2]

# 使用正规方程求解多元线性回归参数
theta = np.linalg.inv(X_b.T.dot(X_b)).dot(X_b.T).dot(y)

# 打印回归参数
print("回归参数 (theta):")
print(theta)

# 生成新的数据点进行预测
new_X1 = np.linspace(0, 2, 10).reshape(-1, 1)
new_X2 = np.linspace(0, 3, 10).reshape(-1, 1)
new_X_b = np.c_[np.ones((10, 1)), new_X1, new_X2]
predictions = new_X_b.dot(theta)

# 绘制原始数据和回归线
fig = plt.figure(figsize=(10, 6))
ax = fig.add_subplot(111, projection='3d')
ax.scatter(X1, X2, y, color='blue', label='Original Data')
ax.plot(new_X1, new_X2, predictions, color='red', label='Regression Line')
ax.set_xlabel('X1')
ax.set_ylabel('X2')
ax.set_zlabel('Y')
ax.legend()
plt.title('多元线性回归示例')
plt.show()
