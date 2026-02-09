package br.com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.OnlyPracticeDAO;
import br.com.model.Task;

@WebServlet("/queriescomplexas")
public class QueryComplexaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final OnlyPracticeDAO opdao = new OnlyPracticeDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Task> listLeftJoin = opdao.allTaskJoinEmployee();

		req.setAttribute("listLeftJoin", listLeftJoin);

		req.setAttribute("listByLetter", opdao.listByLetter());
		
		String busca = req.getParameter("busca");
		
		req.setAttribute("listFilter", opdao.listFilter(busca));
		
		System.out.println(opdao.listFilter(busca) + " " + busca);

		req.getRequestDispatcher("queriescomplexas.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
		
	}

}
