import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from collections import Counter
from sklearn.model_selection import train_test_split

data = pd.read_csv("./WineDataset.csv")

print(data)
print(data.describe().T)
print(data.isna().sum())

data_std = (data - data.min()) / (data.max() - data.min())  # Z-score standardize
data_std['Wine'] = data['Wine']

print(data.describe().T)

Y = data_std[["Wine"]]
X = data_std.drop(["Wine"], axis=1)


x_train, x_test, y_train, y_test = train_test_split(X, Y, test_size=0.3, stratify=data.Wine)

print(x_train.shape)
print(x_test.shape)
print(y_train.shape)
print(y_test.shape)


class KNNClassifier:
    def __init__(self, k):
        self.k = k
        self.features = None
        self.labels = None

    def fit(self, features, labels):
        self.features = features.to_numpy()
        self.labels = labels.to_numpy()

    def predict(self, x):
        X = x.to_numpy()

        def inner_pred(x):
            distances = [self.euclidean_distance(x, point) for point in self.features]
            k_indexes = np.argsort(distances)[:self.k]
            k_labels = [self.labels[i] for i in k_indexes]
            k_labels_tuples = [tuple(row) for row in k_labels]

            mode = Counter(k_labels_tuples).most_common()
            return mode[0][0][0]

        return [inner_pred(x) for x in X]

    def euclidean_distance(self, x1, x2):
        return sum((a - b) ** 2 for a, b in zip(x1, x2)) ** 0.5

    def f1_score(self, y_test, pred):
        # Classes = [TP, FP, TN, FN]
        y_test = np.array(y_test).flatten()
        pred = np.array(pred)
        self.TP = 0
        self.FP = 0
        self.TN = 0
        self.FN = 0

        classes = list(set(y_test.tolist()))
        for i, cur_class in enumerate(classes):
            for idx, (el1, el2) in enumerate(zip(y_test, pred)):
                if (el1 == el2 == cur_class):
                    self.TP += 1
                if (el2 == cur_class and el1 != el2):
                    self.FP += 1
                if (el1 == el2 and el1 != cur_class):
                    self.TN += 1
                if (el1 != el2 and el1 != cur_class):
                    self.FN += 1

        return self.TP / (self.TP + (1 / (len(classes))) * (self.FP + self.FN))

K = [3, 5, 10]
for k in K:
    print("k = %d" % k)
    model = KNNClassifier(k)
    model.fit(x_train, y_train)
    pred = model.predict(x_test)

    print(np.array(pred))
    print(np.array(y_test).flatten())
    print("F1 score:", model.f1_score(y_test, pred))
    print("matrix: TP=%4d FP=%4d" % (model.TP, model.FP))
    print("        TN=%4d FN=%4d" % (model.TN, model.FN))

print("end")

