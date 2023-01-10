package ru.someboy.naradareweb.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Slipets Artem
 */
public class SearchService {
    public static void main(String[] args) {
        String query1 = "дисплей";
        String query2 = "Samsung шлейф A32";
//        method(query1);
        System.out.println(Arrays.toString(method(query1)));
        System.out.println(sqlQueryGenerate(query1));
//        System.out.println(Arrays.toString(shufflingQuery(query)));
    }

    public static String[] method(String query) {
        List<String> listRu = new ArrayList<>();
        List<String> listEn = new ArrayList<>();
        for (String ar : query.split(" ")) {
            if (ar.matches("^([а-яА-Я])+")) {
                listRu.add(ar);
            } else {
                listEn.add(ar);
            }
        }
        return shufflingQuery(String.join(" ", listRu) + " " + String.join("%", listEn));
    }

    public static String sqlQueryGenerate(String searchText) {
        StringBuilder commaSeparatedVar = new StringBuilder();
        StringBuilder commaSeparatedQuestionMark = new StringBuilder();
        StringBuilder separatedByCommasILIKEOR = new StringBuilder();
        for (int i = 0; i < method(searchText).length; i++) {
            commaSeparatedVar.append("var").append(i).append(", ");
            commaSeparatedQuestionMark.append("?").append(", ");
            if (i == 0) {
                separatedByCommasILIKEOR.append("constants WHERE productName ILIKE var").append(i);
            } else {
                separatedByCommasILIKEOR.append(" OR productName ILIKE var").append(i);
            }
        }
        commaSeparatedVar.delete(commaSeparatedVar.length() - 2, commaSeparatedVar.length());
        commaSeparatedQuestionMark.delete(commaSeparatedQuestionMark.length() - 2, commaSeparatedQuestionMark.length());

        return String.format("WITH constants (%1$s) AS (VALUES (%2$s))\n" +
//                        "SELECT * FROM mobaproduct, %3$s\n" +
//                        "UNION ALL SELECT * FROM gizatmp, %3$s\n" +
//                        "UNION ALL SELECT * FROM libertiproduct, %3$s",
                "SELECT * FROM moba, %3$s\n" +
                        "UNION ALL SELECT * FROM giza, %3$s",
                commaSeparatedVar, commaSeparatedQuestionMark, separatedByCommasILIKEOR);
    }

    private static String[] shufflingQuery(String searchText) {
        String[] query = searchText.split(" ");
        List<String> resultQuery = new ArrayList<>();
        if(query.length < 2) {return query;}
        int sizeQuery = query.length;
        for (int i = 1; i <= factorial(sizeQuery) / (sizeQuery - 1); i++) {
            for (int j = 1; j < sizeQuery; j++) {
                shuffling(j, j + 1, query);
                resultQuery.add("%" + String.join("%", query) + "%");
            }
        }
        return resultQuery.toArray(new String[0]);
    }

    private static void shuffling(int x, int y, String[] array) {
        int size = array.length;
        String tmp = array[size - x];
        array[size - x] = array[size - y];
        array[size - y] = tmp;
    }

    private static long factorial(int number) {
        return number <= 2 ? number : number * factorial(number - 1);
    }
}
