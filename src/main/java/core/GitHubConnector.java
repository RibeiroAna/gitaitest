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

	public void createRepository(String name, String description, String homepage, Boolean isPublic)
			throws IOException {
		gitHub.createRepository(name, description, homepage, isPublic);
	}

	public void uploadAia(String name, byte[] file) throws IOException {
		GHRepository repository = gitHub.getRepository(username + "/" + name);
		repository.createContent(file, "first commit", "test.aia");
	}

}