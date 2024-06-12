## [MainPage](../../index.md)/[AI System](../README.md)/Lab1

# Лабораторная 1. Создание базы знаний и выполнение запросов в Prolog<!-- omit from toc -->

Требуется создать базу знаний в языке программирования Prolog и реализовать набор запросов, используя эту базу знаний. Задача направлена на развитие навыков работы с фактами, предикатами, и правилами в логическом программировании.  
需要用 Prolog 编程语言创建一个知识库，并使用该知识库实现一组查询。 该任务旨在培养逻辑编程中处理事实、谓词和规则的技能。

**Задание**

- **Создание базы знаний:**
    
  Создайте базу знаний. База знаний должна включать в себя **не менее 20 фактов с одним аргументом, 10-15 фактов с двумя аргументам, которые дополняют и показывают связь с другими фактами и 5-7 правил.** Факты могут описывать объекты, их свойства и отношения между ними. Предикаты могут описывать различные атрибуты объектов, а правила - логические законы и выводы, которые можно сделать на основе фактов и предикатов.  
  创建知识库。 知识库应包括**至少 20 个带有一个论点的事实、10-15 个带有两个论点的事实来补充并显示与其他事实的联系以及 5-7 条规则。** 事实可以描述对象、它们的属性以及它们之间的关系。 谓词可以描述对象的各种属性，规则是根据事实和谓词可以得出的逻辑规律和结论。
    
- **Выполнение запросов:**
    
  Напишите несколько запросов для БЗ. Запросы **должны быть разной сложности** и включать в себя:  
  为知识库编写几个查询。 请求**必须具有不同的复杂性**，并包括：
    
  - Простые запросы к базе знаний для поиска фактов.
  - Запросы, использующие логические операторы (**и, или, не**) для формулирования сложных условий.
  - Запросы, использующие переменные для поиска объектов с определенными характеристиками.
  - Запросы, которые требуют выполнения правил для получения результата.  

  - 简单查询知识库以查找事实。
  - 使用逻辑运算符（**and、or、not**）来制定复杂条件的查询。
  - 使用变量来查找具有某些特征的对象的查询。
  - 需要遵循规则才能获得结果的查询。
- **Документация: 文档：**
    
  В коде должны быть комментарии описания фактов, предикатов и правил.  
  代码应包含描述事实、谓词和规则的注释。
    

**Критерии оценки 评估标准**

- Корректность базы знаний и выполненных запросов.
- Сложность и разнообразие запросов.
- Качество документации и комментариев к коду.  

- 知识库和执行查询的正确性。
- 请求的复杂性和多样性。
- 文档和代码注释的质量。

**Тематики БЗ BZ主题**

Любая, связанная с играми. Например,  
任何与游戏有关的东西。 例如，

- Видеоигры
- Правила настольных игр
- Профили игроков
- Игровые персонажи
- История игры
- Игровые механики

- 视频游戏
- 棋盘游戏规则
- 玩家档案
- 游戏角色
- 游戏历史
- 游戏机制

Example 1

```prolog
%facts%
age(son,22).
age(daught,18).
age(dad,47).
age(mom,41).
age(grandpa_mom,64).
age(grandma_mom,57).
age(uncle_liao,49).
age(uncle,35).
age(uncle_lin,38).
age(grandpa_dad,70).
age(grandma_dad,62).
age(cosin_sister_liao,26).
age(cosin_brother_liao,22).
age(cosin_brother,17).
age(cosin_sister,13).
age(aunt_liao,44).
age(aunt,36).
man(son).
man(dad).
man(uncle).
man(grandpa_mom).
man(cosin_brother).
man(grandpa_dad).
man(uncle_liao).
man(cosin_brother_liao).
man(uncle_lin).
woman(cosin_sister_liao).
woman(aunt_liao).
woman(grandma_dad).
woman(daught).
woman(mom).
woman(aunt).
woman(cosin_sister).
woman(grandma_mom).
parent(uncle_liao,cosin_brother_liao).
parent(uncle_liao,cosin_sister_liao).
parent(aunt_liao,cosin_brother_liao).
parent(aunt_liao,cosin_sister_liao).
parent(mom,son).
parent(mom,daught).
parent(dad,son).
parent(dad,daught).
parent(grandpa_mom,mom).
parent(grandma_mom,mom).
parent(grandpa_mom,uncle).
parent(grandma_mom,uncle).
parent(grandma_mom,uncle_lin).
parent(grandpa_mom,uncle_lin).
parent(uncle,cosin_sister).
parent(uncle,cosin_brother).
parent(aunt,cosin_brother).
parent(aunt,cosin_sister).
parent(grandpa_dad,dad).
parent(grandma_dad,dad).
parent(grandma_dad,uncle_liao).
parent(grandpa_dad,uncle_liao).
couple(mom,dad).
couple(grandpa_dad,grandma_dad).
couple(grandpa_mom, grandma_mom).
couple(aunt,uncle).
couple(aunt_liao,uncle_liao).
couple(dad,mom).
couple(grandma_dad,grandpa_dad).
couple(grandma_mom, grandpa_mom).
couple(uncle,aunt).
couple(uncle_liao,aunt_liao).
%rules%
%couple(A,B):- couple(B,A),!.%
son(A,B):-parent(B,A), man(A).
daught(A,B):-parent(B,A),woman(A).
dad(A,B):-parent(A,B),man(A).
mom(A,B):-parent(A,B),woman(A).
brother(A,B):- dad(F1,A), dad(F2,B),F1=F2, mom(M1,A), mom(M2,A), M1=M2, man(A),\+A=B.
sister(A,B):- dad(F1,A), dad(F2,B),F1=F2, mom(M1,A), mom(M2,B), M1=M2, woman(A),\+A=B.
husband(A,B):-couple(A,B),man(A),woman(B).
wife(A,B):-couple(A,B),woman(A),man(B).
%two possibility for uncle
possibility_u1(A,B):-man(A),mom(M,B),sister(M,A).
possibility_u2(A,B):-man(A),dad(D,B),brother(D,A).
uncle(A,B):-possibility_u1(A,B);possibility_u2(A,B).
aunt(A,B):- uncle(C,B),wife(A,C).
grandparent(A,B):-parent(C,B), parent(A,C).
is_adult(A):- age(A,Age),Age>18.
```

