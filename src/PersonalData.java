import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class PersonalData {
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.print("Введите данные (Фамилия Имя Отчество дата рождения номер телефона пол): ");
        try (Scanner scanner = new Scanner(System.in)) {
            String data = scanner.nextLine();

            String[] dataArray = data.split(" ");


            if(dataArray.length != 6) {
                throw new IllegalArgumentException("Ошибка! Введено неверное количество данных!");
            }

            String surname = dataArray[0];
            String name = dataArray[1];
            String patronymic = dataArray[2];

            String birthDateStr = dataArray[3];
            LocalDate birthDate = LocalDate.parse(birthDateStr, java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));

            long phoneNumber = Long.parseLong(dataArray[4]);

            char gender = dataArray[5].charAt(0);

            StringBuilder output = new StringBuilder();
            output.append("Фамилия: ").append(surname).append("\n")
                    .append("Имя: ").append(name).append("\n")
                    .append("Отчество: ").append(patronymic).append("\n")
                    .append("Дата рождения: ").append(birthDate).append("\n")
                    .append("Номер телефона: ").append(phoneNumber).append("\n")
                    .append("Пол: ").append(gender);
            System.out.println(output);

            File file = new File(surname + ".txt");
            try(FileWriter writer = new FileWriter(file)) {
                writer.write(output.toString());
            } catch(IOException ex) {
                System.out.println("Ошибка записи персональных данных в файл: " + ex.getMessage());
            }

        } catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}