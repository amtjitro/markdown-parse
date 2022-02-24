import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile() throws IOException{
        assertEquals(List.of("https://something.com", "some-page.html"),
            MarkdownParse.getLinks(Files.readString(Path.of("test-file.md"))));
    }

    @Test
    public void testFile2() throws IOException{
        assertEquals(List.of(),
            MarkdownParse.getLinks(Files.readString(Path.of("test-file2.md"))));
    }

    @Test
    public void testFile3() throws IOException{
        assertEquals(List.of(),
            MarkdownParse.getLinks(Files.readString(Path.of("test-file3.md"))));
    }

    @Test
    public void testFile4() throws IOException{
        assertEquals(List.of(),
            MarkdownParse.getLinks(Files.readString(Path.of("test-file4.md"))));
    }

    @Test
    public void testFile5() throws IOException{
        assertEquals(List.of("https://google.com"), MarkdownParse.getLinks(Files.readString(Path.of("test-file5.md"))));
    }

    @Test
    public void testSnippet1() throws IOException{
        assertEquals(List.of("'google.com, google.com, ucsd.edu"),
            MarkdownParse.getLinks(Files.readString(Path.of("snippet1.md"))));
    }

    @Test
    public void testSnippet2() throws IOException{
        assertEquals(List.of("a.com, a.com(()), example.com"),
            MarkdownParse.getLinks(Files.readString(Path.of("snippet2.md"))));
    }

    @Test
    public void testSnippet3() throws IOException{
        assertEquals(List.of("https://www.twitter.com, https://ucsd-cse15l-w22.github.io/, https://cse.ucsd.edu/"),
            MarkdownParse.getLinks(Files.readString(Path.of("snippet3.md"))));
    }

}