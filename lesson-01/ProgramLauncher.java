import animals.Cat;
import valuestype.Gender;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-11
 */
public class ProgramLauncher
{
  public static void main(String[] args)
  {

    Cat maleCat = new Cat(2, "Vasya", Gender.MALE);
    Cat femaleCat = new Cat(3, "Katya", Gender.FEMALE);


    //RUN
    System.out.println(maleCat.getName() + " : " + maleCat.run());
    System.out.println(femaleCat.getName() + " : " + femaleCat.run());

    //JUMP
    System.out.println(maleCat.getName() + " : " + maleCat.jump());
    System.out.println(femaleCat.getName() + " : " + femaleCat.jump());


  }
}
