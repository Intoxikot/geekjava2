import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class PhoneCatalog {

    private Map<String, List<String>> records;

    public PhoneCatalog() {
        records = new HashMap<>();
    }

    // Добавить абонента, его номер
    public void add(String name, String number) {
        List<String> listNumbers = records.get(name);
        if (listNumbers != null) {  // если фамилия уже существует, то нужно всего лишь добавить новый номер
            listNumbers.add(number);
        } else { // в противном случае, нужно добавить новую фамилию в справочник и присвоить ей текущий номер
            listNumbers = new ArrayList<>();
            listNumbers.add(number);
            records.put(name, listNumbers);
        }
    }

    // Поиск номеров, результат передается напрямую в консоль
    public void get(String name) {
        System.out.println(find(name));
    }

    // Ищет совпадения по имени, сообщает результат в виде строки с перечислением номеров
    private String find(String name) {
        List<String> listNumbers = records.get(name);
        if (listNumbers != null)
            return "results of search for \'" + name + "\': " + listNumbers.toString();
        else
            return "contacts does not exist";
    }

    // Проверка, рабочий тест
    public static void main(String[] args) {
        PhoneCatalog catalog = new PhoneCatalog();
        catalog.add("koteev", "+7-952-515-57-35");
        catalog.add("koteev", "+7-652-510-23-30");
        catalog.add("koteev", "4-17-04");
        catalog.add("sirius", "+7-950-640-00-00");
        catalog.add("fridrich", "+7-950-677-22-34");
        catalog.add("kolachev", "222-22");
        catalog.add("kolachev", "8-351-471-47-46");

        catalog.get("koteev");
        catalog.get("sirius");
        catalog.get("fridrich");
        catalog.get("kolachev");
        catalog.get("machinin");
    }
}