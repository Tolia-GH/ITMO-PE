import pytest
from practice.src.basic_cal import add
from practice.src.basic_cal import divide


def test_devide():

    with pytest.raises(ZeroDivisionError):
        divide(1,0)