package DAO;

import exception.InternalServerException;
import exception.NotFoundException;
import model.Item;

import java.util.Date;

public class ItemDAO extends DAO<Item> {

    public ItemDAO() {
        super(Item.class);
    }

    @Override
    public Item save(Item object) throws InternalServerException {
        object.setDateCreated(new Date());
        return super.save(object);
    }

    @Override
    public Item update(Item object) throws InternalServerException {
        try {
            object.setDateCreated(findById(object.getId()).getDateCreated());
            object.setLastUpdatedDate(new Date());
        } catch (NotFoundException e) {
            throw new InternalServerException(e.getMessage());
        }
        return super.update(object);
    }
}
