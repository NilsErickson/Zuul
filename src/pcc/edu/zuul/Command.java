/**
 * Created new Java class to integrate with newer IDE
 * Added new lines under "Help" Command to further explain newer commands
 * author: Nils Erickson
 * version: 05.02.2017
 */

package pcc.edu.zuul;

public class Command {
    private String commandWord;
    private String secondWord;

    public Command(String firstWord, String secondWord) {
        this.commandWord = firstWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord() {
        return this.commandWord;
    }

    public String getSecondWord() {
        return this.secondWord;
    }

    public boolean isUnknown() {
        return this.commandWord == null;
    }

    public boolean hasSecondWord() {
        return this.secondWord != null;
    }
}