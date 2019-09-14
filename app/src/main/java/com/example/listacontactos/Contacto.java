package com.example.listacontactos;

import java.io.Serializable;

public class Contacto implements Serializable {
    public String usuario;
    public String email;
    public String twitter;
    public String tel;
    public String fecha;

    public Contacto(String usuario, String email, String twitter, String tel, String fecha) {
        this.usuario = usuario;
        this.email = email;
        this.twitter = twitter;
        this.tel = tel;
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getTel() {
        return tel;
    }

    public String getFecha() {
        return fecha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
