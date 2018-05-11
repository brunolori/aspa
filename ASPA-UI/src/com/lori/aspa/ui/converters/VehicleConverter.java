package com.lori.aspa.ui.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.lori.aspa.ui.models.VehicleDTO;
import com.lori.aspa.ui.services.VehicleService;


@SuppressWarnings("rawtypes")
@FacesConverter("vehicleConverter")
public class VehicleConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && !"".equals(value.trim())) {
            try {
                int id = Integer.valueOf(value);
                return new VehicleService().findVehicleById(id);
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
            return String.valueOf(((VehicleDTO)value).getId());
        }
        return null;

    }
}