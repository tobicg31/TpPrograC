package view;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Utilidad de la capa de presentación para reproducir efectos de sonido
 * espaciales en segundo plano sin bloquear la interfaz gráfica.
 */
public class ReproductorSonido {
    private static boolean habilitado = true;

    public static boolean isHabilitado() {
        return habilitado;
    }

    public static void setHabilitado(boolean estado) {
        habilitado = estado;
    }

    public static void click() {
        reproducir("click.wav");
    }

    public static void saltoComun() {
        reproducir("salto.wav");
    }

    public static void warp() {
        reproducir("warp.wav");
    }

    public static void colision() {
        reproducir("colision.wav");
    }

    public static void victoria() {
        reproducir("victoria.wav");
    }

    public static void derrota() {
        reproducir("derrota.wav");
    }

    public static void reproducir(String nombreArchivo) {
        if (!habilitado) {
            return;
        }
        new Thread(() -> {
            try {
                InputStream is = ReproductorSonido.class.getResourceAsStream("/sonidos/" + nombreArchivo);
                if (is == null) {
                    is = ReproductorSonido.class.getClassLoader().getResourceAsStream("sonidos/" + nombreArchivo);
                }
                if (is != null) {
                    try (BufferedInputStream bis = new BufferedInputStream(is);
                         AudioInputStream audioIn = AudioSystem.getAudioInputStream(bis)) {
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioIn);
                        clip.start();
                    }
                }
            } catch (Exception e) {
                // Modo defensivo: no interrumpe el juego si no hay hardware de audio
            }
        }).start();
    }
}
