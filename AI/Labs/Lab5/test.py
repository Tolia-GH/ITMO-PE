import pandas as pd
import random


# 1. 从CSV文件中读取数据并进行预处理
def preprocess_data(file_path):
    # 读取CSV文件
    data = pd.read_csv(file_path)

    # 处理缺失值
    data = data.dropna()

    # 分类特征编码
    data = pd.get_dummies(data)

    # 缩放（这里简化为不进行缩放，实际情况可能需要根据数据情况进行标准化或归一化）

    return data


# 2. 实现k近邻方法
class KNN:
    def __init__(self, k, features):
        self.k = k
        self.features = features

    def fit(self, X_train, y_train):
        self.X_train = X_train
        self.y_train = y_train

    def predict(self, X_test):
        predictions = []
        for test_point in X_test:
            distances = [self.distance(test_point, train_point) for train_point in self.X_train]
            k_nearest_indices = sorted(range(len(distances)), key=lambda i: distances[i])[:self.k]
            k_nearest_labels = [self.y_train[i] for i in k_nearest_indices]
            prediction = max(set(k_nearest_labels), key=k_nearest_labels.count)
            predictions.append(prediction)
        return predictions

    def distance(self, point1, point2):
        # 欧几里德距离
        return sum((x - y) ** 2 for x, y in zip(point1, point2)) ** 0.5


# 3. 构建两个具有不同特征集的 k-NN 模型
def build_model1(data, k_values):
    random_features = random.sample(list(data.columns), 3)  # 随机选择3个特征
    X_model1 = data[random_features]
    y_model1 = data['Wine']  # 请替换成实际的目标列名

    models = {}
    for k in k_values:
        knn_model = KNN(k, random_features)
        knn_model.fit(X_model1.values, y_model1.values)
        models[f'Model1_k={k}'] = knn_model

    return models


def build_model2(data, k_values):
    fixed_features = ['Alcohol', 'Malic Acid', 'Magnesium']  # 请替换成实际的特征列名
    X_model2 = data[fixed_features]
    y_model2 = data['Wine']  # 请替换成实际的目标列名

    models = {}
    for k in k_values:
        knn_model = KNN(k, fixed_features)
        knn_model.fit(X_model2.values, y_model2.values)
        models[f'Model2_k={k}'] = knn_model

    return models


# 4. 对于每个模型，在不同的 k 值下对测试数据集进行评估，构造误差矩阵
def evaluate_model(model, X_test, y_test):
    confusion_matrix = pd.DataFrame(0, index=model.keys(), columns=model.keys())

    for model_name, knn_model in model.items():
        predictions = knn_model.predict(X_test.values)
        for true_label, predicted_label in zip(y_test.values, predictions):
            confusion_matrix.loc[true_label, predicted_label] += 1

    return confusion_matrix


# 使用示例
file_path = 'WineDataset.csv'  # 请替换成实际的文件路径
k_values = [3, 5, 10]

# 1. 数据预处理
wine_data = preprocess_data(file_path)

# 2. 构建模型1和模型2
model1 = build_model1(wine_data, k_values)
model2 = build_model2(wine_data, k_values)

# 3. 假设有测试数据集 X_test 和真实标签 y_test，这里仅作示例，实际使用时请替换成真实的测试数据
X_test = wine_data.sample(frac=0.2)  # 从数据中随机选择一部分作为测试数据
y_test = X_test['Wine']  # 请替换成实际的目标列名

# # 4. 评估模型1和模型2
# confusion_matrix_model1 = evaluate_model(model1, X_test, y_test)
# confusion_matrix_model2 = evaluate_model(model2, X_test, y_test)
#
# print("Confusion Matrix for Model 1:")
# print(confusion_matrix_model1)
#
# print("\nConfusion Matrix for Model 2:")
# print(confusion_matrix_model2)
