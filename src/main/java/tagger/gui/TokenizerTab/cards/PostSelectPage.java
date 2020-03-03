package tagger.gui.TokenizerTab.cards;

import tagger.gui.Page.components.ControlBar;
import tagger.gui.TokenizerTab.TokenizeMediator;
import tagger.gui.components.PostList.JListPost;
import tagger.http.posts.Post;
import tagger.http.posts.ServerPosts;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class PostSelectPage extends CardTemplate {

    private JListPost list;

    public PostSelectPage() {
        super();
        this.list = new JListPost();
        this.add(new JScrollPane(this.list), BorderLayout.CENTER);
    }

    public void setPosts(ServerPosts posts) {
        this.list.addPosts(posts);
    }

    public Post getSelected() {
        return this.list.getSelectedValue();
    }


    @Override
    public String getName() {
        return "Upload Page";
    }

    @Override
    protected void onFocusChange() {
        //this.setTokens( Tagger.getInstance().getTokens() );
    }

    protected ControlBar buildControlBar() {
        ControlBar controlBar = super.buildControlBar();
        JLabel label = new JLabel("Select an episode");
        controlBar.add(label, BorderLayout.WEST);
        JButton button = new JButton("Upload Tags");
        TokenizeMediator.getInstance().setUploadButton(button);
        controlBar.add(button, BorderLayout.EAST);
        return controlBar;
    }


}
