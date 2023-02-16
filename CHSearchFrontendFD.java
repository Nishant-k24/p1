import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class CHSearchFrontendFD implements CHSearchFrontendInterface {
    
    private Scanner userInput;
    private CHSearchBackendInterface backend;

    public CHSearchFrontendFD(Scanner userInput, CHSearchBackendInterface backend) {
        this.userInput = userInput;
        this.backend = backend;
    }

    @Override
    public void runCommandLoop() {
        char choice;
        do {
            choice = mainMenuPrompt();
            

        } while (!(choice == 'Q'));
        System.out.println("You have Quit the Application");
    }

    /* (non-Javadoc)
     * @see CHSearchFrontendInterface#mainMenuPrompt()
     */
    @Override
    public char mainMenuPrompt() {

        System.out.println("[L]oad data Files\nSearch Post [T]itles\nSearch Post [B]odies\nSearch [P]ost titles and bodies\nDisplay [S]tatistic for dataset\n[Q]uit");

        String input = userInput.nextLine();
        if (input.equals("L")) {
            System.out.println("Load data Files");
            loadDataCommand();
            return  'L';
        } 
        else if (input.equals("T")) {
            System.out.println("Search Post Titles");
            searchTitleCommand(chooseSearchWordsPrompt());
            return  'T';
        }
        else if (input.equals("B")) {
            System.out.println("Search Post Bodies");
            searchBodyCommand(chooseSearchWordsPrompt());
            return  'B';
        }
        else if (input.equals("P")) {
            System.out.println("Search Post titles and bodies");
            searchPostCommand(chooseSearchWordsPrompt());
            return 'P';
        }
        else if (input.equals("S")) {
            System.out.println("Display Statistic for dataset"); 
            displayStatsCommand();
            return 'D';
        }
        else if (input.equals("Q")) {
            System.out.println("Quit");
            return 'Q';
        }
        else {
            System.out.println("\0");
            return '\0';
        }
    }

    @Override
    public void loadDataCommand()  {
        // TODO Auto-generated method stub
        try {
            System.out.println("Enter filename :");
            String filename = userInput.nextLine();
            backend.loadData(filename);
        } catch (Exception e) {
            System.out.println("invalid filename");
        }
        
    }

    @Override
    public List<String> chooseSearchWordsPrompt() {
        boolean choice = true;
        String input = "";
        ArrayList<String> words = new ArrayList<String>();
        while (choice) {
            System.out.println("Enter Search word/words:");
            input = userInput.next();
            System.out.println("Would you like to edit your response Y/N?");
            String bool = userInput.nextLine();
            if (bool.equals("Y")) {
                input = userInput.next();
            }
            else {
                choice = false;
            }
        }
        words.add(input);
        
        return words;
    }

    /* (non-Javadoc)
     * @see CHSearchFrontendInterface#searchTitleCommand(java.util.List)
     */
    @Override
    public void searchTitleCommand(List<String> words) {
        List<String> text = new ArrayList<String>();
        for( String word: words ) {
            text = backend.findPostsByTitleWords(word);
        }
        for (String word: text) {
            System.out.print(word + " ");
        }

    }

    @Override
    public void searchBodyCommand(List<String> words) {
        String word = words.get(0);
        List<String> test = backend.findPostsByBodyWords(word);
        for (String w : test) {
            System.out.println(w);
        }
    }

    @Override
    public void searchPostCommand(List<String> words) {
        String word = words.get(0);
        List<String> test = backend.findPostsByTitleOrBodyWords(word);
        for (String w : test) {
            System.out.println(w);
        }
    }

    @Override
    public void displayStatsCommand() {
        // TODO Auto-generated method stub
        String test = backend.getStatisticsString();
        System.out.println(test);
        
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        CHSearchBackendFD backend = new CHSearchBackendFD();
        CHSearchFrontendFD search = new CHSearchFrontendFD(userInput, backend);
        
        search.runCommandLoop();
    }



    


}
    

