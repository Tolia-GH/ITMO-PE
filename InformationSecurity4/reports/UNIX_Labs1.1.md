<head>
  <script src="https://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML" type="text/javascript"></script>
  <script type="text/x-mathjax-config">
    MathJax.Hub.Config({
      tex2jax: {
      skipTags: ['script', 'noscript', 'style', 'textarea', 'pre'],
      inlineMath: [['$','$']]
      }
    });
  </script>
</head>

## [MainPage](../../../index.md)/[Info Security](../../README.md)/Encript Lab 1.2

<center>
<p>Университет ИТМО<br>Факультет ФПИ и КТ</p>
<br><br><br><br><br><br>
<h3>Отчёт по лабораторной работе 1.1</h3>
<h2>«Учетные записи и группы пользователей Linux»</h2>
по дисциплину
<h5>«Информационная безопасность»</h5>
</center>

<br><br><br><br><br><br><br><br>

<div align="right">Студент: Чжоу Хунсян</div>
<div align="right">Группа: P34131</div>
<div align="right">Преподаватель:</div>

<center>
<br><br>
<p>Санкт-Петербург 2024</p>
<br>
</center>

---

## Цель работы

Изучить параметры учетных записей пользователей в Linux. Ознакомиться с процессом конфигурации и изменения учетных записей по умолчанию. Изучить процесс разграничения доступа к данным и модификации прав доступа. 

## Основная часть

1. Создайте пользователя sXXXXXX(где XXXXXX - ваш номер ису). Создайте группу пользователей studs, добавьте пользователя в эту группу.

2. Создайте пользователя admin_sXXXXXX(где XXXXXX - ваш номер ису). Предоставьте пользователю root-права. Опишите все способы, которыми можно это сделать и продемонстрируйте их. (минимум 3 способа).

3. Продемонстрируйте, что пользователь admin_sXXXXXX(где XXXXXX - ваш номер ису), теперь имеет больше привилегий, по сравнению с пользователем user_sXXXXXX. Предоставьте минимум 5 отличий.

## Варианты заданий

> Вариант: 23 % 11 = 1

Настроить маску создаваемых файлов для пользователя sXXXXXX так, чтобы пользователи группы имели только право на чтение, владелец – на чтение и запись.  

## Выполнение

### Создать пользователя s336184

```
parallels@ubuntu-linux-22-04-desktop:~$ sudo useradd -m s336184
parallels@ubuntu-linux-22-04-desktop:~$ sudo passwd s336184
[sudo] password for parallels: 
New password: 
Retype new password: 
passwd: password updated successfully
```

### Создайть группу пользователей studs

```
parallels@ubuntu-linux-22-04-desktop:~$ sudo groupadd studs
```

### Добавить пользователя в эту группу.

```
parallels@ubuntu-linux-22-04-desktop:~$ sudo usermod -aG studs s336184
```

Проверение

```
parallels@ubuntu-linux-22-04-desktop:~$ groups s336184
s336184 : s336184 studs
```

### Создать пользователя admin_sXXXXXX(где XXXXXX - ваш номер ису).

```
parallels@ubuntu-linux-22-04-desktop:~$ sudo useradd -m admin_s336184
parallels@ubuntu-linux-22-04-desktop:~$ sudo passwd admin_s336184 
New password: 
Retype new password: 
passwd: password updated successfully
```

### Предоставить пользователю root-права.

1. Добавить пользователь в файле /etc/sudoers
```
parallels@ubuntu-linux-22-04-desktop:~$ sudo visudo
```

```
# User privilege specification
root    ALL=(ALL:ALL) ALL
admin_s336184    ALL=(ALL:ALL) ALL
```

2. Добавить admin_s336184 в группу sudo, и можно использовать команд `sudo` для получения root правы
```
parallels@ubuntu-linux-22-04-desktop:~$ sudo usermod -g sudo admin_s336184
```

3. Изменить файл /etc/passwd

```
parallels@ubuntu-linux-22-04-desktop:~$ sudo vipw
```

```
admin_s336184:x:0:1003::/home/admin_s336184:/bin/sh
```

### Проверение разниц прав между admin_s336184 и s336184

