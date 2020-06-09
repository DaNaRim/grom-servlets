package DAO;

import exception.InternalServerException;
import model.Item;

import java.util.Date;

public class ItemDAO extends DAO<Item> {

    public ItemDAO(Class<Item> itemClass) {
        super(itemClass);
    }

    @Override
    public Item update(Item object) throws InternalServerException {

        object.setLastUpdatedDate(new Date());

        return super.update(object);
    }
}
