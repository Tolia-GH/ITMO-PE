import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.metrics import r2_score

# 加载波士顿房价预测数据集
from sklearn.datasets import load_boston
boston = load_boston()
data = pd.DataFrame(boston.data, columns=boston.feature_names)
data['PRICE'] = boston.target

# 1. 可视化数据集的统计数据
print("统计数据：")
print(data.describe())

# 2. 数据预处理
# 处理缺失值（在波士顿房价数据集中通常没有缺失值）
# 分类特征编码（在波士顿房价数据集中不需要，因为所有特征都是数值型）
# 标准化
def standardize(X):
    return (X - X.mean()) / X.std()

# 标准化除目标变量外的所有特征
for feature in boston.feature_names:
    if feature != 'PRICE':
        data[feature] = standardize(data[feature])

# 3. 将数据分为训练数据集和测试数据集
X = data.drop('PRICE', axis=1)
y = data['PRICE']
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# 4. 使用最小二乘法实现线性回归
def least_squares(X, y):
    X_b = np.c_[np.ones((X.shape[0], 1)), X]  # 添加偏置项
    theta = np.linalg.inv(X_b.T.dot(X_b)).dot(X_b.T).dot(y)
    return theta

# 5. 构建具有不同功能集的三个模型
model1_features = ['RM', 'LSTAT']  # 选择两个特征
model2_features = ['CRIM', 'NOX', 'RM', 'AGE', 'DIS']  # 选择五个特征
model3_features = boston.feature_names.tolist()  # 使用所有特征

model1_X_train = X_train[model1_features]
model2_X_train = X_train[model2_features]
model3_X_train = X_train[model3_features]

model1_theta = least_squares(model1_X_train, y_train)
model2_theta = least_squares(model2_X_train, y_train)
model3_theta = least_squares(model3_X_train, y_train)

# 6. 评估性能
def evaluate_model(model_X, model_theta, true_values):
    model_X_b = np.c_[np.ones((model_X.shape[0], 1)), model_X]
    predictions = model_X_b.dot(model_theta)
    r2 = r2_score(true_values, predictions)
    return r2

model1_r2 = evaluate_model(X_test[model1_features], model1_theta, y_test)
model2_r2 = evaluate_model(X_test[model2_features], model2_theta, y_test)
model3_r2 = evaluate_model(X_test[model3_features], model3_theta, y_test)

# 7. 比较三个模型的结果
print("\n模型1（两个特征）的R^2分数：", model1_r2)
print("模型2（五个特征）的R^2分数：", model2_r2)
print("模型3（所有特征）的R^2分数：", model3_r2)