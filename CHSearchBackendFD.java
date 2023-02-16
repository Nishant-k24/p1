import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class CHSearchBackendFD implements CHSearchBackendInterface {

    private HashtableWithDuplicateKeysInterface<String,PostInterface> hashtable;
    private PostReaderInterface postReader;

    // public CHSearchBackendFD(HashtableWithDuplicateKeysInterface<String,PostInterface> hashtable, PostReaderInterface postReader) {
    //     this.hashtable = hashtable;
    //     this.postReader = postReader;
    // }

    @Override
    public void loadData(String filename) throws FileNotFoundException {
        // TODO Auto-generated method stub
        if (filename == null ) {
            throw new FileNotFoundException();
        }
        System.out.println("Loading Data...");
    }

    @Override
    public List<String> findPostsByTitleWords(String words) {
        List<String> text = new ArrayList<String>();
        if (words.equals("apples")) {
            text.add("red");
            text.add("green");
            for (String word : text) {
                System.out.print(word + " ");
            }
        }
        return text;
    }

    @Override
    public List<String> findPostsByBodyWords(String words) {
        // TODO Auto-generated method stub
        List<String> text = new ArrayList<String>();
        if (words.equals("apples")) {
            text.add("red");
            text.add("green");
            for (String word : text) {
                System.out.print(word + " ");
            }
        }
        return text;
    }

    @Override
    public List<String> findPostsByTitleOrBodyWords(String words) {
        // TODO Auto-generated method stub
        List<String> text = new ArrayList<String>();
        if (words.equals("apples")) {
            text.add("red");
            text.add("green");
            for (String word : text) {
                System.out.print(word + " ");
            }
        }
        return text;
    }

    @Override
    public String getStatisticsString() {
        // TODO Auto-generated method stub
        return "Statistics";
    }







}