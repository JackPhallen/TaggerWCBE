package tagger.gui.workers;

import tagger.gui.AppMediator;
import tagger.gui.components.Dialog.AppDialog;
import tagger.http.TagUpdater;
import tagger.http.WordPressData;
import tagger.http.posts.Post;
import tagger.words.Words;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class TagUploadJob extends SwingWorker<Void,String> {

    private WordPressData wordPressData = WordPressData.getInstance();
    private TagUpdater tagUpdater = TagUpdater.getInstance();

    public TagUploadJob(Post post, Words words) {
        this();
        this.tagUpdater.setPost(post);
        this.tagUpdater.setWords(words);
    }

    private TagUploadJob() {
        super();
    }


    @Override
    protected Void doInBackground() {
        AppMediator.getInstance().getApp().showLoading();
        try {
            publish("Initiating WordPress Connected...");
            this.wordPressData.setUrl("https://2rogues.com");
            publish("Creating tags...");
            this.tagUpdater.generateTags();
            publish("Loading tag IDs...");
            this.wordPressData.fetchTags();
            publish("Adding tags to post...");
            this.tagUpdater.POST();
            publish("Finishing up...");
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
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
        AppDialog dialog = new AppDialog("Success!" ,"Tags successfully added to post!");
        dialog.setVisible(true);
    }

    protected void updateStatus(String status) {
        AppMediator.getInstance().getApp().setLoadingText(status);
    }
}
