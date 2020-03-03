package tagger.http.tags;

import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@NoArgsConstructor
public class ServerTags implements Iterable<Tag> {

    private List<Tag> tags = new ArrayList<>();

    public static ServerTags parseJSON(String json) {
        JSONArray array = new JSONArray(json);
        return ServerTags.parseJSON(array);
    }

    public static ServerTags parseJSON(JSONArray array) {
        ServerTags serverTags = new ServerTags();
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            Tag tag = Tag.parseJSON(object);
            serverTags.add(tag);
        }
        return serverTags;
    }



    public boolean hasTag(String name) {
        for (Tag tag: this) {
            if (tag.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int getID(String name) {
        for (Tag tag: this) {
            if (tag.getName().equals(name)) {
                return tag.getId();
            }
        }
        return -1;
    }

    public void add(Tag tag) {
        this.tags.add( tag );
    }

    public void add(ServerTags tags) {
        this.tags.addAll( tags.tags );
    }

    public Iterator<Tag> iterator() {
        return this.tags.iterator();
    }

    public static boolean canParse(String body) {
        String endToken = "[]";
        return !body.equals(endToken);
    }



}
