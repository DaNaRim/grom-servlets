package service;

import DAO.ItemDAO;
import exception.BadRequestException;
import exception.InternalServerException;
import exception.NotFoundException;
import model.Item;

public class ItemService {

    private static final ItemDAO itemDAO = new ItemDAO();

    public Item findById(long id) throws InternalServerException, NotFoundException {
        return itemDAO.findById(id);
    }

    public Item save(Item item) throws InternalServerException, BadRequestException {
        validateItem(item);

        return itemDAO.save(item);
    }

    public Item update(Item item) throws BadRequestException, InternalServerException {
        validateItem(item);

        return itemDAO.update(item);
    }

    public void delete(long id) throws BadRequestException, InternalServerException {
        Item item;
        try {
            item = itemDAO.findById(id);
        } catch (NotFoundException e) {
            throw new BadRequestException(e.getMessage());
        }
        itemDAO.delete(item);
    }

    private void validateItem(Item item) throws BadRequestException {
        if (item == null) {
            throw new BadRequestException("Impossible to process null item");
        }
        if (item.getName() == null
                || item.getDescription() == null
                || item.getName().isBlank()
                || item.getDescription().isBlank()) {
            throw new BadRequestException("Not all fields are filled");
        }
        if (item.getName().length() > 50 || item.getDescription().length() > 300) {
            throw new BadRequestException("Fields size is too long");
        }
    }
}
