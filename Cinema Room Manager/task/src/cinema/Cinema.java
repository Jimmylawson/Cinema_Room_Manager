package cinema;

import java.util.Scanner;

public class Cinema {
        static int staticRows = 0;
        static int staticsSeats =0;

        static int totalIncome = 0;
        private static Scanner in = new Scanner(System.in);
        public static void main(String[] args) {
                int ticketPrice = 0;
                int totalNumber = 0;
                int frontHalf = 10;
                int backHalf = 8;
                int rows = 0;
                int seats = 0;

                int numRows = 0,numSeats = 0;

                System.out.println("Enter the number of rows: ");
                numRows = in.nextInt();
                System.out.println("Enter the number of seats in each row:");
                numSeats = in.nextInt();


                String[][] arr = new String[numRows][numSeats];

                staticRows = numRows;
            staticsSeats = numSeats;

                boolean flag = true;

            System.out.println();
                while(flag) {
                        System.out.print("""
                                1. Show the seats
                                2. Buy a ticket
                                3. Statistics
                                0. Exit
                                """);

                        int numTicket =0;
                        int choice = in.nextInt();
                        switch (choice) {
                                case 1 -> showSeats(arr, numSeats);
                                case 2 -> buyTicket(arr, numSeats);
                                case 3-> statistics(arr);
                                case 0 -> flag = false;

                        }


                }
        }

       static  String[][] calcArr = new String[staticRows][staticsSeats];
        static void statistics(String[][] arr){


                System.out.println("\nNumber of purchased ticket: "+ ticketsBoughtNumber(arr));
                System.out.printf("Percentage: %.2f%%%n",percentage(arr));
                System.out.println("Current income: $"+ currentIncome(arr));
                System.out.println("Total income: $" + allSeatsCalc(arr));
                System.out.println();
        }

        static int calculateTicketPrice(int row){
                int frontHalf = 10;
                int backHalf = 8;

            //    int totalRows = calcArr.length;
             //   int totalSeats = calcArr[0].length;
                if(staticRows * staticsSeats <= 60 || row <= staticRows/2){
                        return frontHalf;

                }else{
                        return backHalf;
                }
        }
        static double percentage(String[][] arr){
                 int totalSeats = arr.length * arr[0].length;
                 int numTicket = ticketsBoughtNumber(arr);
                 return ((double)numTicket/totalSeats) * 100;
        }

        static int currentIncome(String[][] arr){
                int numTicket = ticketsBoughtNumber(arr);

                return numTicket * calculateTicketPrice(1);
        }

      static   int allSeatsCalc(String[][] arr){
            int totalSeats = arr.length * arr[0].length;
            return totalSeats * calculateTicketPrice(1);

        }

        static int ticketsBoughtNumber(String[][] arr){
//
                int numTicket = 0;

                for(String[] row : arr){
                        for(String seat : row){
                                if("B".equals(seat)){
                                        numTicket++;
                                }
                        }
                }

                return numTicket;
        }

        static void showSeats(String[][] arr,int numSeats){

                System.out.println("Cinema:");
                System.out.print("  ");
                for(int i = 1;i <= numSeats;i++){
                        System.out.print(i + " ");
                }

                for(int i = 0;i < arr.length; i++){
                        System.out.print("\n" + (i+1) + " ");
                        for(int j = 0;j < numSeats; j++){
                                if(arr[i][j] !=null && arr[i][j].equals("B")){
                                        System.out.print("B ");
                                }else{
                                        System.out.print("S ");
                                }
                        }
                }
                System.out.println();


        }

        static void buyTicket(String[][] arr,int numSeats){
                int rows = 0;
                int seats = 0;
                int ticketPrice = 0;
                int totalNumber = 0;
                int frontHalf = 10;
                int backHalf = 8;

                System.out.println();
                System.out.println("Enter a row number: ");
                rows = in.nextInt();
                System.out.println("Enter a seat number in that row:");
                seats = in.nextInt();

                if(rows < 1 || rows >arr.length || seats < 1 || seats > numSeats){
                        System.out.println("Wrong input\n");
                }
                if ("B".equals(arr[rows - 1][seats - 1])) {
                        System.out.println("That ticket has already been purchased!\n");
                        System.out.println("Enter a row number: ");
                        rows = in.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        seats = in.nextInt();
                        if(rows < 1 || rows >arr.length || seats < 1 || seats > numSeats){
                                System.out.println("\nWrong input");
                                System.out.println("\nEnter a row number: ");
                                rows = in.nextInt();
                                System.out.println("Enter a seat number in that row:");
                                seats = in.nextInt();
                        }
                }

                 ticketPrice = calculateTicketPrice(rows);
                System.out.println("\nTicket price: $" + ticketPrice);
                System.out.println();
                arr[rows -1][seats -1] = "B";
              //  totalIncome += ticketPrice;

        }
}