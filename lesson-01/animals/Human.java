package animals;

import behavers.Swim;
import service.CharacterService;
import service.impl.HumanCharacterService;
import valuestype.ActType;
import valuestype.Gender;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-11
 */
public class Human extends Animal implements Swim
{
  private CharacterService characterService = new HumanCharacterService();

  public Human(Gender gender)
  {
    super(gender);
  }

  public Human(int age, Gender gender)
  {
    super(age, gender);
  }

  public Human(int age, String name, Gender gender)
  {
    super(age, name, gender);
  }

  @Override
  public int jump()
  {
    CharacterValue characterValue = characterService.getCharacterValue(ActType.JUMP, getGender());
    return characterValue.getValue();
  }

  @Override
  public int run()
  {
    CharacterValue characterValue = characterService.getCharacterValue(ActType.RUN, getGender());
    return characterValue.getValue();
  }

  @Override
  public int swim()
  {
    CharacterValue characterValue = characterService.getCharacterValue(ActType.SWIM, getGender());
    return characterValue.getValue();

  }
}
