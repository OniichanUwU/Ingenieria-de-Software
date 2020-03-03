package fes.ico;

import javax.swing.JOptionPane;

public class Camisa {

    public int montoOriginal = 0;
    public float montoFinal = 0;
    public int camisas = 0;
    public static final Integer[] listaPrecios = {190, 230, 310};
    public Integer[] listaCamisas = new Integer[3];

    //listaCamisas va a contener la cantidad de camisas, la posición en memoria será el ID-1
    public Camisa() {
    }

    public float getMontoOriginal() {
        return montoOriginal;
    }

    public float getMontoFinal() {
        return montoFinal;
    }

    public int getCamisas() {
        return camisas;
    }

    public int getListaCamisas(int camisaID) { //Devuelve la cantidad de camisas dependiendo la ID
        return listaCamisas[camisaID];
    }
    
    public int getListaPrecios(int ID){
        return listaPrecios[ID];
    }

    public void setMontoOriginal(int montoOriginal) {
        this.montoOriginal = montoOriginal;
    }

    public void setMontoFinal(float montoFinal) {
        this.montoFinal = montoFinal;
    }

    public void setCamisas(int camisas) {
        this.camisas = camisas;
    }

    public void setListaCamisas(int camisaID, int cantidad) { //Inicializa la cantidad de camisas dependiendo la ID
        listaCamisas[camisaID] = cantidad;
    }

    public void MontoOriginal() {
        for (int i = 0; i < listaCamisas.length; i++) {
            setMontoOriginal(montoOriginal + (getListaCamisas(i) * getListaPrecios(i)));
            setCamisas(camisas + getListaCamisas(i));
            //Podría hacer que cuente las camisas en otro método pero eso sería aumentar la complejidad algorítmiaca del algoritmo
            //y me quiero acostumbrar a buscar la menor complejidad algorítmica posible
        }
    }

    public void MontoFinal() {
        float descuento = Descuento(getCamisas());
        setMontoFinal((float) (getMontoOriginal() * (1 - descuento)));
    }

    public float Descuento(int camisas) {
        if (camisas > 2 && camisas < 6) {
            return (float) 0.05; //Decuento del 5%
        } else {
            if (camisas > 5) {
                return (float) 0.08; //Decuento del 8%
            } else {
                return 0; //Decuento del 0%
            }
        }
    }
}
