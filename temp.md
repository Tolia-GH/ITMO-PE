% define characters `character(name).`
character('Noelle').
character('Klee').
character('Ganyu').
character('Keqing').
character('Ayaka').
character('Kokomi').
character('Nahida').
character('Nilou').
character('Lynette').
character('Neuvilette').

% define enemies `enemy(enemyName).`
monster(slime).
monster(hilichurl).
monster(ruinGuard).
monster(treasureHoarders).
monster(nobushi).
monster(eremite).

% define Boss `Boss(BossName).`
boss('Stormterror').
boss('Childe').
boss('Azhdaha').

% define the nation of characters `nation(characterName, nation).`
nation('Noelle', moundstalt).
nation('Klee', moundstalt).
nation('Ganyu', liyue).
nation('Keqing', liyue).
nation('Ayaka', inazuma).
nation('Kokomi', inazuma).
nation('Nahida', sumeru).
nation('Nilou', sumeru).
nation('Lynette', fontaine).
nation('Neuvilette', fontaine).

% define elementType of character `elementType(characterName, element).`
elementType('Noelle', geo).
elementType('Klee', pyro).
elementType('Ganyu', cryo).
elementType('Keqing', electro).
elementType('Ayaka', cryo).
elementType('Kokomi', hydro).
elementType('Nahida', dendro).
elementType('Nilou', hydro).
elementType('Lynette', anemo).
elementType('Neuvilette', hydro).

% define weaponType of character `useWeaponType(characterName, weaponType).`
useWeaponType('Noelle', claymore).
useWeaponType('Klee', catalyst).
useWeaponType('Ganyu', bow).
useWeaponType('Keqing', sword).
useWeaponType('Ayaka', sword).
useWeaponType('Kokomi', catalyst).
useWeaponType('Nahida', catalyst).
useWeaponType('Nilou', sword).
useWeaponType('Lynette', sword).
useWeaponType('Neuvilette', catalyst).

% define weapons `weapon(name).`
weapon('Bloodtainted Great Sword'). % 沐浴龙血的剑
weapon('Rain Slasher'). % 雨裁
weapon('Magic Guider'). % 魔法导论
weapon('Skyward Atlas'). % 天空之卷
weapon('Oath Sworn Eye'). % 证誓之明瞳
weapon('Solar Pearl'). % 匣里日月
weapon('Tome Of The Eternal Flowl'). % 万世流涌大典
weapon('Amos Bow'). % 阿莫斯之弓
weapon('Fading Twilight'). % 落霞
weapon('Silver Sword'). % 银剑
weapon('Fillet Blade'). % 吃虎鱼刀
weapon('Amenoma Kageuchi'). % 天目影打刀

% define weaponType `weaponType(weaponName, weaponType).`
weaponType('Bloodtainted Great Sword', claymore).
weaponType('Rain Slasher', claymore).
weaponType('Magic Guider', catalyst).
weaponType('Skyward Atlas', catalyst).
weaponType('Oath Sworn Eye', catalyst).
weaponType('Solar Pearl', catalyst).
weaponType('Tome Of The Eternal Flowl', catalyst).
weaponType('Amos Bow', bow).
weaponType('Fading Twilight', bow).
weaponType('Silver Sword', sword).
weaponType('Fillet Blade', sword).
weaponType('Amenoma Kageuchi', sword).

% define rules %
isObject(ObjectName) :-
    character(ObjectName), !;
    monster(ObjectName), !;
    boss(ObjectName).

%define weather a character can use this weapon
canUseWeapon(CharacterNAme,WeaponName) :- 
    character(CharacterNAme),
    weapon(WeaponName),
    useWeaponType(CharacterNAme, Type),
    weaponType(WeaponName, Type).

%define weather the objectA will attack objectB
areEnemy(ObjectA, ObjectB) :-  
    character(ObjectA), monster(ObjectB), !;
    character(ObjectA), boss(ObjectB), !;
    monster(ObjectA), character(ObjectB), !;
    boss(ObjectA), character(ObjectB).

areFriendly(ObjectA, ObjectB) :-
    character(ObjectA), character(ObjectB) ->  
    (   nation(ObjectA, Nation),
        nation(ObjectB, Nation)
    ), !;
    monster(ObjectA), monster(ObjectB), !;
    boss(ObjectA), monster(ObjectB).

areNeutral(ObjectA, ObjectB) :-
    character(ObjectA), character(ObjectB) ->  
    (   nation(ObjectA, NationA),
        nation(ObjectB, NationB),
        NationA \= NationB
    ).

attack(ObjectA, ObjectB) :-
    call(areFriendly(ObjectA, ObjectB)) ->  
    (   write(ObjectA),
        write(' will not attack '),
        write(ObjectB),
        write(', because they are friendly.')
    ), !;
    (   write(ObjectA),
        write(' attack '),
        write(ObjectB),
        write('!'), nl
    ).
