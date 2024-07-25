import numpy as np
import cv2
from matplotlib import pyplot as plt


def contrast(image, p):  # incorrect!
    img_result = image.copy() / 255.0
    if p > 0:
        img_result = (img_result - 0.5) / (1 - p)
    else:
        img_result = (img_result - 0.5) * (1 - p)
    img_result = img_result * 255

    return img_result


img_original = cv2.imread('test1.jpg')  # use opencv to load img 'test.jpg'
img_original = cv2.cvtColor(img_original, cv2.COLOR_BGR2RGB)  # convert BGR format to RGB format
img_result_lib = contrast(img_original, 0.58)
cv2.imwrite("img_result_lib.png", img_result_lib)
img_result_lib = cv2.imread("img_result_lib.png")

fig, axes = plt.subplots(2, 1, figsize=(20, 10))
axes[0].imshow(img_original)
axes[1].imshow(img_result_lib)

print("высота:", img_result_lib.shape[0], "ширина:", img_result_lib.shape[1])
print("среднее значение интенсивности пикселя:", np.mean(img_result_lib))

plt.show()
