package tagger.http;

import java.net.http.HttpResponse;

public class Response {

    private HttpResponse<String> response;

    public Response(HttpResponse<String> response) {
        this.response = response;
    }

    public String getBody() {
        return this.response.body();
    }

    public int getStatus() {
        return this.response.statusCode();
    }

}
