package com.lori.aspa.ui.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.lori.aspa.ui.models.PlaceDTO;
import com.lori.aspa.ui.services.PlaceService;

@SuppressWarnings("rawtypes")
@FacesConverter("placeConverter")
public class PlaceConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && !"".equals(value.trim())) {
            try {
                int id = Integer.valueOf(value);
                return new PlaceService().findPlaceById(id);
            }catch(NumberFormatException ne)
            {
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        if (value != null) {
            return String.valueOf(((PlaceDTO)value).getId());
        }
        return null;

    }
}