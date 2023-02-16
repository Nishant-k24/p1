
import java.util.Scanner;

public class FrontendDeveloperTests {
    
    /**
     * checks if the laod data program works
     * @return
     */
    public static boolean test1() {
       TextUITester tester = new TextUITester("L\napple.txt\nQ\n"); 
       Scanner scnr = new Scanner(System.in);
        CHSearchFrontendFD fd = new CHSearchFrontendFD(scnr, new CHSearchBackendFD());
        fd.runCommandLoop();
        String output = tester.checkOutput();
        return output.contains("Loading Data...");
    }

    public static boolean test2() {
        TextUITester tester = new TextUITester("T\napples turtles\nN\nQ\n"); 
        Scanner scnr = new Scanner(System.in);
        CHSearchFrontendFD fd = new CHSearchFrontendFD(scnr, new CHSearchBackendFD());
        fd.runCommandLoop();
        String output = tester.checkOutput();
        
        return output.contains("red green ");
        
    }

    public static boolean test3() {
        TextUITester tester2 = new TextUITester("B\napples\nQ\n"); 
        Scanner scnr = new Scanner(System.in);
        CHSearchFrontendFD fd = new CHSearchFrontendFD(scnr, new CHSearchBackendFD());
        fd.runCommandLoop();
        String output = tester2.checkOutput();
        if (!output.contains("red green")) {
            return false;
        }
        return true;
    }

    public static boolean test4() {
        TextUITester tester2 = new TextUITester("P\napples\nQ\n"); 
        Scanner scnr = new Scanner(System.in);
        CHSearchFrontendFD fd = new CHSearchFrontendFD(scnr, new CHSearchBackendFD());
        fd.runCommandLoop();
        String output = tester2.checkOutput();
        if (!output.contains("red green")) {
            return false;
        }
        return true;
    }

    public static boolean test5() {
        TextUITester tester2 = new TextUITester("S\nQ\n"); 
        Scanner scnr = new Scanner(System.in);
        CHSearchFrontendFD fd = new CHSearchFrontendFD(scnr, new CHSearchBackendFD());
        fd.runCommandLoop();
        String output = tester2.checkOutput();
        if (!output.contains("Statistics")) {
            return false;
        }
        return true;
    }

    public static void main (String[] args) {
        TextUITester tester = new TextUITester("L\napple\n14");
        String output = tester.checkOutput();


        System.out.println(test1());
        System.out.println(test2());
        System.out.println(test3());
        System.out.println(test4());
        System.out.println(test5());
    }

}
