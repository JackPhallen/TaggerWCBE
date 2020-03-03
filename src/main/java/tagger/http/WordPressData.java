package tagger.http;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tagger.http.posts.ServerPosts;
import tagger.http.tags.ServerTags;

import java.io.IOException;


@Getter
@Setter
@NoArgsConstructor
public class WordPressData {

    @Getter
    private static WordPressData instance = new WordPressData();

    @Getter
    @Setter
    private String url;

    private HTTPClient handler = new HTTPClient();
    private ServerTags tags = new ServerTags();
    private ServerPosts posts = new ServerPosts();

    private static int ERROR_CODE = 400;

    private static String TAG_PATH = "/wp-json/wp/v2/tags";
    private static String POST_PATH = "/wp-json/wp/v2/posts";
    private static String PARAMS = "?per_page=50&page=";

    public void fetchData() throws IOException, InterruptedException {
        this.fetchTags();
        this.fetchPosts();
    }

    public void fetchTags() throws IOException, InterruptedException {
        String tagURL = this.url + TAG_PATH + PARAMS;
        int page = 1;
        boolean doFetch = true;
        while ( doFetch ) {
            String url = tagURL + page;
            Response response = handler.get(url);
            String body = response.getBody();
            if (ServerTags.canParse(body)) {
                this.tags.add( ServerTags.parseJSON(body) );
            } else {
                doFetch = false;
            }
            page++;
        }
    }

    public void fetchPosts() throws IOException, InterruptedException {
        String postURL = this.url + POST_PATH + PARAMS;
        int page = 1;
        boolean doFetch = true;
        while( doFetch ) {
            String url = postURL + page;
            Response response = this.handler.get(url);
            if (response.getStatus() != ERROR_CODE) {
                this.posts.add( ServerPosts.parseJSON(response.getBody()) );
            } else {
                doFetch = false;
            }
            page++;
        }
    }

    public String getTagPath() {
        return this.url + WordPressData.TAG_PATH;
    }

    public String getPostPath() {
        return this.url + WordPressData.POST_PATH;
    }

    public String getPostPath(int id) {
        return this.getPostPath() + '/' + id;
    }


}

