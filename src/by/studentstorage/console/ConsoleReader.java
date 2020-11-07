package by.studentstorage.console;

import java.util.Scanner;

public class ConsoleReader {
    private Scanner scanner = new Scanner(System.in);

    public String readString(){
        return scanner.next();
    }

    public double readDouble(){
        return scanner.nextDouble();
    }

    public long readLong(){
        return scanner.nextLong();
    }

    public int readInt(){
        return scanner.nextInt();
    }

    public boolean hasInt() {
        if (scanner.hasNextInt()){
            return true;
        }
        return false;
    }
}