Example 2
```prolog
% 定义宝可梦
pokemon(charmander, fire, 50).
pokemon(squirtle, water, 50).

% 定义宝可梦招式
move(flamethrower, fire, 30).
move(water_gun, water, 25).

% 主循环
start_battle :-
    write('宝可梦对战开始！'), nl,
    choose_pokemon(Pokemon1),
    choose_pokemon(Pokemon2),
    battle(Pokemon1, Pokemon2).

% 玩家选择宝可梦
choose_pokemon(Pokemon) :-
    write('请选择一个宝可梦 (charmander/squirtle)： '),
    read(Pokemon),
    (   pokemon(Pokemon, _, _) ->
        write('你选择了 '), write(Pokemon), nl
    ;   write('无效的宝可梦，请重新选择。'), nl,
        choose_pokemon(Pokemon)
    ).

% 进行对战
battle(Pokemon1, Pokemon2) :-
    write(Pokemon1), write(' 对战 '), write(Pokemon2), nl,
    write('请选择一个招式 (flamethrower/water_gun)： '),
    read(Move),
    (   move(Move, Type, Power),
        pokemon(Pokemon1, Type, HP1),
        pokemon(Pokemon2, Type, HP2),
        NewHP2 is HP2 - Power,
        NewHP2 > 0 ->
        write(Pokemon1), write(' 使用 '), write(Move), write(' 攻击了 '), write(Pokemon2), nl,
        write(Pokemon2), write(' 的HP减少到 '), write(NewHP2), nl,
        battle(Pokemon2, Pokemon1, NewHP2, HP1)
    ;   write('无效的招式，请重新选择。'), nl,
        battle(Pokemon1, Pokemon2)
    ).

% 宝可梦2反击
battle(Pokemon1, Pokemon2, HP2, HP1) :-
    write(Pokemon2), write(' 反击了 '), write(Pokemon1), nl,
    write(Pokemon1), write(' 的HP减少到 '), write(HP1), nl,
    (   HP1 > 0 ->
        write('请选择一个招式 (flamethrower/water_gun)： '),
        read(Move),
        (   move(Move, Type, Power),
            pokemon(Pokemon2, Type, _),
            NewHP1 is HP1 - Power,
            NewHP1 > 0 ->
            write(Pokemon2), write(' 使用 '), write(Move), write(' 攻击了 '), write(Pokemon1), nl,
            write(Pokemon1), write(' 的HP减少到 '), write(NewHP1), nl,
            battle(Pokemon1, Pokemon2, HP2, NewHP1)
        ;   write('无效的招式，请重新选择。'), nl,
            battle(Pokemon1, Pokemon2, HP2, HP1)
        )
    ;   write(Pokemon1), write(' 被打败了！游戏结束。'), nl
    ).

% 主入口
:- start_battle.

```

