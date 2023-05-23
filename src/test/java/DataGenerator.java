import lombok.Value;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int days) {
        String date = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        var cities = new String[]{"Воронеж", "Иваново", "Калуга", "Кострома", "Курск", "Липецк", "Москва",
                "Орел", "Рязань", "Смоленск", "Тамбов", "Тверь", "Тула", "Ярославль", "Архангельск", "Вологда",
                "Калининград", "Петрозаводск", "Сыктывкар", "Санкт-Петербург", "Мурманск", "Салехард",
                "Великий Новгород", "Псков", "Санкт-Петербург", "Уфа", "Киров", "Йошкар-Ола", "Саранск",
                "Нижний Новгород", "Оренбург", "Пенза", "Пермь", "Самара", "Саратов", "Казань", "Ижевск",
                "Ульяновск", "Чебоксары", "Курган", "Екатеринбург", "Тюмень", "Югра", "Ханты-Мансийск", "Челябинск",
                "Салехард", "Горно-Алтайск", "Барнаул", "Улан-Удэ", "Чита", "Иркутск", "Кемерово", "Красноярск",
                "Новосибирск", "Омск", "Томск", "Кызыл", "Абакан", "Благовещенск", "Биробиджан",
                "Петропавловск-Камчатский", "Магадан", "Владивосток", "Якутск", "Южно-Сахалинск", "Хабаровск",
                "Анадырь", "Майкоп", "Астрахань", "Волгоград", "Элиста", "Краснодар", "Ростов-на-Дону", "Махачкала",
                "Магас", "Нальчик", "Черкесск", "Владикавказ", "Ставрополь", "Грозный"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        Locale localeRu = new Locale("ru");
        Faker faker = new Faker(localeRu);
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Locale localeRu = new Locale("ru");
        Faker faker = new Faker(localeRu);
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            Locale localeRu = new Locale("ru");
            Faker faker = new Faker(localeRu);
            String city = faker.address().city();
            String name = faker.name().fullName();
            String phone = faker.phoneNumber().phoneNumber();
            UserInfo user = new UserInfo(city, name, phone);
            return user;
        }

        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
    }
}
