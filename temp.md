```prolog
% define characters %
character(name).

% define the nation of characters 
nation(characterName, nation).

% define HP of character 
hp(characterName, Hitpoints).

% define ATK of character 
atk(characterName, ATK).

% define elementType of character 
elementType(characterName, element).

% define weaponType of character 
weaponType(characterName, weaponType).

% define 
weapon(weponName, weaponType).

% define equipment of characters 
equipment(characterName, weaponName).
```

define rules
```prolog
canEquip(CharacterName, WeaponName) :-
    weaponType(CharacterName, weaponType)
    weapon(WeponName, weaponType)
```