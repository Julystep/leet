#!/usr/bin/python3

class A:
    pass


class B(A):
    pass


if __name__ == '__main__':
    print('hello python')
    a: int = 111
    isinstance(a, int)
    # type 和 instance 有区别，type不认为父类是字类
    print(type(B()) == A)
    print(isinstance(B(), A))

    # python 推导式
    # 列表推导
    names = ['Bob', 'Tom', 'alice', 'Jerry', 'Wendy', 'Smith']
    new_names = [name.upper() for name in names if len(name) > 3]
    print(new_names)
    # 字典推导
    dictionary = {key: len(key) for key in new_names}
    print(dictionary)

    # python 运算符
    a = 1
    b = 0
    if a and b:
        print("yes")
    else:
        print("no")

    if a not in names:
        print("a not in names")

    x = 3
    y = 3.0
    if x == y:
        print("3 == 3.0")

    # 列表查询
    list = ['red', 'green', 'blue', 'yellow', 'white', 'black']
    print(list[-1])
    print(list[1:4])
    del list[1]
    print(list)

    # 元组
    tup = ('r', 'u', 'n', 'o', 'o', 'b')
    tup[0] = 'j'
    print(tup[0])

    # 条件语句
    a = 400
    # match a:
    #     case 400|401|402:
    #         print("ok")