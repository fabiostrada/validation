package it.allitude.validation.business.helpers;

import java.util.List;

public class ListHelper {

    public static boolean isNotEmpty(List<?> array) {
        return array !=null && !array.isEmpty();
    }
}
