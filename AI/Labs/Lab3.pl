% Genshin A.I.mpact, Launch! [doge]

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

% define monsters `monster(monsterName).`
monster('Slime').
monster('Hilichurl').
monster('RuinGuard').
monster('TreasureHoarders').
monster('Nobushi').
monster('Eremite').

% define Boss `Boss(BossName).`
boss('StormTerror').
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

border(moundstalt, liyue).
border(liyue, inazuma).
border(liyue, sumeru).
border(sumeru, fontaine).

% define HP of character `hp(characterName, hitpoints).`
hp('Noelle', 12071).
hp('Klee', 10287).
hp('Ganyu', 9797).
hp('Keqing', 13103).
hp('Ayaka', 12858).
hp('Kokomi', 13471).
hp('Nahida', 10360).
hp('Nilou', 15185).
hp('Lynette', 12937).
hp('Neuvilette', 14695).

% define HP of monsters `hp(enemyName, hp).`
hp('Slime', 3000000).
hp('Hilichurl', 4000).
hp('RuinGuard', 8000).
hp('TreasureHoarders', 5000).
hp('Nobushi', 6000).
hp('Eremite', 5000).

% define HP of boss `hp(bossName, hp).`
hp('StormTerror', 13000).
hp('Childe', 10000).
hp('Azhdaha', 12000).

% define ATK of character `atk(characterName, atk).`
atk('Noelle', 701).
atk('Klee', 352).
atk('Ganyu', 943).
atk('Keqing', 323).
atk('Ayaka', 796).
atk('Kokomi', 799).
atk('Nahida', 626).
atk('Nilou', 348).
atk('Lynette', 232).
atk('Neuvilette', 208).

% define atk of monsters `atk(enemyName, atk).`
atk('Slime', 100).
atk('Hilichurl', 150).
atk('RuinGuard', 300).
atk('TreasureHoarders', 200).
atk('Nobushi', 250).
atk('Eremite', 200).

% define atk of boss `atk(bossName, atk).`
atk('StormTerror', 500).
atk('Childe', 400).
atk('Azhdaha', 450).

% define atk of weapons
atk('Bloodtainted Great Sword', 354).
atk('Rain Slasher', 510).
atk('Magic Guide', 354).
atk('Skyward Atlas', 674).
atk('Oath Sworn Eye', 565).
atk('Solar Pearl', 510).
atk('Tome Of The Eternal Flow', 542).
atk('Amos Bow', 608).
atk('Fading Twilight', 565).
atk('Silver Sword', 243).
atk('Fillet Blade', 401).
atk('Amenoma Kageuchi', 454).

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

reactionFrozen(cryo, hydro).
reactionFrozen(hydro, cryo).
reactionVaporize(pyro, hydro).
reactionVaporize(hydro, pyro).
reactionElectroCharge(electro, hydro).
reactionElectroCharge(hydro, electro).
reactionOverload(pyro, electro).
reactionOverload(electro, pyro).
reactionSuperconduct(cryo, electro).
reactionSuperconduct(electro, cryo).
reactionBurning(pyro, dendro).
reactionBurning(dendro, pyro).
reactionSwirl(anemo, pyro).
reactionSwirl(anemo, hydro).
reactionSwirl(anemo, cryo).
reactionSwirl(anemo, electro).
reactionSwirl(pyro, anemo).
reactionSwirl(hydro, anemo).
reactionSwirl(cryo, anemo).
reactionSwirl(electro, anemo).
reactionMelt(cryo, pyro).
reactionMelt(pyro, cryo).

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
weapon('Magic Guide'). % 魔法导论
weapon('Skyward Atlas'). % 天空之卷
weapon('Oath Sworn Eye'). % 证誓之明瞳
weapon('Solar Pearl'). % 匣里日月
weapon('Tome Of The Eternal Flow'). % 万世流涌大典
weapon('Amos Bow'). % 阿莫斯之弓
weapon('Fading Twilight'). % 落霞
weapon('Silver Sword'). % 银剑
weapon('Fillet Blade'). % 吃虎鱼刀
weapon('Amenoma Kageuchi'). % 天目影打刀

% define weaponType `weaponType(weaponName, weaponType).`
weaponType('Bloodtainted Great Sword', claymore).
weaponType('Rain Slasher', claymore).
weaponType('Magic Guide', catalyst).
weaponType('Skyward Atlas', catalyst).
weaponType('Oath Sworn Eye', catalyst).
weaponType('Solar Pearl', catalyst).
weaponType('Tome Of The Eternal Flow', catalyst).
weaponType('Amos Bow', bow).
weaponType('Fading Twilight', bow).
weaponType('Silver Sword', sword).
weaponType('Fillet Blade', sword).
weaponType('Amenoma Kageuchi', sword).

% define rules %
mob(ObjectName) :-
    character(ObjectName);
    monster(ObjectName);
    boss(ObjectName).

isConnected(NationA, NationB) :-
    border(NationA, NationB);
    border(NationB, NationA).

%define weather a character can use this weapon
canUseWeapon(CharacterNAme, WeaponName) :- 
    character(CharacterNAme),
    weapon(WeaponName),
    useWeaponType(CharacterNAme, Type),
    weaponType(WeaponName, Type).

willCauseReaction(CharacterA, CharacterB) :-
    elementType(CharacterA, ElementA), 
    elementType(CharacterB, ElementB),
    (   reactionFrozen(ElementA, ElementB);
    	reactionVaporize(ElementA, ElementB);
    	reactionElectroCharge(ElementA, ElementB);
    	reactionOverload(ElementA, ElementB);
    	reactionSuperconduct(ElementA, ElementB);
    	reactionBurning(ElementA, ElementB);
    	reactionSwirl(ElementA, ElementB);
    	reactionMelt(ElementA, ElementB)
    ).

