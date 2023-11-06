package com.mycompany.cashcontroljava;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import com.mycompany.cashcontroljava.ArbolBinario;


public class CashControlJava {
    public static void InicioDeSesion(FileOutputStream fichero,Usuario antiguo){
        ArbolBinario arbol = new ArbolBinario();
        int opc=1;
        String nombre,nickname, correo, contra;
        opc = Integer.parseInt(JOptionPane.showInputDialog("""
                                            ||BIENVENIDO A CASHCONTROL||
                                            -------------------------------------------------
                                            1. Iniciar sesión
                                            2. Registrarse
                                            """));
        switch(opc){
            case 1:
                nombre = JOptionPane.showInputDialog("Nombre de usuario: ");
                Usuario encontrado = arbol.buscarUsuarioPorNickname(nombre);

                if (encontrado != null) {
                    contra = JOptionPane.showInputDialog("Contraseña: ");
                    if (encontrado.getNickname().equals(nombre) && encontrado.getClave().equals(contra)) {
                        JOptionPane.showMessageDialog(null, "Accediste correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Clave y/o usuario incorrectos");
                        System.exit(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                    System.exit(0);
                }
                break;

            case 2:
                nombre = JOptionPane.showInputDialog("Nombre Completo: ");
                nickname = JOptionPane.showInputDialog("Nombre de usuario:");
                Usuario resistente = arbol.buscarUsuarioPorNickname(nickname);

                if (resistente != null) {
                    JOptionPane.showMessageDialog(null, "Este usuario ya existe");
                } else {
                    correo = JOptionPane.showInputDialog("Correo electrónico: ");
                    contra = JOptionPane.showInputDialog("Contraseña: ");
                    Usuario nuevo = new Usuario(nombre, nickname, correo, contra);

                    try {
                        ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
                        tuberia.writeObject(nuevo);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            fichero.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                break;
            default: JOptionPane.showMessageDialog(null,"La opción digitada no es valida");
        }
    }
    
    public static void menuPrincipal(Usuario usuario){
        int opc = 1,cuotas,registroI=1,registroG=1;
        String categoria,medioPago,cobrador;
        Boolean TipoCiclo,ActivoPasivo;
        float valor;
        
        do{
            try{
            opc = Integer.parseInt(JOptionPane.showInputDialog("""
                                                1. Agregar un ingreso
                                                2. Agregar un Gasto
                                                3. Crear una meta de ahorro
                                                4. Lista de ingresos
                                                5. Lista de gatos
                                                6. Ingresar Dinero a la meta de ahorro
                                                7. Salir."""));
            }catch(InputMismatchException ex){
                    JOptionPane.showMessageDialog(null,"Ingrese los datos nuevamente de la forma solicitada.");
            }
       
            switch(opc){
                case 1: categoria = JOptionPane.showInputDialog("Digite el nombre o categoria que tendra el ingreso:");
                        valor = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor del ingreso"));
                        cuotas = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de cuotas por el que se hace el pago:"));
                        medioPago = JOptionPane.showInputDialog("Digite el medio de pago por el que recibe el dinero (NO BRINDE DETALLES ADICIONALES):");
                        opc = JOptionPane.showConfirmDialog(null, "Es un ingreso Regular? (Si/no)");
                        TipoCiclo = opc != 0;
                        opc = JOptionPane.showConfirmDialog(null, "Es un ingreso Activo? (Si/no)");
                        ActivoPasivo = opc != 0;
                        usuario.AñadirIngreso(categoria, medioPago, TipoCiclo, valor, cuotas, registroI, ActivoPasivo);
                        JOptionPane.showMessageDialog(null, "Ingreso Añadido correctamente");
                        registroI++;
                        break;

                case 2: categoria = JOptionPane.showInputDialog("Digite el nombre o categoria que tendra el gasto:");
                        valor = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor del gasto"));
                        cuotas = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de cuotas por el que se hace el pago:"));
                        medioPago = JOptionPane.showInputDialog("Digite el medio de pago por el que efectuas la transaccion:");
                        opc = JOptionPane.showConfirmDialog(null, "Es un gasto Regular? (Si/no)");
                        TipoCiclo = opc != 0;
                        cobrador = JOptionPane.showInputDialog("Digite el nombre de la entidad a la que se le paga:");
                        usuario.AñadirGasto(categoria, medioPago, TipoCiclo, valor, cuotas, registroG, cobrador);
                        JOptionPane.showMessageDialog(null, "Ingreso Añadido correctamente");
                        registroG++;
                        break;

                case 3: 
                        usuario.CrearMeta();
                        System.out.println("Meta creada, Buena suerte");
                        break;
                case 4: JOptionPane.showMessageDialog(null,usuario.LecturaIngresos());
                        break;
                case 5: JOptionPane.showMessageDialog(null,usuario.LecturaGastos());
                        break;
                case 6: valor = Integer.parseInt(JOptionPane.showInputDialog("Cuanto dinero insertara:"));
                        usuario.Ahorros.IngresarDinero(valor);
                        JOptionPane.showMessageDialog(null, "Dinero ingresado correctamente");
                case 7: JOptionPane.showMessageDialog(null, "Hasta luego crack.");
                        break;
                default: JOptionPane.showMessageDialog(null,"La opción digitada no es valida");
            }
            
        }while(opc != 7);
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArbolBinario arbol = new ArbolBinario();
        Usuario usuario1 = new Usuario("Juan", "juan123", "juan@gmail.com", "clave123");
        Usuario usuario2 = new Usuario("María", "maria456", "maria@gmail.com", "clave456");

        arbol.insertar(usuario1);
        arbol.insertar(usuario2);

        InicioDeSesion(null,usuario2);
}
}