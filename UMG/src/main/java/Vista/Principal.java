/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Vista;

import Controlador.Cursos;
import Modelo.CursosDAO;
import Controlador.Jornada;
import Modelo.JornadaDAO;
import java.util.List;


/*
  Clase Principal
  
  Esta clase pertenece a la capa Vista del sistema y contiene
  el método principal (main) desde donde se ejecuta el programa.
  
  Su función es probar las diferentes operaciones CRUD del sistema,
  utilizando la clase Cursos y la clase CursosDAO que se encargan
  de interactuar con la base de datos.
  
  En este archivo se pueden probar las siguientes operaciones:
  - Insertar un curso
  - Buscar un curso
  - Actualizar un curso
  - Eliminar un curso
  - Mostrar todos los cursos
  
  @author Jorge Reyes
 */
public class Principal { // Declaración de la clase principal del programa

    public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
       //INSERT cursos
       Cursos cursos = new Cursos (4,"Estadistica","Activo"); 
       // Se crea un objeto de tipo Cursos con código 4, nombre "Estadistica" y estado "Activo"
       System.out.println(cursos.toString()); 
       // Se imprime en pantalla la información del objeto cursos utilizando el método toString()
       CursosDAO cursosdao = new CursosDAO(); 
       // Se crea un objeto de tipo CursosDAO que se encargará de realizar operaciones en la base de datos
       cursosdao.insert(cursos);
       // Se llama al método insert para guardar el curso creado en la base de datos
       
      
       //QUERY cursos
       Cursos cursos1= new Cursos(); 
       // Se crea un objeto vacío de la clase Cursos para realizar una consulta
       CursosDAO cursosdao1 = new CursosDAO(); 
       // Se crea un nuevo objeto DAO que permitirá ejecutar la consulta en la base de datos
       cursos1.setCurCodigo(1); 
       // Se establece el código del curso que se desea buscar en la base de datos
       cursos1=cursosdao1.query(cursos1); 
       // Se ejecuta el método query que busca el curso con código 1 y devuelve sus datos
       System.out.println(cursos1.toString());
       // Se muestra en pantalla la información del curso obtenido de la base de datos
         
         
       //UPDATE cursos
       Cursos cursos2 = new Cursos(3,"Progra III","Inactivo"); 
       // Se crea un objeto Cursos con los nuevos datos que se desean actualizar
       CursosDAO  cursosdao2 = new CursosDAO(); 
       // Se crea un objeto DAO para realizar la operación de actualización
       cursosdao2.update(cursos2);
       // Se ejecuta el método update para modificar los datos del curso en la base de datos
       System.out.println(cursos2.toString());
       // Se imprime en pantalla el objeto actualizado
       
       
       //DELETE cursos
       Cursos cursos3= new Cursos(2);
       // Se crea un objeto Cursos con el código del curso que se desea eliminar
       CursosDAO cursosdao3= new CursosDAO();
       // Se crea un objeto DAO que ejecutará la eliminación en la base de datos
       cursosdao3.delete(cursos3);
       // Se llama al método delete para eliminar el curso con código 2
       System.out.println(cursos3.toString());
       // Se imprime el objeto eliminado como confirmación
        
       //SELECT cursos
       Cursos cursos4 = new Cursos();
       // Se crea un objeto Cursos (aunque en este caso no se usa directamente)
       CursosDAO cursosdao4 = new CursosDAO();
       // Se crea un objeto DAO para realizar la consulta de todos los cursos
       List<Cursos> cursoss = cursosdao4.select();
       // Se ejecuta el método select que obtiene todos los cursos de la base de datos
       // y los guarda en una lista de tipo Cursos
       for (Cursos lista : cursoss) {
       // Se recorre la lista de cursos utilizando un ciclo for
       System.out.println(lista.toString());
       // Se imprime en pantalla la información de cada curso encontrado
       }
     
       //INSERT jornada
       Jornada jornada = new Jornada (7,"Noctura"); 
       // Se crea un objeto de tipo Cursos con código 4, nombre "Estadistica" y estado "Activo"
       System.out.println(jornada.toString()); 
       // Se imprime en pantalla la información del objeto cursos utilizando el método toString()
       JornadaDAO jornadadao = new JornadaDAO(); 
       // Se crea un objeto de tipo CursosDAO que se encargará de realizar operaciones en la base de datos
       jornadadao.insert(jornada);
       // Se llama al método insert para guardar el curso creado en la base de datos
       
       //QUERY Jornada
       Jornada jornada1= new Jornada(); 
       // Se crea un objeto vacío de la clase Cursos para realizar una consulta
       JornadaDAO jornadadao1 = new JornadaDAO(); 
       // Se crea un nuevo objeto DAO que permitirá ejecutar la consulta en la base de datos
       jornada1.setJorCodigo(7); 
       // Se establece el código del curso que se desea buscar en la base de datos
       jornada1=jornadadao1.query(jornada1); 
       // Se ejecuta el método query que busca el curso con código 1 y devuelve sus datos
       System.out.println(jornada1.toString());
       // Se muestra en pantalla la información del curso obtenido de la base de datos
       
       //UPDATE cursos
       Jornada jornada2= new Jornada(3,"Matutina"); 
       // Se crea un objeto Cursos con los nuevos datos que se desean actualizar
       JornadaDAO  jornadadao2 = new JornadaDAO(); 
       // Se crea un objeto DAO para realizar la operación de actualización
       jornadadao2.update(jornada2);
       // Se ejecuta el método update para modificar los datos del curso en la base de datos
       System.out.println(jornada2.toString());
       // Se imprime en pantalla el objeto actualizado
       
       //DELETE jornada
       Jornada jornada3= new Jornada(2);
       // Se crea un objeto Cursos con el código del curso que se desea eliminar
       JornadaDAO jornadadao3= new JornadaDAO();
       // Se crea un objeto DAO que ejecutará la eliminación en la base de datos
       jornadadao3.delete(jornada3);
       // Se llama al método delete para eliminar el curso con código 2
       System.out.println(jornada3.toString());
       // Se imprime el objeto eliminado como confirmación
       
       //SELECT Jornada
       Jornada jornada4 = new Jornada();
       // Se crea un objeto Cursos (aunque en este caso no se usa directamente)
       JornadaDAO jornadadao4 = new JornadaDAO();
       // Se crea un objeto DAO para realizar la consulta de todos los cursos
       List<Jornada> Jornadas = jornadadao4.select();
       // Se ejecuta el método select que obtiene todos los cursos de la base de datos
       // y los guarda en una lista de tipo Cursos
       for (Jornada lista : Jornadas) {
       // Se recorre la lista de cursos utilizando un ciclo for
       System.out.println(lista.toString());
       // Se imprime en pantalla la información de cada curso encontrado
     
       }
       
    }
}
