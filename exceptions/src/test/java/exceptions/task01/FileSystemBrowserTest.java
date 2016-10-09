package exceptions.task01;

import org.junit.Test;

public class FileSystemBrowserTest {
    @Test
    public void cd() throws Exception {
    }

    @Test
    public void ls() throws Exception {
        FileSystemBrowser fsBrowser = new FileSystemBrowser();

        fsBrowser.cd("home");
        fsBrowser.ls();
        fsBrowser.cd("../");
        fsBrowser.cd("etc");
        fsBrowser.ls();
    }

}