package MainLib;

import Services.AutorService;
import Services.EditorialService;
import Services.LibroService;
import jdk.nashorn.internal.ir.TryNode;

public class Menu {
    //minuto 37 video drive explicacion

    private final LibroService libroService = new LibroService();
    private final AutorService autorService = new AutorService();
    private final EditorialService editorialService = new EditorialService();

    public void ejecucion() {

//CREO AUTORES
        try {

            //FALTA PASAR PARÁMETROS
            autorService.crearAutor("GARCÍA MARQUEZ"); 
            autorService.crearAutor("JULIO CORTAZAR");
                    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
//        System.out.println("Esta es la lista de autores que se ha creado: ");
//        autorService.listarAutores().forEach(((a) -> {
//            System.out.println(a.toString());
//        }));

//CREO EDITORIALES
        try {
            //FALTA PASAR PARÁMETROS
            editorialService.crearEditorial("PAIDOS");
            editorialService.crearEditorial("TULUM");
                    
                    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
//        System.out.println("Esta es la lista de editoriales que se ha creado: ");
//        editorialService.listarEdiroriales().forEach(((a) -> {
//            System.out.println(a.toString());
//        }));

//FALTA PASAR PARÁMETROS
        System.out.println(editorialService.buscarPorNombre("PAIDOS").toString());
        System.out.println(editorialService.buscarPorNombre("TULUM"));

//CREO LIBROS
        try {
            //FALTA PASAR PARÁMETROS
            
            //LONG SIEMPRE SE TERMINA CON "L" AL FINAL DEL NUMERO. EJ: 12345678L
            //PARA EDITORIAL O AUTOR, QUE NECESITAN RECIBIR UN OBJETO, UTILIZAR FUNCIONES:
            // editorialService.buscarPorNombre o autorService.buscarPorNombre
            libroService.crearLibro(12345678L, "Rayuela", 1963, 10000, editorialService.buscarPorNombre("TULUM")
                    , autorService.buscarPorNombre("JULIO CORTÁZAR"));
            libroService.crearLibro(87654321L, "Amor en tiempos de cólera", 1985, 5000, editorialService.buscarPorNombre("PAIDOS")
                    ,autorService.buscarPorNombre("GARCIA MARQUEZ"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
//        System.out.println("Esta es la lista de editoriales que se ha creado: ");
//        autorService.listarAutores().forEach(((a) -> {
//            System.out.println(a.toString());
//        }));

//MODIFICO EDITORIAL
        try {
            editorialService.modificarNombre();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }

//DAR DE ALTA Y BAJA
        try {
            //ALTA
            editorialService.darAlta();
            
            //BAJA
            editorialService.darBaja();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
        }

//ELIMINAR LIBRO
        try {
            System.out.println("Vamos a eliminar el libro: " + libroService.buscarLibroPorISBN(12345678L).getTitulo());
            libroService.eliminarLibro(12345678L);
        } catch (Exception e) {
        }
    }
}
