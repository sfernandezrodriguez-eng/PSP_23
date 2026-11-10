import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ResolutorNombre {
    public static void main(String[] args) {
        // Información del equipo local al inicio
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("Mi equipo: " + local.getHostName() + " | IP: " + local.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("No se pudo obtener la IP local: " + e.getMessage());
        }

        Scanner sc = new Scanner(System.in);

        // Bucle de lectura de dominios
        while (true) {
            System.out.print("\nIntroduce un dominio (escribe 'salir' si quieres salir): ");
            String dominio = sc.nextLine().trim();

            if (dominio.equalsIgnoreCase("salir")) {
                break;
            }

            try {
                InetAddress[] direcciones = InetAddress.getAllByName(dominio);
                for (InetAddress ip : direcciones) {
                    // Identificación de versión según la longitud de los bytes de la IP (4 bytes = IPv4, 16 bytes = IPv6)
                    String tipo = (ip.getAddress().length == 4) ? "IPv4" : "IPv6";
                    System.out.println(" -> " + ip.getHostAddress() + " (" + tipo + ")");
                }
            } catch (UnknownHostException e) {
                System.err.println("No se pudo resolver el dominio: " + e.getMessage());
            }
        }

        sc.close();
        System.out.println("Fin de ejecucion");
    }
}