## [MainPage](../index.md)/[Computer Vision](./README.md)/Lecture

课程链接：[开放教育](https://apps.openedu.ru/learning/course/course-v1:ITMOUniversity+COMPVIS+spring_2024_ITMO_bac/home)

- [1. Введение. Предобработка изображений 介绍 图像预处理](#1-введение-предобработка-изображений-介绍-图像预处理)
  - [1.0 О курсе 关于课程](#10-о-курсе-关于课程)
  - [1.1 Введение. Объект изучения. Процесс формирования изображения 简介 研究对象 成像过程](#11-введение-объект-изучения-процесс-формирования-изображения-简介-研究对象-成像过程)
  - [1.2 Повышение разрешения 超分辨率](#12-повышение-разрешения-超分辨率)
  - [1.3 Основные цветовые преобразования в составе комбинированной схемы коррекции цвета 基本颜色变换作为组合颜色校正方案的一部分](#13-основные-цветовые-преобразования-в-составе-комбинированной-схемы-коррекции-цвета-基本颜色变换作为组合颜色校正方案的一部分)
  - [1.4 Дополнительные цветовые преобразования в составе комбинированной схемы коррекции цвета 作为组合色彩校正方案一部分的附加色彩变换](#14-дополнительные-цветовые-преобразования-в-составе-комбинированной-схемы-коррекции-цвета-作为组合色彩校正方案一部分的附加色彩变换)
- [2. Классификация изображений 图像分类](#2-классификация-изображений-图像分类)
  - [2.1 Введение. Классические/не нейросетевые/общие методы для классификации изображений 经典/非神经网络/图像分类的通用方法](#21-введение-классическиене-нейросетевыеобщие-методы-для-классификации-изображений-经典非神经网络图像分类的通用方法)
  - [2.2 Классические/базовые дескрипторы изображений](#22-классическиебазовые-дескрипторы-изображений)
  - [2.3 Основные конструктивные элементы нейросетевых классификаторов изображений](#23-основные-конструктивные-элементы-нейросетевых-классификаторов-изображений)
  - [2.4 Современные нейросетевые архитектуры классификации изображений](#24-современные-нейросетевые-архитектуры-классификации-изображений)
  - [2.5 Основные методы оптимизации градиентного спуска](#25-основные-методы-оптимизации-градиентного-спуска)
  - [2.6 Функции потерь и метрики качества](#26-функции-потерь-и-метрики-качества)


# 1. Введение. Предобработка изображений <br>介绍 图像预处理

## 1.0 О курсе 关于课程

**Здравствуйте, уважаемые слушатели!**  
**亲爱的听众朋友们大家好！**

**Добро пожаловать на курс «Компьютерное зрение».**  
**欢迎来到计算机视觉课程。**

![](./pic/Lecture1-1.1.png)

В курсе рассматриваются основные задачи из области компьютерного зрения, вокруг которых сконцентрировано внимание научного сообщества и промышленности: задачи классификации, сегментации, детектирования объектов. В рамках данного курса изучаются наиболее распространенные современные методы решения рассматриваемых проблем.  
该课程研究了计算机视觉领域的主要任务，科学界和工业界的注意力集中在这些任务上：分类、分割、对象检测问题。本课程探讨解决所考虑问题的最常见的现代方法。

**АВТОР ОНЛАЙН-КУРСА:**  
**在线课程作者：**

![](./pic/Lecture1-1.2.png)

Самарин Алексей Владимирович

## 1.1 Введение. Объект изучения. Процесс формирования изображения <br>简介 研究对象 成像过程

<iframe width="560" height="315" src="https://www.youtube.com/embed/jxsKSIpaoHw?si=mxwW_LSgerkMNM06" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程链接(Youtube)](https://www.youtube.com/watch?v=jxsKSIpaoHw&t=1s)

- [视频课程原文及翻译](./LectureRAW/Lecture1-1.md)

## 1.2 Повышение разрешения <br>超分辨率

<iframe width="560" height="315" src="https://www.youtube.com/embed/roEJDiJg3X4?si=EA0rlTTuC3Iw172x" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程链接(Youtube)](https://www.youtube.com/watch?v=roEJDiJg3X4)

- [视频课程原文及翻译](./LectureRAW/Lecture1-2.md)

## 1.3 Основные цветовые преобразования в составе комбинированной схемы коррекции цвета <br>基本颜色变换作为组合颜色校正方案的一部分

<iframe width="560" height="315" src="https://www.youtube.com/embed/KES76i-Cv4c?si=nvb_EY3HPyTvZELY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程链接(Youtube)](https://www.youtube.com/watch?v=KES76i-Cv4c)

- [视频课程原文及翻译](./LectureRAW/Lecture1-3.md)

## 1.4 Дополнительные цветовые преобразования в составе комбинированной схемы коррекции цвета <br>作为组合色彩校正方案一部分的附加色彩变换

<iframe width="560" height="315" src="https://www.youtube.com/embed/0yBdAqbvu9w?si=hN7RXbqsjHi5L3R2" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程链接(Youtube)](https://www.youtube.com/watch?v=0yBdAqbvu9w)

- [视频课程原文及翻译](./LectureRAW/Lecture1-4.md)

# 2. Классификация изображений <br>图像分类

## 2.1 Введение. Классические/не нейросетевые/общие методы для классификации изображений <br>经典/非神经网络/图像分类的通用方法

<iframe width="560" height="315" src="https://www.youtube.com/embed/lAnudqhAo5k?si=glebJP8g2AVQ0eQA" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程链接(Youtube)](https://www.youtube.com/watch?v=lAnudqhAo5k)

- [视频课程原文及翻译](./LectureRAW/Lecture1-x.md)

## 2.2 Классические/базовые дескрипторы изображений

<iframe width="560" height="315" src="https://www.youtube.com/embed/Vkrhju1RC5w?si=SrM2G0ZVpEw6WNTb" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程链接(Youtube)](https://www.youtube.com/watch?v=Vkrhju1RC5w)

- [视频课程原文及翻译](./LectureRAW/Lecture1-x.md)

## 2.3 Основные конструктивные элементы нейросетевых классификаторов изображений

<iframe width="560" height="315" src="https://www.youtube.com/embed/5iYkaNPcDBg?si=q8_f-avbOdjDww10" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程链接(Youtube)](https://www.youtube.com/watch?v=5iYkaNPcDBg)

- [视频课程原文及翻译](./LectureRAW/Lecture1-x.md)

## 2.4 Современные нейросетевые архитектуры классификации изображений

<iframe width="560" height="315" src="https://www.youtube.com/embed/tUz2Nvp5kq4?si=VkfgV3Ee4C2YYnq1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程链接(Youtube)](https://www.youtube.com/watch?v=tUz2Nvp5kq4)

- [视频课程原文及翻译](./LectureRAW/Lecture1-x.md)

## 2.5 Основные методы оптимизации градиентного спуска

<iframe width="560" height="315" src="https://www.youtube.com/embed/4KtIL3Bvtj4?si=YmO3gH4EOTHyIfSb" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程链接(Youtube)](https://www.youtube.com/watch?v=4KtIL3Bvtj4)

- [视频课程原文及翻译](./LectureRAW/Lecture1-x.md)

## 2.6 Функции потерь и метрики качества

<iframe width="560" height="315" src="https://www.youtube.com/embed/mGxyP5Al9Oo?si=dKgh_5RFU12MUJbL" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程链接(Youtube)](https://www.youtube.com/watch?v=mGxyP5Al9Oo)

- [视频课程原文及翻译](./LectureRAW/Lecture1-x.md)
