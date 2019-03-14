package animals;

public class Team {

    private Human[] team; // наша команда может состоять только из людей (мне так больше нравится)
    private StringBuffer results;

    // Количество участников в команде строго ограничено и может быть только 4
    public Team(Human mate1, Human mate2, Human mate3, Human mate4) {
        this.team = new Human[]{mate1, mate2, mate3, mate4};
        results = new StringBuffer();
    }

    // Позволяет общаться с каждым конкретным участником команды
    public Human getMate(int index) {
        if (index < 0 || index > 3)
            return null;
        return team[index];
    }

    // Зафиксировать результаты, подача осуществляется в виде строки, а формат записи будет определять сама полоса препятствий
    public void addResult(String result) {
        results.append('\n');
        results.append(result);
    }

    // Вывод результатов
    public void showResults() {
        System.out.println(results.toString());
    }
}
