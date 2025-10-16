package baseNoStates;

public abstract class DoorState {
    // Aquesta classe abstracta és la base dels estats de les portes, mitjançant la funció changeState i totes
    // les classes que hereten d'aquesta, es delega la tasca de la classe Door de canviar d'estat, evitant
    // condicionals llargs i reduint l'acoblament en cas de canvi.

    // Potser s'ha de posar closed i opened també com a atribut, per UnlockedShortly.
    public abstract DoorState changeState(String state);
}
