import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static final double DISCOUNT_PERCENT = 0.9;
    public static boolean DISCOUNT = false;

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Запуск программы");

        logger.log("Создание справочников");
        Map<String, Integer> itemPrices = new HashMap<>();
        itemPrices.put("ноутбук", 10);
        itemPrices.put("телефон", 20);

        Map<String, Integer> basket = new HashMap<>();

        System.out.println("Приветствую, покупатель!");
        logger.log("Создание сканнера");
        Scanner sc = new Scanner(System.in);

        logger.log("Запуск главного цикла");
        while (true) {
            logger.log("Вывод главного меню");
            System.out.print("Главное меню:\n" +
                    "1 - список товаров" +
                    "\n2 - корзина" +
                    "\n3 - выход" +
                    "\nВведите номер раздела: ");

            int choice = Integer.parseInt(sc.nextLine());

            logger.log("Выбор раздела и запуск соответствующей логики");
            switch (choice) {
                case 1:

                    logger.log("Отображение доступных товаров с ценой каждой позиции");
                    System.out.println("Список доступных товаров: ");

                    for (String key : itemPrices.keySet()) {
                        System.out.println("<" + key + "> [" + itemPrices.get(key) + " руб.]");
                    }
                    System.out.println("<назад>");

                    logger.log("Логика ввода товара с количеством");
                    System.out.print("Напишите имя товара или Назад: ");

                    String item = sc.nextLine();
                    if (!item.equalsIgnoreCase("назад")) {
                        System.out.println("Введите количество: ");
                        int qty = Integer.parseInt(sc.nextLine());
                        basket.put(item, qty);
                        System.out.println("Товар добавлен в Корзину\n");
                    }
                    break;
                case 2:

                    logger.log("Постороение отображения корзины");
                    System.out.println("Корзина: ");
                    if (basket.isEmpty()) {
                        System.out.println("Вы еще не добавили товар\n");
                        break;
                    }

                    logger.log("Расчет стоимости товара в зависимости от количества и скидки");
                    for (String key : basket.keySet()) {
                        int pricePosition;
                        if (DISCOUNT) {
                            pricePosition = (int) (itemPrices.get(key) * basket.get(key) * DISCOUNT_PERCENT);
                        } else {
                            pricePosition = itemPrices.get(key) * basket.get(key);
                        }
                        System.out.println("<" + key + "> | " + basket.get(key) + " шт. | " + pricePosition + " руб.");
                    }

                    System.out.println("1 - применить скидку");
                    System.out.println("2 - назад");

                    int choice2 = Integer.parseInt(sc.nextLine());
                    switch (choice2) {
                        case 1:
                            if (!DISCOUNT) {
                                DISCOUNT = true;
                                System.out.println("Скидка применена\n");
                            } else {
                                System.out.println("Скидка уже применена\n");
                            }
                            break;
                        case 2:
                            break;
                    }
                    break;
                case 3:
                    logger.log("Выход из программы");
                    System.out.println("До свидания!");
                    exit(0);
            }
        }
    }
}
