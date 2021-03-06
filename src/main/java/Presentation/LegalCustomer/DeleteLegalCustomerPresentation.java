package Presentation.LegalCustomer;

import BusinessLogic.BusinessLogic;
import Presentation.Presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Integer.parseInt;

/**
 * Created by Yasi on 11/22/2016.
 */
public class DeleteLegalCustomerPresentation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //request.getAttribute("id");
        String customerNumber = request.getParameter("id");
        //LegalCustomer legalCustomer = BusinessLogic.getLegalCustomerBiz(customerNumber);
        //legalCustomer.setCustomerNumber(parseInt(customerNumber)); //TO Do : check that if it's already saved or not

        String html;
        String body;
        if (BusinessLogic.deleteLegalCustomerBiz(parseInt(customerNumber))) {
            body = "مشتری حقوقی با شماره مشتری " + customerNumber + "حذف شد.";
        } else
            body = "رکوردی حذف نشد. ";

        html = createHTMLString(body);
        out.println(html);
    }

    public String createHTMLString(String body) {
        return
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
                        "http://www.w3.org/TR/html4/loose.dtd\">\n" +
                        "<html charset=UTF-8\" lang=\"fa\" dir=\"rtl\"> \n" +
                        "<style type=\"text/css\">\n" +
                        "    body {\n" +
                        "        background-image:\n" +
                        "                url('images/background.png');\n" +
                        "}\n" +
                        "</style>" +
                        "<head> \n" +
                        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                        "<title>Deleted Legal DataAccessCustomer</title> \n" +
                        "</head> \n" +
                        "<body align='center'>\n" +
                        " <br><br>\n" + " <br><br>\n" +
                        body +
                        " <br><br>\n" +
                        "<a type=\"text\" href=\"index.html\"> صفحه ی اول </a><br>\n" +
                        "</body> \n" +
                        "</html>";

    }
}
