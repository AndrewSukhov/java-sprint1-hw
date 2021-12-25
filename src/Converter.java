public class Converter {
    static double lengthStep = 0.75d;
    static double calorieStep = 50d;

    static void convert(int steps) {
        System.out.println("Пройденная дистанция (в км): " + (steps * lengthStep / 1000));
        System.out.println("Количество сожжённых килокалорий: " + (steps * calorieStep / 1000));
    }
}