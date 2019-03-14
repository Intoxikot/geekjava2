package service.impl;

import constants.Constants;
import valuestype.ActType;
import animals.CharacterValue;
import service.CharacterService;
import valuestype.Gender;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-11
 */
public class DogCharacterService implements CharacterService
{

  @Override
  public CharacterValue getCharacterValue(ActType actType)
  {
    // Смысл конструкций остался тот же, но стал более удобочитаем
    // Я так понимаю, в данном случае не так важно какие конкретно мы будем задавать/использовать значения - придумываем что угодно
    // К тому же, у нас есть определенные константы
    CharacterValue characterValue = new CharacterValue();
    int value = 0;
    switch (actType) {
        case JUMP: value = (Constants.Dog.Female.POWER + Constants.Dog.Male.POWER) / 3;
        case RUN: value = (Constants.Dog.Female.SPEED + Constants.Dog.Male.SPEED) / 2;
        case SWIM: return null; // препятствие нельзя преодолеть
    }
    characterValue.setValue(value);
    characterValue.setName(actType.name());
    return characterValue;
  }

  @Override
  public CharacterValue getCharacterValue(ActType actType, Gender gender)
  {
    // Механика метода осталась та же, добавлена только зависимость от пола
    CharacterValue characterValue = new CharacterValue();
    int value = 0;
    switch (actType) {
        case JUMP: value = (gender == Gender.MALE) ? Constants.Dog.Male.POWER / 2: Constants.Dog.Female.POWER / 5;
        case RUN: value = (gender == Gender.MALE) ? Constants.Dog.Male.SPEED / 3: Constants.Dog.Female.SPEED / 3;
        case SWIM: return null;
    }
    characterValue.setValue(value);
    characterValue.setName(actType.name());
    return characterValue;
  }
}