%define weather the objectA will attack objectB
areEnemy(ObjectA, ObjectB) :-
    mob(ObjectA), mob(ObjectB),
    character(ObjectA),
    (	monster(ObjectB);
    	boss(ObjectB)
    );
    (   monster(ObjectA), character(ObjectB)
    );
    (   boss(ObjectA), character(ObjectB)
    ).

areFriendly(ObjectA, ObjectB) :-
    mob(ObjectA), mob(ObjectB),
    (   character(ObjectA), character(ObjectB), 
    	nation(ObjectA, NationA),
    	nation(ObjectB, NationB),
        NationA == NationB
    );
    monster(ObjectA), boss(ObjectB);
    boss(ObjectA), monster(ObjectB);
    monster(ObjectA), monster(ObjectB);
    boss(ObjectA), boss(ObjectB).

areNeutral(ObjectA, ObjectB) :-
    mob(ObjectA), mob(ObjectB),
    character(ObjectA), character(ObjectB),
    nation(ObjectA, NationA),
    nation(ObjectB, NationB),
    NationA \= NationB.

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

printStatus(Object) :-
    write('Status of '),
    write(Object),
    write(':'), nl,
    hp(Object, HP),
    atk(Object, ATK),
    write('HP: '),
    write(HP), nl,
    write('ATK: '),
    write(ATK), nl.

hit(ObjectA, ObjectB, DamageMultiplier) :-
    hp(ObjectB, HP_B),
    atk(ObjectA, ATK_A),
    Damage is ATK_A * DamageMultiplier,
    write(ObjectA),
    write(' cause '),
    write(Damage),
    write(' damage '),
	write('to '),
	write(ObjectB), nl,
	NewHP_B is HP_B - Damage,
    retract(hp(ObjectB, HP_B)),
    asserta(hp(ObjectB, NewHP_B)).

attack(CharacterName, EnemyName) :-
    areEnemy(CharacterName, EnemyName) ->  
    (   write(CharacterName),
        write(' attack '),
        write(EnemyName),
        write('!'), nl,  
        printStatus(CharacterName),
        write('Choose a movement:'), nl,
        write('1 - Normal Attack'), nl,
        write('2 - Element Skill'), nl,
        write('3 - Element Burst'), nl,
        write('4 - Escape'), nl,
        read(Movement),
        (   
            Movement == 1 ->  
            (   hit(CharacterName, EnemyName, 1.5),
                printStatus(EnemyName),
                alive(EnemyName) ->  
                (   attackBack(EnemyName, CharacterName),
                    alive(CharacterName) -> 
                    (   attack(CharacterName, EnemyName)
                    );
                    write(CharacterName),
                    write(' lose the fight...'), nl
                );
                write(CharacterName),
                write(' won the fight!'), nl
            );
            Movement == 2 ->  
            (   hit(CharacterName, EnemyName, 2),
                printStatus(EnemyName),
                alive(EnemyName) ->  
                (   attackBack(EnemyName, CharacterName),
                    alive(CharacterName) -> 
                    (   attack(CharacterName, EnemyName)
                    );
                    write(CharacterName),
                    write(' lose the fight...'), nl
                );
                write(CharacterName),
                write(' won the fight!'), nl
            );
            Movement == 3 ->  
            (   hit(CharacterName, EnemyName, 4),
                printStatus(EnemyName),
                alive(EnemyName) ->  
                (   attackBack(EnemyName, CharacterName),
                    alive(CharacterName) -> 
                    (   attack(CharacterName, EnemyName)
                    );
                    write(CharacterName),
                    write(' lose the fight...'), nl
                );
                write(CharacterName),
                write(' won the fight!'), nl
            );
            Movement == 4 ->
            (   write(CharacterName),
                write(' escape!')
            )
        )
    );
    (   write(CharacterName),
        write(' will not attack '),
        write(EnemyName),
        write(', because they are not hostiles.'), nl
    ).

%judge weather mob is alive
alive(Mob) :-
    hp(Mob, HP),
    HP > 0.

attackBack(EnemyName, CharacterName) :-
    areEnemy(EnemyName, CharacterName) ->  
    (   write(EnemyName),
        write(' attack '),
        write(CharacterName),
        write('!'), nl, 
    	hit(EnemyName, CharacterName, 80),
        printStatus(CharacterName)
    ).

%for chossing weapon
chooseWeapon(Weapon) :-
    write('Choose a weapon:'), nl,
    read(Weapon),
    canUseWeapon(Mob, Weapon) ->  
    (   equip(Mob, Weapon)
    );
    write(Mob),
    write(' can not use '),
    write(Weapon),
    write(', choose again!'), nl,
    chooseWeapon(Weapon).

%for chossing mob
chooseMob(Mob) :-
    write('Choose a Mob'), nl,
    read(Mob),
    mob(Mob) ->  
    (   
        character(Mob) ->  
        (   write('You chose '), 
            write(Mob), nl,
            chooseWeapon(_)
        );
        monster(Mob) ->  
        (   write('You chose '), 
            write(Mob), nl
        );
        boss(Mob) ->  
        (   write('You chose '), 
            write(Mob), nl
        )
    );
    write('Invalid Mob!'), nl,
    chooseMob(Mob).

%main function
startBattle :-
    chooseMob(Character),
    chooseMob(Enemy),
    attack(Character, Enemy).