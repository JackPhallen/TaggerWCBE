package tagger.http;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tagger.http.posts.Post;
import tagger.http.tags.Tag;
import tagger.words.Words;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class TagUpdater {

    @Getter
    private static TagUpdater instance = new TagUpdater();


    private static int TAG_SUCCESS = 201;

    private Words words;
    private Post post;
    private WordPressData wordPressData = WordPressData.getInstance();
    private HTTPClient client = new HTTPClient();


    public void POST() throws IOException, InterruptedException {
        String url = this.wordPressData.getPostPath(this.post.getId());
        Map<Object, Object> data = this.buildData();
        this.client.post(url, data);
    }

    public void generateTags() throws IOException, InterruptedException {
        for (String token : this.words) {
            if (!this.wordPressData.getTags().hasTag(token)) {
                this.createTag(token);
            }
        }
    }

    private Map<Object, Object> buildData() {
        List<String> ids = new ArrayList<>();
        for (String token: this.words) {
            int id = this.wordPressData.getTags().getID(token);
            ids.add( Integer.toString(id) );
        }
        Map<Object, Object> data = new HashMap<>();
        data.put("tags", String.join(",", ids) );
        return data;
    }

    private void createTag(String name) throws IOException, InterruptedException {
        String tagURL = this.wordPressData.getTagPath();
        Map<Object, Object> data = Tag.buildData(name);
        Response response = this.client.post(tagURL, data);
        if (response.getStatus() == TAG_SUCCESS) {
            Tag tag = Tag.parseJSON( response.getBody() );
            this.wordPressData.getTags().add( tag );
        }
    }

}
