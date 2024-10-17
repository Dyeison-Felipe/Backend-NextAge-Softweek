package com.softweek.softweek.domain.utils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Utils {

    public static Object atualizarObjetos(Class<?> classe, Map<String, Object> objModificado, Object objBanco) {
        objModificado.forEach((property, value) -> {
            Field field = ReflectionUtils.findField(classe, property);
            if (field != null) {
                field.setAccessible(true);

                if (!field.getType().isPrimitive() && !field.getType().getName().startsWith("java.lang")) {
                    return;
                }

                if (value != null) {
                    ReflectionUtils.setField(field, objBanco, value);
                }
            }
        });

        return objBanco;
    }

    public static String formataDataString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return sdf.format(date);
    }

}
