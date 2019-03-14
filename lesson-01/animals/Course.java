package animals;

import valuestype.ActType;

// Полоса препятствий
public class Course {
    ActType[] line; // набор препятствий

    public Course(ActType[] line) {
        this.line = line;
    }

    public void doIt(Team squad) {
        // Каждый участник проходит каждое препятствие (результаты записываются в лог команды)
        for (ActType act : line)
            for (int i = 0; i < 4; i++) {
                Human mate = squad.getMate(i);
                String name = mate.getName();
                int value = doIt(mate, act);
                squad.addResult(name + " : " + value + " [" + act.name() + "]");
            }
    }

    // Одиночное преодоление препятствия
    private int doIt(Human mate, ActType act) {
        switch (act) {
            case JUMP: return mate.jump();
            case RUN: return mate.run();
            case SWIM: return mate.swim();
            default: return 0;
        }
    }
}