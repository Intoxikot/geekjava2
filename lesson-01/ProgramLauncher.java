import animals.Cat;
import animals.Course;
import animals.Human;
import animals.Team;
import valuestype.ActType;
import valuestype.Gender;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-11
 */
public class ProgramLauncher
{
  public static void main(String[] args)
  {

    Human koteev = new Human(25, "Koteev", Gender.MALE);
    Human dareeva = new Human(23, "Dareeva", Gender.FEMALE);
    Human panin = new Human(24, "Panin", Gender.MALE);
    Human usov = new Human(22, "Usov", Gender.MALE);

    Team teamZero = new Team(koteev, dareeva, panin, usov);
    Course course = new Course(new ActType[]{ActType.JUMP, ActType.RUN, ActType.SWIM, ActType.RUN});
    course.doIt(teamZero);
    teamZero.showResults();
  }
}
