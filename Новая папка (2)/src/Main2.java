import java.util.Scanner;
import java.time.LocalDate;
import java.util.*;


public class Main2 extends EntityDocument {


    private static int id;

    public Main2(int id, String title, String author, LocalDate creationDate, LocalDate registrationDate, String status) {
        super(id, title, author, creationDate, registrationDate, status);
    }

    public Main2(int id, String title) {
        super(id, title);
    }

    private static String title;
    private static String author;
    private static String creationDate1;
    private static LocalDate creationDate;
    private static String registrationDate1;
    private static LocalDate registrationDate;
    private static String status;
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        List<String> listChoose = new ArrayList<>();
        listChoose.add("Добавить новый документ");
        listChoose.add("Посчитать количество документов по статусу Approve");

        System.out.println("Выбирите действия над документами:");

        int c = 0;
        {
            for (int i = 0; i < listChoose.size(); i++) {
                 System.out.println(String.format(i+1+" "+listChoose.get(i)));
             }

            c = in.nextInt();
           switch (c) {
               case 1:
                   System.out.println("Введите следующие значение в перечисленном порядке: id,title,author,creationDate,registrationDate, status");
                   id = in.nextInt();
                   title = in.nextLine();
                   author = in.nextLine();
                   status = in.nextLine();
                   creationDate1 = in.nextLine();

                   registrationDate1 = in.nextLine();

                   StreamDataAtFile streamDataAtFile = new StreamDataAtFile(id,title,author,registrationDate1,creationDate1, status);

                   streamDataAtFile.saveConfig();
                   break;
               case 2:
                   StreamDataFromFile streamDataFromFile = new StreamDataFromFile();

                   int count = 0;
                   streamDataFromFile.fileread(count);
                   System.out.println(streamDataFromFile.fileread(count));

                   //OperationDocs operationDocs = new OperationDocs(id,title,author,creationDate,registrationDate,status);
                   //operationDocs.CountDocsbySA(operationDocs.getId(), operationDocs.getStatus());
                   break;


           }
        }while ( c != 0);


    }
}
