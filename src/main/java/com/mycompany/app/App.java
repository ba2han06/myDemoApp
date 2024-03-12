package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
	port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);
          int[] arr1 = new int[inputList.size()];
       	  for (int i = 0; i < inputList.size(); i++)
            arr1[i] = inputList.get(i);
		

          String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
          }
          System.out.println(inputList2);
          int[] arr2 = new int[inputList2.size()];
       	  for (int i = 0; i < inputList2.size(); i++)
            arr2[i] = inputList2.get(i);


          String input3 = req.queryParams("input3").replaceAll("\\s","");
          int input3AsInt = Integer.parseInt(input3);
	
          String input4 = req.queryParams("input4").replaceAll("\\s","");
          int input4AsInt = Integer.parseInt(input4);
	
          boolean result = App.search(arr1, arr2, input3AsInt, input4AsInt);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
        


    }

     static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
	return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }



     public static boolean search(int[] arr1, int [] arr2, int start, int end) { //between specified indexes, the method returns if the sum of arrays is equal
     if (arr1 == null || arr2 == null || start < 0 || end < start || end >= arr1.length || end >= arr2.length) {
            return false;
     }
     int sum1 = 0;
     int sum2 = 0;
     for(int i = 0; i <= end; i++) {
        sum1 += arr1[i];
	sum2 += arr2[i];
     }
     if (sum1 == sum2)
	return true;
     return false;        
     }
}
