

Для выполнения заданий, описанных ниже, используйте модель, предварительно обученную на десяти тысячах изображений из датасета, рассмотренного в примере. Файл архитектуры обученной модели в формате json и файл с весами модели в формате h5 [доступны по ссылке](https://courses.openedu.ru/assets/courseware/v1/99da282cb4e4e2968641f9fd85cca83d/asset-v1:ITMOUniversity+COMPVIS+spring_2024_ITMO_bac+type@asset+block/Model_10k_images_cats_dogs_trained.zip).  
要完成下面描述的任务，请使用对示例中讨论的数据集中的一万张图像进行预训练的模型。 json 格式的训练模型架构文件和 h5 格式的模型权重文件[可在链接中找到](https://courses.openedu.ru/assets/courseware/v1/99da282cb4e4e2968641f9fd85cca83d/asset-v1:ITMOUniversity+COMPVIS+spring_2024_ITMO_bac+type@asset+block/Model_10k_images_cats_dogs_trained.zip)。

Зеркало с исходными данными, на случай, если Kaggle будет недоступен  
包含原始数据的镜像，以防 Kaggle 不可用

[Train.zip](https://disk.yandex.ru/d/SwOfruA71A1Kag)

[Test.zip](https://disk.yandex.ru/d/k3c39rdP732KqQ)

1. Отберите из тренировочного набора данных (файл train.zip) изображения с именами в диапазоне `[cat.10200.jpg, cat.10300.jpg)` и `[dog.10200.jpg, dog.10300.jpg)`. Всего должно получиться по 100 изображений кошек и собак. Эти данные будут тестовыми.  
   从训练数据集（train.zip 文件）中选择名称在`[cat.10200.jpg,cat.10300.jpg)`和`[dog.10200.jpg,dog.10300.jpg)`范围内的图像。总共应该有 100 张猫和狗的图像。该数据将作为测试数据。

2. Произведите оценку модели на отобранных тестовых данных:  
   根据选定的测试数据评估模型：

   - Введите значение $Recall (macro\ avg)$ модели:  

   - Введите значение $Accuracy$ модели:

   - Введите значение $F1-score\ (macro\ avg)$ модели:

3. Выполните предсказания для следующих изображений.  
   对以下图像进行预测。

   - Имя файла: `cat.10238.jpg`. Введите вероятность отнесения объекта классу cats:

   - Имя файла: `dog.10238.jpg`. Введите вероятность отнесения объекта классу dogs: