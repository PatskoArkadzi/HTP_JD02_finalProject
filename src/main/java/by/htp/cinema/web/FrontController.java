package by.htp.cinema.web;

import static by.htp.cinema.web.util.ConstantDeclaration.*;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import by.htp.cinema.web.action.ActionManagerContext;
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
		ServletContext servletContext = req.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		String action = req.getParameter(REQUEST_PARAM_ACTION);
		BaseAction baseAction = ActionManagerContext.getAction(action, webApplicationContext);
		String page;
		if (action != null) {
			page = baseAction.executeAction(req);

			String nextStep = (String) req.getAttribute(REQUEST_PARAM_ACTION);
			System.out.println("action= " + action);
			System.out.println("nextStep= " + nextStep);

			if (nextStep == null || action.equals(nextStep)) {
				req.getRequestDispatcher(page).forward(req, resp);
			} else {
				resp.sendRedirect("do?action=" + nextStep);
			}

		} else {
			logger.error("Incorrect action");
			req.setAttribute(REQUEST_PARAM_ERROR_MESSAGE, "Incorrect action");
			req.getRequestDispatcher(PAGE_ERROR).forward(req, resp);
		}

	}

}
