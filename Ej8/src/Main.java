import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
public class Main {

	public static void main(String[] args) throws IOException {
	
		Path relativePath = Paths.get("/proyecto/archivo.txt");
		Path path = Paths.get("C:/usuario/src/archivo.java");
		//lo de antes son paths a archivos que no existen
		
		Path pathPuente = Paths.get("C:/usuario/src/");
		Path puentePath=pathPuente.relativize(path);
		System.out.println(puentePath);
		
		Path directorioProyectos=Paths.get("C:/todosLosProyectos/");
		directorioProyectos.resolve(path); //se metera el archivo en path a directorioProyectos
		//si se puede saber mostrando una ruta relativa,mirar abajo
			Path esteCodigo=Paths.get(System.getProperty("java.class.path"));
		System.out.println(esteCodigo);
		
		//si iteramos, llegariamos a todos los elementos de la ruta
		//si podemos usar ".." en las rutas
		
		//si no sabemos el SO podemos usar user.home
	
		/*Diapositiva 11 abajo*/
		String rutaSiExiste = "C:/Users/Javier/Desktop";
		Path siExiste = Paths.get(rutaSiExiste);
		String rutaNoExiste = "/ruta/al/archivo/o/directorio";
		Path noExiste = Paths.get(rutaNoExiste);
		
		System.out.println("El home es "+System.getProperty("user.home"));
		if (Files.exists(siExiste)) {
		  System.out.println("La ruta " + siExiste + " existe.");
		} else {
		  System.out.println("La ruta " + siExiste + " no existe.");
		}
		if (Files.exists(noExiste)) {
			  System.out.println("La ruta " + noExiste + " existe.");
			} else {
			  System.out.println("La ruta " + noExiste + " no existe.");
			}
		String rutaSinPermisosS = "C:/Users/Javier/Desktop/prueba.txt";
		Path rutaSinPermisos=Paths.get(rutaSinPermisosS);
			System.out.println(Files.isReadable(rutaSinPermisos));
			System.out.println(Files.isWritable(rutaSinPermisos));
			System.out.println(Files.isExecutable(rutaSinPermisos));
		
	//copiar un archivo
				Path rutaDestino=Paths.get("C:/Users/Javier/Desktop/A/");
				//	Files.copy(rutaSinPermisos, rutaDestino.resolve(rutaSinPermisos.getFileName()));
		
	//copiar una carpeta vacia	
		Path carpetaACopiar=Paths.get("C:/Users/Javier/Desktop/acopiar");
		Path carpetaACopiarDestino=Paths.get("C:/Users/Javier/Desktop/A/");
		Files.createDirectories(carpetaACopiarDestino.resolve(carpetaACopiar.getFileName()));
	//copiar una carpeta con archivos
		Path carpetaConArchivosACopiar=Paths.get("C:/Users/Javier/Desktop/carpeta con archivos");
		Path carpetaConArchivosDestino=Paths.get("C:/Users/Javier/Desktop/carpeta destino/");
		/*  
		Files.walkFileTree(carpetaConArchivosACopiar, new SimpleFileVisitor<Path>() {
	            @Override
	            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
	                Path destino = carpetaConArchivosDestino.resolve(carpetaConArchivosACopiar.relativize(file));
	                Files.copy(file, destino, StandardCopyOption.REPLACE_EXISTING);
	                System.out.println("Archivo copiado: " + destino);
	                return FileVisitResult.CONTINUE;
	            }

	            @Override
	            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
	                Path destino = carpetaConArchivosDestino.resolve(carpetaConArchivosACopiar.relativize(dir));
	                Files.createDirectories(destino);
	                System.out.println("Directorio creado: " + destino);
	                return FileVisitResult.CONTINUE;
	            }
	        });*/
		
		//borrar carpeta vacia
		Path carpetaBorrar=Paths.get("C:/Users/Javier/Desktop/aa/");
		//Files.deleteIfExists(carpetaBorrar); 
		
		//borrar carpeta llena
		Path carpetaBorrarLlena=Paths.get("C:/Users/Javier/Desktop/aa/");
	deleteFolder(carpetaBorrarLlena);
        
	//mover un archivo
	Path moverArchivo=Paths.get("C:/Users/Javier/Desktop/prueba.txt");
	//Files.move(moverArchivo,carpetaACopiarDestino.resolve(moverArchivo.getFileName()));
	
	//mover una carpeta vacia o llena
	Path moverCarpeta=Paths.get("C:/Users/Javier/Desktop/mm");
	Path moverCarpetaDestino=Paths.get("C:/Users/Javier/Desktop/QWER");
	//Files.move(moverCarpeta,moverCarpetaDestino.resolve(moverCarpeta.getFileName()));
	
	Path verAtributos=Paths.get("C:/Users/Javier/Desktop/prueba.txt");
	/*BasicFileAttributes attrs = Files.readAttributes(verAtributos, BasicFileAttributes.class);

    System.out.println("Metadatos del archivo:");
    System.out.println("Nombre del archivo: " + verAtributos.getFileName());
    System.out.println("Tamaño del archivo: " + attrs.size() + " bytes");
    System.out.println("Es un directorio? " + attrs.isDirectory());
    System.out.println("Es un archivo regular? " + attrs.isRegularFile());
    System.out.println("Es un enlace simbólico? " + attrs.isSymbolicLink());
    System.out.println("Fecha de creación: " + attrs.creationTime());
    System.out.println("Fecha de última modificación: " + attrs.lastModifiedTime());
    System.out.println("Fecha de último acceso: " + attrs.lastAccessTime());
    
    System.out.println("Obtenido individualmente: "+Files.getAttribute(verAtributos,"size"));
   
   //Files.setAttribute(verAtributos,"isDirectory",true);
   
  // Files.setAttribute(verAtributos, "name", "AAA");
   Files.setAttribute(verAtributos, "dos:hidden", false);
   */
   
   Iterable<FileStore> raices = FileSystems.getDefault().getFileStores();
   int contador=0;
   for(FileStore raiz :raices) {
	   contador++;
   }
System.out.println("Tengo "+contador+" raices");

//quedan ejercicios

}
	
	
	
	  public static void deleteFolder(Path folder) throws IOException {
	        // Verifica si la ruta es un directorio
	        if (Files.isDirectory(folder)) {
	            // Borra todos los archivos y subdirectorios de la carpeta
	            try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder)) {
	                for (Path file : stream) {
	                    if (Files.isDirectory(file)) {
	                        // Borra subdirectorios recursivamente
	                        deleteFolder(file);
	                    } else {
	                        // Borra archivos dentro de la carpeta
	                        Files.delete(file);
	                    }
	                }
	            }
	            // Borra la carpeta vacía
	            Files.delete(folder);
	        }
	    }

}
