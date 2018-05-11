package com.lori.aspa.ui.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.lori.aspa.ui.models.UserDTO;
import com.lori.aspa.ui.services.UserService;

@SuppressWarnings("rawtypes")
@FacesConverter("userConverter")
public class UserConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && !"".equals(value.trim())) {
            try {
                int id = Integer.valueOf(value);
                return new UserService().findUserById(id);
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
            return String.valueOf(((UserDTO)value).getId());
        }
        return null;

    }
}
