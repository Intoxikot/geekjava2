package service;

import valuestype.ActType;
import animals.CharacterValue;
import valuestype.Gender;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-11
 */
public interface CharacterService
{

  CharacterValue getCharacterValue(ActType actType);

  CharacterValue getCharacterValue(ActType actType, Gender gender);

}
