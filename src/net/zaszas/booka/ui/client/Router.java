package net.zaszas.booka.ui.client;

public class Router {

    public static final String REGEX_ENTRANCE = "^/entrance$";
    public static final String REGEX_HOME = "^$";
    private static final String REGEX_ARCHIVES = "^/p/\\d+/archives$";

    public static int getProjectFromArchives(String token) {
	return 0;
    }

    public static String getProjectId(String token) {
	return null;
	// FIXME
    }

    public static boolean isProjectPath(String token) {
	return token.matches(Router.REGEX_ARCHIVES);
    }

    public static String project_path(String projectId) {
	return "/p/" + projectId + "/archives";
    }

}
