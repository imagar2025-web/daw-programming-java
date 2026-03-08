
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Sistema {

    ArrayList<String> users, passw;
    Agenda contactosUsuario;
    String usuarioActivo;

    public Sistema() {
        users = new ArrayList<>();
        passw = new ArrayList<>();
        boolean salida = false;
        boolean cargaUsuarios = cargarUsuarios();
        do {
            if (cargaUsuarios) {
                System.out.println("Haga referencia a una opcion: \n1: Crear nuevo Usuario\n2: Iniciar sesion"
                        + "\n3: Salir");
                switch (new Scanner(System.in).nextInt()) {
                    case 1 -> {
                        crearUsuario();
                    }
                    case 2 -> {
                        if (!iniciarSesion()) {
                            salida = true;
                        } else {
                            //Abriremos el menu conforme a la agenda
                            do {
                                System.out.println("Seleccione una de las opciones de su agenda:\n1: Registrar Contacto\n2: Ver contactos\n3: Buscar contacto\n4: Eliminar contacto\n5: desloguearse");
                                switch (new Scanner(System.in).nextInt()) {
                                    case 1 -> {
                                        contactosUsuario.reistrarContacto();
                                    }
                                    case 2 -> {
                                        System.out.println("Contactos de " + usuarioActivo + ":\n" + contactosUsuario.toString());
                                    }
                                    case 3 -> {
                                        contactosUsuario.buscarContacto(contactosUsuario.encontrarUsuario());
                                    }
                                    case 4 -> {
                                        contactosUsuario.eliminarUsuario(contactosUsuario.encontrarUsuario());
                                    }
                                    case 5 -> {
                                        try {
                                            FileOutputStream fos = new FileOutputStream("Agendas\\agenda" + usuarioActivo + ".dat");
                                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                                            oos.writeObject(contactosUsuario);
                                            System.out.println("Deslogin completado del usuario " + usuarioActivo);
                                            usuarioActivo = null;
                                        } catch (IOException e) {
                                            System.out.println("No se pudieron realizar los cambios en la agenda de " + usuarioActivo + " " + e.getMessage());

                                        } catch (Exception e) {
                                            System.out.println("Ocurrio un error inesperado " + e.getMessage());
                                        }
                                    }
                                    default ->
                                        throw new AssertionError();
                                }
                            } while (usuarioActivo != null);
                        }
                    }
                    case 3 -> {
                        salida = true;
                    }
                    default -> {
                        System.out.println("No has introducido una opcion valida, fin del programa");
                    }
                }
            } else {
                crearUsuario();
                guardarUsuarios();
            }
        } while (!salida);
        //Aqui habra un metedo que nos cargue todos los usuarios nuevos o los cambios habidos en el sistema
        System.out.println(users.size());
        guardarUsuarios();

    }

    public boolean cargarUsuarios() {
        String info = "";
        File misUsuarios = new File("misUsuarios.txt");
        try {
            if (!misUsuarios.exists()) {
                misUsuarios.createNewFile();
            }
            FileReader fr = new FileReader(misUsuarios);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                info += linea;
                linea = br.readLine();
            }
            String[] axu = info.split(" ");
            if (axu.length == 1) {
                System.out.println("No hay usuarios en el sistema, cree un usuario para continuar");
                return false;
            } else {
                //Una vez comprobado que hay elementos en la base de datos afirmamos que mantiene la estuctura de usuario y password
                //Utilizaremos los numeros pares e impares para diferenciar entre nombre de usuario y password
                for (int i = 0; i < axu.length; i++) {
                    if (i % 2 == 0) {
                        users.add(axu[i]);
                    } else {
                        passw.add(axu[i]);
                    }
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Hubo un error con la base de usuarios");
            return false;
        }
        return true;
    }

    //Este metodo nos aplicara para tanto como inicar sesion como crear un usuario
    //si el metodo devuelve algo distinto de cero nos dira que hay un usuario que coincide
    //y con el numero que nos devuelva coincidira con su password del otro array list
    public int encontrarUsuario(String usuario) {
        for (int i = 0; i < users.size(); i++) {
            if (usuario.equalsIgnoreCase(users.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public void crearUsuario() {
        Scanner datos = new Scanner(System.in);

        System.out.println("Introduca de esta manera su nombre y password\nNombreUsuario PassWord");
        String[] nuevoUsuario = datos.nextLine().split(" ");
        if (nuevoUsuario.length != 2) {
            System.out.println("Has introducido mal el formato de: NombreUsuario PassWord");
        } else {
            if (encontrarUsuario(nuevoUsuario[0]) == -1) {
                users.add(nuevoUsuario[0]);
                passw.add(nuevoUsuario[1]);
                File agendaUsuario = new File("Agendas\\agenda" + nuevoUsuario[0] + ".dat");
                System.out.println("Se ha creado correctamente el usuario");
                try {
                    agendaUsuario.createNewFile();
                    FileOutputStream fos = new FileOutputStream(agendaUsuario);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(new Agenda(new ArrayList<>()));
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    System.out.println("Sucedido un erro al crear la agende de este nuevo usuario " + e.getMessage());
                }
            } else {
                System.out.println("Este usuario ya esta registrado en el sistema");
            }
        }
    }

    public boolean iniciarSesion() {
        int numIntentos, numIntUsuarios;
        String usuarioAnterior = "";
        numIntUsuarios = 0;
        numIntentos = 0;

        do {
            Scanner datos = new Scanner(System.in);
            System.out.println("Introduzca en este formato el nombre de usuarios y contraseña \nUser Password");
            String inicio = datos.nextLine();
            String[] axu = inicio.split(" ");
            if (axu.length == 2) {
                if (!usuarioAnterior.equalsIgnoreCase(axu[0])) {
                    usuarioAnterior = axu[0];
                    numIntUsuarios = 0;
                }
                int posicionUsuario = encontrarUsuario(axu[0]);
                if (posicionUsuario != -1 && axu[1].equals(passw.get(posicionUsuario))) {
                    usuarioActivo = axu[0];
                    System.out.println("Has iniciado sesion");
                    try {
                        FileInputStream ios = new FileInputStream("Agendas\\agenda" + usuarioAnterior + ".dat");
                        ObjectInputStream oos = new ObjectInputStream(ios);
                        contactosUsuario = (Agenda) (oos.readObject());
                        return true;
                    } catch (IOException e) {
                        System.out.println("Ocurrio un error con el acceso a la agenda " + e.getMessage());
                    } catch (ClassNotFoundException e) {
                        System.out.println("No se ha podido leer nada de la agenda " + e.getMessage());
                    }
                } else if (posicionUsuario == -1) {
                    numIntentos++;
                    System.out.println("Este usuario no existe, le quedan " + (3 - numIntentos) + " intentos");
                } else if (posicionUsuario != -1 && !axu[1].equals(passw.get(posicionUsuario))) {
                    numIntentos++;
                    numIntUsuarios++;
                    System.out.println("Password incorrecta te quedan " + (3 - numIntUsuarios) + " para iniciar sesion con este usuario\n"
                            + "Te quedan " + (3 - numIntentos) + " para  iniciar  una sesion");
                }

            } else {
                System.out.println("Has introducido mal el formato indicado");
            }
        } while (numIntentos < 3);
        if (numIntUsuarios == 3) {
            //Eliminamos el usuario que es el que recogimos para hhacer las   comprobaciones con el  ultimo usuario
            users.remove(encontrarUsuario(usuarioAnterior));
            passw.remove(encontrarUsuario(usuarioAnterior));
            File supriCuenta = new File("Agendas\\agenda" + usuarioAnterior + ".dat");
            if (supriCuenta.exists()) {
                supriCuenta.delete();
            }
        }
        return false;
    }

    public void guardarUsuarios() {
        String info = "";
        try {
            for (int i = 0; i < users.size(); i++) {
                info += users.get(i) + " ";
                if (i!=users.size()) {
                    info += passw.get(i) + " ";
                }else{
                    info += passw.get(i);
                }
            }
        } catch (IndexOutOfBoundsException e) {
        } catch (Exception e) {
        }
        try {
            FileWriter actualizacion = new FileWriter("misUsuarios.txt",false);
            BufferedWriter bw = new BufferedWriter(actualizacion);
            bw.write(info);
            bw.close();
            actualizacion.close();
        } catch (IOException e) {
            System.out.println("Hubo un error con el  acceso al  Fichero");
        }

    }
}
