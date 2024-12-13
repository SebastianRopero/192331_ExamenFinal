package management;

import entities.Agente;
import utils.ConsoleUtils;

import java.util.ArrayList;

public class AgenteManager {
    private ArrayList<Agente> agentes;

    public AgenteManager() {
        this.agentes = new ArrayList<>();
    }

    public void registrarAgente() {
        int id = ConsoleUtils.leerEntero("Ingrese el ID del agente: ");
        ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

        String nombre = ConsoleUtils.leerTexto("Ingrese el nombre del agente: ");
        String habilidad = ConsoleUtils.leerTexto("Ingrese la habilidad especial del agente: ");

        Agente nuevoAgente = new Agente(id, nombre, habilidad);
        agentes.add(nuevoAgente);
        System.out.println("Agente registrado con éxito.");
    }

    public void mostrarAgentes() {
        if (agentes.isEmpty()) {
            System.out.println("No hay agentes registrados.");
            return;
        }
        System.out.println("=== Lista de Agentes ===");
        for (Agente agente : agentes) {
            System.out.println(agente);
        }
    }

    // Método para equipar un agente con un equipo
    public void equiparEquipo() {

        int id = ConsoleUtils.leerEntero("Ingrese el ID del agente para asignarle su equipo: ");
        ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

        Agente agente = buscarAgentePorId(id); // Buscar al agente por su ID

        if (agente == null) {
            System.out.println("Agente no encontrado.");
            return;
        }
        
        if (agente.tieneEquipo()) {
            System.out.println("Este agente ya tiene un equipo asignado. No puede recibir otro.");
            return;
        }

        String equipo = ConsoleUtils.leerTexto("Ingrese el equipo a asignar: ");
        agente.setEquipoActual(equipo); // Asignamos el equipo al agente
        System.out.println("Equipo asignado con éxito.");

    }

    // Método para buscar un agente por su ID
    private Agente buscarAgentePorId(int id) {
        for (Agente agente : agentes) {
            if (agente.getId() == id) {
                return agente; // Devuelve el agente si se encuentra
            }
        }
        return null; // Retorna null si no se encuentra un agente con ese ID
    }

    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú Agentes ===");
            System.out.println("1. Registrar Agente");
            System.out.println("2. Mostrar Agentes");
            System.out.println("3. Equipar Equipo");
            System.out.println("4. Salir");
            int opcion = ConsoleUtils.leerEntero("Seleccione una opción: ");
            ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

            switch (opcion) {
                case 1 -> registrarAgente();
                case 2 -> mostrarAgentes();
                case 3 -> equiparEquipo(); // Llamamos al método para equipar un agente
                case 4 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}
