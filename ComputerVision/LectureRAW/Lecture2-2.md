## [MainPage](../../index.md)/[Computer Vision](../README.md)/[Lecture](../Lecture.md)/2-2 RAW

语音识别：Youtube 转文本  
断句与标点：ChatGPT 4o  
翻译：chatGPT 4o  

<!-- ![](../pic/Lecture2-2.1.png) -->

# 2.2 Классические/базовые дескрипторы изображений <br>经典/基本图像描述符

![](../pic/Lecture2-2.2.png)

Одним из самых популярных классических подходов для построения дескрипторов изображений является гистограмма ориентированных градиентов. Данный тип дескрипторов позволяет задавать векторы признаков напрямую, находку секторов, например таких, как ранее изученный метод опорных векторов или метод градиентного бустинга, и многим другим.  
构建图像描述符的最受欢迎的经典方法之一是方向梯度直方图（Histogram of Oriented Gradients, HOG）。这种类型的描述符可以直接设置特征向量，找到区域，例如以前研究过的支持向量机方法或梯度提升方法，以及许多其他方法。

В основе идеи построения данного типа дескрипторов лежит предположение, что вид распределения градиентов интенсивности изображения позволяет достаточно точно определить целевой предмет, изображённый на данном рассматриваемом фрагменте изображения. То есть изображение тем более похоже друг на друга, чем более похожи между собой гистограммы направлений их градиентов. Таким образом, изображение по большей части характеризуется контурами и другими перепадами яркости.  
这种描述符构建方法的核心思想是，图像梯度强度分布的模式可以相当准确地确定在所考虑的图像片段中所描绘的目标物体。也就是说，两幅图像之间的相似性取决于它们的梯度方向直方图的相似性。因此，图像主要由轮廓和其他亮度变化来表征。

Сама процедура построения такого дескриптора довольно проста: вычисляется градиент исходного изображения во всех точках, после чего происходит локальное построение гистограммы распределения направленных градиентов и их последующее объединение в единый дескриптор.  
构建这种描述符的过程非常简单：计算原始图像在所有点的梯度，然后进行局部的方向梯度分布直方图构建，最后将它们合并成一个统一的描述符。

![](../pic/Lecture2-2.3.png)

Ещё одним распространённым подходом к формированию дескрипторов изображения являются локальные двоичные шаблоны. Данный метод прост в понимании и хорошо зарекомендовал себя в качестве дескрипторов изображений с текстом. Также этот подход имеет множество вариаций и усовершенствований. В простейшем случае процесс формирования дескриптора представляет собой получение двоичного кода окрестности точки путём сравнения значений пикселей в этой точке и окрестности, а также дальнейшим пороговым преобразованием, после чего полученная бинарная маска окрестности разворачивается в вектор.  
另一个常用的图像描述符构建方法是局部二值模式（Local Binary Patterns, LBP）。这种方法简单易懂，并且在文本图像的描述符中表现良好。此外，这种方法有许多变体和改进。在最简单的情况下，描述符构建过程是通过比较该点及其邻域的像素值来获取邻域点的二进制码，并进行阈值转换，之后将获得的二进制掩码展开为一个向量。