package tagger.gui.TokenizerTab.Actions;

import tagger.gui.components.Dialog.AppDialog;
import tagger.gui.workers.TagUploadJob;
import tagger.http.TagUpdater;
import tagger.http.posts.Post;
import tagger.token.TokenList;
import tagger.words.Words;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TagUploadAction extends TokenizeAction {

    protected TagUpdater tagUpdater = TagUpdater.getInstance();

    @Override
    public void actionPerformed(ActionEvent e) {
        TokenList tokens = this.mediator.getTagPage().getTokens();
        Words tags = TokenList.toWords( tokens );
        Post post = this.mediator.getPostSelectPage().getSelected();
        if ( post == null) {
            this.postNotSelected();
        } else if ( tags.size() < 1 ) {
            this.noTagsSelected();
        } else {
            this.uploadTags(post, tags);
        }
    }

    protected void uploadTags(Post post, Words tags) {
        SwingWorker<Void, String> worker = new TagUploadJob(post, tags);
        worker.execute();
    }

    protected void postNotSelected() {
        JDialog dialog = new AppDialog("Warning!", "You must select a post!");
        dialog.setVisible(true);
    }

    protected void noTagsSelected() {
        JDialog dialog = new AppDialog("Warning!", "No tags selected!");
        dialog.setVisible(true);
    }

}
