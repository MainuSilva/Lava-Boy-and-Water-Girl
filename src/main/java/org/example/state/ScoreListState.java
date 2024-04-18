package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.ScoreListController;
import org.example.model.score.ScoreList;
import org.example.viewer.View;
import org.example.viewer.menu.ScoreListView;

import java.io.IOException;

public class ScoreListState extends State<ScoreList>{

    public ScoreListState(ScoreList score) throws IOException, ClassNotFoundException { super(score);}

    @Override
    protected View<ScoreList> getViewer() { return new ScoreListView(getModel());}

    @Override
    protected Controller<ScoreList> getController() { return new ScoreListController(getModel());}
}

