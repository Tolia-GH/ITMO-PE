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
  - [2.2 Классические/базовые дескрипторы изображений 经典/基本图像描述符](#22-классическиебазовые-дескрипторы-изображений-经典基本图像描述符)
  - [2.3 Основные конструктивные элементы нейросетевых классификаторов изображений 神经网络图像分类器的基本结构要素](#23-основные-конструктивные-элементы-нейросетевых-классификаторов-изображений-神经网络图像分类器的基本结构要素)
  - [2.4 Современные нейросетевые архитектуры классификации изображений 用于图像分类的现代神经网络架构](#24-современные-нейросетевые-архитектуры-классификации-изображений-用于图像分类的现代神经网络架构)
  - [2.5 Основные методы оптимизации градиентного спуска 基本梯度下降优化技术](#25-основные-методы-оптимизации-градиентного-спуска-基本梯度下降优化技术)
  - [2.6 Функции потерь и метрики качества 损失函数和质量指标](#26-функции-потерь-и-метрики-качества-损失函数和质量指标)
- [3. Детектирование объектов  物体检测](#3-детектирование-объектов--物体检测)
  - [3.1 Введение. Классическая схема сканирующего окна для детектирования объектов 介绍。用于物体检测的经典扫描窗口设计](#31-введение-классическая-схема-сканирующего-окна-для-детектирования-объектов-介绍用于物体检测的经典扫描窗口设计)
  - [3.2 Глубокие нейросетевые архитектуры для детектирования объектов общего плана 用于检测一般物体的深度神经网络架构](#32-глубокие-нейросетевые-архитектуры-для-детектирования-объектов-общего-плана-用于检测一般物体的深度神经网络架构)
  - [3.3 Глубокие нейросетевые архитектуры для детектирования текстовых фрагментов на изображении 用于检测图像中文本片段的深度神经网络架构](#33-глубокие-нейросетевые-архитектуры-для-детектирования-текстовых-фрагментов-на-изображении-用于检测图像中文本片段的深度神经网络架构)
  - [3.4 Глубокие нейросетевые архитектуры для детектирования человеческих лиц 用于检测人脸的深度神经网络架构](#34-глубокие-нейросетевые-архитектуры-для-детектирования-человеческих-лиц-用于检测人脸的深度神经网络架构)
  - [3.5 Оценка качества детектирования 检测质量评估](#35-оценка-качества-детектирования-检测质量评估)
- [4. Трекинг 对象跟踪](#4-трекинг-对象跟踪)
  - [4.1 Введение. Общая схема трекинга объектов. Базовые принципы распознавания движения в кадре 介绍 对象跟踪的一般方案 帧内运动识别的基本原理](#41-введение-общая-схема-трекинга-объектов-базовые-принципы-распознавания-движения-в-кадре-介绍-对象跟踪的一般方案-帧内运动识别的基本原理)
  - [4.2 Априорная локализация объектов. 对象的先验定位](#42-априорная-локализация-объектов-对象的先验定位)
  - [4.3 Трекинг ключевых точек. Детектирование и дескрипторы ключевых точек 跟踪关键点 关键点检测和描述符](#43-трекинг-ключевых-точек-детектирование-и-дескрипторы-ключевых-точек-跟踪关键点-关键点检测和描述符)
  - [4.4 Трекинг на основе вычисления оптического потока 基于光流计算的跟踪](#44-трекинг-на-основе-вычисления-оптического-потока-基于光流计算的跟踪)
  - [4.5 Глубокие нейросетевые архитектуры для трекинга объектов 用于对象跟踪的深度神经网络架构](#45-глубокие-нейросетевые-архитектуры-для-трекинга-объектов-用于对象跟踪的深度神经网络架构)
- [5. Сегментация  图像分割](#5-сегментация--图像分割)
  - [5.1 Постановка задачи. Основные типы, принципы работы и устройство механизмов стереозрения 问题的表述。立体视觉机构的基本类型、工作原理和设计](#51-постановка-задачи-основные-типы-принципы-работы-и-устройство-механизмов-стереозрения-问题的表述立体视觉机构的基本类型工作原理和设计)
  - [5.2 Описание принципов работы стереопары в терминах проективной геометрии 用射影几何描述立体对的工作原理](#52-описание-принципов-работы-стереопары-в-терминах-проективной-геометрии-用射影几何描述立体对的工作原理)
  - [5.3 Ректификация изображений. Карта расхождений и поиск глубины 图像校正。视差图和深度搜索](#53-ректификация-изображений-карта-расхождений-и-поиск-глубины-图像校正视差图和深度搜索)
  - [5.4 Алгоритмы стереосопоставления 立体匹配算法](#54-алгоритмы-стереосопоставления-立体匹配算法)
- [6. Генерация изображений  图像生成](#6-генерация-изображений--图像生成)
  - [6.1 Введение. Авторегрессионные модели генерации изображений 介绍 自回归图像生成模型](#61-введение-авторегрессионные-модели-генерации-изображений-介绍-自回归图像生成模型)
  - [6.2 GANы и их проблемы GAN 及其问题](#62-ganы-и-их-проблемы-gan-及其问题)
  - [6.3 Архитектуры на основе GANов 基于 GAN 的架构](#63-архитектуры-на-основе-ganов-基于-gan-的架构)
  - [6.4 VAE. Принцип работы VAE, reparameterization trick VAE 的工作原理，重新参数化技巧](#64-vae-принцип-работы-vae-reparameterization-trick-vae-的工作原理重新参数化技巧)
- [7. Конструирование признаков 特征工程](#7-конструирование-признаков-特征工程)
  - [7.1 Введение. Базовые контурные примитивы и алгоритмы их вычисления 介绍 基本轮廓基元及其计算算法](#71-введение-базовые-контурные-примитивы-и-алгоритмы-их-вычисления-介绍-基本轮廓基元及其计算算法)
  - [7.2 Комплексные контурные признаки. Понижение размерности. Признаки на основе ключевых точек 复杂的轮廓特征 降维 基于关键点的特征](#72-комплексные-контурные-признаки-понижение-размерности-признаки-на-основе-ключевых-точек-复杂的轮廓特征-降维-基于关键点的特征)
  - [7.3 Перцептивное хэширование 感知哈希](#73-перцептивное-хэширование-感知哈希)
  - [7.4 Нейросетевые дескрипторы. Feature engineering в общем пайплайне системы компьютерного зрения 神经网络描述符。计算机视觉系统通用流程中的特征工程](#74-нейросетевые-дескрипторы-feature-engineering-в-общем-пайплайне-системы-компьютерного-зрения-神经网络描述符计算机视觉系统通用流程中的特征工程)
- [8. Stereo vision  立体视觉](#8-stereo-vision--立体视觉)
  - [8.1 Постановка задачи. Основные типы, принципы работы и устройство механизмов стереозрения 问题的表述 立体视觉机构的基本类型、工作原理和设计](#81-постановка-задачи-основные-типы-принципы-работы-и-устройство-механизмов-стереозрения-问题的表述-立体视觉机构的基本类型工作原理和设计)
  - [8.2 Описание принципов работы стереопары в терминах проективной геометрии 用射影几何描述立体对的工作原理](#82-описание-принципов-работы-стереопары-в-терминах-проективной-геометрии-用射影几何描述立体对的工作原理)
  - [8.3 Ректификация изображений. Карта расхождений и поиск глубины 图像校正 视差图和深度搜索](#83-ректификация-изображений-карта-расхождений-и-поиск-глубины-图像校正-视差图和深度搜索)
  - [8.4 Алгоритмы стереосопоставления 立体匹配算法](#84-алгоритмы-стереосопоставления-立体匹配算法)


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

- [视频课程原文及翻译](./LectureRAW/Lecture1-1.md)

## 1.2 Повышение разрешения <br>超分辨率

<iframe width="560" height="315" src="https://www.youtube.com/embed/roEJDiJg3X4?si=EA0rlTTuC3Iw172x" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture1-2.md)

## 1.3 Основные цветовые преобразования в составе комбинированной схемы коррекции цвета <br>基本颜色变换作为组合颜色校正方案的一部分

<iframe width="560" height="315" src="https://www.youtube.com/embed/KES76i-Cv4c?si=nvb_EY3HPyTvZELY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture1-3.md)

## 1.4 Дополнительные цветовые преобразования в составе комбинированной схемы коррекции цвета <br>作为组合色彩校正方案一部分的附加色彩变换

<iframe width="560" height="315" src="https://www.youtube.com/embed/0yBdAqbvu9w?si=hN7RXbqsjHi5L3R2" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture1-4.md)

# 2. Классификация изображений <br>图像分类

## 2.1 Введение. Классические/не нейросетевые/общие методы для классификации изображений <br>经典/非神经网络/图像分类的通用方法

<iframe width="560" height="315" src="https://www.youtube.com/embed/lAnudqhAo5k?si=glebJP8g2AVQ0eQA" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture2-1.md)

## 2.2 Классические/базовые дескрипторы изображений <br>经典/基本图像描述符

<iframe width="560" height="315" src="https://www.youtube.com/embed/Vkrhju1RC5w?si=SrM2G0ZVpEw6WNTb" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture2-2.md)

## 2.3 Основные конструктивные элементы нейросетевых классификаторов изображений <br>神经网络图像分类器的基本结构要素

<iframe width="560" height="315" src="https://www.youtube.com/embed/5iYkaNPcDBg?si=q8_f-avbOdjDww10" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture2-3.md)

## 2.4 Современные нейросетевые архитектуры классификации изображений <br>用于图像分类的现代神经网络架构

<iframe width="560" height="315" src="https://www.youtube.com/embed/tUz2Nvp5kq4?si=VkfgV3Ee4C2YYnq1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture2-4.md)

## 2.5 Основные методы оптимизации градиентного спуска <br>基本梯度下降优化技术

<iframe width="560" height="315" src="https://www.youtube.com/embed/4KtIL3Bvtj4?si=YmO3gH4EOTHyIfSb" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture2-5.md)

## 2.6 Функции потерь и метрики качества <br>损失函数和质量指标

<iframe width="560" height="315" src="https://www.youtube.com/embed/mGxyP5Al9Oo?si=dKgh_5RFU12MUJbL" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture2-6.md)

# 3. Детектирование объектов <br> 物体检测

## 3.1 Введение. Классическая схема сканирующего окна для детектирования объектов <br>介绍。用于物体检测的经典扫描窗口设计

<iframe width="560" height="315" src="https://www.youtube.com/embed/NorGQOiuvAU?si=9PQYzLWfxDGGHPA6" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture3-1.md)

## 3.2 Глубокие нейросетевые архитектуры для детектирования объектов общего плана <br>用于检测一般物体的深度神经网络架构

<iframe width="560" height="315" src="https://www.youtube.com/embed/_62KGeJoVWo?si=PQk3krzwunLGQdcV" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture3-2.md)

## 3.3 Глубокие нейросетевые архитектуры для детектирования текстовых фрагментов на изображении <br>用于检测图像中文本片段的深度神经网络架构

<iframe width="560" height="315" src="https://www.youtube.com/embed/-4CpxaaRIpo?si=3hhpm7clpcFXta7R" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture3-3.md)

## 3.4 Глубокие нейросетевые архитектуры для детектирования человеческих лиц <br>用于检测人脸的深度神经网络架构

<iframe width="560" height="315" src="https://www.youtube.com/embed/66eVZZ9xnfE?si=hAcIvpMMtXbI4WtI" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture3-4.md)

## 3.5 Оценка качества детектирования <br>检测质量评估

<iframe width="560" height="315" src="https://www.youtube.com/embed/RdAROKVirq8?si=pjGqlMQdR76X9vtl" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture3-5.md)

# 4. Трекинг <br>对象跟踪

## 4.1 Введение. Общая схема трекинга объектов. Базовые принципы распознавания движения в кадре <br>介绍 对象跟踪的一般方案 帧内运动识别的基本原理

<iframe width="560" height="315" src="https://www.youtube.com/embed/RcReFoLUC2o?si=m9OLvQVP5JZcTDzq" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture4-1.md)

## 4.2 Априорная локализация объектов. <br>对象的先验定位

<iframe width="560" height="315" src="https://www.youtube.com/embed/cnnCRjpyNRY?si=BCvL11mze7RMo4uQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture4-2.md)

## 4.3 Трекинг ключевых точек. Детектирование и дескрипторы ключевых точек <br>跟踪关键点 关键点检测和描述符

<iframe width="560" height="315" src="https://www.youtube.com/embed/9ldZFocs_pk?si=_i8V7a0SAVJKqP3I" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture4-3.md)

## 4.4 Трекинг на основе вычисления оптического потока <br>基于光流计算的跟踪

<iframe width="560" height="315" src="https://www.youtube.com/embed/0rZjaTwI6bM?si=4YE5LkRNfxnDGUwo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture4-4.md)

## 4.5 Глубокие нейросетевые архитектуры для трекинга объектов <br>用于对象跟踪的深度神经网络架构

<iframe width="560" height="315" src="https://www.youtube.com/embed/qnY9t25wqpA?si=7ECEJDhqRNoxtc0C" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture4-5.md)

# 5. Сегментация <br> 图像分割

## 5.1 Постановка задачи. Основные типы, принципы работы и устройство механизмов стереозрения <br>问题的表述。立体视觉机构的基本类型、工作原理和设计

<iframe width="560" height="315" src="https://www.youtube.com/embed/ZJWYqMflbeQ?si=h0Et6yUA8tMo3uTe" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture5-1.md)

## 5.2 Описание принципов работы стереопары в терминах проективной геометрии <br>用射影几何描述立体对的工作原理

<iframe width="560" height="315" src="https://www.youtube.com/embed/SB8-Lo8ivjs?si=imdaPwVRd4pk5DgT" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture5-2.md)

## 5.3 Ректификация изображений. Карта расхождений и поиск глубины <br>图像校正。视差图和深度搜索

<iframe width="560" height="315" src="https://www.youtube.com/embed/QZEwXTp3WH0?si=pGaWZ-LT8bZ5gtID" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture5-3.md)

## 5.4 Алгоритмы стереосопоставления <br>立体匹配算法

<iframe width="560" height="315" src="https://www.youtube.com/embed/X5XrjWecGrI?si=uaz1u0oPmN2d1ZY5" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture5-4.md)

# 6. Генерация изображений <br> 图像生成

## 6.1 Введение. Авторегрессионные модели генерации изображений <br>介绍 自回归图像生成模型

<iframe width="560" height="315" src="https://www.youtube.com/embed/sxgmp-DP7L8?si=CWB0NRpptEQp-WKN" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture6-1.md)

## 6.2 GANы и их проблемы <br>GAN 及其问题

<iframe width="560" height="315" src="https://www.youtube.com/embed/DgfkOMwHU70?si=DVuWsPkhs0_umNd4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture6-2.md)

## 6.3 Архитектуры на основе GANов <br>基于 GAN 的架构

<iframe width="560" height="315" src="https://www.youtube.com/embed/vg0f9vY2dH8?si=7fDNkE8FnrULWI9z" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture6-3.md)

## 6.4 VAE. Принцип работы VAE, reparameterization trick <br>VAE 的工作原理，重新参数化技巧

<iframe width="560" height="315" src="https://www.youtube.com/embed/e_yv6eFdNZ4?si=UFOsy3OcTcRzAo51" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture6-4.md)

# 7. Конструирование признаков <br>特征工程

## 7.1 Введение. Базовые контурные примитивы и алгоритмы их вычисления <br>介绍 基本轮廓基元及其计算算法

<iframe width="560" height="315" src="https://www.youtube.com/embed/Rnk-NSk4Law?si=l-D1qALjl4otdfLe" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture7-1.md)

## 7.2 Комплексные контурные признаки. Понижение размерности. Признаки на основе ключевых точек <br>复杂的轮廓特征 降维 基于关键点的特征

<iframe width="560" height="315" src="https://www.youtube.com/embed/DG4TlpusvPE?si=4Kz-8aQ551WCpdav" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture7-2.md)

## 7.3 Перцептивное хэширование <br>感知哈希

<iframe width="560" height="315" src="https://www.youtube.com/embed/5EDeX2xkx3o?si=639DHLs4gPJ7-MaW" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture7-3.md)

## 7.4 Нейросетевые дескрипторы. Feature engineering в общем пайплайне системы компьютерного зрения <br>神经网络描述符。计算机视觉系统通用流程中的特征工程

<iframe width="560" height="315" src="https://www.youtube.com/embed/Yse-p-JPElc?si=VMPAJaCW_pP5Bf2A" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture7-4.md)

# 8. Stereo vision <br> 立体视觉

## 8.1 Постановка задачи. Основные типы, принципы работы и устройство механизмов стереозрения <br>问题的表述 立体视觉机构的基本类型、工作原理和设计

<iframe width="560" height="315" src="https://www.youtube.com/embed/UFFr0ASuCZ8?si=iRFRpZPMxDdXMPbv" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture8-1.md)

## 8.2 Описание принципов работы стереопары в терминах проективной геометрии <br>用射影几何描述立体对的工作原理

<iframe width="560" height="315" src="https://www.youtube.com/embed/RV0ujaXjIFU?si=mYKLKM3aFsjcoDyf" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture8-2.md)

## 8.3 Ректификация изображений. Карта расхождений и поиск глубины <br>图像校正 视差图和深度搜索

<iframe width="560" height="315" src="https://www.youtube.com/embed/mxomQueMQg4?si=rdRL39-MFBvGrtyC" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture8-3.md)

## 8.4 Алгоритмы стереосопоставления <br>立体匹配算法

<iframe width="560" height="315" src="https://www.youtube.com/embed/SqHyRgd4V3I?si=dpVJ3F50vzEBh4Ji" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

- [视频课程原文及翻译](./LectureRAW/Lecture8-4.md)