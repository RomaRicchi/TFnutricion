/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package laboratorio.tfnutricionista;


import Modelo.Paciente;

import Persistencia.PacienteData;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Roma
 */
public class TFNutricionista {

    



    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        /*ComidaData comidaService = new ComidaData();
        DietaData dietaService = new DietaData();*/
        PacienteData pacienteService = new PacienteData();

        int opcion = 0;
        int idPaciente = 0; 

        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            /*System.out.println("1. Agregar comida");
            System.out.println("2. Buscar comida");
            System.out.println("3. Modificar comida");
            System.out.println("4. Listar todas las comidas");
            System.out.println("5. Agregar comida a dieta");
            System.out.println("6. Eliminar comida de dieta");
            System.out.println("7. Listar comidas de una dieta");*/
            System.out.println("8. Agregar paciente");
            System.out.println("9. Buscar paciente por DNI");
            System.out.println("10. Modificar paciente");
            System.out.println("11. Listar todos los pacientes");
            /*System.out.println("12. Listar pacientes con peso pendiente");
            System.out.println("13. Modificar peso actual");
            System.out.println("14. Buscar comidas por calorías");*/
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                /*case 1:
                    // Agregar comida
                    scanner.nextLine();
                    System.out.print("Ingrese nombre de la comida: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese detalle de la comida: ");
                    String detalle = scanner.nextLine();
                    System.out.print("Ingrese calorías de la comida: ");
                    int calorias = scanner.nextInt();
                    Comida nuevaComida = new Comida(nombre, detalle, calorias);
                    comidaService.agregarComida(nuevaComida);
                    break;

                case 2:
                    // Buscar comida
                    System.out.print("Ingrese el ID de la comida a buscar: ");
                    int idComida = scanner.nextInt();
                    Comida comida = comidaService.buscarComida(idComida);
                    if (comida != null) {
                        System.out.println("Comida encontrada: " + comida);
                    } else {
                        System.out.println("Comida no encontrada.");
                    }
                    break;

                case 3:
                    // Modificar comida
                    System.out.print("Ingrese el ID de la comida a modificar: ");
                    idComida = scanner.nextInt();
                    scanner.nextLine();  // Limpiar buffer
                    System.out.print("Ingrese el nuevo nombre de la comida: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el nuevo detalle de la comida: ");
                    detalle = scanner.nextLine();
                    System.out.print("Ingrese las nuevas calorías de la comida: ");
                    calorias = scanner.nextInt();
                    comidaService.modificarComida(idComida, nombre, detalle, calorias);
                    break;

                case 4:
                    // Listar todas las comidas
                    List<Comida> listaComidas = comidaService.listarComidas();
                    for (Comida c : listaComidas) {
                        System.out.println(c);
                    }
                    break;

                case 5:
                    // Agregar comida a dieta
                    System.out.print("Ingrese el ID de la dieta: ");
                    int idDieta = scanner.nextInt();
                    System.out.print("Ingrese el ID de la comida: ");
                    idComida = scanner.nextInt();
                    dietaService.agregarComidaADieta(idDieta, idComida);
                    break;

                case 6:
                    // Eliminar comida de dieta
                    System.out.print("Ingrese el ID de la dieta: ");
                    idDieta = scanner.nextInt();
                    System.out.print("Ingrese el ID de la comida: ");
                    idComida = scanner.nextInt();
                    dietaService.borrarComidaDeDieta(idDieta, idComida);
                    break;

                case 7:
                    // Listar comidas de una dieta
                    System.out.print("Ingrese el ID de la dieta: ");
                    idDieta = scanner.nextInt();
                    List<Comida> comidasDeDieta = dietaService.obtenerComidasDeDieta(idDieta);
                    for (Comida c : comidasDeDieta) {
                        System.out.println(c);
                    }
                    break;*/

