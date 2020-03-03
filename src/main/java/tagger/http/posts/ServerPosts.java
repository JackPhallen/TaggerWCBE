package tagger.http.posts;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServerPosts implements Iterable<Post> {

    private List<Post> posts = new ArrayList<>();

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Post post : this.posts) {
            titles.add( post.getTitle() );
        }
        return titles;
    }

    public static ServerPosts parseJSON(String json) {
        JSONArray array = new JSONArray(json);
        return ServerPosts.parseJSON(array);
    }


    public static ServerPosts parseJSON(JSONArray array) {
        ServerPosts posts = new ServerPosts();
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            posts.add( Post.parseJSON(object) );
        }
        return posts;
    }

    public int getID(String name) {
        for (Post tag: this.posts) {
            if (tag.getTitle().equals(name)) {
                return tag.getId();
            }
        }
        return -1;
    }

    public void add(Post post) {
        this.posts.add( post );
    }

    public void add(ServerPosts posts) {
        this.posts.addAll( posts.posts );
    }

    public Iterator<Post> iterator() {
        return this.posts.iterator();
    }



}
