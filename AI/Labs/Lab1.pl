:- dynamic hp/2.
:- dynamic atk/2.

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
boss(stormterror).
boss(childe).
boss(azhdaha).

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

% define HP of character `hp(characterName, hitpoints).`
hp('Noelle', 12071).
hp('Klee', 10287).
hp('Ganyu', 9797).
hp('Keqing', 13103).
hp('Ayaka', 12858).
hp(komiomi, 13471).
hp('Nahida', 10360).
hp('Nilou', 15185).
hp('Lynette', 12937).
hp('Neuvilette', 14695).

% define HP of monsters `hp(enemyName, hp).`
hp(slime, hp).
hp(hilichurl, hp).
hp(ruinGuard, hp).
hp(treasureHoarders, hp).
hp(nobushi, hp).
hp(eremite, hp).

% define HP of boss `hp(bossName, hp).`
hp(stormterror, hp).
hp(childe, hp).
hp(azhdaha, hp).

% define ATK of character `atk(characterName, atk).`
atk('Noelle', 701).
atk('Klee', 352).
atk('Ganyu', 943).
atk('Keqing', 323).
atk('Ayaka', 796).
atk(komiomi, 799).
atk('Nahida', 626).
atk('Nilou', 348).
atk('Lynette', 232).
atk('Neuvilette', 208).

% define atk of monsters `atk(enemyName, atk).`
atk(slime, atk).
atk(hilichurl, atk).
atk(ruinGuard, atk).
atk(treasureHoarders, atk).
atk(nobushi, atk).
atk(eremite, atk).

% define atk of boss `atk(bossName, atk).`
atk(stormterror, atk).
atk(childe, atk).
atk(azhdaha, atk).

% define atk of weapons
atk(bloodtaintedGreatsword, 354).
atk(rainslasher, 510).
atk(magicGuide, 354).
atk(skywardAtlas, 674).
atk(oathswornEye, 565).
atk(solarPearl, 510).
atk(tomeOfTheEternalFlow, 542).
atk(amosbow, 608).
atk(fadingTwilight, 565).
atk(silverSword, 243).
atk(filletBlade, 401).
atk(amenomaKageuchi, 454).

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
weapon(bloodtaintedGreatsword). % 沐浴龙血的剑
weapon(rainslasher). % 雨裁
weapon(magicGuide). % 魔法导论
weapon(skywardAtlas). % 天空之卷
weapon(oathswornEye). % 证誓之明瞳
weapon(solarPearl). % 匣里日月
weapon(tomeOfTheEternalFlow). % 万世流涌大典
weapon(amosbow). % 阿莫斯之弓
weapon(fadingTwilight). % 落霞
weapon(silverSword). % 银剑
weapon(filletBlade). % 吃虎鱼刀
weapon(amenomaKageuchi). % 天目影打刀

% define weaponType `weaponType(weaponName, weaponType).`
weaponType(bloodtaintedGreatsword, claymore).
weaponType(rainslasher, claymore).
weaponType(magicGuide, catalyst).
weaponType(skywardAtlas, catalyst).
weaponType(oathswornEye, catalyst).
weaponType(solarPearl, catalyst).
weaponType(tomeOfTheEternalFlow, catalyst).
weaponType(amosbow, bow).
weaponType(fadingTwilight, bow).
weaponType(silverSword, sword).
weaponType(filletBlade, sword).
weaponType(amenomaKageuchi, sword).

% define rules %
object(ObjectName) :-
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
    monster(ObjectA), boss(ObjectB), !;
    boss(ObjectA), monster(ObjectB).

areNeutral(ObjectA, ObjectB) :-
    character(ObjectA), character(ObjectB) ->  
    (   nation(ObjectA, NationA),
        nation(ObjectB, NationB),
        NationA \= NationB
    ).

equip(CharacterName, WeaponName) :-
    canUseWeapon(CharacterName, WeaponName) ->  
    (   atk(CharacterName, X),
        write('The ATK of '), write(CharacterName), write(' is: '), write(X), nl,
        atk(WeaponName, Y),
        NewX is X + Y,
        write('New ATK of '), write(CharacterName), write(' is: '), write(NewX), nl,
        retract(atk(CharacterName, X)),
        asserta(atk(CharacterName, NewX))
    ).
    