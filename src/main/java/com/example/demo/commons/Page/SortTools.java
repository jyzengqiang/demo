package com.example.demo.commons.Page;

import org.springframework.data.domain.Sort;

/**
 * @Author:曾强
 * @DATE 2017/12/1
 *
 */
public class SortTools {
    public static Sort basicSort() {
        return basicSort("desc", "id");
    }

    public static Sort basicSort(String orderType, String orderField) {
        Sort sort = new Sort(Sort.Direction.fromString(orderType), orderField);
        return sort;
    }

    public static Sort basicSort(SortDto... dtos) {
        Sort result = null;
//        if(dtos!=null){
            for(int i=0; i<dtos.length; i++) {
                SortDto dto = dtos[i];
                if(result == null) {
                    result = new Sort(Sort.Direction.fromString(dto.getOrderType()), dto.getOrderField());
                } else {
                    result = result.and(new Sort(Sort.Direction.fromString(dto.getOrderType()), dto.getOrderField()));
                }
            }
//        }
        return result;
    }
}
