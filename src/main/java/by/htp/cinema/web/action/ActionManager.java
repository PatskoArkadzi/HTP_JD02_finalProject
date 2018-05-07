package by.htp.cinema.web.action;

import java.util.HashMap;
import java.util.Map;

import by.htp.cinema.web.action.impl.CrudFilmAction;
import by.htp.cinema.web.action.impl.CrudGenreAction;
import by.htp.cinema.web.action.impl.CrudRoleAction;
import by.htp.cinema.web.action.impl.CrudUserAction;
import by.htp.cinema.web.action.impl.FilmListViewAction;

import static by.htp.cinema.web.util.ConstantDeclaration.*;

public class ActionManager {

	private static Map<String, BaseAction> actions;

	static {
		actions = new HashMap<>();
		actions.put(ACTION_NAME_VIEW_FILM_LIST, new FilmListViewAction());
		actions.put(ACTION_NAME_CRUD_ROLE, new CrudRoleAction());
		actions.put(ACTION_NAME_CRUD_USER, new CrudUserAction());
		actions.put(ACTION_NAME_CRUD_GENRE, new CrudGenreAction());
		actions.put(ACTION_NAME_CRUD_FILM, new CrudFilmAction());

	}

	public ActionManager() {
	}

	public static BaseAction getAction(String action) {
		return actions.get(action);
	}
}
