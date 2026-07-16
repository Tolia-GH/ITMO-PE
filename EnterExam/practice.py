import time
from time import sleep
from contextlib import contextmanager

@contextmanager
def Timer():

    # 进入 with 之前执行
    start = time.time()

    # 将控制权交给 with 代码块
    yield

    # 离开 with 之后执行
    end = time.time()
    print(f"cost: {end - start:.2f} second")

# 对代码执行时间进行计时
with Timer():
    # 执行一些耗时操作
    sleep(1)