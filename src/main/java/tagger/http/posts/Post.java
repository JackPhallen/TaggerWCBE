package tagger.http.posts;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class Post {

    private String title;
    private int id;

    public Post(int id, String title) {
        this.title = title;
        this.id = id;
    }

    public static Post parseJSON(String json) {
        JSONObject object = new JSONObject(json);
        return Post.parseJSON(object);
    }

    public static Post parseJSON(JSONObject object) {
        int id = object.getInt("id");
        String title = object.getJSONObject("title").getString("rendered");
        return new Post(id, title);
    }
}
