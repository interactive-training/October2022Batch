package com.ita.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class demo {

    @Given("I have multiple rows of data in a single column")
    public void i_have_multiple_rows_of_data(DataTable dataTable) {

        String[] a = {"s", "b"};
        List<String> b = new ArrayList<String>();
        b.add("a");
        System.out.println(b);
        System.out.println(b.toArray());

//        System.out.println(dataTable.asList());
//        [email@email.com, email 2, email3, email4]

        List<String> data = dataTable.asList();

        //extract items one by one - hard coded the index
//        System.out.println("First item " + data.get(0));
//        System.out.println("Second item " + data.get(1));

        //if you do not know the number of items  //then loop is the only solution
        //loop 1
//        for (int x = 0; x <= data.size() - 1; x++){
//            System.out.println(data.get(x));
//        }

        //loop 2
//        for (String d: data){
//            System.out.println(d);
//        }

        //loop 3 (iterator)
        Iterator<String> s = data.iterator();
        while(s.hasNext()){
            System.out.println(s.next());

        }

    }

    @When("I have multiple rows of data with multiple columns")
    public void i_have_multiple_rows_of_data_with_multiple_columns(io.cucumber.datatable.DataTable dataTable) {

        //multiple columns
//        System.out.println(dataTable.asLists());
//        List<List<String>> data = dataTable.asLists();
//
//        //looping
//
//        for(int x=0; x<= data.size()-1; x++){
//            System.out.println("Row " + x + ":" +  data.get(x)); //row
//
//            System.out.println(" Col 1 :" + data.get(x).get(0));
//            System.out.println(" Col 2 :" + data.get(x).get(1));
//
//        }

    }

    @When("I have multiple rows of data with multiple columns and column header")
    public void i_have_multiple_rows_of_data_with_multiple_columns_and_column_header(io.cucumber.datatable.DataTable dataTable) {

//
////        System.out.println(dataTable.asMap());
////        {Email=Password, email@email.com=pass1, email 2=pass2, email3=pass3}
//
//        System.out.println(dataTable.asMaps());
////        [{Email=email@email.com, Password=pass1}, {Email=email 2, Password=pass2}, {Email=email3, Password=pass3}]
//
//        //store it and loop it
//        List<Map<String,String>> data = dataTable.asMaps();
//
//
//        for (Map<String,String> d : data){
//            System.out.println(d);
//
//            //access each field by its name
//            System.out.println(d.get("Email"));
//            System.out.println(d.get("Password"));
//        }

    }


    @When("I have multiple rows of data with multiple columns and column header with more than two columns")
    public void i_have_multiple_rows_of_data_with_multiple_columns_and_column_header_with_more_than_two_columns(io.cucumber.datatable.DataTable dataTable) {

//        System.out.println(dataTable.cells());
//        [[Email, Password, address], [email@email.com, pass1, addre1], [email 2, pass2, addr2], [email3, pass3, addr3]]

//        System.out.println(dataTable.asMap());
//        io.cucumber.datatable.CucumberDataTableException: Can't convert DataTable to Map<java.lang.String, java.lang.String>.
//        There is more then one value per key. Did you mean to transform to Map<java.lang.String, List<java.lang.String>> instead?

//        System.out.println(dataTable.asMaps());
//        [{Email=email@email.com, Password=pass1, address=addre1}, {Email=email 2, Password=pass2, address=addr2}, {Email=email3, Password=pass3, address=addr3}]

//        System.out.println(dataTable.asList());
//        io.cucumber.datatable.UndefinedDataTableTypeException: Can't convert DataTable to List<java.lang.String>.

//        System.out.println(dataTable.asLists());
//        [[Email, Password, address], [email@email.com, pass1, addre1], [email 2, pass2, addr2], [email3, pass3, addr3]]

    }

    @Then("my test case is passed")
    public void my_test_case_is_passed() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }


}
