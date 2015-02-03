package de.berlios.vch.parser;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OverviewPage extends WebPage implements IOverviewPage {

    private List<IWebPage> pages;

    @Override
    public List<IWebPage> getPages() {
        if (pages == null) {
            pages = Collections.synchronizedList(new LinkedList<IWebPage>());

        }
        return pages;
    }
}
