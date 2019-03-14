package animals;

import service.CharacterService;
import service.impl.CatCharacterService;
import valuestype.ActType;
import valuestype.Gender;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-11
 */
public class Cat extends Animal
{
  private CharacterService characterService = new CatCharacterService();


  public Cat(Gender gender)
  {
    super(gender);
  }

  public Cat(int age, Gender gender)
  {
    super(age, gender);
  }

  public Cat(int age, String name, Gender gender)
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

}
