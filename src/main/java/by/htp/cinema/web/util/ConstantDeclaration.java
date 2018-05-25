package by.htp.cinema.web.util;

public final class ConstantDeclaration {

	public static final String SESSION_PARAM_CURRENT_USER = "current_user";

	public static final String REQUEST_PARAM_ACTION = "action";
	public static final String REQUEST_PARAM_CRUD_COMMAND = "crud_command";
	public static final String REQUEST_PARAM_ERROR_MESSAGE = "error_message";
	public static final String REQUEST_PARAM_CURRENT_DATE = "current_date";
	public static final String REQUEST_PARAM_USER_CHOSEN_DATE = "user_chosen_date";
	public static final String REQUEST_PARAM_CHOSEN_FILM_FILM_SESSIONS = "chosen_film_film_sessions";

	public static final String REQUEST_PARAM_ROLE_LIST = "rolelist";
	public static final String REQUEST_PARAM_ROLE_ID = "role_id";
	public static final String REQUEST_PARAM_ROLE_NAME = "role_name";
	public static final String REQUEST_PARAM_FOUND_ROLE = "found_role";

	public static final String REQUEST_PARAM_USER_LIST = "userlist";
	public static final String REQUEST_PARAM_USER_ID = "user_id";
	public static final String REQUEST_PARAM_USER_LOGIN = "user_login";
	public static final String REQUEST_PARAM_USER_EMAIL = "user_email";
	public static final String REQUEST_PARAM_USER_PASSWORD = "user_password";
	public static final String REQUEST_PARAM_USER_ROLE = "user_role";
	public static final String REQUEST_PARAM_FOUND_USER = "found_user";

	public static final String REQUEST_PARAM_GENRE_LIST = "genrelist";
	public static final String REQUEST_PARAM_GENRE_ID = "genre_id";
	public static final String REQUEST_PARAM_GENRE_NAME = "genre_name";
	public static final String REQUEST_PARAM_FOUND_GENRE = "found_genre";
	public static final String REQUEST_PARAM_CRUD_GENRE = "crud_genre";

	public static final String REQUEST_PARAM_FILM_LIST = "filmlist";
	public static final String REQUEST_PARAM_FILM_ID = "film_id";
	public static final String REQUEST_PARAM_FILM_NAME = "film_name";
	public static final String REQUEST_PARAM_FILM_DESCRIPTION = "film_description";
	public static final String REQUEST_PARAM_FILM_POSTER_URL = "film_poster_url";
	public static final String REQUEST_PARAM_FILM_GENRES = "film_genres";
	public static final String REQUEST_PARAM_FOUND_FILM = "found_film";
	public static final String REQUEST_PARAM_USER_CHOSEN_FILM = "user_chosen_film";
	public static final String REQUEST_PARAM_CRUD_FILM = "crud_film";

	public static final String CRUD_OPERATION_NAME_CREATE = "create";
	public static final String CRUD_OPERATION_NAME_READ = "read";
	public static final String CRUD_OPERATION_NAME_UPDATE = "update";
	public static final String CRUD_OPERATION_NAME_DELETE = "delete";

	public static final String ACTION_NAME_VIEW_FILM_LIST = "view_film_list";
	public static final String ACTION_NAME_VIEW_FILM_PAGE = "view_film_page";
	public static final String ACTION_NAME_CRUD_ROLE = "crud_role";
	public static final String ACTION_NAME_CRUD_USER = "crud_user";
	public static final String ACTION_NAME_CRUD_GENRE = "crud_genre";
	public static final String ACTION_NAME_CRUD_FILM = "crud_film";

	public static final String PAGE_USER_MAIN = "/WEB-INF/pages/user/main.jsp";
	public static final String PAGE_USER_FILM_PAGE = "/WEB-INF/pages/user/film_page.jsp";
	public static final String PAGE_ADMIN_CRUD_ROLE = "/WEB-INF/pages/admin/crud_role.jsp";
	public static final String PAGE_ADMIN_CRUD_USER = "/WEB-INF/pages/admin/crud_user.jsp";
	public static final String PAGE_ADMIN_CRUD_GENRE = "/WEB-INF/pages/admin/crud_genre.jsp";
	public static final String PAGE_ADMIN_CRUD_FILM = "/WEB-INF/pages/admin/crud_film.jsp";
	public static final String PAGE_ERROR = "/WEB-INF/pages/error.jsp";

	public static final String CURRENT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String EMAIL_INPUT_VALIDATION_REGEX = "(\\w{5,})@(\\w+\\.)([a-z]{2,4})";

	public static final String SIGN_UP_CHECK_LOGIN_RESULT_STRING = "<span style=\"color:%s;\">%s</span>";
	public static final String SIGN_UP_CHECK_LOGIN_FAIL_COLOR = "#FF0000";
	public static final String SIGN_UP_CHECK_LOGIN_SUCCESS_COLOR = "#008B00";

	public static final String SIGN_UP_CHECK_EMAIL_RESULT_STRING = "<span style=\"color:#FF0000;\">%s</span>";

	public static final String SIGN_UP_CHECK_PASSWORD_RESULT_STRING = "<span style=\"color:%s;\">%s</span>";
	public static final String SIGN_UP_CHECK_PASSWORD_WEAK_STRENGTH_COLOR = "#FF0000";
	public static final String SIGN_UP_CHECK_PASSWORD_MIDDLE_STRENGTH_COLOR = "#FFFF00";
	public static final String SIGN_UP_CHECK_PASSWORD_STRONG_STRENGTH_COLOR = "#008B00";
	public static final int SIGN_UP_CHECK_PASSWORD_WEAK_STRENGTH = 1;
	public static final int SIGN_UP_CHECK_PASSWORD_MIDDLE_STRENGTH = 5;
	public static final int SIGN_UP_CHECK_PASSWORD_STRONG_STRENGTH = 7;
}
