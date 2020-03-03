package tagger.gui;


import tagger.gui.Actions.FetchWebData;
import tagger.gui.Loading.LoadingPage;
import tagger.gui.Page.Page;
import tagger.gui.StopWordsTab.StopWordPage;
import tagger.gui.TokenizerTab.TokenizerPage;
import tagger.gui.components.TabPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entry point for GUI
 */
public class App extends JFrame {

    private TabPanel tabPanel;
    private LoadingPage loadingPage;

    public App() {
        super();
        AppMediator.getInstance().setApp(this);
        this.setTitle(Properties.TITLE);
        this.tabPanel = new TabPanel(buildPageList());
        this.loadingPage = new LoadingPage("Loading...");
        this.showTabPanel();
        this.setSize(Properties.WIDTH,Properties.HEIGHT);
        this.setVisible(true);
        this.initWebData();
    }

    public void setLoadingText(String text) {
        this.loadingPage.setText(text);
    }

    public void showLoading() {
        this.hideTabPanel();
        this.add( this.loadingPage,  BorderLayout.CENTER );
        this.revalidate();
        this.repaint();
    }

    public void hideLoading() {
        this.remove(this.loadingPage);
        this.showTabPanel();
        this.revalidate();
        this.repaint();
    }

    private void hideTabPanel() {
        this.remove(this.tabPanel);
    }

    private void showTabPanel() {
        this.add(this.tabPanel, BorderLayout.CENTER);
    }

    /**
     * Build list of pages for tab navigator
     * @return page list
     */
    private List<Page> buildPageList() {
        List<Page> list = new ArrayList<>();
        list.add( this.buildTokenPage() );
//        list.add( this.buildStopWordPage() );
        return list;
    }

    /**
     * Create instance of tokenizer page
     * @return TokenizerPage instance
     */
    private TokenizerPage buildTokenPage() {
        TokenizerPage page = new TokenizerPage();
        AppMediator.getInstance().setTokenizerPage(page);
        return page;
    }

    /**
     * Create instance of stop words page
     * @return StopWordPage instance
     */
    private StopWordPage buildStopWordPage() {
        StopWordPage page = new StopWordPage();
        AppMediator.getInstance().setStopWordPage(page);
        return page;
    }

    private void initWebData() {
        new FetchWebData().actionPerformed(null);
    }



}
