import numpy as np
import pandas as pd

# 生成示例数据
np.random.seed(42)
num_samples = 100
X1 = 2 * np.random.rand(num_samples, 1)
X2 = 3 * np.random.rand(num_samples, 1)
y = 4 + 2 * X1 + 3 * X2 + np.random.randn(num_samples, 1)

# 将数据转为DataFrame
data = pd.DataFrame(np.column_stack([X1, X2, y]), columns=['X1', 'X2', 'Y'])

# 可视化数据集的统计数据
print("统计数据:")
print(data.describe())

# 处理缺失值（这里示例数据没有缺失值，实际应用中可能需要处理）
# 处理分类特征编码（这里示例数据没有分类特征，实际应用中可能需要处理）

# 标准化数据
def standardize_data(data):
    mean = data.mean()
    std = data.std()
    standardized_data = (data - mean) / std
    return standardized_data, mean, std

X_std, X_mean, X_std_dev = standardize_data(data[['X1', 'X2']])
y_std, y_mean, y_std_dev = standardize_data(data[['Y']])

# 将数据分为训练数据集和测试数据集
def train_test_split(X, y, test_size=0.2):
    num_samples = len(X)
    num_test = int(test_size * num_samples)
    indices = np.random.permutation(num_samples)
    test_indices = indices[:num_test]
    train_indices = indices[num_test:]
    X_train, X_test = X.iloc[train_indices], X.iloc[test_indices]
    y_train, y_test = y.iloc[train_indices], y.iloc[test_indices]
    return X_train, X_test, y_train, y_test

X_train, X_test, y_train, y_test = train_test_split(X_std, y_std)

# 使用最小二乘法实现线性回归
def linear_regression(X, y):
    X_b = np.c_[np.ones((len(X), 1)), X]
    theta_best = np.linalg.inv(X_b.T.dot(X_b)).dot(X_b.T).dot(y)
    return theta_best

# 训练模型
theta_model1 = linear_regression(X_train, y_train)

# 预测测试集
X_test_b = np.c_[np.ones((len(X_test), 1)), X_test]
y_pred = X_test_b.dot(theta_model1)

# 评估性能
def r2_score(y_true, y_pred):
    ssr = ((y_pred - y_true) ** 2).sum()
    sst = ((y_true - y_true.mean()) ** 2).sum()
    r2 = 1 - (ssr / sst)
    return r2

r2_model1 = r2_score(y_test.values, y_pred)

# 打印模型1的结果
print("模型1 - 系数:")
print(theta_model1)
print("模型1 - R^2 分数:", r2_model1)
print()

# 构建其他两个模型（这里只是示例，实际应用中需要根据问题进行选择）

# 比较三个模型的结果
# 这里只是简单地比较 R^2 分数，实际应用中可能需要更复杂的比较和评估
# if r2_model1 > r2_model2 and r2_model1 > r2_model3:
#     print("模型1表现最好")
# elif r2_model2 > r2_model1 and r2_model2 > r2_model3:
#     print("模型2表现最好")
# else:
#     print("模型3表现最好")