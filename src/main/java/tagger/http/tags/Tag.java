package tagger.http.tags;

import lombok.Getter;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Tag {

    @Getter
    private int id;
    @Getter
    private String name;

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Map<Object, Object> buildData(String name) {
        String slug = buildSlug(name);
        Map<Object, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("slug", slug);
        return data;
    }

    private static String buildSlug(String name) {
        return name.replaceAll(" ", "_");
    }

    public static Tag parseJSON(JSONObject object) {
        int id = object.getInt("id");
        String name = object.getString("name");
        return new Tag(id, name);
    }

    public static Tag parseJSON(String json) {
        JSONObject object = new JSONObject(json);
        return Tag.parseJSON(object);
    }

}
