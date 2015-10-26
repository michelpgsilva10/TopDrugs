/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import vo.FuncionarioVO;
import vo.PessoaVO;

/**
 *
 * @author miche
 */
@FacesConverter(value = "funcionarioConverter")
public class FuncionarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            FuncionarioDAO dao = new FuncionarioDAO(FabricaEntityManager.getEntityManager());
            return dao.getFuncionarioById(Integer.parseInt(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof FuncionarioVO) {
            FuncionarioVO func = (FuncionarioVO) value;
            return String.valueOf(func.getCodigoPessoa());
        }
        return "";
    }

}

