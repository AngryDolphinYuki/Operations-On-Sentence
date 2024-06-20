import java.io.*;
import java.util.Scanner;

public class Files {
    File file;
    public Files(){
        file = new File("sentence.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {}
        }
        clear();
        writeToSentenceTxt();
    }

    public void clear() {
        try {
            FileWriter writer = new FileWriter(this.file, false);
            writer.close();
        } catch (IOException e) {}

    }
    public void writeToSentenceTxt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the sentence here: ");
        String sentence = sc.nextLine();
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter buffer = new BufferedWriter(writer);

            if (file.length() == 0) buffer.write(sentence);
            else buffer.append("\n" + sentence);

            buffer.close();
            writer.close();
        } catch (IOException e) {}
    }

    public String readTheSentenceTxt() {
        String sentence = "";
        if (file.length() == 0) System.out.println("no");
        else {
            try {
                Scanner fileSC = new Scanner(file);
                while (fileSC.hasNextLine()){
                    if (sentence.isBlank()) sentence += fileSC.nextLine();
                    else sentence += "\n" + fileSC.nextLine();
                }
                fileSC.close();
            } catch (FileNotFoundException e) {}
        }
        return sentence;
    }

}
