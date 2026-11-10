import java.net.InetAddress;
import java.net.UnknownHostException;


public class ResultorNombre {
    public static void main(String[] args) {
        try {
            InetAddress web = InetAddress.getByName("www.xunta.gal");
            System.out.println(web.getHostName() + " -> " + web.getHostAddress());

            for (InetAddress ip : InetAddress.getAllByName("google.com")) {
                System.out.println("  " + ip.getHostAddress()); // IPv4 e IPv6
            }

            InetAddress yo = InetAddress.getLocalHost();
            System.out.println("Mi equipo: " + yo.getHostName());
        } catch (UnknownHostException e) {
            System.err.println("No se pudo resolver: " + e.getMessage());
        }
    }
}
}
