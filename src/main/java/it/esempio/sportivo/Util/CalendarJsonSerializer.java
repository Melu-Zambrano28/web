package it.esempio.sportivo.Util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarJsonSerializer implements JsonSerializer<GregorianCalendar>, JsonDeserializer<GregorianCalendar>{

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy -- hh:mm:ss aa");


    @Override
    public JsonElement serialize(GregorianCalendar gregorianCalendar, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(dateFormat.format(gregorianCalendar.getGregorianChange()));
    }

    @Override
    public GregorianCalendar deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
