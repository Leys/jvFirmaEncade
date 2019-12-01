/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class clsUsuario extends clsConexion {

    private int Id;
    private String Nombre;
    private String Usuario;
    private String Pas;
    private String Foto;
    private int Estatus;
    private Date Fecha;

    String uh;
    String link;
    String llave;
    String ultFirma;

    String resultado;

    public String getUh() {
        return uh;
    }

    public String getLink() {
        return link;
    }

    public String getResultado() {
        return resultado;
    }

    public String getLlave() {
        return llave;
    }

    public String getUltFirma() {
        return ultFirma;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPas() {
        return Pas;
    }

    public void setPas(String Pas) {
        this.Pas = Pas;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public int getEstatus() {
        return Estatus;
    }

    public void setEstatus(int Estatus) {
        this.Estatus = Estatus;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public clsUsuario() {
    }

    public clsUsuario(String us) {
        //obtener datos del usuario
    }

    public String registrarUsuI(String nombre, String contra, String usuario, String foto, String h, String firma) throws SQLException {
        String consultaSql;
        ResultSet rs;
        consultaSql = "call tspRegistrarUsuarioI('" + nombre + "','" + usuario + "','" + contra + "','" + foto + "','" + h + "','" + firma + "');";
        st = (Statement) cnn.createStatement();
        rs = st.executeQuery(consultaSql);
        String res = "";
        while (rs.next()) {
            res = rs.getString(1);
        }
        rs.close();
        return res;
    }

    public String getUltH() throws SQLException {
        String consultaSql;
        ResultSet rs;
        consultaSql = "call tspObtenerUltH(" + this.Id + ");";
        st = (Statement) cnn.createStatement();
        rs = st.executeQuery(consultaSql);
        String res = "";
        while (rs.next()) {
            res = rs.getString(1);
        }
        rs.close();
        return res;
    }

    public String firmar(String link, String firma, String llave, String h) throws SQLException {
        String consultaSql;
        ResultSet rs;
        consultaSql = "call tspFirmarNuevoMensaje(" + this.Id + ", '" + llave + "', '" + firma + "', '" + h + "', '" + link + "');";
        st = (Statement) cnn.createStatement();
        rs = st.executeQuery(consultaSql);
        String res = "";
        while (rs.next()) {
            res = rs.getString(1);
        }
        rs.close();
        return res;
    }

    public String getVFirma(int idFirma) throws SQLException {

        String consultaSql;
        ResultSet rs;
        consultaSql = "call tspVFirma(" + this.Id + ");";
        st = (Statement) cnn.createStatement();
        rs = st.executeQuery(consultaSql);
        String res = "";
        while (rs.next()) {
            res = rs.getString(1);
            if (!"0".equals(res)) {
                uh = rs.getString(1);
                ultFirma = rs.getString(2);
                link = rs.getString(3);
                llave = rs.getString(4);
            }
        }
        rs.close();
        return res;
    }

    public int buscarUsuario(String f) throws SQLException {
        int idFirma = 0;
        String consultaSql;
        ResultSet rs;
        consultaSql = "call tspBuscarUsuario('" + f + "');";
        st = (Statement) cnn.createStatement();
        rs = st.executeQuery(consultaSql);
        String res = "";
        while (rs.next()) {
            res = rs.getString(1);
            if (!"0".equals(res)) {
                this.Id = Integer.parseInt(rs.getString(2));
                this.Nombre = rs.getString(4);
                this.Usuario = rs.getString(3);
                idFirma = Integer.parseInt(rs.getString(1));
            }
        }
        rs.close();
        return idFirma;
    }

    public ResultSet listarUsuarios(String b) throws SQLException {
        ResultSet rs;
        String consultaSql = "call tspBusquedaUsuario('"+b+"')";
        st = (Statement) cnn.createStatement();
        rs = st.executeQuery(consultaSql);
        return rs;
    }

    public boolean verificar() throws SQLException {
        boolean res = true;
        List<String> f = new ArrayList<>();
        List<String> l = new ArrayList<>();
        List<String> h = new ArrayList<>();

        conexion();
        ResultSet rs;
        String consultaSQL = "call tspVerificar(" + this.Id + ")";
        st = (Statement) cnn.createStatement();
        rs = st.executeQuery(consultaSQL);
        while (rs.next()) {
            f.add(rs.getString(1)); //firma
            l.add(rs.getString(2)); //link
            h.add(rs.getString(3)); //h
        }
        rs.close();

        byte[][][] firmas = new byte[f.size()][16][16];
        for (int i = 0; i < f.size(); i++) {
            firmas[i] = arrStringToByte(f.get(i).split(","));
        }

        this.resultado = "Verificando\n";
        for (int i = 0; i < f.size(); i++) {
            clsFirma fir = new clsFirma();
            byte[][] esFirma = fir.verCadena(arrStringToByte(l.get(i).split(",")), arrStringToInt(h.get(i - 1).split(",")), arrStringToInt(h.get(i).split(",")));

            for (int j = 0; j < esFirma.length; j++) {
                if (fir.toDouble(firmas[i][j]) == fir.toDouble(esFirma[i])) {
                    this.resultado += "Correcto\tCadena: " + i + "\tSeccion: " + j + "Resultado: " + fir.toDouble(esFirma[i])+"\n";
                } else {
                    this.resultado += "ERROR\tCadena: " + i + "\tSeccion: " + j + "Resultado: " + fir.toDouble(firmas[i][j]) + "," + fir.toDouble(esFirma[i])+"\n";
                    return false;
                }
            }

        }

        return res;
    }

    private byte[][] arrStringToByte(String[] org) {
        byte[][] res = new byte[16][16];
        for (int i = 0; i < org.length; i++) {
            res[i] = clsFirma.hextoByte(org[i]);
        }
        return res;
    }

    private int[] arrStringToInt(String[] org) {
        int[] res = new int[org.length];
        for (int i = 0; i < org.length; i++) {
            res[i] = Integer.parseInt(org[i]);
        }
        return res;
    }

}
