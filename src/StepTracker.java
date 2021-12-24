import java.util.ArrayList;
import java.util.HashMap;

public class StepTracker {
    HashMap<String, ArrayList<Integer>> stepsCount;
    ArrayList<Integer> calendar;
    int stepsPerDay;
    int targetStepCount;

    StepTracker() {
        stepsCount = new HashMap<>();
        calendar = new ArrayList<>();
        stepsPerDay = 0;
        targetStepCount = 10_000;
        for (int i = 0; i < 30; i++) {
            calendar.add(i, stepsPerDay);
        }
        stepsCount.put("Январь", calendar);
        stepsCount.put("Февраль", calendar);
        stepsCount.put("Март", calendar);
        stepsCount.put("Апрель", calendar);
        stepsCount.put("Май", calendar);
        stepsCount.put("Июнь", calendar);
        stepsCount.put("Июль", calendar);
        stepsCount.put("Август", calendar);
        stepsCount.put("Сентябрь", calendar);
        stepsCount.put("Октябрь", calendar);
        stepsCount.put("Ноябрь", calendar);
        stepsCount.put("Декабрь", calendar);
    }
    //todo написать метод сейвСтепс, который сохранит в Хеш таблицу три переменные.
    public void saveSteps(String month, int day, int steps) {
        if (steps < 0) {
            System.out.println("Количество шагов должно быть неотрицательным");
        }
        if (stepsCount.containsKey(month)) {
            calendar.add(day - 1, steps);
            stepsCount.put(month, calendar);
            System.out.println("Данные сохранены");
        } else {
            System.out.println("Название месяца введено неверно");
        }
    }

    public void printStatistic(String month) {
        int totalSumSteps = 0;
        int maxSteps = 0;
        int dayOfMaxSteps = 0;
        if (stepsCount.containsKey(month)) {
            for (int i = 0; i < calendar.size(); i++) {
                int steps = stepsCount.get(month).get(i);
                System.out.println((i + 1) + "день: " + steps);
                totalSumSteps += steps;
                if (steps > maxSteps) {
                    maxSteps = steps;
                    dayOfMaxSteps = i + 1;
                }
            }
            int avgSteps = totalSumSteps / calendar.size();
            System.out.println("Общее количество шагов за месяц: " + totalSumSteps);
            System.out.println("Максимальное количество шагов - " + maxSteps +
                    "было пройдено в день номер" + dayOfMaxSteps);
            System.out.println("Среднее количество шагов в день: " + avgSteps);
            //todo Количество сожжённых килокалорий;
            // todo Лучшая серия targetStepCount
        } else {
            System.out.println("Название месяца введено неверно");
        }
    }
}
/*
Подсчёт и вывод статистики за указанный пользователем месяц.
В статистике должны быть следующие данные:
Количество пройденных шагов по дням в следующем формате:
1 день: 3000, 2 день: 2000, ..., 30 день: 10000
Общее количество шагов за месяц;
Максимальное пройденное количество шагов в месяце;
Среднее количество шагов;
Пройденная дистанция (в км);
Количество сожжённых килокалорий;
Лучшая серия: максимальное количество подряд идущих дней,
в течение которых количество шагов за день было выше целевого.
Если текущий день — первый в месяце (количество дней, за которое есть данные = 0),
то вывод статистики должен работать корректно: все показатели должны быть равны нулю.



В памяти приложения хранится следующая информация:
Название месяца и данные о шагах пройденных в каждый день этого месяца.
Для удобства считаем, что в месяце всегда ровно 30 дней.
Целевое количество шагов. При старте приложения устанавливается равным 10000.
В классе должна быть реализована следующая функциональность:
Сохранение количества шагов за день. Пользователь должен указать название месяца,
номер дня и количество шагов, пройденных в этот день.
Количество шагов должно быть неотрицательным.
Для ускорения прототипирования на данном этапе считается,
что в месяце ровно 30 дней. Если за какой-то день статистика не сохранялась,
то считаем количество шагов в этот день равным 0.
 */