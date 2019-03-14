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
public class HumanCharacterService implements CharacterService
{
  @Override
  public CharacterValue getCharacterValue(ActType actType)
  {
    CharacterValue characterValue = new CharacterValue();
    int value = 0;
    switch (actType) {
        case JUMP: value = (Constants.Human.Female.POWER + Constants.Human.Male.POWER) / 3;
        case RUN: value = (Constants.Human.Female.SPEED + Constants.Human.Male.SPEED) / 2;
        case SWIM: value = (Constants.Human.Female.SPEED + Constants.Human.Male.SPEED) / 4;
    }
    characterValue.setValue(value);
    characterValue.setName(actType.name());
    return characterValue;
  }

  @Override
  public CharacterValue getCharacterValue(ActType actType, Gender gender)
  {
    CharacterValue characterValue = new CharacterValue();
    int value = 0;
    switch (actType) {
        case JUMP: value = (gender == Gender.MALE) ? Constants.Human.Male.POWER / 2: Constants.Human.Female.POWER / 5;
        case RUN: value = (gender == Gender.MALE) ? Constants.Human.Male.SPEED / 3: Constants.Human.Female.SPEED / 3;
        case SWIM: value = (gender == Gender.MALE) ? Constants.Human.Male.SPEED / 4: Constants.Human.Female.SPEED / 5;
    }
    characterValue.setValue(value);
    characterValue.setName(actType.name());
    return characterValue;
  }
}
