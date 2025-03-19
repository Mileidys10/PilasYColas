/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerpilas.colas;

/**
 *
 * @author HP
 */
class Nodo {
    private Object dato; // Cambiar a Object para aceptar cualquier tipo
    private Nodo siguiente;

    public Nodo(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

class Metodos {
    private Nodo frenteCola;
    private Nodo finalCola;
    private Nodo cima; // Para la pila

    public Metodos() {
        this.frenteCola = null;
        this.finalCola = null;
        this.cima = null;
    }

    // Métodos para la Pila
    public void apilar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    public void apilarPorPosicion(Object dato, int posicion) {
        Nodo nuevo = new Nodo(dato);
        if (posicion == 0) {
            nuevo.setSiguiente(cima);
            cima = nuevo;
            System.out.println("Elemento apilado en la posición 0: " + dato);
            return;
        }

        Nodo temp = cima;
        Nodo anterior = null;
        int index = 0;

        while (temp != null && index < posicion) {
            anterior = temp;
            temp = temp.getSiguiente();
            index++;
        }

        if (temp == null) {
            System.out.println("Posición fuera de rango. Elemento no apilado.");
            return;
        }

        anterior.setSiguiente(nuevo);
        nuevo.setSiguiente(temp);
        System.out.println("Elemento apilado en la posición " + posicion + ": " + dato);
    }

    public void apilarPorDato(Object dato, Object datoReferencia) {
        Nodo nuevo = new Nodo(dato);
        
        if (cima != null && cima.getDato().equals(datoReferencia)) {
            nuevo.setSiguiente(cima);
            cima = nuevo;
            System.out.println("Elemento apilado antes de " + datoReferencia + ": " + dato);
            return;
        }

        Nodo temp = cima;
        Nodo anterior = null;

        while (temp != null && !temp.getDato().equals(datoReferencia)) {
            anterior = temp;
            temp = temp.getSiguiente();
        }

        if (temp == null) {
            System.out.println("Elemento de referencia no encontrado. Elemento no apilado.");
            return;
        }

        if (anterior != null) {
            anterior.setSiguiente(nuevo);
            nuevo.setSiguiente(temp);
        }

        System.out.println("Elemento apilado antes de " + datoReferencia + ": " + dato);
    }

    public Nodo desapilar() {
        if (cima == null) {
            System.out.println("Pila vacía - No se puede desapilar");
            return null;
        }
        Nodo temporal = cima;
        cima = cima.getSiguiente();
        return temporal;
    }

    public void eliminarPorPosicionPila(int posicion) {
        if (cima == null) {
            System.out.println("Pila vacía - No se puede eliminar");
            return;
        }

        Nodo temp = cima;
        Nodo anterior = null;
        int index = 0;

        while (temp != null && index < posicion) {
            anterior = temp;
            temp = temp.getSiguiente();
            index++;
        }

        if (temp == null) {
            System.out.println("Posición fuera de rango");
            return;
        }

        if (anterior == null) {
            cima = cima.getSiguiente();
        } else {
            anterior.setSiguiente(temp.getSiguiente());
        }

        System.out.println("Elemento eliminado de la pila en posición: " + posicion);
    }

    public void eliminarPorDatoPila(Object dato) {
        if (cima == null) {
            System.out.println("Pila vacía - No se puede eliminar");
            return;
        }

        Nodo temp = cima;
        Nodo anterior = null;

        while (temp != null && !temp.getDato().equals(dato)) {
            anterior = temp;
            temp = temp.getSiguiente();
        }

        if (temp == null) {
            System.out.println("Elemento no encontrado en la pila");
            return;
        }

        if (anterior == null) {
            cima = cima.getSiguiente();
        } else {
            anterior.setSiguiente(temp.getSiguiente());
        }

        System.out.println("Elemento eliminado de la pila: " + dato);
    }

    public boolean vaciaPila() {
        return cima == null;
    }

    public void invertirPila() {
        if (cima == null) {
            System.out.println("La pila está vacía");
            return;
        }
        
        Metodos pilaInvertida = new Metodos();

        while (!vaciaPila()) {
            Nodo nodo = desapilar();
            pilaInvertida.apilar(nodo.getDato());
        }

        this.cima = pilaInvertida.cima;
        System.out.println("Pila invertida correctamente.");
    }

    public void mostrarPila() {
        if (cima == null) {
            System.out.println("La pila está vacía.");
            return;
        }

        Nodo temp = cima;
        System.out.println("Contenido de la pila:");
        while (temp != null) {
            System.out.println(temp.getDato());
            temp = temp.getSiguiente();
        }
    }

    // Métodos para la Cola
    public void encolar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (frenteCola == null && finalCola == null) {
            frenteCola = nuevo;
            finalCola = nuevo;
        } else {
            finalCola.setSiguiente(nuevo);
            finalCola = nuevo;
        }
    }

    public void encolarPorPosicion(Object dato, int posicion) {
        Nodo nuevo = new Nodo(dato);
        if (posicion == 0) {
            nuevo.setSiguiente(frenteCola);
            frenteCola = nuevo;
            if (finalCola == null) {
                finalCola = nuevo;
            }
            System.out.println("Elemento encolado en la posición 0: " + dato);
            return;
        }

        Nodo temp = frenteCola;
        Nodo anterior = null;
        int index = 0;

        while (temp != null && index < posicion) {
            anterior = temp;
            temp = temp.getSiguiente();
            index++;
        }

        if (temp == null) {
            System.out.println("Posición fuera de rango. Elemento no encolado.");
            return;
        }

        anterior.setSiguiente(nuevo);
        nuevo.setSiguiente(temp);
        if (temp == null) {
            finalCola = nuevo;
        }
        System.out.println("Elemento encolado en la posición " + posicion + ": " + dato);
    }

    public void encolarPorDato(Object dato, Object datoReferencia) {
        Nodo nuevo = new Nodo(dato);

        if (frenteCola != null && frenteCola.getDato().equals(datoReferencia)) {
            nuevo.setSiguiente(frenteCola);
            frenteCola = nuevo;

            if (finalCola == null) {
                finalCola = nuevo;
            }

            System.out.println("Elemento encolado antes del frente (dato " + datoReferencia + "): " + dato);
            return;
        }

        Nodo temp = frenteCola;
        Nodo anterior = null;

        while (temp != null && !temp.getDato().equals(datoReferencia)) {
            anterior = temp;
            temp = temp.getSiguiente();
        }

        if (temp == null) {
            System.out.println("Elemento de referencia no encontrado. Elemento no encolado.");
            return;
        }

        anterior.setSiguiente(nuevo);
        nuevo.setSiguiente(temp);

        System.out.println("Elemento encolado antes de " + datoReferencia + ": " + dato);
    }

    public Nodo desencolar() {
        if (frenteCola == null) {
            System.out.println("Cola vacía - No se puede desencolar");
            return null;
        }
        Nodo pilaAux = frenteCola;
        frenteCola = frenteCola.getSiguiente();
        return pilaAux;
    }

    public void eliminarPorPosicionCola(int posicion) {
        if (frenteCola == null) {
            System.out.println("Cola vacía - No se puede eliminar");
            return;
        }

        Nodo temp = frenteCola;
        Nodo anterior = null;
        int index = 0;

        while (temp != null && index < posicion) {
            anterior = temp;
            temp = temp.getSiguiente();
            index++;
        }

        if (temp == null) {
            System.out.println("Posición fuera de rango");
            return;
        }

        if (anterior == null) {
            frenteCola = frenteCola.getSiguiente();
        } else {
            anterior.setSiguiente(temp.getSiguiente());
        }

        System.out.println("Elemento eliminado de la cola en posición: " + posicion);
    }

    public void eliminarPorDatoCola(Object dato) {
        if (frenteCola == null) {
            System.out.println("Cola vacía - No se puede eliminar");
            return;
        }

        Nodo temp = frenteCola;
        Nodo anterior = null;

        while (temp != null && !temp.getDato().equals(dato)) {
            anterior = temp;
            temp = temp.getSiguiente();
        }

        if (temp == null) {
            System.out.println("Elemento no encontrado en la cola");
            return;
        }

        if (anterior == null) {
            frenteCola = frenteCola.getSiguiente();
        } else {
            anterior.setSiguiente(temp.getSiguiente());
        }

        if (temp == finalCola) {
            finalCola = anterior; // Actualizar el final si se eliminó el último elemento
        }

        System.out.println("Elemento eliminado de la cola: " + dato);
    }

    public boolean vaciaCola() {
        return frenteCola == null;
    }

   public void invertirCola() {
    if (frenteCola == null) {
        System.out.println("La cola está vacía, no se puede invertir.");
        return;
    }

    Metodos pilaAuxiliar = new Metodos();

    // Desencolar todos los elementos y apilarlos en la pila auxiliar
    while (frenteCola != null) {
        Nodo nodo = desencolar();  // Desencolamos el nodo actual
        pilaAuxiliar.apilar(nodo.getDato());  // Lo apilamos en la pila auxiliar
    }

    // Reestablecer la cola para evitar referencias incorrectas
    frenteCola = null;
    finalCola = null;

    // Sacar de la pila y volver a encolar
    while (!pilaAuxiliar.vaciaPila()) {
        Nodo nodo = pilaAuxiliar.desapilar();  // Desapilamos de la pila auxiliar
        encolar(nodo.getDato());  // Volvemos a encolar los elementos en el orden invertido
    }

    System.out.println("Cola invertida correctamente.");
}


    public void mostrarCola() {
        if (frenteCola == null) {
            System.out.println("La cola está vacía.");
            return;
        }

        Nodo temp = frenteCola;
        System.out.println("Contenido de la cola:");
        while (temp != null) {
            System.out.print("  " + temp.getDato() + "  ");
            temp = temp.getSiguiente();
        }
    }
}

