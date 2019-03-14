package constants;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-11
 */
public interface Constants
{
  interface Dog
  {
    interface Male
    {
      public static int SPEED = 16;
      public static int POWER = 18;
    }

    interface Female
    {
      public static int SPEED = 4;
      public static int POWER = 8;
    }

  }

  interface Cat
  {
    interface Male
    {

      public static int SPEED = 9;
      public static int POWER = 6;

    }

    interface Female
    {

      public static int SPEED = 4;
      public static int POWER = 3;
    }

  }

  interface Human
  {

    interface Male
    {

      public static int SPEED = 25;
      public static int POWER = 30;


    }

    interface Female
    {

      public static int SPEED = 12;
      public static int POWER = 30;

    }

  }
}
