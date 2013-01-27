package idrabenia.webtest

import org.junit.Before
import org.junit.Test
import idrabenia.webtest.ui.HomeController

class HomeControllerTest {

    HomeController controller

    @Before
    void createController() {
        controller = new HomeController()
    }

    @Test
    void indexShouldReturnCorrectViewName() {
        assert controller.index() == "index"
    }
}
