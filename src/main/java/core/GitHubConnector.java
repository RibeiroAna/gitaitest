package core;

import java.io.IOException;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class GitHubConnector {

	private GitHub gitHub;
	private String username;

	public GitHubConnector(String username, String password) throws IOException {
		gitHub = GitHub.connectUsingPassword(username, password);
		this.username = username;
	}

	public void createRepository(String repoName, String description, String homepage, Boolean isPublic)
			throws IOException {
		gitHub.createRepository(repoName, description, homepage, isPublic);
	}

	public void uploadAia(String repoName, byte[] file) throws IOException {
		GHRepository repository = gitHub.getRepository(username + "/" + repoName);
		repository.createContent(file, "first commit", "test.aia");
	}

}
