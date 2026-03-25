import re
import time


def yaml_to_json(infile, outfile):

    f_in = open(infile, 'r', encoding='utf-8')  # 本仓库提供了三份额外的 YAML 输入文件可供测试，此处文件名加上对应阿拉伯数字即可
    f_out = open(outfile, 'w', encoding='utf-8')

    big_brackets = [0]*100  # 指针表示缩进层级，存放当前层级下未配对的大括号数量，每当输出一个'{'时+1，输出一个'}\n'时-1，所有缩进层级下的最后应归零
    middle_brackets = [0]*100  # 同上一行，存放当前缩进层级下未配对的中括号数量
    lines = list()  # 记录每一行的信息，存进列表
    line_counter = 1  # 记录文件行数，从一开始

    new_line = f_in.readline()  # 预读第一行文件内容
    while new_line:  # 循环读取每一行文件，并统计文件行数
        lines.append(new_line)
        line_counter += 1
        new_line = f_in.readline()
    lines.append('')  # 额外补充空行，给后续循环过程中对下一行的判断留出空间
    lines.append('')  # 同上
    lines.append('')  # 同上
    line_counter += 3  # 同时加上补充的空行

    # print("line_counter=", line_counter)
    f_out.write("{\n")  # 每一个 JSON 文件开头必带的'{'符号
    print("'{' at level 0")  # 测试输出

    level = 1  # 记录输出文件中当前行的缩进层级，由于 JSON 文件的特性，默认从一级缩进开始

    for i in range(0, line_counter - 1):  # 循环枚举记录的每一行文本
        if i == 0:  # 如果当前为第一行
            last_level = 0  # 输入文件上一行左侧的空格数 = 0
            this_level = len(lines[i]) - len(lines[i].lstrip())  # 输入文件当前行左侧的空格数 = 当前行的字符数 - 当前行去掉左侧空格后的字符数
        else:  # 如果当前不为第一行
            last_level = len(lines[i - 1]) - len(lines[i - 1].lstrip())  # 输入文件上一行左侧的空格数 = 上一行的字符数 - 上一行去掉左侧空格后的字符数
            this_level = len(lines[i]) - len(lines[i].lstrip())  # 当前行的字符数 - 当前行去掉左侧空格后的字符数

        if last_level < this_level:  # 如果当前行的缩进层级比上一行深
            level += (this_level-last_level)//2  # 根据当前行和上一行左侧的空格数的差增加输出文件的缩进层级（因为有可能缩进层级在两行内增加了多级）

        if last_level > this_level:  # 如果当前行的缩进层级比上一行浅
            level -= (last_level-this_level)//2  # 根据当前行和上一行左侧的空格数的差减小输出文件的缩进层级（因为有可能缩进层级在两行内减小了多级）
            if big_brackets[level] > 0:  # 如果当前缩进层级下存在未匹配的大括号
                write_space(f_out, level)  # 根据缩进层级写入空格
                if lines[i+1] == '' or lines[i+1] == '\n':  # 如果下一行为空行
                    f_out.write('}\n')  # 写入右大括号并换行
                    big_brackets[level] -= 1  # 当前缩进层级下未匹配的大括号数量 -1
                    print("'}' at level", level)  # 测试输出
                else:
                    f_out.write('},\n')  # 否则输出带有逗号的右大括号并换行
                    big_brackets[level] -= 1  # 当前缩进层级下未匹配的大括号数量 -1
                    print("'}' at level", level)  # 测试输出

        print("level=", level, "last_level=", last_level, "this_level=", this_level)  # 测试输出
        print(lines[i])  # 测试输出

        if middle_brackets[level] != 0:  # 如果当前缩进层级存在未匹配的中括号
            write_space(f_out, level)  # 根据当前缩进层级写入空格
            if lines[i+1].strip() == '':
                f_out.write(']\n')  # 写入右大括号并换行
                middle_brackets[level] -= 1  # 当前缩进层级下未匹配的中括号数量 -1
                print("']' at level", level)  # 测试输出
            else:
                f_out.write('],\n')  # 写入右大括号并换行
                middle_brackets[level] -= 1  # 当前缩进层级下未匹配的中括号数量 -1
                print("']' at level", level)  # 测试输出

        if '-' in lines[i] and lines[i].strip()[0] == '-':  # 如果当前行存在'-' 并且位于行首，那么意味着这可能是个数组，或包含数组的复合结构
            keyword = lines[i].strip().split('-', maxsplit=1)  # 根据该符号分割出关键字，并只进行一次分割，防止误判值中的 '-' 符号
            print("|keyword0=" + keyword[0] + "|keyword1=" + keyword[1])  # 测试输出
            if keyword[0].strip() == '' and keyword[1].strip() == '':  # 如果该行只有一个 '-' 符号，则说明这是一个多维数组，需要加深缩进
                write_space(f_out, level)   # 根据当前缩进层级写入空格
                f_out.write('{\n')   # 写入左大括号并换行
                print("'{'at level", level)  # 测试输出
                big_brackets[level] += 1  # 当前缩进层级下未匹配的大括号数量 +1
            elif keyword[0].strip() == '' and keyword[1].strip() != '':  # 如果 '-' 左侧为空，右侧不为空，则说明这是一个一维数组
                if (lines[i+1] == '') or ('-' not in lines[i+1]):  # 如果下一行为空，或下一行不包含数组结构，则说明该元素为当前数组的最后一个元素，不需要加上逗号分隔
                    write_space(f_out, level)  # 根据当前缩进层级写入空格
                    f_out.write('"' + keyword[1].strip() + '"\n')  # 转换成 JSON 样式后写入
                else:  # 否则说明该元素为当前数组的最后一个元素，需要加上逗号分隔
                    write_space(f_out, level)  # 根据当前缩进层级写入空格
                    f_out.write('"' + keyword[1].strip() + '",\n')  # 转换成 JSON 样式后写入，并加上逗号分隔
                    f_out.write(re.sub(""))

        if ':' in lines[i] and lines[i].strip()[0] != '-':  # 如果当前行中存在 ':' 符号，并且该行不以 '-'开头，那么意味着这大概是个对象
            keyword = lines[i].strip().split(':', maxsplit=1)  # 根据该符号分割出关键字，并只进行一次分割，误判值中的 '-' 符号
            print("|keyword0="+keyword[0]+"|keyword1="+keyword[1])  # 测试输出
            if keyword[1].strip() == "":  # 如果当前行的第二个关键字为空，则该对象可能包含复合结构
                if '-' in lines[i+1] and lines[i+1].strip()[0] == '-':  # 如果下一行包含 '-' 并且以 '-'为开头，则说明该对象嵌套了一个数组
                    write_space(f_out, level)  # 根据当前缩进层级写入空格
                    f_out.write('"' + keyword[0].strip() + '": [\n')  # 转换成 JSON 样式后写入，并加上逗号分隔
                    f_out.write(re.sub(r'\w+:\ \w', '"' + keyword[0].strip() + '": [\n'))
                    print("'['at level", level)  # 测试输出
                    middle_brackets[level] += 1  # 当前缩进层级下未匹配的中括号数量 +1
                else:  # 否则该对象下就再次嵌套了一个对象
                    write_space(f_out, level)  # 根据当前缩进层级写入空格
                    f_out.write('"' + keyword[0].strip() + '": {\n')  # 转换成 JSON 样式后写入，并加上逗号分隔
                    print("'{'at level", level)  # 测试输出
                    big_brackets[level] += 1  # 当前缩进层级下未匹配的中括号数量 +1
            elif lines[i+1].strip() == '-':  # 若当前不包含复合结构，且下一行只有一个 '-'，则说明该元素为当前缩进下的最后一个元素，末尾不需要写入逗号分割
                if keyword[1].strip() == '~':  # 如果 '-' 右侧关键字为 '~'，则该值对应 JSON 为 null
                    write_space(f_out, level)  # 根据当前缩进层级写入空格
                    f_out.write('"' + keyword[0].strip() + '": null\n')  # 转换成 JSON 样式后写入，将 '~' 转换为 mull
                else:
                    write_space(f_out, level)  # 根据当前缩进层级写入空格
                    f_out.write('"' + keyword[0].strip() + '": "' + keyword[1].strip() + '"\n')  # 转换成 JSON 样式后写入
            elif (lines[i+1] == '\n') or (lines[i+1] == ''):  # 若当前不包含复合结构，且下一行为空，则说明该元素为当前结构，乃至整份文档的下的最后一个元素
                if keyword[1].strip() == '~':  # 如果 '-' 右侧关键字为 '~'，则该值对应 JSON 为 null
                    write_space(f_out, level)  # 根据当前缩进层级写入空格
                    f_out.write('"' + keyword[0].strip() + '": null\n')  # 转换成 JSON 样式后写入，将 '~' 转换为 mull
                else:
                    write_space(f_out, level)  # 根据当前缩进层级写入空格
                    f_out.write('"' + keyword[0].strip() + '": "' + keyword[1].strip() + '"\n')  # 转换成 JSON 样式后写入
                if big_brackets[level-1] > 0:  # 如果当前缩进下存在为配对的大括号
                    write_space(f_out, level-1)  # 则根据预估的下一行缩进层级写入空格
                    f_out.write('}\n')  # 写入右大括号并换行
                    big_brackets[level-1] -= 1  # 当前预估的下一行缩进层级下未匹配的大括号数量 -1
                    print("'}' at level", level-1)  # 测试输出
            else:  # 否则说明当前元素非最后一个元素，写入时需要加上逗号分隔
                write_space(f_out, level)  # 根据当前缩进层级写入空格
                f_out.write('"' + keyword[0].strip() + '": "' + keyword[1].strip() + '",\n')  # 转换成 JSON 样式后写入，并加上逗号分隔

    f_out.write('}\n')
    print("'}' at level 0")
    f_in.close()
    f_out.close()

    return
