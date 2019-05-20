
package com.controller;

import com.database.ListQuery;
import com.model.Autos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "main")
@SessionScoped
public class MainController implements Serializable {
    
    ListQuery query=new ListQuery();
    private List<Autos> list=new ArrayList<Autos>();
    
    public List<Autos> getList() {
        list = query.listAutos();
        return list;
    }

    public void setList(List<Autos> list) {
        this.list = list;
    }

}
