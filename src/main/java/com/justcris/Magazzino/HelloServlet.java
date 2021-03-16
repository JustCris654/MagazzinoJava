
/*
 * 3/16/21, 12:48 PM. Scapin Cristian @JustCris654
 */

package com.justcris.Magazzino;



import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private Items items;
    private Items carrello;

    public void init() {
        items = new Items(new ArrayList<Item>() {
            {
                add(new Item(1, "Cacao", 3.49, 10, "cacao.png"));
                add(new Item(2, "Latte", 0.89, 5, "milk.png"));
                add(new Item(3, "Farina", 1.99, 11, "farina.png"));
                add(new Item(4, "Uova", 5.0, 13, "eggs.png"));
                add(new Item(5, "Scarpe", 40.0, 8, "shoes.png"));
            }
        });
        carrello = new Items();
    }

    private Double getTotalPrice(Items chart) {
        Double price = 0.0;
        for (Item item :
                chart.getItems()) {
            price += item.getPrice();
        }
        return price;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        Double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        items.addItem(new Item(id, title, price, quantity));
        System.out.println(id + " " +
                title + " " +
                price + " " +
                quantity + "\n"
        );
        out.println("ok");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        try {
            String[] itemsToBuy = request.getParameter("buy").split(",");
//            System.out.println(Arrays.toString(itemsToBuy));
            for (String s :
                    itemsToBuy) {
                Item item = items.getItemClone(Integer.parseInt(s));
                System.out.println(item.toString());
                carrello.addItem(item);
//                int quantity = items.getItem(Integer.parseInt("s")).getQuantity();
//                System.out.println("Quantity: "+quantity);
//                items.getItem(Integer.parseInt("s")).setQuantity(--quantity);
            }

        } catch (Exception e) {
            System.out.println("Errore");
        }

        if(request.getParameter("acquista")!= null){
            for (Item item :
                    carrello.getItems()) {
                items.getItem(item.getId()).removeQuantity(item.getQuantity());
            }
            carrello = new Items();
        }


        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>");

        out.println("<form method=\"post\" action=\"hello-servlet\">\n" +
                "        <fieldset>\n" +
                "            <p class=\"articles\">");
        for (Item item :
                items.getItems()) {
            out.println(item.toString());
        }
        out.println("</p>\n" +
                "        </fieldset>\n" +
                "        <label for=\"buy\">\n" +
                "            Articoli da acquistare:\n" +
                "        </label>\n" +
                "        <input type=\"text\" name=\"buy\" id=\"buy\" placeholder=\"1,2,3,4,...\">\n" +
                "            <input type=\"submit\" value=\"Aggiungi al carrello\">\n" +
                "    </form>\n" +
                "\n" + "<fieldset>\n" +
                "    <h3>Carrello:</h3>\n" +
                "    <p>");
        for (Item item :
                carrello.getItems()) {
            out.println(item.toString());
        }
                out.println("</p>\n" +
                "\n" +
                "</fieldset>" +
                "    <h4>Totale:");
        out.println(getTotalPrice(carrello)+"</h4>");

        out.println("<form action=\"hello-servlet\" method=\"post\">\n" +
                "    <input type=\"submit\" name=\"acquista\" id=\"acquista\" value=\"Acquista\">\n" +
                "\n" +
                "</form>");

        out.println("</body>\n" +
                "</html>");


    }

    public void destroy() {
    }
}