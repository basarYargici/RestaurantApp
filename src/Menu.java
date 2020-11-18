import java.util.HashMap;

public class Menu {
    //region Attributes
    //Use HashMap for key-value mapping like dictionary
    private HashMap<String, Double> menuList = new HashMap<>();
    //endregion

    //region Methods
    //Return menuList
    public HashMap<String, Double> getMenuList() {
        return menuList;
    }

    //Add new item(key and value) into menuList
    public void addToMenu(String key, double price) {
        menuList.put(key, price);
    }

    //Remove item(key and value) from menuList
    public void removeFromMenu(String key) {
        if (menuList.containsKey(key)) {
            System.out.println(key +" deleted from list.");
            menuList.remove(key);
        } else {
            System.out.println("Menu does not contain" + key);
        }
    }

    //Print all the items, where key is the name and value is cost, in menuList
    public void printMenu() {
        String titleTemplate = "%-10s %18s";
        String template = "%-22s %.1f ";

        System.out.println("\nWelcome! \nMenu:");
        System.out.printf(titleTemplate, "Name", "Cost TL");
        System.out.println();
        for (String value : menuList.keySet()) {
            System.out.printf(template, value,menuList.get(value));
            System.out.println();
            //System.out.println(value + " = " + menuList.get(value) + " TL");
        }
    }
    //endregion
}
