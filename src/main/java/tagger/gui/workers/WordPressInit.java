package tagger.gui.workers;

import tagger.gui.AppMediator;
import tagger.gui.TokenizerTab.TokenizeMediator;
import tagger.http.WordPressData;

import javax.swing.*;
import java.util.List;

public class WordPressInit extends SwingWorker<Void,String> {

    private WordPressData wordPressData = WordPressData.getInstance();

    public WordPressInit(String url) {
        this();
        wordPressData.setUrl(url);
    }

    public WordPressInit() {
        super();
    }


    @Override
    protected Void doInBackground() {
        AppMediator.getInstance().getApp().showLoading();
        try {
            publish("Initiating tokenizer...");
            this.wordPressData = WordPressData.getInstance();
            publish("Initiating WordPress Connected...");
            this.wordPressData.setUrl("https://2rogues.com");
            publish("Fetching WordPress tags...");
            this.wordPressData.fetchTags();
            publish("Fetching WordPress posts...");
            this.wordPressData.fetchPosts();
            publish("Finishing up...");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    @Override
    protected void process(List<String> messages) {
        String message = messages.get(messages.size() - 1);
        this.updateStatus(message);
    }

    @Override
    protected void done() {
        super.done();
        AppMediator.getInstance().getApp().hideLoading();
        TokenizeMediator.getInstance().getPostSelectPage().setPosts( this.wordPressData.getPosts() );
    }

    protected void updateStatus(String status) {
        AppMediator.getInstance().getApp().setLoadingText(status);
    }
}
