package by.htp.cinema.web;

import static by.htp.cinema.web.util.ConstantDeclaration.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.cinema.web.action.ActionManager;
import by.htp.cinema.web.action.BaseAction;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = -6886728390526627968L;

	private static final Logger logger = LogManager.getLogger();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter(REQUEST_PARAM_ACTION);
		System.out.println(action);
		BaseAction baseAction = ActionManager.getAction(action);
		String page = baseAction.executeAction(req);
		req.getRequestDispatcher(page).forward(req, resp);

	}
}
