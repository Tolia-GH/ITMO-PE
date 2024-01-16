import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

data = pd.read_csv("./Student_Performance.csv")

data.head(5)

data.info()

print(data.describe().T)

print(data.describe(include=object).T)

print(data['Extracurricular Activities'].value_counts())

print(data.isna().sum())

data['Extracurricular Activities'] = data['Extracurricular Activities'].replace({"No": 0, "Yes": 1})

print(data.describe().T)

# Checking Normal distribution of data
plt.figure(figsize=(12, 12))
i = 1
for col in data.columns:
    plt.subplot(2, 3, i)
    sns.kdeplot(data[col])
    i += 1

# Checking outliers
plt.figure(figsize=(12, 12))
i = 1
for col in data.columns:
    plt.subplot(2, 3, i)
    data[[col]].boxplot()
    i += 1
plt.show()

print(data.columns)

corellation = data.corr()

sns.heatmap(corellation, annot=True, cmap='coolwarm')

mean = data.mean()
std = data.std()

data_std = (data - mean) / std  # Z-score standardize
data_std['Performance Index'] = data['Performance Index']

print(data_std.describe().T)

## Checking Normal distribution of data
plt.figure(figsize=(12, 12))
i = 1
for col in data.columns:
    plt.subplot(2, 3, i)
    sns.kdeplot(data_std[col])
    i += 1
plt.show()

from sklearn.model_selection import train_test_split

train_data, test_data = train_test_split(data_std, test_size=0.2, random_state=42)

x_train = train_data.drop('Performance Index', axis=1)
y_train = train_data['Performance Index']
x_test = test_data.drop('Performance Index', axis=1)
y_test = test_data['Performance Index']

print(x_train.shape)
print(x_test.shape)
print(y_train.shape)
print(y_test.shape)


class LinearRegression:
    def __init__(self):
        self.coefficients = None

    def fit(self, X, y):
        X_b = np.c_[np.ones((X.shape[0], 1)), X]  # 添加偏置项
        self.coefficients = np.linalg.inv(X_b.T.dot(X_b)).dot(X_b.T).dot(y)

    def predict(self, X):
        X_b = np.c_[np.ones((X.shape[0], 1)), X]
        return X_b.dot(self.coefficients)


model1 = LinearRegression()
model1.fit(x_train, y_train)

model2 = LinearRegression()
model2.fit(x_train['Previous Scores'], y_train)

model3 = LinearRegression()
model3.fit(x_train['Hours Studied'], y_train)

from sklearn.metrics import r2_score

def evaluate_model(X, y, theta):
    X_b = np.c_[np.ones((X.shape[0], 1)), X]
    predictions = X_b.dot(theta)
    r2 = r2_score(y, predictions)
    return r2


r2_model1 = evaluate_model(x_test, y_test, model1.coefficients)
r2_model2 = evaluate_model(x_test['Previous Scores'], y_test, model2.coefficients)
r2_model3 = evaluate_model(x_test['Hours Studied'], y_test, model3.coefficients)

print("R^2 score of module 1:", r2_model1)
print("R^2 score of module 2:", r2_model2)
print("R^2 score of module 2:", r2_model3)
