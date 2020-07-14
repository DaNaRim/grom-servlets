package DAO;

import exception.BadRequestException;
import exception.InternalServerException;
import model.Item;

import java.util.Date;

public class ItemDAO extends DAO<Item> {

    public ItemDAO(Class<Item> itemClass) {
        super(itemClass);
    }

    @Override
    public Item save(Item object) throws InternalServerException {

        object.setDateCreated(new Date());
        object.setLastUpdatedDate(new Date());

        return super.save(object);
    }

    @Override
    public Item update(Item object) throws InternalServerException {

        try {
            object.setDateCreated(findById(object.getId()).getDateCreated());
            object.setLastUpdatedDate(new Date());
        } catch (BadRequestException e) {
            System.err.println("Something went wrong");
        }

        return super.update(object);
    }
}
