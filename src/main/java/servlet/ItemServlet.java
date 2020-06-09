package servlet;

import exception.BadRequestException;
import exception.InternalServerException;
import model.Item;
import service.ItemService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/test")
public class ItemServlet extends HttpServlet {

    private static final ItemService itemService = new ItemService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.getWriter().println(itemService.findById(Long.parseLong(req.getParameter("id"))));

        try {
            resp.getWriter().println(itemService.findById(Long.parseLong(req.getParameter("id"))));

        } catch (BadRequestException | InternalServerException e) {

            resp.getWriter().println(e.getMessage());
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            Item item = new Item(
                    req.getParameter("name"),
                    req.getParameter("description")
            );

            resp.getWriter().println(itemService.save(item));

        } catch (BadRequestException | InternalServerException e) {

            resp.getWriter().println(e.getMessage());
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            Item item = new Item(
                    req.getParameter("name"),
                    req.getParameter("description")
            );

            resp.getWriter().println(itemService.update(item));

        } catch (BadRequestException | InternalServerException e) {

            resp.getWriter().println(e.getMessage());
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            itemService.delete(Long.parseLong(req.getParameter("id")));

            resp.getWriter().println("Delete success");
        } catch (InternalServerException | BadRequestException e) {

            resp.getWriter().println(e.getMessage());
            System.err.println(e.getMessage());
        }
    }

    //servlet registration - init()
    //servlet  works with service method
    //to close servlet with its resources - destroy()

    //HTTP REQUESTS
    // GET - get some info
    // POST - save some info
    // PUT - update
    // DELETE - delete info

    //CRUD
}
