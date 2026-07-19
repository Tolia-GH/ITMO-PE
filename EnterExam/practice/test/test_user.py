import pytest


@pytest.fixture(autouse=True)
def user_fixture():
    print('------my_fixture---用例前置执行脚本--------')
    yield
    print('------my_fixture---用例后置执行脚本--------')

def test_01():
    print("测试用例----test_func__01----")

class TestDome:
    # 函数用例 指定测试夹具
    def test_02(self):
        print('----测试用例：test_02------')

    # 函数用例 指定测试夹具
    def test_03(self):
        print('----测试用例：test_03------')
