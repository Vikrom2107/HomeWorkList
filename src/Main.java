import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> shopList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Введите одну из операций для списка покупок\n" +
                    "(1. добавить, 2. показать, 3. удалить, 4. найти): ");
            String input = scan.nextLine();
            if ("end".equals(input)) {
                break;
            }
            if ("1".equals(input) || "добавить".equals(input) ) {
                addProduct(shopList, scan);
            }
            if ("2".equals(input) || "показать".equals(input)) {
                showList(shopList);
                System.out.println("*******************");
            }
            if ("3".equals(input) || "удалить".equals(input)) {
                showList(shopList);
                deleteProduct(shopList, scan);
            }
            if ("4".equals(input) || "найти".equals(input)) {
                searchProducts(shopList, scan);
            }
        }
    }

    private static void searchProducts(ArrayList<String> shopList, Scanner scan) {
        System.out.println("Введите текст для поиска: ");
        String find = scan.nextLine();
        System.out.println("Найдено: ");
        int findAmount = 0;
        for (int i = 0; i < shopList.size(); i++) {
            if (shopList.get(i).toLowerCase().contains(find.toLowerCase())) {
                System.out.println(i+1 + ". " + shopList.get(i));
                findAmount += 1;
            }
        }
        if (findAmount == 0)
            System.out.println(findAmount);
        System.out.println("*******************");
    }

    private static void deleteProduct(ArrayList<String> shopList, Scanner scan) {
        System.out.println("Какую покупку хотите удалить? Введите номер или название: ");
        String deleteInput = scan.nextLine();
        try {
            int number = Integer.parseInt(deleteInput);
            shopList.remove(number-1);
            System.out.println("*******************");
        } catch (NumberFormatException e) {
            shopList.remove(deleteInput);
            System.out.println("*******************");
        }

    }

    private static void addProduct(ArrayList<String> shopList, Scanner scan) {
        System.out.println("Какую покупку хотите добавить? (Введите название)");
        String product = scan.nextLine();
        shopList.add(product);
        System.out.println("Итого в списке покупок " + shopList.size());
        System.out.println("*******************");
    }

    public static void showList(ArrayList<String> shopList) {
        System.out.println("Список покупок: ");
        for(int i = 0; i < shopList.size(); i++) {
            System.out.println(i+1 + ". " + shopList.get(i));
        }
    }
}
