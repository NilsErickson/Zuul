/**
 * Created new Java class to integrate with newer IDE
 * Added new lines under "Help" Command to further explain newer commands
 * author: Nils Erickson
 * version: 05.02.2017
 */

package pcc.edu.zuul;

public class CommandWords {
    private static final String[] validCommands = new String[]{"go", "quit", "help", "look", "meditate"};

    public CommandWords() {
    }

    public boolean isCommand(String aString) {
        for(int i = 0; i < validCommands.length; ++i) {
            if(validCommands[i].equals(aString)) {
                return true;
            }
        }

        return false;
    }

    public String getCommandList() {
        String c = "";
        String[] var2 = validCommands;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String command = var2[var4];
            c = c + command + ' ';
        }

        return c;
    }
}