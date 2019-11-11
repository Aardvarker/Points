package com.company;



import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.lang.Integer;
import com.company.IdTracker;
import com.company.Transaction;
import com.company.Customer;
import com.sun.org.apache.xpath.internal.objects.XBoolean;


public class Main {

    public static void main(String[] args) throws IOException {

        IdTracker id = new IdTracker();
        List<Transaction> allTransactions = new ArrayList<>();

        List<Customer> allCustomers = new ArrayList<>();
        File file = new File("/home/vark/Points/src/com/company/record.csv");
        List<List<String>> records = new ArrayList<>();
   //     Map idMap = new HashMap();

        //LOAD RECORD FROM RECORD.CSV
        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/vark/Points/src/com/company/record.csv"));
            String row;
            while ((row = br.readLine()) != null) {
                String[] values = row.split(",");
                records.add(Arrays.asList(values));

            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        int currentID = 0;
        Customer currentCustomer = new Customer();
     //   List<Transaction> thisCustomerTransactions= new ArrayList<>();
        for(int i = 0;i<records.size();i++){
            double myTotal = Double.parseDouble(records.get(i).get(0));
            LocalDate myDate = LocalDate.parse(records.get(i).get(1));
            int myId = id.makeNewID();
            int thisId;
            thisId = Integer.parseInt(records.get(i).get(2));


            Transaction t = new Transaction(myTotal,myDate,myId,thisId);
            //System.out.println("CREATED TRANSACTION"+t.tTotal+"=Total      "+t.tPoints+"= Points");
            allTransactions.add(t);
     //       idMap.put(myId,thisId);
         //   thisCustomerTransactions.add(t);

            if(thisId != currentID){
                currentID = thisId;
                currentCustomer = new Customer(currentID);

                allCustomers.add(currentCustomer);

                //System.out.println("CREATED CUSTOMER");
            }
            currentCustomer.addTransaction(t);
            //System.out.println(" ");

        }
        for(Customer cust : allCustomers) {


            showMonthly(cust);
        }

    }

    public static void showMonthly(Customer C){

        System.out.println("******** CUSTOMER #"+C.cID+" ******** Total pts: "+C.getTotalPoints()+" ********");
        List<Transaction> transList = new ArrayList<>();
        transList = C.getTransactions();
        Collections.sort(transList);
        int monthHolder = 0;

        for(Transaction transaction:transList){

            if(monthHolder != transaction.getDate().getMonthValue()){
                monthHolder = transaction.getDate().getMonthValue();



                System.out.println(transaction.getDate().getMonth());
            }
            System.out.println("-----"+transaction.gettPoints()+" pts");
        }


    }




    }