Разница 1: admin_s3336184 может использовать комманд `sudo`, а s336184 нет

```
# изменить пользователь admin_s336184
$ su - admin_s336184
$ sudo ls
...

# изменить пользователь s336184
$ su - s336184
$ sudo ls
s336184 is not in the sudoers file. This incident will be reported.
```

Разница 2: admin_s3336184 может достигать /root, а s336184 нет

```
# изменить пользователь admin_s336184
$ su - admin_s336184
$ sudo ls /root  # 成功列出 root 目录内容
snap

# изменить пользователь s336184
$ su - s336184
$ ls /root
ls: cannot open directory '/root': Permission denied
```

Разница 3: admin_s3336184 может управлять сервисы систем, а s336184 нет

```
# изменить пользователь admin_s336184
$ su - admin_s336184
$ sudo systemctl restart sshd  
# успешно перезагрузить сервис SSH

# изменить пользователь s336184
$ su - s336184
$ systemctl restart sshd
Failed to restart sshd.service: Access denied
```

Разница 4: admin_s3336184 может управлять пользователи систем, а s336184 нет

```
# изменить пользователь admin_s336184
$ su - admin_s336184
$ sudo useradd test_user
# успешно добавил test_user

# изменить пользователь s336184
$ su - s336184
$ useradd test_user
useradd: Permission denied.
useradd: cannot lock /etc/passwd; try again later.
```

Разница 5: admin_s3336184 может изменить файлы у системы, а s336184 нет

```
# изменить пользователь admin_s336184
$ su - admin_s336184
$ sudo nano /etc/sudoers
# успешно открывал sudoers с nano

# изменить пользователь s336184
$ su - s336184
$ nano /etc/sudoers
# открыл но с "Permission denied"
```

Подводя итог, мы можем убедиться, что admin_s336184 имеет значительно более высокие разрешения, чем s336184.

### Настроить маску создаваемых файлов

```
$ su - s336184

# проверять umask
$ umask
0002

# изменить .profile
$ nano ~/.profile
```

В файле .profile добавить

```
umask 0027
```

Сохранить и ещё раз login ы336184, и проверять

```
$ su - s336184
$ umask
0027

$ touch test
$ ls -l test
-rw-r----- 1 s336184 s336184 0 Dec  2 16:57 test
```

Мы увидим что umask успешно изменино

### Создайте каталог /studs. Настройте группу studs так, чтобы только у ее членов был доступ к этому каталогу. Продемонстрируйте, что у других групп нет доступа к этому каталогу. 

```
$ sudo mkdir /studs
$ sudo groupadd studs
$ sudo chgrp studs /studs
$ sudo chmod 770 /studs
$ sudo usermod -aG studs s336184
```

```
$ su - s336184
$ cd /studs

$ su - test_user
$ cd /studs
sh: 4: cd: can't cd to studs
```

### Измените конфигурацию таким образом, чтобы у всех пользователей домашний каталог создавался в /studs/... Продемонстрируйте выполнение, создав тестового пользователя. 

```
sudo nano /etc/default/useradd
```

```
HOME=/studs
```

Пролверение 

```
$ sudo useradd -m test_user
$ sudo passwd test_user
$ ls /studs
test_user
```

### Создайте каталог /studs/lab_reports. Настройте права так, чтобы файлы из этого каталога могли удалять только те пользователи, которые эти файлы создали. Продемонстрируйте изменения, создав новый файл и удалив его, как другой пользователь.  

```
$ sudo mkdir /studs/lab_reports
$ sudo chmod 1770 /studs/lab_reports
$ sudo chgrp studs /studs/lab_reports
$ sudo chmod g+s /studs/lab_reports
```

проверение

```
$ su - s336184
$ cd /studs/lab_reports
$ touch report

$ su - test_user
$ cd /studs/lab_reports
$ rm report
rm: cannot remove 'report': Operation not permitted

$ su - s336184
$ rm report
# успешно удалено
```

## Вывод

В ходу лабораторной работы, я изучить параметры учетных записей пользователей в Linux. Ознакомился с процессом конфигурации и изменения учетных записей по умолчанию. Изучил процесс разграничения доступа к данным и модификации прав доступа.