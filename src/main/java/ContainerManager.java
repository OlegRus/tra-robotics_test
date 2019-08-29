import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ContainerManager {

    private static final File containerRunner = new File(
            ClassLoader.getSystemClassLoader().getResource("container_runner.sh").getFile());

    public static void run() {
        execCommand("run");
    }

    public static void stop() {
        execCommand("stop");
    }

    public static void delete() {
        execCommand("delete");
    }

    public static void restart() {
        execCommand("restart");
    }

    private static void execCommand(String command) {
        ProcessBuilder procBuilder = new ProcessBuilder();
        procBuilder.command("bash", containerRunner.getAbsolutePath(), command);
        // System.out.println("Command: " + command);
        byte[] buff = new byte[2048];
        byte[] errBuff = new byte[2048];
        try {
            Process proc = procBuilder.start();
            proc.getInputStream().read(buff);
            proc.getErrorStream().read(errBuff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // System.out.println("Input stream:\n" + new String(buff));
        // System.out.println("Error stream:\n" + new String(errBuff));
    }

    public static boolean pingHost(String host, int port, int timeout) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), timeout);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