```prolog
% 宝可梦属性
pokemon(皮卡丘, 电).
pokemon(杰尼龟, 水).
pokemon(小火龙, 火).

% 宝可梦技能
skill(电击, 电, 30).
skill(水枪, 水, 25).
skill(火焰牙, 火, 28).

% 宝可梦对战规则
can_attack(X, Y) :- 
    pokemon(X, TypeX),
    pokemon(Y, TypeY),
    skill(_, TypeX, _),
    skill(_, TypeY, _),
    X \= Y.

% 攻击计算
attack(Pokemon, Skill, Damage) :-
    pokemon(Pokemon, Type),
    skill(Skill, Type, Power),
    Damage is Power.

% 对战逻辑
battle(Pokemon1, Pokemon2) :-
    can_attack(Pokemon1, Pokemon2),
    write(Pokemon1), write(' 使用技能：'), read(Skill),
    attack(Pokemon1, Skill, Damage),
    write(Pokemon1), write(' 对 '), write(Pokemon2), write(' 造成了 '), write(Damage), write(' 点伤害！'), nl,
    NewHP is 100 - Damage,
    write(Pokemon2), write(' 的剩余生命值为 '), write(NewHP), nl.

% 主入口
start_battle :-
    write('请输入第一个宝可梦：'), read(Pokemon1),
    write('请输入第二个宝可梦：'), read(Pokemon2),
    battle(Pokemon1, Pokemon2).
```

```prolog
% 定义宝可梦的属性（名字、类型、HP、攻击力）
pokemon(charmander, fire, 60, 50).
pokemon(squirtle, water, 65, 45).
pokemon(bulbasaur, grass, 70, 40).

% 定义宝可梦的招式（名字、类型、威力）
move(flamethrower, fire, 40).
move(watergun, water, 35).
move(vine_whip, grass, 30).

% 玩家选择宝可梦
choose_pokemon(Pokemon) :-
    write('请选择宝可梦 (charmander/squirtle/bulbasaur)： '),
    read(Pokemon),
    (   pokemon(Pokemon, _, _, _) ->
        write('你选择了：'), write(Pokemon), nl
    ;   write('无效的选择，请重新选择。'), nl,
        choose_pokemon(Pokemon)
    ).

% 玩家选择招式
choose_move(Move) :-
    write('请选择招式 (flamethrower/watergun/vine_whip)： '),
    read(Move),
    (   move(Move, _, _) ->
        write('你使用了：'), write(Move), nl
    ;   write('无效的选择，请重新选择。'), nl,
        choose_move(Move)
    ).

% 宝可梦对战
battle :-
    write('宝可梦对战开始！'), nl,
    choose_pokemon(PlayerPokemon),
    choose_pokemon(ComputerPokemon),
    battle_loop(PlayerPokemon, ComputerPokemon).

% 宝可梦对战主循环
battle_loop(PlayerPokemon, ComputerPokemon) :-
    write('玩家选择招式：'), nl,
    choose_move(PlayerMove),
    random_move(ComputerMove),
    perform_move(PlayerMove, PlayerPokemon, ComputerPokemon, NewComputerPokemon),
    perform_move(ComputerMove, NewComputerPokemon, PlayerPokemon, NewPlayerPokemon),
    display_battle_status(NewPlayerPokemon, NewComputerPokemon),
    (   has_won(NewPlayerPokemon) ->
        write('恭喜你，你赢了！'), nl
    ;   has_won(NewComputerPokemon) ->
        write('电脑赢了，再接再厉！'), nl
    ;   battle_loop(NewPlayerPokemon, NewComputerPokemon)
    ).

% 随机选择电脑招式
random_move(Move) :-
    random_member(Move, [flamethrower, watergun, vine_whip]).

% 执行招式
perform_move(Move, Attacker, Defender, NewDefender) :-
    move(Move, Type, Power),
    pokemon(Defender, DefType, HP, DefHP),
    calculate_damage(Type, Power, DefType, Damage),
    NewDefHP is max(0, DefHP - Damage),
    NewDefender =.. [pokemon, Defender, DefType, HP, NewDefHP].

% 计算伤害
calculate_damage(Type, Power, DefType, Damage) :-
    effectiveness(Type, DefType, Multiplier),
    Damage is Power * Multiplier.

% 计算招式效果
effectiveness(fire, grass, 2.0).
effectiveness(fire, water, 0.5).
effectiveness(water, fire, 2.0).
effectiveness(water, grass, 0.5).
effectiveness(grass, water, 2.0).
effectiveness(grass, fire, 0.5).
effectiveness(_, _, 1.0).

% 显示战斗状态
display_battle_status(PlayerPokemon, ComputerPokemon) :-
    write('玩家的宝可梦：'), nl,
    display_pokemon(PlayerPokemon),
    write('电脑的宝可梦：'), nl,
    display_pokemon(ComputerPokemon).

% 显示宝可梦信息
display_pokemon(pokemon(Name, Type, HP, _)) :-
    write('名字：'), write(Name), nl,
    write('类型：'), write(Type), nl,
    write('HP：'), write(HP), nl.

% 判断是否赢得比赛
has_won(pokemon(_, _, HP, _)) :-
    HP =< 0.

% 主入口
:- battle.

```