                case 8:
                    // Agregar paciente
                    scanner.nextLine();
                    System.out.print("Ingrese nombre completo del paciente: ");
                    String nombrePaciente = scanner.nextLine();
                    System.out.print("Ingrese DNI del paciente: ");
                    int dniPaciente = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese domicilio del paciente: ");
                    String domicilioPaciente = scanner.nextLine();
                    System.out.print("Ingrese celular del paciente: ");
                    String celularPaciente = scanner.nextLine();
                    System.out.print("Ingrese estado del paciente: ");
                    Boolean estadoPaciente = scanner.nextBoolean();
                    Paciente nuevoPaciente = new Paciente( nombrePaciente, dniPaciente, domicilioPaciente, celularPaciente, estadoPaciente);
                    pacienteService.agregarPaciente(nuevoPaciente);
                    break;

                case 9:
                    // Buscar paciente por DNI
                    System.out.print("Ingrese el DNI del paciente a buscar: ");
                    dniPaciente = scanner.nextInt();
                    Paciente paciente = pacienteService.buscarPaciente(dniPaciente);
                    if (paciente != null) {
                        System.out.println("Paciente encontrado: " + paciente);
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 10:
                    // Modificar paciente
                    System.out.print("Ingrese el ID del paciente a modificar: ");
                    idPaciente = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre completo del paciente: ");
                    nombrePaciente = scanner.nextLine();
                    System.out.print("Ingrese el nuevo DNI del paciente: ");
                    dniPaciente = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el nuevo domicilio del paciente: ");
                    domicilioPaciente = scanner.nextLine();
                    System.out.print("Ingrese el nuevo celular del paciente: ");
                    celularPaciente = scanner.nextLine();
                    System.out.print("Ingrese estado del paciente: ");
                    estadoPaciente = scanner.nextBoolean();
                    pacienteService.modificarPaciente(idPaciente, nombrePaciente, dniPaciente, domicilioPaciente, celularPaciente, estadoPaciente);
                    break;

                case 11:
                    // Listar todos los pacientes
                    List<Paciente> listaPacientes = pacienteService.listarPacientes();
                    for (Paciente p : listaPacientes) {
                        System.out.println(p);
                    }
                    break;

                /*case 12:
                    // Listar pacientes con peso pendiente
                    List<Paciente> pacientesConPesoPendiente = pacienteService.listarPacientesConPesoPendiente();
                    for (Paciente p : pacientesConPesoPendiente) {
                        System.out.println(p);
                    }
                    break;
                    
                case 13:
                    try {
                        // Modificar peso actual
                        System.out.print("Ingrese el ID del paciente: ");
                        idPaciente = scanner.nextInt();
                        scanner.nextLine();  // Limpiar buffer
                        System.out.print("Ingrese el nuevo peso: ");
                        float peso_actual = scanner.nextFloat();

                        // Validación del peso
                        if (peso_actual <= 0 || peso_actual > 300) {
                            System.out.println("El peso debe ser mayor que 0 y menor o igual a 300.");
                            break;
                        }

                        // Llamar al servicio para actualizar el peso
                        dietaService.cargarPesoActual(idPaciente, peso_actual);

                    } catch (InputMismatchException e) {
                        System.out.println("Error: Entrada inválida. Por favor, ingrese valores numéricos.");
                        scanner.nextLine();  // Limpiar el buffer en caso de error
                    } catch (SQLException e) {
                        System.out.println("Error al modificar el peso: " + e.getMessage());
                    }
                    break;

                case 14:
                    // Buscar comidas por calorías
                    System.out.print("Ingrese el máximo de calorías: ");
                    int maxCalorias = scanner.nextInt();

                    // Llamar al método para buscar las comidas que tengan menos de las calorías especificadas
                    List<Comida> comidasMenoresEnCalorias = comidaService.buscarComidasPorCaloriasMenores(maxCalorias);

                    // Verificar si hay resultados
                    if (comidasMenoresEnCalorias.isEmpty()) {
                        System.out.println("No se encontraron comidas con menos de " + maxCalorias + " calorías.");
                    } else {
                        System.out.println("Comidas con menos de " + maxCalorias + " calorías:");
                        for (Comida c : comidasMenoresEnCalorias) {
                            System.out.println(c);  // Imprimir cada comida que cumple con la condición
                        }
                    }
                    break;*/

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }

        } while (opcion != 0);

        scanner.close();
    }
    

    
}
