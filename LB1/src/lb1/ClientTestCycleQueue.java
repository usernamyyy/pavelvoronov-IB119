package lb1;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class ClientTestCycleQueue
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String command;
        String[] arguments;
        CycleQueue<String> queue = new CycleQueue<>(5);
        while (true)
        {
            System.out.println("--------------------");
            System.out.print("Input a command: ");
            command = input.nextLine();
            if (command.equals("q") || command.equals("exit")) break;
            if (command.equals("show"))
            {
                queue.print();
                continue;
            }
            if (command.equals("clear"))
            {
                queue.clear();
                continue;
            }

            arguments = command.split(" ",2);
            command = arguments[0];
            if (command.equals("-") || command.equals("pop"))
            {
                try
                {
                    System.out.println("Result: " + queue.pop());
                }
                catch (NoSuchElementException e)
                {
                    System.out.println("Queue is empty.");
                }
            }
            else if (command.equals("+") || command.equals("add"))
            {
                String item = null;
                try
                {
                    item = arguments[1];
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("Wrong argument");
                    continue;
                }
                if (item == null || item.equals(""))
                {
                    System.out.println("Wrong argument");
                    continue;
                }
                queue.push(item);
            }
            else
                {
                    System.out.println("*** Unknown command ***");
                }
        }
        input.close();
        System.out.println("Exit...");
    }
}
