/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.web.jsf;

import com.uniminuto.lchacon.estampate.ejb.admin.AdministracionSFBean;
import com.uniminuto.lchacon.estampate.ejb.usuario.ManejoSessionSFBean;
import com.uniminuto.lchacon.estampate.web.base.BaseJSFBean;
import com.unniminuto.lchacon.estampateem.modelo.SysFuncionario;
import com.unniminuto.lchacon.estampateem.modelo.SysMenuprin;
import com.unniminuto.lchacon.estampateem.modelo.SysModulos;
import com.unniminuto.lchacon.estampateem.modelo.SysSubmodulo;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.MethodExpressionActionListener;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.icefaces.ace.component.ajax.AjaxBehavior;
import org.icefaces.ace.component.menuitem.MenuItem;
import org.icefaces.ace.component.submenu.Submenu;
import org.icefaces.ace.model.DefaultMenuModel;
import org.icefaces.ace.model.MenuModel;

/**
 *
 * @author fercris
 */
@SessionScoped
@Named
public class PrincipalJSFBean extends BaseJSFBean implements Serializable {
  private SysFuncionario sysfuncionario = new SysFuncionario();

   private String clave;
    private ManejoSessionSFBean manejoSessionSFBean;

    private ManejoSessionSFBean lookupManejoSessionSFBeanBean() {
        try {
            Context c = new InitialContext();
            return (ManejoSessionSFBean) c.lookup("java:global/Estampate/ManejoSessionSFBean!com.uniminuto.lchacon.estampate.ejb.usuario.ManejoSessionSFBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    private AdministracionSFBean administracionSFBean;

    private AdministracionSFBean lookupAdministracionSFBean() {
        try {
            Context c = new InitialContext();
            return (AdministracionSFBean) c.lookup("java:global/Estampate/AdministracionSFBean!com.uniminuto.lchacon.estampate.ejb.admin.AdministracionSFBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    boolean renderNavegacion = false; //si la persona se logea con exito muestra el menu, de lo contrario no.
    private MenuModel menuModel;
    private String navegacion;
    private String beanAnt;
    private String beanDest;

    public void cargarMenuNav() {
        fc = FacesContext.getCurrentInstance();
        elc = fc.getELContext();
//        menuBar.setOrientation("Horizaontal");

        //Vertical --Opción para el menu en posición Vertical
        //menu 
        menuModel = new DefaultMenuModel();
        ExpressionFactory factory = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
        MethodExpression methodsexpression = factory.createMethodExpression(FacesContext.getCurrentInstance().getELContext(), "#{arincipalJSFBean.navMenu_ActionEvent}", null, new Class[]{ActionEvent.class});
        MethodExpressionActionListener actionListener = new MethodExpressionActionListener(methodsexpression);

        for (SysMenuprin menuapp : administracionSFBean.getLstMenuprinsxFrn(manejoSessionSFBean.getFrnlogeado().getFrnId())) {
//            Column column = new Column();
            //column.setStyleClass("estiloMenu");
            Submenu menuItemApp = new Submenu();

            //Agregar menu de aplicación a la barra de menu
            menuItemApp.setId("miMenu" + menuapp.getMenId());
            menuItemApp.setLabel(menuapp.getMenNombre());
            menuItemApp.setTransient(true);
            menuItemApp.setStyleClass("letraMenuSubMenu");
            menuItemApp.setStyle("font-style: normal;font-weight: 500; color: #000000 !important;text-decoration:none; z-index: 35; font-size: 12px");

            menuModel.addSubmenu(menuItemApp);
//            menuItemApp.getChildren().add(column);

            //Consultar la lista de modulos por menu
            menuapp.setSysModulosList(administracionSFBean.getLstModulosxMenu(menuapp.getMenId()));

            for (SysModulos modapp : menuapp.getSysModulosList()) {

                Submenu menuItemMod = new Submenu();
                menuItemMod.setId("miMod" + modapp.getProcId());
                menuItemMod.setLabel(modapp.getProcNombre());
                menuItemMod.setStyleClass("letraMenuSubMenu");
                menuItemMod.setStyle("font-style: normal;font-weight: normal; color: #000000 !important;text-decoration:none; z-index: 35; font-size: 11px;");
                //Consultar la lista de submódulos por modulo

                modapp.setSysSubmoduloList(administracionSFBean.getLstSubmodprocxModXFrn(manejoSessionSFBean.getFrnlogeado().getFrnId(), modapp.getProcId()));
                //        setAdmSubmodappList(mssfbl.getLstSubmodappXModXCpe(mssfbl.getColxempLog().getCpeId(),
                //      modapp.getModId()));
//                column.getChildren().add(menuItemMod);

                menuItemApp.getChildren().add(menuItemMod);
                //agregar el modulo al menu

                for (SysSubmodulo sysSubmodproc : modapp.getSysSubmoduloList()) {
                    MenuItem menuItemSubMod = new MenuItem();
                    menuItemSubMod.setId("miSubMod" + sysSubmodproc.getSubId());
                    menuItemSubMod.setValue(sysSubmodproc.getSubNombre());
                    menuItemSubMod.setStyle("font-style: normal;font-weight: bold;color: #000000;text-decoration: underline; z-index: 35; font-size: 11px;");
                    menuItemSubMod.setActionExpression(factory.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
                            "#{arincipalJSFBean.navMenu_Action}", null, new Class<?>[0]));
                    menuItemSubMod.addActionListener(actionListener);
                    menuItemSubMod.getAttributes().put("navegacion", sysSubmodproc.getSubReglanav());
                    menuItemSubMod.getAttributes().put("jsfbean", sysSubmodproc.getSubJsfbean());
                    //menuItemSubMod.set(false);
                    menuItemSubMod.setImmediate(true);
                    menuItemMod.getChildren().add(menuItemSubMod);
                    addAjaxBehaviorTo(menuItemSubMod);
                }
            }
        }
    }
    
     public void ingresar_ActionEvent(ActionEvent ae) {
        manejoSessionSFBean = lookupManejoSessionSFBeanBean();
        sysfuncionario.setFrnClave(hashPasswordSha512(clave));
        manejoSessionSFBean.validaringreso(sysfuncionario);
        sysfuncionario = manejoSessionSFBean.getFrnlogeado();
        if (sysfuncionario.getFrnId() != null) {
            renderNavegacion = true;
            navegacion = "ingresar";
            cargarMenuNav();
        

        } else {
            manejoSessionSFBean.remove();
            navegacion = "";
            renderNavegacion = false;
            FacesMessage message = new FacesMessage();
            message.setDetail("Usuario o clave incorrecto");
            message.setSummary("Error");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
          
        }

    }
     
      public String ingresar_Action() {
        return navegacion;
    }

    public void btnInicio_ActionEvent(ActionEvent ae) {
    }

    private void addAjaxBehaviorTo(MenuItem menuItem) {
        AjaxBehavior ajaxBehavior = new AjaxBehavior();
        ajaxBehavior.setExecute("@form");
        ajaxBehavior.setRender("@form");
        menuItem.addClientBehavior("activate", ajaxBehavior);
    }

    /**
     * ActionListener para la barra de menu principal
     *
     * @param ae
     */
    public void navMenu_ActionEvent(ActionEvent ae) {
        Map<String, Object> map = ae.getComponent().getAttributes();
        navegacion = (String) map.get("navegacion");
        System.out.println(navegacion);
        if (navegacion.equals("salir")) {
            renderNavegacion = false;
            // RequestContext context = RequestContext.getCurrentInstance();
            //context.execute("cerrarPagina();");
            //            cpjsfb.limpiarVariables();
            manejoSessionSFBean.
            remove();
            //apcsfbe.remove();
        } else {
            try {
                beanAnt = beanDest;
                beanDest = (String) map.get("jsfbean");
                elc = FacesContext.getCurrentInstance().getELContext();
                Object objDestJSFBean = elc.getELResolver().getValue(elc, null, beanDest);
                Class cls = objDestJSFBean.getClass();

                if (!beanAnt.isEmpty()) {
                    Object objAntJSFBean = elc.getELResolver().getValue(elc, null, beanAnt);
                    Class clsAnt = objAntJSFBean.getClass();
                    Method mthdLimpiarVar = clsAnt.getDeclaredMethod("limpiarVariables", new Class<?>[0]);
                    mthdLimpiarVar.invoke(objAntJSFBean, new Object[0]);
                }

                Method mthdInit = cls.getDeclaredMethod("init", new Class<?>[0]);
                mthdInit.invoke(objDestJSFBean, new Object[0]);

            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException |
                    NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(AdministracionJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String navMenu_Action() {
        System.out.println(navegacion);
        return navegacion;
    }
//<editor-fold defaultstate="collapsed" desc="Funciones base">

    @Override
    public void init() {
        manejoSessionSFBean = lookupManejoSessionSFBeanBean();
    }

    @Override
    public void limpiarVariables() {

    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {

    }

    @Override
    public boolean validarFormulario() {
        return true;
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Propiedades">

    public ManejoSessionSFBean getManejoSessionSFBean() {
        return manejoSessionSFBean;
    }

    public boolean isRenderNavegacion() {
        return renderNavegacion;
    }

    public void setRenderNavegacion(boolean renderNavegacion) {
        this.renderNavegacion = renderNavegacion;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    public String getNavegacion() {
        return navegacion;
    }

    public void setNavegacion(String navegacion) {
        this.navegacion = navegacion;
    }

    public String getBeanAnt() {
        return beanAnt;
    }

    public void setBeanAnt(String beanAnt) {
        this.beanAnt = beanAnt;
    }

    public String getBeanDest() {
        return beanDest;
    }

    public void setBeanDest(String beanDest) {
        this.beanDest = beanDest;
    }
     public SysFuncionario getSysfuncionario() {
        return sysfuncionario;
    }

    public void setSysfuncionario(SysFuncionario sysfuncionario) {
        this.sysfuncionario = sysfuncionario;
    }
//</editor-fold>

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
}
