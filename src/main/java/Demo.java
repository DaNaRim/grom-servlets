import model.Item;
import service.ItemService;

public class Demo {
    private static final ItemService itemService = new ItemService();

    public static void main(String[] args) throws Exception {
        Item item = new Item("bottle0111", "TestBottle0");

        System.out.println(itemService.save(item).toString());
        item.setName("fringe");
        System.out.println(itemService.update(item).toString());
        itemService.delete(26);
        System.out.println(itemService.findById(27).toString());
    }
}
