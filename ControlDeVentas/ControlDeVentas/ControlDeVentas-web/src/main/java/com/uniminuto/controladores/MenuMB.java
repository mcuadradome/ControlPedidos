/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.controladores;

import co.uniminuto.entidades.Menu;
import co.uniminuto.logica.GeneralEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Miguel
 */
@Named(value = "menuMB")
@SessionScoped
public class MenuMB implements Serializable {

    private List<Menu> listMenu;
    private MenuModel modelMenu;

    @EJB
    GeneralEJB general;

    public MenuMB() {

    }

    @PostConstruct
    public void init() {
        listMenu = general.getMenu();
        modelMenu = new DefaultMenuModel();
        this.setMenu();
    }

    public void setMenu() {
        for (Menu menu : listMenu) {
            if (menu.getEstado()) {

                if (menu.getTipo().trim().equals("S")) {
                    DefaultSubMenu firstSubmenu = DefaultSubMenu.builder().label(menu.getNombre()).build();

                    for (Menu menu1 : listMenu) {
                        Menu submenu = menu1.getSubMenu();
                        if (submenu != null) {
                            if (submenu.getCodigo() == menu.getCodigo()) {

                                DefaultMenuItem item = DefaultMenuItem.builder()
                                        .value(menu1.getNombre())
                                        .url(menu1.getUrl()).build();
                                firstSubmenu.getElements().add(item);
                            }
                        }
                    }
                    modelMenu.getElements().add(firstSubmenu);
                } else {
                    if (menu.getSubMenu() == null) {
                        DefaultMenuItem item;
                        if (menu.getUrl().equals("")) {
                            item = DefaultMenuItem.builder()
                                    .value(menu.getNombre()).build();
                        } else {
                            item = DefaultMenuItem.builder()
                                    .value(menu.getNombre())
                                    .url(menu.getUrl()).build();
                        }

                        modelMenu.getElements().add(item);
                    }

                }
            }
        }
    }

    public List<Menu> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<Menu> listMenu) {
        this.listMenu = listMenu;
    }

    public MenuModel getModelMenu() {
        return modelMenu;
    }

    public void setModelMenu(MenuModel modelMenu) {
        this.modelMenu = modelMenu;
    }

    public GeneralEJB getGeneral() {
        return general;
    }

    public void setGeneral(GeneralEJB general) {
        this.general = general;
    }

}
