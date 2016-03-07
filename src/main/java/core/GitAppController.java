package core;


import java.io.IOException;

public class GitAppController {

	private GitHubConnector github;

	public GitAppController(String login, String password) throws IOException {
		github = new GitHubConnector(login, password);
	}

	/**
	 * This method creates a git repo with a .aia it has no parameters or things
	 * like that because this example is very static and limited, but in a real
	 * situation, it would have a parameter for the file, name of the repo, etc.
	 * 
	 * @throws IOException
	 */
	public String createRepoAia(byte [] file) throws IOException {
		String name = "appInventor" + Math.random();
		github.createRepository(name, "none", "none", true);
		github.uploadAia(name, file);
		return name;
	}

}
