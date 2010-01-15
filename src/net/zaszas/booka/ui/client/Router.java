package net.zaszas.booka.ui.client;

public class Router {

    public static final String REGEX_ENTRANCE = "^/entrance$";
    public static final String REGEX_HOME = "^$";
    public static final String REGEX_ARCHIVES = "^/p/\\d+/archives$";

    public static int getProjectFromArchives(String token) {
	return 0;
    }

    public static String project_path(int projectId) {
	return "/p/" + projectId + "/archives";
    }

}
