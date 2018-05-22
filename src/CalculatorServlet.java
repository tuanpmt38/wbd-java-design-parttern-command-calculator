import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/cal")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("operator");
        int firstNumber = Integer.parseInt(request.getParameter("firstNumber"));
        int secondNumber = Integer.parseInt(request.getParameter("secondNumber"));
        Calculator calculator ;
        if(op.equals("+")){
            calculator = new Calculator(new AddperatorImpl());
        }else {
            calculator = new Calculator( new SubperatorImpl());
        }

        int result = calculator.excute(firstNumber,secondNumber);
        request.setAttribute("result", result);
        request.setAttribute("firstNumber",firstNumber);
        request.setAttribute("second", secondNumber);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
